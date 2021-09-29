/**
 * 
 */
package viveksingh.sb.restws.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import viveksingh.sb.restws.bean.User;
import viveksingh.sb.restws.processor.UserResource;

/**
 * @author vivek
 *
 */
@Component
public class UserResourceProcessor implements RepresentationModelProcessor<RepresentationModel<User>> {

	private static final Logger logger = LoggerFactory.getLogger(UserResourceProcessor.class);

	@Override
	public RepresentationModel<User> process(RepresentationModel<User> model) {

		logger.info("Execution started of process method.");

		logger.info("Model instance: " + model.getClass().getName());

		final UserResource userResource = WebMvcLinkBuilder.methodOn(UserResource.class);

		model.add(WebMvcLinkBuilder.linkTo(userResource.retrieveAllUsers()).withRel("all-user"));

		logger.info("Execution completed of process method.");

		return model;
	}

}
