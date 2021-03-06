package Service;

import DAOImpl.User_StackDAOImpl;
import bean.Stack;
import dao.User_StackDAO;
import db.DBConnection;

import java.sql.SQLException;
import java.util.LinkedList;
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

    @Override
    public boolean isContainStack(int uid, String sname) throws SQLException {
        boolean res;
        try{
            res = user_stackDAOImpl.isContainStack(uid, sname);
        } catch (SQLException throwables) {
            throw throwables;
        }finally {
            dbConnection.close();
        }
        return res;
    }

    @Override
    public boolean insert(int uid, int sid) throws SQLException {
        boolean res;
        try{
            res = user_stackDAOImpl.insert(uid, sid);
        } catch (SQLException throwables) {
            throw throwables;
        }finally {
            dbConnection.close();
        }
        return res;
    }

    @Override
    public List<Stack> SearchStackByName(int uid, String sname) throws SQLException {
        List<Stack> stackList = null;
        try{
            stackList = user_stackDAOImpl.SearchStackByName(uid, sname);
        } catch (SQLException throwables) {
            throw throwables;
        }finally {
            dbConnection.close();
        }
        return stackList;
    }
}
