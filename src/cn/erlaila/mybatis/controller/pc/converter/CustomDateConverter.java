package cn.erlaila.mybatis.controller.pc.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
public class CustomDateConverter implements Converter<String,Date>{

	@Override
	public Date convert(String source) {		
	
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");	
		
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd hh");
		
		int n=source.length();
		if(n>10){
			try {
				
				return simpleDateFormat2.parse(source);
			} catch (ParseException e) {
				e.printStackTrace();
			}			
		}else{
			try {
			
						return simpleDateFormat.parse(source);
					} catch (ParseException e) {
						e.printStackTrace();
				}
		}


		return null;
	}
}


