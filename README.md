Sample Spring Boot Demo Complete Assignment
Required Software
Feature included
How to run the Program
How to generate Code coverage report
This project consist of two API which can be used to get list of countries with their country codes and to get data about a specific country by its name. Also, it runs a job every hour to get the latest rate for applicable currencies

Required software
Intellij IDEA/Eclipse
Java JDK 8+
JDK and Maven installed and Set in your classpath
Feature included
1. Sample-Spring-Boot Demo:The service should expose end-points to
   “return country details or countries list” .

## Technology:
Spring Boot Service

Api Docs:-

http://localhost:8080/api/countries

http://localhost:8080/api/countries/{name}

Request Headers:-

"Content-type": "application/json",

"Accept": "application/json"

How to run the Program
Import the project into Intellij IDEA/Eclipse.
Makes sure jdk is set for all modules in Intellij.(Check Modules Settings and project setting to configure JDK)
Run Maven commands from Project:-
It will build clean and build the entire application.
mvn clean
mvn package or mvn install
Bring the spring boot service rest module UP by Running Main class CountryServiceApplication.java, or we can also use command from cmd line java -jar target/account-service-rest-1.0-SNAPSHOT.jar
