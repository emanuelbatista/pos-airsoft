<%-- 
    Document   : addJogo
    Created on : 11/02/2016, 13:17:56
    Author     : emanuel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="/css/addJogo.css" rel="stylesheet">
        <title>Criar um novo Jogo</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jsp/fragmentos/navbar.jsp" %>
        <div class="container-fluid">
            <h1 class="text-center">Novo Jogo</h1>
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <c:if test="${erros!=null}">
                        <div class="alert alert-danger">
                            <c:forEach var="erro" items="${erros}">
                                ${erro.defaultMessage}
                            </c:forEach>
                        </div>
                    </c:if>
                    <div class="box-form">
                        <form action="/jogo/add" method="post" enctype="multipart/form-data">
                            <div class="form-group">
                                <label>Imagem do Jogo</label>
                                <input type="file" required name="image" accept="image/*" >
                            </div>
                            <div class="form-group">
                                <label>Objetivo:</label>
                                <input type="text" required name="objetivo" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Enredo:</label>
                                <textarea class="form-control" required name="enredo" placeholder="Enredo do jogo..."></textarea>
                            </div>
                            <div class="form-group">
                                <label>Missão:</label>
                                <textarea class="form-control" required name="missao" placeholder="Missão do jogo..."></textarea>
                            </div>
                            <div class="form-group">
                                <label>Local:</label>
                                <input type="text" class="form-control" required name="local" placeholder="local do jogo">
                            </div>
                            <div class="form-group">
                                <label>Horário:</label>
                                <input type="datetime-local" required class="form-control" name="horario" placeholder="horário">
                            </div>
                            <div class="form-group text-center">
                                <button type="submit" class="btn btn-success">Criar Jogo</button>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-md-3"></div>
            </div>
        </div>
        <script src="/jquery/jquery-2.1.4.min.js"></script>
        <script src="/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
