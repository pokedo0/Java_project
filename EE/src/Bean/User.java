package Bean;

import java.sql.Date;

/**
 * Created by pokedo on 2017/4/14.
 */
public class User {
    private Integer userId;
    private String userName;
    private String password;
    private String head;
    private Date regTime;
    private String email;
    private int gender;

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getHead() {
        return head;
    }

    public Date getRegTime() {
        return regTime;
    }

    public String getEmail() {
        return email;
    }

    public int getGender() {
        return gender;
    }
}
