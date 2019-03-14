package com.springMVC.model;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CarrinhoCompras {
	
	//Usamos MAP de CarrinhoItem e Integer
	//LinkedHashMap é usado junto com hashCode e Equals, para varrer exatamente os itens corretos
	private Map<CarrinhoItem, Integer> itens = new LinkedHashMap<CarrinhoItem, Integer>();
	
	
	//Adiciona no carrinho, porém qnd ele vai pegar a QUANTIDADE ele vá até um método que:
	//Verifica se aquele ITEM já existe no MAP, se ele existir é coloco o valor ZERO e retorna ZERO no método, dessa forma não muda o inteiro
	//Se não tem o ITEM, ele simplesmente retorna o ITEM normalmente, que será 1. Ficando sempre o ITEM + 1.
	public void add(CarrinhoItem item) {
		itens.put(item, getQuantidade(item) + 1);
	}
	
	
	//Atenção nesse método de validação de itens no carrinho
	private int getQuantidade(CarrinhoItem item) {
		if (!itens.containsKey(item)) {
			itens.put(item, 0);
		}
		
		return itens.get(item);
	}
	
	//Publico, será usado no getQuantidade do Spring da página na hora de pegar via JSTL
	//Usando Lampda
	public int getQuantidade() {
		return itens.values().stream().reduce(0, 
				(proximo, acumulador) -> proximo + acumulador);
	}

}
