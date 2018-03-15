package main.by.epam.library.model.command;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements ActionCommand {

    private static final String PARAMETER_LOGIN = "login";
    private static final String PARAMETER_PASSWORD = "password";

    public String execute(HttpServletRequest request) {
        String page = null;
        String login = request.getParameter(PARAMETER_LOGIN);
        String password = request.getParameter(PARAMETER_PASSWORD);
        if(login.equals("Nastya@gmail.com") && password.equals("0303")){
            request.setAttribute("user",login);
            page = ConfigurationManager.getProperty("path.page.main");
        } else {
            request.setAttribute("wrongAction", MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.login");
        }

        return page;
    }
}
