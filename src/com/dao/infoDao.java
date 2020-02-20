package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bean.infoBean;
import com.util.DBUtil;
import com.util.StringHandle;

public class infoDao {
	public static void main(String[] args) throws SQLException {
		List<infoBean> beans=new ArrayList<infoBean>();
		beans=infoDao.select_he_city();
		for(infoBean n:beans)
		{
			System.out.println(n.getNew_Confirmed_num());
		}
	}
	static StringHandle sh=new StringHandle();
	
	public static ArrayList<infoBean> select_China_yu( String City) throws SQLException
	{
		Connection conn = DBUtil.getConn();
		ArrayList<infoBean> userBeans=new ArrayList<infoBean>();
		infoBean userBean;
		try {
			Statement state = conn.createStatement();
			String sql="select * from info where  city like '%"+City+"%' ";
			ResultSet rs = state.executeQuery(sql);
			System.out.println(sql);
			while(rs.next()) {
				//如果有结果，是认为是通过验证了
				userBean = new infoBean();
				userBean.setId(rs.getString("ID"));
				userBean.setDate(rs.getString("Date"));
				userBean.setProvince(rs.getString("Province"));
				userBean.setConfirmed_num(rs.getString("Confirmed_num"));
				
				String city=rs.getString("City");
				Pattern p = Pattern.compile(".*[州区].*");
				Matcher m = p.matcher(city);
				boolean isValid = m.matches();
				if(isValid)
				{
					userBean.setCity(city);
				}
				else
				{
					city=city+"市";
					userBean.setCity(city);
				}
				userBean.setYisi_num(rs.getString("Yisi_num"));
				userBean.setCured_num(rs.getString("Cured_num"));
				userBean.setDead_num(rs.getString("Dead_num"));
				userBean.setCode(rs.getString("Code"));
				userBeans.add(userBean);
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return userBeans;
	}
	
	
	
	
	public static ArrayList<infoBean> select_China_city( String Date) throws SQLException
	{
		Connection conn = DBUtil.getConn();
		ArrayList<infoBean> userBeans=new ArrayList<infoBean>();
		infoBean userBean;
		try {
			Statement state = conn.createStatement();
			String sql="select * from info where City !='' and Date like '%"+Date+"%' ";
			ResultSet rs = state.executeQuery(sql);
			System.out.println(sql);
			while(rs.next()) {
				//如果有结果，是认为是通过验证了
				userBean = new infoBean();
				userBean.setId(rs.getString("ID"));
				userBean.setDate(rs.getString("Date"));
				userBean.setProvince(rs.getString("Province"));
				userBean.setConfirmed_num(rs.getString("Confirmed_num"));
				
				String city=rs.getString("City");
				Pattern p = Pattern.compile(".*[州区].*");
				Matcher m = p.matcher(city);
				boolean isValid = m.matches();
				if(isValid)
				{
					userBean.setCity(city);
				}
				else
				{
					city=city+"市";
					userBean.setCity(city);
				}
				userBean.setYisi_num(rs.getString("Yisi_num"));
				userBean.setCured_num(rs.getString("Cured_num"));
				userBean.setDead_num(rs.getString("Dead_num"));
				userBean.setCode(rs.getString("Code"));
				userBeans.add(userBean);
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return userBeans;
	}
	
	public static ArrayList<infoBean> select_he_city( ) throws SQLException
	{
		Connection conn = DBUtil.getConn();
		ArrayList<infoBean> userBeans=new ArrayList<infoBean>();
		List<String> lists=new ArrayList<String>();
		infoBean userBean;
		String test="";
		try {
			Statement state = conn.createStatement();
			String sql="select * from hebei_city_info";
			ResultSet rs = state.executeQuery(sql);
			System.out.println(sql);
			while(rs.next()) {
				//如果有结果，是认为是通过验证了
				userBean = new infoBean();
				userBean.setId(rs.getString("ID"));
				userBean.setDate(rs.getString("Date"));
				userBean.setCity(rs.getString("City"));
				
				
				
				lists=sh.getExpString("([0-9]+)",rs.getString("New_Confirmed_num") );
				if(lists.size()>0)
				{
					test=lists.get(0);
				}
				else
				{
					test="0";
				}
				userBean.setNew_Confirmed_num(test);
				

				
				lists=sh.getExpString("([0-9]+)",rs.getString("Confirmed_num") );
				if(lists.size()>0)
				{
					test=lists.get(0);
				}
				else
				{
					test="0";
				}
				userBean.setConfirmed_num(test);
				
				lists=sh.getExpString("([0-9]+)",rs.getString("Dead_num") );
				if(lists.size()>0)
				{
					test=lists.get(0);
				}
				else
				{
					test="0";
				}
				userBean.setDead_num(test);
				
				lists=sh.getExpString("([0-9]+)",rs.getString("Zhong_num") );
				if(lists.size()>0)
				{
					test=lists.get(0);
				}
				else
				{
					test="0";
				}
				userBean.setZhong_num(test);
				
				lists=sh.getExpString("([0-9]+)",rs.getString("Cured_num") );
				if(lists.size()>0)
				{
					test=lists.get(0);
				}
				else
				{
					test="0";
				}
				userBean.setCured_num(test);
				
				
				userBean.setUrl(rs.getString("Url"));
				userBeans.add(userBean);
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return userBeans;
	}
	
	public static ArrayList<infoBean> select_he_city_one(String city) throws SQLException
	{
		Connection conn = DBUtil.getConn();
		ArrayList<infoBean> userBeans=new ArrayList<infoBean>();
		List<String> lists=new ArrayList<String>();
		infoBean userBean;
		String test="";
		try {
			Statement state = conn.createStatement();
			String sql="select * from hebei_city_info where City like '%"+city+"%' ";
			ResultSet rs = state.executeQuery(sql);
			System.out.println(sql);
			while(rs.next()) {
				//如果有结果，是认为是通过验证了
				userBean = new infoBean();
				userBean.setId(rs.getString("ID"));
				userBean.setDate(rs.getString("Date"));
				userBean.setCity(rs.getString("City"));
				
				
				
				lists=sh.getExpString("([0-9]+)",rs.getString("New_Confirmed_num") );
				if(lists.size()>0)
				{
					test=lists.get(0);
				}
				else
				{
					test="0";
				}
				userBean.setNew_Confirmed_num(test);
				

				
				lists=sh.getExpString("([0-9]+)",rs.getString("Confirmed_num") );
				if(lists.size()>0)
				{
					test=lists.get(0);
				}
				else
				{
					test="0";
				}
				userBean.setConfirmed_num(test);
				
				lists=sh.getExpString("([0-9]+)",rs.getString("Dead_num") );
				if(lists.size()>0)
				{
					test=lists.get(0);
				}
				else
				{
					test="0";
				}
				userBean.setDead_num(test);
				
				lists=sh.getExpString("([0-9]+)",rs.getString("Zhong_num") );
				if(lists.size()>0)
				{
					test=lists.get(0);
				}
				else
				{
					test="0";
				}
				userBean.setZhong_num(test);
				
				lists=sh.getExpString("([0-9]+)",rs.getString("Cured_num") );
				if(lists.size()>0)
				{
					test=lists.get(0);
				}
				else
				{
					test="0";
				}
				userBean.setCured_num(test);
				
				
				userBean.setUrl(rs.getString("Url"));
				userBeans.add(userBean);
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return userBeans;
	}
	
	
	public static ArrayList<infoBean> select_he_city__today(String Date) throws SQLException
	{
		Connection conn = DBUtil.getConn();
		ArrayList<infoBean> userBeans=new ArrayList<infoBean>();
		List<String> lists=new ArrayList<String>();
		infoBean userBean;
		String test="";
		try {
			Statement state = conn.createStatement();
			String sql="select * from hebei_city_info where Date like '%"+Date+"%' ";
			ResultSet rs = state.executeQuery(sql);
			System.out.println(sql);
			while(rs.next()) {
				//如果有结果，是认为是通过验证了
				userBean = new infoBean();
				userBean.setId(rs.getString("ID"));
				userBean.setDate(rs.getString("Date"));
				userBean.setCity(rs.getString("City"));
				
				
				
				lists=sh.getExpString("([0-9]+)",rs.getString("New_Confirmed_num") );
				if(lists.size()>0)
				{
					test=lists.get(0);
				}
				else
				{
					test="0";
				}
				userBean.setNew_Confirmed_num(test);
				

				
				lists=sh.getExpString("([0-9]+)",rs.getString("Confirmed_num") );
				if(lists.size()>0)
				{
					test=lists.get(0);
				}
				else
				{
					test="0";
				}
				userBean.setConfirmed_num(test);
				
				lists=sh.getExpString("([0-9]+)",rs.getString("Dead_num") );
				if(lists.size()>0)
				{
					test=lists.get(0);
				}
				else
				{
					test="0";
				}
				userBean.setDead_num(test);
				
				lists=sh.getExpString("([0-9]+)",rs.getString("Zhong_num") );
				if(lists.size()>0)
				{
					test=lists.get(0);
				}
				else
				{
					test="0";
				}
				userBean.setZhong_num(test);
				
				lists=sh.getExpString("([0-9]+)",rs.getString("Cured_num") );
				if(lists.size()>0)
				{
					test=lists.get(0);
				}
				else
				{
					test="0";
				}
				userBean.setCured_num(test);
				
				
				userBean.setUrl(rs.getString("Url"));
				userBeans.add(userBean);
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return userBeans;
	}
	
	
	public static ArrayList<String> select_he_city_date() throws SQLException
	{
		Connection conn = DBUtil.getConn();
		ArrayList<String> Dates=new ArrayList<String>();
		try {
			Statement state = conn.createStatement();
			String sql="select date from hebei_city_info group BY Date";
			ResultSet rs = state.executeQuery(sql);
			System.out.println(sql);
			while(rs.next()) {
				//如果有结果，是认为是通过验证了
				String date=new String();
				date=rs.getString("date");
				Dates.add(date);
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return Dates;
	}
	public static ArrayList<String> select_he_city_names() throws SQLException
	{
		Connection conn = DBUtil.getConn();
		ArrayList<String> Dates=new ArrayList<String>();
		try {
			Statement state = conn.createStatement();
			String sql="select city from hebei_city_info group BY city";
			ResultSet rs = state.executeQuery(sql);
			System.out.println(sql);
			while(rs.next()) {
				//如果有结果，是认为是通过验证了
				String date=new String();
				date=rs.getString("city");
				Dates.add(date);
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return Dates;
	}
	
	public static ArrayList<infoBean> select_he( ) throws SQLException
	{
		Connection conn = DBUtil.getConn();
		ArrayList<infoBean> userBeans=new ArrayList<infoBean>();
		infoBean userBean;
		List<String> lists=new ArrayList<String>();
		String test="";
		try {
			Statement state = conn.createStatement();
			String sql="select * from hebei_info";
			ResultSet rs = state.executeQuery(sql);
			System.out.println(sql);
			while(rs.next()) {
				//如果有结果，是认为是通过验证了
				userBean = new infoBean();
				userBean.setId(rs.getString("ID"));
				userBean.setDate(rs.getString("Date"));
				
				lists=sh.getExpString("([0-9]+)",rs.getString("New_Confirmed_num") );
				if(lists.size()>0)
				{
					test=lists.get(0);
				}
				else
				{
					test="0";
				}
				userBean.setNew_Confirmed_num(test);
				
				
				
				lists=sh.getExpString("([0-9]+)",rs.getString("New_Cured_num") );
				if(lists.size()>0)
				{
					test=lists.get(0);
				}
				else
				{
					test="0";
				}
				userBean.setNew_Cured_num(test);

				
				lists=sh.getExpString("([0-9]+)",rs.getString("New_Yisi_num") );
				if(lists.size()>0)
				{
					test=lists.get(0);
				}
				else
				{
					test="0";
				}
				userBean.setNew_Yisi_num(test);
				
				lists=sh.getExpString("([0-9]+)",rs.getString("Confirmed_num") );
				if(lists.size()>0)
				{
					test=lists.get(0);
				}
				else
				{
					test="0";
				}
				userBean.setConfirmed_num(test);
				
				lists=sh.getExpString("([0-9]+)",rs.getString("Dead_num") );
				if(lists.size()>0)
				{
					test=lists.get(0);
				}
				else
				{
					test="0";
				}
				userBean.setDead_num(test);
				
				lists=sh.getExpString("([0-9]+)",rs.getString("Zhong_num") );
				if(lists.size()>0)
				{
					test=lists.get(0);
				}
				else
				{
					test="0";
				}
				userBean.setZhong_num(test);
				
				lists=sh.getExpString("([0-9]+)",rs.getString("Cured_num") );
				if(lists.size()>0)
				{
					test=lists.get(0);
				}
				else
				{
					test="0";
				}
				userBean.setCured_num(test);
				
				lists=sh.getExpString("([0-9]+)",rs.getString("Yisi_num") );
				if(lists.size()>0)
				{
					test=lists.get(0);
				}
				else
				{
					test="0";
				}
				userBean.setYisi_num(test);
				
				lists=sh.getExpString("([0-9]+)",rs.getString("Miqie_num") );
				if(lists.size()>0)
				{
					test=lists.get(0);
				}
				else
				{
					test="0";
				}
				userBean.setMiqie_num(test);
				
				lists=sh.getExpString("([0-9]+)",rs.getString("None_Guan_num") );
				if(lists.size()>0)
				{
					test=lists.get(0);
				}
				else
				{
					test="0";
				}
				userBean.setNone_Guan_num(test);
				
				lists=sh.getExpString("([0-9]+)",rs.getString("Guan_num") );
				if(lists.size()>0)
				{
					test=lists.get(0);
				}
				else
				{
					test="0";
				}
				userBean.setGuan_num(test);
				
				userBean.setUrl(rs.getString("Url"));
				userBeans.add(userBean);
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return userBeans;
	}
	
	public static ArrayList<infoBean> select_China_province_yu(String name ) throws SQLException
	{
		Connection conn = DBUtil.getConn();
		ArrayList<infoBean> userBeans=new ArrayList<infoBean>();
		infoBean userBean;
		try {
			Statement state = conn.createStatement();
			String sql="select * from info where City='' and Province like '%"+name+"%'";
			ResultSet rs = state.executeQuery(sql);
			System.out.println(sql);
			while(rs.next()) {
				//如果有结果，是认为是通过验证了
				userBean = new infoBean();
				userBean.setId(rs.getString("ID"));
				userBean.setDate(rs.getString("Date"));
				userBean.setProvince(rs.getString("Province"));
				userBean.setConfirmed_num(rs.getString("Confirmed_num"));
			
				userBean.setCity(rs.getString("City"));
				userBean.setYisi_num(rs.getString("Yisi_num"));
				userBean.setCured_num(rs.getString("Cured_num"));
				userBean.setDead_num(rs.getString("Dead_num"));
				userBean.setCode(rs.getString("Code"));
				userBeans.add(userBean);
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return userBeans;
	}
	
	public static ArrayList<infoBean> select_China_province(String Date ) throws SQLException
	{
		Connection conn = DBUtil.getConn();
		ArrayList<infoBean> userBeans=new ArrayList<infoBean>();
		infoBean userBean;
		try {
			Statement state = conn.createStatement();
			String sql="select * from info where City='' and Date like '%"+Date+"%'";
			ResultSet rs = state.executeQuery(sql);
			System.out.println(sql);
			while(rs.next()) {
				//如果有结果，是认为是通过验证了
				userBean = new infoBean();
				userBean.setId(rs.getString("ID"));
				userBean.setDate(rs.getString("Date"));
				userBean.setProvince(rs.getString("Province"));
				userBean.setConfirmed_num(rs.getString("Confirmed_num"));
			
				userBean.setCity(rs.getString("City"));
				userBean.setYisi_num(rs.getString("Yisi_num"));
				userBean.setCured_num(rs.getString("Cured_num"));
				userBean.setDead_num(rs.getString("Dead_num"));
				userBean.setCode(rs.getString("Code"));
				userBeans.add(userBean);
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return userBeans;
	}
}
