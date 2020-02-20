<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>驾车途经点</title>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=QoajELQDUljC80oe6AeXlZVFwXVGOSr6"></script>
</head>
<body>
<p><input type='button' value='开始' onclick='run();' /></p>
<div style="width:820px;height:500px;border:1px solid gray" id="container"></div>

</body>
</html>
<script type="text/javascript">
var map = new BMap.Map("container");
map.centerAndZoom(new BMap.Point(116.404, 39.915), 13);
map.addControl(new BMap.NavigationControl());               // 添加平移缩放控件
map.addControl(new BMap.ScaleControl());                    // 添加比例尺控件
map.addControl(new BMap.OverviewMapControl());              //添加缩略地图控件

var myP1 = new BMap.Point(114.48799,38.017127);    //起点-重庆

var myP2 = new BMap.Point(114.510198,37.980955);    //终点-西安

var myP3 = new BMap.Point(114.540537,38.045836);    //终点-北京


function MyAutoRun (){
    map.clearOverlays();                        //清除地图上所有的覆盖物
    var driving = new BMap.DrivingRoute(map);    //创建驾车实例
    driving.search(myP1, myP2);                 //第一个驾车搜索
    driving.search(myP2, myP3);                 //第二个驾车搜索
    driving.setSearchCompleteCallback(function(){
        var pts = driving.getResults().getPlan(0).getRoute(0).getPath();    //通过驾车实例，获得一系列点的数组

        var polyline = new BMap.Polyline(pts);     
        map.addOverlay(polyline);
        
        var m1 = new BMap.Marker(myP1);         //创建3个marker
        var m2 = new BMap.Marker(myP2);
        var m3 = new BMap.Marker(myP3);
        map.addOverlay(m1);
        map.addOverlay(m2);
        map.addOverlay(m3);
        
        var lab1 = new BMap.Label("起点",{position:myP1});        //创建3个label
        var lab2 = new BMap.Label("途径点",{position:myP2});
        var lab3 = new BMap.Label("终点",{position:myP3});   
        map.addOverlay(lab1);
        map.addOverlay(lab2);
        map.addOverlay(lab3);
        
        setTimeout(function(){
            map.setViewport([myP1,myP2,myP3]);          //调整到最佳视野
        },1000);
        
    });
}
window.onload=MyAutoRun();
</script>