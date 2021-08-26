package bean;

import java.util.List;

public class User {
    private int userid = -1;
    private String username;
    private String password;
    private List<Stack> stackList;

    public User(int userid, String username, String password, List<Stack> stackList) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.stackList = stackList;
    }

    public User(int userid, String username, String password) {
        this.userid = userid;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public List<Stack> getStackList() {
        return stackList;
    }

    public void setStackList(List<Stack> stackList) {
        this.stackList = stackList;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
