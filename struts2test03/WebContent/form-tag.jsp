
<%@page import="com.struts2test03.City"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	java.util.List<City> cities = new ArrayList<City>();
	cities.add(new City(1001,"AA"));  
	cities.add(new City(1002,"BB")); 
	cities.add(new City(1003,"CC")); 
	cities.add(new City(1004,"DD")); 
	request.setAttribute("cities", cities);
	%>
	<s:debug></s:debug>
	<!-- 表单标签：
       1.和HTML的form标签相似
       2.Struts2的from标签自动省成本一个table，以进行排版
       3.可以对表单的提交的值进行回显:从栈顶对象开始匹配属性，并把匹配的值赋到对应的标签的value中，若栈顶对象没有对应的属性，则依次向下找相应的属性
       4.
     -->
	<s:form action="save" method="get">
		<s:hidden name="userId"></s:hidden>
		<s:textfield name="useName" label="UseName"></s:textfield>
		<s:password name="password" label="Password"></s:password>
		<s:textarea name="desc" label="Desc"></s:textarea>
		<s:checkbox name="married" label="Married"></s:checkbox>
	<s:radio name="gender" list="#{'1':'Male','0':'Female' }" label="Gender"></s:radio>
	<!-- 服务端需要使用集合类型以保证能够正常的的回显 -->
	<s:checkboxlist name="city" list="#request.cities" listKey="cityId" listValue="cityName" label="City" ></s:checkboxlist>
	
	<s:select list="{11,12,13,14,15,16,71,18,19,20}"
	     headerKey=""
	     headerValue="请选择"
	     name="age"
	     label="Age">
	     <!-- s:optgroup用于s:select的子标签，用于显示更多的下拉框，必须使用键值对，而不能用一个集合 -->
	     <s:optgroup label="21-30" list="#{21:21,22:22,23:23}" ></s:optgroup>
	     <s:optgroup label="31-34" list="#{31:31}"></s:optgroup>
	</s:select>
	<s:submit></s:submit>
	</s:form>
	<br><br>
</body>
</html>