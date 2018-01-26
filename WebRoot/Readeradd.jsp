<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import = "javabean.ReaderPO" %>
<%@page import ="java.util.List" %>
<%@page import="java.util.Calendar"%>
<%
	request.setCharacterEncoding("UTF-8");
	/*List<BookPO> books = (List<BookPO>)session.getAttribute("Booklist");*/
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	 <title>增加读者</title>
	  <script type="text/javascript">			
		function checkReaderInfo()
		{
			var _no =document.Readeradd.no.value;
			var _name = document.Readeradd.name.value;
			var _age = document.Readeradd.age.value;
			var _dept = document.Readeradd.dept.value;
			if( _no == null || _no.indexOf(" ") >=0 || _no=="")     
				{
					alert("读者编号不能为空,且不能有空格");
					document.Readeradd.no.focus();
					return false;
				}
			if(_name == null ||  _name.indexOf(" ") >=0 ||_name.toString()=="")
				{
					alert("学生姓名不能为空,且不能有空格");
					document.Readeradd.name.focus();
					return false;
				}
			if( _age == null ||  _age.indexOf(" ") >=0 || _age=="")
				{
					alert("年龄不能为空,且不能有空格");
					document.Readeradd.age.focus();
					return false;
				}
			else
				{
					var test = /^[0-9]*[1-9][0-9]*$/;
					if(!test.test(_age))
					{
						alert("输入的年龄必须为整数");
						document.Readeradd.age.focus();
						return false;
					}
				}
			if( _dept == null || _dept.indexOf(" ") >=0 || _dept=="")    
				{
					alert("学院不能为空,且不能有空格");
					document.Readeradd.dept.focus();
					return false;
				}
			return true;
		}
	</script>
	<style type="text/css" media="screen">
		.center
		{
			position:absolute;
			left: 31%;
			top: 16%;
		}
	</style>
	<style type="text/css"> 
		body
		{ 
		    background-image:url(reader.jpg);
		    background-repeat:no-repeat;
		} 
	</style>
  </head>
 		<%
  		Calendar now1 = Calendar.getInstance();  
        int year = now1.get(Calendar.YEAR);  
        int month = now1.get(Calendar.MONTH)+1 ; 
        int day = now1.get(Calendar.DAY_OF_MONTH); 
   		%>						 
  <body>
  	<strong><font size="4" color="red">您好，今天是<%=year %>年<%=month %>月<%=day %>日</font></strong>
  	 <div class="center">
    <h3>增加读者信息</h3>
     <form align="center" name="Readeradd" method="post" action="/Mywork/ApplicationController" onsubmit="return checkReaderInfo();">
    	<table>
	    	<tr>
	    		<td><label for="no">读者编号:</label></td>
	    		<td><input type="text" name="no" id="no" ></td>
	    	</tr>
	    	<tr>
	    		<td><label for="style">读者类型</td>
	    		<td>
	    			<select name="style" id="style">
							<option>学生</option>
							<option >教师</option>
						</select >
	    		</td>
	    	</tr>
	    	<tr>
	    		<td><label for="name">姓名:</label></td>
	    		<td><input type="text" name="name" id="name"></td>
	    	</tr>
	    	<tr>
	    		<td><label for="sex">性别：</label></td>
	    		<td>
		    		<select name="sex" id="sex">
			    		<option>男</option>
			    		<option>女</option>
		    		</select>
	    		</td>
	    	</tr>
	    	<tr>
	    		<td><label for="age">年龄:</label></td>
	    		<td><input type="text" name="age" id="age"></td>
	    	</tr>
	    	<tr>
	    		<td><label for="dept">学院：</label></td>
	    		<td><input type="text" name="dept" id="dept"></td>
	    	</tr>
	    	<tr>
	    		<td><label for="all">借阅数量：</label></td>
	    		<td><input type="text" name="all" id="all" value="0" readonly></td>
	    	</tr>
    	</table>
    	<input type="hidden" name="entity" id="entity" value="Reader">
    	<input type="hidden" name="operation" id="operation" value="insert">
    	<p>
    		<input type="submit" name ="submit" value="提交">
    		<input type="button" name="cancel" value="取消" onclick="javascript:history.go(-1)">
    	</p>	
    </form>
    </div>
  </body>
</html>
