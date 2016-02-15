<%-- 
    Document   : membros
    Created on : 13/02/2016, 21:24:12
    Author     : emanuel
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="/css/listMembros.css" rel="stylesheet">
        <title>Lista de Membros</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jsp/fragmentos/navbar.jsp" %>
        <div class="container-fluid">
            <h1 class="text-center">Lista de Membros</h1>
            <div class="container-game">
                <div class="row">
                    <c:forEach var="membro" items="${membros}">
                        <div class="col-md-6">
                            <div class="box-list">
                                <div class="panel panel-primary">
                                    <div class="panel-heading"><b>Nome</b></div>
                                    <div class="panel-body">
                                        ${membro.nome}
                                    </div>
                                </div>
                                <div class="panel panel-primary">
                                    <div class="panel-heading"><b>E-mail</b></div>
                                    <div class="panel-body">
                                        ${membro.email}
                                    </div>
                                </div>
                                <div class="panel panel-primary">
                                    <div class="panel-heading"><b>Código</b></div>
                                    <div class="panel-body">
                                        ${membro.codigo}
                                    </div>
                                </div>
                                <div class="panel panel-primary">
                                    <div class="panel-heading"><b>Telefone</b></div>
                                    <div class="panel-body">
                                        ${membro.telefone}
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>

        </div>
        <script src="/jquery/jquery-2.1.4.min.js"></script>
        <script src="/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
