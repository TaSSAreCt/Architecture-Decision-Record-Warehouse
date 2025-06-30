package ch.unisg.sat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class SatApplication {

	public static void main(String[] args) {
		SpringApplication.run(SatApplication.class, args);

	}

}
