package com.edithbga.poc;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edithbga.poc.domain.Users;
import com.edithbga.poc.repo.CustomRepository;
import com.edithbga.poc.repo.UserRepository;

import ch.qos.logback.classic.Logger;

@SpringBootApplication
public class MongoBootApplication implements CommandLineRunner {

	private static final Logger LOGGER=(Logger) LoggerFactory.getLogger(MongoBootApplication.class);

	@Autowired
	UserRepository repository;

	@Autowired
	CustomRepository crepo;

	public static void main(String[] args) {
		SpringApplication.run(MongoBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		deleteAll();
		addSampleData();
		listAll();
		findFirst();
		findByRegex();
	}

	public void deleteAll() {
		LOGGER.info("Deleting all records");

		repository.deleteAll();
	}

	public void addSampleData() {
		LOGGER.info("Adding sample data");

		repository.save(new Users("Edith Baga", "Canada", 99999d));
		repository.save(new Users("Angelica Garcia", "Mexico", 10101d));
		repository.save(new Users("Nancy Luna", "Peru", 11111d));
		repository.save(new Users("Sergio Mena", "Mexico", 12121d));
	}

	public void listAll() {
		LOGGER.info("Isting sample data");

		repository.findAll().forEach(u -> System.out.println(u));
	}

	public void findFirst() {
		LOGGER.info("Finding first by Name");

		Users u = repository.findFirstByName("Louise Litt");
		System.out.println(u);
	}

	public void findByRegex() {
		LOGGER.info("Finding by Regex - All with address starting with New");
		repository.findCustomByRegExAddress("New").forEach(u -> System.out.println(u));
	}
}
