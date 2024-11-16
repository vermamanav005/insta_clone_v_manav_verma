
# Insta-Clone User Management API

A simple backend application for user management in an Instagram-like application, built using **Spring Boot** and **MySQL**.

---

## **Features**
- User registration.
- Secure user authentication.
- CRUD operations on user data.


---

## **API Endpoints**

| **HTTP Method** | **Endpoint**         | **Description**                  | **Request Body**        |
|------------------|----------------------|----------------------------------|-------------------------|
| `GET`           | `/users`            | Get all users                    | None                    |
| `GET`           | `/users/{username}` | Find a user by their username    | None                    |
| `PUT`           | `/users`            | Update user details              | JSON object of `User`   |
| `DELETE`        | `/users/{id}`       | Delete a user by their ID        | None                    |

---

## **Request and Response Examples**

### **1. Get All Users**
**Request**:  
```
GET /users
```

**Response**:  
```json
[
  {
    "id": 1,
    "userName": "john_doe",
    "email": "john@example.com",
    "gender": "Male",
    "bio": "Hello, this is John!",
    "profileImagePath": "/images/john.jpg"
  },
  {
    "id": 2,
    "userName": "jane_doe",
    "email": "jane@example.com",
    "gender": "Female",
    "bio": "Hello, this is Jane!",
    "profileImagePath": "/images/jane.jpg"
  }
]
```

---

### **2. Find User by Username**
**Request**:  
```
GET /users/john_doe
```

**Response**:  
```json
{
  "id": 1,
  "userName": "john_doe",
  "email": "john@example.com",
  "gender": "Male",
  "bio": "Hello, this is John!",
  "profileImagePath": "/images/john.jpg"
}
```

---

### **3. Update User**
**Request**:  
```
PUT /users
Content-Type: application/json
```

**Request Body**:  
```json
{
  "id": 1,
  "userName": "john_doe",
  "email": "john_updated@example.com",
  "passwordHash": "new_password",
  "gender": "Male",
  "bio": "Updated bio for John",
  "profileImagePath": "/images/john_updated.jpg"
}
```

**Response**:  
```json
{
  "id": 1,
  "userName": "john_doe",
  "email": "john_updated@example.com",
  "gender": "Male",
  "bio": "Updated bio for John",
  "profileImagePath": "/images/john_updated.jpg"
}
```

---

### **4. Delete User**
**Request**:  
```
DELETE /users/1
```

**Response**:  
```json
"User deleted successfully."
```

---

## **Project Setup**

### **1. Prerequisites**
- **Java 17+**
- **Spring Boot**
- **MySQL Database**
- Maven or Gradle for dependency management.

### **2. Steps to Run**
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/insta-clone-api.git
   cd insta-clone-api
   ```
2. Update `application.properties` with your MySQL credentials:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/instaclone
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   ```
3. Build the project:
   ```bash
   mvn clean install
   ```
4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

---

## **Technologies Used**
- **Spring Boot**: For creating the APIs.
- **MySQL**: As the relational database.
- **Maven**: For dependency management.




