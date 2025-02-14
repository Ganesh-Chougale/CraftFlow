# CORS: `Cross Origin Resourse Sharing`  
CORS is a security mechanism that controls how resources on a web server can be requested from a different origin (domain, protocol, or port) to prevent unauthorized cross-origin requests.  

### **Why is it needed?**  
By default, browsers block requests from different origins due to the **Same-Origin Policy (SOP)**. CORS allows trusted websites to bypass this restriction safely.  

### **`Example Scenarios`:**  
#### **1. Without CORS (Blocked Request)**  
- `frontend.com` (React app) tries to fetch data from `api.backend.com`.  
- Browser blocks the request due to SOP.  
- **Error:** `Access to fetch at 'api.backend.com' from origin 'frontend.com' has been blocked by CORS policy.`  

#### **2. With CORS (Allowed Request)**  
- `api.backend.com` enables CORS by adding a response header:  
  ```http
  Access-Control-Allow-Origin: https://frontend.com
  ```
- Now `frontend.com` can fetch data without issues.  

### **How to Enable CORS?**  
- **In Express (Node.js)**  
  ```js
  const cors = require('cors');
  app.use(cors({ origin: 'https://frontend.com' }));
  ```
- **In Spring Boot (Java)**  
  ```java
  @CrossOrigin(origins = "https://frontend.com")
  @RestController
  public class MyController { }
  ```