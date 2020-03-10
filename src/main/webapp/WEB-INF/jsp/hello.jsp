<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.4.1-1/css/bootstrap.min.css">
</head>
<body>
    <c:out value="<xmp>" escapeXml="true"></c:out>
    <h2>Hello! ${name}</h2>
    <div>JSP</div>

    <script src="webjars/jquery/3.4.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/4.4.1-1/js/bootstrap.min.js"></script>
</body>
</html>
