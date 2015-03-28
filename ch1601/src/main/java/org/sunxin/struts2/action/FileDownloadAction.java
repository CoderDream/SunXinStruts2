package org.sunxin.struts2.action;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

public class FileDownloadAction implements Action {
	// 下载文件的路径，在struts.xml文件中配置
	private String inputPath;

	public void setInputPath(String value) {
		inputPath = value;
	}

	// inputStream属性的getter方法，StreamResult结果类型使用该属性来读取下载文件的内容
	public InputStream getInputStream() throws Exception {
		return ServletActionContext.getServletContext().getResourceAsStream(inputPath);
	}

	public String execute() throws Exception {
		return SUCCESS;
	}
}