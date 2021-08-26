package bean;

public class Tech {
    private int tid;
    private String tname;
    private String description;
    private String filename;

    public Tech(int tid, String tname, String description, String filename) {
        this.tid = tid;
        this.tname = tname;
        this.description = description;
        this.filename = filename;
    }

    public Tech(String tname, String description, String filename) {
        this.tname = tname;
        this.description = description;
        this.filename = filename;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
