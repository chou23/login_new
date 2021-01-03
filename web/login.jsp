<%--
  Created by IntelliJ IDEA.
  User: chink
  Date: 2021/1/3
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <script>
        window.onload =function () {
            document.getElementById("img").onclick = function () {
                this.src = "/day14/checkCodeServlet?time="+new Date().getTime();
            }
        }
    </script>
  <style>
      div{
          color: red;
      }
  </style>

</head>
<body>

<form action="/day14/loginServlet" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td colspan="2"><img id="img" src="/day14/checkCodeServlet"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" type="submit" value="登录"></td>
        </tr>
    </table>

</form>

<div> <%= request.getAttribute("login_error") == null ? "" : request.getAttribute("login_error")%> </div>

</body>
</html>
