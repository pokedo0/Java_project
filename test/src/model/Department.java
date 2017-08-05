package model;

/**
 * Created by pokedo on 2017/6/2.
 */
public class Department {
    private int deptid;
    private String dName;
    private String loc;

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public void setDName(String dName) {
        this.dName = dName;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public int getDeptid() {
        return deptid;
    }

    public String getDName() {
        return dName;
    }

    public String getLoc() {
        return loc;
    }
}
