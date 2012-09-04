<h2>Lista de Alunos e suas Disciplinas e Médias</h2>
<form method="post" id="frm-filtro">
    <p>
        <label for="pesquisar">Pesquisar</label>
        <input type="text" id="pesquisar" name="pesquisar" size="30" />
    </p>
</form>
<c:choose>
    <c:when test="${empty lsthistoricoNotas}">
        <p>- N&atilde;o h&aacute; Alunos registrados </p>
    </c:when>
    <c:otherwise>
        <table class="normal tablesorter">
            <thead>
                <tr>
                    <th>Select</th>
                    <th>Matrícula</th>
                    <th>Aluno</th>
                    <th>Turma</th>
                    <th>Disciplina</th>
                    <th>Professor</th>
                    <th>Matrícula</th>
                    <th>Média</th>
                    <th>Situação</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="historicoNota" items="${requestScope.lsthistoricoNotas}">
                <tr class="odd">
                    <td><input type="checkbox" class="iphone" /></td>
                    <td>${historicoNota.historico.aluno.getMatricula()}</td>
                    <td>${historicoNota.historico.aluno.getNome()}</td>
                    <td>${historicoNota.professorDisciplina.coordenadorTurma.ano} - ${historicoNota.professorDisciplina.coordenadorTurma.serie}ª Série - ${historicoNota.professorDisciplina.coordenadorTurma.coordenador.getNome()}</td>
                    <td>${historicoNota.professorDisciplina.disciplina.getNome()}</td>
                    <td>${historicoNota.professorDisciplina.professor.getNome()}</td>
                    <td>${historicoNota.professorDisciplina.professor.getMatricula()}</td>
                    <td>${historicoNota.media}</td>
                    <td>${historicoNota.historico.getSituacao()}</td>
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