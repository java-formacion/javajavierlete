<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>TiendaVirtual</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-1.12.4.min.js"></script>
<script>
$( document ).ready(function() {
    var heights = $(".partido").map(function() {
        return $(this).height();
    }).get(),

    maxHeight = Math.max.apply(null, heights);

    $(".partido").height(maxHeight);
});
</script>
<link rel="stylesheet" href="css/estilo.css">
</head>

<body class="container-fluid">
	
			<h1 class="text-center">Partidos de Copa</h1>
		
	<div class="row">
		<c:forEach var="partido" items="${partido}">
			<div class="col-sm-6 col-md-6 partido">
					<div class="card">
						<h3 class="card-img-top-left-center">${partido.getSScore()}</h3>
						<img class="card-img-top-left" src="${partido.getTeam1().getSCountryFlagLarge()}" alt="Card image cap"> 
						<img class="card-img-top-right" src="${partido.getTeam2().getSCountryFlagLarge()}" alt="Card image cap">

						<p class="card-text">Fecha del partido: ${partido.getDPlayDate()} </p>
							<p class="card-text">${partido.getTeam1().getSName()}
								${partido.getSScore()} ${partido.getTeam2().getSName()}</p>
							<h4 class="card-title">Goleadores</h4>
							<c:forEach var="goles" items="${partido.getGoals()}">
								<p class="card-text"><strong>${goles.getSPlayerName()}</strong> del equipo
									<strong>${goles.getSTeamName()}</strong> en el minuto <strong>${goles.getDGame()}</strong></p>
							</c:forEach>
					</div>
				
			</div>
		</c:forEach>
	</div>
</body>



</html>
