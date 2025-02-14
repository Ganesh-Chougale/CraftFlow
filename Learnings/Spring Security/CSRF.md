# `CSRF`: Cross-Site Request Forgery  
CSRF (Cross-Site Request Forgery) is an attack where a malicious website tricks a logged-in user into performing unwanted actions on a trusted site without their consent.  

### How it works:  
1. User logs into a website (e.g., a banking site).  
2. The attacker tricks the user into clicking a malicious link or visiting a fake website.  
3. That site sends unauthorized requests (like transferring money) to the legitimate site using the user’s active session.  

### Prevention methods:  
- **CSRF Tokens**: Unique tokens in requests to verify authenticity.  
- **SameSite Cookies**: Restrict cookies from being sent with cross-site requests.  
- **Referer/Origin Checks**: Validate request sources.  
- **User Authentication Steps**: Re-authentication for sensitive actions.  

### **Scenario 1: `With CSRF (Vulnerable Application)`**  
#### **Situation:** Online Banking Fund Transfer  
1. **User logs into** their online banking (`bank.com`) and stays authenticated (session cookie stored).  
2. **Attacker sends a phishing email** with a malicious link like:  
   ```html
   <img src="https://bank.com/transfer?to=attacker&amount=10000" />
   ```
3. **User clicks the link**, and since they are already logged into `bank.com`, the request executes automatically, transferring money to the attacker **without user consent**.  

💀 **Attack succeeded! Money is stolen.**  

---

### **Scenario 2: `Without CSRF (Protected Application)`**  
#### **How the attack is prevented?**  
1. **User logs into** `bank.com`.  
2. **Attacker still sends the malicious link**, but `bank.com` has a CSRF token mechanism.  
3. When the request is received:  
   - **Server checks for a CSRF token** in the request.  
   - The attacker's request **does not have a valid CSRF token**, so the server **rejects the request**.  

✅ **Attack failed! The transaction is blocked.**  

---