<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
  <link href="${contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="${contextPath}/resources/css/blog-home.css" rel="stylesheet">
    <meta charset="utf-8">
    <title>Przepisy kulinarne</title>
</head>
<body>
<%@ include file="fragments/navbar.jspf" %>
  <div class= "container">
        <h1 class="my-4">Wszystkie przepisy
        </h1>
  </div>
<%@ include file="fragments/wyswietlPrzepisy.jspf" %>

  <script src="${contextPath}/resources/vendor/jquery/jquery.min.js"></script>
  <script src="${contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>