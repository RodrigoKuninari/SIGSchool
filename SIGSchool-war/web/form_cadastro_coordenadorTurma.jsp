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
            <label>S�rie:</label>
            <select id="serie" name="serie">
                <option value=""></option>
                <option value="1">1� S�rie - Ensino Fundamental</option>
                <option value="2">2� S�rie - Ensino Fundamental</option>
                <option value="3">3� S�rie - Ensino Fundamental</option>
                <option value="4">4� S�rie - Ensino Fundamental</option>
                <option value="5">5� S�rie - Ensino Fundamental</option>
                <option value="6">6� S�rie - Ensino Fundamental</option>
                <option value="7">7� S�rie - Ensino Fundamental</option>
                <option value="8">8� S�rie - Ensino Fundamental</option>
                <option value="9">9� S�rie - Ensino Fundamental</option>
            </select>
            <span class="field_desc">S�rie da Turma</span>
        </p>   
        <p>
            <input class="button" type="submit" value="Salvar" />
            <input class="button" type="reset" value="Limpar" />
        </p>
    </fieldset>
</form>