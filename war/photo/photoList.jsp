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
<title>bb</title>
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
		$(".photoItem input").click(function(){
			$(this).trigger("select");
		});
	});
</script>
</head>

<body>
<a href="/photo/upload.jsp">上传</a>

<div id="photos">
<%
	List<Photo> photos = (List<Photo>) request.getAttribute("photos");
	Page pa = (Page) request.getAttribute("page");
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
<form action="/juqccList"><a href="/juqccList?page=1"><<</a> <a
	href="/juqccList?page=<%=pa.getPrevPage()%>"><</a> <%=pa.getCurrentPage()%>/<%=pa.getEndPage()%>
<a href="/juqccList?page=<%=pa.getNextPage()%>">></a> <a
	href="/juqccList?page=<%=pa.getEndPage()%>">>></a> <input name="page"
	id="page"> <input type="submit" value="GO"></form>
</div>

</body>
</html>