<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<title>My JSP 'index.jsp' starting page</title>
	<script src="/WebProject/js/jquery-3.5.0.min.js"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script>
		$(document).ready(function(){
			$.ajax({
				type:"get",
				url:"huawei.api",
				data:{},
				dataType:"json",
				success:function(response){
					console.log(response);
				}
			});
	})

	</script>

  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
