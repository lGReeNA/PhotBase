package sample.windows.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class is for working with the main window
 */

public class MainController {

    @FXML
    private Button seeAll;

    @FXML
    private Button newUser;

    @FXML
    private Button delete;

    @FXML
    private Button out;

    /**
     * The method for opening all another windows
     */

    @FXML
    void initialize() {
        newUser.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/windows/FXML's/registrationWindow.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/sample/cssFiles/registrationWindow.css").toExternalForm());

            stage.setScene(scene);
            stage.showAndWait();
        });

        seeAll.setOnAction(event -> {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/windows/FXML's/photographersListWindow.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/sample/cssFiles/registrationWindow.css").toExternalForm());

            stage.setScene(scene);
            stage.showAndWait();
        });

        delete.setOnAction(event -> {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/windows/FXML's/deletingWindow.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.showAndWait();
        });

        out.setOnAction(event -> {
            out.getScene().getWindow().hide();
        });
    }


}
