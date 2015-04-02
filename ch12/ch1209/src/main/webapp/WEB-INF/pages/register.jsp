<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title><s:text name="title" /></title>
<s:head />
</head>
<body>

	<s:set name="current_locale"
		value="#session['WW_TRANS_I18N_LOCALE'] == null ? locale : #session['WW_TRANS_I18N_LOCALE']" />

	<s:url id="chinese_url" value="register!default.action">
		<s:param name="request_locale" value="@java.util.Locale@CHINA" />
	</s:url>
	<s:url id="english_url" value="register!default.action">
		<s:param name="request_locale" value="@java.util.Locale@ENGLISH" />
	</s:url>

	<s:if test="#current_locale.equals(@java.util.Locale@CHINA)">
		<s:a href="%{#chinese_url}">
			<strong><s:text name="chinese" /></strong>
		</s:a>
		<s:a href="%{#english_url}">
			<s:text name="english" />
		</s:a>
	</s:if>
	<s:else>
		<s:a href="%{#chinese_url}">
			<s:text name="chinese" />
		</s:a>
		<s:a href="%{#english_url}">
			<strong><s:text name="english" /></strong>
		</s:a>
	</s:else>

	<hr color="#ededed" />

	<s:fielderror />
	<s:form>
		<s:textfield id="user.username" name="user.username" key="username"
			required="true" />
		<s:password id="user.password" name="user.password" key="password"
			value="#{user.password}" required="true" />
		<s:password id="verifyPassword" name="verifyPassword"
			value="#{verifyPassword}" key="verifyPassword" required="true" />
		<s:radio name="user.sex" value="true"
			list="#{true : getText('sex.male'), false : getText('sex.female')}" key="sex" />
		<s:textfield name="user.email" key="email" />
		<s:textfield name="user.pwdQuestion" key="pwdQuestion" />
		<s:textfield name="user.pwdAnswer" key="pwdAnswer" />
		<table>
			<tr>
				<td><label for="register_validationCode"> <s:text
							name="validationCode" />
				</label></td>
				<td><s:textfield name="validationCode" theme="simple" /> <!-- 使用url标签来输出引用验证码图像的URL -->
					<img src="<s:url action='validationCode'/>" /></td>
			</tr>
		</table>
		<s:component template="submit_resetTemplate.jsp">
			<s:param name="submit" value="getText('submit')" />
			<s:param name="reset" value="getText('reset')" />
		</s:component>
	</s:form>
</body>
</html>
