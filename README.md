# Hotel Management System

A comprehensive hotel management REST API built with Spring Boot and PostgreSQL that provides complete functionality for managing hotels, rooms, reservations, customers, billing operations, and staff management.

## Tech Stack

- **Backend**: Spring Boot 3.5.0, Java 21
- **Database**: PostgreSQL with Hibernate/JPA
- **Build Tool**: Maven
- **API**: RESTful web services with Spring MVC

## Prerequisites

- Java 21 or higher
- Maven 3.6 or higher
- PostgreSQL 12 or higher

## Setup Instructions

### 1. Clone the Repository
```shell script
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
Update the `src/main/resources/application.properties` file with your database credentials:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/gestion_hotelera
spring.datasource.username=your_username
spring.datasource.password=your_password
```


### 4. Run the Application
```shell script
mvn spring-boot:run
```


The application will start on `http://localhost:8080`

### 5. Database Schema
The application uses `spring.jpa.hibernate.ddl-auto=update`, so the database tables will be created automatically on first run.

## API Endpoints

### Hotels (`/hoteles`)

| Method | URL | Description | Request Body |
|--------|-----|-------------|--------------|
| `GET` | `/hoteles` | Get all hotels | None |
| `GET` | `/hoteles/{id}` | Get hotel by ID | None |
| `POST` | `/hoteles` | Create new hotel | Hotel JSON |
| `PUT` | `/hoteles` | Update hotel | Hotel JSON |
| `DELETE` | `/hoteles/{id}` | Delete hotel | None |

**Example - Create Hotel:**
```shell script
curl -X POST http://localhost:8080/hoteles \
  -H "Content-Type: application/json" \
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

| Method | URL | Description | Request Body |
|--------|-----|-------------|--------------|
| `GET` | `/tipos_habitacion` | Get all room types | None |
| `GET` | `/tipos_habitacion/{id}` | Get room type by ID | None |
| `POST` | `/tipos_habitacion` | Create new room type | Room Type JSON |
| `PUT` | `/tipos_habitacion` | Update room type | Room Type JSON |
| `DELETE` | `/tipos_habitacion/{id}` | Delete room type | None |

**Example - Create Room Type:**
```shell script
curl -X POST http://localhost:8080/tipos_habitacion \
  -H "Content-Type: application/json" \
  -d '{
    "id": 1,
    "nombre": "Suite Deluxe",
    "cantidad": 10
  }'
```


### Rooms (`/habitaciones`)

| Method | URL | Description | Request Body |
|--------|-----|-------------|--------------|
| `GET` | `/habitaciones` | Get all rooms | None |
| `GET` | `/habitaciones/{id}` | Get room by ID | None |
| `POST` | `/habitaciones` | Create new room | Room JSON |
| `PUT` | `/habitaciones` | Update room | Room JSON |
| `DELETE` | `/habitaciones/{id}` | Delete room | None |

**Example - Create Room:**
```shell script
curl -X POST http://localhost:8080/habitaciones \
  -H "Content-Type: application/json" \
  -d '{
    "id": 1,
    "numeroHabitacion": 101,
    "precioDia": 150,
    "disponible": true,
    "hotel": {"id": 1},
    "tipoHabitacion": {"id": 1}
  }'
```


### Customers (`/clientes`)

| Method | URL | Description | Request Body |
|--------|-----|-------------|--------------|
| `GET` | `/clientes` | Get all customers | None |
| `GET` | `/clientes/{id}` | Get customer by ID | None |
| `POST` | `/clientes` | Create new customer | Customer JSON |
| `PUT` | `/clientes` | Update customer | Customer JSON |
| `DELETE` | `/clientes/{id}` | Delete customer | None |

**Example - Create Customer:**
```shell script
curl -X POST http://localhost:8080/clientes \
  -H "Content-Type: application/json" \
  -d '{
    "id": 1,
    "primerNombre": "John",
    "segundoNombre": "Michael",
    "primerApellido": "Doe",
    "segundoApellido": "Smith",
    "cedula": "12345678",
    "direccion": "456 Main St, New York, NY"
  }'
```


### Reservations (`/reservas`)

| Method | URL | Description | Request Body |
|--------|-----|-------------|--------------|
| `GET` | `/reservas` | Get all reservations | None |
| `GET` | `/reservas/{id}` | Get reservation by ID | None |
| `POST` | `/reservas` | Create new reservation | Reservation JSON |
| `PUT` | `/reservas` | Update reservation | Reservation JSON |
| `DELETE` | `/reservas/{id}` | Delete reservation | None |

**Example - Create Reservation:**
```shell script
curl -X POST http://localhost:8080/reservas \
  -H "Content-Type: application/json" \
  -d '{
    "id": 1,
    "fechaInicio": "2024-07-15T14:00:00.000+00:00",
    "fechaFin": "2024-07-20T11:00:00.000+00:00",
    "cantidadDias": 5,
    "estado": true,
    "fechaReserva": "2024-07-01T10:00:00.000+00:00",
    "habitacion": {"id": 1},
    "cliente": {"id": 1}
  }'
```


### Invoices (`/facturas`)

| Method | URL | Description | Request Body |
|--------|-----|-------------|--------------|
| `GET` | `/facturas` | Get all invoices | None |
| `GET` | `/facturas/{id}` | Get invoice by ID | None |
| `POST` | `/facturas` | Create new invoice | Invoice JSON |
| `PUT` | `/facturas` | Update invoice | Invoice JSON |
| `DELETE` | `/facturas/{id}` | Delete invoice | None |

**Example - Create Invoice:**
```shell script
curl -X POST http://localhost:8080/facturas \
  -H "Content-Type: application/json" \
  -d '{
    "id": 1,
    "fechaEmision": "2024-07-15",
    "valorTotal": 750,
    "reserva": {"id": 1}
  }'
```


### Payments (`/pagos`)

| Method | URL | Description | Request Body |
|--------|-----|-------------|--------------|
| `GET` | `/pagos` | Get all payments | None |
| `GET` | `/pagos/{id}` | Get payment by ID | None |
| `POST` | `/pagos` | Create new payment | Payment JSON |
| `PUT` | `/pagos` | Update payment | Payment JSON |
| `DELETE` | `/pagos/{id}` | Delete payment | None |

**Example - Create Payment:**
```shell script
curl -X POST http://localhost:8080/pagos \
  -H "Content-Type: application/json" \
  -d '{
    "id": 1,
    "fecha": "2024-07-15T15:30:00.000+00:00",
    "metodoPago": "Credit Card",
    "pagoTotal": 750,
    "reserva": {"id": 1}
  }'
```


### Staff Management

#### Employees (`/empleados`)

| Method | URL | Description | Request Body |
|--------|-----|-------------|--------------|
| `GET` | `/empleados` | Get all employees | None |
| `GET` | `/empleados/{id}` | Get employee by ID | None |
| `POST` | `/empleados` | Create new employee | Employee JSON |
| `PUT` | `/empleados` | Update employee | Employee JSON |
| `DELETE` | `/empleados/{id}` | Delete employee | None |

#### Administrators (`/administradores`)

| Method | URL | Description | Request Body |
|--------|-----|-------------|--------------|
| `GET` | `/administradores` | Get all administrators | None |
| `GET` | `/administradores/{id}` | Get administrator by ID | None |
| `POST` | `/administradores` | Create new administrator | Administrator JSON |
| `PUT` | `/administradores` | Update administrator | Administrator JSON |
| `DELETE` | `/administradores/{id}` | Delete administrator | None |

#### General Administrators (`/administradores_generales`)

| Method | URL | Description | Request Body |
|--------|-----|-------------|--------------|
| `GET` | `/administradores_generales` | Get all general administrators | None |
| `GET` | `/administradores_generales/{id}` | Get general administrator by ID | None |
| `POST` | `/administradores_generales` | Create new general administrator | General Administrator JSON |
| `PUT` | `/administradores_generales` | Update general administrator | General Administrator JSON |
| `DELETE` | `/administradores_generales/{id}` | Delete general administrator | None |

#### Users (`/usuarios`)

| Method | URL | Description | Request Body |
|--------|-----|-------------|--------------|
| `GET` | `/usuarios` | Get all users | None |
| `GET` | `/usuarios/{id}` | Get user by ID | None |
| `POST` | `/usuarios` | Create new user | User JSON |
| `PUT` | `/usuarios` | Update user | User JSON |
| `DELETE` | `/usuarios/{id}` | Delete user | None |

## Response Format

All endpoints return JSON responses with appropriate HTTP status codes:
- `200 OK` - Successful GET, PUT requests
- `201 Created` - Successful POST requests
- `204 No Content` - Successful DELETE requests
- `404 Not Found` - Resource not found
- `400 Bad Request` - Invalid request data

## Testing

You can test the API using tools like:
- **Postman** - Import the endpoint collection
- **curl** - Use the examples provided above
- **Thunder Client** (VS Code extension)

## Database Schema

The system manages relationships between:
- Hotels ↔ Rooms
- Room Types ↔ Rooms
- Rooms ↔ Reservations
- Customers ↔ Reservations
- Reservations ↔ Invoices/Payments
- Various user roles and staff management

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request