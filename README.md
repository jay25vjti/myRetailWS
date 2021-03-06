# myRetailWS
A REST webservice application Proof-of-Concept for a products API, which will aggregate product data from multiple sources and return it as JSON to the caller.

## Synopsis
The API provides product details to any number of client devices from .com to mobile by making use of application/json as content type.
The service that can retrieve product and price details by ID based on input parameters.
The service retrives product details from external API and price details from a local data store, MongoDB in this example.

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
##Installation
1. Git clone to your IDE.
2. I have used Maven. Update the pom.xml as need may be.
3. The packaging option in pom.xml can be changed to "war" for actual deployments in containers.
4. Update the project. In IDE right click project -> Maven -> update project.
5. You need to configure a local noSQL data store for storing product's price and currency code. I have used mongoDB for this.
6. To install and configure mongoDB follow steps as per [here](http://www.mkyong.com/mongodb/how-to-install-mongodb-on-windows/). I have set it up as a service for ease.
7. To configure logging, this app uses logback. The settings can be found at logback.xml under resources. Currently the logs are written to a log file and to console. I have set app logging level to DEBUG and root to info. Based on deployment environments this can be modified.

## Running
 Below configurations show how to run the app and changes as needed.
 
###Running as stand alone app in IDE
With below config we can run as a stand alone app in developer workstations using an IDE (preferably STS). Simply select the MyRetailConfig and run it in IDE as Spring Boot app. 
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
To run in a container like websphere or weblogic etc the config needs to be modified by extending SpringBootServletInitializer. This helps the app to get initialized on deployment and thus serves the resources needed. You may need to tweak your pom.xml, since we need a war file for this deployment.
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

## Testing
The rest services can be tested with any rest client like SOAPUI or Postman. I have used Postman for testing.

###Steps
1. You need a rest client for invoking the services like SOAPUI or Postman. I have used Postman for my testing.
2. Make sure the following heardes are present for local testing:
   * Content-Type - application/json. 
   * TOKEN - myRetailToken
3. Make sure the correct HTTP verb is selected in client and proper URI is given while invoking the services.
4. The list of resources available with URI, sample request and response is given below:

### Resource details

--> Get a particular product based on id.
  
   VERB: GET.

   URI: <domain>\myretail\products\v1\13860428 (this fetches data from external api and price from local ds and aggregates response).
        
   URI: <domain>\myretail\products\v2\13860428 (this fetches data from locally hosted api and price from local ds and aggregates response).
   
   Sample response:
```
[
  {
    "id": "13860428",
    "current_price": {
      "value": "13.00",
      "currency_code": "USD"
    },
    "name": "The description goes here"
  }
]
```

--> Update a product's price and currency_code in local Data Store

  VERB: PUT
  
  URI: <domain>\myretail\products\v1\13860428  or <domain>\myretail\products\v2\13860428 (v1 for actal and v2 for local DS. However the price is present in local DS only)
  
   Sample response:
```
[
  {
    "id": "13860428",
    "current_price": {
      "value": "13.00",
      "currency_code": "USD"
    },
    "name": "The description goes here"
  }
]
```

--> Helper resource to create product in local data store

  VERB: POST
  
  URI: <domain>\myretail\products
  
  Sample request:
  
  ```
{"id":13860428,"name":"The Big Lebowski (Blu-ray) (Widescreen)","current_price":{"value": 13.49,"currency_code":"USD"}}
  ```
  
  Sample response:
  
  ```
  {
  "id": "13860428",
  "current_price": {
    "value": "13.49",
    "currency_code": "USD"
  },
  "name": "The Big Lebowski (Blu-ray) (Widescreen)"
}
```

--> Helper to delete a product from local DS

   VERB: DELETE
   
   URI: <domain>\myretail\products\13860428
   
   Sample response :
```
{
  "id": "13860428",
  "current_price": {
    "value": "13.00",
    "currency_code": "USD"
  },
  "name": "The Big Lebowski (Blu-ray) (Widescreen)"
}
```

--> Helper to get all product details from local data store
   
   VERB: GET

   URI: <domain>\myretail\products
   
Sample response:
```
[
  {
    "id": "13860428",
    "current_price": {
      "value": "13.00",
      "currency_code": "USD"
    },
    "name": "The description goes here"
  }
]
```
