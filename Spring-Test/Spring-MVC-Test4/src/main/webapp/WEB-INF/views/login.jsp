<html>
<body>
<h1>  Spring MVC Example  </h1>

	<p><font color="red">${errormessage}</font></p>
	<form action="validateUser" method="post">
		Username : 
			<input type="text" name="username" /> <br> <br>
		Password : 
			<input type="password" name="password" /> <br>
			
		<input type="submit" value="submit" />
	</form>
</body>
</html>
