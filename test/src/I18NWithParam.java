import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by pokedo on 2017/5/26.
 */
public class I18NWithParam {
    public static void main(String args[]) {
        Locale locale1 = Locale.SIMPLIFIED_CHINESE;
        ResourceBundle bundle1 = ResourceBundle.getBundle("message", locale1);
        String welcome1 = bundle1.getString("welcome");
        String msg1 = MessageFormat.format(welcome1, "李明", new Date());
        System.out.println(msg1);

        Locale locale2 = Locale.US;
        ResourceBundle bundle2 = ResourceBundle.getBundle("message", locale2);
        String welcome2 = bundle2.getString("welcome");
        String msg2 = MessageFormat.format(welcome2, "Jogn", new Date());
        System.out.println(msg2);
    }
}
