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
			// ��ȡ��ǰwebӦ�õĳ�ʼ������pattern
			ServletContext servletContext = ServletActionContext.getServletContext();
			String pattern = servletContext.getInitParameter("pattern");
			dateFormat = new SimpleDateFormat(pattern);
		}
		return dateFormat;
	}

	// ����������(���ַ���תΪObject)
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

	// ����(��ObjectתΪ�ַ���)
	@Override
	public String convertToString(Map context, Object o) {
		System.out.println("convertToString...");
		if (o instanceof Date) {
			Date date = (Date) o;
			return getDateFormat().format(date);
		}
		// ��ת��ʧ�ܷ���null��
		return null;
	}

}
