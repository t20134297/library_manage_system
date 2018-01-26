<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="javabean.BorrowPO" %>
<%@page import="java.util.Calendar"%>
<%
	request.setCharacterEncoding("UTF-8");
	List<BorrowPO> borrows = (List<BorrowPO>)request.getAttribute("Borrowlist");
	Calendar now1 = Calendar.getInstance();  
    int year = now1.get(Calendar.YEAR);  
    int month = now1.get(Calendar.MONTH)+1 ; 
    int day = now1.get(Calendar.DAY_OF_MONTH); 
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>借阅列表</title>
   <script type="text/javascript">
   	function choose(number)
   	{
   		var rowno = eval(number);
   		document.forwarder.no.value = document.all("listBorrow").rows[rowno].cells[0].innerText;
   		document.forwarder.name.value = document.all("listBorrow").rows[rowno].cells[1].innerText;
   		document.forwarder.bookno.value = document.all("listBorrow").rows[rowno].cells[2].innerText;
   		document.forwarder.bookname.value = document.all("listBorrow").rows[rowno].cells[3].innerText;
   		document.forwarder.borrowdate.value = document.all("listBorrow").rows[rowno].cells[4].innerText;
   		document.forwarder.returndate.value = document.all("listBorrow").rows[rowno].cells[5].innerText;
   		if(document.all("listBorrow").rows.length>1)
   		{
   			for(var i = 1;i<document.all("listBorrow").rows.length;i++)
   			{
   				document.all("listBorrow").rows[i].style.backgroundColor="";
   			}
   		}
   		document.all("listBorrow").rows[rowno].style.backgroundColor="#ff998f";
   	}
   	function gotoAdd()
   	{
   		document.forwarder.action = "Borrowadd.jsp";
   		document.forwarder.submit();
   	}
   	function gotoReturn()
   	{  		
   		var judge = document.forwarder.returndate.value;
   		if(judge == "未还")
   		{
	   		document.forwarder.action="Borrowreturn.jsp";
	   		document.forwarder.submit();
   		}
   		else
   		{
   			alert("该书已经归还");
   			return false;
   		}
   	}
   	function gotoDelete()
   	{
   		var jud = document.forwarder.returndate.value;
   		if(jud == "未还")
   		{
   			alert("该书未还，不可以删除几月记录");
   			return false;
   		}
   		document.forwarder.action="Borrowdelete.jsp";
   		document.forwarder.submit();
   	}
   	function gotoSearch()
   	{
   		document.forwarder.action="Borrowsearch.jsp";
   		document.forwarder.submit();
   	}
   	function gotoportal()
   	{
   		document.location.href ="/Mywork/portal.jsp";
   	}
   </script>
   <style type="text/css" media="screen">
		.center
		{
			position:absolute;
			left: 20%;
			top: 8%;
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
  
  <body >
  	<strong><font size="4" color="blue">您好，今天是<%=year %>年<%=month %>月<%=day %>日</font></strong>
  	<div class="center">
  	<h3>借阅列表</h3>
     <table name="listBorrow" id="listBorrow" >
    	<tr align="center">
    	<td>读者编号</td><td>姓名</td><td>所借图书编号</td><td>书名</td><td>借书日期</td><td>还书日期</td>
    	</tr>
    		<% BorrowPO borrow;
    		for(int index=0;index<borrows.size();index++)
    		{
    			borrow = borrows.get(index);%>
    	
    	 <tr align="center" onclick="choose('<%= index+1 %>')">
    	 	<td><%= borrow.getbno() %></td>
    	 	<td><%= borrow.getbname()%></td>
    	 	<td><%= borrow.getbookno()%></td>
    	 	<td><%= borrow.getbookname()%></td>
    	 	<td><%= borrow.getborrowdate() %></td>
    	 	<td><%= borrow.getreturndate() %></td>
    	 </tr>
    	 <%}%>
    </table>
    <p>
    	<input type="button" name="add" value="读者借阅" onclick="gotoAdd()">
    	<input type="button" name="return" value="读者还书" onclick="gotoReturn()">
    	<input type="button" name="update" value="删除借阅记录" onclick="gotoDelete()">
    	<input type="button" name="search" value="搜索图书" onclick="gotoSearch()">
    	<input type="button" name="exit" value="退出" onclick="gotoportal()">
    </p>
    <form name="forwarder" method="post" id="forwarder">
    	<input type="hidden" name="no" id="no"/>
    	<input type="hidden" name="name" id="name" />
    	<input type="hidden" name="bookno" id="bookno"/>
    	<input type="hidden" name="bookname" id="bookname"/>
    	<input type="hidden" name="borrowdate" id="borrowdate"/>
    	<input type="hidden" name="returndate" id="returndate"/>
    </form>
    </div>
  </body>
</html>
