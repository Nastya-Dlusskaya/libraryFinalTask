package main.by.epam.library.model.command;

public class ActionFactory {
    public ActionCommand defineCommand(String typeCommand) {
        if(typeCommand == null || typeCommand.equals("")){
            return new EmptyCommand();
        }
        CommandEnum currentEnum = CommandEnum.getCommandEnum(typeCommand);

        switch (currentEnum){
            case LOGIN:
                return new LoginCommand();
            default:
                return new EmptyCommand();
        }
    }
}
