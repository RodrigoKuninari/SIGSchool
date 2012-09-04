<h2>Lista de Professores</h2>
<form method="post" id="frm-filtro">
    <p>
        <label for="pesquisar">Pesquisar</label>
        <input type="text" id="pesquisar" name="pesquisar" size="30" />
    </p>
</form>
<p>
    <a href="${pageContext.request.contextPath}/professor_Form_cadastrar" style="text-decoration:none" >
        <input class="button" type="submit" value="Cadastrar Professor" />
    </a>
</p>
<table class="normal tablesorter" summary="Tabela de dados fictícios">
    <thead>
        <tr>
            <th>Nome</th>
            <th>Rg</th>
            <th>Cpf</th>
            <!--<th>Foto</th>-->
            <th>Sexo</th>
            <th>Email</th>
            <th>Tel.Res.</th>
            <th>Tel.Cel.</th>
            <th>Opções</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="professor" items="${requestScope.lstprofessores}">
        <c:if test="${professor.ativo}">
            <tr class="odd">
                <td>${professor.nome}</td>
                <td>${professor.rg}</td>
                <td>${professor.cpf}</td>
                <!--<td><img src="./assets/avatar.png" alt="" /></td>-->

            <c:choose> 
                <c:when test="${professor.sexo=='M'}" > 
                    <td>Masculino</td>
                </c:when> 
                <c:when test="${professor.sexo=='F'}" > 
                    <td>Feminino</td>
                </c:when> 
                <c:otherwise> 
                    <td></td>
                </c:otherwise> 
            </c:choose>  

            <td>${professor.email}</td>
            <td>${professor.telRes}</td>
            <td>${professor.telCel}</td>
            <td>
                <a href="${pageContext.request.contextPath}/professor_Form_editar?id_professor=${professor.id}" title="Editar/Visualizar" class="tooltip table_icon">
                    <img src="./assets/icons/actions_small/pencil.png" alt="" />
                </a> 
                <!--<a href="#" title="Visualizar" class="tooltip table_icon"><img src="img/edit.png" alt="" /></a>-->
                <a href="${pageContext.request.contextPath}/professor_Desativar_professor?id_professor=${professor.id}" title="Desativar Professor" class="tooltip table_icon"><img src="./assets/icons/actions_small/trash.png" alt="" /></a>
            </td>
            </tr>
        </c:if>
    </c:forEach>
</tbody>
</table>

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
