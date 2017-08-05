package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.UserDaoImpl;
import model.User;

import java.util.Map;


public class LoginAction extends ActionSupport {
    private String userName;
    private String password;
    private String repassword;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String execute() throws Exception {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.findUser(userName, password);
        if (null == user) { //登录不成功，则#session.user == null
            this.addActionError("用户名或密码错误！");
            return LOGIN;
        }   //登录成功则设置session
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        session.put("user", user);  //登录的用户名保存到session中
        return SUCCESS;
    }

    public String logout() {
        ActionContext context = ActionContext.getContext();
        Map session = context.getSession();
        session.clear();
        return "loginpage";
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getRepassword() {
        return repassword;
    }

}
