package bean;

import java.util.List;

public class Stack {
    private int sid;
    private String sname;
    private String description;
    List<Tech> techList;

    public Stack(int sid, String sname, String description) {
        this.sid = sid;
        this.sname = sname;
        this.description = description;
    }

    public Stack(String sname, String description) {
        this.sname = sname;
        this.description = description;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Tech> getTechList() {
        return techList;
    }

    public void setTechList(List<Tech> techList) {
        this.techList = techList;
    }
}
