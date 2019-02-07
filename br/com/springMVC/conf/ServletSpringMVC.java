package com.springMVC.conf;

import javax.servlet.Filter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}
	
	//Método que procura a classe de configuração dos Controllers do Spring
	//Nesse caso retornamos a classe onde constam essas configurações
	//Colocamos classes de configurações da JPA também
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {AppWebConfiguration.class, JPAConfiguration.class};
	}
	
	//Método de configuração do mapeando que eu quero que o Spring gerencie
	//Nesse caso ele vai gerianciar o que tiver '/' em diante, ou seja TUDO.
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
    @Override
    protected Filter[] getServletFilters() {
    	CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        return new Filter[] {encodingFilter};
    }

}
