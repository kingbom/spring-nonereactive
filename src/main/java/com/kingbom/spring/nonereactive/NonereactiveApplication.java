package com.kingbom.spring.nonereactive;

import com.kingbom.spring.nonereactive.domain.Transaction;
import com.kingbom.spring.nonereactive.repository.TransactionRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class NonereactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(NonereactiveApplication.class, args);
	}

	@Bean
	ApplicationRunner init(TransactionRepository repository) {
		String  userId = UUID.randomUUID().toString();

		Object[][] data = {
				{ null, userId, UUID.randomUUID().toString(), 305, Instant.now()},
				{ null, userId, UUID.randomUUID().toString(), 404, Instant.now()},
				{ null, userId, UUID.randomUUID().toString(), 503, Instant.now()},
				{ null, userId, UUID.randomUUID().toString(), 602, Instant.now()},
				{ null, userId, UUID.randomUUID().toString(), 701, Instant.now()}
		};

		return args -> {
			repository.deleteAll();

			List<Transaction> transactions = Stream.of(data)
				  .map(array -> new Transaction((String) array[0], (String) array[1], (String) array[2], (Integer) array[3], (Instant) array[4]))
				  .collect(Collectors.toList());

			repository.saveAll(transactions).stream().forEach(transaction -> System.out.println(String.format("saved -> %s", transaction.toString())));

		};
	}

}
