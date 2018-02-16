<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="eu.dataaccess.footballpool.TGameInfo"%>
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
			<div class="col-sm-6 col-md-6">
				<div class="row">
					<div class="col-sm-4 col-md-4">
						<h3 class="text-center">${partido.getTeam1().getSName()}</h3>
					</div>
					<div class="col-sm-4 col-md-4">
						<h2 class="text-center">VS</h2>
					</div>
					<div class="col-sm-4 col-md-4">
						<h3 class="text-center">${partido.getTeam2().getSName()}</h3>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-4 col-md-4">
						<img class="text-center" src="${partido.getTeam1().getSCountryFlagLarge()}" alt="Card image cap">
					</div>
					<div class="col-sm-4 col-md-4 ">
						<h1 class="text-center">${partido.getSScore()}</h1>
					</div>
					<div class="col-sm-4 col-md-4">
						<img class="text-center" src="${partido.getTeam2().getSCountryFlagLarge()}" alt="Card image cap">
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12 col-md-12">
						<h3 class="text-center">Horario del partido</h3>
						<p class="text-center">${partido.getDPlayDate()}</p>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6 col-md-6">
						<h3 class="text-center">Tarjetas amarillas</h3>
						<p class="text-center">${partido.getIYellowCards()}</p>
					</div>
					<div class="col-sm-6 col-md-6">
						<h3 class="text-center">Tarjetas rojas</h3>
						<p class="text-center">${partido.getIRedCards()}</p>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-4 col-md-4">
						<h4 class="text-center">Goleador</h4>
					</div>
					<div class="col-sm-4 col-md-4">
						<h4 class="text-center">Equipo</h4>
					</div>
					<div class="col-sm-4 col-md-4">
						<h4 class="text-center">Horario del gol</h4>
					</div>
				</div>
				<div class="row">
				<c:forEach var="goles" items="${partido.getGoals()}">
					<div class="col-sm-4 col-md-4">
						<p class="text-center">${goles.getSPlayerName()}</p>
					</div>
					<div class="col-sm-4 col-md-4">
						<p class="text-center">${goles.getSTeamName()}</p>
					</div>
					<div class="col-sm-4 col-md-4">
						<p class="text-center">${goles.getDGame()}</p>
					</div>
				</c:forEach>
				</div>
			</div>
		</c:forEach>
	</div>
	
	<div>
	
	</div>
</body>



</html>
