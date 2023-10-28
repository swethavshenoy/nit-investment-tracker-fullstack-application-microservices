package com.natwest.userauth.repository;

import com.natwest.userauth.model.UserAuth;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserAuthRepositoryTest {

    @Autowired
    private UserAuthRepository userAuthRepository;

    @Test
    @Transactional
     void testFindByEmailId() {
        UserAuth userAuth = new UserAuth();
        userAuth.setEmailid("test@example.com");
        userAuth.setProfileid(BigInteger.valueOf(1));
        userAuth.setFname("John");
        userAuth.setLname("Doe");
        userAuth.setDob(LocalDate.of(1990, 1, 1));
        userAuth.setAddress("123 Main St");
        userAuth.setGender("Male");
        userAuth.setUsertype("User");
        userAuth.setPhoneno(new BigDecimal("1234567890"));
        userAuth.setPassword("password");

        userAuthRepository.save(userAuth);

        UserAuth foundUserAuth = userAuthRepository.findById("test@example.com").orElse(null);

        assertNotNull(foundUserAuth);
        assertEquals("test@example.com", foundUserAuth.getEmailid());
    }
}
