<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="caminho" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <link href="${caminho}/css/navcss.css" rel="stylesheet" type="text/css"/>

        <style>
            #imgHome{

                width: 100%;
                height: 20%;
                background-size: 100% 100%;


            }
        </style>        
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
        <link rel="shortcut icon" type="image/ico" href="${caminho}/img/Favicon.ico"/>
    <body>
        <c:import url="cabecalho.jsp" /> 
        <div id="imgHome"> 
            <div class="text-center">
                <img src="../img/logo-projeto-png_1.png" class="img-fluid" alt="">
            </div>
        </div>
    </body>
</head>
</html>