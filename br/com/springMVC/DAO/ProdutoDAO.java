package com.springMVC.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.springMVC.model.Produto;

@Repository
public class ProdutoDAO {
	
	@PersistenceContext
	private EntityManager manager; 
	
	public void gravar(Produto produto) {
		manager.persist(produto);
	}
	
	
	
	
	/*
	 * 
	 * Precisamos criar o EntityManagerFactory (Criado pela fábrica).. Ou nós criamos ou falamos para o Spring gerenciar isso para
	 * nós.. Configuramos ela através da classe JPAConfiguration
	 * 
	 * 
	 * 
	 * Component = Repository.. Porém Repository HERDA e Component, ou seja, é mais especifica etc..
	*/
	
}
