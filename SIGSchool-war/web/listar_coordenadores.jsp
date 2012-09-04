<h2>Lista de Coordenadores</h2>
<form method="post" id="frm-filtro">
    <p>
        <label for="pesquisar">Pesquisar</label>
        <input type="text" id="pesquisar" name="pesquisar" size="30" />
    </p>
</form>
<p>
    <a href="${pageContext.request.contextPath}/coordenador_Form_cadastrar" style="text-decoration:none" >
        <input class="button" type="submit" value="Cadastrar Coordenador" />
    </a>
</p>
<c:choose>
    <c:when test="${empty lstcoordenadores}">
        <p>- N&atilde;o h&aacute; contatos registrados </p>
    </c:when>
    <c:otherwise>
        <table class="normal tablesorter" >
            <thead>
                <tr>
                    <th>Matrícula</th>
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
            <c:forEach var="coordenador" items="${requestScope.lstcoordenadores}">
                <tr class="odd">
                    <td>${coordenador.matricula}</td>
                    <td>${coordenador.nome}</td>
                    <td>${coordenador.rg}</td>
                    <td>${coordenador.cpf}</td>
                    
                <c:choose> 
                    <c:when test="${coordenador.sexo=='M'}" > 
                        <td>Masculino</td>
                    </c:when> 
                    <c:when test="${coordenador.sexo=='F'}" > 
                        <td>Feminino</td>
                    </c:when> 
                    <c:otherwise> 
                        <td></td>
                    </c:otherwise> 
                </c:choose>  

                <td>${coordenador.email}</td>
                <td>${coordenador.telRes}</td>
                <td>${coordenador.telCel}</td>
                <td>
                    <a href="#" title="Editar Coordenador" class="tooltip table_icon"><img src="./assets/icons/actions_small/pencil.png" alt="" /></a> 
<!--                    <a href="#" title="Preferences" class="tooltip table_icon"><img src="./assets/icons/actions_small/preferences.png" alt="" /></a>-->
                    <a href="#" title="Deletar Coordenador" class="tooltip table_icon"><img src="./assets/icons/actions_small/trash.png" alt="" /></a>
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