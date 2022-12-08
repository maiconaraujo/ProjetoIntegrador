<%-- 
    Document   : acessoNegado
    Created on : 22/02/2018, 09:06:55
    Author     : sala308b
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="caminho" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <link href="${caminho}/css/navcss.css" rel="stylesheet" type="text/css"/>
        <link href="${caminho}/css/acessoNegado.css" rel="stylesheet" type="text/css"/>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
        <link rel="shortcut icon" type="image/ico" href="${caminho}/img/Favicon.ico"/>
    </head>
    <body>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <form class="form-signin" method="post" action="${caminho}/login">
            <img class="mb-4 " src="${caminho}/img/logo-projetoPequeno.png"  alt="" width="115" height="115" >      
            <div class=" alert alert-danger">
                <h1>Acesso negado á esta área !</h1>
                <h3>Volte para a página de login! </h3>
            </div> 
            <a href="${caminho}/login.jsp" class="btn btn-lg btn-primary btn-block"> Login </a>
            <p class="mt-5 mb-3 text-muted">&copy; 2018</p>
        </form>
    </body>
</html>
