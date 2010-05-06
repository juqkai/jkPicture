<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>
<%@page import="org.juqkai.juqcc.domain.Photo"%>
<%@page import="org.juqkai.juqcc.domain.Page"%>
<%@page import="java.io.File"%>
<%@page import="org.juqkai.juqcc.util.PhotoUtil"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>juqcc图片外链</title>
<link rel="stylesheet" type="text/css" href="/script/css/index.css">
<script type="text/javascript" src="/script/js/jquery-1.4.2.js"></script>
<style type="text/css">
#photos {
	border: 1px solid #778541;
}
*{
	margin: 0x;
	padding: 0px;
	font-size: 12px;
}
a:link {
	text-decoration: underline;
}
img{
	border: 0px solid red;
}

#photos {
	position:relative;
}
.photoItem {
	float: left;
	border: 0px solid red;
	width: 130px;
	margin: 5px;
}
.photoItem input {
	width: 81px;
	margin-left: 5px;
}

#page {
	width: 22px;
}
.clear{
	clear: both;
}
</style>



<script type="text/javascript">
	$(function(){
		<% 
		String message = (String)request.getAttribute("message");
		if(message != null){
			out.println("alert('"+message+"')");
		}
		%>
				
		$(".photoItem input").click(function(){
			$(this).trigger("select");
		});
	});
</script>
</head>

<body>
<a href="/juqccPreUpload">上传</a>

<div id="photos">
<%
	List<Photo> photos = (List<Photo>) request.getAttribute("photos");
	Page pa = (Page) request.getAttribute("pg");
	for (Photo photo : photos) {
%>
<div class="photoItem">
	<a href="/jquccOne?id=<%=photo.getId()%>" class="photoItem" title="<%=photo.getName()%>" target="_blank">  
	<img width="100" height="100" src='/jquccOne?id=<%=photo.getId()%>' /></a>
	<input name="aa" value="<%=PhotoUtil.getPhotoUrl(request) + photo.getId()%>" >
	<a href="/juqccDelete?id=<%=photo.getId()%>" title="删除图片" onclick="return confirm('确定删除?');"><img src="/image/delete.gif"/></a>
	</div>
<%
	}
%>
<div class="clear"/>
</div>
<div>
<form action="/juqccList"><a href="/juqccList?pg=1"><<</a> <a
	href="/juqccList?pg=<%=pa.getPrevPage()%>"><</a> <%=pa.getCurrentPage()%>/<%=pa.getEndPage()%>
<a href="/juqccList?pg=<%=pa.getNextPage()%>">></a> <a
	href="/juqccList?pg=<%=pa.getEndPage()%>">>></a> <input name="pg"
	id="page"> <input type="submit" value="GO"></form>
</div>

<div class="systemInfo">
	版权所有:zhaoweiyicc,juqkai,zkgale&nbsp;&nbsp;
	<a href="/photo/systemInfo.jsp">更新信息</a>
</div>
</body>
</html>