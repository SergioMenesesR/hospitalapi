package es.hospital.business;

import java.util.List;

import es.hospital.facade.dto.AnalisisFacade;
import es.hospital.facade.dto.ConsultaFacade;
import es.hospital.facade.dto.ConsultaFacadeIn;
import es.hospital.facade.dto.Login;
import es.hospital.facade.dto.PacienteFacade;
import es.hospital.facade.dto.PacientesFacadeIn;

public interface IPacientesBusinessSrv {
	List<PacienteFacade> getAllPacientes();
	List<PacienteFacade> getAllPacientesPorMedico(int idMedico);
	PacienteFacade getPaciente(int idPaciente);
	PacienteFacade addPaciente(PacientesFacadeIn paciente);
	PacienteFacade updatePaciente(int idPaciente, PacientesFacadeIn paciente);
	ConsultaFacade addConsulta(int idPaciente, ConsultaFacadeIn historial);
	ConsultaFacade addAnalisis(int idConsulta, AnalisisFacade analisis);
	PacienteFacade checkLogin(Login login);
}
