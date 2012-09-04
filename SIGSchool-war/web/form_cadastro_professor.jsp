<form id="form_cadastrar_professor" action="${pageContext.request.contextPath}/professor_Cadastrar_professor" onsubmit="return valida_form(this);" >
    <fieldset>
        <legend>Cadastro De Professor</legend>
        <!--Cadastrar Professor-->
        <c:if test="${status}">
            <p><span class="validate_success">${mensagem_retorno}</span></p>
        </c:if>
        <p>
            <label>Matrícula:</label>
            <input type="text" id="matricula" name="matricula" class="mf"/>
            <span id="msg_matricula" class="field_desc">Matrícula do Professor</span>
            <span class="validate_success matricula_success" style="display: none;" >Ok</span>
            <span class="validate_error matricula_error" style="display: none;">Favor informar matrícula!</span>
        </p>
        <p>
            <label>Nome:</label>
            <input type="text" id="nome" name="nome" class="mf"/>
            <span id="msg_nome" class="field_desc">Nome do Professor</span>
            <span class="validate_success nome_success" style="display: none;" >Ok</span>
            <span class="validate_error nome_error" style="display: none;">Favor informar nome!</span>
        </p>
        <p>
            <label>CPF:</label>
            <input type="text" id="cpf" name="cpf" class="mf"/>
            <span id="msg_cpf" class="field_desc">CPF</span>
            <span class="validate_success cpf_success" style="display: none;" >Ok</span>
            <span class="validate_error cpf_error" style="display: none;">Favor informar Cpf!</span>
        </p>
        <p>
            <label>RG:</label>
            <input type="text" id="rg" name="rg" class="mf"/>
            <span id="msg_rg" class="field_desc">RG</span>
            <span class="validate_success rg_success" style="display: none;" >Ok</span>
            <span class="validate_error rg_error" style="display: none;">Favor informar Rg!</span>
        </p>
        <p>
            <label>Sexo:</label>
            <select id="sexo" name="sexo">
                <option value="M">Masculino</option>
                <option value="F">Feminino</option>
            </select>
            <span id="msg_sexo" class="field_desc" >Masculino/Feminino</span>
            <span class="validate_success sexo_success" style="display: none;" >Ok</span>
            <span class="validate_error sexo_error" style="display: none;">Favor informar Sexo!</span>
        </p>
        <p>
            <label>E-mail:</label>
            <input type="text" id="email" name="email" class="mf"/>
            <span id="msg_email" class="field_desc">Email do Professor</span>
            <span class="validate_success email_success" style="display: none;" >Ok</span>
            <span class="validate_error email_error" style="display: none;">Favor informar Email!</span>
        </p>
        <p>
            <label>Tel. Res:</label>
            <input type="text" id="telRes" name="telRes" class="mf"/>
            <span id="msg_telRes" class="field_desc">Telefone Residencial</span>
            <span class="validate_success telRes_success" style="display: none;" >Ok</span>
            <span class="validate_error telRes_error" style="display: none;">Favor informar Tel.Res.!</span>
        </p>
        <p>
            <label>Tel. Cel:</label>
            <input type="text" id="telCel" name="telCel" class="mf" />
            <span id="msg_telCel" class="field_desc">Telefone Celular</span>
            <span class="validate_success telCel_success" style="display: none;" >Ok</span>
            <span class="validate_error telCel_error" style="display: none;">Favor informar Tel.Cel.!</span>
        </p>
        <p>
            <label>Data de Nascimento:</label>
            <input type="text" id="dataNasc" name="dataNasc" class="mf" /> 
            <span id="msg_dataNasc" class="field_desc">Data de Nascimento</span>
            <span class="validate_success dataNasc_success" style="display: none;" >Ok</span>
            <span class="validate_error dataNasc_error" style="display: none;">Favor informar Data de Nascimento!</span>
        </p>
    </fieldset>
    <fieldset>
        <legend>Endereço</legend>
        <p>
            <label>Logradouro:</label>
            <input type="text" id="logradouro" name="logradouro" class="mf"/>
            <span id="msg_logradouro" class="field_desc">Logradouro do Endereço</span>
            <span class="validate_success logradouro_success" style="display: none;" >Ok</span>
            <span class="validate_error logradouro_error" style="display: none;">Favor informar Logradouro!</span>
        </p>
        <p>
            <label>Número:</label>
            <input type="text" id="numero" name="numero" class="mf"/>
            <span id="msg_numero" class="field_desc">Número do Endereço</span>
            <span class="validate_success numero_success" style="display: none;" >Ok</span>
            <span class="validate_error numero_error" style="display: none;">Favor informar Número!</span>
        </p>            
        <p>
            <label>Bairro:</label>
            <input type="text" id="bairro" name="bairro" class="mf"/>
            <span id="msg_bairro" class="field_desc">Bairro do Endereço</span>
            <span class="validate_success bairro_success" style="display: none;" >Ok</span>
            <span class="validate_error bairro_error" style="display: none;">Favor informar Número!</span>
        </p>            
        <p>
            <label>Cidade:</label>
            <input type="text" id="cidade" name="cidade" class="mf"/>
            <span id="msg_cidade" class="field_desc">Cidade do Endereço</span>
            <span class="validate_success cidade_success" style="display: none;" >Ok</span>
            <span class="validate_error cidade_error" style="display: none;">Favor informar Cidade!</span>
        </p>
        <p>
            <label>UF:</label>
            <select id="uf" name="uf">
                <option value="AC">Acre</option>
                <option value="AL">Alagoas</option>
                <option value="AP">Amapá</option>
                <option value="AM">Amazonas</option>
                <option value="BA">Bahia</option>
                <option value="CE">Ceará</option>
                <option value="DF">Distrito Federal</option>
                <option value="ES">Espírito Santo</option>
                <option value="GO">Goiás</option>
                <option value="MA">Maranhão</option>
                <option value="MT">Mato Grosso</option>
                <option value="MS">Mato Grosso do Sul</option>
                <option value="MG">Minas Gerais</option>
                <option value="PR">Paraná</option>
                <option value="PB">Paraíba</option>
                <option value="PA">Pará</option>
                <option value="PE">Pernambuco</option>
                <option value="PI">Piauí</option>
                <option value="RJ">Rio de Janeiro</option>
                <option value="RN">Rio Grande do Norte</option>
                <option value="RS">Rio Grande do Sul</option>
                <option value="RO">Rondônia</option>
                <option value="RR">Roraima</option>
                <option value="SC">Santa Catarina</option>
                <option value="SE">Sergipe</option>
                <option value="SP">São Paulo</option>
                <option value="TO">Tocantins</option>
            </select>
            <span class="field_desc">UF do Endereço</span>
        </p>
        <p>
            <label>CEP:</label>
            <input type="text" id="cep" name="cep" class="mf"/>
            <span id="msg_cep" class="field_desc">CEP do Endereço</span>
            <span class="validate_success cep_success" style="display: none;" >Ok</span>
            <span class="validate_error cep_error" style="display: none;">Favor informar Cep!</span>
        </p>    
        <p>
            <input class="button" type="submit" value="Salvar" />
            <input class="button" type="reset" value="Limpar" />
        </p>
    </fieldset>
</form>