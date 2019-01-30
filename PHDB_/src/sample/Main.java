package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    /**
     * This method makes a main window
     */
    @Override
    public void start(Stage stage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("/sample/windows/FXML's/mainWindow.fxml"));
        Scene scene = new Scene(root, 1100, 700);
        stage.setTitle("PHDB");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("cssFiles/Fon.jpg")));
        scene.getStylesheets().add(getClass().getResource("cssFiles/mainWindow.css").toExternalForm());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
