package br.com.onedigitalinnovation.personaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.onedigitalinnovation.personaapi.entity.Person;


@Repository
public interface PersonRepository extends JpaRepository<Person,Long>{
	
}
