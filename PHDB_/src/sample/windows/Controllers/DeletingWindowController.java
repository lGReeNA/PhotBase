package sample.windows.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.dataBaseWorkClasses.DbHandler;
import sample.workedClasses.Photographer;
import java.sql.SQLException;

/**
 * This class is for working with the window for deleting a photographer
 */

public class DeletingWindowController {

    @FXML
    private Button Cancel;

    @FXML
    private TextField id;

    @FXML
    private Button Ok;

    /**
     * The method for deleting the photographer from database by id
     */

    @FXML
    void initialize()
    {
        Cancel.setOnAction(event -> Cancel.getScene().getWindow().hide());

        Ok.setOnAction(event -> {
            DbHandler dbHandler = new DbHandler();
            Photographer photographer = new Photographer();
            photographer.setId(id.getText().trim());
            System.out.println(id.getText().trim());
                photographer.setId(id.getText().trim());

            try {
                dbHandler.deleteRaw(photographer);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }
}
