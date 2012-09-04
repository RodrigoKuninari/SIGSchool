<h2>Lista de Disciplinas e suas Avaliações</h2>
<form method="post" id="frm-filtro">
    <p>
        <label for="pesquisar">Pesquisar</label>
        <input type="text" id="pesquisar" name="pesquisar" size="30" />
    </p>
</form>
<c:choose>
    <c:when test="${empty lsttipoAvaliacoes}">
        <p>- N&atilde;o h&aacute; avaliações cadastradas </p>
    </c:when>
    <c:otherwise>
        <table class="normal tablesorter">
            <thead>
                <tr>
                    <th>Turma</th>
                    <th>Professor</th>
                    <th>Disciplina</th>
                    <th>Avaliação</th>
                    <th>Descrição</th>
                    <th>Aluno</th>
                    <th>Nota</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="tipoAvaliacao" items="${requestScope.lsttipoAvaliacoes}">
                <tr class="odd">
                    <td>${tipoAvaliacao.historicoNotas.professorDisciplina.coordenadorTurma.getAno()} - ${tipoAvaliacao.historicoNotas.professorDisciplina.coordenadorTurma.getSerie()}ª Série - ${tipoAvaliacao.historicoNotas.professorDisciplina.coordenadorTurma.coordenador.getNome()}</td>
                    <td>${tipoAvaliacao.historicoNotas.professorDisciplina.professor.getNome()}</td>
                    <td>${tipoAvaliacao.historicoNotas.professorDisciplina.disciplina.getNome()}</td>
                    <td>${tipoAvaliacao.getNome()}</td>
                    <td>${tipoAvaliacao.getDescricao()}</td>
                    <td>${tipoAvaliacao.historicoNotas.historico.aluno.getNome()}</td>
                    <td>${tipoAvaliacao.getNota()}</td>
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