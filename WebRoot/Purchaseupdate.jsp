<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="javabean.PurchasePO" %>
<%@page import="java.util.Calendar"%>
<%
	request.setCharacterEncoding("UTF-8");
	List<PurchasePO> purs = (List<PurchasePO>)session.getAttribute("Purchaselist");
	Calendar now1 = Calendar.getInstance();  
    int year = now1.get(Calendar.YEAR);  
    int month = now1.get(Calendar.MONTH)+1 ; 
    int day = now1.get(Calendar.DAY_OF_MONTH); 
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>采购列表</title>
  <style type="text/css" media="screen">
		.center
		{
			position:absolute;
			left: 35%;
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
  <body >
  <strong><font size="4" color="blue">您好，今天是<%=year %>年<%=month %>月<%=day %></font></strong>
  	<div class="center">
  	<h3>采购记录</h3>
     <table name="listPurchase" id="listPurchase" >
    	<tr align="center">
    	<td>图书编号</td><td>书名</td><td>作者</td><td>主题</td><td>购买总计</td>
    	</tr>
    		<% PurchasePO pur;
    		for(int index=0;index<purs.size();index++)
    		{
    			pur = purs.get(index);
    			if(pur.getPall()>0){%>
    	
    	 <tr align="center" onclick="choose('<%= index+1 %>')">
    	 	<td><%= pur.getPno() %></td>
    	 	<td><%= pur.getPname()%></td>
    	 	<td><%= pur.getPwriter()%></td>
    	 	<td><%= pur.getPtopic()%></td>
    	 	<td><%= pur.getPall() %></td>
    	 </tr>
    	 <%}%>
    	 <%} %>
    </table>
   
    	<input type="button" name="exit" value="退出" onclick="javascript:history.go(-1)"> 
    	</div>
  </body>
</html>
