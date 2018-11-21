package taxo.service.backend;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import taxo.service.backend.model.Contact;
import taxo.service.backend.repository.ContactRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TaxoServiceBackEndApplicationTests {

	String uri = "http://localhost:8087";
	@Autowired
	ContactRepository contactRepository;
	
	@Test
	public void getShowContacts(){
		RestTemplate restTemplate = new RestTemplate();
		/*
		String resultMDB = restTemplate.getForObject(uri+"/showcontacts", String.class);
		System.out.println("Lista utenti : "+ resultMDB);
		*/
	}
	
	//@Test
	public void createContact() {
		Contact utente = new Contact();
		
		utente.setFirstName("Benedetta");
		utente.setSurname("Polaca");
		String dataBirth = "23/03/1990";
		utente.setDataOfBirth(dataBirth);
		utente.setBirthPlaceCity("Milano");
		utente.setBirthPlaceProvince("Milano");
		utente.setBirthPlaceCountry("Italia");
		utente.setGender("Femina");
		
		RestTemplate restTemplate = new RestTemplate();
		Contact risultato = restTemplate.postForObject(uri+"/contact", utente, Contact.class);
		System.out.println("New contact " + risultato.getFirstName()); 
	}
	
	//@Test
	public void getContactId(){
		Map<String,String> params= new HashMap<String, String>();
		params.put("id","5a855ac7701a390c1469afc7");
		RestTemplate restTemplate = new RestTemplate();
		Contact risultato = restTemplate.getForObject(uri+"/contact/{id}",Contact.class,params);
		System.out.println("Contatto ottenuto : "+risultato.getSurname());
	}

	//@Test
	public void deleteContact(){
		Map<String,String> params= new HashMap<String, String>();
		params.put("id","5a855ac7701a390c1469afc7");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri+"/contactdel/{id}",params);

		System.out.println("CONTACTO REMOVIDO : ");
	}
}
