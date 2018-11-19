package taxo.service.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import taxo.service.backend.repository.ContactRepository;
@EntityScan("taxo.service.backend.model")
@ComponentScan(basePackages = "taxo.service.backend")
@EnableReactiveMongoRepositories(basePackageClasses = ContactRepository.class)
@SpringBootApplication
public class TaxoServiceBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxoServiceBackEndApplication.class, args);
	}
}
