package es.hospital.business;

import es.hospital.dao.dto.PersonalHospital;
import es.hospital.facade.dto.Login;
import es.hospital.facade.dto.Medico;
import es.hospital.facade.dto.PacienteFacade;

public interface IPersonalBusinessImpl {

	PersonalHospital getPersonal(int idPersonal);
	Medico addMedico(Medico medico);
	Medico updateMedico(int idMedico, Medico medico);
	PersonalHospital checkLogin(Login login);

}
