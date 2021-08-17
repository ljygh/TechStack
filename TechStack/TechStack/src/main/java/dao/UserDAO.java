package dao;

import bean.User;

import java.sql.SQLException;

public interface UserDAO {

    boolean insert(User user) throws SQLException;

    boolean delete(String username) throws SQLException;

    boolean update(String username, User user) throws SQLException;

    User getUser(String username) throws SQLException;
}
