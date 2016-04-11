package AAA000;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DayDevice {

	public static void main(String[] args) {
		DayDevice dayDevice = new DayDevice();
		//System.out.println(dayDevice.getToday());
		//System.out.println(dayDevice.calculateAfterDate("20160404",20));
		//System.out.println(dayDevice.parse_WebtoDB("2012/01/01"));
		//System.out.println(dayDevice.parse_DBtoWeb("20120101"));
		
		//if("20">"19")
		//System.out.println();
	}
	
	public String getToday(){
		java.util.Date date = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");       
	    String strToday = sdf.format(date);       
	    return strToday;
	}
	
	public String calculateAfterDate(String strDate, int addDay){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		java.util.Date date = null;
		String strAfterDate = null;
		try {
			date = sdf.parse(strDate);
			java.util.Date afterDate = new Date(date.getTime() + 1000L*3600*24*addDay); 
			strAfterDate = sdf.format(afterDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return strAfterDate;
	}
	
	public String parse_WebtoDB(String WebDate){
		//網頁上小日曆String(格式:yyyy/MM/dd) split to yyyyMMdd
		//Data from web
		String DBDate ="";
		String[] aArray = WebDate.split("/");
		for (String d : aArray) {
			 DBDate = DBDate +d;
			        }
		return DBDate;
	}
	
	public String parse_DBtoWeb(String DBdate){
		//從資料庫抓取資料(String yyyyMMdd) 加入 "/" -->yyyy/MM/dd 
		//Data from DB
		String webDate = DBdate.substring(0, 4) + "/" + DBdate.substring(4, 6) + "/" + DBdate.substring(6, 8);
		return webDate;
	}
	
	

}
