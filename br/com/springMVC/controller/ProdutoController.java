package com.springMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springMVC.DAO.ProdutoDAO;
import com.springMVC.model.Produto;

@Controller
public class ProdutoController  {
	
	@Autowired
	private ProdutoDAO produtoDAO; //Injeção do DAO.. Faz o NEW....
	
	@RequestMapping("/produtos")
	public String homeList() {
		return "produto/cadastroProduto";
	}
	
	//Os parametros recebido pelo metodo precisa ser o mesmo nome dos inputs do formulado da propriedade 'name'
	//Esse processo se chama BINDING (funciona com parametro normal e até mesmo um objeto)
	@RequestMapping("/produtos/gravar")
	public String grava(Produto produto) {
		System.out.println(produto);
		produtoDAO.gravar(produto);
		return "produto/ok";
	}

}
