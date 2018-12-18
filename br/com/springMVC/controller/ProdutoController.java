package com.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springMVC.model.Produto;

@Controller
public class ProdutoController  {
	
	@RequestMapping("/produtos")
	public String homeList() {
		return "produto/cadastroProduto";
	}
	
	
	//Os parametros recebido pelo metodo precisa ser o mesmo nome dos inputs do formulado da propriedade 'name'
	//Esse processo se chama BINDING (funciona com parametro normal e até mesmo um objeto)
	@RequestMapping("/produtos/form")
	public String form(Produto produto) {
		System.out.println(produto);
		return "produto/cadastroProduto";
	}

}
