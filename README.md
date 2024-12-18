
# Student App Documentation

## Introduction
This application is a secured Spring Boot-based application designed for user authentication and student-subject management. It uses JWT (JSON Web Token) for authentication. With the provided API endpoints, you can:
- Create and log in users.
- Create and retrieve students and subjects.

---

## API Endpoints

### 1. Authentication APIs

1. **User Sign-in**  
   - **Endpoint**: `/signin`  
   - **Method**: POST  
   - **Request Body**:
     ```json
     {
       "username": "your_username",
       "password": "your_password"
     }
     ```
   - **Response**:
     ```json
     {
       "username": "your_username",
       "roles": ["USER/ADMIN"],
       "jwtToken": "your_jwt_token"
     }
     ```
   - **Purpose**: Authenticates the user and generates a JWT token, which is required to access secured APIs.

---

### 2. Student Management APIs

1. **Add a Student**  
   - **Endpoint**: `/api/students`  
   - **Method**: POST  
   - **Request Body**:
     ```json
     {
       "name": "Student Name",
       "address": "Student Address",
       "subjects": [
         {"id": subject_id}
       ]
     }
     ```

     Use Jwt token for authorization in rejestration proces to send jwt use header ,to generate jwt use signin api
      Response:  Bearer your_jwt_token
      First Admin will add suject based on subject id student can register in subjects
   - **Response**: Saved Student Object

2. **Retrieve All Students**  
   - **Endpoint**: `/api/students`  
   - **Method**: GET  
   - **Response**: List of all saved students.

---

### 3. Subject Management APIs

1. **Add a Subject**  
   - **Endpoint**: `/api/subjects`  
   - **Method**: POST  
   - **Request Body**:
     ```json
     {
       "name": "Subject Name"
     }
     ```
          Use Jwt token for authorization in rejestration proces to send jwt use header ,to generate jwt use signin api
      Response:  Bearer your_jwt_token
   - **Response**: Saved Subject Object

2. **Retrieve All Subjects**  
   - **Endpoint**: `/api/subjects`  
   - **Method**: GET  
   - **Response**: List of all saved subjects.

---

### 4. Role-based Access APIs

1. **Admin-Specific API**  
   - **Endpoint**: `/admin`  
   - **Method**: GET  
   - **Access**: `ROLE_ADMIN`  
   - **Response**: `"Hello, Admin!"`

2. **User-Specific API**  
   - **Endpoint**: `/user`  
   - **Method**: GET  
   - **Access**: `ROLE_USER`  
   - **Response**: `"Hello, User!"`

---

## Setup Instructions

1. **Start the Application**:  
   Run the Spring Boot application via the main class `SecuritydemoApplication`.

2. **Database Configuration**:  
   - Default database: **H2 In-Memory**  
   - Access H2 console at `/h2-console` with credentials:
     - Username: `sa`
     - Password: `password`

3. **Authorization Token Setup**:
   - Sign in using `/signin`.
   - Copy the `jwtToken` from the response.
   - Add this token to the `Authorization` header in the format:
     ```
     Bearer your_jwt_token
     ```

---

## Important Notes

1. **Default Users**:
   - Admin:  
     - Username: `admin`  
     - Password: `adminPass`
   - User:  
     - Username: `user1`  
     - Password: `password1`

2. **Common Errors**:
   - **401 Unauthorized**:  
     Ensure valid JWT token is passed in the Authorization header.
   - **403 Forbidden**:  
     Check if the logged-in user has access rights to the endpoint.

3. **Environment Variables**:
   - Update `application.properties` for database and JWT secret key configurations.

---





Sample Data to Accses the api
Method Post:url : http://localhost:8080/signin
Use Body to send json data for generating the jwt token
{
    "username":"admin",
    "password":"adminPass"
}

=================================================
Method Post:url : http://localhost:8080/api/subjects
send jwt token in header as : key :Authorization value : Bearer jwt token

send subject that you want to add in body in form of json data
{
    "name": "Environmental Science "
}
Response the the subject you added with id ,this id will be used in student api to add subject
=============================================================================================
Method Get:url : http://localhost:8080/api/subjects
this will return all the added subjects
==================================================================================================
Method Post: url : http://localhost:8080/api/students
json data sample for student registration send jwt token in header as : key :Authorization value : Bearer jwt token
{
  "name": "Kumar Kumar",
  "address": "Indore India",
  "subjects": [ {"id": 5}, {"id": 6}]
}

 ==============================================================================================================
 Method Get: url : http://localhost:8080/api/students

 this will return all student registered

For any issues or further details, feel free to reach out.
