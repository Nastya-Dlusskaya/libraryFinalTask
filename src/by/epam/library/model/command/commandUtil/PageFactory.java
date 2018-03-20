package by.epam.library.model.command;

import by.epam.library.model.entity.TypePerson;

public class PageFactory {
    public String createPage(TypePerson typePerson){
        switch(typePerson){
            case ADMIN:
                return ConfigurationManager.getProperty("path.page.admin");
            case READER:
                return ConfigurationManager.getProperty("path.page.reader");
            case LIBRARIAN:
                return ConfigurationManager.getProperty("path.page.librarian");
            default:
                return ConfigurationManager.getProperty("path.page.login");
        }
    }
}
