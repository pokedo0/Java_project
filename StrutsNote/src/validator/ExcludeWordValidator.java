package validator;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

/**
 * Created by pokedo on 2017/5/21.
 */
public class ExcludeWordValidator extends FieldValidatorSupport {
    private String exclude = "";

    public void setExclude(String exclude) {
        this.exclude = exclude;
    }

    @Override
    public void validate(Object o) throws ValidationException {
        String fieldName = this.getFieldName();
        String fieldValue = (String) this.getFieldValue(fieldName, o);
        System.out.println("fieldname:" + fieldName);
        System.out.println("object:" + o);
        System.out.println("fieldvalue:" + fieldValue);
        if (null == fieldValue || fieldValue.length() == 0)
            return;
        if (exclude.length() == 0)
            return;
        String[] keywords = exclude.split(",");
        for (String s : keywords)
            if (fieldValue.contains(s)) {
                this.addFieldError(fieldName, o);
                return;
            }
    }
}
