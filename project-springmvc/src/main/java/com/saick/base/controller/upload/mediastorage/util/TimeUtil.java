package com.saick.base.controller.upload.mediastorage.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

	static String YYYYMMDD="yyyyMMdd";
	
	public static String time2YYYYMMDD(Date date){
		return new SimpleDateFormat(YYYYMMDD).format(date);
	}
	
}
