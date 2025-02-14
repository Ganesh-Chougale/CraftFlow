package com.GSC.BE_CraftFlow.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.GSC.BE_CraftFlow.Config.JwtProvider;
import com.GSC.BE_CraftFlow.Modal.User;
import com.GSC.BE_CraftFlow.Repository.UserRepository;
import com.GSC.BE_CraftFlow.Response.AuthResponse;
import com.GSC.BE_CraftFlow.Service.CustomeUserDetailsImpl;

@Controller
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CustomeUserDetailsImpl customeUserDetailsImpl;
	
	
	@PostMapping("/signup")
	public ResponseEntity<User>createUserHandler(@RequestBody User user) throws Exception{
		
		User isUserExists = userRepository.findByEmail(user.getEmail());
		
		if(isUserExists != null) {
			throw new Exception("email already linked with another account");
		}
		
		// creating new user
		User createUser = new User();
		
		// filling the user feilds
		createUser.setPassword(passwordEncoder.encode(user.getPassword()));
		createUser.setEmail(user.getEmail());
		createUser.setFullName(user.getFullName());
		
		// saving user to DB
		User savedUser = userRepository.save(createUser); 
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt = JwtProvider.generateToken(authentication);
		
		
		AuthResponse res = new AuthResponse();
		res.setMessage("Sign-Up success");
		res.setJwt(jwt);
		
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
}
