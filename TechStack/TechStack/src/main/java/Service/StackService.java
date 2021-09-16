package Service;

import DAOImpl.StackDAOImpl;
import dao.StackDAO;
import db.DBConnection;

import java.sql.SQLException;

public class StackService implements StackDAO {
    private DBConnection dbConnection;
    private StackDAOImpl stackDAOImpl;

    public StackService() throws SQLException, ClassNotFoundException {
        dbConnection = new DBConnection();
        stackDAOImpl = new StackDAOImpl(dbConnection.getConn());
    }

    @Override
    public int insert(String sname, String description) throws SQLException {
        int res;
        try{
            res = stackDAOImpl.insert(sname, description);
        } catch (SQLException throwables) {
            throw throwables;
        }finally {
            dbConnection.close();
        }
        return res;
    }
}
