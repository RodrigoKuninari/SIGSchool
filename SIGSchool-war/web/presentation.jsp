<%-- 
    Document   : presentation
    Created on : 10/11/2011, 13:37:06
    Author     : systematica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 

        <title>SIGSchool | Sistema Online de Agenda Escolar</title>

        <link type="text/css" href="./style.css" rel="stylesheet" /> 
        <link type="text/css" href="./css/jquery.cleditor.css" rel="stylesheet" />

        <!--Tem ser dois senão não funciona seilá o porque-->
        <script type='text/javascript' src='./js/jquery-1.4.2.min.js'></script>	
        <script type='text/javascript' src='./js/jquery-1.4.2.min.js'></script>	

        <script type='text/javascript' src='./js/jquery-ui-1.8.5.custom.min.js'></script>
        <script type='text/javascript' src='./js/cufon-yui.js'></script>
        <script type='text/javascript' src='./js/colaboratelight_400.font.js'></script>
        <script type='text/javascript' src='./js/easytooltip.js'></script>
        <script type='text/javascript' src='./js/jquery.tablesorter.min.js'></script>
        <script type='text/javascript' src='./js/visualize.jquery.js'></script>
        <script type='text/javascript' src='./js/iphone-style-checkboxes.js'></script>
        <script type='text/javascript' src='./js/jquery.cleditor.min.js'></script>
        <script type='text/javascript' src='./js/custom.js'></script>

        <!--Pra Colocar Mascara-->
        <script type='text/javascript' src='./js/jquery.maskedinput-1.3.js'></script>

        <script type='text/javascript' src='./javaScript/${opc}.js'></script>

        <!--Tabela-->
        <script type='text/javascript' src='./js/jquery.tablesorter.pager.js'></script>
    </head>
    <body>
        <div id="container">

            <div id="bgwrap">
                <div id="primary_left">

                    <div id="logo">
                        <a href="http://hello.amnesio.com/dashboard.html" title="Dashboard"><img src="./assets/logo.png" alt="" /></a>
                    </div> <!-- logo end -->

                    <div id="menu"> 
                        <ul>
                            <li class="tooltip" title="Cadastro das Tabelas de Apoio">
                                <a href="#">
                                    <img src="./assets/icons/small_icons_3/users.png" alt="" />
                                    <span>Cadastrar</span>
                                </a>
                                <ul>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/professor_Form_cadastrar">
                                            Professor
                                        </a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/coordenador_Form_cadastrar">
                                            Coordenador
                                        </a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/responsavel_Form_cadastrar">
                                            Responsável
                                        </a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/disciplina_Form_cadastrar">
                                            Disciplina
                                        </a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/coordenadorTurma_Form_cadastrar">
                                            Definir Coordenador da Turma
                                        </a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/professorDisciplina_Form_cadastrar">
                                            Definir Professor da Disciplina
                                        </a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/aluno_Form_cadastrar">
                                            Aluno
                                        </a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/turma_Form_cadastrar">
                                            Cadastrar Alunos da Turma
                                        </a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/tipoAvaliacao_Form_cadastrar">
                                            Cadastrar Avaliação da Disciplina
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">
                                    <img src="./assets/icons/small_icons_3/posts.png" alt="" />
                                    <span>Listar</span> 
                                </a>
                                <ul>
                                    <li><a href="${pageContext.request.contextPath}/professor_Listar_professores">Professores</a></li>
                                    <li><a href="${pageContext.request.contextPath}/coordenador_Listar_coordenadores">Coordenadores</a></li>
                                    <li><a href="${pageContext.request.contextPath}/responsavel_Listar_responsaveis">Responsáveis</a></li>
                                    <li><a href="${pageContext.request.contextPath}/disciplina_Listar_disciplinas">Disciplinas</a></li>
                                    <li><a href="${pageContext.request.contextPath}/coordenadorTurma_Listar_coordenadorTurmas">Coordenadores e suas Turmas</a></li>
                                    <li><a href="${pageContext.request.contextPath}/professorDisciplina_Listar_professorDisciplinas">Professores e suas Disciplinas</a></li>
                                    <li><a href="${pageContext.request.contextPath}/aluno_Listar_alunos">Alunos</a></li>
                                    <li><a href="${pageContext.request.contextPath}/turma_Listar_turmas">Turmas e seus Alunos</a></li>
                                    <li><a href="${pageContext.request.contextPath}/historicoNota_Listar_historicoNotas">Alunos e suas Disciplinas e Médias</a></li>
                                    <li><a href="${pageContext.request.contextPath}/tipoAvaliacao_Listar_tipoAvaliacoes">Avaliações</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div> <!-- navigation menu end -->
                </div> <!-- sidebar end -->

                <div id="primary_right">
                    <div class="inner">
                        <h1>SIGSchool | Sistema Online de Agenda Escolar</h1>
                        <ul class="dash">
                            <li class="fade_hover tooltip" title="Listar Professores">
                                <span class="bubble">Professor</span>
                                <a href="${pageContext.request.contextPath}/professor_Listar_professores">
                                    <img src="./assets/icons/dashboard/54.png" alt="" />
                                    <span>Professores</span>
                                </a>
                            </li>
                            <li class="fade_hover tooltip" title="Listar Coordenadores">
                                <span class="bubble">Coordenador</span>
                                <a href="${pageContext.request.contextPath}/coordenador_Listar_coordenadores">
                                    <img src="./assets/icons/dashboard/54.png" alt="" /> 
                                    <span>Coordenadores</span>
                                </a>
                            </li>
                            <li class="fade_hover tooltip" title="Listar Responsáveis">
                                <span class="bubble">Responsável</span>
                                <a href="${pageContext.request.contextPath}/responsavel_Listar_responsaveis">
                                    <img src="./assets/icons/dashboard/54.png" alt="" />
                                    <span>Resposáveis</span>
                                </a>
                            </li>
                            <li class="fade_hover tooltip" title="Listar Disciplinas">
                                <a href="${pageContext.request.contextPath}/disciplina_Listar_disciplinas">
                                    <img src="./assets/icons/dashboard/123.png" alt="" />
                                    <span>Disciplinas</span>
                                </a>
                            </li>
                            <li class="fade_hover tooltip" title="Listar Coordenador e sua Turma">
                                <a href="${pageContext.request.contextPath}/coordenadorTurma_Listar_coordenadorTurmas">
                                    <img src="./assets/icons/dashboard/75.png" alt="" />
                                    <span>Coordenador e sua Turma</span>
                                </a>
                            </li>
                            <li class="fade_hover tooltip" title="Listar Professor e sua Disciplina">
                                <a href="${pageContext.request.contextPath}/professorDisciplina_Listar_professorDisciplinas">
                                    <img src="./assets/icons/dashboard/42.png" alt="" />
                                    <span>Professor e sua Disciplina</span>
                                </a>
                            </li>
                            <li class="fade_hover tooltip" title="Listar Alunos">
                                <span class="bubble">Aluno</span>
                                <a href="${pageContext.request.contextPath}/aluno_Listar_alunos">
                                    <img src="./assets/icons/dashboard/54.png" alt="" />
                                    <span>Alunos</span>
                                </a>
                            </li>
                            <li class="fade_hover tooltip" title="Listar Turma e seus Alunos">
                                <a href="${pageContext.request.contextPath}/turma_Listar_turmas">
                                    <img src="./assets/icons/dashboard/3.png" alt="" />
                                    <span>Turma e seus Alunos</span>
                                </a>
                            </li>
                            <li class="fade_hover tooltip" title="Listar Histórico dos Alunos">
                                <a href="${pageContext.request.contextPath}/historicoNota_Listar_historicoNotas">
                                    <img src="./assets/icons/dashboard/81.png" alt="" />
                                    <span>Histórico dos Alunos</span>
                                </a>
                            </li>
                            <li class="fade_hover tooltip" title="Listar Avaliações dos Alunos">
                                <a href="${pageContext.request.contextPath}/tipoAvaliacao_Listar_tipoAvaliacoes">
                                    <img src="./assets/icons/dashboard/123.png" alt="" />
                                    <span>Avaliações dos Alunos</span>
                                </a>
                            </li>
                            <li class="fade_hover tooltip dialog_link" title="End current session">
                                <a href="#">
                                    <img src="./assets/icons/dashboard/118.png" alt="" />
                                    <span>Logout</span>
                                </a>
                            </li>
                        </ul>
                    </div>               
                    <c:if test="${opc!=''}">
                        <div class="inner">
                            <fieldset>
                                <!--Cadastrar Endereco-->
                                <c:if test="${opc=='cadastrar'}">
                                    <%@ include file="form_cadastro_endereco.jsp" %>  
                                </c:if>
                                <!--Cadastrar Professor-->
                                <c:if test="${opc=='professor_Cadastrar_professor'}">
                                    <%@ include file="form_cadastro_professor.jsp" %>  
                                </c:if>
                                <!--Editar Professor-->
                                <c:if test="${opc=='professor_Editar_professor'}">
                                    <%@ include file="editar_professor.jsp" %>  
                                </c:if>
                                <!--Cadastrar Coordenador-->
                                <c:if test="${opc=='coordenador_Cadastrar_coordenador'}">
                                    <%@ include file="form_cadastro_coordenador.jsp" %>  
                                </c:if>
                                <!--Cadastrar Responsavel-->
                                <c:if test="${opc=='responsavel_Cadastrar_responsavel'}">
                                    <%@ include file="form_cadastro_responsavel.jsp" %>  
                                </c:if>
                                <!--Cadastrar Disciplina-->
                                <c:if test="${opc=='disciplina_Cadastrar_disciplina'}">
                                    <%@ include file="form_cadastro_disciplina.jsp" %>  
                                </c:if>
                                <!--Definir Coordenador da Turma-->
                                <c:if test="${opc=='coordenadorTurma_Cadastrar_coordenadorTurma'}">
                                    <%@ include file="form_cadastro_coordenadorTurma.jsp" %>  
                                </c:if>
                                <!--Definir Professor da Disciplina-->
                                <c:if test="${opc=='professorDisciplina_Cadastrar_professorDisciplina'}">
                                    <%@ include file="form_cadastro_professorDisciplina.jsp" %>  
                                </c:if>
                                <!--Cadastrar Aluno-->
                                <c:if test="${opc=='aluno_Cadastrar_aluno'}">
                                    <%@ include file="form_cadastro_aluno.jsp" %>  
                                </c:if>
                                <!--Definir Alunos da Turma-->
                                <c:if test="${opc=='turma_Cadastrar_turma'}">
                                    <%@ include file="form_cadastro_turma.jsp" %>  
                                </c:if>
                                <!--Cadastrar Avaliacao da Disciplina-->
                                <c:if test="${opc=='tipoAvaliacao_Cadastrar_tipoAvaliacao'}">
                                    <%@ include file="form_cadastro_tipoAvaliacao.jsp" %>  
                                </c:if>
                                <!--Listar Professor-->
                                <c:if test="${opc=='professor_Listar_professores'}">
                                    <%@ include file="listar_professores.jsp" %>  
                                </c:if>
                                <!--Listar Coordenador-->
                                <c:if test="${opc=='coordenador_Listar_coordenadores'}">
                                    <%@ include file="listar_coordenadores.jsp" %>  
                                </c:if>
                                <!--Listar Responsavel-->
                                <c:if test="${opc=='responsavel_Listar_responsaveis'}">
                                    <%@ include file="listar_responsaveis.jsp" %>  
                                </c:if>
                                <!--Listar Disciplinas-->
                                <c:if test="${opc=='disciplina_Listar_disciplinas'}">
                                    <%@ include file="listar_disciplinas.jsp" %>  
                                </c:if>
                                <!--Listar Coordenadores e suas Turmas-->
                                <c:if test="${opc=='coordenadorTurma_Listar_coordenadorTurmas'}">
                                    <%@ include file="listar_coordenadorTurmas.jsp" %>  
                                </c:if>
                                <!--Listar Professores e suas Turmas-->
                                <c:if test="${opc=='professorDisciplina_Listar_professorDisciplinas'}">
                                    <%@ include file="listar_professorDisciplinas.jsp" %>  
                                </c:if>
                                <!--Listar Alunos-->
                                <c:if test="${opc=='aluno_Listar_alunos'}">
                                    <%@ include file="listar_alunos.jsp" %>  
                                </c:if>
                                <!--Listar Turmas e seus Alunos-->
                                <c:if test="${opc=='turma_Listar_turmas'}">
                                    <%@ include file="listar_turmas.jsp" %>  
                                </c:if>
                                <!--Listar Alunos e suas Disciplinas e Médias-->
                                <c:if test="${opc=='historicoNota_Listar_historicoNotas'}">
                                    <%@ include file="listar_historicoNotas.jsp" %>  
                                </c:if>
                                <!--Listar Avalicoes-->
                                <c:if test="${opc=='tipoAvaliacao_Listar_tipoAvaliacoes'}">
                                    <%@ include file="listar_tipoAvaliacoes.jsp" %>  
                                </c:if>

                                <c:if test="${opc=='dashboard'}">
                                    <jsp:include page="conteudo.jsp" />  
                                </c:if>
                            </fieldset>
                        </div>
                    </c:if>
                </div>
            </div>
        </div> 
    </body>
</html>
