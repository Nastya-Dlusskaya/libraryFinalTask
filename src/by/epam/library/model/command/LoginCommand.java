package main.by.epam.library.model.command;

import main.by.epam.library.model.entity.Person;
import main.by.epam.library.model.entity.TypePerson;
import main.by.epam.library.model.exception.CommandException;
import main.by.epam.library.model.exception.ServiceException;
import main.by.epam.library.servises.LoginService;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements ActionCommand {

    private static final String PARAMETER_LOGIN = "login";
    private static final String PARAMETER_PASSWORD = "password";

    public String execute(HttpServletRequest request) throws CommandException {
        String page = null;

        String login = request.getParameter(PARAMETER_LOGIN);
        String password = request.getParameter(PARAMETER_PASSWORD);

        LoginService loginService = new LoginService();

        TypePerson typePerson = null;
        try {
            typePerson = loginService.validateUser(login, password );
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        PageFactory factory = new PageFactory();
        page = factory.createPage(typePerson);

        if (typePerson != TypePerson.UNKNOWN){
            request.setAttribute("user",login);
        } else {
            request.setAttribute("wrongAction", MessageManager.getProperty("message.loginerror"));
        }

        return page;
    }
}
