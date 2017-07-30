<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <s:debug></s:debug>
     ProductName: <s:property value="[0].productName"/>
    <br><br>
     ProductDesc: ^<s:property value="[1].productDesc"/>
    <br><br>
     ProductPrice: ${productPrice}
    <br><br>
    <!-- 用property标签显示值栈属性的值     -->
     ProductPrice: ^<s:property value="[0].productPrice"/>
    <br><br>
    
     ProductPrice: ^^<s:property value="productPrice"/>
    <br><br>
     ProductName1: ${sessionScope.product.productName }
     <s:property value="#session.product.productName"/>
    <br><br>
     ProductName2: ${ requestScope.test.productName }
     <s:property value="#request.test.productName"/>
    <br><br>
    
    <!-- 使用OGNl调用public 类的public类型的静态字段和静态方法 -->
    <s:property value="@java.lang.Math@PI"/>
    <br><br>
    <s:property value ="@java.lang.Math@cos(0)"/>
      <br><br>
      <s:property value ="productName"/>
      <br><br>
     <!-- 调用对象栈的方法为一个属性赋值 --> 
   <s:property value="setProductName('调用对象栈的方法为一个属性赋值')" />
    <s:property value ="productName"/>
    <br><br>
    <!-- OGNL访问数组中元素的个数 （调用数组对象的属性）-->
    <%
      String [] names = new String[]{"a","b","c","d"};
      request.setAttribute("names", names);
    %>
    length:<s:property value="#attr.names.length"/> 
    <br><br>
    names[2]: <s:property value="#attr.names[2]"/> 
    <br><br>
    <%
    java.util.Map<String,String> letters=new HashMap<String,String>();
    request.setAttribute("letters", letters);
    letters.put("A","a");
    letters.put("B","b");
    letters.put("C","c");
    letters.put("D","d");
    %>
    <!-- 使用OGNL访问Map -->
     Size:<s:property value="#attr.letters.size"/>
     <br><br>
     A: <s:property value="#attr.letters['A']"/>
     <br><br>
</body>
</html>