package nus.iss.edu.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import static nus.iss.edu.server.Constants.*;

@Configuration
public class MongoConfig {

     // Inject the mongo connection string
     @Value("${mongo.url}")
     private String mongoUrl;
 
     // Create and initialize MongoTemplate
     @Bean(name = DATABASE_MONGO)
     public MongoTemplate createMongoTemplate() {
         // Create a MongoClient with the mongo connection string
         MongoClient client = MongoClients.create(mongoUrl);
         return new MongoTemplate(client, DATABASE_MONGO);
     }
    
}
