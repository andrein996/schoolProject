package GUIScene;

import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 * Created by Andrei on 11/28/2016.
 */
public class ShowMessage {
    static Stage dialogStage;

    static void showMessage(Alert.AlertType type, String header, String text){
        Alert message=new Alert(type);
        message.setHeaderText(header);
        message.setContentText(text);
        message.initOwner(dialogStage);
        message.showAndWait();
    }

    static void showErrorMessage(String text){
        Alert message=new Alert(Alert.AlertType.ERROR);
        message.initOwner(dialogStage);
        message.setTitle("Mesaj eroare");
        message.setContentText(text);
        message.showAndWait();
    }
}
