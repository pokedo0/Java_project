package action;

import com.opensymphony.xwork2.ActionSupport;

import java.util.Date;
import java.util.ResourceBundle;


public class I18NTestAction extends ActionSupport {
    @Override
    public String execute() throws Exception {
        String welcome = getText("welcome");
        System.out.println("welcome = " + welcome);

        String hello = getText("hello", new String[]{"黎明", new Date().toString()});
        System.out.println("hello = " + hello);

        ResourceBundle bundle = getTexts("message");
        String msgHello = bundle.getString("hello");
        System.out.println("message::hello = " + msgHello);
        return SUCCESS;
    }
}
