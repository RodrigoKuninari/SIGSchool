<form action="${pageContext.request.contextPath}/aluno_Cadastrar_aluno" onsubmit="return valida_form(this);" > 
    <fieldset>
        <legend>Cadastro De Aluno</legend>
        <!--Cadastrar Responsavel-->
        <c:if test="${status}">
            <p><span class="validate_success">${mensagem_retorno}</span></p>
        </c:if>        
        <p>
            <label>Matr�cula:</label>
            <input type="text" id="matricula" name="matricula" class="mf"/>
            <span class="field_desc">Matricula do Aluno</span>
        </p>
        <p>
            <label>Nome:</label>
            <input type="text" id="nome" name="nome" class="mf"/>
            <span class="field_desc">Nome do Aluno</span>
        </p>
        <p>
            <label>Sexo:</label>
            <select id="sexo" name="sexo">
                <option value="M">Masculino</option>
                <option value="F">Feminino</option>
            </select>
            <span class="field_desc">Masculino/Feminino</span>
        </p>
        <p>
            <label>E-mail:</label>
            <input type="text" id="email" name="email" class="mf"/>
            <span class="field_desc">Email do Aluno</span>
        </p>
        <p>
            <label>Tel. Res:</label>
            <input type="text" id="telRes" name="telRes" class="mf"/>
            <span class="field_desc">Telefone Residencial</span>
        </p>
        <p>
            <label>Tel. Cel:</label>
            <input type="text" id="telCel" name="telCel" class="mf"/>
            <span class="field_desc">Telefone Celular</span>
        </p>
        <p>
            <label>Data de Nascimento:</label>
            <input type="text" id="dataNasc" name="dataNasc" class="datepicker"/>
            <span class="field_desc">Data de Nascimento</span>
        </p>
        <p>
            <label>Respons�vel:</label>
            <select id="responsavel" name="responsavel">
                <option value=""></option>
                <c:forEach var="responsavel" items="${requestScope.lstresponsaveis}">
                    <option value="${responsavel.id}">${responsavel.nome}</option>
                </c:forEach>
            </select>
            <span class="field_desc">Respons�vel do Aluno</span>
        </p>
    </fieldset>
    <fieldset>
        <legend>Endere�o</legend>
        <p>
            <label>Logradouro:</label>
            <input type="text" id="logradouro" name="logradouro" class="mf"/>
            <span class="field_desc">Logradouro do Endere�o</span>
        </p>
        <p>
            <label>N�mero:</label>
            <input type="text" id="numero" name="numero" class="mf"/>
            <span class="field_desc">N�mero do Endere�o</span>
        </p>            
        <p>
            <label>Bairro:</label>
            <input type="text" id="bairro" name="bairro" class="mf"/>
            <span class="field_desc">Bairro do Endere�o</span>
        </p>            
        <p>
            <label>Cidade:</label>
            <input type="text" id="cidade" name="cidade" class="mf"/>
            <span class="field_desc">Cidade do Endere�o</span>
        </p>
        <p>
            <label>UF:</label>
            <select id="uf" name="uf">
                <option value=""></option>
                <option value="AC">Acre</option>
                <option value="AL">Alagoas</option>
                <option value="AP">Amap�</option>
                <option value="AM">Amazonas</option>
                <option value="BA">Bahia</option>
                <option value="CE">Cear�</option>
                <option value="DF">Distrito Federal</option>
                <option value="ES">Esp�rito Santo</option>
                <option value="GO">Goi�s</option>
                <option value="MA">Maranh�o</option>
                <option value="MT">Mato Grosso</option>
                <option value="MS">Mato Grosso do Sul</option>
                <option value="MG">Minas Gerais</option>
                <option value="PR">Paran�</option>
                <option value="PB">Para�ba</option>
                <option value="PA">Par�</option>
                <option value="PE">Pernambuco</option>
                <option value="PI">Piau�</option>
                <option value="RJ">Rio de Janeiro</option>
                <option value="RN">Rio Grande do Norte</option>
                <option value="RS">Rio Grande do Sul</option>
                <option value="RO">Rond�nia</option>
                <option value="RR">Roraima</option>
                <option value="SC">Santa Catarina</option>
                <option value="SE">Sergipe</option>
                <option value="SP">S�o Paulo</option>
                <option value="TO">Tocantins</option>
            </select>
            <span class="field_desc">UF do Endere�o</span>
        </p>
        <p>
            <label>CEP:</label>
            <input type="text" id="cep" name="cep" class="mf"/>
            <span class="field_desc">CEP do Endere�o</span>
        </p>    
        <p>
            <input class="button" type="submit" value="Salvar" />
            <input class="button" type="reset" value="Limpar" />
        </p>
    </fieldset>
</form>