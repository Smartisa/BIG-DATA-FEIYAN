package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex {

    static String regEx="[\n`'' \" , ��]";
    static String aa="";
	public static void main(String[] args) {
		
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd");//�������ڸ�ʽ
		String createTime = dateFormat.format(now);//��ʽ��Ȼ������ַ�����
		System.out.println(createTime);
		StringHandle sh=new StringHandle();
		String test=sh.getExpString("([0-9]+)", "11��11111").get(0);
		System.out.println(test);
				//.replaceAll("\"cityName\":", "").replaceAll(regEx, aa);
		//test=sh.getExpString("([0-9]+)", "����������").get(0);
		test="����������";
		boolean a = test.contains("��");
		System.out.println(a);
				//.replaceAll("\"cityName\":", "").replaceAll(regEx, aa);
		
		
		
	
	String str = "��������";
	
	Pattern p = Pattern.compile(".*[����].*");
	
	Matcher m = p.matcher(str);
	
	boolean isValid = m.matches();
	if(isValid)
	{
		System.out.println("AA");
	}
	System.out.println(isValid);

	}

}
