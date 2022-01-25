package br.com.onedigitalinnovation.personaapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.onedigitalinnovation.personaapi.dto.request.PersonDTO;
import br.com.onedigitalinnovation.personaapi.entity.Person;

@Mapper
public interface PersonMapper {
	
	//PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
	PersonMapper INSTANCE = Mappers.getMapper( PersonMapper.class );
	
	@Mapping(target="birthDate", source="birthDate", dateFormat="dd-MM-yyyy")
	Person toModel(PersonDTO personDTO);
	
	PersonDTO toDTO(Person person);	
	

}
