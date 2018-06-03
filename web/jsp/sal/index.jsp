<%@ page import="java.util.List" %>
<%@ page import="sal.vo.Sal" %><%--
  Created by IntelliJ IDEA.
  User: hadoop
  Date: 2018/5/7
  Time: 下午6:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/Computer/js/echarts.min.js"></script>
    <style>
    </style>
</head>

<%
    List<Sal> list = (List<Sal>) request.getAttribute("list");
%>
<body>

<div id="main" style="margin-top: 80px; margin-left: 140px; width: 600px;height:600px;">
</div>
<script type="text/javascript">
    // 绘制图表。
    echarts.init(document.getElementById('main')).setOption({
        series: {
            type: 'pie',
            data: [
                    <%
                        for (int i=0;i<list.size();i++){
                            if (i< list.size()-1){
                                %>{
                    name: '<%=list.get(i).getLocation()%>', value: <%=list.get(i).getSal()%>
                }, <%
                    	} else {
                    		%>{
                    name: '<%=list.get(i).getLocation()%>', value: <%=list.get(i).getSal()%>
                }<%
                    	}
                    }
                %>
            ]
        }
    });
</script>

</body>
</html>
