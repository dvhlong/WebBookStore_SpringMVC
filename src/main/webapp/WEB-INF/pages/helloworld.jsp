<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC -HelloWorld</title>
</head>


<body>
    <c:choose>
  	<c:when test="${sessionScope.tam!=null}">
		Gia tri cua Session: <br>
		${sessionScope.tam}
		<br>Ds ho ten <br>
		<c:forEach items="${dsht}" var="ht">
		    ${ht}
		</c:forEach>
		    <h1>${test}</h1>
</c:when>
    <c:otherwise>
	    <form action="hello" method="post">
	       <input type="submit" name="but1" value ="Thu 1 ty">
	    </form>
    </c:otherwise>
    </c:choose>
</body>


</html>