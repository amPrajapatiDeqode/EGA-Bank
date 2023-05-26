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
  "type": "DEPOSIT"
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
  "name": "John Doe",
  "email": "user@example.com",
  "password": "password"
}
```

## Additional Information

- The application uses JWT tokens for authentication. The tokens should be included in the `Authorization` header as a bearer token.
- The MySQL database is managed through a Docker container. The database configuration can be found in the `docker-compose.yml` file.
- The application uses Spring Security for securing the API endpoints and validating JWT tokens.
- The application follows the RESTful API design principles and returns appropriate HTTP status codes for responses.

## Conclusion

Congratulations! You have successfully set up and run the banking application. You can now explore the various
