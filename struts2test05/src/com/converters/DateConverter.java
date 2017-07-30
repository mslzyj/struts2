package com.converters;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.StrutsTypeConverter;

public class DateConverter extends StrutsTypeConverter {
	private DateFormat dateFormat;

	public DateConverter() {
		System.out.println("DateConverter...");
		
	}
	public DateFormat getDateFormat(){
		if(dateFormat == null){
			// 获取当前web应用的初始化参数pattern
			ServletContext servletContext = ServletActionContext.getServletContext();
			String pattern = servletContext.getInitParameter("pattern");
			dateFormat = new SimpleDateFormat(pattern);
		}
		return dateFormat;
	}

	// 到服务器端(由字符串转为Object)
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		System.out.println("convertFromString...");
		if (toClass == Date.class) {
			if (values != null && values.length > 0) {
				String value = values[0];

				try {
					return getDateFormat().parseObject(value);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		return values;
	}

	// 回显(由Object转为字符串)
	@Override
	public String convertToString(Map context, Object o) {
		System.out.println("convertToString...");
		if (o instanceof Date) {
			Date date = (Date) o;
			return getDateFormat().format(date);
		}
		// 若转换失败返回null；
		return null;
	}

}
