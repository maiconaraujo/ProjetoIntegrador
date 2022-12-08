<%-- 
    Document   : login
    Created on : 20/02/2018, 08:24:25
    Author     : sala308b
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="caminho" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
        <link href="${caminho}/css/login.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" type="image/ico" href="${caminho}/img/Favicon.ico"/>
    </head>
    <body>

        <div class="container text-center">
            <form class="form-signin" method="post" action="${caminho}/login">
                <img class="mb-4 " src="${caminho}/img/logo-projetoPequeno.png"  alt="" width="115" height="115" >      
                <h1 class="h3 mb-3 font-weight-normal">Entrar no Sistema</h1>


                <c:if test="${not empty erro}">
                    <h3>
                        <div class=" alert alert-danger">
                            <h6>${erro} </h6>
                    </div> 
                   
                </c:if>
                
                <label for="inputLogin" class="sr-only">Login address</label>
                <input type="text" id="inputLogin" class="form-control" placeholder="Login" name="login" required autofocus>
                <label for="inputSenha" class="sr-only">Senha</label>
                <input type="password" id="inputSenha" class="form-control" placeholder="Senha" name="senha" required>

                <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
                <p class="mt-5 mb-3 text-muted">Sistema GAC &copy; 2018</p>
            </form>
        </div>

    </body>
</html>
