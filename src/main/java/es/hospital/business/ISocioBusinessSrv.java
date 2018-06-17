package es.hospital.business;

import java.util.List;

import es.hospital.dao.dto.Socios;




public interface ISocioBusinessSrv {

	 List<Socios> getAllSocios();
	 Socios getSocioById(int socioId);
     Socios addSocio(Socios socio);
     Socios updateSocio(Socios socio);
     void deleteSocio(int socioId);
}
