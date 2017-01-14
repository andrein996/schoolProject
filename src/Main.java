import Controller.ElementFisaController;
import Controller.PostController;
import Controller.SarcinaController;
import Entities.ElementFisa;
import Entities.SarcinaDataModel;
import GUIScene.PostShowController;
import Interface.SarcinaView;
import Repository.ElementFisaRepoSerializable;
import Repository.PostRepo;
import Repository.PostRepoSerializable;
import Repository.SarcinaRepoFile;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        PostRepoSerializable repo = new PostRepoSerializable("src/post.txt");
        PostController controller = new PostController(repo);

        SarcinaRepoFile repoFile = new SarcinaRepoFile("src/sarcini.txt");
        SarcinaController sarcinaController = new SarcinaController(repoFile);

        ElementFisaRepoSerializable elementFisaRepoSerializable = new ElementFisaRepoSerializable("src/elementfisa.txt");
        ElementFisaController fisaController = new ElementFisaController(elementFisaRepoSerializable, controller, sarcinaController);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("GUIScene/ElementFisaShowV.fxml"));
        BorderPane borderPane = loader.load();

        GUIScene.ElementFisaController viewController = loader.getController();

        viewController.setController(fisaController);
        elementFisaRepoSerializable.addObserver(viewController);
        /**repo.addObserver(viewController); @TO ADD**/
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Element fisa");
        primaryStage.show();

        /**
         * @@@STAGE
         * With posts
         */
        Stage stage = new Stage();
        FXMLLoader loaderFrames = new FXMLLoader();
        loaderFrames.setLocation(Main.class.getResource("GUIScene/PostShowV.fxml"));
        BorderPane border = loaderFrames.load();

        GUIScene.PostShowController postController = loaderFrames.getController();
        postController.setController(controller);
        repo.addObserver(postController);
        Scene postScene = new Scene(border);
        stage.setScene(postScene);
        stage.setTitle("Post scene");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();

        /**
         * @@@STAGE
         * With sarcine
         */
        Stage stageSarcine = new Stage();
        SarcinaDataModel model = new SarcinaDataModel(repoFile);
        SarcinaView sarcinaView = new SarcinaView(model.getModel(), sarcinaController);
        Parent parent = sarcinaView.getView();

        Scene sceneSarcina = new Scene(parent,500,500);
        stageSarcine.setScene(sceneSarcina);
        stageSarcine.setTitle("Sarcini repo");
        stageSarcine.show();
        stageSarcine.setOnCloseRequest(new EventHandler<WindowEvent>() {

            @Override
            public void handle(WindowEvent event) {
                repoFile.saveToFile();
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
