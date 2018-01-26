<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>增加图书编号重复</title>
		<script language="javascript">
					function gotoportal()
		   				{
		   					document.location.href ="/Mywork/portal.jsp";
		   				}
		</script>
		<style type="text/css" media="screen">
		.center
		{
			position:absolute;
			left: 35%;
			top: 25%;
		}
	</style>
	<style type="text/css"> 
		body
		{ 
		    background-image:url(sorry.jpg);
		    background-repeat:no-repeat;
		} 
	</style>
	</head>
	<body>
	    <div class="center">
		<h3>该图书编号已经存在不能再添加</h3>
		 <input type="button" name="Continue" value="继续添加其他图书" onclick="javascript:history.go(-1);"> 
		 <input type="button" name="back" value="退回主页" onclick="gotoportal()"> 
		 </div>
	</body>
</html>