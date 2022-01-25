package br.com.onedigitalinnovation.personaapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.onedigitalinnovation.personaapi.anums.PhoneType;
import br.com.onedigitalinnovation.personaapi.dto.request.PersonDTO;
import br.com.onedigitalinnovation.personaapi.dto.request.PhoneDTO;
import br.com.onedigitalinnovation.personaapi.dto.response.MessageResponseDTO;
import br.com.onedigitalinnovation.personaapi.entity.Person;
import br.com.onedigitalinnovation.personaapi.entity.Phone;
import br.com.onedigitalinnovation.personaapi.repository.PersonRepository;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
	
	@Mock
    private PersonRepository personRepository;
	
	@InjectMocks
    private PersonService personService;
	
	    @Test
	    void testGivenPersonDTOThenReturnSavedMessage() {
	        PersonDTO personDTO = PersonDTO.builder()
	                .firstName("Pablo")
	                .lastName("Guimarães")
	                .cpf("91966078153")
	                .birthDate("04-04-2010")
	                .phones(Collections.singletonList(PhoneDTO.builder()
	                        .number("61991566857")
	                        .phoneType(PhoneType.MOBILE)
	                        .build()))
	                        .build();
	        
	        Person expectedSavedPerson = Person.builder()
	                .id(1L)
	                .firstName("Pablo")
	                .lastName("Guimarães")
	                .cpf("91966078153")
	                .birthDate(LocalDate.of(2010, 10, 1))
	                .phones(Collections.singletonList(Phone.builder()
	                        .id(1L)
	                        .number("61991566857")
	                        .phoneType(PhoneType.MOBILE)
	                        .build()))
	                        .build();
	        //when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);
	        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedPerson.getId());
	        MessageResponseDTO succesMessage = personService.creatPerson(personDTO);
	        assertEquals(expectedSuccessMessage, succesMessage);
	    }
	    
	    private MessageResponseDTO createExpectedMessageResponse(Long id) {
	        return MessageResponseDTO
	                .builder()
	                .message("Created person with ID " + id)
	                .build();
	    }


}
