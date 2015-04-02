<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
    //得到Web应用程序的上下文路径
    String path = request.getContextPath();
    //构建Web应用程序上下文路径的完整URL
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title><s:text name="failure" /></title>
</head>

<body>
	<s:text name="failure.info">
		<s:param><%=basePath%>register!default.action</s:param>
	</s:text>
</body>
</html>