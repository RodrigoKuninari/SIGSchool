<form action="${pageContext.request.contextPath}/disciplina_Cadastrar_disciplina">
    <fieldset>
        <legend>Cadastrar Disciplina</legend>
        <!--Cadastrar Disciplina-->
        <c:if test="${status}">
            <p><span class="validate_success">${mensagem_retorno}</span></p>
        </c:if>
        <p>
            <label>Nome:</label>
            <input type="text" id="nome" name="nome" class="mf"/>
            <span class="field_desc">Nome da Disciplina</span>
        </p>
        <p>
            <input class="button" type="submit" value="Salvar" />
            <input class="button" type="reset" value="Limpar" />
        </p>

    </fieldset>
</form>
