<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ajouter</title>

<style type="text/css">

	.resize{
		
		width : 60%;
		margin-top  : 10%;
	}

</style>

</head>
<body>


<div class="resize shadow-lg p-3 mb-5 bg-white rounded">
<form class="row g-3" method="POST" action="hello?insert=OK">
  <div class="col-md-6">
    <label for="inputEmail4" class="form-label">Nom</label>
    <input type="text"  name = "nom" class="form-control" id="inputEmail4">
  </div>
  <div class="col-md-6">
    <label for="inputPassword4" class="form-label">Prenom</label>
    <input type="text" name = "prenom" class="form-control" id="inputPassword4">
  </div>
  <div class="col-12">
    <label for="inputAddress" class="form-label">Email</label>
    <input type="email" class="form-control" name= "email" id="inputAddress" placeholder="">
  </div>
  <div class="col-12">
    <label for="inputAddress2" class="form-label">Ville</label>
    <input type="text" class="form-control"  name = "ville"  id="inputAddress2" placeholder="">
  </div>
  <div class="col-12">
    <label for="inputCity" class="form-label">Adresse</label>
    <input type="text" class="form-control" name= "adresse" id="inputCity">
  </div>



  <div class="col-12">
    <button type="submit" class="btn btn-primary">Sign in</button>
  </div>
</form>

</div>


</body>
</html>