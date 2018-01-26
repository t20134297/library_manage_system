<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="javabean.BookPO" %>
<%@page import="javabean.ReaderPO" %>
<%@page import="java.util.Calendar"%>
<%
	request.setCharacterEncoding("UTF-8");
	List<BookPO> books = (List<BookPO>)session.getAttribute("Booksname");
	List<ReaderPO> readers =(List<ReaderPO>)session.getAttribute("Readerlist"); 
	Calendar now1 = Calendar.getInstance();  
    int year = now1.get(Calendar.YEAR);  
    int month = now1.get(Calendar.MONTH)+1 ; 
    int day = now1.get(Calendar.DAY_OF_MONTH); 
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>搜索结果借阅</title>
  <script language="javascript">
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
   	function check()
   	{
   		var judge = document.forwarder.all.value;
   		var test = /^[0-9]*[1-9][0-9]*$/;
					if(!test.test(judge))		
					{
						alert("请选择图书");						
						return false;
					} 		
   	}
  </script>
   <style type="text/css" media="screen">
		.center
		{
			position:absolute;
			left: 28%;
			top: 12%;
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
  	<strong><font size="4" color="blue">您好，今天是<%=year %>年<%=month %>月<%=day %></font></strong>
  	<div class="center">
  	<h3>结果借阅</h3>
     <table name="listBook" id="listBook" >
    	<tr align="center">
    	<td>图书编号</td><td>书名</td><td>作者</td><td>主题</td><td>总计</td><td>借出</td>
    	</tr>
    		<% BookPO book;
    		for(int index=0;index<books.size();index++)
    		{
    			book = books.get(index);
    			if(book.getBnow()<book.getBall())
    			 {%>
    	
    	 <tr align="center" onclick="choose('<%= index+1 %>')">
    	 	<td><%= book.getBno() %></td>
    	 	<td><%= book.getBname()%></td>
    	 	<td><%= book.getBwriter()%></td>
    	 	<td><%= book.getBtopic()%></td>
    	 	<td><%= book.getBall() %></td>
    	 	<td><%= book.getBnow() %></td>
    	 </tr>
    	 <%} %>
    	 <%}%>
    </table>
    <form name="forwarder" method="post" id="forwarder" onsubmit="return check();">
    	<tr>
    	<td><label for="bno">读者编号和姓名: </label></td>
     	<td><select name="bno" id="bno">     
          	<% for(ReaderPO reader:readers)
          		if(reader.getRall()<5)
          	{%>          	
          		<option> <%=reader.getRno()+" "+reader.getRname()%></option>
          	<% } %>
        </select></td>        
    </tr>
        <input type="hidden" name="no" id="no"/>
    	<input type="hidden" name="name" id="name" />
    	<input type="hidden" name="writer" id="writer"/>
    	<input type="hidden" name="topic" id="topic"/>
    	<input type="hidden" name="all" id="all"/>
    	<input type="hidden" name="now" id="now"/>
    <p> 
	  	<input type="submit" name="Submit" value="借阅" >
	    <input type="button" name="Cancel" value="取消" onclick="javascript:history.go(-1);"> 
	 </p>  
	 <input  name="entity" id="entity" value="Borrow" type="hidden">		
	<input  name="operation" id="operation" value="searchinsert" type="hidden">
    </form>
    </div>
  </body>
</html>
