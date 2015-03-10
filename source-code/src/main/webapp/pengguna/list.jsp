<%-- 
    Document   : list
    Created on : Mar 10, 2015, 2:08:18 AM
    Author     : DAWUD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar Pengguna</title>
    </head>
    <body>
        <h1>Daftar Pengguna</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Username</th>
                    <th>Full Name</th>
                    <th>Kontak</th>
                    <th>Surel</th>
                </tr>
            </thead><tbody>
                <c:forEach items="${users}" var="pengguna">
                    <tr>
                        <td>${pengguna.username}</td>
                        <td>${pengguna.fullName}</td>
                        <td>${pengguna.kontak}</td>
                        <td>${pengguna.email}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
