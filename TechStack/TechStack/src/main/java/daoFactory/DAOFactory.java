package daoFactory;

import Service.StackService;
import Service.TechService;
import Service.UserService;
import Service.User_StackService;

import java.sql.SQLException;

public class DAOFactory {

    public static UserService getUserService() throws SQLException, ClassNotFoundException {
        return new UserService();
    }

    public static User_StackService getUser_StackService() throws SQLException, ClassNotFoundException {
        return new User_StackService();
    }

    public static TechService getTechService(){
        return new TechService();
    }

    public static StackService getStackService(){
        return new StackService();
    }
}
