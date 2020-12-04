<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<t:layout>
	<jsp:attribute name="title">Se connecter</jsp:attribute>
	<jsp:body>
		<form method="POST" action="process_connexion">
			<div class="card">
				<div class="card-body">
					<div class="form-group row">
						<label for="username" class="col-sm-2 col-form-label">Nom d'utilisateur</label>
						<div class="col-sm-10">
							<input type="text" id="username" name="username" class="form-control" />
						</div>
					</div>
					
					<div class="form-group row">
						<label for="password" class="col-sm-2 col-form-label">Mot de passe</label>
						<div class="col-sm-10">
							<input type="password" id="password" name="password" class="form-control" />
						</div>
					</div>
				</div>
				
				<div class="card-footer">
					<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }" />
					<input type="submit" class="btn btn-success" value="Se connecter" />
				</div>
			</div>
		</form>
	</jsp:body>
</t:layout>