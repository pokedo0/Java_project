import org.apache.struts2.util.StrutsTypeConverter;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;

/**
 * Created by pokedo on 2017/6/2.
 */
public class MoneyConverter extends StrutsTypeConverter {
    @Override
    public Object convertFromString(Map map, String[] strings, Class aClass) {
        String s = strings[0].substring(1);
        String str = s.replace(",", "");
        return Double.parseDouble(str);
    }

    @Override
    public String convertToString(Map map, Object o) {
        System.out.println("object" + o);
        NumberFormat fmt = new DecimalFormat("$#,##0.00");
        return fmt.format(o);
//        return "22233";
    }
}
