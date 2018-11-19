package taxo.service.backend.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import taxo.service.backend.model.Contact;

@Repository
public interface ContactRepository  extends ReactiveMongoRepository<Contact, String> {

}
