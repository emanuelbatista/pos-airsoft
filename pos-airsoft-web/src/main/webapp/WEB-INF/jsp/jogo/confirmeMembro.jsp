<%-- 
    Document   : confirmeMembro
    Created on : 15/02/2016, 06:19:31
    Author     : emanuel
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
        <h3 class="text-center">Confirmar participação para ser membro do jogo</h3>
        <c:if test="${erro!=null}">
            <div class="alert alert-danger">
                ${erro}
            </div>
        </c:if>
        <form action="/jogo/membro/confirmacao/${jogo.id}" method="post">
            <div class="row">
                <div class="col-sm-2"></div>
                <div class="col-sm-8">
                    <div class="form-group">
                        <label>Token de Confirmação:</label>
                        <input type="text" class="form-control" placeholder="Insira o token para a confirmação aqui..." name="token">
                    </div>
                    <div class="text-center">
                    <button type="submit" class="btn btn-success">Confirmar</button>
                    </div>
                </div>
                <div class="col-sm-2"></div>
            </div>
            <div class="row">
                 <div class="col-sm-2"></div>
                 <div class="col-sm-8">
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
                 </div>
                 <div class="col-sm-2"></div>
            </div>

        </form>
    </body>
</html>
