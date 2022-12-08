<%-- 
    Document   : ListagemCrianca
    Created on : 08/05/2018, 11:33:25
    Author     : sala308b
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="caminho" value="${pageContext.request.contextPath}" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <style>
            table{
                text-align: center;
            }
            .divCentralizar{
                width: 120px;
                text-align: center;
                margin-left: auto;
                margin-right: auto;
            }
            .divPesquisar{
                margin-left: 20px;
            }
            #imgLogo{
                width: 40; 
                height: 40;
            }


        </style>

        <title>Lista das Crianças</title>


        <link href="../css/navcss.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>   
        <link rel="shortcut icon" type="image/ico" href="${caminho}/img/Favicon.ico"/>
    </head>
    <body>

        <c:import url="cabecalho.jsp" />

        <div class="row mb-3">
            <div class="col-md-4 col-sm-6">
                <div class="divPesquisar">
                    <h6>Pesquisar criança pelo nome:</h6>
                    <form action="PesquisaCrianca" method="post" class="form-inline">                       
                        <input type="text" class="form-control mr-2" name="pesquisaNome" value="${nomePesquisado}"/>
                        <button type="submit" class="btn btn-primary btn-sm ml-2 mt-2">Pesquisar</button> <br>
                    </form>

                </div>
            </div>
        </div>
 <div class="row">
        <div class="table-responsive">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Código </th>
                        <th>Nome </th>
                        <th>Data de Nascimento</th>
                        <th>Sexo </th>
                        <th>Responsável </th>
                        <th>Status</th>
                        <th>Dados da Criança</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="c" items="${lista}">
                        <tr>
                            <td>${c.codigo}</td>
                            <td>${c.nome}</td>
                            <td><fmt:formatDate value="${c.dataNascimento.time}" 
                                            pattern="dd/MM/yyyy"/></td>
                            <td>${c.sexo}</td>
                            <td>${c.responsavel}</td>
                            <td>${c.status}</td>
                            <td><div class="list-group divCentralizar">
                                    <a href="vizualizarCrianca?codigo=${c.codigo}">
                                        <button type="button" class="btn btn-primary btn-sm">                                
                                            Vizualizar                               
                                        </button>
                                    </a>
                                </div>
                            </td>
                        <tr>
                        </c:forEach>
                </tbody>
            </table>
        </div>
 </div>
    </body>
</html>
