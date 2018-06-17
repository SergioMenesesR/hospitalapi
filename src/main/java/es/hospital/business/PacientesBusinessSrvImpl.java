package es.hospital.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.hospital.dao.IPacientesDaoSrv;
import es.hospital.dao.dto.MedicosPacientes;
import es.hospital.dao.dto.Paciente;
import es.hospital.dao.mapper.MapperDao;
import es.hospital.facade.dto.AnalisisFacade;
import es.hospital.facade.dto.ConsultaFacade;
import es.hospital.facade.dto.ConsultaFacadeIn;
import es.hospital.facade.dto.Login;
import es.hospital.facade.dto.PacienteFacade;
import es.hospital.facade.dto.PacientesFacadeIn;
@Service
public class PacientesBusinessSrvImpl implements IPacientesBusinessSrv {
	@Autowired
	IPacientesDaoSrv dao;
	@Autowired
	MapperDao mapper;
	
	@Override
	public List<PacienteFacade> getAllPacientes() {
		List<Paciente> res=dao.getAllPacientes();
		List<PacienteFacade> response = new ArrayList<PacienteFacade>();
		for (Paciente x : res) {
			response.add(mapper.converterToPacienteFacede(x));
		}
		return response;
	}

	@Override
	public List<PacienteFacade> getAllPacientesPorMedico(int idMedico) {
		// TODO Auto-generated method stub
		List<Paciente> res= dao.getAllPacientesPorMedico(idMedico);
		List<PacienteFacade> response = new ArrayList<PacienteFacade>();
		for (Paciente x : res) {
			response.add(mapper.converterToPacienteFacede(x));
		}
		return response;
	}

	@Override
	public PacienteFacade getPaciente(int idPaciente) {
		Paciente p=dao.getPaciente(idPaciente);
		return mapper.converterToPacienteFacede(p);
				
	}

	@Override
	public PacienteFacade addPaciente(PacientesFacadeIn paciente) {
		Paciente res=dao.addPaciente(paciente);
		return mapper.converterToPacienteFacede(res);
	}

	@Override
	public PacienteFacade updatePaciente(int idPaciente, PacientesFacadeIn paciente) {
		Paciente res=dao.updatePaciente(idPaciente, paciente);
		return mapper.converterToPacienteFacede(res);
	}

	@Override
	public ConsultaFacade addConsulta(int idPaciente, ConsultaFacadeIn historial) {
		MedicosPacientes mp=mapper.converterToHistorialDao(historial);
		mp.setFecha(new Date());
		mp.setIdPaciente(idPaciente);
		MedicosPacientes res=dao.addConsulta(mp);
		return mapper.converterToHistorial(res);
	}

	@Override
	public ConsultaFacade addAnalisis(int idConsulta, AnalisisFacade analisis) {
		MedicosPacientes res=dao.addAnalisis(idConsulta,analisis);
		return mapper.converterToHistorial(res);
	}

	@Override
	public PacienteFacade checkLogin(Login login) {
		Paciente p=dao.checkLogin(login);
		return mapper.converterToPacienteFacede(p);
	}
	
	

}
