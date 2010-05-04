<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>

<%@page import="org.juqkai.juqcc.domain.Photo"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>bb</title>
<style type="text/css">
	#photos{
		border: 1px solid blue;
	}
	div {
		display: block;
	}
	a {
		border: 1px solid #333;
	}
	a div{
		width: 120px;
		border: 1px solid red;
	}
	
</style>
</head>

<body>

<div id="photos">
<%
List<Photo> photos = (List<Photo>)request.getAttribute("photos");
for(Photo photo : photos){
	%>
	<a href="/jquccOne?id=<%=photo.getId()%>" class="photoItem">
		<div>
		<img width="100" height="100" src='/jquccOne?id=<%=photo.getId()%>'>
		<span class="target"><%=photo.getName()%></span>
		</div>
		<!-- 
	<img width="100" height="100" src='/jquccOne?id=<%=photo.getId()%>'>
	<%=photo.getName()%>
	 -->
	</a>
	<%
}
%>
</div>
</body>
</html>