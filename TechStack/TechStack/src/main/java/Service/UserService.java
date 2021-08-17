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
    public boolean update(String username, User user) throws SQLException {
        boolean res;
        try{
            res = userDAOImpl.update(username, user);
        }catch (SQLException throwables) {
            throw throwables;
        }finally {
            dbConnection.close();
        }
        return res;
    }

    @Override
    public User getUser(String username) throws SQLException {
        User res;
        try{
            res = userDAOImpl.getUser(username);
        }catch (SQLException throwables) {
            throw throwables;
        }finally {
            dbConnection.close();
        }
        return res;
    }
}
