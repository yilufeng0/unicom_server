package com.cb.timestr;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStr {
	
	public static String getOptStr(Date date,String formatStr){
		SimpleDateFormat dateFormat= new SimpleDateFormat(formatStr);
		String timeStr=dateFormat.format(date);
		return timeStr;
	}
	
	public static String getDateStr(Date now){
//		Date now = new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMdd");
		String timeStr=dateFormat.format(now);
		return timeStr;
	}
	
	public static String getTimeStr(Date now){
//		Date now=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("HHmmss");
		String timeStr=dateFormat.format(now);
		return timeStr;
	}
	
	public static String getAllStr(Date now){
//		Date now= new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
		String timeStr=dateFormat.format(now);
		return timeStr;
	}
	
}
