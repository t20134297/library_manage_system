<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>重复借阅提示</title>
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
			left: 2%;
			top: 25%;
		}
	</style>
	</head>
	<body>
		<div class="center">
			<font size="6" color="red">都说大学越上，梦想越少，但是始终有一个梦想，希望某门课程得到100分</font>
			<input type="button" name="Continue" value="圆梦" onclick="javascript:history.go(-1);"> 		 
		</div>
		
	</body>
</html>
