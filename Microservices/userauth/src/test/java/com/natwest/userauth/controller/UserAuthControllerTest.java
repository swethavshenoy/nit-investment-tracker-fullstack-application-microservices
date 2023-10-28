package com.natwest.userauth.controller;

import com.natwest.userauth.exception.UserNotFoundException;
import com.natwest.userauth.model.UserAuth;
import com.natwest.userauth.service.UserAuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class UserAuthControllerTest {

    @InjectMocks
    private UserAuthController userAuthController;

    @Mock
    private UserAuthService userAuthService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAUser() throws UserNotFoundException {
        // Create a test user
        UserAuth testUser = new UserAuth();
        testUser.setEmailid("testuser@example.com");
        testUser.setFname("Test User");

        // Mock the service to return the test user
        when(userAuthService.getAUser(testUser.getEmailid())).thenReturn(testUser);

        // Call the controller method
        ResponseEntity<UserAuth> response = userAuthController.getAUser(testUser.getEmailid());

        // Assertions
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(testUser, response.getBody());
    }

    @Test
    void testUpdateAUser() {
        // Create a test user
        UserAuth testUser = new UserAuth();
        testUser.setEmailid("testuser@example.com");
        testUser.setFname("Test User");

        // Mock the service to return the test user after update
        when(userAuthService.updateAUser(any(UserAuth.class))).thenReturn(testUser);

        // Call the controller method
        ResponseEntity<UserAuth> response = userAuthController.updateAUser(testUser);

        // Assertions
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(testUser, response.getBody());
    }

    @Test
    void testSaveAUser() {
        // Create a test user
        UserAuth testUser = new UserAuth();
        testUser.setEmailid("testuser@example.com");
        testUser.setFname("Test User");

        // Mock the service to return the test user after saving
        when(userAuthService.saveAUser(any(UserAuth.class))).thenReturn(testUser);

        // Call the controller method
        ResponseEntity<UserAuth> response = userAuthController.saveAUser(testUser);

        // Assertions
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(testUser, response.getBody());
    }
}
