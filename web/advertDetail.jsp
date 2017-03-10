<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2017-03-10
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Detalus skelbimas</title>
</head>
<body>
<c:if test="${not empty advert}">
<table>
    <tr>
    <td>Aprasymas:</td>
    <td>${advert.description}</td>
</tr>
    <tr>
        <td>Kaina:</td>
        <td>${advert.price}</td>
    </tr>
    <tr>
        <td>Miestas:</td>
        <td>${advert.city}</td>
    </tr>
    <tr>
        <td>Email:</td>
        <td>${advert.email}</td>
    </tr>
    <tr>
        <td>Telefonas:</td>
        <td>${advert.phone}</td>
    </tr>
    <tr>
        <td>Galioja iki:</td>
        <td>${advert.activeTime}</td>
    </tr>

</table>
</c:if>
</body>
</html>
