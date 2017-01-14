package GUIScene;

import Controller.PostController;
import Validator.ValidatorException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by Andrei on 12/3/2016.
 */
public class UpdatePostController {
    @FXML
    private TextField idText;

    @FXML
    private TextField descriereText;

    @FXML
    private TextField tipText;

    @FXML
    private Button updateButton;

    @FXML
    private Button closeButton;

    public UpdatePostController() {

    }

    private PostController controller;
    private Stage stage;

    public void setController(PostController controller, Stage stage) {
        this.controller = controller;
        this.stage = stage;
    }

    public void updateButtonHandler() {
        if (!(controller.existsId(idText.getText()))) {
            ShowMessage.showErrorMessage("ID-ul este invalid!");
        }
        else {
            try {
                controller.change(idText.getText(), descriereText.getText(), tipText.getText());
            }
            catch (ValidatorException ex) {
                ShowMessage.showErrorMessage(ex.getMessage());
            }
        }
    }

    public void closeButtonHandler() {
        stage.close();
    }
}
