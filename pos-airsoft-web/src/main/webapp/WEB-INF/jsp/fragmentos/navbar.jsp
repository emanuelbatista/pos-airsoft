<%-- 
    Document   : navbar
    Created on : 12/02/2016, 21:24:11
    Author     : emanuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">
                    AirSoft
                </a>
            </div>

        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Jogo <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/jogo/add">Adicionar</a></li>
                        <li><a href="/jogos/1">Listar</a></li>
                        <li><a href="/jogos/1/realizados">Listar Realizados</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Membro <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/membro/add">Adicionar</a></li>
                        <li><a href="/membros">Listar</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>