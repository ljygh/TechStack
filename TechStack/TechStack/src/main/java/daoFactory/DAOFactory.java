package daoFactory;

import Service.UserService;

import java.sql.SQLException;

public class DAOFactory {

    public static UserService getUserService() throws SQLException, ClassNotFoundException {
        return new UserService();
    }
}
