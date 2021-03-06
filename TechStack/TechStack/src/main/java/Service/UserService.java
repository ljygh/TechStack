package Service;

import DAOImpl.UserDAOImpl;
import bean.User;
import dao.UserDAO;
import db.DBConnection;

import java.sql.SQLException;

public class UserService implements UserDAO {
    private DBConnection dbConnection;
    private UserDAOImpl userDAOImpl;

    public UserService() throws SQLException, ClassNotFoundException {
        dbConnection = new DBConnection();
        userDAOImpl = new UserDAOImpl(dbConnection.getConn());
    }

    @Override
    public boolean insert(User user) throws SQLException {
        boolean res;
        try{
            res = userDAOImpl.insert(user);
        }catch (SQLException throwables) {
            throw throwables;
        }finally {
            dbConnection.close();
        }
        return res;
    }

    @Override
    public boolean delete(String username) throws SQLException {
        boolean res;
        try{
            res = userDAOImpl.delete(username);
        }catch (SQLException throwables) {
            throw throwables;
        }finally {
            dbConnection.close();
        }
        return res;
    }

    @Override
    public boolean updatePswd(String username, String password) throws SQLException {
        boolean res;
        try{
            res = userDAOImpl.updatePswd(username, password);
        }catch (SQLException throwables) {
            throw throwables;
        }finally {
            dbConnection.close();
        }
        return res;
    }

    @Override
    public User getUserByName(String username) throws SQLException {
        User res;
        try{
            res = userDAOImpl.getUserByName(username);
        }catch (SQLException throwables) {
            throw throwables;
        }finally {
            dbConnection.close();
        }
        return res;
    }
}
