<div class="panel panel-primary">
	<div class="panel-heading">
		<div class="clearfix">
			<h4 class="panel-title titulo-painel">Ranking dos Restaurantes</h4>
		</div>
	</div>

	<div>
		<form class="form-inline" name="user"
			action="${pageContext.request.contextPath}/vote-no-restaurante/user/save">

			<h2>
				<c:if test="${message!=null}">
					<font color="red">${message }</font>
				</c:if>
			</h2>


			<h4>Digite seu nome e e-mail voc&ecirc; ser&aacute;
				redirecionado para o ranking da vota&ccedil;&atilde;o...</h4>
			<br>
			<div class="container-fluid container-table">
				<div id="page-wrap" class="jumbotron" id="options">
					<div class="row vertical-center-row">
						<div class="form-group">
							<label for="name">Nome</label> <input type="text"
								class="form-control" id="name" name="user.name"
								placeholder="Seu Nome">
						</div>
						<div class="form-group">
							<label for="email">Email</label> <input type="email"
								class="form-control" id="email" name="user.email"
								placeholder="example@yahoo.com.br">
						</div>
						<button type="submit" class="btn btn-default" onClick="sendUser()">Enviar</button>
					</div>
				</div>
			</div>

		</form>
	</div>
</div>