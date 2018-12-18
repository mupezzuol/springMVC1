package com.springMVC.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}
	
	//Método que procura a classe de configuração dos Controllers do Spring
	//Nesse caso retornamos a classe onde constam essas configurações
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {AppWebConfiguration.class};
	}
	
	//Método de configuração do mapeando que eu quero que o Spring gerencie
	//Nesse caso ele vai gerianciar o que tiver '/' em diante, ou seja TUDO.
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
