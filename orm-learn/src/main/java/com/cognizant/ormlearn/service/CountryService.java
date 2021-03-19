package com.cognizant.ormlearn.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {
	
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Transactional
	public List<Country> getAllCountries() 
	{
		List<Country> countryList=(List<Country>)countryRepository.findAll();
		return countryList;
	}

	/*
	 * Hands on 6
	 * 
	 * Find a country based on country code
	 * 
	 * Create new method findCountryByCode() in CountryService with @Transactionalannotation
	 *  In findCountryByCode() method, perform the following steps:
	 * Method signature
	 * Get the country based on findById() built in method
	 * From the result, check if a country is found. If not found, throw CountryNotFoundException
	 * Use get() method to return the country fetched
	 * Include new test method in OrmLearnApplication to find a country based on country code and compare the country name to check if it is valid.
	 */
		@Transactional
		public Country findCountryByCode(String countryCode) throws CountryNotFoundException
		{
			
			Optional<Country> result = countryRepository.findById(countryCode);
			if (!result.isPresent()) {
				throw new CountryNotFoundException("Country not found!!");
			}
			else {
				Country country = result.get();
				return country;
			}
		}

		/*Hands on 7
		 *Add a new country
		 * Create new method in CountryService Invoke save() method of repository to get
		 * the country added.
		 */
		@Transactional
		public void addCountry(Country country) 
		{
			
			countryRepository.save(country);
		}

		/*Hands on 8

		*Update a country based on code
		 * Create a new method updateCountry() in CountryService with parameters code
		 * and name. Annotate this method with @Transactional. Implement following steps
		 * in this method.
		 * Get the reference of the country using findById() method in repository
		 *  In the country reference obtained, update the name of country using setter
		 * method
		 *  Call countryRepository.save() method to update the name
		 */
		@Transactional
		public void updateCountry(String countryCode,String name) 
		{
			Optional<Country> countryid = countryRepository.findById(countryCode);
			if (countryid.isPresent()) {

				Country country=countryid.get();
				country.setName(name);
				countryRepository.save(country);
			}
			
			
		}

		/*Hands on 9

		 *Delete a country based on code
		 * Create new method deleteCountry() in CountryService. Annotate this method
		 * with @Transactional.
		 *  In deleteCountry() method call deleteById() method of repository.
		 * Include new test method in OrmLearnApplication with following steps
		 * Call the delete method based on the country code during the add country
		 * hands on
		 * Check in database if the country is deleted
		 */
		@Transactional
		public void deleteCountry(String countryCode)
		{
			countryRepository.deleteById(countryCode);
		}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
