package com.natwest.userauth.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserNotFoundException extends Exception {
    private String message;

    @Override
    public String toString() {
        return "Email Id Not Found, Please Sign Up";
    }
}
