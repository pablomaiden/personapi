package br.com.onedigitalinnovation.personaapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.onedigitalinnovation.personaapi.dto.request.PersonDTO;
import br.com.onedigitalinnovation.personaapi.dto.response.MessageResponseDTO;
import br.com.onedigitalinnovation.personaapi.entity.Person;
import br.com.onedigitalinnovation.personaapi.exception.PersonNotFoundException;
import br.com.onedigitalinnovation.personaapi.mapper.PersonMapper;
import br.com.onedigitalinnovation.personaapi.repository.PersonRepository;

@Service
public class PersonService {
		
	@Autowired
	private PersonRepository personRepository;
	
	private final PersonMapper personMapper = PersonMapper.INSTANCE;
	
	public MessageResponseDTO creatPerson(PersonDTO personDTO) {		
		Person personTosave = personMapper.toModel(personDTO);		
		Person personSaved  = personRepository.save(personTosave);
		return MessageResponseDTO.builder().message("Person criado ID->"+personSaved.getId()).build();		
	}

	public void deletePerson(Long id) {		
		Optional<Person> person = personRepository.findById(id);	
		if(person.isPresent()) {
			personRepository.delete(person.get());			
		}		
	}

	public void updateById(Long id, @Valid PersonDTO personDTO) {				
		Optional<Person> person = personRepository.findById(id);
		if(person.isPresent()) {
		   Person personToUpdate = personMapper.toModel(personDTO);			
		   personRepository.save(personToUpdate);			
		}		
	}	
	
	public PersonDTO findById(Long id) throws PersonNotFoundException {		
		Person person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
		return personMapper.toDTO(person); 		
	}
	
	public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }
	

}
