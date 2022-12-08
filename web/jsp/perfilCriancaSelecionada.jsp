<%-- 
    Document   : perfilCriancaSelecionada
    Created on : 10/05/2018, 11:33:07
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            .div1{
                border: solid;
                border-left: 2px;
                border-right: 2px;
                border-radius: 10px;
                border-color: #0099ff;
                padding: 5px;
            }
            .div2{
                border: solid;
                border-top: 2px;
                border-bottom: 2px;                
                border-radius: 10px;
                border-color: #0099ff;
                padding: 5px;

                text-indent: 0.5em;
            }
            .tdD{
                background-color: #9efdfd;
            }
        </style>
        <title>Perfil de Criança</title>
        <link rel="shortcut icon" type="image/ico" href="${caminho}/img/Favicon.ico"/>
    </head>
    <body>
        <c:import url="cabecalho.jsp" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>

        <div class="table-responsive div1">
            <div class="div2">

                <h4>1.Dados da Unidade de Acolhimento</h4>
                <label><b>1.1 Nome: ${crianca.un.nome}</b></label> <br>
                <label>Endereço:</label> ${crianca.un.endereco} <br>
                <label>Bairro:</label> ${crianca.un.bairro} <br>
                <label>Municipio:</label> ${crianca.un.municipio} <br>
                <label>Estado:</label> ${crianca.un.estado} <br>
                <label>Telefone:</label> ${crianca.un.telefone} <br>
                <label>Público Alvo:</label> ${crianca.un.publicoAlvo} <br><br>

                <h4>2. Indentificação da Criança</h4>
                <div>
                    <div class="row"> 

                        <div class="col-sm-4">
                            <c:if test="${crianca.fotoCrianca!=null}">
                                <img src="<c:url value="/CarregarImagemCrianca?codigo=${crianca.codigo}" />" width="200" height="200">
                            </c:if>
                        </div>

                    </div> 
                    <br>
                    <div class="col-sm-8">

                        <label><b>2.1 Nome: </label> ${crianca.nome} </b><br>                
                        <label>Naturalidade: </label> ${crianca.naturalidade} <br>
                        <label>Sexo: </label> ${crianca.sexo} <br>
                        <label>Data de Nascimento:</label> <fmt:formatDate value="${crianca.dataNascimento.time}" 
                                        pattern="dd/MM/yyyy"/><br>
                        <label>Apresenta Algum tipo de Deficiencia:</label> ${crianca.tipoDeficiencia} <br>
                        <c:if test="${crianca.tipoDeficiencia.equals('Sim')}">
                            <label>Em caso positivo,informar qual:</label> ${crianca.tipoDeficienciaInfo} <br>
                        </c:if>
                        <br>                            
                    </div>

                </div>


                <h4>3. Idenficação dos Pais e/ou Responsáveis</h4>
                <label><b>3.1 Nome do Pai:</b></label> ${crianca.genitor} <br>

                <label>Data de Nascimento:</label> <fmt:formatDate value="${crianca.dataNascimentoGenitor.time}" 
                                pattern="dd/MM/yyyy"/><br>

                <label>Documento:</label> ${crianca.documentoGenitor} <br>
                <label>Endereço:</label> ${crianca.enderecoGenitor} <br>
                <label>Telefone:</label> ${crianca.telefoneGenitor} <br>
                <br>

                <label><b>3.2 Nome da Mãe:</b></label> ${crianca.genitora} <br>

                <label>Data de Nascimento:</label> <fmt:formatDate value="${crianca.dataNascimentoGenitora.time}" 
                                pattern="dd/MM/yyyy"/><br>

                <label>Documento:</label> ${crianca.documentoGenitora} <br>
                <label>Endereço:</label> ${crianca.enderecoGenitora} <br>
                <label>Telefone:</label> ${crianca.telefoneGenitora} <br>
                <br>

                <label><b>3.3 Responsavel:</b></label> ${crianca.responsavel} <br>

                <label>Data de Nascimento:</label> <fmt:formatDate value="${crianca.dataNascimentoResponsavel.time}" 
                                pattern="dd/MM/yyyy"/><br>

                <label>Documento:</label> ${crianca.documentoResponsavel} <br>
                <label>Endereço:</label> ${crianca.enderecoResponsavel} <br>
                <label>Telefone:</label> ${crianca.telefoneResponsavel} <br>
                <br>

                <h4>4.Dados do Acolhimento</h4>
                <label>Data de Entrada no Acolhimento Institucional:</label> <fmt:formatDate value="${crianca.dataAcolhimento.time}" 
                                pattern="dd/MM/yyyy"/> <br>                    
                <label>Orgão Encaminhador:</label> ${crianca.orgaoEncaminhador} <br>
                <label>Guia de Acolhimento:</label> ${crianca.guiaAcolhimento} <br>
                <label>N° do(s) Processo(s) na Vara da Infância e Juventude:</label> ${crianca.numProcesso} <br>
                <label><b>4.1 Há Irmãos sob Acolhimento Institucional ou Familiar ?</b></label> ${crianca.irmaosSobAcolhimento}<br>
                <c:if test="${crianca.irmaosSobAcolhimento.equals('Sim')}">
                    <label>Em caso positivo,informar qual:</label> ${crianca.irmaosSobAcolhimentoInfo} <br>
                </c:if>
                <label><b>4.2 É o primeiro acolhimento da criança ?</b></label> ${crianca.primeiroAcolhimento}<br>
                <label><b>4.3 A criança possui algum problema de saúde ?</b></label> ${crianca.problemaSaude}<br>
                <c:if test="${crianca.problemaSaude.equals('Sim')}">
                    <label>Em caso positivo,informar qual:</label> ${crianca.problemaSaudeInfo} <br>
                </c:if>
                <label><b>4.4 A criança faz uso de algum medicamento ?</b></label> ${crianca.usoMedicamento}<br>
                <c:if test="${crianca.usoMedicamento.equals('Sim')}">
                    <label>Em caso positivo,informar qual:</label> ${crianca.usoMedicamentoInfo} <br>
                </c:if>

                <br>
                <h4>5. Caracterização da Situação de Violação de Direitos e Justificativa Para Acolhimento</h4>
                <label><b>5.1 Local de ocorrência de Violação de Direitos: </b></label> ${crianca.ja.ocorrenciaViolacaoDireitos} <br>
                <label><b>5.2 Foi elaborada ocorrência policial (B.O)?:</b> </label> ${crianca.ja.ocorrenciaPolicial}<br>
                <label><b>5.3 Algum familiar possui autorização para visita e/ou se existe alguma restrição quanto à visita de familiares?</b></label> <br>
                <label><b>- Familiar Autorizado ?</b></label> ${crianca.ja.familiarAutorizado}
                <c:if test="${crianca.ja.familiarAutorizado.equals('Sim')}">
                    ${crianca.ja.familiarAutorizadoInfo} <br>
                </c:if>
                <label><b>- Restrição ?</b></label> ${crianca.ja.restricaoFamiliar}
                <c:if test="${crianca.ja.restricaoFamiliar.equals('Sim')}">
                    ${crianca.ja.restricaoFamiliarInfo} <br>
                </c:if>
                <br>
                <label><b>5.4 Documentação entregue a equipe da Unidade:</b></label> <br>
                <c:if test="${crianca.ja.guiaAcolhimento.equals(true)}">
                    <label>(x) Guia de Acolhimento;</label> <br>
                </c:if>    
                <c:if test="${crianca.ja.guiaAcolhimento.equals(false)}">
                    <label>( ) Guia de Acolhimento;</label> <br>
                </c:if>

                <c:if test="${crianca.ja.oficioJuizado.equals(true)}">
                    <label>(x) Ofício do Juizado da Infância e Juventude solicitando o acolhimento;</label> <br>
                </c:if>  
                <c:if test="${crianca.ja.oficioJuizado.equals(false)}">
                    <label>( ) Ofício do Juizado da Infância e Juventude solicitando o acolhimento;</label> <br>
                </c:if>

                <c:if test="${crianca.ja.oficioConselho.equals(true)}">
                    <label>(x) Ofício do Conselho Tutelar solicitando o acolhimento;</label> <br>
                </c:if>     
                <c:if test="${crianca.ja.oficioConselho.equals(false)}">
                    <label>( ) Ofício do Conselho Tutelar solicitando o acolhimento;</label> <br>
                </c:if>

                <c:if test="${crianca.ja.relatorioServicoSocial.equals(true)}">
                    <label>(x) Relatório do Serviço Social do Juizado da Infância sobre o caso;</label> <br>
                </c:if> 
                <c:if test="${crianca.ja.relatorioServicoSocial.equals(false)}">
                    <label>( ) Relatório do Serviço Social do Juizado da Infância sobre o caso;</label> <br>
                </c:if>

                <c:if test="${crianca.ja.relatorioConselhoTutelar.equals(true)}">
                    <label>(x) Relatório do Conselho Tutelar sobre o acompanhamento do caso;</label> <br>
                </c:if>     
                <c:if test="${crianca.ja.relatorioConselhoTutelar.equals(false)}">
                    <label>( ) Relatório do Conselho Tutelar sobre o acompanhamento do caso;</label> <br>
                </c:if>

                <c:if test="${crianca.ja.certidaoNascimento.equals(true)}">
                    <label>(x) Certidão de Nascimento da criança;</label> <br>
                </c:if>     
                <c:if test="${crianca.ja.certidaoNascimento.equals(false)}">
                    <label>( ) Certidão de Nascimento da criança;</label> <br>
                </c:if>

                <c:if test="${crianca.ja.cartaoVacina.equals(true)}">
                    <label>(x) Cartão de Vacina;</label> <br>
                </c:if>     
                <c:if test="${crianca.ja.cartaoVacina.equals(false)}">
                    <label>( ) Cartão de Vacina;</label> <br>
                </c:if>

                <br>
                <h4>6. Quais Instituições e Serviços prestaram ou estão prestanto
                    atendimento e/ou orientação ao grupo familiar?</h4>
                <label> ${crianca.pa.atendimento} </label>

                <br>
                <br>
                <h4>7. Qual a opnião da criança quanto à situação de Acolhimento?</h4>
                <label> ${crianca.pa.opiniaoCrianca}</label>

                <br><br>
                <h4>8. Informações sobre a Família de Origem</h4>
                <label><b>8.1 Composição da Residência</b></label>
                <br>

                <div class="row">
                    <div class="col-lg-6">
                        <div class="table-responsive">
                            <table class="table">

                                <td class="tdD"><b>Nome</b></td>
                                <td class="tdD"><b>Idade</b></td>
                                <td class="tdD"><b>Parentesco</b></td>
                                <td class="tdD"><b>Ocupação</b></td>
                                <td class="tdD"><b>Renda</b></td>

                                <c:forEach items="${crianca.ifo.listaresidenciaFamiliaOrigem}" var="rfo">
                                    <tr>
                                        <td>${rfo.nome}</td>
                                        <td>${rfo.idade}</td>
                                        <td>${rfo.parentesco}</td>
                                        <td>${rfo.ocupacao}</td>
                                        <td>${rfo.renda}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>

                <label><b>8.2 Situação SocioFamiliar(trabalho e renda, habitação e saúde):</b></label><br>
                <label>${crianca.ifo.situacaoSociofamiliar}</label><br>
                <label><b>8.3 Qual a opinião da família quanto à situação de 
                        acolhimento e propostas para restabelecimento da convivência familiar?</b></label><br>
                <label>${crianca.ifo.opiniaoFamilia}</label><br>    
                <br>

                <h4>9. Informações a respeito da Familia Extensa</h4>
                <label><b>9.1 Foram identificados parentes próximos com os quais a 
                        criança convive e mantém vínculos de afinidade e afetividade?</b> ${crianca.ife.parentesProximos}</label><br>
                        <c:if test="${crianca.ife.parentesProximos.equals('Sim')}">
                    <label>${crianca.ife.parentesProximosInfo}</label> <br>
                </c:if>
                <label><b>9.2 Foram mantidos contatos ou visitas com os 
                        parentes identificados? ${crianca.ife.contatoParentes}</b></label> <br>
                <label><b>9.3 Dentre os parentes identificados há 
                        interessados em receber a(s) criança(s) sob guarda?</b></label> ${crianca.ife.parentesInteressadosNaGuarda}<br>
                        <c:if test="${crianca.ife.parentesInteressadosNaGuarda.equals('Sim')}">
                    <label>${crianca.ife.parentesInteressadosNaGuardaInfo}</label> <br>
                </c:if>
                <label><b>9.4 Composição da Residência</b></label>
                <br>

                <div class="row">
                    <div class="col-lg-6">
                        <div class="table-responsive">
                            <table class="table">

                                <td class="tdD"><b>Nome</b></td>
                                <td class="tdD"><b>Idade</b></td>
                                <td class="tdD"><b>Parentesco</b></td>
                                <td class="tdD"><b>Ocupação</b></td>
                                <td class="tdD"><b>Renda</b></td>

                                <c:forEach items="${crianca.ife.listaresidenciaFamiliaExtensa}" var="rfe">
                                    <tr>
                                        <td>${rfe.nome}</td>
                                        <td>${rfe.idade}</td>
                                        <td>${rfe.parentesco}</td>
                                        <td>${rfe.ocupacao}</td>
                                        <td>${rfe.renda}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>

                <label><b>9.5 Situação sociofamiliar (trabalho e renda, habitação e saúde):</b></label><br>
                <label>${crianca.ife.situacaoSociofamiliar}</label><br>
                <label><b>9.6 Qual a opinião da família quanto à situação de acolhimento 
                        e propostas para ter a criança sob guarda? </b></label><br>
                <label>${crianca.ife.opiniaoFamiliaExtensa}</label><br> 
                <br>

                <h4>10. Informações a Respeito de Terceiros</h4>
                <label><b>10.1 Foram identificados pessoas com os quais a criança convive
                        e mantém vínculos de afinidade e afetividade?</b> </label> <label>${crianca.it.vinculoTerceiros}</label><br>
                        <c:if test="${crianca.it.vinculoTerceiros.equals('Sim')}">
                    <label>${crianca.it.vinculoTerceirosInfo}</label> <br>
                </c:if>
                <label><b>10.2 Foram mantidos contatos ou visitas com os 
                        terceiros identificados?</b></label> ${crianca.it.contatoTerceiros} <br>
                <label><b>10.3 Dentre os terceiros identificados há interessados em 
                        receber a(s) criança(s) sob guarda?</b></label> ${crianca.it.terceirosInteressadosNaGuarda}</label><br>
                        <c:if test="${crianca.it.terceirosInteressadosNaGuarda.equals('Sim')}">
                    <label>${crianca.it.terceirosInteressadosNaGuardaInfo}</label> <br>
                </c:if>
                <label><b>10.4 Composição da Residência</b></label>
                <br>

                <div class="row">
                    <div class="col-lg-6">
                        <div class="table-responsive">
                            <table class="table">

                                <td class="tdD"><b>Nome</b></td>
                                <td class="tdD"><b>Idade</b></td>
                                <td class="tdD"><b>Ocupação</b></td>
                                <td class="tdD"><b>Renda</b></td>

                                <c:forEach items="${crianca.it.listaresidenciaTerceiros}" var="it">
                                    <tr>
                                        <td>${it.nome}</td>
                                        <td>${it.idade}</td>
                                        <td>${it.ocupacao}</td>
                                        <td>${it.renda}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>

                <label><b>10.5 Situação Sociofamiliar (trabalho e renda, habitação e saúde):</b></label><br>
                <label>${crianca.it.situacaoSociofamiliar}</label><br>
                <label><b>10.6 Qual a opinião da família quanto à situação de 
                        acolhimento e propostas para ter a criança sob guarda?</b></label><br>
                <label>${crianca.it.opiniaoTerceiros}</label><br>
                <br>

                <h4>11. Procedimentos e Encaminhamentos realizados pela
                    Unidade de Acolhimento com a criança</h4>

                <label><b>11.1 Saúde: </b></label><br> <label> ${crianca.puc.saude} </label>
                <br>

                <label><b>11.2 Educação: </b></label><br> <label>${crianca.puc.educacao}</label>
                <br>

                <label><b>11.3 Convivência Comunitária: </b></label><br> <label>${crianca.puc.convivenciaComunitaria}</label>
                <br>

                <label><b>11.4 Manutenção dos vínculos familiares: </b></label><br> <label>${crianca.puc.manutencaoVinculosFamiliares}</label>
                <br>

                <label><b>11.5 Inserção na rede socioassistencial do município: </b></label><br> <label>${crianca.puc.insercaoSocioassistencialMunicipio}</label>
                <br>

                <label><b>11.6 Esporte e Lazer: </b></label><br> <label>${crianca.puc.esporteLazer}</label>
                <br>

                <label><b>11.7 Acompanhamento social: </b></label><br> <label>${crianca.puc.acompanhamentoSocial}</label>
                <br>

                <label><b>11.8 Acompanhamento Psicológico: </b></label><br> <label>${crianca.puc.acompanhamentoPsicologico}</label>
                <br>                
                <br>

                <h4>12. Procedimentos e Encaminhamentos realizados pela
                    Unidade de Acolhimento com a família e/ou Terceiros</h4>

                <label><b>12.1 Visita Domiciliar: </b></label><br> <label>${crianca.pucf.visitaDomiciliar}</label>
                <br>

                <label><b>12.2 Visita Domiciliar: </b></label><br> <label>${crianca.pucf.insercaoSocioassistencialMunicipio}</label>
                <br>
                <br>

                <h4>13. Relato da Situação e Avaliação Interdisciplinar do Caso</h4>
                <label>${crianca.aidc.descricao}</label>
            </div>
        </div>
    </body>
</html>
