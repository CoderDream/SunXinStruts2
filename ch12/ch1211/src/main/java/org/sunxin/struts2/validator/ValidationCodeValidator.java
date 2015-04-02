package org.sunxin.struts2.validator;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class ValidationCodeValidator extends FieldValidatorSupport {

    // 接收Session中的验证码
    private String sessionValidationCode;
    // 指示是否删除字符串首尾的空格
    private boolean trim = true;

    public String getSessionValidationCode() {
        return sessionValidationCode;
    }

    // 配置验证规则时，将保存在session中的验证码传递进来
    public void setSessionValidationCode(String sessionValidationCode) {
        this.sessionValidationCode = sessionValidationCode;
    }

    public boolean isTrim() {
        return trim;
    }

    public void setTrim(boolean trim) {
        this.trim = trim;
    }

    public void validate(Object object) throws ValidationException {
        Object objValidateCode = getFieldValue(sessionValidationCode, object);

        // 得到字段名
        String fieldName = getFieldName();
        // 得到字段的值
        String fieldValue = (String) getFieldValue(fieldName, object);

        // 如果字段值为null，直接返回
        if (fieldValue == null)
            return;

        // 如果trim为ture，则删除字段值首尾的空格
        if (trim)
            fieldValue = fieldValue.trim();

        // 如果字段值为""，直接返回
        if (fieldValue.length() == 0)
            return;

        // 判断字段值是否和session中的验证码相等，如果不相等，则添加字段错误消息
        if (!fieldValue.equals(objValidateCode)) {
            addFieldError(fieldName, object);
        }
    }
}