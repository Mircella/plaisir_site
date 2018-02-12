package app;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class SpringInitializer implements WebApplicationInitializer {
    private static final String DISPATCHER = "dispatcher";
    public void onStartup(ServletContext servletContext) throws ServletException {
        //AnnotationConfigWebApplicationContext springContext = new AnnotationConfigWebApplicationContext();
        //springContext.register(WebConfig.class);
        //servletContext.addListener(new ContextLoaderListener(springContext));

        ServletRegistration.Dynamic servlet = servletContext.addServlet(DISPATCHER,new DispatcherServlet());
        servlet.addMapping("/database");
        servlet.setLoadOnStartup(1);

    }
}
