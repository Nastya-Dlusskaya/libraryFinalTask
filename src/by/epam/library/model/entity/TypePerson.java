package main.by.epam.library.model.entity;

public enum TypePerson {
    ADMIN("admin"), READER("reader"), LIBRARIAN("librarian"), UNKNOWN("unknown");
    String value;

    TypePerson(String value) {
        this.value = value;
    }

    public static TypePerson getCommandEnum(String value){
        TypePerson[] commands = TypePerson.values();
        for (TypePerson command:commands) {
            String commandValue = command.value;
            if (value.equals(commandValue)){
                return command;
            }
        }
        return UNKNOWN;
    }
}
