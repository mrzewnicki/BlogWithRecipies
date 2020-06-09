<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Filtruj przepisy</title>
  <link href="${contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="${contextPath}/resources/css/blog-home.css" rel="stylesheet">
</head>
<body>
<%@ include file="fragments/navbar.jspf" %>

   <!-- filtry -->
  <div class="container">
          <h2 class="my-4">  Filtruj przy uzyciu:
          </h2>
  <form method="POST" modelAttribute="przepisFilterForm" action="${contextPath}/filters">
	        <div class="form-group" style="width:50%">
					Nazwa uzytkownika:
					<input name="czasWykonania" type="text" class="form-control" placeholder=""
		                   autofocus="true"/>
		            Poziom trudnosci:
		            <input name="poziomTrudnosci" type="text" class="form-control" placeholder=""
		                   autofocus="true"/>
		            Kategoria:
             		<input name="rodzajPotrawy" type="text" class="form-control" placeholder=""
		                   autofocus="true"/>
		            <button class="btn btn-lg btn-primary btn-block" type="submit">Filtruj</button>
	        </div>
	      </form>
  </div>
  <div class= "container">
        <h1 class="my-4">Przepisy:
        </h1>
  </div>
<%@ include file="fragments/wyswietlPrzepisy.jspf" %>
  <script src="${contextPath}/resources/vendor/jquery/jquery.min.js"></script>
  <script src="${contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>