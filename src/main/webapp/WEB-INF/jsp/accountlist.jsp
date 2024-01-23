<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account List</title>
</head>
<body>
	<h2>Account List</h2>
    <table border="1">
        <tr>
            <th>Account No</th>
            <th>Name</th>
            <th>Aadhar No</th>
        </tr>

        <c:forEach var="account" items="${accountList}">
            <tr>
                <td>${account.accNo}</td>
                <td>${account.accHolderName}</td>
                <td>${account.aadhar}</td>
            </tr>
        </c:forEach>
    </table>
    <button onclick="performAction()">Dashboard</button>

    <script>
        function performAction() {
        	window.location.href = 'http://localhost:8081/ui/account/dashboard';
        }
    </script>
</body>
</html>