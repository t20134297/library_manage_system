<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.Calendar"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>图书购买</title>
		<style type="text/css" media="screen">
		.center
		{
			position:absolute;
			left: 38%;
			top: 25%;
		}
	</style>
	<style type="text/css"> 
		body
		{ 
		    background-image:url(purchase.jpg);
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
		String change = request.getParameter("change");
		Calendar now1 = Calendar.getInstance();  
        int year = now1.get(Calendar.YEAR);  
        int month = now1.get(Calendar.MONTH)+1 ; 
        int day = now1.get(Calendar.DAY_OF_MONTH); 
	 %>
	 	<strong><font size="4" color="red">您好，今天是<%=year %>年<%=month %>月<%=day %>日</font></strong>
	 	<div class="center">
	 	<h3>采购图书</h3>
		<form name="Purchaseadd" method="post" action="/Mywork/ApplicationController"  >
			<table name="PurchaseInfo" border="0" cellspacing="0">
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
					<td><label for="topic">主题：</label></td>
					<td><input type="text" name="topic" id="topic" value="<%=topic%>" readonly></td>
				</tr>
				<tr>
					<td><label for="all">购买后的数量：</label></td>
					<td>
						<select name="all" id="all">
							<% for(int i=Integer.parseInt(all)+1;i<6;i++) {%>
							<option><%=i %></option>
							<%}%>
							<option selected = "selected"><%=all %></option>
						</select >
					</td>
				</tr>
				<tr>
					<td><label for="now">借出：</label></td>
					<td><input type="text" name="now" id="now" value="<%=now%>" readonly></td>
				</tr>
			</table>
				<input type="hidden" name="entity" id="entity" value="Purchase">
				<input type="hidden" name="operation" id="operation" value="update" >
				<input type="submit" name="submit" value="购买" >
				<input type="button" name="cancel" value="取消" onclick="javascript:history.go(-1)">
		</form>
		</div>
	</body>
</html>