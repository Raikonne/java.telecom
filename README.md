# java.telecom

# [1] How to run

- 1.1 Download the project onto your local machine.
- 1.2 Inside the project root folder via cmd run: gradlew clean build or via bash: ./gradlew clean build.
      This will download project required dependencies locally into your .gradlew folder that is usually
      located in windows user/{username} root folder.
- 1.3 After running the above command in project root under build/libs there should be a jar file generated
      that will be used to run the project locally.
- 1.4 Run file that is located under cmd\run.cmd to start the application.

# [2] Approach
      
      Since the documentation didn't specify about the end-point usage or load I have decided to go for 3
      tier architecture: dao, service and controller layer (sometimes we could use 2 tier as 3 could be overkill).
      
      http://localhost:8080/customer/get/{customerId}/phonenumbers/all
      The above end-point has been developed to present the layers which is real world scenario I would use
      in this application when developing further end-points as well as the other two.
      
      http://localhost:8080/phonenumber/get/all
      http://localhost:8080/phonenumber/update/{number}
      Since the initial end-point took fair amount of time to develop I have completed those as working prototypes 
      but hopefully based on the customer controller you will be able to see how they could look if developed 
      as part of the real project.
      
      If this was two tier design the service layers that is responsible for caching requests would be skipped.
      
# [3] API Specification
      
- 3.1  Base URL: http://localhost:8080
      
- 3.2 get all phone numbers of a single customer

     /**
     * Retrieve a list of phone numbers stored for a customer
     *
     * @param customerId
     * @produces application/json
     * @RequestType GET
     * @return list of phone numbers for customer with id of customerId
     */

     API endpoint: - /customer/get/{customerId}/phonenumbers/all
     
- 3.3 get all phone numbers

    /**
     * Retrieve all phone numbers
     * 
     * @produces application/json
     * @RequestType GET
     * @return list of all phone numbers currently stored in database
     */

     API endpoint: - /phonenumber/get/all
     
- 3.4 activate a phone number

    /**
     * Activate phone number
     *
     * @param number
     * @return PhoneNumber object with activated status if found. Returns without owner and not activated if not found or log message if already activated
     */
	
     API endpoint: PUT - /phonenumber/update/{number}
     
- 3.5 Sample data
    
     After spring dependency injection application is injecting some sample data that can be used to test those end-points,
     by replacing relevant parameters:
     
     - /phonenumber/update/{number} replace with number value such as 07471885134
     - /customer/get/{customerId}/phonenumbers/all replace with customer id such as 1
     
     Customer [id=1, firstName=testFornameOne, lastName=testSurnameOne, 
     phoneNumbers=[PhoneNumber [id=1, number=07471885134, hasBeenActivated=false]]]
     
     Customer [id=2, firstName=testFornameTwo, lastName=testSurnameTwo, 
     phoneNumbers=[PhoneNumber [id=2, number=07471885134, hasBeenActivated=false]]]
