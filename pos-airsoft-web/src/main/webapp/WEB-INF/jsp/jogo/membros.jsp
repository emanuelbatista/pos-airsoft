<%-- 
    Document   : membros
    Created on : 14/02/2016, 09:10:00
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
        <title>Lista de Membros</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jsp/fragmentos/navbar.jsp" %>
        <div class="container-fluid">
            <h1 class="text-center">Lista de Membros</h1>
            <div class="text-center">
                <!-- Button trigger modal -->
                <a href="/jogo/${idJogo}" class="btn btn-primary">Jogo</a>
                <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal">
                    Adicionar Membro
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




            <!-- Modal -->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <form action="/jogo/membros/add" method="post">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel">Adicionar Membro</h4>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <label>Email do membro:</label>
                                    <select class="form-control select2 select-membro" id="idMembros" required="true" style="width: 100%;" name="idMembro" multiple="true">
                                    </select>
                                    <input type="hidden" value="${idJogo}" id="idJogo" name="idJogo">
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
        <script src="/select2/select2.min.js"></script>
        <script src="/select2/i18n/pt-BR.js"></script>
        <script>
            function templateResult(result) {
                var textResult = result.text;
                return  textResult.substring(0, textResult.lastIndexOf(" - "));
            }
            $('.select-membro').select2({
                ajax: {
                    url: "/jogo/nao/membro/pesquisa",
                    dataType: 'json',
                    delay: 250,
                    data: function (params) {
                        return {
                            pesquisa: params.term, // search term
                            id:${idJogo}
                        };
                    },
                    processResults: function (data, params) {
                        var result = [];
                        for (i = 0; i < data.length; i++) {
                            var f = 0;
                            result[i] = {"id": data[i][f], text: data[i][++f] + " - " + data[i][++f]};
                        }
                        return {
                            results: result
                        };
                    },
                    cache: false
                },
                language: "pt-BR",
                allowClear: true,
                escapeMarkup: function (markup) {
                    return markup;
                }, // let our custom formatter work
                minimumInputLength: 1,
                templateSelection: templateResult


            });

        </script>
        <script src="/js/jogo-membro.js"></script>
    </body>
</html>

