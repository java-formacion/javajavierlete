<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Informacion partidos eurocopa</title>

<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-1.12.4.min.js"></script>

</head>
<body>
<center>
<h1>PARTIDOS EUROCOPA</h1>
</center>
<br><br>
<div class="row">
<c:forEach var="partido" items="${partidos}">	

  <div class="col-sm-4 col-md-4">
    
    <div class="thumbnail">
      <h4 align="center">${partido.getSDescription()}</h4>
      <p align="center">-------------------------------------------------------------------------------------</p>
      <p align="center"><img src="${partido.getTeam1().getSCountryFlag()}">&nbsp;${partido.getTeam1().getSName()}&nbsp; &nbsp;${partido.getSScore()}&nbsp; &nbsp;${partido.getTeam2().getSName()}&nbsp;<img src="${partido.getTeam2().getSCountryFlag()}">  </p>
         
        <c:forEach var="goal" items="${partido.getGoals()}">
        <c:choose>
        	<c:when test="${partido.getTeam1().getSName().equalsIgnoreCase(goal.getSTeamName())}">
        	<p align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${goal.getSPlayerName()} ${goal.getIMinute()}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
        	</c:when>
        	<c:when test="${partido.getTeam2().getSName().equalsIgnoreCase(goal.getSTeamName())}">
        	<p align="right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${goal.getSPlayerName()} ${goal.getIMinute()}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
        	
        	</c:when>
        </c:choose>
      
        </c:forEach>
      <p align="center">-------------------------------------------------------------------------------------</p>
      <div class="caption">
         <p><b>Dia:</b><fmt:formatDate type="date" value="${partido.getDPlayDate()}"></fmt:formatDate>&nbsp;&nbsp;<b>Hora:</b><fmt:formatDate pattern="HH:mm" value="${partido.getTPlayTime().getAsCalendar().getTime()}"></fmt:formatDate></p>
      	<p><b>Estadio:</b> ${partido.getStadiumInfo().getSStadiumName()} </p>
        
      </div>
    </div>
  </div>

</c:forEach>
</div>


<script src="js/bootstrap.min.js" ></script>
</body>
</html>