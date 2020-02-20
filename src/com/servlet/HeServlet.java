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
import com.util.最小二乘法;

/**
 * Servlet implementation class HeServlet
 */
@WebServlet("/HeServlet")
public class HeServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		String method = req.getParameter("method");
		if ("he_zhu".equals(method)) {
			try {
				he_zhu(req, resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if ("city_zhu".equals(method)) {
			try {
				city_zhu(req, resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if ("city3D".equals(method)) {
			try {
				city3D(req, resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if ("he_di".equals(method)) {
			try {
				he_di(req, resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if ("he_yu".equals(method)) {
			try {
				he_yu(req, resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void he_yu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
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
		
		List<infoBean> beans=new ArrayList<infoBean>();
		beans=infoDao.select_he();
		
		List<Float> New_Confirmed_nums=new ArrayList<Float>();
		List<Float> Yu_New_Confirmed_nums=new ArrayList<Float>();
		List<Float> Confirmed_nums=new ArrayList<Float>();
		List<Float> Yu_Confirmed_nums=new ArrayList<Float>();
		
		int len=beans.size();
		float[] x =new float[len];
        float[] y =new float[len];
		for(int i=0;i<len;i++)
        {
        	x[i]=i+1;
        	y[i]=Integer.parseInt(beans.get(i).getNew_Confirmed_num());
        	New_Confirmed_nums.add(y[i]);
        	xAxisData.add(beans.get(i).getDate());
        }
		
		for(int i=0;i<len+10;i++)
		{
			if(i>len-2)
			{
				String mid=""+i;
				xAxisData.add(mid);
			}
			Yu_New_Confirmed_nums.add(最小二乘法.estimate(x, y,i));
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
			Yu_Confirmed_nums.add(最小二乘法.estimate(x, y,i));
		}
		
		
		
		
		
		
		
		
		
		
		
	
		
		
	
		
		 JSONObject job = new JSONObject();
         job.put("name", "新增确诊病例");
         job.put("type", "line");
         job.put("data",New_Confirmed_nums);  
         seriesList.add(job); 
         
         
		 job = new JSONObject();
         job.put("name", "预测新增确诊病例");
         job.put("type", "bar");
         job.put("data",Yu_New_Confirmed_nums);  
         seriesList.add(job); 
         
         job = new JSONObject();
         job.put("name", "确诊病例");
         job.put("type", "line");
         job.put("data",Confirmed_nums);  
         seriesList.add(job); 
         
         job = new JSONObject();
         job.put("name", "预测确诊病例");
         job.put("type", "bar");
         job.put("data",Yu_Confirmed_nums);  
         seriesList.add(job); 
         
         
         JSONObject jsob = new JSONObject(); 
         jsob.put("xAxis", xAxisData);  
         jsob.put("series", seriesList); 
         
		resp.setCharacterEncoding("UTF-8");
		System.out.println(jsob.toString());
  		//resp.sendRedirect(req.getContextPath() + "/admin/child/Child_11/1_Rcai.jsp");
		resp.getWriter().write(jsob.toString());
  		}

    private void he_zhu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
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
		
		List<infoBean> beans=new ArrayList<infoBean>();
		beans=infoDao.select_he();
		
		List<Integer> New_Confirmed_nums=new ArrayList<Integer>();
		List<Integer> New_Cured_nums=new ArrayList<Integer>();
		List<Integer> New_Yisi_nums=new ArrayList<Integer>();
		List<Integer> Confirmed_nums=new ArrayList<Integer>();
		List<Integer> Dead_nums=new ArrayList<Integer>();
		List<Integer> Zhong_nums=new ArrayList<Integer>();
		List<Integer> Cured_nums=new ArrayList<Integer>();
		List<Integer> Yisi_nums=new ArrayList<Integer>();
		List<Integer> Miqie_nums=new ArrayList<Integer>();
		List<Integer> None_Guan_nums=new ArrayList<Integer>();
		List<Integer> Guan_nums=new ArrayList<Integer>();
		
		for(infoBean n:beans)
		{
			String str=n.getDate();
			xAxisData.add(str);
			int New_Confirmed_num=Integer.parseInt(n.getNew_Confirmed_num());
			New_Confirmed_nums.add(New_Confirmed_num);
			int New_Cured_num=Integer.parseInt(n.getNew_Cured_num());
			New_Cured_nums.add(New_Cured_num);
			int New_Yisi_num=Integer.parseInt(n.getNew_Yisi_num());
			New_Yisi_nums.add(New_Yisi_num);
			int Confirmed_num=Integer.parseInt(n.getConfirmed_num());
			Confirmed_nums.add(Confirmed_num);
			int Dead_num=Integer.parseInt(n.getDead_num());
			Dead_nums.add(Dead_num);
			int Zhong_num=Integer.parseInt(n.getZhong_num());
			Zhong_nums.add(Zhong_num);
			int Cured_num=Integer.parseInt(n.getCured_num());
			Cured_nums.add(Cured_num);
			int Yisi_num=Integer.parseInt(n.getYisi_num());
			Yisi_nums.add(Yisi_num);
			int Miqie_num=Integer.parseInt(n.getMiqie_num());
			Miqie_nums.add(Miqie_num);
			int None_Guan_num=Integer.parseInt(n.getNone_Guan_num());
			None_Guan_nums.add(None_Guan_num);
			int Guan_num=Integer.parseInt(n.getGuan_num());
			Guan_nums.add(Guan_num);
			
			
		}
		
		
	
		
		 JSONObject job = new JSONObject();
         job.put("name", "新增确诊病例");
         job.put("type", "bar");
         job.put("data",New_Confirmed_nums);  
         seriesList.add(job); 
         
         
		 job = new JSONObject();
         job.put("name", "新增治愈病例");
         job.put("type", "bar");
         job.put("data",New_Cured_nums);  
         seriesList.add(job); 
         
         job = new JSONObject();
         job.put("name", "新增疑似病例");
         job.put("type", "bar");
         job.put("data",New_Yisi_nums);  
         seriesList.add(job); 
         
         job = new JSONObject();
         job.put("name", "确诊病例");
         job.put("type", "bar");
         job.put("data",Confirmed_nums);  
         seriesList.add(job); 
         
         job = new JSONObject();
         job.put("name", "死亡病例");
         job.put("type", "bar");
         job.put("data",Dead_nums);  
         seriesList.add(job); 
         
         job = new JSONObject();
         job.put("name", "重症病例");
         job.put("type", "bar");
         job.put("data",Zhong_nums);  
         seriesList.add(job); 
         
         job = new JSONObject();
         job.put("name", "治愈病例");
         job.put("type", "bar");
         job.put("data",Cured_nums);  
         seriesList.add(job); 
         
         job = new JSONObject();
         job.put("name", "疑似病例");
         job.put("type", "bar");
         job.put("data",Yisi_nums);  
         seriesList.add(job); 
         
         job = new JSONObject();
         job.put("name", "密切接触者");
         job.put("type", "bar");
         job.put("data",Miqie_nums);  
         seriesList.add(job); 
         
         job = new JSONObject();
         job.put("name", "解除隔离医学观察");
         job.put("type", "bar");
         job.put("data",None_Guan_nums);  
         seriesList.add(job); 
         
         job = new JSONObject();
         job.put("name", "隔离医学观察");
         job.put("type", "bar");
         job.put("data",Guan_nums);  
         seriesList.add(job); 
         
         JSONObject jsob = new JSONObject(); 
         jsob.put("xAxis", xAxisData);  
         jsob.put("series", seriesList); 
         
		resp.setCharacterEncoding("UTF-8");
		System.out.println(jsob.toString());
  		//resp.sendRedirect(req.getContextPath() + "/admin/child/Child_11/1_Rcai.jsp");
		resp.getWriter().write(jsob.toString());
  		}
    
    private void city_zhu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
  		// TODO Auto-generated method stub
  		//response.getWriter().append("Served at: ").append(request.getContextPath());
  		req.setCharacterEncoding("utf-8");
  		resp.setContentType("text/html;charset=utf-8");
  		HttpSession session=req.getSession();
  		PrintWriter out=resp.getWriter();
		System.out.println("AAAAAAAAAAAAA");
		String cityname = req.getParameter("cityname");
		//resp.sendRedirect(req.getContextPath() + "/right.jsp");
		List<String> xAxisData = new ArrayList<String>();  
        List<JSONObject> seriesList = new ArrayList< JSONObject>(); 
		
		List<infoBean> beans=new ArrayList<infoBean>();
		beans=infoDao.select_he_city_one(cityname);
		
		List<Integer> New_Confirmed_nums=new ArrayList<Integer>();
		List<Integer> Confirmed_nums=new ArrayList<Integer>();
		List<Integer> Dead_nums=new ArrayList<Integer>();
		List<Integer> Zhong_nums=new ArrayList<Integer>();
		List<Integer> Cured_nums=new ArrayList<Integer>();
		
		for(infoBean n:beans)
		{
			String str=n.getDate();
			xAxisData.add(str);
			int New_Confirmed_num=Integer.parseInt(n.getNew_Confirmed_num());
			New_Confirmed_nums.add(New_Confirmed_num);

			int Confirmed_num=Integer.parseInt(n.getConfirmed_num());
			Confirmed_nums.add(Confirmed_num);
			int Dead_num=Integer.parseInt(n.getDead_num());
			Dead_nums.add(Dead_num);
			int Zhong_num=Integer.parseInt(n.getZhong_num());
			Zhong_nums.add(Zhong_num);
			int Cured_num=Integer.parseInt(n.getCured_num());
			Cured_nums.add(Cured_num);
			

			
		}
		
		
	
		
		 JSONObject job = new JSONObject();
         job.put("name", "新增确诊病例");
         job.put("type", "bar");
         job.put("data",New_Confirmed_nums);  
         seriesList.add(job); 
         
         job = new JSONObject();
         job.put("name", "确诊病例");
         job.put("type", "bar");
         job.put("data",Confirmed_nums);  
         seriesList.add(job); 
         
         job = new JSONObject();
         job.put("name", "死亡病例");
         job.put("type", "bar");
         job.put("data",Dead_nums);  
         seriesList.add(job); 
         
         job = new JSONObject();
         job.put("name", "重症病例");
         job.put("type", "bar");
         job.put("data",Zhong_nums);  
         seriesList.add(job); 
         
         job = new JSONObject();
         job.put("name", "治愈病例");
         job.put("type", "bar");
         job.put("data",Cured_nums);  
         seriesList.add(job); 
        
         
         JSONObject jsob = new JSONObject(); 
         jsob.put("xAxis", xAxisData);  
         jsob.put("series", seriesList); 
         
		resp.setCharacterEncoding("UTF-8");
		System.out.println(jsob.toString());
  		//resp.sendRedirect(req.getContextPath() + "/admin/child/Child_11/1_Rcai.jsp");
		resp.getWriter().write(jsob.toString());
  		}
    
    private void he_di(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
  		// TODO Auto-generated method stub
  		//response.getWriter().append("Served at: ").append(request.getContextPath());
  		req.setCharacterEncoding("utf-8");
  		resp.setContentType("text/html;charset=utf-8");
  		HttpSession session=req.getSession();
  		PrintWriter out=resp.getWriter();
		System.out.println("AAAAAAAAAAAAA");
		String select_date = req.getParameter("select_date");
		//resp.sendRedirect(req.getContextPath() + "/right.jsp");
		List<String> xAxisData = new ArrayList<String>();  
        List<JSONObject> seriesList = new ArrayList< JSONObject>(); 
		
		List<infoBean> beans=new ArrayList<infoBean>();
		beans=infoDao.select_he_city__today(select_date);
		
		List<Integer> Confirmed_nums=new ArrayList<Integer>();

		
		for(infoBean n:beans)
		{
			String str=n.getDate();
			xAxisData.add(str);

			int Confirmed_num=Integer.parseInt(n.getConfirmed_num());


			
			 JSONObject job = new JSONObject();
	         job.put("name",n.getCity());
	         job.put("value",Confirmed_num);  
	         seriesList.add(job); 
			
		}
		
        
         
         JSONObject jsob = new JSONObject(); 
         jsob.put("series", seriesList); 
         
		resp.setCharacterEncoding("UTF-8");
		System.out.println(jsob.toString());
  		//resp.sendRedirect(req.getContextPath() + "/admin/child/Child_11/1_Rcai.jsp");
		resp.getWriter().write(jsob.toString());
  		}
    private void  city3D(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
  		// TODO Auto-generated method stub
  		//response.getWriter().append("Served at: ").append(request.getContextPath());
  		req.setCharacterEncoding("utf-8");
  		resp.setContentType("text/html;charset=utf-8");
  		HttpSession session=req.getSession();
  		PrintWriter out=resp.getWriter();
		System.out.println("AAAAAAAAAAAAA");
		
		List<String> xAxis3D=infoDao.select_he_city_date();

		List<String> yAxis3D = infoDao.select_he_city_names();
        List<JSONObject> seriesList = new ArrayList< JSONObject>(); 
		
		List<infoBean> beans=new ArrayList<infoBean>();
		beans=infoDao.select_he_city();
		
		

		int num=0;
		int[][] datas = new int[beans.size()*5+10][3];
		for(infoBean n:beans)
		{
			int x=0;
			int y=0;
			int z=0;
			int mid=0;
			for(String date:xAxis3D)
			{
				
				if(n.getDate().equals(date))
				{
					x=mid;
				}
				mid++;
			}
			
			mid=0;
			
			for(String city:yAxis3D)
			{
				
				if(n.getCity().equals(city))
				{
					y=mid;
				}
				mid++;
			}
			mid=0;
			
			
			z=Integer.parseInt(n.getNew_Confirmed_num());
			
			datas[num][0]=x;
			datas[num][1]=y;
			datas[num][2]=z;
			num++;
			
			z=Integer.parseInt(n.getConfirmed_num());
			datas[num][0]=x;
			datas[num][1]=y;
			datas[num][2]=z;
			num++;
			
			z=Integer.parseInt(n.getDead_num());
			datas[num][0]=x;
			datas[num][1]=y;
			datas[num][2]=z;
			num++;
			z=Integer.parseInt(n.getZhong_num());
			datas[num][0]=x;
			datas[num][1]=y;
			datas[num][2]=z;
			num++;
			z=Integer.parseInt(n.getCured_num());
			datas[num][0]=x;
			datas[num][1]=y;
			datas[num][2]=z;
			num++;
			
			
		}
		
	
	
		
		 JSONObject job = new JSONObject();
         job.put("data",datas);  
         seriesList.add(job); 

         
         JSONObject jsob = new JSONObject(); 
         jsob.put("xAxis3D", xAxis3D);  
         jsob.put("yAxis3D", yAxis3D);  
         jsob.put("series", seriesList); 
         
		resp.setCharacterEncoding("UTF-8");
		System.out.println(jsob.toString());
  		//resp.sendRedirect(req.getContextPath() + "/admin/child/Child_11/1_Rcai.jsp");
		resp.getWriter().write(jsob.toString());
  		}
}
