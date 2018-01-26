<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import = "javabean.BookPO" %>
<%@page import="java.util.Calendar"%>
<%@page import ="java.util.List" %>
<%
	request.setCharacterEncoding("UTF-8");
	/*List<BookPO> books = (List<BookPO>)session.getAttribute("Booklist");*/
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	 <title>图书增加</title>
	  <script type="text/javascript">			
		function checkBookInfo()
		{
			var _no =document.Bookadd.no.value;
			var _name = document.Bookadd.name.value;
			var _writer = document.Bookadd.writer.value;
			var _topic = document.Bookadd.topic.value;
			if( _no == null || _no.indexOf(" ") >=0 || _no=="")     
			{
				alert("图书编号不能为空,且不能有空格");
				document.Bookadd.no.focus();
				return false;
			}
			if(_name == null ||  _name.indexOf(" ") >=0 ||_name.toString()=="")
			{
				alert("书名不能为空,且不能有空格");
				document.Bookadd.name.focus();
				return false;
			}
			if(_writer == null || _writer.indexOf(" ") >=0 || _writer=="")
			{
				alert("作者不能为空,且不能有空格");
				document.Bookadd.writer.focus();
				return false;
			}
			if(_topic == null ||  _topic.indexOf(" ") >=0 || _topic=="")
			{
				alert("主题不能为空,且不能有空格");
				document.Bookadd.topic.focus();
				return false;
			}
			return true;
		}
	</script>
	<%
  		Calendar now = Calendar.getInstance();  
        int year = now.get(Calendar.YEAR);  
        int month = now.get(Calendar.MONTH)+1 ; 
        int day = now.get(Calendar.DAY_OF_MONTH); 
   %>
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
		    background-image:url(book.jpg);
		    background-repeat:no-repeat;
		} 
	</style>
  </head>
 								 
  <body>
  <strong><font size="4" color="blue">您好，今天是<%=year %>年<%=month %>月<%=day %>日</font></strong>
  	<div class="center">
    <h3>增加图书信息</h3>
     <form align="center" name="Bookadd" method="post" action="/Mywork/ApplicationController" onsubmit="return checkBookInfo();">
    	<table>
	    	<tr>
	    		<td><label for="no">图书编号:</label></td>
	    		<td><input type="text" name="no" id="no" ></td>
	    	</tr>
	    	<tr>
	    		<td><label for="name">书名:</label></td>
	    		<td><input type="text" name="name" id="name"></td>
	    	</tr>
	    	<tr>
	    		<td><label for="writer">作者：</label></td>
	    		<td><input type="text" name="writer" id="writer"></td>
	    	</tr>
	    	<tr>
	    		<td><label for="topic">主题:</label></td>
	    		<td><input type="text" name="topic" id="topic"></td>
	    	</tr>
	    	<tr>
	    		<td><label for="all">总计:</label></td>
	    		<td><input type="text" name="all" id="all" value="0" readonly></td>
	    	</tr>
	    	<tr>
	    		<td><label for="now">借出：</label></td>
	    		<td><input type="text" name="now" id="now" value="0" readonly></td>
	    	</tr>
    	</table>
    	<input type="hidden" name="entity" id="entity" value="Book">
    	<input type="hidden" name="operation" id="operation" value="insert">
    	<p>
    		<input type="submit" name ="submit" value="增加">
    		<input type="button" name="cancel" value="取消" onclick="javascript:history.go(-1)">
    	</p>	
    </form>
    </div>
  </body>
</html>
