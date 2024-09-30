# Banking-System Back-End

Banking System Project : 
This project is a comprehensive banking system developed using Spring Boot for the backend. The system is designed to manage various banking operations, such as account management, transactions, and user authentication. Below is a brief explanation of the key components of the backend architecture.

1. Entity Layer:
Purpose: The entity layer defines the core data structure of the system. Each entity represents a table in the database, and the fields in the entity class correspond to the columns in the table.
Example: Entities such as Account, Customer, Transaction, and User are created to model the banking system.
Annotations: The @Entity annotation is used at the class level to indicate that this class is a JPA entity. Other annotations like @Id, @Column, and @GeneratedValue are used to define primary keys and column properties.

3. Repository Layer:
Purpose: The repository layer is responsible for interacting with the database. It provides CRUD (Create, Read, Update, Delete) operations and query methods for the entities.
Implementation: Each entity has an associated repository interface that extends JpaRepository or CrudRepository. This enables the use of built-in methods like save(), findById(), findAll(), deleteById(), etc.
Annotations: The @Repository annotation is used to indicate that the interface is a repository that will interact with the database.
Example:
AccountRepository manages database operations for the Account entity.
CustomerRepository handles data access for the Customer entity.

5. Service Layer:
Purpose: The service layer contains the business logic of the application. It acts as an intermediary between the controller and repository layers, ensuring that the business rules are applied and data is processed correctly.
Implementation: Services inject the required repositories and use them to perform complex operations, such as transferring money between accounts or calculating interest.
Annotations: The @Service annotation is used to indicate that the class provides business services.
Example:
AccountService manages account-related operations such as opening new accounts, updating account information, and handling transactions.
CustomerService manages customer-related operations, including registration, updates, and retrieval of customer information.

7. Controller Layer:
Purpose: The controller layer handles incoming HTTP requests from the client and maps them to the appropriate service methods. It is responsible for routing requests, processing input data, and returning responses.
Implementation: Each controller class is mapped to a specific endpoint using the @RequestMapping or other HTTP method annotations like @PostMapping, @GetMapping, etc.
Annotations: The @RestController or @Controller annotations are used to define controller classes. The @Autowired annotation is used to inject the service layer into the controller.
Example:
AccountController handles all account-related requests, such as creating a new account, viewing account details, and processing transactions.
CustomerController manages customer-related endpoints, such as customer registration, profile updates, and customer data retrieval.


Working in Short:
Client Interaction: The client sends a request (e.g., to create a new account) to the backend through a REST API endpoint defined in the controller layer.

Controller Layer: 
        The controller receives the request, processes the input, and calls the corresponding method in the service layer.

Service Layer: 
        The service layer applies business logic and interacts with the repository layer to perform the required operations (e.g., saving the account information in the database).

Repository Layer: 
        The repository layer interacts directly with the database to execute the CRUD operations. It retrieves, updates, or saves the data as instructed by the service layer.

Response:
       Once the operation is completed, the service returns the result to the controller, which then sends an appropriate response back to the client.

This architecture ensures a clean separation of concerns, making the system more maintainable, scalable, and testable. Each layer has a specific responsibility, and by following this pattern, the banking system is both robust and efficient in handling various banking operations.

Technologies Used
Backend: Spring Boot, JPA, MySQL
Frontend: Angular, TypeScript, HTML, CSS
Database: MySQL
Tools: Maven, npm, Angular CLI

Contact
📧 Email: dhageravi4@gmail.com
📞 Phone: 7875671417




