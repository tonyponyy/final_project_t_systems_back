package com.dcs.jwt;

import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcs.dao.IUserDAO;
import com.dcs.dto.Role;
import com.dcs.dto.User;
import com.dcs.exception.UserNotFoundException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class JWTController {
    
	@Autowired
    private JWTService jwtService;
	@Autowired
	private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
	@Autowired
	private IUserDAO userRepository;

    @PostMapping("/login")
    public Object getTokenForAuthenticatedUser(@RequestBody JWTAuthenticationRequest authRequest){
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
	    System.out.println(authRequest.getUserName() + " " + authRequest.getPassword());
        if (authentication.isAuthenticated()){
            String token =  jwtService.generateToken(authRequest.getUserName());
            JSONObject jsonObject = new JSONObject("{\"token\": \"" + token + "\"}");
            jsonObject.put("token",token );
            return jsonObject.toMap();
        }
        else {
            throw new UserNotFoundException("Invalid user credentials");
        }

    }
    
    @PostMapping("/signup")
	public ResponseEntity<User> signup(@RequestBody SignUpRequest signUpRequest){
		
		User user = new User();

		
	    user.setName(signUpRequest.getFirstName());
	    user.setLastname(signUpRequest.getLastName());
	    user.setLastname2(signUpRequest.getLastName2());
	    user.setEmail(signUpRequest.getEmail());
		user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
		user.setRole(new Role(1,"user"));
		
	    System.out.println("Nuevo usuario registrado: " + user.toString());

		
		return ResponseEntity.ok(userRepository.save(user));
	}
}