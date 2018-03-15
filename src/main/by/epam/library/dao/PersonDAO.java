package main.by.epam.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDAO {

    private static final String QUERY_FIND_TYPE_PERSON = "SELECT id_login, id_type FROM person WHERE login=? AND password=?";

    private Connection connection;

    public PersonDAO(Connection connection) {
        this.connection = connection;
    }

    public int findTypePerson(String login, String password) throws SQLException {
        String query = QUERY_FIND_TYPE_PERSON;
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, login);
        statement.setString(2, password);

        ResultSet resultSet = statement.executeQuery();

        if(resultSet.next()){
            int idPerson = resultSet.getInt("id_login");
            int idType = resultSet.getInt("id_type");
        }
        return 0;
    }
}
