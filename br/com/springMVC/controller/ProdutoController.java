package com.springMVC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springMVC.DAO.ProdutoDAO;
import com.springMVC.model.Produto;
import com.springMVC.model.enums.TipoPreco;

@Controller
@RequestMapping("produtos") //Endereço DEFAULT antes de todos abaixo
public class ProdutoController  {
	
	@Autowired
	private ProdutoDAO produtoDAO; //Injeção do DAO.. Faz o NEW....
	
	
	//Os parametros recebido pelo metodo precisa ser o mesmo nome dos inputs do formulado da propriedade 'name'
	//Esse processo se chama BINDING (funciona com parametro normal e até mesmo um objeto)
	@RequestMapping(value="/gravar", method=RequestMethod.POST)
	public String grava(Produto produto) {
		System.out.println(produto);
		produtoDAO.gravar(produto);
		return "produto/ok";
	}
	
	//Não coloquei o endereço pois é o endereço HOME 'produtos'
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar(Produto produto) {
		List<Produto> produtos = produtoDAO.listar();
		ModelAndView mv = new ModelAndView("produto/lista");
		mv.addObject("listProdutos", produtos);
		return mv;
	}
	
	
	@RequestMapping(value="/CadProdutos", method=RequestMethod.GET)
	public ModelAndView homeProduto() {
		ModelAndView mv = new ModelAndView("produto/cadastroProduto");//Do MODEL para a VIEW
		mv.addObject("tipos", TipoPreco.values());
		return mv;
	}
	
	
	
	
	
	

}
