package org.sunxin.struts2.action;

import java.util.Date;

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

    /**
     * 调用UserDao的register方法注册用户
     */
    @Override
    public String execute() throws Exception {
        user.setRegDate(new Date()); // 注意不要忘了设置注册日期
        userDao.register(user);
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