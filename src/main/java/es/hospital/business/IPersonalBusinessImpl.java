package es.hospital.business;

import java.util.List;

import es.hospital.dao.dto.Paciente;
import es.hospital.dao.dto.PersonalHospital;
import es.hospital.facade.dto.Login;
import es.hospital.facade.dto.Medico;

public interface IPersonalBusinessImpl {

	PersonalHospital getPersonal(int idPersonal);
	Medico addMedico(Medico medico);
	Medico updateMedico(int idMedico, Medico medico);
	PersonalHospital checkLogin(Login login);
	List<Paciente> getPacientesPorMedico(int idMedico);

}
