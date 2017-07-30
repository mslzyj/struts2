<%@page import="com.struts2test03.PersonComparator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.struts2test03.Person"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <s:debug></s:debug>
    <%
          session.setAttribute("date",new Date() );
        
    %>
   <br><br>
   s:property:打印值栈中的属性的值的，对于对象栈，打印值栈中对应对象的属性的值的。
   <br><br>
   <s:property value="[0].propertyName"/>
   <br><br>
        对于Map栈,打印request,session,application的某个属性值或某个请求参数的值
        <br><br>
        <s:property value="#session.date"/>
        <br><br>
       
        
        s:url:创建一个URL字符串
        <br><br>
        <s:url value="/getProduct" var="url" >
        <!-- 指定url包含的请求参数，1001不可能是一个属性名，struts2把1001直接作为属性值 -->
          <s:param name="productId" value="1001"></s:param>
        </s:url>
        ${url }
        <br><br>
        
        
       <s:url value="/getProduct" var="url2" >
       <!-- 对于value值会自动的进行OGNl解析 -->
          <s:param name="productId" value="productId"></s:param>
          <s:param name="date" value="#session.date"></s:param>
          
        </s:url>
        ${url2 }
        <br><br>
        
       <s:url value="/getProduct" var="url3" >
       <!-- 对于value值会自动的进行OGNl解析 ，若不需要自动进行解析，则加上单引号-->
          <s:param name="productId" value=" 'abcde' "></s:param>
        </s:url>
        ${url3 }
        <br><br>
        
        
        <!-- 构建一个请求Action的地址 -->
        <s:url action="testAction" namespace="/helloWord" method="save" var="url4"></s:url>
        ${url4 }
        <br><br>
        
         <s:url value="testUrl" var="url5" includeParams="all"></s:url>     
        ${url5 }
        <br><br>
        s:set：指向page，request，session，application域中加入一个属性值
        <br><br>
        
        <!-- 对value属性进行自动的OGNL解析 -->
        <s:set name="productName" value="productName" scope="request"></s:set>
        productName:${requestScope.productName }
        <br><br>
        
        
       
        s:push:把一个标签对象再标签开始压入到值栈中，标签结束时，弹出值栈
        <%
          Person person = new Person();
          person.setName("xian");
          person.setAge(10);
          request.setAttribute("person", person);
        %>
        <s:push value="#request.person">
          ${name }
        </s:push>
        <br><br>
      
        s:if,s:else,s:elseif:
        <br><br>
        <s:if test="productPrice>100">大于1000</s:if>
        <s:elseif test="productPrice>800">大于800</s:elseif>
        <s:else> 其他</s:else>
        <br><br>
        s:iterator:遍历集合,会把遍历的集合依次压入弹出栈
        <br><br>
        <%
        java.util.List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("C",10));
        persons.add(new Person("B",10));
        persons.add(new Person("D",10));
        persons.add(new Person("A",10));
        request.setAttribute("persons", persons);
        %>
        <s:iterator value="#request.persons" status="status">
          index:${stauts.index }-count:${status.count }:${name }-${age }
        </s:iterator>
        <br><br>
       
        <s:iterator value="persons" >
          ${name }-${age }
        </s:iterator>
        <br><br>
        s:sort：可以对集合中的元素进行排序
        <br><br>
        <%
          PersonComparator pc=new PersonComparator();
          request.setAttribute("comparator", pc);
        %>
        <s:sort comparator="#request.comparator"  source="persons" var="persons2"></s:sort>
        <s:iterator value="#attr.persons2">
        
        ${name }-${age }<br>
        </s:iterator>
        <br><br>
        s:date可以对date对象进行排版
        <br><br>
        <s:date name="#session.date" format="yyyy-MM-dd hh:mm:ss"/>
        date:${date2 }
        <br><br>
        a:标签
        <br><br>
        <s:iterator value="persons">
        <!-- 可以使用%{}将属性包装起来，使其进行强制的OGNL解析 -->
           <s:a href="getPerson.action?name=%{name}">${name }</s:a>
        </s:iterator>
        <br><br>
</body>
</html>