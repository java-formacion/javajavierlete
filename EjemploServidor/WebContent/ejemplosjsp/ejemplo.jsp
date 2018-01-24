<html>
<head>
<title>Hola</title>
</head>
<body>
	<h1>Hola desde JSP</h1>
	<h2><%=new java.util.Date()%></h2>

	<%
		for (int i = 1; i <= 6; i++) {
	%>
	<h <%=i%>>Título <%=i%></h<%=i%>>
	<%
		}
	%>
</body>
</html>