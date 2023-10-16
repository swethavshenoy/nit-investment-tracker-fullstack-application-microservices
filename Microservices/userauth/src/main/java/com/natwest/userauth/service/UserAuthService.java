package com.natwest.userauth.service;

import com.natwest.userauth.exception.UserNotFoundException;
import com.natwest.userauth.model.UserAuth;

import java.math.BigInteger;

public interface UserAuthService {

//    Get A user
    public UserAuth getAUser(String emailid) throws UserNotFoundException;

//   Put Usertype
    public UserAuth updateAUser(UserAuth userAuth);
//Post a user
    public UserAuth saveAUser(UserAuth userAuth);

}
