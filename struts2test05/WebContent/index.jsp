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
   <!-- 
   1.如何覆盖默认的错误消:
               （1）在对应的Action类所在的包中新建ActionClassName.properties文件，即为包含着输入字段
     Action类的类名。
               （2）在属性文件中添加如下键值对：invalid.fildvalue.fildName=xxx
   2.如果是simple主题，则不显示错误消息，可以通过标签的方式显示错误消息
               （1）通过debug标签，可知若转换出错，则在值栈的Action（实现了ValidationArare接口）对象中有一个fieldErrors属性，
          该属性的类型为Map<String,List<String>>键值对，键：属性名，值：错误消息组成的List，所以可以使用LE或OGNL的方式显示错误消息
    ${fieldErrors.age[0]}   
              （2）还可以使用s:fieldErrors标签来显示，可以通过fieldName属性指定字段的错误。
   3.若是simple主题，且使用<s:fielderror fieldName="age"></s:fielderror>来显示错误消息，则该消息在一个ul,
      li,span中，则需要去除ul，li,span如下：
       在template.simple下面的fielderror.ftl定义了simple主题，s:fieldError标签显示错误的样式，所以修改该配置文件即可：
       修改： 在src下新建 template.simple包，新建fielderror.ftl文件，把原来的fielderror.ftl中的内容复制到新建的fielderror.ftl
       中，去除ul.li,span即可。
   4.自定义类型转换器：
     （1）因为struts不能自动完成字符串到引用类型的转换
     （2）定义类型转换器：
     I.开发类型转化器的类：扩展StrutsTypeConverter类
     II.配置类型准唤起：
       有两种方法：
       1.基于字段的配置：
         >在字段所在的Model(可能是Action，可能是一个javaBean)的包下，新建一个modelClassName-conversion.properties
         
         >在该文件中输入键值对：fieldName=类型转换器的全类名
       2.基于类型的配置：
         >在src下新建xwork-conversion.properties
         >键入：待转换的类型=类型转换器的全类名
         >在当前Struts2应用被加载时创建实例
    (3).转换器是单实例的。
    -->
    <s:debug></s:debug>
    
    <s:form action="testConversion" theme="simple">
       Age:<s:textfield name="age" label="Age"></s:textfield>
       ${fieldErrors.age[0] }
       <s:fielderror fieldName="age"></s:fielderror>
        <br><br>
      Birth: <s:textfield name="birth"></s:textfield>
      <s:fielderror fieldName="birth"></s:fielderror>
       <br><br>
      <s:submit></s:submit>
    </s:form>
</body>
</html>