package sample.dataBaseWorkClasses;

import sample.workedClasses.Photographer;
import java.sql.*;

/**
 * This class is for working with DB
 */

public class DbHandler extends Configs {
    private Connection dbConnection;

    /**
     * The method is for get connection with DB
     */

    public Connection getDbConnection() throws ClassNotFoundException {

        String connectionString = "jdbc:mysql://localhost:3306/phdb";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

            if (!dbConnection.isClosed()) {
                System.out.println("Соединение с БД установлено");
            }

        } catch (SQLException e) {
            System.out.println("Не удалось загрузить класс драйвера");
        }
        return dbConnection;
    }

    /**
     * The method adds a new raw to DB
     */

    public void signUpUser(Photographer photographer) {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" +
                Const.USER_NAME + "," + Const.USER_SURNAME + "," +
                Const.USER_STAGE + "," +
                Const.USER_PORTFOLIO + "," + Const.USER_LOCATION_ +
                ") " +
                "VALUES(?,?,?,?,?)";
        System.out.println(insert);

        try {
            System.out.println(insert);
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, photographer.getName());
            System.out.println(photographer.getName());
            prSt.setString(2, photographer.getSurname());
            System.out.println(photographer.getSurname());
            prSt.setString(3, photographer.getStage());
            System.out.println(photographer.getStage());
            prSt.setString(4, photographer.getPortfolio());
            System.out.println(photographer.getPortfolio());
            prSt.setString(5, photographer.getLocation_());
            System.out.println(photographer.getLocation_());
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * The method deletes a raw from DB by a column "id"
     */

    public void deleteRaw(Photographer photographer) throws SQLException, ClassNotFoundException {

        String insert = "DELETE FROM photographers WHERE id = " + photographer.getId() + " ";

        System.out.println(insert);
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.executeUpdate();

    }

    /**
     * The method gets the information from DB
     */

    public ResultSet getAll() {
        ResultSet resultSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE;

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            resultSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resultSet;
    }
}
