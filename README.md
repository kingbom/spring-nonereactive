# spring-nonereactive

Clone repo 
- git clone https://github.com/kingbom/spring-nonereactive.git
- cd spring-nonereactive

Install lib spring boot and run test
- mvn clean install 

Run application on port 8080
- mvn spring-boot:run

APIs you can test
- POST: http://localhost:8080/api/transactions // Save transaction
- GET: http://localhost:8080/api/transactions  //  Get all transactions
- GET: http://localhost:8080/api/transactions/{id}  //Get transaction by id

Load test save transaction
- ./loadtest.sh 

