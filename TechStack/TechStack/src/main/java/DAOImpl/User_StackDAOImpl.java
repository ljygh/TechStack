package DAOImpl;

import bean.Stack;
import dao.User_StackDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class User_StackDAOImpl implements User_StackDAO {
    private Connection conn;

    public User_StackDAOImpl(Connection connection){
        conn = connection;
    }

    @Override
    public List<Stack> getAllStackOfUser(int uid) throws SQLException {
        List<Stack> stackList = new LinkedList<>();
        String sql = "select * from stack where sid in (select sid from user_stack where uid = ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, uid);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            int sid = resultSet.getInt("sid");
            String sname = resultSet.getString("sname");
            String description = resultSet.getString("description");
            stackList.add(new Stack(sid, sname, description));
        }
        return stackList;
    }

    @Override
    public boolean isContainStack(int uid, String sname) throws SQLException {
        String sql = "select * from stack where sid in (select sid from user_stack where uid = ?) and sname = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, uid);
        statement.setString(2, sname);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()) return true;
        return false;
    }

    @Override
    public boolean insert(int uid, int sid) throws SQLException {
        String sql = "insert into user_stack values(?,?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, uid);
        statement.setInt(2, sid);
        if(statement.executeUpdate() > 0) return true;
        return false;
    }
}
