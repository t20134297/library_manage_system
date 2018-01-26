<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>友情链接</title>
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
			left: 30%;
			top: 25%;
		}
	</style>
	<style type="text/css"> 
		body
		{ 
		    background-image:url(internet.jpg);
		    background-repeat:no-repeat;
		} 
	</style>
	</head>
	<body>
		<div class="center">
			<a href='http://www.neu.edu.cn/'>东北大学官网</a> <br><br>			
			<a href='http://aao.neu.edu.cn/'>东北大学教务处</a><br><br>
			<a href='http://www.ise.neu.edu.cn/'>东北大学信息学院</a><br><br>
			<a href='http://www.baidu.com/'>百度搜索</a><br><br>
		    <input type="button" name="back" value="退回主页" onclick="gotoportal()"> 
		</div>
		
	</body>
</html>