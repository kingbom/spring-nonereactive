package com.kingbom.spring.nonereactive.repository;

import com.kingbom.spring.nonereactive.domain.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
}
