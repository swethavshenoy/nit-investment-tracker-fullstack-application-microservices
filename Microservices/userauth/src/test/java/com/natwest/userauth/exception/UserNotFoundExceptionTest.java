package com.natwest.userauth.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserNotFoundExceptionTest {

    @Test
    void testToString() {
        // Create a UserNotFoundException instance
        UserNotFoundException exception = new UserNotFoundException();

        // Test the toString method
        String expectedMessage = "Email Id Not Found, Please Sign Up";
        String actualMessage = exception.toString();

        // Assert that the message returned by toString() matches the expected message
        assertEquals(expectedMessage, actualMessage);
    }
}
