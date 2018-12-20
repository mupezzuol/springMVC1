<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Produtos</title>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>
	<h1>Cadastro de Produtos</h1>

	<form action="produtos/form" method="post">
		<div>
			<label>T�tulo</label> <input type="text" name="titulo" />
		</div>
		<div>
			<label>Descri��o</label>
			<textarea rows="10" cols="20" name="descricao"></textarea>
		</div>
		<div>
			<label>P�ginas</label> <input type="text" name="paginas" />
		</div>
		<button type="submit">Cadastrar</button>
	</form>
</body>
</html>