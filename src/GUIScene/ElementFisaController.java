package GUIScene;

import Entities.ElementFisa;
import Interface.*;
import Repository.ElementFisaRepo;
import Utils.Observable;
import Utils.Observer;
import Validator.ValidatorException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Created by Andrei on 12/5/2016.
 */
public class ElementFisaController implements Observer<ElementFisa> {
    @FXML
    private TableView table;
    @FXML
    private TableColumn columnID;
    @FXML
    private TableColumn columnDescrierePost;
    @FXML
    private TableColumn columnDescriereSarcina;
    @FXML
    private TextField textId;
    @FXML
    private TextField textIdPost;
    @FXML
    private TextField textIdSarcina;
    @FXML
    private Button addButton;
    @FXML
    private Button removeButton;
    @FXML
    private Button updateButton;

    private Controller.ElementFisaController controller;
    private ObservableList<ElementFisa> model;

    public ElementFisaController() {}

    public void setController(Controller.ElementFisaController controller) {
        this.controller = controller;
        model = FXCollections.observableArrayList(controller.getAll()); /** TO ADD filterByIdPost() **/
        table.setItems(model);
    }

    @FXML
    public void initialize() {
        columnID.setCellValueFactory(new PropertyValueFactory<ElementFisa, String>("id"));
        columnDescrierePost.setCellValueFactory(new PropertyValueFactory<ElementFisa, String>("post"));
        columnDescriereSarcina.setCellValueFactory(new PropertyValueFactory<ElementFisa, String>("sarcina"));
        /** TO ADD: ProperyValueFactory descriereSarcina**/
        table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ElementFisa>() {
            @Override
            public void changed(ObservableValue<? extends ElementFisa> observable, ElementFisa oldValue, ElementFisa newValue) {
                if (newValue != null) {
                    textId.setText(String.valueOf(newValue.getId()));
                    textIdPost.setText(newValue.getPost().getDescriere());
                    textIdSarcina.setText(String.valueOf(newValue.getPost().getDescriere()));
                }
                else {
                    textId.setText("");
                    textIdPost.setText("");
                    textIdSarcina.setText("");
                }
            }
        });
    }

    @FXML
    public void addButtonHandler(){
        try {
            try {
                Integer x = Integer.parseInt(textId.getText());
                x = Integer.parseInt(textIdSarcina.getText());
            }
            catch (Exception e) {
                throw new ValidatorException("ID-ul trebuie sa fie un intreg!");
            }
            controller.addElementFisa(Integer.parseInt(textId.getText()),
                    textIdPost.getText(),
                    Integer.parseInt(textIdSarcina.getText()));
        }
        catch (ValidatorException ex) {
            ShowMessage.showErrorMessage(ex.getMessage());
        }
    }

    @FXML
    public void updateButtonHandler(){
        try {
            controller.changeElementFisa(Integer.parseInt(textId.getText()),
                    textIdPost.getText(),
                    Integer.parseInt(textIdSarcina.getText()));
        }
        catch (ValidatorException ex) {
            ShowMessage.showErrorMessage(ex.getMessage());
        }
    }

    @FXML
    public void removeButtonHandler(){
        controller.removeElementFisa(Integer.parseInt(textId.getText()));
    }

    @Override
    public void update(Observable<ElementFisa> e) {
        model.setAll(controller.getAll());
    }
}
