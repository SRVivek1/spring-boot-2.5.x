/**
 * 
 */
package viveksingh.sb.restws.config;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * @author vivek
 *
 */
@Configuration
public class AppConfig {

	private final Logger logger = LoggerFactory.getLogger(AppConfig.class);
	
	/**
	 * Locale Resolver for i18n.
	 * 
	 * @return
	 */
	@Bean
	public LocaleResolver localResolver() {
		
		logger.info("Execution started for method : localResolver");
		
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		
		logger.info("Execution completed for method : localResolver");
		
		return localeResolver;
	}

	/**
	 * An interceptor bean that will switch to a new locale based on the value of
	 * the lang parameter appended to a request.
	 * 
	 * @return
	 */
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		
		logger.info("Exection started for method : localeChangeInterceptor");
		
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		
		logger.info("Exection completed for method : localeChangeInterceptor");
		
		return localeChangeInterceptor;
	}

	/**
	 * Resource bundle to resolve messages.
	 * 
	 * @param locale
	 * @return
	 */
	@Bean
	public ResourceBundleMessageSource messageBundle() {
		
		logger.info("Exection started for method : messageBundle");
		
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		
		logger.info("Exection completed for method : messageBundle");
		
		return messageSource;
	}
}
