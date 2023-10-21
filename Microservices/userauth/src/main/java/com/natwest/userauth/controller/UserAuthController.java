package com.natwest.userauth.controller;

import com.natwest.userauth.exception.UserNotFoundException;
import com.natwest.userauth.model.UserAuth;
import com.natwest.userauth.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("user-auth")
public class UserAuthController {

    @Autowired
    private UserAuthService userAuthServ;

    @GetMapping("/user/{emailid}")
    public ResponseEntity<UserAuth> getAUser(@PathVariable String emailid) throws UserNotFoundException {
        return new ResponseEntity<UserAuth>(userAuthServ.getAUser(emailid), HttpStatus.OK);
    }

    @PutMapping("/update-user")
    public ResponseEntity<UserAuth> updateAUser(@RequestBody UserAuth userAuth) {
        return new ResponseEntity<UserAuth>(userAuthServ.updateAUser(userAuth), HttpStatus.ACCEPTED);
    }

    @PostMapping("/save-user")
    public ResponseEntity<UserAuth> saveAUser(@RequestBody UserAuth userAuth) {
        return new ResponseEntity<UserAuth>(userAuthServ.saveAUser(userAuth), HttpStatus.CREATED);
    }

}
