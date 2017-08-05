package interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pokedo on 2017/5/21.
 */
public class ListInterceptor extends AbstractInterceptor {
    //返回列表时，获取列表数据展示
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        if (ActionContext.getContext().get("headList") == null) {
            List headList = new ArrayList<>();
            for (int i = 1; i <= 15; i++)
                headList.add(i);
            ActionContext.getContext().put("headList", headList);
        }
        return actionInvocation.invoke();
    }
}
