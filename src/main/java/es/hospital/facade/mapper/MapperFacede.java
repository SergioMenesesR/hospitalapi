package es.hospital.facade.mapper;

import org.springframework.stereotype.Component;

import es.hospital.dao.dto.Socios;
import es.hospital.facade.dto.SociosFacade;

@Component
public class MapperFacede {
	
	public SociosFacade converterToSociosFacede(Socios socio) {
		SociosFacade socioFacade=new SociosFacade();
		
		socioFacade.setId(socio.getId());
		socioFacade.setNombre(socio.getNombre());
		socioFacade.setApellidos("muertooo");		
		return socioFacade;
	}

}
