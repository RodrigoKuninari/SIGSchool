<h2>Lista de Alunos</h2>
<form method="post" id="frm-filtro">
    <p>
        <label for="pesquisar">Pesquisar</label>
        <input type="text" id="pesquisar" name="pesquisar" size="30" />
    </p>
</form>
<p>
    <a href="${pageContext.request.contextPath}/aluno_Form_cadastrar" style="text-decoration:none" >
        <input class="button" type="submit" value="Cadastrar Aluno" />
    </a>
</p>
<c:choose>
    <c:when test="${empty lstalunos}">
        <p>- N&atilde;o h&aacute; contatos registrados </p>
    </c:when>
    <c:otherwise>
        <table class="normal tablesorter">
            <thead>
                <tr>
                    <th>Select</th>
                    <th>Matrícula</th>
                    <th>Nome</th>
                    <th>Sexo</th>
                    <th>Email</th>
                    <th>Tel.Res.</th>
                    <th>Tel.Cel.</th>
                    <th>Responsável</th>
                    <th>Opções</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="aluno" items="${requestScope.lstalunos}">
                <tr class="odd">
                    <td><input type="checkbox" class="iphone" /></td>
                    <td>${aluno.matricula}</td>
                    <td>${aluno.nome}</td>
                    
                <c:choose> 
                    <c:when test="${aluno.sexo=='M'}" > 
                        <td>Masculino</td>
                    </c:when> 
                    <c:when test="${aluno.sexo=='F'}" > 
                        <td>Feminino</td>
                    </c:when> 
                    <c:otherwise> 
                        <td></td>
                    </c:otherwise> 
                </c:choose>  

                <td>${aluno.email}</td>
                <td>${aluno.telRes}</td>
                <td>${aluno.telCel}</td>
                <td>${aluno.responsavel.getNome()}</td>
                <td>
                    <a href="#" title="Editar Aluno" class="tooltip table_icon"><img src="./assets/icons/actions_small/pencil.png" alt="" /></a> 
<!--                    <a href="#" title="Preferences" class="tooltip table_icon"><img src="./assets/icons/actions_small/preferences.png" alt="" /></a>-->
                    <a href="#" title="Deletar Aluno" class="tooltip table_icon"><img src="./assets/icons/actions_small/trash.png" alt="" /></a>
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