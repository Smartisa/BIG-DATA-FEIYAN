<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 100%">
   <head>
       <meta charset="utf-8">
   </head>
   <%
   	String Date=request.getParameter("China_Date");
   %>
   <body style="height: 100%; margin: 0">
       <div id="container" style="height: 100%"></div>
       <script type="text/javascript" src="${pageContext.request.contextPath}/static/echart/echarts.min.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-1.12.1.js"></script>
       <script type="text/javascript">
var dom = document.getElementById("container");
var myChart = echarts.init(dom);
var app = {};
option = null;
option = {
	    title: [{
	    	text: '全国省份确诊病例疫情示例图',
	        subtext: '数据来源：各地市卫生健康委员会',
	        left: 'center'
	    }, {
	        subtext: '确诊病例',
	        left: '16.67%',
	        top: '75%',
	        textAlign: 'center'
	    }, {
	        subtext: '治愈病例',
	        left: '50%',
	        top: '75%',
	        textAlign: 'center'
	    }, {
	        subtext: '死亡病例',
	        left: '83.33%',
	        top: '75%',
	        textAlign: 'center'
	    }],
	    tooltip: {
	        trigger: 'item',
	        formatter: '{a} <br/>{b} : {c} ({d}%)'
	    },
	    legend: {
	        type: 'scroll',
	        orient: 'vertical',
	        right: 10,
	        top: 20,
	        bottom: 20,
	        data: [],
			selected: {}
	    },
    series: [{
        type: 'pie',
        radius: '25%',
        center: ['20%', '50%'],
        data:[],
        animation: false,
        label: {
            position: 'outer',
            alignTo: 'none',
            bleedMargin: 5
        },
        left: 0,
        right: '66.6667%',
        top: 0,
        bottom: 0
    }, {
        type: 'pie',
        radius: '25%',
        center: ['50%', '50%'],
        data: [],
        animation: false,
        label: {
            position: 'outer',
            alignTo: 'labelLine',
            bleedMargin: 5
        },
        left: '33.3333%',
        right: '33.3333%',
        top: 0,
        bottom: 0
    }, {
        type: 'pie',
        radius: '25%',
        center: ['80%', '50%'],
        data: [],
        animation: false,
        label: {
            position: 'outer',
            alignTo: 'edge',
            margin: 20
        },
        left: '66.6667%',
        right: 0,
        top: 0,
        bottom: 0
    }]
};

myChart.showLoading(); 

$.ajax({
    type : "post",
    async : true,
    url : "${pageContext.request.contextPath}/ChartServlet",
    type:"POST",
    data:
    	{
    	"method":"china_shan",
    	"Date":"<%=Date%>"
    	},
    dataType:"json",
    
    success:function(result) {
       // alert(result.selected);
        if(result)
        {
        	myChart.hideLoading();
           	myChart.setOption({        //加载数据图表
           		legend: {
                    data: result.legend,
                   // selected:result.selected
                },
                series: [
                    {
                        data: result.seriesList_confirmed
                     },
                     {
                         data: result.seriesList_cured
                      },
                      {
                          data: result.seriesList_dead
                       }
                	]
            });
        }
                  
   },
    error : function(errorMsg) {
        //请求失败时执行该函数
    alert("请求数据失败!");
   // myChart.hideLoading();
    }
});
if (option && typeof option === "object") {
    myChart.setOption(option, true);
}
       </script>
   </body>
</html>