package saludconecta.citas.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "saludconecta.citas.infrastructure.adapters")
public class ConsultaMongoConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "consultas";
    }

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://database:27017"); // Docker container connection
    }

    @Override
    protected boolean autoIndexCreation() {
        return true; // Automatic index creation
    }
}
