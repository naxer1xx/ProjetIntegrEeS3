<%@page import="beans.ClientBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>affichage</title>
</head>

<style>
.table {
	margin-top: 20%;
	text-align: center;
	margin-left : auto;
	margin-right: auto;
}
</style>

<body>



	<div class="container">
		<div class="table-responsive-sm">
			<table class="table table-dark bordred table-hover">
				<thead>
					<tr>
						<th scope="col">Nom</th>
						<th scope="col">Prenom</th>
						<th scope="col">Email</th>
						<th scope="col">Ville</th>
						<th scope="col">Adresse</th>
						<th scope="col">modifier</th>
						<th scope="col">supprimer</th>


					</tr>
				</thead>
				<tbody>

					<c:forEach items="${clients}" var="client">

						<tr>
							<td>${client.getNom()}</td>


							<td>${client.getPrenom()}</td>



							<td>${client.getEmail()}</td>



							<td>${client.getVille()}</td>



							<td>${client.getAdresse()}</td>



							<td><a href="#"><img alt=""
									src="images/icons/pen.svg" width="25px" height="25px"></a></td>


							<td><a href="hello?choice=supprimer&idC=${client.getId()}"><img alt=""
									src="images/icons/trash-fill.svg" width="25px" height="25px"></a></td>

						</tr>




					</c:forEach>


				</tbody>
			</table>
		</div>
	</div>

</body>
</html>