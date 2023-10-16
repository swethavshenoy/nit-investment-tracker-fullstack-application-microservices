package com.natwest.userauth.service;

import com.natwest.userauth.exception.UserNotFoundException;
import com.natwest.userauth.model.UserAuth;
import com.natwest.userauth.repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class UserServiceAuthImplementation implements UserAuthService{

    @Autowired
    private UserAuthRepository userAuthRepo;

    @Override
    public UserAuth getAUser(String emailid) throws UserNotFoundException {
        return userAuthRepo.findById(emailid).get();
    }

    @Override
    public UserAuth updateAUser(UserAuth userAuth) {
        String userEmail = userAuth.getEmailid();
        UserAuth userAuthInDB = userAuthRepo.findById(userEmail).get();

        userAuthInDB.setProfileid(userAuth.getProfileid());
        userAuthInDB.setFname(userAuth.getFname());
        userAuthInDB.setLname(userAuth.getLname());
        userAuthInDB.setDob(userAuth.getDob());
        userAuthInDB.setAddress(userAuth.getAddress());
        userAuthInDB.setGender(userAuth.getGender());
        userAuthInDB.setUsertype(userAuth.getUsertype());
        userAuthInDB.setPhoneno(userAuth.getPhoneno());
        userAuthInDB.setPassword(userAuth.getPassword());

        return userAuthRepo.save(userAuthInDB);
    }

    @Override
    public UserAuth saveAUser(UserAuth userAuth) {
        return userAuthRepo.save(userAuth);
    }
}
