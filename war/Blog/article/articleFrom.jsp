<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加文章</title>
</head>
<body>
<form action="/article/save.htm">
<table>
	<tr>
		<td>名称：</td>
		<td><input type="text" name="name" /></td>
	</tr>
	<tr>
		<td>标签：</td>
		<td><input type="text" name="articleName" /></td>
	</tr>
	<tr>
		<td>内容：</td>
		<td><textarea name="article" rows="5" cols="50"></textarea></td>
	</tr>
	<tr>
		<td><input type="submit" value="提交" /></td>
		<td><input type="reset" /></td>
	</tr>
</table>
</form>
</body>
</html>