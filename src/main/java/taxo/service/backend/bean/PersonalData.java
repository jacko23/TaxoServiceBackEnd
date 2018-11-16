package taxo.service.backend.bean;

import java.util.Date;

public class PersonalData {

	private String firstName;
	private String surname;
	private String dataOfBirth;
	private String birthPlaceCity;
	private String birthPlaceProvince;
	private String birthPlaceCountry;
	private String Gender;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getBirthPlaceCity() {
		return birthPlaceCity;
	}

	public void setBirthPlaceCity(String birthPlaceCity) {
		this.birthPlaceCity = birthPlaceCity;
	}

	public String getBirthPlaceProvince() {
		return birthPlaceProvince;
	}

	public void setBirthPlaceProvince(String birthPlaceProvince) {
		this.birthPlaceProvince = birthPlaceProvince;
	}

	public String getBirthPlaceCountry() {
		return birthPlaceCountry;
	}

	public void setBirthPlaceCountry(String birthPlaceCountry) {
		this.birthPlaceCountry = birthPlaceCountry;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getDataOfBirth() {
		return dataOfBirth;
	}

	public void setDataOfBirth(String dataOfBirth) {
		this.dataOfBirth = dataOfBirth;
	}
	
	
}
