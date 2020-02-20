<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 100%">
   <head>
       <meta charset="utf-8">
   </head>
   <body style="height: 100%; margin: 0">
       <div id="container" style="height: 100%"></div>

    <script type="text/javascript" src="${pageContext.request.contextPath}/static/echart/map/echarts.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/echart/map/echarts-gl.min.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-1.12.1.js"></script>

       <script type="text/javascript">
var dom = document.getElementById("container");
var myChart = echarts.init(dom);
var app = {};
option = null;
var date=new Date();
option = {
		 title: {
		        text: date.toLocaleString( )+'河北省各地市疫情统计',
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
            magicType: {show: true, type: ['line', 'bar','bar3D']},
            restore: {show: true},
            saveAsImage: {show: true}
        }
    },
    visualMap: {
        max: 40,
        inRange: {
            color: ['#313695', '#4575b4', '#74add1', '#abd9e9', '#e0f3f8', '#ffffbf', '#fee090', '#fdae61', '#f46d43', '#d73027', '#a50026']
        }
    },
    xAxis3D: {
        type: 'category',
        data: []
    },
    yAxis3D: {
        type: 'category',
        data: []
    },
    zAxis3D: {
        type: 'value'
    },
    grid3D: {
        boxWidth: 200,
        boxDepth: 80,
        light: {
            main: {
                intensity: 1.2
            },
            ambient: {
                intensity: 0.3
            }
        }
    },
    series: [{
        type: 'bar3D',
        data:[	] ,
        shading: 'color',

        label: {
            show: false,
            textStyle: {
                fontSize: 50,
                borderWidth: 5
            }
        },
        
        itemStyle: {
            opacity: 0.4
        },

        emphasis: {
            label: {
                textStyle: {
                    fontSize: 20,
                    color: '#900'
                }
            },
            itemStyle: {
                color: '#900'
            }
        }
    }]
};
myChart.showLoading(); 

$.ajax({
    type : "post",
    async : true,
    url : "${pageContext.request.contextPath}/HeServlet",
    type:"POST",
    data:
    	{
    	"method":"city3D",
    	},
    dataType:"json",
    success:function(result) {
        if(result)
        {
        	myChart.hideLoading();
           	myChart.setOption({        //加载数据图表
           		xAxis3D: {
                    data: result.xAxis3D
                },
                yAxis3D: {
                    data: result.yAxis3D
                },
                series: [
                    {
                        data: result.series[0].data
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