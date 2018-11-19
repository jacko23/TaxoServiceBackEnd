package taxo.service.backend.controller;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import taxo.service.backend.model.Contact;
import taxo.service.backend.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;







@RestController
public class ContactController {	
	

	@Autowired
	private ContactRepository contactRepository;
	
	private static final Log LOG = LogFactory.getLog(ContactController.class);
	
	
	
	@GetMapping("/showcontacts")
	private Flux<Contact> showContacts() {
		
		/*
		Contact utente = new ---------------Contact();
		
		//String dataString = sdf.format(new Date());
		
		utente.setFirstName("Benedetta");
		utente.setSurname("Polaca");
		String dataBirth = "23/03/1990";
		utente.setDataOfBirth(dataBirth);
		utente.setBirthPlaceCity("Milano");
		utente.setBirthPlaceProvince("Milano");
		utente.setBirthPlaceCountry("Italia");
		utente.setGender("Femina");
		*/
		
		LOG.debug("I dati sono stati registrati");
		
		return contactRepository.findAll();
	}
}
