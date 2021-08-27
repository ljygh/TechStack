import bean.Stack;
import bean.User;
import daoFactory.DAOFactory;

import java.sql.SQLException;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        try {
            List<Stack> stackList = DAOFactory.getUser_StackService().getAllStackOfUser(6);
            for(Stack stack : stackList){
                System.out.println(stack.getSid() + " " + stack.getSname() + " " + stack.getDescription());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
