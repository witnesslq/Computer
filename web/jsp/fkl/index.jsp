<%@ page import="java.util.List" %>
<%@ page import="fkl.vo.Fkl" %><%--
  Created by IntelliJ IDEA.
  User: hadoop
  Date: 2018/5/7
  Time: 下午5:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示界面</title>
    <script src="/Computer/js/echarts.min.js"></script>
</head>
<body>
<%
    List<Fkl> list = (List<Fkl>) request.getAttribute("list");
%>
<div id="main" style="width: 1000px;height:600px; ">
</div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));
    <%
            String values = "";
            String values2 = "";
            for (int i=0;i<list.size();i++) {
            	if (i == 0) {
            		values = values +"\""+ list.get(i).getLocation()+"\""+", ";
            		values2 = '"'+values2 + String.valueOf(list.get(i).getFklNum()).substring(0,3)+",";
            	} else if  (i<list.size()-1 && i>=1){
            		values = values +"\""+ list.get(i).getLocation()+"\""+", ";
            		values2 = values2 + String.valueOf(list.get(i).getFklNum()).substring(0,3)+",";
            	}else {
            		values = values +"\""+ list.get(i).getLocation()+"\"";
            		values2 = values2 + String.valueOf(list.get(i).getFklNum()).substring(0,3)+'"';
            	}
            }
            %>
    var str = <%=values2%>;
    var arr = str.split(",");
    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '各城市对计算机类工作响应率'
        },
        tooltip: {},
        legend: {
            data: ['平均响应率']
        },
        xAxis: {
            data: [<%=values%>]
        },
        yAxis: {},
        series: [{
            name: '平均评分',
            type: 'bar',

            data: arr
        }]
    };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
</body>
</html>
