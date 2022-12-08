<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="caminho" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href="${caminho}/css/navcss.css" rel="stylesheet" type="text/css"/>
        <link href="${caminho}/login.jsp"/>
        <link rel="shortcut icon" type="image/ico" href="${caminho}/img/Favicon.ico"/>

    <body>
        <nav class="navbar navbar-expand-md navbar-light bg-light mb-4">

            <a class="navbar-brand" href="#">
                <img id="imgLogo" src="${caminho}/img/logo-projetoPequeno.png"  alt=""  width="40" height="40">
            </a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto"> 

                    <li class="nav-item active">
                        <a class="nav-link" href="${caminho}/jsp/home.jsp">Inicio <span class="sr-only">(current)</span></a>                  
                    </li>

                    <li class="nav-item ">
                        <a class="nav-link" href="${caminho}/criancas"> Crianças
                            <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${caminho}/logout ">Sair
                            <span class="sr-only">(sair)</span></a>
                    </li>
                </ul>
            </div>
        </nav>
    </body>
</head>
</html>