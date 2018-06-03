<%--
  Created by IntelliJ IDEA.
  User: hadoop
  Date: 2018/5/21
  Time: 下午4:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="sun.vo.SunType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="/Computer/js/jQuery.js"></script>
    <script src="/Computer/js/echarts.js"></script>
        <%
    List<SunType> list2 = (List<SunType>) request.getAttribute("list");
%>
<body>
<div id="main" style="width: 800px;height:800px; margin-left: 80px; margin-top: -30px"></div>
<script>
    echarts.init(document.getElementById('main')).setOption({
        series: {
            type: 'sunburst',
            data: [
                <%
                for (int i=0;i<list2.size();i++){
                if (i<list2.size()-1){
                %>
                {
                    name: '<%=list2.get(i).getMlocation()%>',
                    children:
                        [
                            <%for (int j=0;j<list2.get(i).getJobAndSal().size();j++){
                            if (j<list2.get(i).getJobAndSal().size()-1) {
                            %>
                            {

                                name: '<%=list2.get(i).getJobAndSal().get(j).getJobName()%>',
                                value: <%=list2.get(i).getJobAndSal().get(j).getSal()%>
                            },
                            <%} else {
                            %>
                            {

                                name: '<%=list2.get(i).getJobAndSal().get(j).getJobName()%>',

                                value: <%=list2.get(i).getJobAndSal().get(j).getSal()%>
                            }
                            <%
                            }
                            }%>
                        ]
                },
                <%
                } else {
                %>
                {
                    name: '<%=list2.get(i).getMlocation()%>',
                    children:
                        [
                            <%for (int j=0;j<list2.get(i).getJobAndSal().size();j++){
                            if (j<list2.get(i).getJobAndSal().size()-1) {
                            %>
                            {

                                name: '<%=list2.get(i).getJobAndSal().get(j).getJobName()%>',

                                value: <%=list2.get(i).getJobAndSal().get(j).getSal()%>
                            },
                            <%} else {
                            %>
                            {

                                name: '<%=list2.get(i).getJobAndSal().get(j).getJobName()%>',

                                value: <%=list2.get(i).getJobAndSal().get(j).getSal()%>
                            }
                            <%
                            }}
                            %>
                        ]
                }

                <%
                }
                }
                %>
            ]
        }
    });
</script>
</body>
</html>
