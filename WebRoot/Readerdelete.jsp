<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.Calendar"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>删除读者 </title>
		<style type="text/css"> 
		body
		{ 
		    background-image:url(reader.jpg);
		    background-repeat:no-repeat;
		} 
	</style>
	<% 
		request.setCharacterEncoding("UTF-8");
		String no = request.getParameter("no");
		String style =request.getParameter("style");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String dept = request.getParameter("dept");
		String all = request.getParameter("all");
		Calendar now1 = Calendar.getInstance();  
        int year = now1.get(Calendar.YEAR);  
        int month = now1.get(Calendar.MONTH)+1 ; 
        int day = now1.get(Calendar.DAY_OF_MONTH); 
	%>
	</head>
	<style type="text/css" media="screen">
		.center
		{
			position:absolute;
			left: 35%;
			top: 25%;
		}
	</style>
	<body>
		 <strong><font size="4" color="red">您好，今天是<%=year %>年<%=month %>月<%=day %>日</font></strong>
		 <div class="center">
		<h3>删除读者</h3>
		<form name="Readerdelete" method="post" action="/Mywork/ApplicationController">
			<table id="Readerinfo" border="0" cellspacing="0">
				<tr>
					<td><label for="no">读者编号：</label></td>
					<td><input type="text" name="no" id="no" value="<%=no%>" readonly></td>
				</tr>
				<tr>
					<td><label for="style">读者类型</label></td>
					<td><input type="text" name="style" id="style" value="<%=style%>"></td>
				</tr>
				<tr>
					<td><label for="name">姓名：</label></td>
					<td><input type="text" name="name" id="name" value="<%=name %>" readonly></td>
				</tr>
				<tr>
					<td><label for="sex">性别：</label></td>
					<td><input type="text" name="sex" id="sex" value="<%=sex%>" readonly></td>
				</tr>
				<tr>
					<td><label for="age">年龄：</label></td>
					<td><input type="text" name="age" id="age" value="<%=age%>" readonly></td>>
				</tr>
				<tr>
					<td><label for="dept">学院：</label></td>
					<td><input type="text" name="dept" id="dept" value="<%=dept%>" readonly></td>
				</tr>
				<tr>
					<td><label for="all">借阅数量：</label></td>
					<td><input type="text" name="all" id="all" value="<%=all%>" readonly></td>
				</tr>
			</table>
			<input type="hidden" name="entity" id="entity" value="Reader">
			<input type="hidden" name="operation" id="operation" value="delete">
			<p>
				<input type="submit" name="submit" value="删除">
				<input type="button" name="cancel" value="取消" onclick="javascript:history.go(-1);">
			</p>
		</form>
		</div>
	</body>
</html>