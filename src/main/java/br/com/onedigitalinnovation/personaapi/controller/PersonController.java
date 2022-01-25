package br.com.onedigitalinnovation.personaapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.onedigitalinnovation.personaapi.dto.request.PersonDTO;
import br.com.onedigitalinnovation.personaapi.dto.response.MessageResponseDTO;
import br.com.onedigitalinnovation.personaapi.entity.Phone;
import br.com.onedigitalinnovation.personaapi.exception.PersonNotFoundException;
import br.com.onedigitalinnovation.personaapi.service.PersonService;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
		
	@Autowired
	private PersonService personService;
		
	@GetMapping
    public List<PersonDTO> listAll() {
        return personService.listAll();
    }
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {		
		return personService.creatPerson(personDTO);			
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePerson(@PathVariable Long id) {		
		personService.deletePerson(id);		
	}
	
	@PutMapping("/{id}")
	public void updateById(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) {		
		personService.updateById(id, personDTO);	
	}
	
	@GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException{
        return personService.findById(id);
    }
	
	

}
