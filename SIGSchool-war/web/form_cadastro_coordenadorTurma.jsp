<form action="${pageContext.request.contextPath}/coordenadorTurma_Cadastrar_coordenadorTurma">
    <fieldset>
        <legend>Definir Coordenador da Turma</legend>
        <!--Definir Coordenador da Turma-->
        <c:if test="${status}">
            <p><span class="validate_success">${mensagem_retorno}</span></p>
        </c:if>
        <p>
            <label>Coordenador:</label>
            <select id="coordenador" name="coordenador">
                <option value=""></option>
                <c:forEach var="coordenador" items="${requestScope.lstcoordenadores}">
                    <option value="${coordenador.id}">${coordenador.nome}</option>
                </c:forEach>
            </select>
            <span class="field_desc">Coordenador da Turma</span>
        </p>
        <p>
            <label>Ano:</label>
            <select id="ano" name="ano">
                <option value=""></option>
                <option value="2011">2011</option>
            </select>
            <span class="field_desc">Ano da Turma</span>
        </p>
        <p>
            <label>Série:</label>
            <select id="serie" name="serie">
                <option value=""></option>
                <option value="1">1ª Série - Ensino Fundamental</option>
                <option value="2">2ª Série - Ensino Fundamental</option>
                <option value="3">3ª Série - Ensino Fundamental</option>
                <option value="4">4ª Série - Ensino Fundamental</option>
                <option value="5">5ª Série - Ensino Fundamental</option>
                <option value="6">6ª Série - Ensino Fundamental</option>
                <option value="7">7ª Série - Ensino Fundamental</option>
                <option value="8">8ª Série - Ensino Fundamental</option>
                <option value="9">9ª Série - Ensino Fundamental</option>
            </select>
            <span class="field_desc">Série da Turma</span>
        </p>   
        <p>
            <input class="button" type="submit" value="Salvar" />
            <input class="button" type="reset" value="Limpar" />
        </p>
    </fieldset>
</form>