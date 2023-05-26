# Banking Application

This is a banking application built using Java, Spring Boot, and Spring Security. The application uses JWT tokens for authentication and a MySQL database using a Docker image. The application provides various endpoints for managing user accounts, authentication, and transactions.

## Prerequisites

Before running the application, make sure you have the following installed:

- Java Development Kit (JDK)
- Docker
- Docker Compose

## Getting Started

To get started with the banking application, follow the steps below:

1. Clone the repository from GitHub:

   ```
   git clone <repository_url>
   ```

2. Navigate to the project directory:

   ```
   cd banking-application
   ```

3. Build the application:

   ```
   ./mvnw clean package
   ```

4. Start the application and the database using Docker Compose:

   ```
   docker-compose up
   ```

   This command will start the application and the MySQL database using the Docker containers defined in the `docker-compose.yml` file.

5. Once the application is up and running, you can access it at [http://localhost:8080](http://localhost:8080).

## API Endpoints

The banking application provides the following API endpoints:

### Account

- **GET /account/get**: Retrieves the account details for the authenticated user.

### Authentication

- **POST /auth/login**: Authenticates a user and returns a JWT token.
- **POST /auth/logout**: Logs out the currently authenticated user.

### Transaction

- **POST /transaction**: Performs a transaction, such as deposit or withdrawal.
- **GET /transaction/get**: Retrieves all transactions for the authenticated user.
- **GET /transaction/get/deposits**: Retrieves all deposit transactions for the authenticated user.
- **GET /transaction/get/withdraws**: Retrieves all withdrawal transactions for the authenticated user.

### User

- **GET /user/get**: Retrieves the user details for the authenticated user.
- **POST /user/register**: Registers a new user.

## Examples

Here are some examples of how to use the API endpoints:

### Account

To retrieve the account details for the authenticated user:

```
GET /account/get
```

### Authentication

To authenticate a user and receive a JWT token:

```
POST /auth/login

Request Body:
{
  "email": "user@example.com",
  "password": "password"
}
```

### Transaction

To perform a transaction (deposit or withdrawal):

```
POST /transaction

Request Body:
{
  "amount": 100.0,
  "transactionType": "DEPOSIT"
}
```

To retrieve all transactions for the authenticated user:

```
GET /transaction/get
```

To retrieve all deposit transactions for the authenticated user:

```
GET /transaction/get/deposits
```

To retrieve all withdrawal transactions for the authenticated user:

```
GET /transaction/get/withdraws
```

### User

To retrieve the user details for the authenticated user:

```
GET /user/get
```

To register a new user:

```
POST /user/register

Request Body:
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "user@example.com",
  "password": "password"
}
```

## Testing

Unit tests have been implemented to ensure the functionality and reliability of the banking application. The tests cover various scenarios to validate different components and endpoints.

To run the unit tests, follow these steps:

1. Make sure the banking application and the associated containers are running using Docker Compose.

2. Open a terminal or command prompt.

3. Navigate to the cloned repository.

4. Run the following command to execute the unit tests:

   ```bash
   ./mvnw test
   ```

   The tests will be executed, and the results will be displayed in the terminal.

   Note: The above command assumes you are using Maven Wrapper (`mvnw`). If you have Maven installed globally, you can use `mvn test` instead.

5. Review the test results to ensure that all tests pass successfully.


## Swagger API Documentation

The banking application includes Swagger, a powerful tool for documenting and testing APIs. With Swagger, you can explore and interact with the application's endpoints directly from your browser.

To access the Swagger UI, follow these steps:

1. Ensure that the banking application is running using Docker Compose.

2. Open your web browser.

3. Enter the following URL:

   ```
   http://localhost:8080/swagger-ui.html
   ```

   The Swagger UI page will be displayed, showing a list of available endpoints, request/response details, and the ability to test the endpoints.

   Note: The port `8080` is mapped to the `${SPRINGBOOT_APP_PORT}` specified in the `docker-compose.yml` file. Make sure to replace `${SPRINGBOOT_APP_PORT}` with the actual port number if you have modified it in the `docker-compose.yml` file.

4. Explore the API documentation and use the Swagger UI to interact with the endpoints.



## Additional Information

- The application uses JWT tokens for authentication. The tokens should be included in the `Authorization` header as a bearer token.
- The MySQL database is managed through a Docker container. The database configuration can be found in the `docker-compose.yml` file.
- The application uses Spring Security for securing the API endpoints and validating JWT tokens.
- The application follows the RESTful API design principles and returns appropriate HTTP status codes for responses.

## Conclusion

Congratulations! You have successfully set up and run the banking application. You can now explore the various
