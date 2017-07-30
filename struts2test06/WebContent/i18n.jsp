<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:debug></s:debug>
	
	<a href="testI18n.action?request_locale=en_US">English</a>
	<a href="testI18n.action?request_locale=zh_CN">中文</a>
	<br><br>
	<a href="index.jsp">Index Page</a>
	<br><br>
	
	<s:text name="time">
	<s:param value="date"></s:param>
	</s:text>
	<br><br>
	<s:text name="time2"></s:text>
	<br><br>
	<s:form action="" theme="simple">
		<!--
		使用并非simple主题： 
		 label的方式需要使用ognl表达式才能可以从国际化资源文件中获取value值
		因为此时在对象栈中有DefaultTextprover的一个实例，该对象中提供了访问国际化资源的文件的getText方法
		同时还要告诉Struts2框架label中放入的不再是哪一个普通的字符串，而是一个OGNL表达式，并进行包装，以强制进行OGNL解析
		 -->
		 <!--
		   使用simple主题：
		   需要添加：<s:text name="。。。"/>:标签访问国际化资源文件中的value值，
		   submi不要使用：value="%{getText('Submit')}"进行解析
		  
		  -->
		<s:text name="username"/>:<s:textfield name="username" label="%{getText('username')}"></s:textfield>
		<!-- key的方式是直接在资源文件中获取value的值 -->
		<s:text name="username"/>:<s:textfield name="username" key="username"></s:textfield>
		<s:text name="password"/>:<s:textfield name="password" key="password"></s:textfield>
		<s:submit key="submit" value="%{getText('Submit')}"></s:submit>
	</s:form>
</body>
</html>