<div class="panel panel-primary">
    <div class="panel-heading">
        <div class="clearfix">
            <h4 class="panel-title titulo-painel">Ranking dos Restaurantes</h4>
        </div>
    </div>
    <div class="container-fluid">
        <h2>
            <c:if test="${message!=null}">
                <font color="red">${message }</font>
            </c:if>
        </h2>
        <div class="row jumbotron" id="page-wrap">
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-heading">Votos Gerais</div>

                    <table class="table">
                        <tr>
                            <th>Votos</th>
                            <th>Restaurante</th>
                        </tr>
                        <c:forEach items="${restaurants}" var="poll">
                            <tr>
                                <th>${poll.count}</th>
                                <th>${poll.restaurant.name}</th>
                            </tr>
                        </c:forEach>

                    </table>
                </div>
            </div>


            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-heading">Votos Por Usu&aacute;rio</div>

                    <table class="table">
                        <tr>
                            <th>Votos</th>
                            <th>Usu&aacute;rio</th>
                            <th>Restaurante</th>
                        </tr>
                        <c:forEach items="${restaurantsByUser}" var="users">
                            <tr>
                                <th>${users.count}</th>
                                <th>${users.user.name}</th>
                                <th>${users.restaurant.name}</th>
                            </tr>
                        </c:forEach>

                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<b><a href=${pageContext.request.contextPath}/vote-no-restaurante/poll/list>Refazer vota&ccedil;&atilde;o</a></b>