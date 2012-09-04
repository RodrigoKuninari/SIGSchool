<%--
    Material utilizado para as aulas práticas das disciplinas da Faculdade de
Computação da Universidade Federal de Mato Grosso do Sul (FACOM / UFMS).
Seu uso é permitido para fins apenas acadêmicos, todavia mantendo a
referência de autoria.
    Created on : 06/10/2010
    Author     : Profª Jane Eleutério
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EJB 3</title>

    </head>
    <body>
        <h1>Exemplo de uso de componentes JB3</h1>
        <p>Esse exemplo usa injeção de dependência para que o servlet acesse o
            um SessionBean Stateless</p>
        <h2> Nome digitado (em maíusculas):</h2>
        <p>${texto}</p>
        <p><a href="${pageContext.request.contextPath}/professor_Inicio">Inicio</a></p>
    </body>
</html>
