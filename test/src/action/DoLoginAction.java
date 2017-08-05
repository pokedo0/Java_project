package test.src.action;

import com.opensymphony.xwork2.ActionSupport;

import java.util.regex.Pattern;

/**
 * Created by pokedo on 2017/5/20.
 */
public class DoLoginAction extends ActionSupport {
    private String userName;
    private String password;
    private String repassword;
    private String choose;

    public void setChoose(String choose) {
        this.choose = choose;
    }

    public String getChoose() {
        return choose;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getUserName() {

        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getRepassword() {
        return repassword;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    @Override
    public void validate() {
        System.out.println("choose :" + choose);
        if (userName.equals("admin") || userName.equals("adminisztor"))
            addFieldError("username", "用户名关键字！");
        boolean isMatch = Pattern.matches("\\w{6,20}", password);
        if (!isMatch)
            addFieldError("password", "密码6-20位！");
        if (!repassword.equals(password))
            addFieldError("repassword", "重复密码不匹配!");
    }
}
