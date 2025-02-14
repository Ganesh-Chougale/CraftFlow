## Step 1: Setting up Spring Security = Package `Config` :    
1. AppConfig.java
2. JwtConstant.java
3. JwtTokenValidator.java


## **1. `AppConfig.java` (Security Configuration)**  
This file configures **Spring Security**, enabling JWT authentication, CORS, and password encoding.

`CSRF` : disable session base token security.    
`CORS` : by default browser refuse to communicate with third party links, we pass the allowed links here.  
`PasswordEncoder` : encrypt password text & store it into DB, matches the password text & encrypted password for validation within same parameter box  


## **2. `JwtConstant.java` (JWT Constants)**
Defines **JWT Secret Key** and **Authorization Header Name**.

hold `SECRET_KEY` & `HEADER` ("Authorization") text  

## **3. `JwtTokenValidator.java` (JWT Filter)**
A **Spring Security filter** that verifies JWT tokens.  

