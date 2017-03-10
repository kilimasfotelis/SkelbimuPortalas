<div style="float: right">
    <c:if test="${not empty error}">
        ${error}
    </c:if>
<form action="/Login" method="post">
<table>
    <tr>
        <td>email:</td>
        <td><div>email: <input type="text" name ="email"/> </div></td>
    </tr>
    <tr>
        <td>password:</td>
        <td><div>email: <input type="password" name ="password"/> </div></td>
    </tr>
    <tr>
        <td><button>Login</button></td>
        <td><a href="#">Registration</a> </td>
    </tr>
</table>
</form>
</div>
