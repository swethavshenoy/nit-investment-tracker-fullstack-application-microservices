package com.natwest.Repository;

import com.natwest.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository

public interface UserRepository extends MongoRepository<User, String> {


}
