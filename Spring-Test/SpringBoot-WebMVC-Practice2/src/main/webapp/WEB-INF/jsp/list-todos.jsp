<%@page import="java.util.List"%>
<%@page import="com.example.model.Todo"%>

<html>

<head>

<title>First Web Application</title>

</head>

<body>

	<h2>List-Todo Page</h2>
	<hr>
	<h4>Your Name is : ${name}</h4>
    <h4>Here are the list of your todos:</h4>
	<hr>
	
	<!-- ${todos}  -->
	
	<%
		for(Todo todo: (List<Todo>)request.getAttribute("todos")){
			out.print(todo);
	%>
		<br>
	<%
		}
	%>
	
</body>

</html>