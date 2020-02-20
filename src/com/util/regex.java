package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex {

    static String regEx="[\n`'' \" , ，]";
    static String aa="";
	public static void main(String[] args) {
		
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd");//设置日期格式
		String createTime = dateFormat.format(now);//格式化然后放入字符串中
		System.out.println(createTime);
		StringHandle sh=new StringHandle();
		String test=sh.getExpString("([0-9]+)", "11例11111").get(0);
		System.out.println(test);
				//.replaceAll("\"cityName\":", "").replaceAll(regEx, aa);
		//test=sh.getExpString("([0-9]+)", "湘西自治州").get(0);
		test="湘西自治州";
		boolean a = test.contains("州");
		System.out.println(a);
				//.replaceAll("\"cityName\":", "").replaceAll(regEx, aa);
		
		
		
	
	String str = "湘西自治";
	
	Pattern p = Pattern.compile(".*[州区].*");
	
	Matcher m = p.matcher(str);
	
	boolean isValid = m.matches();
	if(isValid)
	{
		System.out.println("AA");
	}
	System.out.println(isValid);

	}

}
