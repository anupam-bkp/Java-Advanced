<html>

<head>
<title>First Web Application</title>
</head>

<body>
	
	<h2>Login Page</h2>
	<hr>

    <font color="red">${errorMessage}</font>

    <form action="validateLogin" method="post">
        Name : <input type="text" name="name" />
        Password : <input type="password" name="password" /> 

        <input type="submit" />
    </form>
</body>

</html>