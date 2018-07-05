package com.concretepage.config;


import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/*
 * We will create:
 * A Spring Web Service Java configuration class annotated with
 *   @EnableWs and extending "WsConfigurationAdapter". 
 *   
 * Now we will configure web service "DefaultWsdl11Definition" bean
 *   as following:
 */
////////////////////////////////////////////////////

/*
*** @EnableWs :: is used with @Configuration to have Spring Web Services
*      defined in "WsConfigureAdapter".
*/
@Configuration
@EnableWs
public class WSConfig extends WsConfigurerAdapter {

	
	////////////////////////////////////////////////////
	/*
	 **** ServletRegistrationBean() :: configures application context, 
	 *       URL mappings etc.
	 */
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		
		return new ServletRegistrationBean(servlet, "/soapws/*");
	}
	
	////////////////////////////////////////////////////
	/*
	 *** DefaultWsdl11Definition() :: is configuring WSDL definitions such as port type 
	 *      name, location URI, target namespace, schema etc.
	 */
	@Bean(name = "articles")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema articlesSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("ArticlesPort");
		wsdl11Definition.setLocationUri("/soapws");
		wsdl11Definition.setTargetNamespace("http://www.concretepage.com/article-ws");
		wsdl11Definition.setSchema(articlesSchema);
		return wsdl11Definition;
	}
	
	////////////////////////////////////////////////////
	/*
	 *** XsdSchema() :: represents an abstraction for XSD schemas.
	 */
	@Bean
	public XsdSchema articlesSchema() {
		return new SimpleXsdSchema(new ClassPathResource("articles.xsd"));
	}
	
} // end of class
