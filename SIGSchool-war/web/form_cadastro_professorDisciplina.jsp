<form action="${pageContext.request.contextPath}/professorDisciplina_Cadastrar_professorDisciplina">
    <fieldset>
        <legend>Definir Professor da Disciplina</legend>
        <!--Definir Professor da Disciplina-->
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
            <label>Professor:</label>
            <select id="professor" name="professor">
                <option value=""></option>
                <c:forEach var="professor" items="${requestScope.lstprofessores}">
                    <option value="${professor.id}">${professor.nome}</option>
                </c:forEach>
            </select>
            <span class="field_desc">Professor</span>
        </p>
        <p>
            <label>Disciplina:</label>
            <select id="disciplina" name="disciplina">
                <option value=""></option>
                <c:forEach var="disciplina" items="${requestScope.lstdisciplinas}">
                    <option value="${disciplina.id}">${disciplina.nome}</option>
                </c:forEach>
            </select>
            <span class="field_desc">Disciplina</span>
        </p> 
        <p>
            <input class="button" type="submit" value="Salvar" />
            <input class="button" type="reset" value="Limpar" />
        </p>
    </fieldset>
</form>