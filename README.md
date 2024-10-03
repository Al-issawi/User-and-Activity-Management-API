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

- Clone the repository:

bash
Copy code
git clone https://github.com/yAl-issawi/User-and-Activity-Management-API
Navigate to the project directory:

bash
  Copy code
  cd user-activity-api
  Build the project using Maven:

bash
  Copy code
  mvn clean install
  Run the application:

bash
    Copy code
    mvn spring-boot:run
    API Endpoints
    User Registration
    Endpoint: /appActivities/users/register

Method: POST

Request Body:

json
Copy code
{
    "firstname": "mmm",
    "lastname": "sss",
    "age": 30,
    "email": "mm.sss@example.com"
}

Response:
json
Copy code
{
    "message": "User registered successfully!"
}
Activity Registration
Endpoint: /appActivities/activities

Method: POST

Request Body:

json
Copy code
{
    "name": "Yoga Class",
    "date": "2024-10-10T10:00:00",
    "description": "A relaxing yoga session for beginners."
}

Response:

json
Copy code
{
    "message": "Activity registered successfully!"
}

Running the Application
Make sure you have Java and Maven installed on your machine. You can verify the installations with:

bash
    Copy code
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
mysql> select activity_user;
ERROR 1054 (42S22): Unknown column 'activity_user' in 'field list'
mysql> select * from activity_user;
+---------+-------------+
| user_id | activity_id |
+---------+-------------+
|       6 |           5 |
+---------+-------------+
1 row in set (0.00 sec)


