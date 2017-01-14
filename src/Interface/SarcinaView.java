package Interface;

import Entities.Sarcina;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * Created by Andrei on 11/27/2016.
 */
public class SarcinaView {
    private ObservableList<Sarcina> model;


    /** ----------------------------------INIT COMPONENTS---------------------------------- */
    private BorderPane background;

    private void initComponents(){
        background = new BorderPane();
        background.setLeft(createLeftPane());
        background.setCenter(createCenterPane());
        background.setBottom(createBottomPane());
    }

    /** ----------------------------------LEFT PANE---------------------------------- */
    private TableColumn<Sarcina, Integer> idColumn;
    private TableColumn<Sarcina, String> titleColumn;
    private TableView<Sarcina> sarcinaTable;

    private Pane createLeftPane(){
        sarcinaTable = new TableView<>();
        idColumn= new TableColumn<>("Id:");
        idColumn.setCellValueFactory(new PropertyValueFactory<Sarcina, Integer>("id"));
        titleColumn = new TableColumn<>("Descriere sarcina:");
        titleColumn.setCellValueFactory(new PropertyValueFactory<Sarcina, String>("descriereSarcina"));
        sarcinaTable.getColumns().add(idColumn);
        sarcinaTable.getColumns().add(titleColumn);

        sarcinaTable.setItems(model);
        return new HBox(sarcinaTable);
    }

    /** ----------------------------------CENTER PANE---------------------------------- */
    private Label idLabel;
    private Label descriereLabel;
    public TextField idText;
    public TextField descriereText;

    private Pane createCenterPane(){
        idLabel = new Label("ID: ");
        descriereLabel = new Label("Descriere sarcina: ");
        idText = new TextField();
        descriereText = new TextField();
        GridPane gridPane = new GridPane();
        gridPane.add(idLabel, 0, 0);
        gridPane.add(descriereLabel, 0, 1);
        gridPane.add(idText, 1, 0);
        gridPane.add(descriereText, 1, 1);
        return gridPane;
    }
    /** ----------------------------------BOTTOM PANE---------------------------------- */
    private Button saveB;
    private Button updateB;
    private Button deleteB;
    //private Button clearAllB;

    private Pane createBottomPane(){
        saveB = new Button("Save");
        saveB.setOnAction(sarcinaController.addButtonHandler());
        updateB = new Button("Update");
        updateB.setOnAction(sarcinaController.changeButtonHandler());
        deleteB = new Button("Delete");
        deleteB.setOnAction(sarcinaController.removeButtonHandler());
        //clearAllB = new Button("Clear all");
        return new HBox(saveB, updateB, deleteB);
    }

    /** ----------------------------------CONSTRUCTOR---------------------------------- */
    private SarcinaController sarcinaController;

    public BorderPane getView(){
        return background;
    }

    public SarcinaView(ObservableList<Sarcina> list, Controller.SarcinaController controller){
        this.model = list;
        sarcinaController = new SarcinaController(this, controller);
        initComponents();
    }

}
