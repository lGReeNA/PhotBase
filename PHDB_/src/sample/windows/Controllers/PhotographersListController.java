package sample.windows.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.interfaces.impl.DbPhotographerList;
import sample.workedClasses.Photographer;
import java.sql.SQLException;

/**
 * This class is for working with the window with list of photographers
 */

public class PhotographersListController {

    @FXML
    private TableColumn<Photographer, Integer> id;

    @FXML
    private TableColumn<Photographer, String> surname;

    @FXML
    private TableColumn<Photographer, String> name;

    @FXML
    private TableColumn<Photographer, String> stage;

    @FXML
    private TableColumn<Photographer, String> portfolio;

    @FXML
    private TableColumn<Photographer, String> location_;

    @FXML
    private Button out;

    @FXML
    private TableView<Photographer> table;

    @FXML
    private Label label;

    /**
     * The method for reading information about photographers from the database and showing the information in a table
     */

    @FXML
   void initialize()
    {
        out.setOnAction(event -> out.getScene().getWindow().hide());

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        stage.setCellValueFactory(new PropertyValueFactory<>("stage"));
        portfolio.setCellValueFactory(new PropertyValueFactory<>("portfolio"));
        location_.setCellValueFactory(new PropertyValueFactory<>("location_"));

        DbPhotographerList dbPhotographerList = new DbPhotographerList();

        try {
            dbPhotographerList.addAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        table.setItems(dbPhotographerList.getReadersList());
        label.setText(label.getText()  + dbPhotographerList.getReadersList().size());
    }
}
