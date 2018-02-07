<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Bean.Product"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shouting Shopping</title>
<style>
#header {
    background-color:black;
    color:white;
    text-align:center;
    padding:5px;
}
#nav {
    line-height:30px;
    background-color:#eeeeee;
    height:300px;
    width:100px;
    float:left;
    padding:5px; 
}


</style>
</head>
<body>
	<header id="header">
		<h1>Shouting Shopping Website</h1>
	</header>
	<div id="nav">
		<a href="ShoppingController?type=Books" >Books</a> <br />
		<a href="ShoppingController?type=Music" >Music</a> <br />
		<a href="ShoppingController?type=Computers" >Computers</a> <br />
		<a href="ShoppingController?nav=myCart"> View My Cart</a>
	</div>

</body>
</html>