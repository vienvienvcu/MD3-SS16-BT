<%--
  Created by IntelliJ IDEA.
  User: viennguyenthi
  Date: 2024/08/01
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Currency Converter</title>
</head>
<body>
<h1>Currency Converter</h1>
<form action="currencyConverterController/convert" method="post">
    <label for="usd">Amount in USD:</label>
    <input type="text" id="usd" name="usd" required>
    <input type="submit" value="Convert">
</form>
</body>
</html>

