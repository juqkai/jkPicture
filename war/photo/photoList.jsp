<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>

<%@page import="org.juqkai.juqcc.domain.Photo"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>bb</title>
<style type="text/css">
	#photos{
		border: 1px solid #778541;
	}
	
	.photoItem{
		display: inline;
		border: 0px solid red;
		width: 130px;
		height: 130px;
		margin:5px;
	}
	.photoItem div{
		display: inline;
		border: 0px solid #478965;
		width: 120px;
	}
	#page{
		width: 22px;
	}
	
</style>
</head>

<body>
<a href="#">上传</a>

<div id="photos">
<%
List<Photo> photos = (List<Photo>)request.getAttribute("photos");
for(Photo photo : photos){
	%>
	<div class="photoItem">
	<a href="/jquccOne?id=<%=photo.getId()%>" class="photoItem" target="<%=photo.getName()%>" >
		<img width="100" height="100" src='/jquccOne?id=<%=photo.getId()%>'/>
	</a>
		
	</div>
	<%
}
%>
</div>
<div>
	<form action="/juqcc">
	<a href="/juqcc?page=1"><<</a>
	<a href="/juqcc?page="><</a>
	<a href="/juqcc?page=">></a>
	<a href="/juqcc?page=">>></a>
	<input name="page" id="page">
	<input type="submit" value="GO"> 
	</form>
</div>

</body>
</html>