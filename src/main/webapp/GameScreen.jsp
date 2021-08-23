<%--
  Created by IntelliJ IDEA.
  User: TToth
  Date: 2021. 05. 07.
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<div id="content">
	<div id="player1">
		<h1>Player 1</h1>
	</div>
	<div id="boardDiv">
		<form method="get" action="Servlet.GameScreenServlet">
			<table id="board" border="1px solid black">
				<%
					for (int i = 0; i < 15; i++) {
						out.print("<tr>");
						for (int j = 0; j < 15; j++) {
							out.print("<td id='" + i + "_" + j + "'>");
							char[] board = (request.getAttribute("board") != null) ? ((String) request.getAttribute("board")).toCharArray() : null;
							if (board != null) {
								out.print("<input type='submit' value='" + board[(15 * i) + j] + "' name='" + i + "_" + j + "'>");
							} else {
								out.print("<input type='submit' value='' name='" + i + "_" + j + "'>");
							}
							out.print("</td>");
						}
						out.print("</tr>");
					}
				%>
			</table>
		</form>
	</div>
	<div id="player2">
		<h1>Player 2</h1>
	</div>
</div>
</body>
</html>
