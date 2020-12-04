<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<t:layout>
	<jsp:attribute name="title">Ajouter un produit</jsp:attribute>
	<jsp:body>
		${ demo }
		<c:if test="${ errors != null }">
			<div class="alert alert-danger" role="alert">
				Des erreurs lors de la saisie :
				<ul>
					<c:forEach var="error" items="${ errors }">
						<li>
							<c:if test="${ error == 'label' }">Le libellé est obligatoire.</c:if>
							<c:if test="${ error == 'price' }">Le prix doit être supérieur à 0.</c:if>
							<c:if test="${ error == 'createdOn' }">La date doit être saisie.</c:if>
						</li>
					</c:forEach>
				</ul>
			</div>
		</c:if>

		<form method="POST">
			<div class="card">
				<div class="card-body">
					<div class="form-group row">
						<label for="label" class="col-sm-2 col-form-label">Libellé</label>
						<div class="col-sm-10">
							<input type="text" id="label" name="label" class="form-control" value="${ produit.label }" />
						</div>
					</div>
					
					<div class="form-group row">
						<label for="price" class="col-sm-2 col-form-label">Prix</label>
						<div class="col-sm-10">
							<input type="number" id="price" name="price" class="form-control" value="${ produit.price }" />
						</div>
					</div>
					
					<div class="form-group row">
						<label for="createdOn" class="col-sm-2 col-form-label">Date de création</label>
						<div class="col-sm-10">
							<input type="date" id="createdOn" name="createdOn" class="form-control" value="${ produit.createdOn }" />
						</div>
					</div>
				</div>
				
				<div class="card-footer">
					<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }" />
					<input type="submit" class="btn btn-success" value="Ajouter" />
					<a class="btn btn-danger" href="produit">Annuler</a>
				</div>
			</div>
		</form>
	</jsp:body>
</t:layout>