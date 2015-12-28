
<form method="post" id="formAction" action="poll/save">


	<div class="panel panel-primary">
		<div class="panel-heading">
			<div class="clearfix">
				<h1 class="panel-title titulo-painel">Vote No Restaurante</h1>
			</div>
		</div>

		<div class="panel-body">
			<c:forEach items="${restaurants}" var="restaurant">
				<div class="container-fluid container-table">
					<div id="page-wrap" class="jumbotron" id="options">
						<div class="row vertical-center-row">
							<div class="text-center col-md-3 col-md-offset-3">
								<div class="thumbnail">
									<img src="/vote-no-restaurante/img/${restaurant.id}.jpg"
										alt="...">
								</div>
							</div>
							<div class="caption">
								<h4>${restaurant.name } - ${restaurant.category }</h4>
								<p>
									<a href="/vote-no-restaurante/poll/save?id=${restaurant.id }"
										class="btn btn-primary btn-sm" role="button">Votar</a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</form>
