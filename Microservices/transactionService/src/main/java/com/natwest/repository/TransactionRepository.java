package com.natwest.repository;
import com.natwest.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


@Repository
@Service
public interface TransactionRepository extends MongoRepository<Transaction, String> {

    List<Transaction> findAllByEmailid(String emailid);
}
