package com.natwest.authapi.service;

import com.natwest.authapi.exception.UserNotFoundException;
import com.natwest.authapi.model.UserAuth;

public interface UserAuthService {

    //    Get A user
    public UserAuth getAUser(String emailid) throws UserNotFoundException;

    //    Save A User
    public UserAuth saveAUser(UserAuth userAuth);
}
