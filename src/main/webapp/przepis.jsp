<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Przepis</title>
	  <link href="${contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/blog-home.css" rel="stylesheet"></head>
<body>
<%@ include file="fragments/navbar.jspf" %>
<br><br>
   
   <div class="container">
    <div class="row">
      <div class="col-md-8">
        <div class="card mb-4">
          <img class="card-img-top" src="/getZdjecie/<c:out value='${przepisById.getId()}'/>" alt="Brak zdjecia">
          <div class="card-body">
            <h2 class="card-title">${przepisById.getId()}. ${przepisById.getNazwa()}</h2>
            <p class="card-text">
				${przepisById.getOpis()}
			<p>
          </div>
          <div class="card-footer text-muted">
            Autor: ${przepisById.getUser().getUsername()} 
            | Kategoria: ${przepisById.getRodzajPotrawy()}
            | Poziom trudnosci: ${przepisById.getPoziomTrudnosci()}
		    | Czas: ${przepisById.getCzasWykonania()}
          </div>
        </div>        
       </div>
     </div>
   </div>
	<div class="container" >
		<form method="POST" modelAttribute="komentarzForm" action="${contextPath}/przepis/${przepisById.getId()}" style="width:70%">
			<div class="form-group ">
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					Twoj komentarz<br>
					<input name="tresc" type="text" class="form-control" placeholder="" autofocus="true"/>
					<button class="btn btn-lg btn-primary btn-block" type="save">Dodaj</button>
				</c:if>  
			</div>
		</form>
		<b>Komentarze:</b><br> <br>   
		<!-- wypisuje wszystkie komentarze -->
		<c:forEach items="${komentarzeDoPrzepisu}" var="komentarz">
			${komentarz.getTresc()}<br>
			Data: ${komentarz.getDataDodania()}<br>
			Dodane przez: ${komentarz.getUser().getUsername()}<br>
			<hr>
		</c:forEach>
	</div>	
  <script src="${contextPath}/resources/vendor/jquery/jquery.min.js"></script>
  <script src="${contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>