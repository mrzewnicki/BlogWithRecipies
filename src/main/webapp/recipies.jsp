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
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
        
        <!-- wypisuje wszystkie descriptiony recipies -->
        <c:forEach items="${recipeList}" var="recipe">
        	${recipe.getDescription()},
        </c:forEach>
        
        
    	<div class="container">
	      <form method="POST" modelAttribute="recipeForm" action="${contextPath}/recipies">
	
	        <div class="form-group ">
	        	Description<br>
	            <input name="description" type="text" class="form-control" placeholder=""
	                   autofocus="true"/>
	            Kind of food<br>
	            <input name="kindOfFood" type="text" class="form-control" placeholder=""
	                   autofocus="true"/>
	            LVL<br>
	            <input name="lvl" type="text" class="form-control" placeholder=""
	                   autofocus="true"/>
	            Time<br>
	            <input name="requiredTime" type="text" class="form-control" placeholder=""
	                   autofocus="true"/>
	
	            <button class="btn btn-lg btn-primary btn-block" type="save">Add new recipe</button>
	        </div>
	      </form>
	    </div>
	    
	    
    </c:if>
  </div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>