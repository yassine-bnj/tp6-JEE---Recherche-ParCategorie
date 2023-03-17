<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
<div class="container">
<div class="card">
<div class="card-header">
Recherche des Produits
</div>
<div class="card-body">
<form action="chercher_cat.do" method="get">
<label>categories</label>


<select name="cat">

<c:forEach items="${model1.categories}" var="c">

<c:if test="${c.idCat == idC}">
<option value="${c.idCat }" selected>${c.nomCat}</option>
</c:if>
<c:if test="${c.idCat != idC}">
<option value="${c.idCat }">${c.nomCat } </option>
</c:if>


</c:forEach>
</select>

<button type="submit" class="btn btn-primary">Chercher</button>
</form>
<table class="table table-striped">
<tr>
<th>ID</th><th>Nom Produit</th><th>Prix</th><th>Cat�gorie</th>
</tr>


<c:forEach items="${model.produits}" var="p">
<tr>
<td>${p.idProduit }</td>
<td>${p.nomProduit }</td>
<td>${p.prix }</td>
<td>${p.categorie.nomCat }</td>
<td><a onclick="return confirm('Etes-vous s�r ?')"
href="supprimer.do?id=${p.idProduit }">Supprimer</a></td>
<td><a href="editer.do?id=${p.idProduit }">Edit</a></td>
</tr>
</c:forEach>
</table>
</div>
</div>
</div>
</body>
</html>