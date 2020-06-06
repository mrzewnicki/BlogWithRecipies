<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create an account</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  <div class="container">
	  <!--   jezeli nie zalogowany uzytkownik-->      
 	  <c:if test="${pageContext.request.userPrincipal.name == null}">
      	<a href="${contextPath}/login">Log in</a>&nbsp&nbsp&nbsp&nbsp  <a href="${contextPath}/registration">Create account</a> 
      </c:if>
      
    <!--   jezeli zalogowany uzytkownik-->      
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
    </c:if>
    
  </div>
  <br>
   <!-- filtry -->
  <div class="container">
  <form method="POST" modelAttribute="recipeFilterForm" action="${contextPath}/recipe_filter">
	        <div class="form-group ">
		        	Search<br>
		            <input name="username" type="text" class="form-control" placeholder=""
		                   autofocus="true"/>
		            <input name="lvl" type="text" class="form-control" placeholder=""
		                   autofocus="true"/>
             		<input name="kindOfFood" type="text" class="form-control" placeholder=""
		                   autofocus="true"/>
		            <button class="btn btn-lg btn-primary btn-block" type="submit">Filter</button>
	        </div>
	      </form>
  </div>
  <br><br>
  <div class="container">
        <!-- wypisuje wszystkie descriptiony recipies -->
        <c:forEach items="${recipeList}" var="recipe">
            ID: <a href="${contextPath}/recipe/${recipe.getId()}">${recipe.getId()}</a><br>
            Level: ${recipe.getLvl()}<br>
            Description: ${recipe.getDescription()}<br>
        	Time: ${recipe.getRequiredTime()}<br>
        	<hr>
        </c:forEach>
  </div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>