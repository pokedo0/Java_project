package action;

import com.opensymphony.xwork2.ActionSupport;
import model.Department;

import java.util.Map;

public class DepartmentAction extends ActionSupport {
    private Map<String, Department> depts;
    private Map<String, String> memo;

    public void setDepts(Map<String, Department> depts) {
        this.depts = depts;
    }

    public void setMemo(Map<String, String> memo) {
        this.memo = memo;
    }

    public Map<String, Department> getDepts() {

        return depts;
    }

    public Map<String, String> getMemo() {
        return memo;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
