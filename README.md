# User Management System

A Spring Boot application that provides secure user management with role-based access control and JWT authentication.

## Features

### Authentication & Authorization
- JWT-based authentication
- Role-based access control (USER and ADMIN roles)
- Automatic admin user creation on startup
- Secure password encryption using BCrypt

### User Management Endpoints
1. Authentication Endpoints
   - `POST /api/v1/auth/register` - Register new user
   - `POST /api/v1/auth/authenticate` - Login and get JWT token

2. User Management Endpoints
   - `GET /api/v1/users` - List all users (Admin only)
   - `GET /api/v1/users/{id}` - Get user by ID
   - `PUT /api/v1/users/{id}` - Update user
   - `DELETE /api/v1/users/{id}` - Delete user

### Access Control
- Regular users can only view/modify their own information
- Admin users have full access to all user data
- Automatic admin user creation with predefined credentials

## Technical Stack

- Java 17
- Spring Boot 3.0.6
- Spring Security
- JWT Authentication
- PostgreSQL Database
- Liquibase for database migrations
- Swagger/OpenAPI for API documentation

## Prerequisites

1. Java 17 or higher
2. PostgreSQL 12 or higher
3. IntelliJ IDEA (recommended)
4. Maven 3.6 or higher

## Setup Instructions

### 1. Database Setup

1. Install PostgreSQL if not already installed
2. Create a new database for the application
3. Configure the `.env` file in the project root:
   ```properties
   PORT=8444
   DB_URL=jdbc:postgresql://localhost:5432/your_database_name
   DB_USERNAME=your_username
   DB_PASSWORD=your_password


### 2. Project Setup in IntelliJ IDEA
1. Clone the repository
2. Open IntelliJ IDEA
3. Go to File -> Open and select the project directory
4. Wait for Maven to download dependencies
5. Copy .env.example to .env and update the values
6. Enable annotation processing for Lombok:
7. Go to Settings -> Build, Execution, Deployment -> Compiler -> Annotation Processors
8. Check Enable annotation processing
9. Make sure PostgreSQL is running (Docker container recommanded and create the database as in your .env file)
10. Run the application:
- Find TaskManagerApp.java
- Right-click and select Run 'TaskManagerApp'
- Or use Maven: mvn spring-boot:run
11. The application will start on http://localhost:8080 where 8080 will be replaced with port set (If set) in the .env file
12. Access Swagger UI: http://localhost:8080/swagger-ui.html
13. Default admin credentials:
      ```properties
      Username: admin
      Password: Admin@123
API Testing with Swagger UI
Access Swagger UI at http://localhost:8080/swagger-ui.html
- Authenticate:
- Use /api/v1/auth/authenticate endpoint
- Enter admin credentials
- Copy the JWT token
- Click "Authorize" button at the top
- Enter token as: Bearer your_token_here
- Test the endpoints
## Security Rules
### Authentication:
- All endpoints except /api/v1/auth/** require authentication
- JWT tokens expire after 24 hours
### Authorization:
- Regular users can only access their own data
- Admin users can access all endpoints and data
- Attempting unauthorized access returns 403 Forbidden
# Database Schema
## The user table includes:

- id (Primary Key)
- username (Unique)
- email (Unique)
- password (BCrypt encrypted)
- role (USER/ADMIN)
- enabled
- created_at
- updated_at

## Error Handling
#### The application provides detailed error messages for:

- Invalid credentials
- Duplicate username/email
- Unauthorized access
- Resource not found
- Validation errors
- Logging
- Application logs are available in the console
- Admin user creation is logged on startup
- Authentication attempts are logged
### Additional Notes
- The application uses stateless authentication
- Passwords are never stored in plain text
