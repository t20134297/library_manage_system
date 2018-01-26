<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.Calendar"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>删除图书</title>
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
		<script language="javascript" >
			function check()
			{
				var jc = document.Bookdelete.now.value;
				if(parseInt(jc) != 0 )
				 {
				 	alert("该书有借出不能删除记录");
				 	return false;
				 }
			}
		</script>
		<style type="text/css" media="screen">
		.center
		{
			position:absolute;
			left: 38%;
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
		<strong><font size="4" color="blue">您好，今天是<%=year %>年<%=month %>月<%=day %>日</font></strong>
		<div class="center">
		<h3>删除图书信息</h3>
		<form name="Bookdelete" method="post" action="/Mywork/ApplicationController" onsubmit="return check();">
			<table id="BookInfo" border="0" cellspacing="0">
				<tr>
					<td><label for="no">图书编号：</label></td>
					<td><input type="text" name="no" id="no" value="<%=no%>" readonly></td>
				</tr>
				<tr>
					<td><label for="name">书名：</label></td>
					<td><input type="text" name="name" id="name" value="<%=name%>" readonly></td>
				</tr>
					<tr>
						<td><label for="writer">作者：</label></td>
						<td><input type="text" name="writer" id="writer" value="<%=writer%>" readonly></td>
					</tr>
					<tr>
						<td><label for="topic">单价：</label></td>
						<td><input type="text" name="topic" id="topic" value="<%=topic%>" readonly></td>
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
				<input type="hidden" name="operation" id="operation" value="delete">
			<p>
				<input type="submit" name="submit" value="删除" >
				<input type="button" name="cancel" value="取消" onclick="javascript:history.go(-1)" >
			</p>	
		</form>
		</div>
	</body>
</html>