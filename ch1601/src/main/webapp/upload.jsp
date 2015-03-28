<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>upload page</title>
</head>
<body>
	<s:actionerror />
	<s:form action="upload" method="post" enctype="multipart/form-data">
		<s:file name="file" label="选择上传的文件" />
		<s:textfield name="description" label="文件描述" />
		<s:submit value="上传" />
	</s:form>
</body>
</html>