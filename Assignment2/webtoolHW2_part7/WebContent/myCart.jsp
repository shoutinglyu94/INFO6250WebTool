<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Bean.Product"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Shopping Cart</title>
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
#myCart {
    width:350px;
    float:left;
    padding:10px; 
}

</style>
</head>
<body>
	<header id="header">
	<h1>My Shopping Cart</h1>
	</header>
	<div id="nav">
		<a href="ShoppingController?type=Books">Books</a> <br /> <a
			href="ShoppingController?type=Music">Music</a> <br /> <a
			href="ShoppingController?type=Computers">Computers</a> <br />
	</div>
	
	<section id="myCart">
	<table>
	<tr>
	<th>Product Id</th>
	<th>Product Name</th>
	<th>Product Price</th>
	</tr>
	<% 
	if(session.getAttribute("myCart")!=null){
		ArrayList<Product> myCart = (ArrayList<Product>)session.getAttribute("myCart"); 
		for(Product product: myCart){
			out.println("<tr><td>" + product.getId() + "</td><td>" + product.getName() + "</td><td>" +
					product.getPrice() + "</td></tr>");
		}
	}
	%>
	</table>
	</section>

</body>
</html>