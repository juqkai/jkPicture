<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>

<%@page import="org.juqkai.juqcc.Photo"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>bb</title>
</head>
<body>
<%
List<Photo> photos = (List<Photo>)request.getAttribute("photos");
for(Photo photo : photos){
	out.print("<img src='/jquccOne?id=" + photo.getId() + "'/>");
	out.print(photo.getName());
}
%>

aab
</body>
</html>