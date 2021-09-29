# Restful web-services

### Hello World service
- Create a greeting service 				- /hello-world
- Greeting service with Bean Response type 	- /hello-world-bean
- Greeting service accepting path variable 	- /hello-world-bean-path-variable

### Note: #1
- While returning any java bean from a controller. The bean must need to have 'getter' methods. If missing, it will result in error.

		There was an unexpected error (type=Internal Server Error, status=500).
		No converter found for return value of type: class viveksingh.sb.restws.beans.HelloWorldBean
		org.springframework.http.converter.HttpMessageNotWritableException: No converter found for return value of type: class viveksingh.sb.restws.beans.HelloWorldBean

### @PathVariable
- An annotation helps to read the data from URL. PSB example where the value of '/{name}' is read and provided as method argument.

	  @GetMapping(path = "/hello-world-bean/path-variable/{name}")
	  public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
			return new HelloWorldBean(String.format("Hello world, %s", name));
	  }