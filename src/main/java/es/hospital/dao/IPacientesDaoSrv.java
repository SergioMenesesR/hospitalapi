package es.hospital.dao;

import java.util.List;

import es.hospital.dao.dto.MedicosPacientes;
import es.hospital.dao.dto.Paciente;
import es.hospital.facade.dto.AnalisisFacade;
import es.hospital.facade.dto.Login;
import es.hospital.facade.dto.PacienteFacade;
import es.hospital.facade.dto.PacientesFacadeIn;

public interface IPacientesDaoSrv {
	List<Paciente> getAllPacientes();
	List<Paciente> getAllPacientesPorMedico(int idMedico);
	Paciente getPaciente(int idPaciente);
	Paciente addPaciente(PacientesFacadeIn paciente);
	Paciente updatePaciente(int idPaciente, PacientesFacadeIn paciente);
	MedicosPacientes addConsulta(MedicosPacientes mp);
	MedicosPacientes addAnalisis(int idConsulta, AnalisisFacade analisis);
	Paciente checkLogin(Login login);
}
