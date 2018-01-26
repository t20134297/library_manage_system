<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.Calendar"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>图书修改</title>
		<script type="text/javascript">
			function checkBookInfo()
		{
			var _name = document.Bookadd.name.value;
			var _writer = document.Bookadd.writer.value;
			var _topic = document.Bookadd.topic.value;			
			if(_name == null ||  _name.indexOf(" ") >=0 ||_name.toString()=="")
			{
				alert("书名不能为空,且不能有空格");
				document.Bookadd.name.focus();
				return false;
			}
			if(_writer == null || _writer.indexOf(" ") >=0 || _writer=="")
			{
				alert("作者不能为空,且不能有空格");
				document.Bookadd.writer.focus();
				return false;
			}
			if(_topic == null ||  _topic.indexOf(" ") >=0 || _topic=="")
			{
				alert("主题不能为空,且不能有空格");
				document.Bookadd.topic.focus();
				return false;
			}			
		return true;
	}
		</script>
		<style type="text/css" media="screen">
		.center
		{
			position:absolute;
			left: 30%;
			top: 15%;
		}
	</style>
	<style type="text/css"> 
		body
		{ 
		    background-image:url(book.jpg);
		    background-repeat:no-repeat;
		} 
	</style>
	</head>
	<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String writer = request.getParameter("writer");
		String topic = request.getParameter("topic");
		String all = request.getParameter("all");
		String now = request.getParameter("now");
		Calendar now1 = Calendar.getInstance();  
        int year = now1.get(Calendar.YEAR);  
        int month = now1.get(Calendar.MONTH)+1 ; 
        int day = now1.get(Calendar.DAY_OF_MONTH); 
	 %>
	 	<strong><font size="4" color="blue">您好，今天是<%=year %>年<%=month %>月<%=day %>日</font></strong>
	 	<div class="center">
	 	<h3>图书修改信息</h3>
		<form name="Bookupdate" method="post" action="/Mywork/ApplicationController" onsubmit="return checkBookInfo();">
			<table name="BookInfo" border="0" cellspacing="0">
				<tr>
					<td><label for="no">图书编号：</label></td>
					<td><input type="text" name="no" id="no" value="<%=no%>" readonly></td>
				</tr>
				<tr>
					<td><label for="name">书名：</label></td>
					<td><input type="text" name="name" id="name" value="<%=name%>"></td>
				</tr>
				<tr>
					<td><label for="writer">作者：</label></td>
					<td><input type="text" name="writer" id="writer" value="<%=writer%>"></td>
				</tr>
				<tr>
					<td><label for="topic">主题：</label></td>
					<td><input type="text" name="topic" id="topic" value="<%=topic%>"></td>
				</tr>
				<tr>
					<td><label for="all">总计：</label></td>
					<td><input type="text" name="all" id="all" value="<%=all%>" readonly></td>
				</tr>
				<tr>
					<td><label for="now">借出：</label></td>
					<td><input type="text" name="now" id="now" value="<%=now%>" readonly></td>
				</tr>
			</table>
				<input type="hidden" name="entity" id="entity" value="Book">
				<input type="hidden" name="operation" id="operation" value="update" >
				<input type="submit" name="submit" value="修改">
				<input type="button" name="cancel" value="取消" onclick="javascript:history.go(-1)">
		</form>
		</div>
	</body>
</html>