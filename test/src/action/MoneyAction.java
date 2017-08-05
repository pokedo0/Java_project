package action;

import com.opensymphony.xwork2.ActionSupport;

public class MoneyAction extends ActionSupport {
    private double money;
    private double result;

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public String execute() throws Exception {
        result = money; //必要
        return SUCCESS;
    }
}
