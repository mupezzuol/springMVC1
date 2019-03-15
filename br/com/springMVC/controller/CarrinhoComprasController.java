package com.springMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.springMVC.DAO.ProdutoDAO;
import com.springMVC.model.CarrinhoCompras;
import com.springMVC.model.CarrinhoItem;
import com.springMVC.model.Produto;
import com.springMVC.model.enums.TipoPreco;

@Controller
@RequestMapping("/carrinho")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)//Para casa REQUISIÇÃO do navegador, ele fará uma sessão diferente.
public class CarrinhoComprasController {
	
	@Autowired //Pedimos para o Spring Injetar para nós
	private ProdutoDAO produtoDAO;
	
	@Autowired
	private CarrinhoCompras carrinhoCompras;
	
	@RequestMapping("/add")
	public ModelAndView add(Integer produtoId, TipoPreco tipoPreco) {
		ModelAndView mv = new ModelAndView("redirect:/produtos");//Para tela de produtos
		CarrinhoItem carrinhoItem = criaItem(produtoId, tipoPreco);
		
		carrinhoCompras.add(carrinhoItem);
		
		return mv;
	}
	
	//Private, só a classe acessa ou herança
	private CarrinhoItem criaItem(Integer produtoId, TipoPreco tipoPreco) {
		Produto produto = produtoDAO.find(produtoId);//recupero o Produto
		CarrinhoItem carrinhoItem = new CarrinhoItem(produto, tipoPreco);//Crio um novo carrinho
		return carrinhoItem;
	}
	
	
	
	
}
