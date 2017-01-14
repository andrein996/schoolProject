package GUIScene;

import Controller.PostController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by Andrei on 12/3/2016.
 */
public class RemovePostController {
    @FXML
    private TextField idText;

    @FXML
    private Button removeButton;

    @FXML
    private Button closeButton;

    public RemovePostController() {}

    private PostController controller;
    private Stage stage;

    public void setController(PostController controller, Stage stage) {
        this.controller = controller;
        this.stage = stage;
    }

    public void removeButtonHandler() {
        controller.remove(idText.getText());
        if (!(controller.existsId(idText.getText()))) {
            ShowMessage.showErrorMessage("Nu exista id-ul!");
        }
    }

    public void closeButtonHandler() {
        stage.close();
    }
}
