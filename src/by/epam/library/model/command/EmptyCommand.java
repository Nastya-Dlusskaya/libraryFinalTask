package main.by.epam.library.model.command;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements ActionCommand {
    public String execute(HttpServletRequest request) {
        return ConfigurationManager.getProperty("path.page.login");
    }
}
