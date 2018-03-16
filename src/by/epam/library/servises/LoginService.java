package main.by.epam.library.servises;

import main.by.epam.library.dao.PersonDAO;
import main.by.epam.library.dao.PoolConnection;
import main.by.epam.library.model.entity.TypePerson;
import main.by.epam.library.model.exception.DAOException;
import main.by.epam.library.model.exception.ServiceException;

import java.sql.Connection;
import java.sql.SQLException;

public class LoginService {
    public TypePerson validateUser(String login, String password) throws ServiceException {
        TypePerson typePerson;
        try{
            PoolConnection poolConnection = PoolConnection.getInstance();
            Connection connection = poolConnection.getConnection();
            PersonDAO personDAO = new PersonDAO(connection);
            String stringTypePerson = personDAO.findTypePerson(login, password);
            typePerson = TypePerson.getCommandEnum(stringTypePerson);
        } catch (DAOException exception) {
            throw new ServiceException(exception);
        }
        return typePerson;
    }
}
