# Hotel Management System

![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5.0-green)
![Java](https://img.shields.io/badge/Java-21-blue)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-12+-blue)

A comprehensive hotel management REST API built with Spring Boot and PostgreSQL that provides complete functionality for managing hotels, rooms, reservations, customers, billing operations, and staff management. The API is secured using JSON Web Tokens (JWT).

## Features

- **Hotel Management**: Create, read, update, and delete hotel information
- **Room Management**: Manage room types and individual rooms
- **Reservation System**: Handle bookings and room assignments
- **Customer Management**: Maintain guest profiles and information
- **Billing Operations**: Process payments and generate invoices
- **Staff Management**: Manage employee information and roles
- **JWT Security**: Secure authentication and authorization

## Tech Stack

- **Backend**: Spring Boot 3.5.0, Java 21, Spring Security
- **Database**: PostgreSQL with Hibernate/JPA
- **Build Tool**: Maven
- **API**: RESTful web services with Spring MVC

## Prerequisites

- Java 21 or higher
- Maven 3.6 or higher
- PostgreSQL 12 or higher

## Setup Instructions

### 1. Clone the Repository
```bash
git clone <repository-url>
cd hotelgestion
```

### 2. Database Setup
1. Install and start PostgreSQL
2. Create a database named `gestion_hotelera`:
```sql
CREATE DATABASE gestion_hotelera;
```

### 3. Configure Database Connection
Update `src/main/resources/application.properties` with your credentials:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/gestion_hotelera
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 4. Run the Application
```bash
mvn spring-boot:run
```
The application will start at: http://localhost:8080

> **Note**: The database tables will be created automatically on first run (`spring.jpa.hibernate.ddl-auto=update`).

## Security - JWT Authentication

All endpoints (except authentication) require a valid JWT token in the `Authorization` header.

### Authentication Endpoints

#### Sign Up
Create a new user:
```bash
curl -X POST http://localhost:8080/api/auth/signup/ \
  -H "Content-Type: application/json" \
  -d '{
    "username": "testuser",
    "password": "password123",
    "email": "test@example.com"
  }'
```

#### Login
Authenticate to receive a JWT:
```bash
curl -X POST http://localhost:8080/api/auth/login/ \
  -H "Content-Type: application/json" \
  -d '{
    "username": "testuser",
    "password": "password123"
  }'
```

Response:
```json
{
  "token": "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJ0...",
  "username": "testuser"
}
```

### Accessing Protected Endpoints
Include the token in the Authorization header:
```
Authorization: Bearer YOUR_JWT_TOKEN
```

## API Endpoints

### Hotels (`/hoteles`)
| Method | URL             | Description         | Request Body |
|--------|-----------------|---------------------|--------------|
| GET    | /hoteles        | Get all hotels      | None         |
| GET    | /hoteles/{id}   | Get hotel by ID     | None         |
| POST   | /hoteles        | Create new hotel    | Hotel JSON   |
| PUT    | /hoteles        | Update hotel        | Hotel JSON   |
| DELETE | /hoteles/{id}   | Delete hotel        | None         |

**Example - Create Hotel:**
```bash
curl -X POST http://localhost:8080/hoteles \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer YOUR_JWT_TOKEN" \
  -d '{
    "id": 1,
    "nombre": "Hotel Paradise",
    "ciudad": "Miami",
    "telefono": "+1-555-0123",
    "correo": "info@hotelparadise.com",
    "direccion": "123 Beach Ave, Miami, FL"
  }'
```

### Room Types (`/tipos_habitacion`)
| Method | URL                     | Description             | Request Body     |
|--------|-------------------------|-------------------------|------------------|
| GET    | /tipos_habitacion       | Get all room types      | None             |
| GET    | /tipos_habitacion/{id}  | Get room type by ID     | None             |
| POST   | /tipos_habitacion       | Create new room type    | Room Type JSON   |
| PUT    | /tipos_habitacion       | Update room type        | Room Type JSON   |
| DELETE | /tipos_habitacion/{id}  | Delete room type        | None             |

**Example - Create Room Type:**
```bash
curl -X POST http://localhost:8080/tipos_habitacion \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer YOUR_JWT_TOKEN" \
  -d '{
    "id": 1,
    "nombre": "Suite Deluxe",
    "cantidad": 10
  }'
```

### Additional Resources
- **Rooms**: `/habitaciones`
- **Customers**: `/clientes`
- **Reservations**: `/reservas`
- **Invoices**: `/facturas`
- **Staff**: `/empleados`

> All endpoints follow the same REST pattern as shown above and require JWT authentication.

## Response Format
- `200 OK`: Successful GET, PUT requests
- `201 Created`: Successful POST requests
- `204 No Content`: Successful DELETE requests
- `401 Unauthorized`: Authentication failed or token not provided
- `404 Not Found`: Resource not found
- `400 Bad Request`: Invalid request data

## Testing
Test the API using:
- [Postman](https://www.postman.com/)
- `curl` (examples provided above)
- [Thunder Client](https://www.thunderclient.com/) (VS Code extension)

## Database Schema
The system manages relationships between:
- Hotels ↔ Rooms
- Room Types ↔ Rooms
- Rooms ↔ Reservations
- Customers ↔ Reservations
- Reservations ↔ Invoices/Payments
- Users ↔ Roles (staff management)

## Contributing
1. Fork the repository
2. Create a feature branch (`git checkout -b feature/your-feature`)
3. Commit your changes (`git commit -m 'Add some feature'`)
4. Push to the branch (`git push origin feature/your-feature`)
5. Create a new Pull Request