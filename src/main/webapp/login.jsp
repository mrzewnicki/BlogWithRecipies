<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Zaloguj sie</title>
	  <link href="${contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/blog-home.css" rel="stylesheet">
  </head>
  <body>
	<%@ include file="fragments/navbar.jspf" %>
<center>
    <div class="container">
    <br>
      <form method="POST" action="${contextPath}/login" class="form-signin" style="width:60%">
        <h2 class="form-heading">Zaloguj sie</h2>

        <div class="form-group ${blad != null ? 'has-error' : ''}">
            <span>${wiadomosc}</span>
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <span>${blad}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Zaloguj sie</button>
            <div style="text-align: left">Nie masz konta?</div><h4 class="text-center"> <a href="${contextPath}/rejestracja">Stworz konto</a></h4>
        </div>
      </form>
    </div>
</center>
  <script src="${contextPath}/resources/vendor/jquery/jquery.min.js"></script>
  <script src="${contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  </body>
</html>