package Service;

import DAOImpl.User_StackDAOImpl;
import bean.Stack;
import dao.User_StackDAO;
import db.DBConnection;

import java.sql.SQLException;
import java.util.List;

public class User_StackService implements User_StackDAO {
    private DBConnection dbConnection;
    private User_StackDAOImpl user_stackDAOImpl;

    public User_StackService() throws SQLException, ClassNotFoundException {
        dbConnection = new DBConnection();
        user_stackDAOImpl = new User_StackDAOImpl(dbConnection.getConn());
    }

    @Override
    public List<Stack> getAllStackOfUser(int uid) throws SQLException {
        List<Stack> resList = null;
        try{
            resList = user_stackDAOImpl.getAllStackOfUser(uid);
        } catch (SQLException throwables) {
            throw throwables;
        }finally {
            dbConnection.close();
        }
        return resList;
    }
}
