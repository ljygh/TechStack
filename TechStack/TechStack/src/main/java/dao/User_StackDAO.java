package dao;

import bean.Stack;

import java.sql.SQLException;
import java.util.List;

public interface User_StackDAO {

    List<Stack> getAllStackOfUser(int uid) throws SQLException;

    boolean isContainStack(int uid, String sname) throws SQLException;

    boolean insert(int uid, int sid) throws SQLException;

    List<Stack> SearchStackByName(int uid, String sname) throws SQLException;
}
