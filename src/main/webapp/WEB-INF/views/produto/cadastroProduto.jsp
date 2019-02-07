<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

	<form action="gravar" method="post">
		<div>
			<label>Título</label> <input type="text" name="titulo" />
		</div>
		<div>
			<label>Descrição</label>
			<textarea rows="10" cols="20" name="descricao"></textarea>
		</div>
		<div>
			<label>Páginas</label> <input type="text" name="paginas" />
		</div>

		<c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
			<div>
				<label>${tipoPreco}</label> 
				<input type="text" name="precos[${status.index}].valor"/>
				<input type="hidden" name="precos[${status.index}].tipo" value="${tipoPreco}"/>
			</div>
		</c:forEach>
		
		<button type="submit">Cadastrar</button>
	</form>
</body>
</html>

<!-- 
EXPLICANDO O FOREACH:
- O varStatus é uma forma de fazer que seja gerado um valor diferente a cada vez que é lançado um item da lista.. Ou seja é um INDEX
- O Spring faz o BINDING do meu Objeto, portanto na minha classe produto eu tenho a herança abaixo:
	.Listas de PRECOS
	.PRECO
		> Valor
		> TipoPreco
			> EBOOK, IMPRESSO, COMBO;
- Para o Spring fazer o BINDING o 'NAME' do input deve ser igual ao da classe, por esse motivo é usado o array, onde eu seto os valores
de todos os TIPOS que estão na lista.
- Após selecionar os precos ele seta cada valor em seu respectivo INDEX de acordo com o 'varStatus' utilizado para setar corretamente 
no array e o BINDING funcionar sem problemas.
 -->