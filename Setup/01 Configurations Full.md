## Step 1: Setting up Spring Security = Package `Config` :    
1. AppConfig.java
2. JwtConstant.java
3. JwtTokenValidator.java



setting up **Spring Security** with JWT-based authentication for your Craft Flow project.

---

## **1. `AppConfig.java` (Security Configuration)**  
This file configures **Spring Security**, enabling JWT authentication, CORS, and password encoding.

### **Key Points**
- **`@Configuration @EnableWebSecurity`** → Marks this class as a security configuration.
- **`SecurityFilterChain` Bean** → Defines security settings:
  - **Disables CSRF** (`csrf.disable()`) because JWT handles authentication.
  - **CORS Configuration** (`cors.configurationSource(corsConfigurationSource())`).
  - **Requires authentication for API endpoints** (`/api/**`).
  - **Adds JWT Validation Filter** (`addFilterBefore(new JwtTokenValidator(), BasicAuthenticationFilter.class)`).
  - **Uses Stateless Sessions** (`SessionCreationPolicy.STATELESS`).
- **CORS Configuration (`corsConfigurationSource()`)** → Allows requests from frontend (`React`, `Vite`, `Angular`).
- **Password Encoder (`BCryptPasswordEncoder`)** → Hashes passwords securely.

---

## **2. `JwtConstant.java` (JWT Constants)**
Defines **JWT Secret Key** and **Authorization Header Name**.

### **Key Points**
- **`SECRET_KEY`** → Used for signing and verifying JWTs.
- **`JWT_HEADER`** → The header where the JWT is expected in requests (`Authorization`).

---

## **3. `JwtTokenValidator.java` (JWT Filter)**
A **Spring Security filter** that verifies JWT tokens.

### **How it Works**
1. **Extracts JWT from `Authorization` Header**.
2. **Removes "Bearer "** (first 7 characters).
3. **Verifies the JWT using `SECRET_KEY`**.
4. **Extracts User Email & Authorities from the Token**.
5. **Creates an Authentication Object** and sets it in `SecurityContextHolder`.
6. **Passes the request to the next filter**.

### **Important Classes Used**
- **`OncePerRequestFilter`** → Ensures this filter runs once per request.
- **`Jwts.parserBuilder()`** → Parses and verifies the JWT.
- **`SecurityContextHolder`** → Stores authentication details for the request.

---

## **Final Summary**
- `AppConfig.java` → Configures security, JWT filter, CORS, and password encoding.
- `JwtConstant.java` → Stores JWT-related constants.
- `JwtTokenValidator.java` → Intercepts requests, verifies JWT, and sets authentication.

Let me know if you need more details! 🚀