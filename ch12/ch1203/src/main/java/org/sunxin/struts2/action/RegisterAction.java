package org.sunxin.struts2.action;

import java.util.Date;

import org.sunxin.struts2.exceptions.UsernameExistException;
import org.sunxin.struts2.persistence.dao.UserDao;
import org.sunxin.struts2.persistence.entity.User;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
    private static final long serialVersionUID = 3970199804617664569L;
    private User user;
    private UserDao userDao;

    /**
     * 在构造方法中初始化UserDao对象
     */
    /*
     * public RegisterAction() { userDao = new UserDao(); }
     */

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 请求register!default.action，调用doDefault方法
     */
    @Override
    public String doDefault() throws Exception {
        return INPUT;
    }

    public void validate() {
        String username = user.getUsername();
        if (null == username || username.trim().length() == 0) {
            addFieldError("user.username", getText("error.username.required"));
        }

        String password = user.getPassword();

        if (null == password || password.trim().length() == 0) {
            addFieldError("user.password", getText("error.password.required"));
        }
        String email = user.getEmail();
        if (null == email || email.trim().length() == 0) {
            addFieldError("user.email", getText("error.email.required"));
        }
    }

    /**
     * 调用UserDao的register方法注册用户
     */
    @Override
    public String execute() throws Exception {
        // 注意不要忘了设置注册日期
        user.setRegDate(new Date());
        try {
            userDao.register(user);
        } catch (UsernameExistException e) {
            // 当捕获到UsernameExistException异常，则从资源文件中获取键为
            // error.username.exist的消息文本，然后添加到字段错误中。
            addFieldError("user.username", getText("error.username.exist"));
            // 返回INPUT结果代码
            return INPUT;
        }

        return SUCCESS;
    }

    /**
     * 为user对象提供getter方法
     * 
     * @return
     */
    public User getUser() {
        return user;
    }

    /**
     * 为user对象提供setter方法
     * 
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

}