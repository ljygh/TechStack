import bean.User;
import daoFactory.DAOFactory;

import java.sql.SQLException;

public class Test {

    public static void main(String[] args) {
        //User user = new User("wangwu", "fiagiagie");
        try {
            /*boolean boo = DAOFactory.getUserService().insert(user);
            System.out.println(boo);
            User sUser = DAOFactory.getUserService().getUser("zhangsan");
            System.out.println(sUser.getUsername() + " " + sUser.getPassword());*/
            //System.out.println(DAOFactory.getUserService().delete("wangwu"));
            System.out.println(DAOFactory.getUserService().updatePswd("zhangsan", "222222"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
