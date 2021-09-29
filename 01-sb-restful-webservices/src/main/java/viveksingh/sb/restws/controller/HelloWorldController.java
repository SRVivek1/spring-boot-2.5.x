/**
 * 
 */
package viveksingh.sb.restws.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import viveksingh.sb.restws.beans.HelloWorldBean;

/**
 * @author vivek
 *
 */
@RestController
public class HelloWorldController {

	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello world bean");
	}
	
	@GetMapping(path = "/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello world, %s", name));
	}
	
	/**
	 * Getting error - No converter for [class viveksingh.sb.restws.beans.HelloWorldBean] with preset Content-Type 'null']
	 * 
	 * @return
	 */
	@GetMapping(path = "/hello-world-bean-xml", produces = {MediaType.APPLICATION_XML})
	public HelloWorldBean helloWorldBeanXml() {
		return new HelloWorldBean("Hello world bean");
	}
}
