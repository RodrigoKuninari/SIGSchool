<h2>Lista de Turmas e seus Alunos</h2>
<form method="post" id="frm-filtro">
    <p>
        <label for="pesquisar">Pesquisar</label>
        <input type="text" id="pesquisar" name="pesquisar" size="30" />
    </p>
</form>
<p>
    <a href="${pageContext.request.contextPath}/turma_Form_cadastrar" style="text-decoration:none" >
        <input class="button" type="submit" value="Aluno/Turma" />
    </a>
</p>
<c:choose>
    <c:when test="${empty lstturmas}">
        <p>- N&atilde;o h&aacute; Turmas e Alunos registrados </p>
    </c:when>
    <c:otherwise>
        <table class="normal tablesorter">
            <thead>
                <tr>
                    <th>Select</th>
                    <th>Turma</th>
                    <th>Aluno</th>
                    <th>Matrícula</th>
                    <th>Opções</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="turma" items="${requestScope.lstturmas}">
                <tr class="odd">
                    <td><input type="checkbox" class="iphone" /></td>
                    <td>${turma.coordenadorTurma.ano} - ${turma.coordenadorTurma.serie}ª Série - ${turma.coordenadorTurma.coordenador.getNome()}</td>
                    <td>${turma.historico.aluno.getNome()}</td>
                    <td>${turma.historico.aluno.getMatricula()}</td>
                <td>
                    <a href="#" title="Editar Turma e seu Aluno" class="tooltip table_icon"><img src="./assets/icons/actions_small/pencil.png" alt="" /></a> 
<!--                    <a href="#" title="Preferences" class="tooltip table_icon"><img src="./assets/icons/actions_small/preferences.png" alt="" /></a>-->
                    <a href="#" title="Deletar Turma e seu Aluno" class="tooltip table_icon"><img src="./assets/icons/actions_small/trash.png" alt="" /></a>
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