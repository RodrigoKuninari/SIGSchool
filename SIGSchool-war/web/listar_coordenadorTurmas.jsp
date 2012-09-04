<h2>Lista de Coordenadores e suas Turmas</h2>
<form method="post" id="frm-filtro">
    <p>
        <label for="pesquisar">Pesquisar</label>
        <input type="text" id="pesquisar" name="pesquisar" size="30" />
    </p>
</form>
<p>
    <a href="${pageContext.request.contextPath}/coordenadorTurma_Form_cadastrar" style="text-decoration:none" >
        <input class="button" type="submit" value="Cadastrar Coordenador/Turma" />
    </a>
</p>
<c:choose>
    <c:when test="${empty lstcoordenadorTurmas}">
        <p>- N&atilde;o h&aacute; coordenadores registrados </p>
    </c:when>
    <c:otherwise>
        <table class="normal tablesorter">
            <thead>
                <tr>
                    <th>Matrícula</th>
                    <th>Coordenador</th>
                    <th>Ano</th>
                    <th>Série</th>
                    <th>Opções</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="coordenadorTurma" items="${requestScope.lstcoordenadorTurmas}">
                <tr class="odd">
                    <td>${coordenadorTurma.coordenador.getMatricula()}</td>
                    <td>${coordenadorTurma.coordenador.getNome()}</td>
                    <td>${coordenadorTurma.ano}</td>
                    <td>${coordenadorTurma.serie}ª Série - Ensino Fundamental</td>
                <td>
                    <a href="#" title="Editar Coordenador e sua Turma" class="tooltip table_icon"><img src="./assets/icons/actions_small/pencil.png" alt="" /></a> 
<!--                    <a href="#" title="Preferences" class="tooltip table_icon"><img src="./assets/icons/actions_small/preferences.png" alt="" /></a>-->
                    <a href="#" title="Deletar Coordenador e sua Turma" class="tooltip table_icon"><img src="./assets/icons/actions_small/trash.png" alt="" /></a>
                </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>
                
                
<div id="pager" class="pager">
    <form>
        <span>
            Exibir 
            <select class="pagesize">
                <option selected="selected"  value="10">10</option>
                <option value="20">20</option>
                <option value="30">30</option>
                <option  value="40">40</option>
            </select> registros
        </span>
        <img src="img/first.png" class="first"/>
        <img src="img/prev.png" class="prev"/>
        <input type="text" class="pagedisplay"/>
        <img src="img/next.png" class="next"/>
        <img src="img/last.png" class="last"/>
    </form>
</div>
