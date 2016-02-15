<%-- 
    Document   : listJogo
    Created on : 11/02/2016, 11:00:06
    Author     : emanuel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="/css/listJogos.css" rel="stylesheet">
        <title>Lista de Jogos</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jsp/fragmentos/navbar.jsp" %>
        <div class="container-fluid">
            <h1 class="text-center">Lista de Jogos</h1>
            <div class="container-game">
                <div class="row">
                    <c:forEach var="jogo" items="${listJogo}">
                        <div class="col-md-6">
                            <div class="box-list">
                                <div>
                                    <img src="/jogo/image/${jogo.id}" class="image-jogo img-circle">
                                </div>
                                <div class="row">
                                    <div class="col-sm-4">
                                        <div class="panel panel-default">
                                            <div class="panel-heading"><b>Quant. de Membros</b></div>
                                            <div class="panel-body">
                                                <span class="label label-success">
                                                    ${fn:length(jogo.membros)}
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="panel panel-default">
                                            <div class="panel-heading"><b>Local</b></div>
                                            <div class="panel-body">
                                                ${jogo.local}
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="panel panel-default">
                                            <div class="panel-heading"><b>Horário</b></div>
                                            <div class="panel-body">
                                                ${jogo.horario}
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-4">
                                        <div class="panel panel-default">
                                            <div class="panel-heading"><b>Estado</b></div>
                                            <div class="panel-body">
                                                <c:choose>
                                                    <c:when test="${jogo.estado=='ATIVO'}">
                                                        <span class="label label-success">
                                                            ${jogo.estado}
                                                        </span>
                                                    </c:when>
                                                    <c:when test="${jogo.estado=='CANCELADO'}">
                                                        <span class="label label-warning">
                                                            ${jogo.estado}
                                                        </span>
                                                    </c:when>
                                                    <c:when test="${jogo.estado=='ENCERRADO'}">
                                                        <span class="label label-danger">
                                                            ${jogo.estado}
                                                        </span>
                                                    </c:when>
                                                </c:choose>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-8">
                                        <div class="panel panel-default">
                                            <div class="panel-heading"><b>Objetivo</b></div>
                                            <div class="panel-body">
                                                ${jogo.objetivo}
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="text-center">
                                    <a href="/jogo/${jogo.id}" class="btn btn-primary">Ver Mais</a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>
            </div>
            <nav>
                <ul class="pager">
                    <li class="previous"><a href="/jogos/${numPage-1}"><span aria-hidden="true">&larr;</span> Anterior</a></li>
                    <li class="next"><a href="/jogos/${numPage+1}">Próximo <span aria-hidden="true">&rarr;</span></a></li>
                </ul>
            </nav>

        </div>
        <script src="/jquery/jquery-2.1.4.min.js"></script>
        <script src="/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
