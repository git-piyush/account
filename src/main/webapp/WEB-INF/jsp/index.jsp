<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Page</title>
</head>
<body>

<h2>Button with Action</h2>
    <button onclick="createAccount()">Create Account</button><br><br>
    <button onclick="accountList()">Account List</button>

    <script>
        function createAccount() {
        	window.location.href = 'http://localhost:8081/ui/account/accountform';
        }
        
        function accountList() {
        	window.location.href = 'http://localhost:8081/ui/account/getAllAccountUI';
        }
    </script>
</body>
</html>