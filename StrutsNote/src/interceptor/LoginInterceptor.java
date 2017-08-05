package interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.PreResultListener;

import java.util.Map;

public class LoginInterceptor extends AbstractInterceptor {

    @Override
    public void destroy() {
        System.out.println("interceptor destroy");
    }

    @Override
    public void init() {
        System.out.println("interceptor start");
    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        ActionContext context = ActionContext.getContext();
        Map session = context.getSession();
        Object user = session.get("user");
        actionInvocation.addPreResultListener(new PreResultListener() {
            @Override
            public void beforeResult(ActionInvocation actionInvocation, String s) {
//                System.out.println("beforesult : " + s);
            }
        });
//        System.out.println("interceptor");
        if (null == user)
            return "loginpage";
        else
            return actionInvocation.invoke();
    }
}
