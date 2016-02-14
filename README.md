# myRetailWS
A REST webservice application Proof-of-Concept for a products API, which will aggregate product data from multiple sources and return it as JSON to the caller.

## Synopsis
The API provides product details to any number of client devices from .com to mobile by making use of application/json as content type.
The service that can retrieve product and price details by ID based on input parameters.

## Code Example
The API is developed using Spring Framework with Spring Boot. The ideal IDE would be STS.
### Sample resource
```
@RestController
@RequestMapping("/myretail/products")
public class MyRetailController {
...
@RequestMapping(value = "/v1/{id}", method = RequestMethod.GET)
	 MyRetailDTO findById(@PathVariable("id") @Validated(MyRetailValidator.class) String id) {
		
	        LOGGER.info("Invoked  findById with id: {}", id);
	        
	        MyRetailDTO response = service.findById(id);
	        
	        return response;
	    }
 further code ...
```
Below configuration shows how to run the app as a standalone project in STS.
###Running as stand alone app
With this config we can run as a stand alone app in developer workstations using an IDE (preferably STS)
```
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class MyRetailConfig {
	
	public static void main(String[] args) {
	        SpringApplication.run(MyRetailConfig.class, args);
	    }

}
```
###Run in a J2EE container 
To run in a container like websphere or weblogic etc the config needs to be modified by extending SpringBootServletInitializer
```
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(applicationClass, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

    private static Class<Application> applicationClass = Application.class;
}
```
[Further Reading on Deploying application](https://spring.io/blog/2014/03/07/deploying-spring-boot-applications)
