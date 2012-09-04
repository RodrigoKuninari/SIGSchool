<h2>Lista de Responsáveis</h2>
<form method="post" id="frm-filtro">
    <p>
        <label for="pesquisar">Pesquisar</label>
        <input type="text" id="pesquisar" name="pesquisar" size="30" />
    </p>
</form>
<p>
    <a href="${pageContext.request.contextPath}/responsavel_Form_cadastrar" style="text-decoration:none" >
        <input class="button" type="submit" value="Cadastrar Responsável" />
    </a>
</p>
<c:choose>
    <c:when test="${empty lstresponsaveis}">
        <p>- N&atilde;o h&aacute; contatos registrados </p>
    </c:when>
    <c:otherwise>
        <table class="normal tablesorter">
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Rg</th>
                    <th>Cpf</th>
                    <th>Sexo</th>
                    <th>Email</th>
                    <th>Tel.Res.</th>
                    <th>Tel.Cel.</th>
                    <th>Opções</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="responsavel" items="${requestScope.lstresponsaveis}">
                <tr class="odd">
                    <td>${responsavel.nome}</td>
                    <td>${responsavel.rg}</td>
                    <td>${responsavel.cpf}</td>
                <c:choose> 
                    <c:when test="${responsavel.sexo=='M'}" > 
                        <td>Masculino</td>
                    </c:when> 
                    <c:when test="${responsavel.sexo=='F'}" > 
                        <td>Feminino</td>
                    </c:when> 
                    <c:otherwise> 
                        <td></td>
                    </c:otherwise> 
                </c:choose>  

                <td>${responsavel.email}</td>
                <td>${responsavel.telRes}</td>
                <td>${responsavel.telCel}</td>
                <td>
                    <a href="#" title="Editar Responsável" class="tooltip table_icon"><img src="./assets/icons/actions_small/pencil.png" alt="" /></a> 
<!--                    <a href="#" title="Preferences" class="tooltip table_icon"><img src="./assets/icons/actions_small/preferences.png" alt="" /></a>-->
                    <a href="#" title="Deletar Responsável" class="tooltip table_icon"><img src="./assets/icons/actions_small/trash.png" alt="" /></a>
                </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>

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