package com.liuning.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.core.convert.converter.Converter;

/**
 * @Description 全局日期转换器
 * @author	刘宁
 * @date	2017-11-1晚上20:11:14
 * @version 1.0
 */
public class CustomDateConverter implements Converter<String,java.sql.Date>{

	@Override
	public java.sql.Date convert(String source) {
		
		//实现 将日期串转成日期类型(格式是yyyy-MM-dd HH:mm:ss)
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			//转成直接返回
			return new java.sql.Date(simpleDateFormat.parse(source).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//如果参数绑定失败返回null
		return null;
	}

}
