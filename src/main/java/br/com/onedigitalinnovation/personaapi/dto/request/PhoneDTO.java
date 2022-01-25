package br.com.onedigitalinnovation.personaapi.dto.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.onedigitalinnovation.personaapi.anums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {
	
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private PhoneType phoneType;
	
	private String number;

}
