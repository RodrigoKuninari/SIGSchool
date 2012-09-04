<form id ="form_editar_professor" action="${pageContext.request.contextPath}/professor_Editar_professor" onsubmit="return valida_form(this);" >
    <fieldset>
        <legend>Editar Professor</legend>
        <!--Cadastrar Professor-->
        <c:if test="${status}">
            <p><span class="validate_success">${mensagem_retorno}</span></p>
        </c:if>
        <p>
            <label>Matrícula:</label>
            <input type="hidden" id="id_professor" name="id_professor" class="mf" value="${id_professor}" />
            <input type="text" id="matricula" name="matricula" class="mf" value="${matricula}" />
            <span id="msg_matricula" class="field_desc">Matrícula do Professor</span>
            <span class="validate_success matricula_success" style="display: none;" >Ok</span>
            <span class="validate_error matricula_error" style="display: none;">Favor informar matrícula!</span>
        </p>
        <p>
            <label>Nome:</label>
            <input type="text" id="nome" name="nome" class="mf" value="${nome}" />
            <span id="msg_nome" class="field_desc">Nome do Professor</span>
            <span class="validate_success nome_success" style="display: none;" >Ok</span>
            <span class="validate_error nome_error" style="display: none;">Favor informar nome!</span>
        </p>
        <p>
            <label>CPF:</label>
            <input type="text" id="cpf" name="cpf" class="mf" value="${cpf}" />
            <span id="msg_cpf" class="field_desc">CPF</span>
            <span class="validate_success cpf_success" style="display: none;" >Ok</span>
            <span class="validate_error cpf_error" style="display: none;">Favor informar Cpf!</span>
        </p>
        <p>
            <label>RG:</label>
            <input type="text" id="rg" name="rg" class="mf" value="${rg}" />
            <span id="msg_rg" class="field_desc">RG</span>
            <span class="validate_success rg_success" style="display: none;" >Ok</span>
            <span class="validate_error rg_error" style="display: none;">Favor informar Rg!</span>
        </p>
        <p>
            <label>Sexo:</label>
            <select id="sexo" name="sexo">
                <option value="M" <c:if test="${sexo=='M'}" >selected</c:if> >Masculino</option>
                <option value="F" <c:if test="${sexo=='F'}" >selected</c:if> >Feminino</option>
            </select>
            <span id="msg_sexo" class="field_desc" >Masculino/Feminino</span>
            <span class="validate_success sexo_success" style="display: none;" >Ok</span>
            <span class="validate_error sexo_error" style="display: none;">Favor informar Sexo!</span>
        </p>
        <p>
            <label>E-mail:</label>
            <input type="text" id="email" name="email" class="mf" value="${email}" />
            <span id="msg_email" class="field_desc">Email do Professor</span>
            <span class="validate_success email_success" style="display: none;" >Ok</span>
            <span class="validate_error email_error" style="display: none;">Favor informar Email!</span>
        </p>
        <p>
            <label>Tel. Res:</label>
            <input type="text" id="telRes" name="telRes" class="mf" value="${telRes}" />
            <span id="msg_telRes" class="field_desc">Telefone Residencial</span>
            <span class="validate_success telRes_success" style="display: none;" >Ok</span>
            <span class="validate_error telRes_error" style="display: none;">Favor informar Tel.Res.!</span>
        </p>
        <p>
            <label>Tel. Cel:</label>
            <input type="text" id="telCel" name="telCel" class="mf" value="${telCel}"/>
            <span id="msg_telCel" class="field_desc">Telefone Celular</span>
            <span class="validate_success telCel_success" style="display: none;" >Ok</span>
            <span class="validate_error telCel_error" style="display: none;">Favor informar Tel.Cel.!</span>
        </p>
        <p>
            <label>Data de Nascimento:</label>
            <input type="text" id="dataNasc" name="dataNasc" value="${dataNasc}" class="mf" />
            <span id="msg_dataNasc" class="field_desc">Data de Nascimento</span>
            <span class="validate_success dataNasc_success" style="display: none;" >Ok</span>
            <span class="validate_error dataNasc_error" style="display: none;">Favor informar Data de Nascimento!</span>
        </p>
    </fieldset>
    <fieldset>
        <legend>Endereço</legend>
        <p>
            <label>Logradouro:</label>
            
            <!--Id do endereco oculto-->
            <input type="hidden" id="id_endereco" name="id_endereco" value="${id_endereco}"/>
            
            <input type="text" id="logradouro" name="logradouro" class="mf" value="${logradouro}"/>
            <span id="msg_logradouro" class="field_desc">Logradouro do Endereço</span>
            <span class="validate_success logradouro_success" style="display: none;" >Ok</span>
            <span class="validate_error logradouro_error" style="display: none;">Favor informar Logradouro!</span>
        </p>
        <p>
            <label>Número:</label>
            <input type="text" id="numero" name="numero" class="mf" value="${numero}" />
            <span id="msg_numero" class="field_desc">Número do Endereço</span>
            <span class="validate_success numero_success" style="display: none;" >Ok</span>
            <span class="validate_error numero_error" style="display: none;">Favor informar Número!</span>
        </p>            
        <p>
            <label>Bairro:</label>
            <input type="text" id="bairro" name="bairro" class="mf" value="${bairro}" />
            <span id="msg_bairro" class="field_desc">Bairro do Endereço</span>
            <span class="validate_success bairro_success" style="display: none;" >Ok</span>
            <span class="validate_error bairro_error" style="display: none;">Favor informar Número!</span>
        </p>            
        <p>
            <label>Cidade:</label>
            <input type="text" id="cidade" name="cidade" class="mf" value="${cidade}" />
            <span id="msg_cidade" class="field_desc">Cidade do Endereço</span>
            <span class="validate_success cidade_success" style="display: none;" >Ok</span>
            <span class="validate_error cidade_error" style="display: none;">Favor informar Cidade!</span>
        </p>
        <p>
            <label>UF:</label>
            <select id="uf" name="uf">
                <option value=""></option>
                <option value="AC" <c:if test="${uf=='AC'}">selected</c:if> >Acre</option>
                <option value="AL" <c:if test="${uf=='Al'}">selected</c:if> >Alagoas</option>
                <option value="AP" <c:if test="${uf=='AP'}">selected</c:if> >Amapá</option>
                <option value="AM" <c:if test="${uf=='AM'}">selected</c:if>>Amazonas</option>
                <option value="BA" <c:if test="${uf=='BA'}">selected</c:if>>Bahia</option>
                <option value="CE" <c:if test="${uf=='CE'}">selected</c:if>>Ceará</option>
                <option value="DF" <c:if test="${uf=='DF'}">selected</c:if>>Distrito Federal</option>
                <option value="ES" <c:if test="${uf=='ES'}">selected</c:if>>Espírito Santo</option>
                <option value="GO" <c:if test="${uf=='GO'}">selected</c:if>>Goiás</option>
                <option value="MA" <c:if test="${uf=='MA'}">selected</c:if>>Maranhão</option>
                <option value="MT" <c:if test="${uf=='MT'}">selected</c:if>>Mato Grosso</option>
                <option value="MS" <c:if test="${uf=='MS'}">selected</c:if>>Mato Grosso do Sul</option>
                <option value="MG" <c:if test="${uf=='MG'}">selected</c:if>>Minas Gerais</option>
                <option value="PR" <c:if test="${uf=='PR'}">selected</c:if>>Paraná</option>
                <option value="PB" <c:if test="${uf=='PB'}">selected</c:if>>Paraíba</option>
                <option value="PA" <c:if test="${uf=='PA'}">selected</c:if>>Pará</option>
                <option value="PE" <c:if test="${uf=='PE'}">selected</c:if>>Pernambuco</option>
                <option value="PI" <c:if test="${uf=='PI'}">selected</c:if>>Piauí</option>
                <option value="RJ" <c:if test="${uf=='RJ'}">selected</c:if>>Rio de Janeiro</option>
                <option value="RN" <c:if test="${uf=='RN'}">selected</c:if>>Rio Grande do Norte</option>
                <option value="RS" <c:if test="${uf=='RS'}">selected</c:if>>Rio Grande do Sul</option>
                <option value="RO" <c:if test="${uf=='RO'}">selected</c:if>>Rondônia</option>
                <option value="RR" <c:if test="${uf=='RR'}">selected</c:if>>Roraima</option>
                <option value="SC" <c:if test="${uf=='SC'}">selected</c:if>>Santa Catarina</option>
                <option value="SE" <c:if test="${uf=='SE'}">selected</c:if>>Sergipe</option>
                <option value="SP" <c:if test="${uf=='SP'}">selected</c:if>>São Paulo</option>
                <option value="TO" <c:if test="${uf=='TO'}">selected</c:if>>Tocantins</option>
            </select>
            <span class="field_desc">UF do Endereço</span>
        </p>
        <p>
            <label>CEP:</label>
            <input type="text" id="cep" name="cep" class="mf" value="${cep}"/>
            <span id="msg_cep" class="field_desc">CEP do Endereço</span>
            <span class="validate_success cep_success" style="display: none;" >Ok</span>
            <span class="validate_error cep_error" style="display: none;">Favor informar Cep!</span>
        </p>    
        <p>
            <input class="button" type="submit" value="Alterar" />
        </p>
    </fieldset>
</form>