<h1>Ajouter un produit</h1>

${ errors }

<form method="POST">
	<input type="text" name="label" />
	<span th:errors="${produit.label}"></span>
	<span>${ labelError }</span>
	<input type="number" name="price" />
	<input type="date" name="createdOn" />
	
	<input type="submit" value="Ajouter" />
</form>