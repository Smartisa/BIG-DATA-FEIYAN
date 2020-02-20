<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.Date" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" name="viewport">
  <title>Components &rsaquo; Buttons &mdash; Stisla</title>

  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/dist/modules/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/dist/modules/ionicons/css/ionicons.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/dist/modules/fontawesome/web-fonts-with-css/css/fontawesome-all.min.css">

  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/dist/css/demo.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/dist/css/style.css">
    <style  type="text/css">
   html, body
   {
   margin: 0px 0px;
   width: 100%;
   height: 100%;
   }
   
   iframe
   {
    margin: 0px 0px;
   width: 100%;
   height: 100%;
   }
  </style>
  
</head>
<%
Date now = new Date(); 
SimpleDateFormat dateFormat = new SimpleDateFormat("dd");//设置日期格式
String createTime = dateFormat.format(now);//格式化然后放入字符串中

int day=Integer.parseInt(createTime);

String China_Date1="2-"+day;
String China_Date2="2-"+(day-1);
String China_Date3="2-"+(day-2);

/*
String China_Date1="2-19";
String China_Date2="2-18";
String China_Date3="2-17";
*/
day=Integer.parseInt(createTime);

String Hebei_Date1="2月"+(day-1)+"日";
String Hebei_Date2="2月"+(day-2)+"日";
String Hebei_Date3="2月"+(day-3)+"日";
String Hebei_Date4="2月"+(day-4)+"日";
String Hebei_Date5="2月"+(day-5)+"日";
String Hebei_Date6="2月"+(day-6)+"日";
String Hebei_Date7="2月"+(day-7)+"日";
String Hebei_Date8="2月"+(day-8)+"日";
String Hebei_Date9="2月"+(day-9)+"日";

/*
String Hebei_Date1="2月18日";
String Hebei_Date2="2月17日";
String Hebei_Date3="2月16日";
String Hebei_Date4="2月15日";
String Hebei_Date5="2月14日";
String Hebei_Date6="2月13日";
String Hebei_Date7="2月12日";
String Hebei_Date8="2月11日";
String Hebei_Date9="2月10日";
*/
%>
<body>
  <div id="app" style="height: 100%">
    <div class="main-wrapper" style="height: 100%">
      <div class="navbar-bg"></div>
      <nav class="navbar navbar-expand-lg main-navbar">
      
      
        <form class="form-inline mr-auto">
          <ul class="navbar-nav mr-3">
            <li><a href="#" data-toggle="sidebar" class="nav-link nav-link-lg"><i class="ion ion-navicon-round"></i></a></li>
            <li><a href="#" data-toggle="search" class="nav-link nav-link-lg d-sm-none"><i class="ion ion-search"></i></a></li>
          </ul>
          <div class="search-element">
            <input class="form-control" type="search" placeholder="Search" aria-label="Search">
            <button class="btn" type="submit"><i class="ion ion-search"></i></button>
          </div>
        </form>
        
        <ul class="navbar-nav navbar-right">
          <li class="dropdown"><a href="#" data-toggle="dropdown" class="nav-link dropdown-toggle nav-link-lg">
            <i class="ion ion-android-person d-lg-none"></i>
            <div class="d-sm-none d-lg-inline-block">你好 博二爷</div></a>
            <div class="dropdown-menu dropdown-menu-right">
              <a href="#" class="dropdown-item has-icon">
                <i class="ion ion-android-person"></i> 我的
              </a>
              <a href="#" class="dropdown-item has-icon">
                <i class="ion ion-log-out"></i> 退出
              </a>
            </div>
          </li>
        </ul>
      </nav>
      <div class="main-sidebar">
        <aside id="sidebar-wrapper">
          <div class="sidebar-brand">
            <a href="index.jsp">疫情信息统计可视化系统</a>
          </div>
          <div class="sidebar-user">
            <div class="sidebar-user-picture">
              <img alt="image" src="${pageContext.request.contextPath}/static/dist/img/avatar/avatar-1.jpeg">
            </div>
            <div class="sidebar-user-details">
              <div class="user-name">博二爷</div>
              <div class="user-role">
                Administrator
              </div>
            </div>
          </div>
          <ul class="sidebar-menu">


            <li class="menu-header">Components</li>
            <li class="active">
              <a href="#" target="myFrameName" class="has-dropdown"><i class="ion ion-ios-albums-outline"></i><span>全国范围数据可视化</span></a>
              <ul class="menu-dropdown">
                <li class="active"><a href="${pageContext.request.contextPath}/Echart/全国/全国.jsp?China_Date=<%=China_Date1%>" target="myFrameName"><i class="ion ion-ios-circle-outline"></i><%=China_Date1%>全国省份地域图</a></li>
                <li ><a href="${pageContext.request.contextPath}/Echart/全国/全国.jsp?China_Date=<%=China_Date2%>" target="myFrameName"><i class="ion ion-ios-circle-outline"></i><%=China_Date2%>全国省份地域图</a></li>
                <li ><a href="${pageContext.request.contextPath}/Echart/全国/全国.jsp?China_Date=<%=China_Date3%>" target="myFrameName"><i class="ion ion-ios-circle-outline"></i><%=China_Date3%>全国省份地域图</a></li>
                <li ><a href="${pageContext.request.contextPath}/Echart/全国/select_province.jsp" target="myFrameName"><i class="ion ion-ios-circle-outline"></i><%=China_Date1%>全国省份最小二乘法预测</a></li>
                <li ><a href="${pageContext.request.contextPath}/Echart/全国/select_city.jsp" target="myFrameName"><i class="ion ion-ios-circle-outline"></i><%=China_Date1%>全国城市最小二乘法预测</a></li>
                <li><a href="${pageContext.request.contextPath}/Echart/全国/Zhu.jsp?China_Date=<%=China_Date1%>" target="myFrameName"><i class="ion ion-ios-circle-outline"></i>全国省份柱状折线图</a></li>
                <li><a href="${pageContext.request.contextPath}/Echart/全国/Shan.jsp?China_Date=<%=China_Date1%>" target="myFrameName"><i class="ion ion-ios-circle-outline"></i>全国省份扇形图</a></li>
                <li><a href="${pageContext.request.contextPath}/Echart/全国/City_zhu.jsp?China_Date=<%=China_Date1%>" target="myFrameName"><i class="ion ion-ios-circle-outline"></i>全国城市柱状折线图</a></li>
                <li><a href="${pageContext.request.contextPath}/Echart/全国/City_shan.jsp?China_Date=<%=China_Date1%>" target="myFrameName"><i class="ion ion-ios-circle-outline"></i>全国城市扇形图</a></li>
                 
              </ul>
            </li>
            
            
              <li>
              <a href="#" class="has-dropdown"><i class="ion ion-flag"></i><span>河北省数据可视化</span></a>
              <ul class="menu-dropdown">
              <li><a href="${pageContext.request.contextPath}/Echart/河北省/Zhu.jsp" target="myFrameName"><i class="ion ion-ios-circle-outline"></i>河北省历史疫情多方位折线柱状图</a></li>
                <li><a href="${pageContext.request.contextPath}/Echart/河北省/3D.jsp" target="myFrameName"><i class="ion ion-ios-circle-outline"></i>省市历史记录3D表</a></li>
                <li><a href="#"><i class="ion ion-ios-circle-outline"></i>地域图</a></li>
              </ul>
            </li>
            
            
            
            <li>
              <a href="#" class="has-dropdown"><i class="ion ion-stats-bars"></i><span>河北城市数据可视化</span></a>
              <ul class="menu-dropdown">
                <li><a href="${pageContext.request.contextPath}/Echart/河北省/city.jsp?cityname=石家庄市" target="myFrameName"><i class="ion ion-ios-circle-outline"></i>石家庄市疫情走线图</a></li>
               <li><a href="${pageContext.request.contextPath}/Echart/河北省/city.jsp?cityname=沧州市" target="myFrameName"><i class="ion ion-ios-circle-outline"></i>沧州市疫情走线图</a></li>
              <li><a href="${pageContext.request.contextPath}/Echart/河北省/city.jsp?cityname=唐山市" target="myFrameName"><i class="ion ion-ios-circle-outline"></i>唐山市疫情走线图</a></li>
              <li><a href="${pageContext.request.contextPath}/Echart/河北省/city.jsp?cityname=保定市" target="myFrameName"><i class="ion ion-ios-circle-outline"></i>保定市疫情走线图</a></li>
              <li><a href="${pageContext.request.contextPath}/Echart/河北省/city.jsp?cityname=邯郸市" target="myFrameName"><i class="ion ion-ios-circle-outline"></i>邯郸市疫情走线图</a></li>
              <li><a href="${pageContext.request.contextPath}/Echart/河北省/city.jsp?cityname=廊坊市" target="myFrameName"><i class="ion ion-ios-circle-outline"></i>廊坊市疫情走线图</a></li>
              <li><a href="${pageContext.request.contextPath}/Echart/河北省/city.jsp?cityname=张家口市" target="myFrameName"><i class="ion ion-ios-circle-outline"></i>张家口市疫情走线图</a></li>
              <li><a href="${pageContext.request.contextPath}/Echart/河北省/city.jsp?cityname=邢台市" target="myFrameName"><i class="ion ion-ios-circle-outline"></i>邢台市疫情走线图</a></li>
              <li><a href="${pageContext.request.contextPath}/Echart/河北省/city.jsp?cityname=秦皇岛市" target="myFrameName"><i class="ion ion-ios-circle-outline"></i>秦皇岛市疫情走线图</a></li>
              <li><a href="${pageContext.request.contextPath}/Echart/河北省/city.jsp?cityname=衡水市" target="myFrameName"><i class="ion ion-ios-circle-outline"></i>衡水市疫情走线图</a></li>
              <li><a href="${pageContext.request.contextPath}/Echart/河北省/city.jsp?cityname=承德市" target="myFrameName"><i class="ion ion-ios-circle-outline"></i>承德市疫情走线图</a></li>
               </ul>
            </li>
           
            
            <li>
              <a href="#" class="has-dropdown"> <i class="ion ion-ios-copy-outline"></i><span>河北城市历史数据可视&nbsp;&nbsp;化</span></a>
              <ul class="menu-dropdown">
                <li><a href="${pageContext.request.contextPath}/Echart/河北省/河北省.jsp?date=<%=Hebei_Date1 %>" target="myFrameName"><i class="ion ion-ios-circle-outline"></i><%=Hebei_Date1 %>河北省疫情地域图</a></li>
               <li><a href="${pageContext.request.contextPath}/Echart/河北省/河北省.jsp?date=<%=Hebei_Date2 %>" target="myFrameName"><i class="ion ion-ios-circle-outline"></i><%=Hebei_Date2 %>河北省疫情地域图</a></li>
              <li><a href="${pageContext.request.contextPath}/Echart/河北省/河北省.jsp?date=<%=Hebei_Date3 %>" target="myFrameName"><i class="ion ion-ios-circle-outline"></i><%=Hebei_Date3 %>河北省疫情地域图</a></li>
              <li><a href="${pageContext.request.contextPath}/Echart/河北省/河北省.jsp?date=<%=Hebei_Date4 %>" target="myFrameName"><i class="ion ion-ios-circle-outline"></i><%=Hebei_Date4 %>河北省疫情地域图</a></li>
              <li><a href="${pageContext.request.contextPath}/Echart/河北省/河北省.jsp?date=<%=Hebei_Date5 %>" target="myFrameName"><i class="ion ion-ios-circle-outline"></i><%=Hebei_Date5 %>河北省疫情地域图</a></li>
              <li><a href="${pageContext.request.contextPath}/Echart/河北省/河北省.jsp?date=<%=Hebei_Date6 %>" target="myFrameName"><i class="ion ion-ios-circle-outline"></i><%=Hebei_Date6 %>河北省疫情地域图</a></li>
              <li><a href="${pageContext.request.contextPath}/Echart/河北省/河北省.jsp?date=<%=Hebei_Date7%>" target="myFrameName"><i class="ion ion-ios-circle-outline"></i><%=Hebei_Date7%>河北省疫情地域图</a></li>
              <li><a href="${pageContext.request.contextPath}/Echart/河北省/河北省.jsp?date=<%=Hebei_Date8 %>" target="myFrameName"><i class="ion ion-ios-circle-outline"></i><%=Hebei_Date8 %>河北省疫情地域图</a></li>
              <li><a href="${pageContext.request.contextPath}/Echart/河北省/河北省.jsp?date=<%=Hebei_Date9 %>" target="myFrameName"><i class="ion ion-ios-circle-outline"></i><%=Hebei_Date9 %>河北省疫情地域图</a></li> 
               </ul>
            </li>
            
            <li>
             <a href="${pageContext.request.contextPath}/Echart/复杂/预测.jsp" target="myFrameName"><i class="ion ion-clipboard"></i><span>最小二乘法预测河北数据分析疫情走向</span></a>
            </li>


  			 <li>
              <a href="#" class="has-dropdown"><i class="ion ion-ios-nutrition"></i><span>石家庄市确诊病例路径（不真实、片面）</span></a>
              <ul class="menu-dropdown">
              <%
              for(int i=1;i<23;i++)
              {
            	  %>
            	  <li><a href="${pageContext.request.contextPath}/Echart/复杂/Child/<%=i %>.jsp" target="myFrameName"><i class="ion ion-ios-circle-outline"></i>第<%=i %>病例走向</a></li>
        
            	  
            	  <%
              }
              
              %>
                
              </ul>
            </li>
            



             </ul>
          <div class="p-3 mt-4 mb-4">
            <a href="#" class="btn btn-danger btn-shadow btn-round has-icon has-icon-nofloat btn-block">
              <i class="ion ion-help-buoy"></i> <div>退出</div>
            </a>
          </div>
        </aside>
      </div>
      <div class="main-content" style="height: 100%">
      <br> <br>
      
      
      
        <iframe name="myFrameName" id="iframeId" frameborder=0 scrolling=no src="Echart/全国/全国.jsp?China_Date=<%=China_Date1%>"></iframe>
        
        
        
        
        
        
      </div>
      <footer class="main-footer">
        <div class="footer-left">
          Copyright &copy; 2020 <div class="bullet"></div> 博客： <a href="https://www.cnblogs.com/smartisn/" target="_blank" title="博二爷">博二爷的博客园</a>
        </div>
        <div class="footer-right"></div>
      </footer>
    </div>
  </div>

  <script src="${pageContext.request.contextPath}/static/dist/modules/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/dist/modules/popper.js"></script>
  <script src="${pageContext.request.contextPath}/static/dist/modules/tooltip.js"></script>
  <script src="${pageContext.request.contextPath}/static/dist/modules/bootstrap/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/dist/modules/nicescroll/jquery.nicescroll.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/dist/modules/scroll-up-bar/dist/scroll-up-bar.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/dist/js/sa-functions.js"></script>
  
  <script src="${pageContext.request.contextPath}/static/dist/js/scripts.js"></script>
  <script src="${pageContext.request.contextPath}/static/dist/js/custom.js"></script>
  <script src="${pageContext.request.contextPath}/static/dist/js/demo.js"></script>
</body>
</html>