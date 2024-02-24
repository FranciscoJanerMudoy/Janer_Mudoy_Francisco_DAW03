<%@ page import="model.Producte" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tabla de Productos</title>
    <link rel="stylesheet" href="./css/bootstrap.css">
</head>
<body>

<div class="container mt-5">
    <table class="table table-bordered">
        <thead class="thead-dark">
        <tr>
            <th>Nom</th>
            <th>Preu</th>
            <th>Descripció</th>
            <th>Categoría</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (Producte producte : (List<Producte>) request.getAttribute("productes")) {
        %>
        <tr>
            <td><%= producte.getNom() %></td>
            <td><%= producte.getPreu() %></td>
            <td><%= producte.getDescripcio() %></td>
            <td><%= producte.getCategoria() %></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>

</body>
</html>
