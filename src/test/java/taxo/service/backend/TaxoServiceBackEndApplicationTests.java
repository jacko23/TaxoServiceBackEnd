package taxo.service.backend;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import taxo.service.backend.repository.ContactRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TaxoServiceBackEndApplicationTests {

	String uri = "http://localhost:8090";
	@Autowired
	ContactRepository contactRepository;
	
	@Test
	public void getShowContacts() throws Exception{
		RestTemplate restTemplate = new RestTemplate();
		
		String resultMDB = restTemplate.getForObject(uri+"/showcontacts", String.class);
		System.out.println("Lista utenti : "+ resultMDB);
	}

}
