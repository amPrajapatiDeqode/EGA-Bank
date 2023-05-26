# EGA-Bank

Baking Application
This is a baking application built with Spring Boot that provides various functionalities related to user accounts, authentication, and transactions. It utilizes JSON Web Tokens (JWT) for authentication and provides password encryption for enhanced security.

Features
User registration: Users can create an account and register with the application.
User authentication: Users can log in and log out of their accounts securely.
User profile: Users can view and update their profile information.
Account management: Users can view their account details and perform account-related operations.
Transaction management: Users can initiate and track their baking transactions.
Installation
Clone the repository:

bash
Copy code
git clone https://github.com/your-username/baking-application.git
Navigate to the project directory:

bash
Copy code
cd baking-application
Build the project using Maven:

Copy code
mvn clean install
Run the application:

arduino
Copy code
mvn spring-boot:run
The application will start running on http://localhost:8080.

API Endpoints
The following are the available API endpoints provided by the application:

/user/get (GET): Retrieves the user information based on the bearer token.
/user/register (POST): Registers a new user with the application.
/account/get (GET): Retrieves the account information based on the bearer token.
Technologies Used
Java
Spring Boot
JSON Web Tokens (JWT)
Maven
Contributing
Contributions to the baking application are welcome! If you find any issues or want to add new features, please open an issue or submit a pull request.

License
This baking application is licensed under the MIT License.

Contact
For any inquiries or feedback, please contact [your-email-address].

