
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import ="web.CreditModel" %>
<%
    CreditModel mod= (CreditModel)request.getAttribute("mod");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Simulateiur credit</title>
    <link rel="stylesheet" type="text/css" href="<%request.getContextPath();%>/css/style.css"/>
</head>
<body>
<div>
    <form action="controleur" method="post">
        <table>
            <tr>
                <td>Montant:</td>
                <td><input type="text" name="montant" value="<%=mod.getMontant()%>"></td>
                <td>DH</td>
            </tr>
            <tr>
                <td>Durée:</td>
                <td><input type="text" name="duree" value="<%=mod.getDuree()%>"></td>
                <td>Mois</td>
            </tr>
            <tr>
                <td>taux:</td>
                <td><input type="text" name="taux" value="<%=mod.getTaux()%>"></td>
                <td>%</td>
            </tr>
            <tr>
                <td><input type="submit" value="Calculer"></td>
            </tr>
        </table>

    </form>
</div>
<div>
    <table>
        <tr>
            <td>Mensualité: </td>
            <td>
                <%=mod.getMensualite() %>
            </td>
            <td>DH</td>
        </tr>
    </table>
</div>

</body>
</html>