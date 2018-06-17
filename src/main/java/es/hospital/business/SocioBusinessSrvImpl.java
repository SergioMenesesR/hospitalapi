package es.hospital.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import es.hospital.dao.ISocioDaoSrv;
import es.hospital.dao.dto.Socios;


@Service
public class SocioBusinessSrvImpl implements ISocioBusinessSrv {
	@Autowired
	private ISocioDaoSrv SocioDAO;
	
	@Override
	public List<Socios> getAllSocios() {
		return SocioDAO.getAllSocios();
	}

	@Override
	public Socios getSocioById(int socioId) {
		// TODO Auto-generated method stub
		return SocioDAO.getSociosById(socioId);
	}

	@Override
	public Socios addSocio(Socios socio) {
		Socios soc=SocioDAO.addSocios(socio);
	    return soc;	       
	}

	@Override
	public Socios updateSocio(Socios socio) {
		// TODO Auto-generated method stub
		return SocioDAO.updateSocios(socio);
	}

	@Override
	public void deleteSocio(int socioId) {
		SocioDAO.deleteSocios(socioId);

	}

}
