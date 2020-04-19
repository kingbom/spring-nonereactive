package com.kingbom.spring.nonereactive.rest;

import com.kingbom.spring.nonereactive.domain.Transaction;
import com.kingbom.spring.nonereactive.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Lazy
@RestController
@RequiredArgsConstructor
public class TransactionResource {

    private final TransactionRepository transactionRepository;

    @PostMapping("/api/transactions")
    private Transaction saveTransaction(@RequestBody Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @GetMapping("/api/transactions")
    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    @GetMapping("/api/transactions/{id}")
    public Transaction getTransaction(@PathVariable String id) throws Exception {
        return transactionRepository.findById(id)
               .orElseThrow(() -> new Exception("Data notfond"));
    }
}
