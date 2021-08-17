package DAOImpl;

import bean.User;
import dao.UserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    private Connection conn;

    public UserDAOImpl(Connection connection){
        conn = connection;
    }

    @Override
    public boolean insert(User user) throws SQLException {
        if(getUser(user.getUsername()) != null) return false;
        String sqlString = "insert into user values(null,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sqlString);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        if(preparedStatement.executeUpdate() > 0) return true;
        return false;
    }

    @Override
    public boolean delete(String username) throws SQLException {
        String sqlString = "delete from user where uname = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sqlString);
        preparedStatement.setString(1, username);
        if(preparedStatement.executeUpdate() > 0) return true;
        return false;
    }

    @Override
    public boolean update(String username, User user) throws SQLException {
        if(getUser(user.getUsername()) != null) return false;
        String sqlString = "update user set uname = ?, password = ? where uname = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sqlString);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, username);
        if(preparedStatement.executeUpdate() > 0) return true;
        return false;
    }

    @Override
    public User getUser(String username) throws SQLException {
        String sqlString = "select * from user where uname = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sqlString);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        User user = null;
        while (resultSet.next()){
            user = new User(resultSet.getString("uname"), resultSet.getString("password"));
        }
        return user;
    }
}
