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
   <script type="text/javascript">
   	function choose(number)
   	{
   		var rowno = eval(number);
   		document.forwarder.no.value = document.all("listPurchase").rows[rowno].cells[0].innerText;
   		document.forwarder.name.value = document.all("listPurchase").rows[rowno].cells[1].innerText;
   		document.forwarder.writer.value = document.all("listPurchase").rows[rowno].cells[2].innerText;
   		document.forwarder.topic.value = document.all("listPurchase").rows[rowno].cells[3].innerText;
   		document.forwarder.all.value = document.all("listPurchase").rows[rowno].cells[4].innerText;
   		document.forwarder.now.value = document.all("listPurchase").rows[rowno].cells[5].innerText;
   		document.forwarder.change.value = document.all("listPurchase").rows[rowno].cells[6].innerText;
   		if(document.all("listPurchase").rows.length>1)
   		{
   			for(var i = 1;i<document.all("listPurchase").rows.length;i++)
   			{
   				document.all("listPurchase").rows[i].style.backgroundColor="";
   			}
   		}
   		document.all("listPurchase").rows[rowno].style.backgroundColor="#ff998f";
   	}
   	function gotoAdd()
   	{
   		document.forwarder.action = "Purchaseadd.jsp";
   		document.forwarder.submit();
   	}
   	function gotoDelete()
   	{
   		document.forwarder.action="Purchasedelete.jsp";
   		document.forwarder.submit();
   	}
   	function gotoUpdate()
   	{
   		document.forwarder.action="Purchaseupdate.jsp";
   		document.forwarder.submit();
   	}
   	function gotoportal()
   	{
   		document.location.href ="/Mywork/portal.jsp";
   	}
   	function gotonum()
   	{
   		document.forwarder.action="Booknum.jsp";
   		document.forwarder.submit();
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
		    background-image:url(purchase.jpg);
		    background-repeat:no-repeat;
		} 
	</style>
  </head>
  
  <body >
  	<strong><font size="4" color="red">您好，今天是<%=year %>年<%=month %>月<%=day %>日</font></strong>
  	<div class="center">
  	<h3>采购列表</h3>
     <table name="listPurchase" id="listPurchase" >
    	<tr align="center">
    	<td>图书编号</td><td>书名</td><td>作者</td><td>主题</td><td>总计</td><td>借出</td><td>是否需要购买</td>
    	</tr>
    		<% PurchasePO pur;
    		for(int index=0;index<purs.size();index++)
    		{
    			pur = purs.get(index);%>
    	
    	 <tr align="center" onclick="choose('<%= index+1 %>')">
    	 	<td><%= pur.getPno() %></td>
    	 	<td><%= pur.getPname()%></td>
    	 	<td><%= pur.getPwriter()%></td>
    	 	<td><%= pur.getPtopic()%></td>
    	 	<td><%= pur.getPall() %></td>
    	 	<td><%= pur.getPnow() %></td>
    	 	<td><%= pur.getPchange() %></td>
    	 </tr>
    	 <%}%>
    </table>
    <p>
    	<input type="button" name="add" value="购买图书" onclick="gotoAdd()">
    	<input type="button" name="delete" value="清理图书" onclick="gotoDelete()">
    	<input type="button" name="update" value="购买记录" onclick="gotoUpdate()">
    	<input type="button" name="exit" value="退出" onclick="gotoportal()">
    </p>
    <form name="forwarder" method="post" id="forwarder">
    	<input type="hidden" name="no" id="no"/>
    	<input type="hidden" name="name" id="name" />
    	<input type="hidden" name="writer" id="writer"/>
    	<input type="hidden" name="topic" id="topic"/>
    	<input type="hidden" name="all" id="all"/>
    	<input type="hidden" name="now" id="now">
    	<input type="hidden" name="change" id="change"/>
    </form>
    </div>
  </body>
</html>
