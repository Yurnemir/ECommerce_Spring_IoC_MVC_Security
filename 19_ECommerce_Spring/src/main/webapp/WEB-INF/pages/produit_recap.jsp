<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Recapitulatif Produits</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<h2>
		<a href="${pageContext.request.contextPath}/accueil">accueil</a>
	</h2>
	<br />
	<h1>Recapitulatif Produits</h1>

<h1>Recapitulatif Produits</h1>
	<table class="table table-bordered">
		<tr>
			<th>ID</th>
			<th>D�signation</th>
			<th>Description</th>
			<th>Prix</th>
			<th>Quantit�</th>
			<th>Image</th>
			<th>Operation</th>
		</tr>
		<c:forEach var="produit" items="${listeProduit}">
			<tr>
				<th>${produit.idProduit}</th>
				<th>${produit.designation}</th>
				<th>${produit.description}</th>
				<th>${produit.prix}</th>
				<th>${produit.quantite}</th>
				<th>Placeholder</th>
				<td><a href="${pageContext.request.contextPath}/admin/produit/supprViaLien/${produit.idProduit}">Supprimer</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>