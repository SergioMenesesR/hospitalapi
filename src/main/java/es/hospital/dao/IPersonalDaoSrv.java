package es.hospital.dao;

import java.util.List;

import es.hospital.dao.dto.PersonalHospital;
import es.hospital.facade.dto.Admin;
import es.hospital.facade.dto.Login;
import es.hospital.facade.dto.Medico;
import es.hospital.facade.dto.PacienteFacade;

public interface IPersonalDaoSrv {
	List<Medico> getAllMedicos();
	List<Admin> getAllAdministradores();
	Admin getAdmin(int idAdmin);
	Medico getMedico(int idMedico);
	PersonalHospital getPersonal(int idPersonal);
	Medico addMedico(Medico medico);
	Medico updateMedico(int idMedico, Medico medico);
	PersonalHospital checkLogin(Login login);
}
