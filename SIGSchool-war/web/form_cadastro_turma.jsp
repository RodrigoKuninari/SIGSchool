<form action="${pageContext.request.contextPath}/turma_Cadastrar_turma">
    <fieldset>
        <legend>Cadastrar Alunos da Turma</legend>
        <!--Definir a Turma e seus Alunos-->
        <c:if test="${status}">
            <p><span class="validate_success">${mensagem_retorno}</span></p>
        </c:if>
        <p>
            <label>Turma:</label>
            <select id="coordenadorTurma" name="coordenadorTurma">
                <option value=""></option>
                <c:forEach var="coordenadorTurma" items="${requestScope.lstcoordenadorTurmas}">
                    <option value="${coordenadorTurma.id}">${coordenadorTurma.ano} - ${coordenadorTurma.serie}ª Série - ${coordenadorTurma.coordenador.getNome()}</option>
                </c:forEach>
            </select>
            <span class="field_desc">Turma</span>
        </p>  
        <p>
        <label>Alunos:</label>
        <table class="normal tablesorter">
            <thead>
                <tr>
                    <th>Select</th>
                    <th>Aluno</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="historico" items="${requestScope.lsthistoricos}">
                    <tr class="odd">
                        <td><input type="checkbox" name="aluno" value="${historico.aluno.getNome()}"></td>
                        <td>${historico.aluno.getNome()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <span class="field_desc">Alunos</span>
        </p>
        <p>
            <input class="button" type="submit" value="Salvar" />
            <input class="button" type="reset" value="Limpar" />
        </p>
    </fieldset>
</form>