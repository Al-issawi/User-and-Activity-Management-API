# User-and-Activity-Management-API
IT-acadimy, Activity.
This project is a RESTful API for managing users and activities. It allows users to register and manage their activities through a simple and intuitive interface.
the Project still need improvment.

## #Table of Contents
## Features
## Technologies Used
## Getting Started
## API Endpoints
## User Registration
## Activity Registration
## Running the Application

## Features
- User registration with validation.
- Activity management including registration and retrieval.
- Easy-to-use RESTful endpoints.
- Built with Spring Boot and Jakarta EE.
- Technologies Used
- Java 17
- Spring Boot
- JPA (Jakarta Persistence API)
- H2 Database (or your preferred database)
- Lombok (for boilerplate code reduction)
- Getting Started
   To get started with this project, follow these steps:

## Configure application properties in src/main/resources/application.properties:
      spring.datasource.url=jdbc:mysql://localhost:3306/activities_db
      spring.datasource.username=your_username
      spring.datasource.password=your_password
      spring.jpa.hibernate.ddl-auto=update


# Activities API

## Overview
The Activities API allows users to register, manage, and participate in various activities. It is built using Spring Boot and uses MySQL as the database for storing user and activity information.

## Features
- User Registration
- Activity Management
- User Participation in Activities

## Technologies Used
- Java 17
- Spring Boot
- MySQL
- Jakarta Validation

## Database
The application uses a MySQL database to store user and activity information. Ensure that you have a MySQL server running and create a database for the application.

### Database Schema
The following tables are used in the application:

1. **User**
   - `id` (bigint, primary key, auto-increment)
   - `first_name` (varchar(255), not null)
   - `last_name` (varchar(255), not null)
   - `age` (int, nullable)
   - `email` (varchar(255), not null)
   - `created_at` (datetime, not null)

2. **Activity**
   - Define the fields for the Activity entity as needed.

## API Endpoints

### User Registration
- **POST** `/users/register`
  - **Request Body:**
   
    {
      "first_name": "John",
      "last_name": "Doe",
      "age": 30,
      "email": "john.doe@example.com"
    }
    ```
  - **Response:**
    - Success: `{"message": "User registered successfully!"}`
    - Error: `{"error": "First name is required"}` (or other validation errors)

### Activity Management
- **GET** `/activities` - Retrieve all activities.
- **POST** `/activities` - Create a new activity.
- **GET** `/activities/{id}` - Retrieve an activity by ID.
- **PUT** `/activities/{id}` - Update an existing activity.
- **DELETE** `/activities/{id}` - Delete an activity by ID.

## Getting Started

### Prerequisites
- Java 17
- Maven
- MySQL Server

### Setup Instructions
1. Clone the repository:
 
   git clone https://your-repo-url.git
   cd activities


### Method: POST

1. Request Body:

   {
       "firstname": "mmm",
       "lastname": "sss",
       "age": 30,
       "email": "mm.sss@example.com"
   }
   
   Response:
   
      {
          "message": "User registered successfully!"
      }
      Activity Registration
      Endpoint: /appActivities/activities
      
      Method: POST
      
      Request Body:
      
 
         
         {
             "name": "Yoga Class",
             "date": "2024-10-10T10:00:00",
             "description": "A relaxing yoga session for beginners."
         }
         
         Response:

            {
                "message": "Activity registered successfully!"
            }
            
            Running the Application
            Make sure you have Java and Maven installed on your machine. You can verify the installations with:

         
             java -version
             mvn -version
             Once the app

## Create database and table activity_user in mysql:

mysql> select * from user;
+----+------+----------------------------+-------------------------+------------+-----------+
| id | age  | created_at                 | email                   | first_name | last_name |
+----+------+----------------------------+-------------------------+------------+-----------+
|  6 |   25 | 2024-10-03 21:13:49.000000 | alice.smith@example.com | Alice      | Smith     |
|  7 |   28 | 2024-10-03 21:13:49.000000 | bob.johnson@example.com | Bob        | Johnson   |
+----+------+----------------------------+-------------------------+------------+-----------+
2 rows in set (0.00 sec)

    mysql> select * from activities;
+----+----------------+------------------------------------------------------+---------+--------------+---------------------+
| id | title          | description                                          | user_id | max_capacity | created_at          |
+----+----------------+------------------------------------------------------+---------+--------------+---------------------+
|  5 | Sessió de Ioga | Classe de ioga per relaxar-se i estirar els músculs. |    NULL |           20 | 2024-10-03 22:13:08 |
+----+----------------+------------------------------------------------------+---------+--------------+---------------------+
1 row in set (0.00 sec)

## in mysql need to create table to join the two tables.as many to many.
mysql> select * from  activity_user;
+---------+-------------+
| user_id | activity_id |
+---------+-------------+
|       6 |           5 |
|       7 |           5 |
|       8 |           5 |
+---------+-------------+
3 rows in set (0.00 sec)

mysql>


