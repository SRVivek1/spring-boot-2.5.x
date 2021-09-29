/**
 * 
 */
package viveksingh.sb.restws.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import viveksingh.sb.restws.constants.MessageConstants;
import viveksingh.sb.restws.beans.HelloWorldBean;

/**
 * @author vivek
 *
 */
@RestController
public class HelloWorldController {

	private final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

	@Autowired
	MessageSource messageSource;

	@GetMapping(path = "/hello-world")
	public String helloWorld(Locale locale) {

		logger.info("Executing started for method helloWorld. Locale - {}", locale.getLanguage());

		String message = messageSource.getMessage(MessageConstants.HELLO_WORLD, null, locale);

		logger.info("Executing completed for method helloWorld. Response {}", message);

		return message;
	}

	/**
	 * Here we are reading the locale information from a defined Header. If 'lang'
	 * header not found in request it will use the provided default value.
	 * 
	 * @param locale
	 * @return
	 */
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean(@RequestHeader(name = "lang", defaultValue = "en") Locale locale) {

		logger.info("Executing started for method helloWorldBean. Locale - {}", locale.getLanguage());

		String message = messageSource.getMessage(MessageConstants.HELLO_WORLD, null, locale);
		HelloWorldBean helloWorldBean = new HelloWorldBean(message + " bean");

		logger.info("Executing completed for method helloWorld. Response {}", helloWorldBean.getMessage());

		return helloWorldBean;
	}

	/**
	 * i18m not implemented on this controller.
	 * 
	 * @param name
	 * @return
	 */
	@GetMapping(path = "/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {

		logger.info("Executing started for method helloWorldPathVariable.");

		HelloWorldBean helloWorldBean = new HelloWorldBean(String.format("Hello world, %s", name));

		logger.info("Executing completed for method helloWorld. Response {}", helloWorldBean.getMessage());

		return helloWorldBean;
	}
}
