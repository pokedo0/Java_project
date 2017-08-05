import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by pokedo on 2017/5/26.
 */
public class TestI18N {
    public static void main(String args[]) {
        Locale locale1 = Locale.SIMPLIFIED_CHINESE;
        ResourceBundle bundle1 = ResourceBundle.getBundle("resource", locale1);
        System.out.println("bundle1: " + bundle1.getString("welcome"));

        Locale locale2 = new Locale("en", "US");
        ResourceBundle bundle2 = ResourceBundle.getBundle("resource", locale2);
        System.out.println("bundle2: " + bundle2.getString("welcome"));

        Locale.setDefault(Locale.CANADA);
        ResourceBundle bundle3 = ResourceBundle.getBundle("resource");
        System.out.println("bundle3: " + bundle3.getString("welcome"));
    }
}
