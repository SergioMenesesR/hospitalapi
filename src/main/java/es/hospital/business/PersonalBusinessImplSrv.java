package es.hospital.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.hospital.dao.IPacientesDaoSrv;
import es.hospital.dao.IPersonalDaoSrv;
import es.hospital.dao.dto.Paciente;
import es.hospital.dao.dto.PersonalHospital;
import es.hospital.facade.dto.Login;
import es.hospital.facade.dto.Medico;
@Service
public class PersonalBusinessImplSrv implements IPersonalBusinessImpl {

	@Autowired
	IPersonalDaoSrv dao;
	@Autowired
	IPacientesDaoSrv daoPaciente;
	
	
	
	@Override
	public PersonalHospital getPersonal(int idPersonal) {
		// TODO Auto-generated method stub
		return dao.getPersonal(idPersonal);
	}

	@Override
	public Medico addMedico(Medico medico) {
		// TODO Auto-generated method stub
		Medico response=dao.addMedico(medico);
		return response;
	}

	@Override
	public Medico updateMedico(int idMedico, Medico medico) {
		// TODO Auto-generated method stub
		return dao.updateMedico(idMedico, medico);
	}

	@Override
	public PersonalHospital checkLogin(Login login) {
		// TODO Auto-generated method stub
		return dao.checkLogin(login);
	}

	@Override
	public List<Paciente> getPacientesPorMedico(int idMedico) {
		// TODO Auto-generated method stub
		return daoPaciente.getAllPacientesPorMedico(idMedico);
	}

}
