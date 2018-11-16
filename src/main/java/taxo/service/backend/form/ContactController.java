package taxo.service.backend.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import taxo.service.backend.bean.PersonalData;


@RestController
public class ContactController {
	
	private static final Log LOG = LogFactory.getLog(ContactController.class);
	
	@GetMapping("/showcontacts")
	private PersonalData showContacts() throws ParseException {
		
		
		PersonalData utente = new PersonalData();
		
		//String dataString = sdf.format(new Date());
		
		utente.setFirstName("Benedetta");
		utente.setSurname("Polaca");
		String dataBirth = "23/03/1990";
		utente.setDataOfBirth(dataBirth);
		utente.setBirthPlaceCity("Milano");
		utente.setBirthPlaceProvince("Milano");
		utente.setBirthPlaceCountry("Italia");
		utente.setGender("Femina");
		return utente;
	}
	
	private Date convertDateLocale(String data) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dateResponse = new Date();
		try {
			
			 dateResponse = sdf.parse(data);
			 
		} catch (ParseException e) {

			e.printStackTrace();
		}
		
		return dateResponse;
	}

}
