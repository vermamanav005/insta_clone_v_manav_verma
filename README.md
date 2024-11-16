# Insta-Clone User Management API

A simple backend application for user management in an Instagram-like application, built using **Spring Boot** with **Spring Security**, **JPA**, and **MySQL**.

---

## **Features**
- User registration with password encryption.
- Secure user authentication.
- CRUD operations on user data.
- Password hashing with **BCrypt**.
- Easily extendable and modular architecture.

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


