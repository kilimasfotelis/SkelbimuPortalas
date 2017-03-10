<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2017-03-09
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="login.jsp"%>

<c:choose>
    <c:when test="${not empty adverts}">
        <table>
            <thead>
            <tr>
                <th>Aprasymas</th>
                <th>Miestas</th>
                <th>Kaina</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${adverts}" var="advert">
            <tr>
                <td><a href="/advertDetail?id=${advert.id}">${advert.shortDescription}</a></td>
                <td>${advert.city}</td>
                <td>${advert.price}</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        tuscias
    </c:otherwise>
</c:choose>

</body>
</html>
