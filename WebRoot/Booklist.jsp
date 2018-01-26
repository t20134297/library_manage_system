<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="javabean.BookPO" %>
<%@page import="java.util.Calendar"%>
<%
	request.setCharacterEncoding("UTF-8");
	List<BookPO> books = (List<BookPO>)session.getAttribute("Booklist");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>图书列表</title>
   <script type="text/javascript">
   	function choose(number)
   	{
   		var rowno = eval(number);
   		document.forwarder.no.value = document.all("listBook").rows[rowno].cells[0].innerText;
   		document.forwarder.name.value = document.all("listBook").rows[rowno].cells[1].innerText;
   		document.forwarder.writer.value = document.all("listBook").rows[rowno].cells[2].innerText;
   		document.forwarder.topic.value = document.all("listBook").rows[rowno].cells[3].innerText;
   		document.forwarder.all.value = document.all("listBook").rows[rowno].cells[4].innerText;
   		document.forwarder.now.value = document.all("listBook").rows[rowno].cells[5].innerText;
   		if(document.all("listBook").rows.length>1)
   		{
   			for(var i = 1;i<document.all("listBook").rows.length;i++)
   			{
   				document.all("listBook").rows[i].style.backgroundColor="";
   			}
   		}
   		document.all("listBook").rows[rowno].style.backgroundColor="#ff998f";
   	}
   	function gotoAdd()
   	{
   		document.forwarder.action = "Bookadd.jsp";
   		document.forwarder.submit();
   	}
   	function gotoDelete()
   	{
   		var num = document.forwarder.all.value;
   		if(parseInt(num) != 0)
   		 {
   		 	alert("图书库中存在该图书，不能删除");
   		 	document.forwarder.action="Booklist.jsp";
   		 	return false;
   		 }
   		document.forwarder.action="Bookdelete.jsp";
   		document.forwarder.submit();
   	}
   	function gotoUpdate()
   	{
   		var num = document.forwarder.now.value;
   		if(parseInt(num) != 0)
   		 {
   		 	alert("该书有借出记录，不能修改");
   		 	document.forwarder.action="Booklist.jsp";
   		 	return false;
   		 }
   		document.forwarder.action="Bookupdate.jsp";
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
			left: 30%;
			top: 15%;
		}
	</style>
	<%
  		Calendar now = Calendar.getInstance();  
        int year = now.get(Calendar.YEAR);  
        int month = now.get(Calendar.MONTH)+1 ; 
        int day = now.get(Calendar.DAY_OF_MONTH); 
   %>
   <style type="text/css"> 
		body
		{ 
		    background-image:url(book.jpg);
		    background-repeat:no-repeat;
		} 
	</style>
  </head>
  
  <body >
  	<strong><font size="4" color="blue">您好，今天是<%=year %>年<%=month %>月<%=day %>日</font></strong>
  	<div class="center">
  	<h3>图书列表</h3>
     <table name="listBook" id="listBook" >
    	<tr align="center">
    	<td>图书编号</td><td>书名</td><td>作者</td><td>主题</td><td>总计</td><td>借出</td>
    	</tr>
    		<% BookPO book;
    		for(int index=0;index<books.size();index++)
    		{
    			book = books.get(index);%>
    	
    	 <tr align="center" onclick="choose('<%= index+1 %>')">
    	 	<td><%= book.getBno() %></td>
    	 	<td><%= book.getBname()%></td>
    	 	<td><%= book.getBwriter()%></td>
    	 	<td><%= book.getBtopic()%></td>
    	 	<td><%= book.getBall() %></td>
    	 	<td><%= book.getBnow() %></td>
    	 </tr>
    	 <%}%>
    </table>
    <p>
    	<input type="button" name="add" value="新增图书" onclick="gotoAdd()">
    	<input type="button" name="delete" value="删除图书记录" onclick="gotoDelete()">
    	<input type="button" name="update" value="修改图书" onclick="gotoUpdate()">
    	<input type="button" name="exit" value="退出" onclick="gotoportal()">
    </p>
    <form name="forwarder" method="post" id="forwarder">
    	<input type="hidden" name="no" id="no"/>
    	<input type="hidden" name="name" id="name" />
    	<input type="hidden" name="writer" id="writer"/>
    	<input type="hidden" name="topic" id="topic"/>
    	<input type="hidden" name="all" id="all"/>
    	<input type="hidden" name="now" id="now"/>
    </form>
    </div>
  </body>
</html>
