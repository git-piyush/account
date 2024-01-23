<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Form</title>
</head>
<body>
	<h2>New Account Input</h2>

	<form action="/ui/account/createAccountUI" method="post">
        <table>
            <tr>
                <td><label for="textInput">Enter Your Name:</label></td>
                <td><input type="text" id="accHolderName" name="accHolderName" required></td>
            </tr>
            <tr>
                <td><label for="textInput">Aadhar No:</label></td>
                <td><input type="number" id="aadhar" name="aadhar" required></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><button type="submit">Submit</button></td>
            </tr>
        </table>
    </form>
    
        <button onclick="performAction()">Dashboard</button>

    <script>
        function performAction() {
        	window.location.href = 'http://localhost:8081/ui/account/dashboard';
        }
    </script>
</body>
</html>