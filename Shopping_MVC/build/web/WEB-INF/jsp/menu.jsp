<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
            <a href="shopping.htm?type=Books" >Books</a> <br />
            <a href="shopping.htm?type=Music" >Music</a> <br />
            <a href="shopping.htm?type=Computers" >Computers</a> <br />
            <a href="shopping.htm?nav=myCart"> View My Cart</a>
        </div>
    </body>
</html>
