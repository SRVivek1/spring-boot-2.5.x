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
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vivek
 *
 */
@RestController
public class ArabicMessageController {

	private static final Logger logger = LoggerFactory.getLogger(ArabicMessageController.class);

	@Autowired
	MessageSource messageSource;

	@GetMapping(path = "/arabic/{key}")
	public String getMessage(@PathVariable String key, Locale locale) {

		logger.info("Language : {0} | Key : {1}", new Object[]{locale, key});
		
		return messageSource.getMessage(key, null, "Key not found.", locale);
	}
}
