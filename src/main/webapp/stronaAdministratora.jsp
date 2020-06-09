<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Administracja</title>
	  <link href="${contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/blog-home.css" rel="stylesheet">
</head>
<body>
<%@ include file="fragments/navbar.jspf" %>
  <div class="container">
  <br>
  	<h2>Wpisz id przepisu, ktory chcesz usunac:</h2> <br><br>
  	<form method="POST" modelAttribute="przepisIdForm" action="${contextPath}/stronaAdministratora">
		<div class="form-group ">
			Id:
			<input name="poziomTrudnosci" type="text" class="form-control" placeholder=""
			               autofocus="true"/>
	        <button class="btn btn-lg btn-primary btn-block" type="submit">Usun</button>
        </div>
     </form>
  </div>
  
  <script src="${contextPath}/resources/vendor/jquery/jquery.min.js"></script>
  <script src="${contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>