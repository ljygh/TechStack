package dao;

import bean.Stack;
import bean.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    boolean insert(User user) throws SQLException;

    boolean delete(String username) throws SQLException;

    boolean updatePswd(String username, String password) throws SQLException;

    User getUserByName(String username) throws SQLException;
}
