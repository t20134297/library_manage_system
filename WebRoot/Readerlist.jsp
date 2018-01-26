<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="javabean.ReaderPO" %>
<%@page import="java.util.*" %>
<%@page import="java.util.Calendar"%>
<%
	 request.setCharacterEncoding("UTF-8");
     List<ReaderPO> readers = (List<ReaderPO>)session.getAttribute("Readerlist");
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>读者列表</title>
	<script language="javascript">
		function choose(number)
		{
		   	var rowno = eval(number);
		   	document.forwarder.no.value = document.all("Readerlist").rows[rowno].cells[0].innerText;
		   	document.forwarder.style.value = document.all("Readerlist").rows[rowno].cells[1].innerText;
		  	document.forwarder.name.value = document.all("Readerlist").rows[rowno].cells[2].innerText;
		  	document.forwarder.sex.value = document.all("Readerlist").rows[rowno].cells[3].innerText;
		  	document.forwarder.age.value = document.all("Readerlist").rows[rowno].cells[4].innerText;
		  	document.forwarder.dept.value = document.all("Readerlist").rows[rowno].cells[5].innerText;
		  	document.forwarder.all.value = document.all("Readerlist").rows[rowno].cells[6].innerText;
		  	if (document.all("Readerlist").rows.length>1) 
		  		{
		  		for (var i=1; i<document.all("Readerlist").rows.length; i++)
		  			{
		  				document.all("Readerlist").rows[i].style.backgroundColor="";
		  			}
		  		}
		  		document.all("Readerlist").rows[rowno].style.backgroundColor="#ff998f";	  	
 			}
		  function gotoAdd()
		  	{
		   		document.forwarder.action="Readeradd.jsp";
		    	document.forwarder.submit();   
		   	}
		  function gotoUpdate()
		  	{
		   		document.forwarder.action="Readerupdate.jsp";
		   		document.forwarder.submit();   
		    }
		 function gotoDelete()
				{
					document.forwarder.action="Readerdelete.jsp";
					document.forwarder.submit();   
				}
	   	 function gotoPortal()
				{
					document.location.href ="/Mywork/portal.jsp";   		
				}
			</script>
			<style type="text/css" media="screen">
		.center
		{
			position:absolute;
			left: 26%;
			top: 8%;
		}
	</style>
	<style type="text/css"> 
		body
		{ 
		    background-image:url(reader.jpg);
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
		<h3>读者列表</h3>
		<table name="Readerlist" id="Readerlist">
			<tr align="center">
				<td>读者编号</td>
				<td>读者类型</td>
				<td>读者姓名</td>
				<td>读者性别</td>
				<td>读者年龄</td>
				<td>读者所在学院</td>
				<td>借阅数量</td>
			</tr>
			</Tr>
			<% ReaderPO reader;
				for (int index = 0; index < readers.size(); index++)
				{
					reader = readers.get(index);
			
			 %>
			<tr onclick="choose('<%=index+1%>')" align="center">
			  <td><%=reader.getRno()%></td>
			  <td><%=reader.getRstyle() %></td>
			  <td><%=reader.getRname()%></td>
			  <td><%=reader.getRsex()%></td>
			  <td><%=reader.getRage()%></td>
			  <td><%=reader.getRdept() %></td>
			  <td><%=reader.getRall() %></td>
			</tr>
			<%} %>
		</table>
		<p>
		  <input type="button" name="add" value="新增" onclick="gotoAdd()"> 
		  <input type="button" name="update" value="修改" onclick="gotoUpdate()">
		  <input type="button" name="delete" value="删除" onclick="gotoDelete()"> 
		  <input type="button" name="exit" value="退回门户" onclick="gotoPortal()"> 
		</p> 
		<form  method="post" name="forwarder" id="forwarder">
			<input type="hidden" name="no" id="no" />
			<input type="hidden" name="style" id="style" />
			<input type="hidden" name="name" id="name" />
			<input type="hidden" name="sex" id="sex" />
			<input type="hidden" name="age" id="age" />
			<input type="hidden" name="dept" id="dept"/>
			<input type="hidden" name="all" id="all"/>	
		</form> 
		</div>
	</body>
</html>