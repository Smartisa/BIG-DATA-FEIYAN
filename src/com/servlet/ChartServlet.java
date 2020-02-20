package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.bean.infoBean;
import com.dao.infoDao;
import com.util.×îÐ¡¶þ³Ë·¨;

/**
 * Servlet implementation class ChartServlet
 */
@WebServlet("/ChartServlet")
public class ChartServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		String method = req.getParameter("method");
		if ("china_zhu".equals(method)) {
			try {
				china_zhu(req, resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if ("china_city_zhu".equals(method)) {
			try {
				china_city_zhu(req, resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if ("china_shan".equals(method)) {
			try {
				china_shan(req, resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if ("city_shan".equals(method)) {
			try {
				city_shan(req, resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if ("china_map".equals(method)) {
			try {
				china_map(req, resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if ("china_yu".equals(method)) {
			try {
				china_yu(req, resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if ("china_yu_province".equals(method)) {
			try {
				china_yu_province(req, resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    private void china_yu_province(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
  		// TODO Auto-generated method stub
  		//response.getWriter().append("Served at: ").append(request.getContextPath());
  		req.setCharacterEncoding("utf-8");
  		resp.setContentType("text/html;charset=utf-8");
  		HttpSession session=req.getSession();
  		PrintWriter out=resp.getWriter();
		System.out.println("AAAAAAAAAAAAA");
		//resp.sendRedirect(req.getContextPath() + "/right.jsp");
		List<String> xAxisData = new ArrayList<String>();  
		
        List<JSONObject> seriesList = new ArrayList< JSONObject>(); 
		
        String Yu_province = req.getParameter("Yu_province");
		List<infoBean> beans=new ArrayList<infoBean>();
		beans=infoDao.select_China_province_yu(Yu_province);
		
		List<Float> Cured_nums=new ArrayList<Float>();
		List<Float> Yu_Cured_nums=new ArrayList<Float>();
		List<Float> Confirmed_nums=new ArrayList<Float>();
		List<Float> Yu_Confirmed_nums=new ArrayList<Float>();
		
		int len=beans.size();
		float[] x =new float[len];
        float[] y =new float[len];
		for(int i=0;i<len;i++)
        {
        	x[i]=i+1;
        	y[i]=Integer.parseInt(beans.get(i).getCured_num());
        	Cured_nums.add(y[i]);
        	xAxisData.add(beans.get(i).getDate());
        }
		
		for(int i=0;i<len+10;i++)
		{
			if(i>len-2)
			{
				String mid=""+i;
				xAxisData.add(mid);
			}
			Yu_Cured_nums.add(×îÐ¡¶þ³Ë·¨.estimate(x, y,i));
		}
		
		x =new float[len];
		y =new float[len];
		for(int i=0;i<len;i++)
        {
        	x[i]=i+1;
        	y[i]=Integer.parseInt(beans.get(i).getConfirmed_num());
        	Confirmed_nums.add(y[i]);
        }
		
		for(int i=0;i<len+10;i++)
		{
			Yu_Confirmed_nums.add(×îÐ¡¶þ³Ë·¨.estimate(x, y,i));
		}
		
		
		
		
		
		
		
		
		
		
		
	
		
		
	
		JSONObject job = new JSONObject();

         
        
         job.put("name", "È·Õï²¡Àý");
         job.put("type", "line");
         job.put("data",Confirmed_nums);  
         seriesList.add(job); 
         
         job = new JSONObject();
         job.put("name", "Ô¤²âÈ·Õï²¡Àý");
         job.put("type", "bar");
         job.put("data",Yu_Confirmed_nums);  
         seriesList.add(job); 
         
         job = new JSONObject();
         job.put("name", "ÖÎÓú²¡Àý");
         job.put("type", "line");
         job.put("data",Cured_nums);  
         seriesList.add(job); 
         
         
		 job = new JSONObject();
         job.put("name", "Ô¤²âÖÎÓú²¡Àý");
         job.put("type", "bar");
         job.put("data",Yu_Cured_nums);  
         seriesList.add(job); 
         
         JSONObject jsob = new JSONObject(); 
         jsob.put("xAxis", xAxisData);  
         jsob.put("series", seriesList); 
         
		resp.setCharacterEncoding("UTF-8");
		System.out.println(jsob.toString());
  		//resp.sendRedirect(req.getContextPath() + "/admin/child/Child_11/1_Rcai.jsp");
		resp.getWriter().write(jsob.toString());
  		}
    
    private void china_yu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
  		// TODO Auto-generated method stub
  		//response.getWriter().append("Served at: ").append(request.getContextPath());
  		req.setCharacterEncoding("utf-8");
  		resp.setContentType("text/html;charset=utf-8");
  		HttpSession session=req.getSession();
  		PrintWriter out=resp.getWriter();
		System.out.println("AAAAAAAAAAAAA");
		//resp.sendRedirect(req.getContextPath() + "/right.jsp");
		List<String> xAxisData = new ArrayList<String>();  
		
        List<JSONObject> seriesList = new ArrayList< JSONObject>(); 
		
        String yu_city = req.getParameter("yu_city");
		List<infoBean> beans=new ArrayList<infoBean>();
		beans=infoDao.select_China_yu(yu_city);
		
		List<Float> Cured_nums=new ArrayList<Float>();
		List<Float> Yu_Cured_nums=new ArrayList<Float>();
		List<Float> Confirmed_nums=new ArrayList<Float>();
		List<Float> Yu_Confirmed_nums=new ArrayList<Float>();
		
		int len=beans.size();
		float[] x =new float[len];
        float[] y =new float[len];
		for(int i=0;i<len;i++)
        {
        	x[i]=i+1;
        	y[i]=Integer.parseInt(beans.get(i).getCured_num());
        	Cured_nums.add(y[i]);
        	xAxisData.add(beans.get(i).getDate());
        }
		
		for(int i=0;i<len+10;i++)
		{
			if(i>len-2)
			{
				String mid=""+i;
				xAxisData.add(mid);
			}
			Yu_Cured_nums.add(×îÐ¡¶þ³Ë·¨.estimate(x, y,i));
		}
		
		x =new float[len];
		y =new float[len];
		for(int i=0;i<len;i++)
        {
        	x[i]=i+1;
        	y[i]=Integer.parseInt(beans.get(i).getConfirmed_num());
        	Confirmed_nums.add(y[i]);
        }
		
		for(int i=0;i<len+10;i++)
		{
			Yu_Confirmed_nums.add(×îÐ¡¶þ³Ë·¨.estimate(x, y,i));
		}
		
		
		
		
		
		
		
		
		
		
		
	
		
		
	
		JSONObject job = new JSONObject();

         
        
         job.put("name", "È·Õï²¡Àý");
         job.put("type", "line");
         job.put("data",Confirmed_nums);  
         seriesList.add(job); 
         
         job = new JSONObject();
         job.put("name", "Ô¤²âÈ·Õï²¡Àý");
         job.put("type", "bar");
         job.put("data",Yu_Confirmed_nums);  
         seriesList.add(job); 
         
         job = new JSONObject();
         job.put("name", "ÖÎÓú²¡Àý");
         job.put("type", "line");
         job.put("data",Cured_nums);  
         seriesList.add(job); 
         
         
		 job = new JSONObject();
         job.put("name", "Ô¤²âÖÎÓú²¡Àý");
         job.put("type", "bar");
         job.put("data",Yu_Cured_nums);  
         seriesList.add(job); 
         
         JSONObject jsob = new JSONObject(); 
         jsob.put("xAxis", xAxisData);  
         jsob.put("series", seriesList); 
         
		resp.setCharacterEncoding("UTF-8");
		System.out.println(jsob.toString());
  		//resp.sendRedirect(req.getContextPath() + "/admin/child/Child_11/1_Rcai.jsp");
		resp.getWriter().write(jsob.toString());
  		}

    private void china_zhu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
  		// TODO Auto-generated method stub
  		//response.getWriter().append("Served at: ").append(request.getContextPath());
  		req.setCharacterEncoding("utf-8");
  		resp.setContentType("text/html;charset=utf-8");
  		HttpSession session=req.getSession();
  		PrintWriter out=resp.getWriter();
		System.out.println("AAAAAAAAAAAAA");
		//resp.sendRedirect(req.getContextPath() + "/right.jsp");
		List<String> xAxisData = new ArrayList<String>();  
        List<JSONObject> seriesList = new ArrayList< JSONObject>(); 
		String Date=req.getParameter("Date");
		List<infoBean> beans=new ArrayList<infoBean>();
		beans=infoDao.select_China_province(Date);
		for(infoBean n:beans)
		{
			String str=n.getProvince();
			xAxisData.add(str);
		}
		List<Integer> list_confirmed=new ArrayList<Integer>();
		
		for(infoBean n:beans)
		{
			int num_confirmed=Integer.parseInt(n.getConfirmed_num());
			list_confirmed.add(num_confirmed);
		}
		
		
		List<Integer> list_cured=new ArrayList<Integer>();
		
		for(infoBean n:beans)
		{
			int num_cured=Integer.parseInt(n.getCured_num());
			list_cured.add(num_cured);
		}
		
		List<Integer> list_dead=new ArrayList<Integer>();
		
		for(infoBean n:beans)
		{
			System.out.println(n.getDead_num());
			int num_dead;
			if(n.getDead_num().equals(""))
			{
				num_dead=0;
			}
			else
			{
				
				num_dead=Integer.parseInt(n.getDead_num());	
			}
			
			list_dead.add(num_dead);
		}
		
		
		 JSONObject job = new JSONObject();
         job.put("name", "È·Õï²¡Àý");
         job.put("type", "bar");
         job.put("data",list_confirmed);  
         seriesList.add(job); 
         
         
		 job = new JSONObject();
         job.put("name", "ÖÎÓú²¡Àý");
         job.put("type", "bar");
         job.put("data",list_cured);  
         seriesList.add(job); 
         
         job = new JSONObject();
         job.put("name", "ËÀÍö²¡Àý");
         job.put("type", "bar");
         job.put("data",list_dead);  
         seriesList.add(job); 
         
         JSONObject jsob = new JSONObject(); 
         jsob.put("xAxis", xAxisData);  
         jsob.put("series", seriesList); 
         
		resp.setCharacterEncoding("UTF-8");
		System.out.println(jsob.toString());
  		//resp.sendRedirect(req.getContextPath() + "/admin/child/Child_11/1_Rcai.jsp");
		resp.getWriter().write(jsob.toString());
  		}

    
    
    private void china_city_zhu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
  		// TODO Auto-generated method stub
  		//response.getWriter().append("Served at: ").append(request.getContextPath());
  		req.setCharacterEncoding("utf-8");
  		resp.setContentType("text/html;charset=utf-8");
  		HttpSession session=req.getSession();
  		PrintWriter out=resp.getWriter();
		System.out.println("AAAAAAAAAAAAA");
		//resp.sendRedirect(req.getContextPath() + "/right.jsp");
		List<String> xAxisData = new ArrayList<String>();  
        List<JSONObject> seriesList = new ArrayList< JSONObject>(); 
		String Date=req.getParameter("Date");
		List<infoBean> beans=new ArrayList<infoBean>();
		beans=infoDao.select_China_city(Date);
		
		for(infoBean n:beans)
		{
			String str=n.getCity();
			xAxisData.add(str);
		}
		
		List<Integer> list_confirmed=new ArrayList<Integer>();
		
		for(infoBean n:beans)
		{
			int num_confirmed=Integer.parseInt(n.getConfirmed_num());
			list_confirmed.add(num_confirmed);
		}
		
		
		List<Integer> list_cured=new ArrayList<Integer>();
		
		for(infoBean n:beans)
		{
			int num_cured=Integer.parseInt(n.getCured_num());
			list_cured.add(num_cured);
		}
		
		List<Integer> list_dead=new ArrayList<Integer>();
		
		for(infoBean n:beans)
		{
			System.out.println(n.getDead_num());
			int num_dead;
			if(n.getDead_num().equals(""))
			{
				num_dead=0;
			}
			else
			{
				
				num_dead=Integer.parseInt(n.getDead_num());	
			}
			
			list_dead.add(num_dead);
		}
		
		
		 JSONObject job = new JSONObject();
         job.put("name", "È·Õï²¡Àý");
         job.put("type", "bar");
         job.put("data",list_confirmed);  
         seriesList.add(job); 
         
         
		 job = new JSONObject();
         job.put("name", "ÖÎÓú²¡Àý");
         job.put("type", "bar");
         job.put("data",list_cured);  
         seriesList.add(job); 
         
         job = new JSONObject();
         job.put("name", "ËÀÍö²¡Àý");
         job.put("type", "bar");
         job.put("data",list_dead);  
         seriesList.add(job); 
         
         JSONObject jsob = new JSONObject(); 
         jsob.put("xAxis", xAxisData);  
         jsob.put("series", seriesList); 
         
		resp.setCharacterEncoding("UTF-8");
		System.out.println(jsob.toString());
  		//resp.sendRedirect(req.getContextPath() + "/admin/child/Child_11/1_Rcai.jsp");
		resp.getWriter().write(jsob.toString());
  		}
    
    private void china_shan(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
  		// TODO Auto-generated method stub
  		//response.getWriter().append("Served at: ").append(request.getContextPath());
  		req.setCharacterEncoding("utf-8");
  		resp.setContentType("text/html;charset=utf-8");
  		HttpSession session=req.getSession();
  		PrintWriter out=resp.getWriter();
		System.out.println("AAAAAAAAAAAAA");
		//resp.sendRedirect(req.getContextPath() + "/right.jsp");
        
		String Date=req.getParameter("Date");
		List<infoBean> beans=new ArrayList<infoBean>();
		beans=infoDao.select_China_province(Date);
		
		
		List<JSONObject> seriesList_confirmed = new ArrayList< JSONObject>(); 
		
		for(infoBean n:beans)
		{
			JSONObject job = new JSONObject();
	         job.put("name", n.getProvince());
	         job.put("value", n.getConfirmed_num());
			seriesList_confirmed.add(job);
		}
		
		
		List<JSONObject> seriesList_cured= new ArrayList< JSONObject>(); 
		
		for(infoBean n:beans)
		{
			JSONObject job = new JSONObject();
	         job.put("name", n.getProvince());
	         job.put("value", n.getCured_num());
	         seriesList_cured.add(job);
		}
		
		List<JSONObject> seriesList_dead= new ArrayList< JSONObject>(); 
		List<String> names=new ArrayList<String>();
		for(infoBean n:beans)
		{
			JSONObject job = new JSONObject();
	         job.put("name", n.getProvince());
	         
	         names.add(n.getProvince());
	         
	         job.put("value", n.getDead_num());
	         seriesList_dead.add(job);
		}
		
         
         JSONObject jsob = new JSONObject(); 
         jsob.put("seriesList_confirmed", seriesList_confirmed); 
         jsob.put("seriesList_cured", seriesList_cured); 
         jsob.put("seriesList_dead", seriesList_dead); 
         jsob.put("legend", names); 
		resp.setCharacterEncoding("UTF-8");
		System.out.println(jsob.toString());
  		//resp.sendRedirect(req.getContextPath() + "/admin/child/Child_11/1_Rcai.jsp");
		resp.getWriter().write(jsob.toString());
  		}
    
    private void city_shan(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
  		// TODO Auto-generated method stub
  		//response.getWriter().append("Served at: ").append(request.getContextPath());
  		req.setCharacterEncoding("utf-8");
  		resp.setContentType("text/html;charset=utf-8");
  		HttpSession session=req.getSession();
  		PrintWriter out=resp.getWriter();
		System.out.println("AAAAAAAAAAAAA");
		//resp.sendRedirect(req.getContextPath() + "/right.jsp");
        
		String Date=req.getParameter("Date");
		List<infoBean> beans=new ArrayList<infoBean>();
		beans=infoDao.select_China_city(Date);
		
		
		List<JSONObject> seriesList_confirmed = new ArrayList< JSONObject>(); 
		List<JSONObject> seriesList_cured= new ArrayList< JSONObject>(); 
		List<JSONObject> seriesList_dead= new ArrayList< JSONObject>(); 
		List<String> names=new ArrayList<String>();
		List<JSONObject> selected=new ArrayList<JSONObject>();
		int num=0;
		for(infoBean n:beans)
		{
			num++;
			JSONObject job = new JSONObject();
			if(num>50)
			{
				break;
			}
			names.add(n.getCity());
			job = new JSONObject();
	         job.put("name", n.getCity());
	         job.put("value", n.getConfirmed_num());
			seriesList_confirmed.add(job);
			job = new JSONObject();
			 job.put("name", n.getCity());
	         job.put("value", n.getCured_num());
	         seriesList_cured.add(job);
	         
	         job = new JSONObject();
			 job.put("name", n.getCity());
	         
	         
	         
	         job.put("value", n.getDead_num());
	         seriesList_dead.add(job);
		}
		
		
         
         JSONObject jsob = new JSONObject(); 
         jsob.put("seriesList_confirmed", seriesList_confirmed); 
         jsob.put("seriesList_cured", seriesList_cured); 
         jsob.put("seriesList_dead", seriesList_dead); 
         jsob.put("legend", names); 
		resp.setCharacterEncoding("UTF-8");
		System.out.println(jsob.toString());
  		//resp.sendRedirect(req.getContextPath() + "/admin/child/Child_11/1_Rcai.jsp");
		resp.getWriter().write(jsob.toString());
  		}
    
    
    private void china_map(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
  		// TODO Auto-generated method stub
  		//response.getWriter().append("Served at: ").append(request.getContextPath());
  		req.setCharacterEncoding("utf-8");
  		resp.setContentType("text/html;charset=utf-8");
  		HttpSession session=req.getSession();
  		PrintWriter out=resp.getWriter();
		System.out.println("AAAAAAAAAAAAA");
		//resp.sendRedirect(req.getContextPath() + "/right.jsp");
        String Date=req.getParameter("Date");
		
		List<infoBean> beans=new ArrayList<infoBean>();
		beans=infoDao.select_China_city(Date);
		
		
		List<JSONObject> seriesList_confirmed = new ArrayList< JSONObject>(); 
		int num=0;
		for(infoBean n:beans)
		{
			num++;
			JSONObject job = new JSONObject();
	         job.put("name", n.getCity());
	         job.put("value", n.getConfirmed_num());
			seriesList_confirmed.add(job);
			
		}
		
		
         
         JSONObject jsob = new JSONObject(); 
         jsob.put("seriesList_confirmed", seriesList_confirmed); 
		resp.setCharacterEncoding("UTF-8");
		System.out.println(jsob.toString());
  		//resp.sendRedirect(req.getContextPath() + "/admin/child/Child_11/1_Rcai.jsp");
		resp.getWriter().write(jsob.toString());
  		}
    
}
