package dao;

import bean.Stack;

import java.sql.SQLException;
import java.util.List;

public interface User_StackDAO {
    List<Stack> getAllStackOfUser(int uid) throws SQLException;
}
