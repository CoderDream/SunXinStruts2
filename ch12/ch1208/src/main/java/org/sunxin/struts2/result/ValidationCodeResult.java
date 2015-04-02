package org.sunxin.struts2.result;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.sunxin.struts2.action.ValidationCodeAction;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;

public class ValidationCodeResult implements Result {
    /**  */
    private static final long serialVersionUID = -1544417314799204958L;

    @Override
    public void execute(ActionInvocation invocation) throws Exception {
        ValidationCodeAction action = (ValidationCodeAction) invocation
                .getAction();
        HttpServletResponse response = ServletActionContext.getResponse();

        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        // 设置发送内容的媒体类型
        response.setContentType(action.getContentType());
        // 设置发送内容的长度
        response.setContentLength(action.getContentLength());

        ServletOutputStream sos = response.getOutputStream();

        // 输出验证码图像数据
        sos.write(action.getImageInBytes());
        sos.close();
    }
}