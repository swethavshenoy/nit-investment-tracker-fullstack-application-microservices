package com.natwest.authapi.service;

import com.natwest.authapi.exception.UserNotFoundException;
import com.natwest.authapi.model.UserAuth;
import com.natwest.authapi.repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceAuthImplementation implements UserAuthService{

    @Autowired
    UserAuthRepository userAuthRepository;

    @Override
    public UserAuth getAUser(String emailid) throws UserNotFoundException {
        return userAuthRepository.findById(emailid).get();
    }

    @Override
    public UserAuth saveAUser(UserAuth userAuth) {
        return userAuthRepository.save(userAuth);
    }
}
