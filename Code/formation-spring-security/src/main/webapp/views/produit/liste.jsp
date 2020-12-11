<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<t:layout>
	<jsp:attribute name="title">Liste des produits</jsp:attribute>
	<jsp:body>
		${ demo }
		
		<sec:authorize access="hasPermission('produit', 'write')">
			<a class="btn btn-primary" href="produit/ajouter">Ajouter un produit</a>
		</sec:authorize>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Libell�</th>
					<th>Prix</th>
					<th>Date de cr�ation</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="produit" items="${ produits }">
					<tr>
						<td>${ produit.label }</td>
						<td>${ produit.price }</td>
						<td>${ produit.createdOn }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</jsp:body>
</t:layout>