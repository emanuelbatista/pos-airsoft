<%-- 
    Document   : jogo
    Created on : 13/02/2016, 15:36:45
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
        <link href="/css/jogo.css" rel="stylesheet">
        <title>Jogo</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jsp/fragmentos/navbar.jsp" %>
        <div class="container-fluid">
            <div>
                <img src="/jogo/image/${jogo.id}" class="image-jogo img-circle">
            </div>
            <div class="btn-group-jogo">
                <a href="/jogo/${jogo.id}/modificar/estado/CANCELADO" class="btn btn-warning">Cancelar</a>
                <a href="/jogo/${jogo.id}/modificar/estado/ENCERRADO" class="btn btn-danger">Encerrar</a>
                <a href="/jogo/${jogo.id}/membros" class="btn btn-primary">Membros</a>
                <a href="/jogo/${jogo.id}/album" class="btn btn-info">Albúm</a>
            </div>
            <div class="row">
                <div class="col-sm-3">
                    <div class="panel panel-default">
                        <div class="panel-heading"><b>Quant. de Membros</b></div>
                        <div class="panel-body">
                            <span class="label label-success">
                                ${fn:length(jogo.membros)}
                            </span>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="panel panel-default">
                        <div class="panel-heading"><b>Local</b></div>
                        <div class="panel-body">
                            ${jogo.local}
                        </div>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="panel panel-default">
                        <div class="panel-heading"><b>Horário</b></div>
                        <div class="panel-body">
                            ${jogo.horario}
                        </div>
                    </div>
                </div>
                <div class="col-sm-3">
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
            </div>
            <div class="panel panel-default">
                <div class="panel-heading"><b>Objetivo</b></div>
                <div class="panel-body">
                    ${jogo.objetivo}
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading"><b>Enredo</b></div>
                <div class="panel-body">
                    ${jogo.enredo}
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading"><b>Missão</b></div>
                <div class="panel-body">
                    ${jogo.missao}
                </div>
            </div>
        </div>
        <script src="/jquery/jquery-2.1.4.min.js"></script>
        <script src="/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
