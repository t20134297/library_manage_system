<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>搜索的图书不存在</title>
		<script language="javascript">
			function gotoportal()
   				{
   					document.location.href ="/Mywork/portal.jsp";
   				}
		</script>
	</head>
	<body>
		<h3>要搜索的图书不存在</h3>
		 <input type="button" name="Continue" value="继续搜索图书" onclick="javascript:history.go(-1);"> 
		 <input type="button" name="back" value="退回主页" onclick="gotoportal()"> 
	</body>
</html>