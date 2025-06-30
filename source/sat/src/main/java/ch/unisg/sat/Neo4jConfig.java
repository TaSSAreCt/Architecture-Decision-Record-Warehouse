package ch.unisg.sat;

import org.neo4j.driver.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.core.DatabaseSelectionProvider;
import org.springframework.data.neo4j.core.ReactiveDatabaseSelectionProvider;
import org.springframework.data.neo4j.core.transaction.Neo4jTransactionManager;
import org.springframework.data.neo4j.core.transaction.ReactiveNeo4jTransactionManager;

@Configuration
public class Neo4jConfig {

    @Bean
    public ReactiveNeo4jTransactionManager reactiveTransactionManager(
            Driver driver,
            ReactiveDatabaseSelectionProvider databaseNameProvider) {
        return new ReactiveNeo4jTransactionManager(driver, databaseNameProvider);
    }

    @Bean
    public Neo4jTransactionManager transactionManager(
            Driver driver,
            DatabaseSelectionProvider databaseNameProvider) {
        return new Neo4jTransactionManager(driver, databaseNameProvider);
    }
}
