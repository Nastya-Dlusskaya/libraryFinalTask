package main.by.epam.library.dao;

import main.by.epam.library.model.entity.Person;
import main.by.epam.library.model.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDAO {

    private static final String QUERY_FIND_TYPE_PERSON = "SELECT role.type_person FROM person JOIN role ON " +
            "person.id_role = role.idrole WHERE login=? AND password=?";

    private Connection connection;

    public PersonDAO(Connection connection) {
        this.connection = connection;
    }

    public String findTypePerson(String login, String password) throws DAOException {
        String query = QUERY_FIND_TYPE_PERSON;
        String type = "";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                type = resultSet.getString("type");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return type;
    }
}
