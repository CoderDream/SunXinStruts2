package org.sunxin.struts2.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

public class User implements Serializable {

    private static final long serialVersionUID = -2225053861113413685L;

    private Integer id;
    private String username;
    private String password;
    private Boolean sex;
    private String email;
    private String pwdQuestion;
    private String pwdAnswer;
    private Date regDate;
    private Date lastLoginDate;
    private String lastLoginIp;

    public String getEmail() {
        return email;
    }

    @RequiredStringValidator(type = ValidatorType.FIELD, key = "error.email.required", message = "${getText('email')} is required", shortCircuit = true)
    @EmailValidator(key = "error.email.invalid", type = ValidatorType.FIELD, message = "${getText('email')} is an invalid email address")
    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public String getUsername() {
        return username;
    }

    @RequiredStringValidator(type = ValidatorType.FIELD, key = "error.username.required", message = "${getText('username')} is required", shortCircuit = true)
    @StringLengthFieldValidator(type = ValidatorType.FIELD, key = "error.username.length", minLength = "4", maxLength = "12", message = "${getText('username')} must between ${minLength} and ${maxLength} characters.")
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    @RequiredStringValidator(type = ValidatorType.FIELD, key = "error.password.required", message = "${getText('password')} is required", shortCircuit = true)
    @StringLengthFieldValidator(type = ValidatorType.FIELD, key = "error.password.length", minLength = "4", maxLength = "8", message = "${getText('password')} must between ${minLength} and ${maxLength} characters.")
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPwdAnswer() {
        return pwdAnswer;
    }

    public void setPwdAnswer(String pwdAnswer) {
        this.pwdAnswer = pwdAnswer;
    }

    public String getPwdQuestion() {
        return pwdQuestion;
    }

    public void setPwdQuestion(String pwdQuestion) {
        this.pwdQuestion = pwdQuestion;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }
}
