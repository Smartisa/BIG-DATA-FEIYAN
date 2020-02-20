<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 100%">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="ECharts">
    <meta name="author" content="kener.linfeng@gmail.com">
    <title>ECharts · Example</title>
     <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-1.12.1.js"></script>
<script src='${pageContext.request.contextPath}/static/echart/echarts-all.js'></script> 

</head>
       <%
       String date=request.getParameter("date");
       //String cityname="石家庄市";
       %>
   <body style="height: 100%; margin: 0">
    <div id="chart" class="chart" style="height: 100%"></div>
	
	<script type="text/javascript">
	var date=new Date();
	
        // 基于准备好的dom，初始化echarts图表
        var myChart = echarts.init(document.getElementById('chart')); 
        var option = {
		title: {
				text : '<%=date%>河北省新型冠状病毒确诊情况'
			},
			   tooltip: {
		            trigger: 'item',
		            formatter: '{b}<br/>{c} (人/市)'
		        },
		        toolbox: {
		            feature: {
		                dataView: {show: true, readOnly: false},
		                magicType: {show: true, type: ['line', 'bar']},
		                restore: {show: true},
		                saveAsImage: {show: true}
		            }
		        },
            dataRange: {
					  x: 'left',
						y: 'bottom',
						splitList: [
							{start: 31, color: '#b91811'},
							{start: 21, end: 30, color: '#ea5c22 '},
							{start: 11, end: 20, color: '#ea802b'},
							{start: 5, end: 10, color: '#eabb5b'},
							{end: 4, color: '#eaf277'},
						],
						color: ['#E0022B', '#E09107', '#A3E00B']
					},
            series : [
                {
                    name: '确诊病例数',
					type: 'map',
					mapType: '河北',
					itemStyle:{
					   normal:{label:{show:true}},
					   emphasis:{label:{show:true}}
					}, 
					data:[]
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
            	"method":"he_di",
            	"select_date":"<%=date%>"
            	},
            dataType:"json",
            success:function(result) {
                if(result)
                {
                	
                	myChart.hideLoading();
                   	myChart.setOption({        //加载数据图表
                        series: [
                            {
                                data: result.series
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
        // 为echarts对象加载数据         
if (option && typeof option === "object") {
    myChart.setOption(option, true);
}
</script>
</body>
</html>
    