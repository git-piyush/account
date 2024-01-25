<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo.DTO.AccountDTO" %>
<%@ page import="com.example.demo.repo.AccountRepo" %>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account List</title>
<script type="text/javascript">

function sortTable(column) {
	var ascDir = 'asc';
	var sortBy=column;
	const currentURL = window.location;
	if(currentURL.indexOf('desc')!== -1){
		ascDir='asc';
	}else{
		ascDir='desc';
	}
	
	var url = "http://localhost:8081/ui/account/getAllAccountUI?sortBy="+sortBy+"&ascDir="+ascDir;
	window.location.href = url;
}
</script>
</head>
<body>
	<h2>Account List</h2>
 <table style="width:70%" id="account" border="1">
    <thead>
        <tr>
            <%--  <th><a href="?sortBy=accNo&amp;ascDir=${ascDir.equals('asc') ? 'desc' : 'asc'}">Account No</a></th> --%>
        	 <th><a href="#" onclick="sortTable('accNo');">Account No</a></th>
        	<th><a href="?sortBy=accHolderName&amp;ascDir=${ascDir.equals('asc') ? 'desc' : 'asc'}">Account Holder Name</a></th>
            <th><a href="?sortBy=aadhar&amp;ascDir=${yourData.ascDir.equals('asc') ? 'desc' : 'asc'}">Aadhar</a></th>
            <th colspan='2' >Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${accountList}" var="yourData">
            <tr>
                <td><a href="/getPost/${yourData.accNo}">${yourData.accNo}</a></td>
                <td>${yourData.accHolderName}</td>
                <td>${yourData.aadhar}</td>
                <td align="center">
                <button onclick="location.href='/getPost/${yourData.accNo}'" type="button" class="btn btn-primary" >Edit</button>
        	    <button onclick="location.href='/deletePost/${yourData.accNo}'" type="button" class="btn btn-danger">Delete</button> 
        	                 	
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<!-- Display pagination links -->
<div>
    <c:if test="${totalPages > 1}">
        <c:choose>
            <c:when test="${number > 0}">
                <a href="?pageNo=${number - 1}&amp;pageSize=${size}">Previous</a>
            </c:when>
            <c:otherwise>
                <span>Previous</span>
            </c:otherwise>
        </c:choose>

        <c:forEach begin="0" end="${totalPages - 1}" var="i">
            <c:choose>
                <c:when test="${number == i}">
                    <span>${i + 1}</span>
                </c:when>
                <c:otherwise>
                    <a href="?pageNo=${i}&amp;pageSize=${size}">${i + 1}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:choose>
            <c:when test="${number < totalPages - 1}">
                <a href="?pageNo=${number + 1}&amp;pageSize=${size}">Next</a>
            </c:when>
            <c:otherwise>
                <span>Next</span>
            </c:otherwise>
        </c:choose>
    </c:if>
</div>
    <button onclick="performAction()">Dashboard</button>

    <script>
        function performAction() {
        	window.location.href = 'http://localhost:8081/ui/account/dashboard';
        }
    </script>
</body>
</html>