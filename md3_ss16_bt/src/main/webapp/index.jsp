<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="${pageContext.request.contextPath}/currencyConverterController">Show Form</a>
<a href="${pageContext.request.contextPath}/dictionaryController">Show Form search</a>

</body>
</html>