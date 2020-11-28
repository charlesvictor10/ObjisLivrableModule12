package fr.orsys.tp10.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext(); // Conteneur Annotation 
		rootContext.register(DBConfig.class, ServiceConfig.class); // Classe de configuration couche Dao (Spring Data)
		
		servletContext.addListener(new ContextLoaderListener(rootContext));  // Chargement du conteneur 
		
		AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext(); // Conteneur Annotation 
		dispatcherServlet.register(MvcConfig.class); // Classe de configuration couche presentation
		
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherServlet)); 
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}

}
