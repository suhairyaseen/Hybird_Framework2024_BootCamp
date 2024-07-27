package com.BootCamp.Part2.Utility;

import java.util.Date;

public class Utility {
	
	
	
	public static String emailStampTime() {
		Date date = new Date();
		String stamptime = date.toString().replace(" " , "_").replace(":","_");
		return "sosocat" + stamptime + "@gmail.com";
		
	}
	public static final int implicitly_TimeOut = 10;
	public static final int setPageLoad_TimeOut = 10;
	public static final int script_TimeOut = 10;

}
