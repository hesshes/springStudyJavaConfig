package org.zerock.config;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// web.xml 대신하는 객체

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { RootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { ServletConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
	}

	@Override
	protected Filter[] getServletFilters() {

		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);

		return new Filter[] { characterEncodingFilter };
	}

}

/*
 * web.xml 구현하는 다른 방식 public class WebConfig implements
 * WebApplicationInitializer {
 * 
 * @Override public void onStartup(ServletContext servletContext) throws
 * ServletException { // TODO Auto-generated method stub
 * AnnotationConfigWebApplicationContext context = new
 * AnnotationConfigWebApplicationContext();
 * context.setConfigLocation("org.zerock.config.RootConfig");
 * System.out.println("여기 자동 진입함?"); ServletRegistration.Dynamic dispatcher =
 * servletContext.addServlet("DispatcherServlet", new
 * DispatcherServlet(context)); dispatcher.setLoadOnStartup(1);
 * dispatcher.addMapping("/"); }
 * 
 * }
 */