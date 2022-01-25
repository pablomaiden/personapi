package br.com.onedigitalinnovation.personaapi.exception;

public class PersonNotFoundException extends Exception {	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5225146117949684028L;

	public PersonNotFoundException(Long id) {
        super("Person not found with ID " + id);
    }

}
