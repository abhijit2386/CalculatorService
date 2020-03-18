<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>


</head>
<body>
	<div class="container">
		<header> </header>
		<div class="starter-template">
			<h1>Expression List</h1>
			<table border="1"
				class="table table-striped table-hover table-condensed table-bordered">
				<tr>

					<th>Input</th>
					<th>Output</th>
				</tr>
				<c:forEach var="calc" items="${calc}">
					<tr>
						<td>${calc.inputVal}</td>
						<td>${calc.outVal}</td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</div>

</body>

</html>