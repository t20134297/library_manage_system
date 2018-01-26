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
<title>搜素图书</title>
<style type="text/css" media="screen">
		.center
		{
			position:absolute;
			left: 30%;
			top: 20%;
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
<h3>搜索借阅</h3>
<form align="center" name="Borrowsearch" method="post" action="/Mywork/ApplicationController"> 
	<table>
	    <tr>
	       	<td><label for="key">关键字：</label></td>
	       	<td>
	       		<select name="key" id="key">
	       			<option>书名</option>
	       			<option>作者</option>
	       			<option>主题</option>
	       		</select>
	       	</td>
	    </tr>
	    <tr>
		    <td><label for="word">输入要查找的内容：</label></td>
		    <td><input type="text" name="word" id="word" value="请输入要搜索的内容"></td>
	    </tr>
	    </table>
 	<input  name="entity" id="entity" value="Borrow" type="hidden">		
	<input  name="operation" id="operation" value="search" type="hidden">
	 <p> 
	  	<input type="submit" name="Submit" value="搜索" >
	    <input type="button" name="Cancel" value="取消" onclick="javascript:history.go(-1);"> 
	 </p>  
  </form>
  </div>
</body>
</html>