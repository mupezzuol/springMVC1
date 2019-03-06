package com.springMVC.conf;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.springMVC.DAO.ProdutoDAO;
import com.springMVC.controller.HomeController;

@EnableWebMvc
@ComponentScan(basePackageClasses= {HomeController.class, ProdutoDAO.class})
public class AppWebConfiguration {
	
	
	//O retorno seja gerenciado pelo Spring, dessa forma temos que colocar como Beans
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver(); 
		resolver.setPrefix("/WEB-INF/views/");//Tudo que vem primeiro, o PREFIXO
		resolver.setSuffix(".jsp");//Tudo que vem por último, o nosso SUFIXO
		return resolver;
	}
	
	@Bean
	public MessageSource messageSource(){
	    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	    messageSource.setBasename("/WEB-INF/messages");
	    messageSource.setDefaultEncoding("UTF-8");
	    messageSource.setCacheSeconds(1);
	    return messageSource;
	}

	
	
	
	
	//Classe que contém todas as configurações referente aos Controllers do Spring
	//Ele é especifico para parte de web
	
	//ANOTAÇÕES:
	/*
	@EnableWebMvc -> Habilita o Web MVC do spring 
	
	@ComponentScan-> Indica onde estão o pacote base dos Controllers
	-	(basePackages= {array de string dos enderecos dos pacotes onde estão as controller}) 
	-	basePackageClasses= {SuaClasse.class} << Spring já é esperto, então se mudar o pacote não tem problema, pois ele pega a classe
	*/
}
