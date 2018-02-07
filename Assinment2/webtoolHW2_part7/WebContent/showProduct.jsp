<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Bean.Product"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shouting Shopping Show Products</title>
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
#section {
    width:350px;
    float:left;
    padding:10px; 
}

</style>
</head>
<body>
	<header id="header">
	<h1>Shouting Shopping Website</h1>
	</header>

	<div id="nav">
		<a href="ShoppingController?type=Books">Books</a> <br /> <a
			href="ShoppingController?type=Music">Music</a> <br /> <a
			href="ShoppingController?type=Computers">Computers</a> <br />
			<a href="ShoppingController?nav=myCart"> View My Cart</a>
	</div>

	<section id="section"> <%
 	ArrayList<Product> selectedList = (ArrayList<Product>) session.getAttribute("selectedProducts");
 %>
	<h2>
		Shopping
		<%=selectedList.get(0).getType()%></h2>
	<form action="ShoppingController" method="get">
		<table>
			<%
				for (Product product : selectedList) {
						out.println("<tr><td><input type=\"checkbox\" name=\"chkProduct\" value=\""+product.getId()+"\">" + product.getId() + "</td><td>"
								+ product.getName() + "</td><td>" + product.getPrice() + "</td></tr>");
				}
			%>
		</table>
		<input type="hidden" name="action" value="add">
		<input type="submit" value="Add to cart">
	</form>
	</section>


</body>
</html>