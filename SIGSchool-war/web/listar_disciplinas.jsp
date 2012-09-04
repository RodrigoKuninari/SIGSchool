<h2>Lista de Disciplinas</h2>
<c:choose>
    <c:when test="${empty lstdisciplinas}">
        <p>- N&atilde;o h&aacute; disciplinas registradas </p>
    </c:when>
    <c:otherwise>
        <table class="normal tablesorter">
            <thead>
                <tr>
                    <th>Select</th>
                    <th>Nome</th>
                    <th>Opções</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="disciplina" items="${requestScope.lstdisciplinas}">
                <tr class="odd">
                    <td><input type="checkbox" class="iphone" /></td>
                    <td>${disciplina.nome}</td>
                <td>
                    <a href="#" title="Editar Disciplina" class="tooltip table_icon"><img src="./assets/icons/actions_small/pencil.png" alt="" /></a> 
<!--                    <a href="#" title="Preferences" class="tooltip table_icon"><img src="./assets/icons/actions_small/preferences.png" alt="" /></a>-->
                    <a href="#" title="Deletar Disciplina" class="tooltip table_icon"><img src="./assets/icons/actions_small/trash.png" alt="" /></a>
                </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>
