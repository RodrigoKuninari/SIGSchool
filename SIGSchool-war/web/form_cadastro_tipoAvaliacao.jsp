<form action="${pageContext.request.contextPath}/tipoAvaliacao_Cadastrar_tipoAvaliacao">
    <fieldset>
        <legend>Cadastrar Avalia��o da Disciplina</legend>
        <!--Definir Avalia��o da Disciplina-->
        <c:if test="${status}">
            <p><span class="validate_success">${mensagem_retorno}</span></p>
        </c:if>
        <p>
            <label>Disciplina:</label>
            <select id="professorDisciplina" name="professorDisciplina">
                <option value=""></option>
                <c:forEach var="professorDisciplina" items="${requestScope.lstprofessorDisciplinas}">
                    <option value="${professorDisciplina.id}">${professorDisciplina.coordenadorTurma.getAno()} - ${professorDisciplina.coordenadorTurma.getSerie()}� S�rie - ${professorDisciplina.coordenadorTurma.coordenador.getNome()} - ${professorDisciplina.disciplina.getNome()} - ${professorDisciplina.professor.getNome()}</option>
                </c:forEach>
            </select>
            <span class="field_desc">Disciplina</span>
        </p>
        <p>
            <label>Tipo da Avalia��o:</label>
            <select id="nome" name="nome">
                <option value=""></option>
                <option value="Atividade">Atividade</option>
                <option value="Exerc�cio">Exerc�cio</option>
                <option value="Prova">Prova</option>
                <option value="Tarefa">Tarefa</option>
                <option value="Trabalho">Trabalho</option>
            </select>
            <span class="field_desc">Tipo da Avalia��o</span>
        </p>
        <p>
            <label>Descri��o:</label>
            <input type="text" id="descricao" name="descricao" class="mf"/>
            <span class="field_desc">Descri��o da Avalia��o</span>
        </p>
        <p>
            <label>Data da Avalia��o:</label>
            <input type="text" id="dataAvaliacao" name="dataAvaliacao" class="datepicker"/>
            <span class="field_desc">Data da Avalia��o</span>
        </p>
        <p>
            <input class="button" type="submit" value="Salvar" />
            <input class="button" type="reset" value="Limpar" />
        </p>
    </fieldset>
</form>