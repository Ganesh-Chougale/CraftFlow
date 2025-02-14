1. 
```sql
mysql -u root -p
-- enter your username & password
```  
2. 
```sql
CREATE DATABASE CraftFlow;
```  
3. 
```sql
show databases;
```  

4. 
```properties
spring.application.name=BE_CraftFlow

# MYSQL Driver Class
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/CraftFlow
spring.datasource.username=gorav
spring.datasource.password=gorav
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql: true

logging.pattern.console=%clr(%5p) %t --- %logger{36} --- %clr(%m) %n
```  