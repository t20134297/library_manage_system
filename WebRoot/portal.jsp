<%@ page language="java"  pageEncoding="UTF-8"%>
<%@page import="java.util.Calendar"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <script language="javascript">
   	function manageBook()
   	{
   		document.location.href="/Mywork/ApplicationController?entity=Book&&operation=query";
   	}
   	function manageReader()
   	{
   		document.location.href="/Mywork/ApplicationController?entity=Reader&&operation=query";
   	}
   	function manageBorrow()
   	{
   		document.location.href="/Mywork/ApplicationController?entity=Borrow&&operation=query";
   	}
   	function managePurchase()
   	{
   		document.location.href="/Mywork/ApplicationController?entity=Purchase&&operation=query";
   	}
   	function gotoexit()
   	{
		window.close();
	}
	function gotoDream()
		{
			document.location.href ="/Mywork/Dream.jsp";
		}
	function gotoInternet()
	{
		document.location.href ="/Mywork/Internet.jsp";
	}
   </script>
   	<style type="text/css" media="screen">
		.center
		{
			position:absolute;
			left: 34%;
			top: 25%;
		}
	</style>
	<style type="text/css"> 
			body
		{ 
		    background-image:url(portal.jpg);
		    background-repeat:no-repeat;
		} 
	</style>
	 <%
  		Calendar now1 = Calendar.getInstance();  
        int year = now1.get(Calendar.YEAR);  
        int month = now1.get(Calendar.MONTH)+1 ; 
        int day = now1.get(Calendar.DAY_OF_MONTH); 
   %>
  </head>
  
  <body>
  <strong><font size="4" color="red">您好，今天是<%=year %>年<%=month %>月<%=day %>日</font></strong>
  <div class="center">
   <p>
   	<input type="button" name="Book" value="图书管理" onclick="manageBook()" >
   </p>
   <p>
   	<input type="button" name="Reader" value="读者管理" onclick="manageReader()">
   </p> 
   <p>
   	<input type="button" name="Purchase" value="采购管理" onclick="managePurchase()">
   </p>
   <p>
   	<input type="button" name="Borrow" value="借阅管理" onclick="manageBorrow()">
   </p>
   <p>
   <input type="button" name="internet" value="友情链接" onclick="gotoInternet()">
   </p>
   <p>
   <input type="button" name="dream" value="梦想" onclick="gotoDream()">
   </p>
   <p>
   <input type="button" name="exit" value="退出" onclick="gotoexit()">
   </p>
   </div>
  </body>
</html>
