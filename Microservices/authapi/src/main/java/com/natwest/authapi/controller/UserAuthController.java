package com.natwest.authapi.controller;

import com.natwest.authapi.config.JWTUtility;
import com.natwest.authapi.model.JWTRequest;
import com.natwest.authapi.model.JWTResponse;
import com.natwest.authapi.model.UserAuth;
import com.natwest.authapi.service.MyUserDetailService;
import com.natwest.authapi.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/authapi")
public class UserAuthController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JWTUtility jwtUtitlity;

    @Autowired
    MyUserDetailService userDetailService;

    @Autowired
    UserAuthService userAuthService;

    @PostMapping("/save")
    public ResponseEntity<UserAuth> saveAUser (@RequestBody UserAuth userAuth){
        return new ResponseEntity<UserAuth>(userAuthService.saveAUser(userAuth), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public JWTResponse login(@RequestBody JWTRequest request) throws Exception {

        try {

            manager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Wrong_Username_or_Password");
        }
        UserDetails userdetail = userDetailService.loadUserByUsername(request.getEmail());
        String generateToken = jwtUtitlity.generateToken(userdetail);
        return new JWTResponse(generateToken);
    }
}
