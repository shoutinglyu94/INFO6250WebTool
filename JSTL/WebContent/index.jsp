<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>jstl</title>
</head>
<body>
	<h1>JSTL Examples</h1>
	
	<h2>Format tag examples:</h2>
	<h3>1.parseNumber:</h3>
	<c:set var="Number" value="10024.56244165" />
	<fmt:parseNumber var="i" type="number" value="${Number}" />
	<p>Number is:<c:out value="${i}" /></p>
	<h3>2.formatNumber:</h3>
	<p>
	1)<fmt:formatNumber type="currency" value="${Number}" />
	2)<fmt:formatNumber type="number" groupingUsed="true" value="${Number}" />
	3)<fmt:formatNumber type="number" maxFractionDigits="3" value="${Number}" />
	4)<fmt:formatNumber type="number" maxFractionDigits="6" value="${Number}" />
	5)<fmt:formatNumber type="number" maxIntegerDigits="4" value="${Number}" />
	6)<fmt:formatNumber type="number" pattern="###.###%" value="${Number}" />
	</p>
	<h3>3.parseDate:</h3>  
	<c:set var="date" value="12-08-2016" />  
  	<fmt:parseDate value="${date}" var="parsedDate"  pattern="dd-MM-yyyy" />  
	<p><c:out value="${parsedDate}" /></p>  
	
	<h2>Function tag examples:</h2>
	<h3>1.contains():</h3>
	<c:set var="str1" value="Test-for-Function-Tag" />
	<c:if test="${fn:contains(str1,'Function')}">
	Found String "Function"
	</c:if>
	<h3>2.split()</h3>
	<c:set var="str2" value="${fn:split(str1, '-')}" />  
	<c:set var="str3" value="${fn:join(str2, ' ')}" />  
	<c:out value="${str3}" />
	<h3>3.replace()</h3>
	<c:set var="str4" value="${fn:replace(str1,\"Function-Tag\",\"Function-Replace()\")}" />
	<c:out value="${str4}" />
</body>
</html>