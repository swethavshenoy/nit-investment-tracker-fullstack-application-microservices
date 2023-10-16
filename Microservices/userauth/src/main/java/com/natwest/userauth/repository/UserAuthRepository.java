package com.natwest.userauth.repository;

import com.natwest.userauth.model.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth, String> {

}
