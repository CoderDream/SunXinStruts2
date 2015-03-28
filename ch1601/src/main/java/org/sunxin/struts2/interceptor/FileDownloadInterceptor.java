package org.sunxin.struts2.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.config.entities.ResultConfig;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.PreResultListener;

public class FileDownloadInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6797242999485894327L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		invocation.addPreResultListener(new PreResultListener() {
			public void beforeResult(ActionInvocation invocation, String resultCode) {
				Map<String, ResultConfig> resultsMap = invocation.getProxy().getConfig().getResults();
				ResultConfig finalResultConfig = resultsMap.get(resultCode);

				// 为了简单起见，我们硬编码了下载文件的类型和下载文件名。
				// 实际应用中，你可以读取数据库或配置文件来获取下载文件的信息
				ResultConfig.Builder b = new ResultConfig.Builder(finalResultConfig);
				b.addParam("contentType", "application/zip");
				b.addParam("contentDisposition", "attachment;filename=\"abc.zip\"");
			}
		});
		return invocation.invoke();
	}
}