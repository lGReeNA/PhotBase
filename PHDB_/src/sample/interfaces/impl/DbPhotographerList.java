package sample.interfaces.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.dataBaseWorkClasses.DbHandler;
import sample.workedClasses.Photographer;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class is for working with the table photographers
 */

public class DbPhotographerList {

    private ObservableList<Photographer> readersList = FXCollections.observableArrayList();

    /**
     * This method is for reading the information from DB
     */

    public void addAll() throws SQLException {
        DbHandler dbHandler = new DbHandler();

        ResultSet resultSet = dbHandler.getAll();
        while (resultSet.next()) {
            Photographer photographer = new Photographer();
            photographer.setId(resultSet.getString(1));
            System.out.println(photographer.getId());
            photographer.setName(resultSet.getString(2));
            System.out.println(photographer.getName());
            photographer.setSurname(resultSet.getString(3));
            System.out.println(photographer.getSurname());
            photographer.setStage(resultSet.getString(4));
            System.out.println(photographer.getStage());
            photographer.setPortfolio(resultSet.getString(5));
            System.out.println(photographer.getPortfolio());
            photographer.setLocation_(resultSet.getString(6));
            System.out.println(photographer.getLocation_());
            readersList.add(photographer);
        }
    }

    public ObservableList<Photographer> getReadersList() {
        return readersList;
    }
}
