<%--
  Created by IntelliJ IDEA.
  User: viennguyenthi
  Date: 2024/08/02
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Student</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
        }
        form {
            display: flex;
            flex-direction: column;
        }
        label {
            margin-bottom: 10px;
        }
        input[type="text"],
        input[type="number"],
        input[type="date"],
        input[type="radio"] {
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #304463;
            color: #FFC7ED;
            border: 1px solid #2F3645;
            padding: 6px 12px;
            text-align: center;
            display: inline-block;
            border-radius: 10px;
            font-weight: 800;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background-color: #7D8ABC;
            color: white;
        }
        .btn-group {
            margin-bottom: 20px;
        }
        .btn-group label {
            background-color: #304463;
            color: #FFC7ED;
            border: 1px solid #2F3645;
            padding: 6px 12px;
            text-align: center;
            display: inline-block;
            border-radius: 10px;
            font-weight: 800;
            font-size: 16px;
        }
        .btn-group label:hover {
            background-color: #7D8ABC;
            color: white;
        }
        label {
            color: #304463;
            font-size: 18px;
            font-weight: 700;
        }
        .btn-group p {
            color: #304463;
            font-size: 18px;
            font-weight: 700;
        }

        .link {
            text-decoration: none;
            background-color: #304463;
            color: #FFC7ED;
            border: 1px solid #2F3645;
            padding: 10px 12px;
            text-align: center;
            display: inline-block;
            border-radius: 3px;
            font-weight: 800;
            font-size: 20px;
            margin-top: 20px;
        }
        .link:hover {
            background-color: #7D8ABC;
            color: white;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Create New Student</h2>
    <form:form action="create" method="post"  modelAttribute="newStudent">
        <input type="hidden" name="action" value="create"/>
<%--        <input type="hidden" name="studentId" value="studentId">--%>

        <label for="studentName">Student Name:</label>
        <form:input type="text" id="studentName" name="studentName" path="studentName"/>

        <form:errors path="studentName" cssClass="text-danger"/>

        <label for="age">Age:</label>
        <form:input type="number" id="age" name="age"  path="age"/>

        <form:errors path="age" cssClass="text-danger"/>

        <p>Sex:</p>
        <div class="btn-group">
            <label for="male">
                <form:radiobutton name="sex" id="male" value="true"  path="sex"/> Male
            </label>
            <label for="female">
                <form:radiobutton  name="sex" id="female" value="false" path="sex"/> Female
            </label>
        </div>
        <form:errors path="sex" cssClass="text-danger"/>

        <label for="address">Address:</label>
        <form:input type="text" id="address" name="address"  path="address"/>

        <form:errors path="address" cssClass="text-danger"/>

        <label for="birthDate">Birth Date:</label>
        <form:input type="date" id="birthDate" name="birthDate" path="birthDate"/>

        <form:errors path="birthDate" cssClass="text-danger"/>

        <p>Status:</p>
        <div class="btn-group">
            <label for="active">
                <form:radiobutton name="status" id="active" value="true" path="status"/> Active
            </label>
            <label for="inactive">
                <form:radiobutton name="status" id="inactive" value="false"  path="status"/> Inactive
            </label>
        </div>
        
        <form:errors path="status" cssClass="text-danger"/>

        <input type="submit" value="Add Student">
    </form:form>
    <a href="/studentController/getAll" class="link"><< Back</a>
</div>

</body>
</html>
