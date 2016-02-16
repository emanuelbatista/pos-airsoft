<%-- 
    Document   : confirmeMembro
    Created on : 15/02/2016, 06:19:31
    Author     : emanuel
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="/css/listJogos.css" rel="stylesheet">
        <title>Confirmar Participação</title>
    </head>
    <body>
        <h1>Confirmar participação para ser membro do jogo</h1>
    <c:if test="${erro!=null}">
        <div class="alert alert-danger">
            ${erro}
        </div>
    </c:if>
    <form action="/jogo/membro/confirmacao/${jogo.id}" method="post">
        <div class="form-group">
            <label>Token de Confirmação:</label>
            <input type="text" class="form-control" placeholder="Insira o token para a confirmação aqui..." name="token">
            <button type="submit" class="btn btn-success">Confirmar</button>
        </div>
    </form>
</body>
</html>
