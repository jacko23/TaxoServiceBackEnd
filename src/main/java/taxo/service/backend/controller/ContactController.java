package taxo.service.backend.controller;



import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import taxo.service.backend.model.Contact;
import taxo.service.backend.repository.ContactRepository;


@RestController
public class ContactController {	
	
	@Autowired
	private ContactRepository contactRepository;
	
	private static final Log LOG = LogFactory.getLog(ContactController.class);
	
	@GetMapping("/showcontacts")
	private Flux<Contact> showContacts() {
			
		LOG.debug("I dati sono stati registrati");
		
		return contactRepository.findAll();
	}
	
	@PostMapping("/contact")
	public Mono<Contact> createContact(@Valid @RequestBody Contact contact){
		
		return contactRepository.save(contact);
	}
	
	@GetMapping("/contact/{id}")
	public Mono<ResponseEntity<Contact>> getContactById(@PathVariable(value ="id") String id){
		
		return contactRepository.findById(id)
				.map(savedContact -> ResponseEntity.ok(savedContact))
				.defaultIfEmpty(ResponseEntity.notFound().build());
		
	}
	
	@DeleteMapping("/contactdel/{id}")
	public Mono<ResponseEntity<Void>> deleteContact(@PathVariable(value = "id") String id){
		
		return contactRepository.findById(id)
				.flatMap(existinContact -> 
				contactRepository.delete(existinContact)
					.then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
					)
					.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
}
