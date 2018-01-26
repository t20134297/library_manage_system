<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="javabean.ReaderPO"%>
<%@page import="javabean.BookPO"%>
<%@page import="javabean.BorrowPO" %>
<%@page import= "java.util.List" %>
<%@page import="java.util.Calendar"%>
<%
    request.setCharacterEncoding("UTF-8");
    List<ReaderPO> readers=(List<ReaderPO>)session.getAttribute("Readerlist");
    List<BookPO> books=(List<BookPO>)session.getAttribute("Booklist");
	Calendar now1 = Calendar.getInstance();  
        int year = now1.get(Calendar.YEAR);  
        int month = now1.get(Calendar.MONTH)+1 ; 
        int day = now1.get(Calendar.DAY_OF_MONTH); 
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>借阅图书</title>
<style type="text/css" media="screen">
		.center
		{
			position:absolute;
			left: 35%;
			top: 15%;
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
<strong><font size="4" color="blue">您好，今天是<%=year %>年<%=month %>月<%=day %>日</font></strong>
<div class="center">
<h3>借阅图书</h3>
<form align="center" name="Borrowadd" method="post" action="/Mywork/ApplicationController">
  <table>
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
    <tr>
        <td><label for="bookno">图书编号和书名: </label></td>
        <td><select name="bookno" id="bookno">        
          	<% for(BookPO book:books)
          	if(book.getBnow()<book.getBall()) 
          	{%>
          	 <option> <%=book.getBno()+" "+book.getBname() %></option>
          	<% } %>
        </select></td>
    </tr>
    </table>
 	<input  name="entity" id="entity" value="Borrow" type="hidden">		
	<input  name="operation" id="operation" value="insert" type="hidden">
	 <p> 
	  	<input type="submit" name="Submit" value="借阅" >
	    <input type="button" name="Cancel" value="取消" onclick="javascript:history.go(-1);"> 
	 </p>  
  </form>
  </div>
</body>
</html>