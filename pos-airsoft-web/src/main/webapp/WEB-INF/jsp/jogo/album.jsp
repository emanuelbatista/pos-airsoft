<%-- 
    Document   : album
    Created on : 16/02/2016, 19:06:51
    Author     : emanuel
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="/select2/select2.min.css" rel="stylesheet">
        <link href="/css/listMembros.css" rel="stylesheet">
        <title>Album de Fotos</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jsp/fragmentos/navbar.jsp" %>
        <div class="container-fluid">
            <h1 class="text-center">Lista de Membros</h1>
            <div class="text-center">
                <!-- Button trigger modal -->
                <a href="/jogo/${idJogo}" class="btn btn-primary">Jogo</a>
                <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal">
                    Adicionar Foto
                </button>
            </div>
            <div id="msg">
                <c:if test="${msg!=null}">
                    <div class="alert alert-success">
                        ${msg}
                    </div>
                </c:if>
            </div>
            <div class="container-game">
                <div class="row">
                    <div class="col-md-12">
                        <div class="box-list">

                            <c:if test="${album.nome!=null}">
                                    <div class="panel panel-primary">
                                        <div class="panel-heading"><b>Nome</b></div>
                                        <div class="panel-body">
                                            ${album.nome}
                                        </div>
                                    </div>
                            </c:if>

                            <div class="text-center">
                                <button data-toggle="modal" data-target="#modal-album" class="btn btn-info">Editar Informação</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <c:forEach var="image" items="${album.imagens}">
                        <div class="col-sm-3">
                            <img src="/jogo/album/imagem/${image.id}" style="width: 100%;height: 300px"class="img-responsive img-rounded"alt="${image.id}">
                        </div>
                    </c:forEach>
                </div>
            </div>




            <!-- Modal -->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <form action="/jogo/${idJogo}/album/imagem/add" method="post" enctype="multipart/form-data">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel">Adicionar Imagem</h4>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <label>Imagem:</label>
                                    <input type="file" multiple="true" name="imagens">
                                    <input type="hidden" value="${album.id}" name="idAlbum">
                                </div>

                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                                <button type="submit" id="btn-add" class="btn btn-primary">Salvar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
                                
            <!-- Modal -->
            <div class="modal fade" id="modal-album" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <form action="/jogo/${idJogo}/album/edit/${album.id}" method="post">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel">Modificar Nome</h4>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <label>Nome do Album:</label>
                                    <input type="text" class="form-control" name="nome">
                                </div>

                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                                <button type="submit" id="btn-add" class="btn btn-primary">Salvar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

        </div>
        <script src="/jquery/jquery-2.1.4.min.js"></script>
        <script src="/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>


</html>
