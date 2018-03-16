package main.by.epam.library.controller;

import main.by.epam.library.model.command.ActionCommand;
import main.by.epam.library.model.command.ActionFactory;
import main.by.epam.library.model.exception.CommandException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.LogManager;

@WebServlet(name = "login", urlPatterns = "/login")
public class Controller extends HttpServlet {
    private static final Logger log = LogManager.getLogger(Controller.class.getName());
    private static final String COMMAND = "command";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;

        ActionFactory client = new ActionFactory();
        String currentCommand = request.getParameter(COMMAND);
        ActionCommand command = client.defineCommand(currentCommand);

        try {
            page = command.execute(request);
        } catch (CommandException e) {

        }

        if(page != null){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        }
    }
}
