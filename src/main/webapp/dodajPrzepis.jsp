<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
    <meta charset="utf-8">
    <title>Dodaj przepis</title>
  <link href="${contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="${contextPath}/resources/css/blog-home.css" rel="stylesheet">
</head>
<body>
  <div class="container">
  <%@ include file="fragments/navbar.jspf" %>
    <c:if test="${pageContext.request.userPrincipal.name != null}">

        <h2>Witaj ${pageContext.request.userPrincipal.name}</h2>   
        <h3> Dodaj nowy przepis </h3>    
        
    	<div class="container" >
	      <form enctype="multipart/form-data" method="POST"  action="${contextPath}/dodajPrzepis">
	        <div class="form-group" style="width:50%">
	        	Opis<br>
	            <textarea name="opis" type="text" class="form-control" placeholder=""
	                   autofocus="true"></textarea>
	            Rodzaj potrawy<br>
	            <input name="rodzajPotrawy" type="text" class="form-control" placeholder=""
	                   autofocus="true"/>
	            Poziom trudnosci<br>
	            <input name="poziomTrudnosci" type="text" class="form-control" placeholder=""
	                   autofocus="true"/>
	            Czas wykonania<br>
	            <input name="czasWykonania" type="text" class="form-control" placeholder=""
	                   autofocus="true"/>
                Zdjecie<br>
                <input name="zdjecie" type="file" class="form-control" placeholder=""
	                   autofocus="true"/>
	            <button class="btn btn-lg btn-primary btn-block" type="save">Dodaj przepis</button>
	    </div>
	    </form>
	    </div>
    </c:if>
  </div>
  <div class="container">        
  <h1 class="my-4">Twoje przepisy
        </h1>
</div>
    <%@ include file="fragments/wyswietlPrzepisy.jspf" %>
  
  <script src="${contextPath}/resources/vendor/jquery/jquery.min.js"></script>
  <script src="${contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>