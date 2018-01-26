<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.Calendar"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>归还图书</title>
		<% 
			request.setCharacterEncoding("UTF-8");
			String no = request.getParameter("no");
			String name = request.getParameter("name");
			String bookno = request.getParameter("bookno");
			String bookname = request.getParameter("bookname");
			String borrowdate = request.getParameter("borrowdate");
			String returndate = request.getParameter("returndate");  
			Calendar now1 = Calendar.getInstance();  
	        int year = now1.get(Calendar.YEAR);  
	        int month = now1.get(Calendar.MONTH)+1 ; 
	        int day = now1.get(Calendar.DAY_OF_MONTH); 
		%>
		<style type="text/css" media="screen">
		.center
		{
			position:absolute;
			left: 30%;
			top: 18%;
		}
	</style>
	<style type="text/css"> 
		body
		{ 
		    background-image:url(borrow.jpg);
		    background-repeat:no-repeat;
		} 
	</style>
	</head>
	<body>
		<strong><font size="4" color="blue">您好，今天是<%=year %>年<%=month %>月<%=day %></font></strong>
		<div class="center">
		<h3>归还图书信息</h3>
		<form name="Borrowdelete" method="post" action="/Mywork/ApplicationController" >
			<table id="BorrowInfo" border="0" cellspacing="0">
				<tr>
					<td><label for="no">读者编号：</label></td>
					<td><input type="text" name="no" id="no" value="<%=no%>" readonly></td>
				</tr>
				<tr>
					<td><label for="name">姓名：</label></td>
					<td><input type="text" name="name" id="name" value="<%=name%>" readonly></td>
				</tr>
					<tr>
						<td><label for="bookno">图书编号：</label></td>
						<td><input type="text" name="bookno" id="bookno" value="<%=bookno%>" readonly></td>
					</tr>
					<tr>
						<td><label for="bookname">书名：</label></td>
						<td><input type="text" name="bookname" id="bookname" value="<%=bookname %>" readonly></td>
					</tr>
					<tr>
						<td><label for="borrowdate">借书日期：</label></td>
						<td><input type="text" name="borrowdate" id="borrowdate" value="<%=borrowdate%>" readonly></td>
					</tr>
					<tr>
						<td><label for="returndate">还书日期：</label></td>
						<td><input type="text" name="returndate" id="returndate" value="<%= returndate%>" readonly></td>
					</tr>
			</table>
				<input type="hidden" name="entity" id="entity" value="Borrow">
				<input type="hidden" name="operation" id="operation" value="return">
			<p>
				<input type="submit" name="submit" value="归还" >
				<input type="button" name="cancel" value="取消" onclick="javascript:history.go(-1)" >
			</p>	
		</form>
		</div>
	</body>
</html>