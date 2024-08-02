<%--
  Created by IntelliJ IDEA.
  User: viennguyenthi
  Date: 2024/08/01
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Conversion Result</title>
</head>
<body>
<h1>Conversion Result</h1>
<p>${usd} USD is equal to ${vnd} VND.</p>
<a href="${pageContext.request.contextPath}/currencyConverterController">Convert another amount</a>
</body>
</html>