<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 100%">
   <head>
       <meta charset="utf-8">
   </head>
   <body style="height: 100%; margin: 0">
   <% 
   		String Date=request.getParameter("China_Date");
   %>
       <div id="container" style="height: 100%"></div>
       <script type="text/javascript" src="${pageContext.request.contextPath}/static/echart/echarts.min.js"></script>
 
       <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-1.12.1.js"></script>
       <script type="text/javascript">
       
var dom = document.getElementById("container");
var myChart = echarts.init(dom);
var uploadedDataURL = "../../static/echart/json/data-1519188124693-rkro_O5vz.json";
var date=new Date();
myChart.showLoading();
option = null;
cityname = [];
option = {
        title: {
            text: '<%=Date%>全国新型冠状病毒确诊情况',
            
        },
        visualMap: {
            show: true,
            type: 'piecewise',
            pieces: [
            	{
                    min: 5000,
                    
                },
            	{
                    min: 1000,
                    max: 5000
                }, // 不指定 max，表示 max 为无限大（Infinity）。
                {
                    min: 500,
                    max: 1000
                },
                {
                    min: 100,
                    max: 500,
                },
                {
                    min: 20,
                    max: 100
                },
                {
                    min: 1,
                    max: 20
                },
                // {min:0,max: 2000},
                // {max:100}// 不指定 min，表示 min 为无限大（-Infinity）。
            ],
            showLabel: true,
            right: '15%',
            bottom: '20%',
            // top: 'bottom',
            text: ['确诊病例'], // 文本，默认为数值文本
            calculable: true,
            inRange: {
                // color: ['#3B5077', '#031525'] // 蓝黑
                // color: ['#ffc0cb', '#800080'] // 红紫
                // color: ['#3C3B3F', '#605C3C'] // 黑绿
                // color: ['#0f0c29', '#302b63', '#24243e'] // 黑紫黑
                // color: ['#23074d', '#cc5333'] // 紫红
                color: ['#F6CED8', '#D90505'] //蓝红
                // color: ['#00467F', '#A5CC82'] // 蓝绿
                // color: ['white','#1488CC', '#2B32B2'] // 浅蓝
                // color: ['#00467F', '#A5CC82'] // 蓝绿
                // color: ['#00467F', '#A5CC82'] // 蓝绿
                // color: ['#00467F', '#A5CC82'] // 蓝绿
                // color: ['#00467F', '#A5CC82'] // 蓝绿

            }
        },
        tooltip: {
            trigger: 'item',
            formatter: '{b}<br/>{c} (人/市)'
        },
        toolbox: {
            show: true,
            feature: {
                dataView: {
                    readOnly: false
                },
                restore: {},
                saveAsImage: {
                    pixelRatio: 4
                }
            }
        },
        series: [{
                name: '确诊病例数',
                type: 'map',
                mapType: 'chinacity',
                label: {
                    normal: {
                        show: false
                    }
                },
                roam: true,
                // itemStyle: {
                //     normal: {
                //         borderColor: '#CD4F39',
                //         areaColor: '#54FF9F',
                //         borderWidth: 4,
                //         opacity: 0.2
                //     }
                // },
                data: []
                
            },

        ]
    };
    
$.get(uploadedDataURL, function(geoJson) {

    myChart.hideLoading();

    echarts.registerMap('chinacity', geoJson);
    var mapFeatures = echarts.getMap('chinacity').geoJson.features;
    mapFeatures.forEach(function(v) {
        // 地区名称
        var name = v.properties.name;
        cityname.push(name)
    });
    console.log(cityname)
    
    $.ajax({
    type : "post",
    async : true,
    url : "${pageContext.request.contextPath}/ChartServlet",
    type:"POST",
    data:
    	{
    	"method":"china_map",
    	"Date":"<%=Date%>",
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
    myChart.setOption(option, true);
    
});
       </script>
   </body>
</html>