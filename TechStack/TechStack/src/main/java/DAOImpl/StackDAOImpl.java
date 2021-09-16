package DAOImpl;

import dao.StackDAO;

import java.sql.*;

public class StackDAOImpl implements StackDAO {
    private Connection conn;

    public StackDAOImpl(Connection conn){
        this.conn = conn;
    }

    @Override
    public int insert(String sname, String description) throws SQLException {
        String sql = "insert into stack values(null, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, sname);
        statement.setString(2, description);
        if(statement.executeUpdate() <= 0) return -1;
        sql = "select last_insert_id()";
        statement = conn.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        return resultSet.getInt("last_insert_id()");
    }
}
