package dao;

import java.sql.SQLException;

public interface StackDAO {

    int insert(String sname, String description) throws SQLException;

}
