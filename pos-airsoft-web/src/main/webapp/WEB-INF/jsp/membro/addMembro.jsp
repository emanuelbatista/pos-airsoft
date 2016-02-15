<%-- 
    Document   : addMembro
    Created on : 13/02/2016, 19:46:27
    Author     : emanuel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="/css/addJogo.css" rel="stylesheet">
        <title>Criar um novo Membro</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jsp/fragmentos/navbar.jsp" %>
        <div class="container-fluid">
            <h1 class="text-center">Novo Membro</h1>
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
                        <form action="/membro/add" method="post">
                            <div class="form-group">
                                <label>Nome:</label>
                                <input type="text" name="nome" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>E-mail:</label>
                                <input type="email" class="form-control" name="email">
                            </div>
                            <div class="form-group">
                                <label>Código:</label>
                                <input type="text" class="form-control" name="codigo" placeholder="código usado pelo membro">
                            </div>
                            <div class="form-group">
                                <label>Telefone:</label>
                                <input type="tel" class="form-control" name="telefone">
                            </div>
                            <div class="form-group text-center">
                                <button type="submit" class="btn btn-success">Criar Membro</button>
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
