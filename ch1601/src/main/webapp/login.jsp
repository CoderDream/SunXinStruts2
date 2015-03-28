<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<html>
<head>
<title>登录页面</title>
<!-- 输出xhtml主题下的CSS和JavaScript代码 -->
<s:head />
</head>
</html>
<s:form action="login">
	<!-- 调用actionerror标签输出Action错误 -->
	<s:actionerror />
	<s:textfield name="user.username" label="用户名" value="zhangsan" />
	<s:password name="user.password" label="密码" value="1234" />
	<s:submit value="登录" />
</s:form>
