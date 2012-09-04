<h2>Lista de Professores e suas Disciplinas</h2>
<form method="post" id="frm-filtro">
    <p>
        <label for="pesquisar">Pesquisar</label>
        <input type="text" id="pesquisar" name="pesquisar" size="30" />
    </p>
</form>
<p>
    <a href="${pageContext.request.contextPath}/professorDisciplina_Form_cadastrar" style="text-decoration:none" >
        <input class="button" type="submit" value="Cadastrar Professor/Disciplina" />
    </a>
</p>
<c:choose>
    <c:when test="${empty lstprofessorDisciplinas}">
        <p>- N&atilde;o h&aacute; professores registrados </p>
    </c:when>
    <c:otherwise>
        <table class="normal tablesorter">
            <thead>
                <tr>
                    <th>Select</th>
                    <th>Turma</th>
                    <th>Professor</th>
                    <th>Matrícula</th>
                    <th>Disciplina</th>
                    <th>Opções</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="professorDisciplina" items="${requestScope.lstprofessorDisciplinas}">
                <tr class="odd">
                    <td><input type="checkbox" class="iphone" /></td>
                    <td>${professorDisciplina.coordenadorTurma.ano} - ${professorDisciplina.coordenadorTurma.serie}ª Série - ${professorDisciplina.coordenadorTurma.coordenador.getNome()}</td>
                    <td>${professorDisciplina.professor.getNome()}</td>
                    <td>${professorDisciplina.professor.getMatricula()}</td>
                    <td>${professorDisciplina.disciplina.getNome()}</td>
                <td>
                    <a href="#" title="Editar Professor e sua Disciplina" class="tooltip table_icon"><img src="./assets/icons/actions_small/pencil.png" alt="" /></a> 
<!--                    <a href="#" title="Preferences" class="tooltip table_icon"><img src="./assets/icons/actions_small/preferences.png" alt="" /></a>-->
                    <a href="#" title="Deletar Professor e sua Disciplina" class="tooltip table_icon"><img src="./assets/icons/actions_small/trash.png" alt="" /></a>
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