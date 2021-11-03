<%@page import="java.util.*" %>
<%@page import="dao.Gestiondb,model.Etudiant" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste</title>
</head>
<body>
<table>
<tr>
<th>prenom</th>
<th>nom</th>
<th>numtel</th>
<th>action</th>
</tr>
<%
 Gestiondb gdb= new Gestiondb ();
List<Etudiant> list=gdb.getAllEtudiants() ;
for(Etudiant e:list){
%>
<tr>
<td><%=e.getPrenom() %></td>
<td><%=e.getNom() %></td>
<td><%=e.getTel() %></td>
<td><a href='controller.Supprimer?num=<%=e.getNum() %>'>Supprimer</a></td>
</tr>
<%
}
%>
</table>
<h1> Ajouter un etudiant </h1>

<form action="Ajouter" method="get">
<label> nom </label> <input type="text" class=form-control" name="nom">
<label> prenom </label> <input type="text" class=form-control" name="prenom">
<label> num</label> <input type="number" class=form-control" name="num">
<label> tel </label> <input type="tel" class=form-control" name="tel">
<input type ="submit" value="Ajouter">
</form>
</body>
</html>