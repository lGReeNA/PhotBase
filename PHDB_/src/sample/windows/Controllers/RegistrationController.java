package sample.windows.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.dataBaseWorkClasses.DbHandler;
import sample.workedClasses.Photographer;

/**
 * This class is for working with the window for adding of photographers
 */

public class RegistrationController {

    @FXML
    private TextField stage;

    @FXML
    private TextField portfolio;

    @FXML
    private TextField surname;

    @FXML
    private TextField name;

    @FXML
    private TextField location_;

    @FXML
    private Button registration;

    @FXML
    private Button out;

    /**
     * The method for reading information about photographers and for adding the information to DataBase
     */

    @FXML
    void initialize() {
        out.setOnAction(event -> out.getScene().getWindow().hide());

        registration.setOnAction(event -> {
            DbHandler DbHandler = new DbHandler();
            Photographer photographer = new Photographer(name.getText(),surname.getText(),stage.getText(),portfolio.getText(),location_.getText());
            DbHandler.signUpUser(photographer);
        });
    }
}
