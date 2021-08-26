package daoFactory;

import Service.StackService;
import Service.TechService;
import Service.UserService;

import java.sql.SQLException;

public class DAOFactory {

    public static UserService getUserService() throws SQLException, ClassNotFoundException {
        return new UserService();
    }

    public static TechService getTechService(){
        return new TechService();
    }

    public static StackService getStackService(){
        return new StackService();
    }
}
