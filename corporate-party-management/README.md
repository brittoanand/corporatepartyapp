# Getting Started

###  Important notes


* Use Java 17 to run this application.
* This application is designed to use both PostgreSQL as well as H2 in-memory DB.
* Notes when using PostgreSQL
	* Install latest version of PostgreSQL in your local. 
	* Edit PostgreSQL url, username and password accordingly in application.properties.
	* Disable H2 DB by setting spring.h2.console.enabled=false.
* Notes when using H2 in-memory DB
	* Enable H2 DB by setting spring.h2.console.enabled=true in application.properties.
	* Provide corresponding DB url.

### Functionality - Facts & assumptions

* Table should be added first. To enable this tables are added automatically when the application starts. Tables can be added and removed as and when required.
* Guests will call up the restaurant to book tables. If the table can accommodate the number of guests + 1 (guest) booking will be allowed on the table. Else another table should be selected that accommodate the guests.
* When guests arrive they will tell what table they had booked. If the table can accommodate the number of guests + 1 (guest) they will be allowed else they will be turned away.
* The application is designed to throw the necessary errors for the above mentioned points.
* When the guests leaves the accompanying guests will also leave.
* At any point of time you should be able to get the list of guests booked as well as arrived and the number of seats empty.

### Future improvements

* Migrate the application to use Java 21.
* More validations to be added to make the application more stable.
* Test coverage to be increased by writing more JUnit test cases.
* Create API documentation.
