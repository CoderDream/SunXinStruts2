package org.sunxin.struts2.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class MultiFileUploadAction extends ActionSupport {
	private static final long serialVersionUID = -2420086584450715095L;

	/*
	 * //使用File对象数组，接收多个上传文件 private File[] file; //使用数组保存多个上传文件的文件名 private String[] fileFileName; //使用数组保存多个上传文件的MIME类型
	 * private String[] fileContentType;
	 * 
	 * public File[] getFile() { return file; }
	 * 
	 * public void setFile(File[] file) { this.file = file; }
	 * 
	 * public String[] getFileContentType() { return fileContentType; }
	 * 
	 * public void setFileContentType(String[] fileContentType) { this.fileContentType = fileContentType; }
	 * 
	 * public String[] getFileFileName() { return fileFileName; }
	 * 
	 * public void setFileFileName(String[] fileFileName) { this.fileFileName = fileFileName; }
	 */

	// 使用列表接收上传文件
	private List<File> file;
	// 使用列表保存多个上传文件的文件名
	private List<String> fileFileName;
	// 使用列表保存多个上传文件的MIME类型
	private List<String> fileContentType;

	// 保存上传文件的目录，相对于Web应用程序的根路径，在struts.xml文件中配置
	private String uploadDir;

	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}

	/**
	 * @see com.opensymphony.xwork.Action#execute()
	 */
	public String execute() throws Exception {

		String newFileName = null;

		// 循环处理多个上传文件
		for (int i = 0; i < file.size(); i++) // //////////
		{
			// 得到当前时间自1970年1月1日0时0分0秒开始流逝的毫秒数，将这个毫秒数作为上传文件新的文件名。
			long now = new Date().getTime();
			int index = fileFileName.get(i).lastIndexOf('.'); // //////

			// 得到保存上传文件的目录的真实路径
			String path = ServletActionContext.getServletContext().getRealPath(uploadDir);

			File dir = new File(path);
			// 如果这个目录不存在，则创建它。
			if (!dir.exists())
				dir.mkdir();

			// 判断上传文件名是否有扩展名
			if (index != -1)
				newFileName = now + fileFileName.get(i).substring(index); // //
			else
				newFileName = Long.toString(now);

			BufferedOutputStream bos = null;
			BufferedInputStream bis = null;
			// 读取保存在临时目录下的上传文件，写入到新的文件中。
			try {
				FileInputStream fis = new FileInputStream(file.get(i)); // /////////
				bis = new BufferedInputStream(fis);

				FileOutputStream fos = new FileOutputStream(new File(dir, newFileName));
				bos = new BufferedOutputStream(fos);

				byte[] buf = new byte[4096];

				int len = -1;
				while ((len = bis.read(buf)) != -1) {
					bos.write(buf, 0, len);
				}
			} finally {
				try {
					if (null != bis)
						bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

				try {
					if (null != bos)
						bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return SUCCESS;
	}

	public List<File> getFile() {
		return file;
	}

	public void setFile(List<File> file) {
		this.file = file;
	}

	public List<String> getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(List<String> fileFileName) {
		this.fileFileName = fileFileName;
	}

	public List<String> getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(List<String> fileContentType) {
		this.fileContentType = fileContentType;
	}
}
