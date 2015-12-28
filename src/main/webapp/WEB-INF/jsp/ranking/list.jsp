	<div class="panel panel-primary">
		<div class="panel-heading">
			<div class="clearfix">
				<h4 class="panel-title titulo-painel">Ranking dos Restaurantes</h4>
			</div>
		</div>

		<div class="panel-body">
			<div id="page-wrap" class="container-fluid">
				<c:forEach items="${restaurants}" var="ranking">
					<div class="row vertical-center-row">
						<div class="text-center col-md-1 col-md-offset-1">
							<div class="thumbnail">
								<img src="/vote-no-restaurante/img/${ranking.restaurant.id}.jpg"
									alt="...">
							</div>
						</div>

						<div class="caption">
							<p>Número de votos - ${ranking.count }</p>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>