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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import viveksingh.sb.restws.constants.MessageKeyConstants;

/**
 * @author vivek
 *
 */
@RestController
public class HelloWorldController {

	private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
	
	@Autowired
	MessageSource messageSource;

	@GetMapping(path = "/greeting")
	public String greet() {
		return "Hello World !!";
	}

	@GetMapping(path = "/greeting/i18n")
	public String greet_i18n(Locale locale) {
		
		logger.info("greet_i18n | locale : " + locale.getDisplayLanguage());
		
		return messageSource.getMessage(MessageKeyConstants.GREETING_MESSAGE, null, "Key not found", locale);
	}
	
	@GetMapping(path = "/greeting/i18n/lang")
	public String greet_i18n_lang(@RequestHeader(name = "lang", defaultValue = "en") Locale locale) {
		
		logger.info("greet_i18n_lang | locale : " + locale.getDisplayLanguage());
		
		return messageSource.getMessage(MessageKeyConstants.GREETING_MESSAGE, null, "Key not found", locale);
	}
}
