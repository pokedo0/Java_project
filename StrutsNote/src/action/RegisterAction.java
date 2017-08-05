package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.UserDao;
import dao.UserDaoImpl;
import model.User;

import java.util.ArrayList;
import java.util.List;


public class RegisterAction extends ActionSupport {
    private String userName;
    private String password;
    private String repeat;
    private int gender;
    private int head;
    private List<Integer> headList;

    public String getRepeat() {
        return repeat;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getGender() {
        return gender;
    }

    public int getHead() {
        return head;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRepeat(String repeat) {
        this.repeat = repeat;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public void setHeadList(List<Integer> headList) {
        this.headList = headList;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("username:" + userName);
        System.out.println("password" + password);
        UserDao userDao = new UserDaoImpl();
        User user = new User();
        user.setPassword(password);
        user.setUserName(userName);
        user.setHead(head + ".gif");
        user.setGender(gender);
        userDao.addUser(user);
        return "loginpage";
    }

    public void list() {
        if (ActionContext.getContext().get("headList") != null)
            return;
        headList = new ArrayList<>();
        for (int i = 1; i <= 15; i++)
            headList.add(i);
        ActionContext.getContext().put("headList", headList);
    }

    //验证表单
//    private boolean fun() {
//        System.out.println("repeat" + repeat);
//        System.out.println("password" + password);
//        if (null == userName || null == password || "".equals(userName) || "".equals(password) || !password.equals(repeat))
//            return false;
//        return true;
//    }
}
