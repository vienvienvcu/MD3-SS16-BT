<%--
  Created by IntelliJ IDEA.
  User: viennguyenthi
  Date: 2024/08/01
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tra cứu từ điển Anh - Việt</title>

</head>
<style>
    body {
        font-family: Arial, sans-serif;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        background-color: #f4f4f4;
    }

    .container {
        background: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        width: 300px;
        text-align: center;
    }

    h1 {
        margin-bottom: 20px;
    }

    form {
        margin-bottom: 20px;
    }

    input[type="text"] {
        width: calc(100% - 20px);
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
        margin-bottom: 10px;
    }

    button {
        padding: 10px 20px;
        border: none;
        background-color: #007bff;
        color: #fff;
        border-radius: 4px;
        cursor: pointer;
    }

    button:hover {
        background-color: #0056b3;
    }


</style>
<body>
<div class="container">
    <h1>Tra cứu từ điển Anh - Việt</h1>
    <form action="/dictionaryController/search" method="post">
        <label for="word">Nhập từ cần tra cứu:</label>
        <input type="text" id="word" name="word" placeholder="Nhập từ..." required>
        <button type="submit">Tra cứu</button>
    </form>
    <div>
        <p>${message}</p>
    </div>
</div>
</body>
</html>
