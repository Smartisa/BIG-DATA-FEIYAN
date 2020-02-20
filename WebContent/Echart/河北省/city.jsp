<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 100%">
   <head>
       <meta charset="utf-8">
       <%
       String cityname=request.getParameter("cityname");
       //String cityname="石家庄市";
       %>
   </head>
   <body style="height: 100%; margin: 0">
       <div id="container" style="height: 100%"></div>
       <script type="text/javascript" src="${pageContext.request.contextPath}/static/echart/echarts.min.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-1.12.1.js"></script>
       <script type="text/javascript">
       var dom = document.getElementById("container");
       var myChart = echarts.init(dom);
       var app = {};
       var date=new Date();
       option = null;
       option = {
    		   title: {
    		        text: date.toLocaleString( )+"<%=cityname%>"+'疫情统计',
    		        subtext: '数据来源：河北省健康委员会官网'
    		    },
           tooltip: {
               trigger: 'axis',
               axisPointer: {
                   type: 'cross',
                   crossStyle: {
                       color: '#999'
                   }
               }
           },
           toolbox: {
               feature: {
                   dataView: {show: true, readOnly: false},
                   magicType: {show: true, type: ['line', 'bar']},
                   restore: {show: true},
                   saveAsImage: {show: true}
               }
           },
           legend: {
               data: ['新增确诊病例','确诊病例','死亡病例','重症病例','治愈病例']
           },
           xAxis: [
               {
                   type: 'category',
                   data:[],
                   axisLabel: {  
                       interval: 0,  
                       formatter:function(value)  
                       {  
                           debugger  
                           var ret = "";//拼接加\n返回的类目项  
                           var maxLength = 2;//每项显示文字个数  
                           var valLength = value.length;//X轴类目项的文字个数  
                           var rowN = Math.ceil(valLength / maxLength); //类目项需要换行的行数  
                           if (rowN > 1)//如果类目项的文字大于3,  
                           {  
                               for (var i = 0; i < rowN; i++) {  
                                   var temp = "";//每次截取的字符串  
                                   var start = i * maxLength;//开始截取的位置  
                                   var end = start + maxLength;//结束截取的位置  
                                   //这里也可以加一个是否是最后一行的判断，但是不加也没有影响，那就不加吧  
                                   temp = value.substring(start, end) + "\n";  
                                   ret += temp; //凭借最终的字符串  
                               }  
                               return ret;  
                           }  
                           else {  
                               return value;  
                           }  
                       }  
                   },
               grid: {  
               		left: '10%',  
               		bottom:'35%'  
               }

               }
           ],
           yAxis: [
               {
                   type: 'value',
                   name: '人数',
                   axisLabel: {
                       formatter: '{value} 人'
                   }
               }
              
           ],
           
           series: [
               {
                   name: '新增确诊病例',
                   type: 'bar',
                   data: []
               },
               {
                   name: '确诊病例',
                   type: 'bar',
                   data: []
               },
               {
                   name: '死亡病例',
                   type: 'bar',
                   data: []
               },
               {
                   name: '重症病例',
                   type: 'bar',
                   data: []
               },
               {
                   name: '治愈病例',
                   type: 'bar',
                   data: []
               }
           ]
       };     

myChart.showLoading(); 

$.ajax({
    type : "post",
    async : true,
    url : "${pageContext.request.contextPath}/HeServlet",
    type:"POST",
    data:
    	{
    	"method":"city_zhu",
    	"cityname":'<%=cityname%>'
    	},
    dataType:"json",
    success:function(result) {
        
        if(result)
        {
        	myChart.hideLoading();
           	myChart.setOption({        //加载数据图表
                xAxis: {
                    data: result.xAxis
                },
                series: [
                    {
                        data: result.series[0].data
                     },
                     {
                         data: result.series[1].data
                      }  ,
                     {
                         data: result.series[2].data
                      },
                      {
                          data: result.series[3].data
                       },
                       {
                           data: result.series[4].data
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