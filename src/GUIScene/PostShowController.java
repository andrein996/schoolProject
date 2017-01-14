package GUIScene;

import Controller.PostController;
import Entities.Post;
import Utils.Observable;
import Utils.Observer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Andrei on 12/2/2016.
 */


public class PostShowController implements Observer<Post> {
    @FXML
    private TableView table;
    @FXML
    private TableColumn idColumn;
    @FXML
    private TableColumn descriereColumn;
    @FXML
    private TableColumn tipColumn;
    @FXML
    private Button addButton;
    @FXML
    private Button removeButton;
    @FXML
    private Button updateButton;

    private PostController controller;
    private ObservableList<Post> model;

    public PostShowController() {}

    public void setController(PostController controller) {
        this.controller = controller;
        model = FXCollections.observableArrayList(controller.getAllPosts());
        table.setItems(model);
    }

    @Override
    public void update(Observable<Post> e) {
        model.setAll(controller.getAllPosts());
    }

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<Post, String>("id"));
        descriereColumn.setCellValueFactory(new PropertyValueFactory<Post, String>("descriere"));
        tipColumn.setCellValueFactory(new PropertyValueFactory<Post, String>("tip"));
    }

    @FXML
    public void addButtonHandler() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(PostShowController.class.getResource("AddPostShow.fxml"));
        AnchorPane anchorPane = loader.load();
        AddPostController addPostController = loader.getController();
        addPostController.setController(controller, stage);
        Scene addScene = new Scene(anchorPane);
        stage.setScene(addScene);
        stage.setTitle("Adding posts");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }

    @FXML
    public void updateButtonHandler() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(PostShowController.class.getResource("UpdatePostShow.fxml"));
        AnchorPane anchorPane = loader.load();
        UpdatePostController updatePostController = loader.getController();
        updatePostController.setController(controller, stage);
        Scene addScene = new Scene(anchorPane);
        stage.setScene(addScene);
        stage.setTitle("Updating posts");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }

    @FXML
    public void removeButtonHandler() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(PostShowController.class.getResource("RemovePostShow.fxml"));
        AnchorPane anchorPane = loader.load();
        RemovePostController removePostController = loader.getController();
        removePostController.setController(controller, stage);
        Scene addScene = new Scene(anchorPane);
        stage.setScene(addScene);
        stage.setTitle("Removing posts");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }
}
