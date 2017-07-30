<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <a href="TestAware.do?name=struts">TestAware</a>
    <br><br>
    <a href="TestActionContext.action?name=struts2">Test ActionContext</a>
    <br><br>
    <a href="TestAware.action?name=struts2">Test Aware</a>
     <br><br>
    <a href="TestServletActionContextAction.action">Test ServletAction</a>
    <br><br>
    <a href="TestServletAware">Test TestServletAware</a>
    <br><br>
    
    <a href="Login-ui.do">LoginUI</a>
    <br><br>
    
    <a href="testResult.do?number=6">Test Result</a>
    <br><br>
  
    <%
    if(application.getAttribute("date")==null)
    	application.setAttribute("date", new Date());
    
    %>
    <a href="Useraction-save"> User Save</a>
    <br><br>
    <a href="Useraction-update"> User Update</a>
    <br><br>
    <a href="Useraction-delete"> User Delete</a>
    <br><br>
    <a href="Useraction-query"> User Query</a>
    <br><br>
    
     <a href="testDynamicMethodInvocation.do"> Test DynamicMethodInvocation</a>
    <br><br>
    
</body>
</html>