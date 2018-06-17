package es.hospital.facade;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.mysql.cj.jdbc.exceptions.SQLError;

import es.hospital.business.IPacientesBusinessSrv;
import es.hospital.dao.IMedicosPacientesDaoSrv;
import es.hospital.dao.IPacientesDaoSrv;
import es.hospital.dao.IPersonalDaoSrv;
import es.hospital.dao.dto.Analisis;
import es.hospital.dao.dto.Article;
import es.hospital.dao.dto.MedicosPacientes;
import es.hospital.dao.dto.Paciente;
import es.hospital.dao.dto.PersonalHospital;
import es.hospital.dao.dto.Socios;
import es.hospital.facade.dto.AnalisisFacade;
import es.hospital.facade.dto.ConsultaFacade;
import es.hospital.facade.dto.ConsultaFacadeIn;
import es.hospital.facade.dto.Login;
import es.hospital.facade.dto.Medico;
import es.hospital.facade.dto.PacienteFacade;
import es.hospital.facade.dto.PacientesFacadeIn;
import es.hospital.facade.dto.SociosFacade;

@Controller
@RequestMapping("api")
public class PacientesSrv {

	@Autowired
	IPacientesBusinessSrv business;
	
	
	
	@GetMapping("pacientes")
	public ResponseEntity<?> getAllPacientes() {
		try {
			List<PacienteFacade> response = business.getAllPacientes();		
			if(response!=null) {
				return new ResponseEntity<List<PacienteFacade>>(response, HttpStatus.OK);			
			}else {
				return new ResponseEntity<List<PacienteFacade>>(HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>(e.getCause().toString(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("paciente/{id}")
	public ResponseEntity<?> getPaciente(@PathVariable("id") int idPaciente) {
		PacienteFacade response = business.getPaciente(idPaciente);		
		if(response!=null) {
			return new ResponseEntity<PacienteFacade>(response, HttpStatus.OK);			
		}else {
			return new ResponseEntity<String>("Paciente no encontrado",HttpStatus.NOT_FOUND);
		}
		
	}
	@PostMapping("paciente")
	public ResponseEntity<?> addPaciente(@RequestBody PacientesFacadeIn paciente, UriComponentsBuilder builder) {
		try {
			PacienteFacade response=business.addPaciente(paciente);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(builder.path("/paciente/{id}").buildAndExpand(response.getId()).toUri());
			return new ResponseEntity<PacienteFacade>(response, headers,HttpStatus.CREATED);			
		} catch (Exception sql) {
			return new ResponseEntity<String>(sql.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PutMapping("paciente/{id}")
	public ResponseEntity<?> updateArticle(@PathVariable("id") int idPaciente ,@RequestBody PacientesFacadeIn paciente, UriComponentsBuilder builder) {
		try {
			PacienteFacade response=business.updatePaciente(idPaciente,paciente);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(builder.path("/paciente/{id}").buildAndExpand(response.getId()).toUri());
			return new ResponseEntity<PacienteFacade>(response, HttpStatus.OK);			
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("paciente/{id}/consulta")
	public ResponseEntity<?> addConsulta(@PathVariable("id") int idPaciente,
			@RequestBody ConsultaFacadeIn historial, UriComponentsBuilder builder) {
		try {
			ConsultaFacade response=business.addConsulta(idPaciente,historial);
			return new ResponseEntity<ConsultaFacade>(response, HttpStatus.CREATED);			
		} catch (Exception sql) {
			return new ResponseEntity<String>(sql.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("paciente/consulta/{id}/analisis")
	public ResponseEntity<?> addAnalisis(@PathVariable("id") int idConsulta,
			@RequestBody AnalisisFacade analisis, UriComponentsBuilder builder) {
		try {
			ConsultaFacade response=business.addAnalisis(idConsulta,analisis);
			return new ResponseEntity<ConsultaFacade>(response, HttpStatus.CREATED);			
		} catch (Exception sql) {
			return new ResponseEntity<String>(sql.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("pacienteLogin")
	public ResponseEntity<?> checkLogin(@RequestBody Login login) {
		try {
			PacienteFacade response = business.checkLogin(login);		
			if(response!=null) {
				return new ResponseEntity<PacienteFacade>(response, HttpStatus.OK);			
			}else {
				return new ResponseEntity<String>("Login o contraseña incorrectos",HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	/*@GetMapping("pacientesmedico/{id}")
	public ResponseEntity<List<PacienteFacade>> getAllPacientesPorMedico(@PathVariable("id") int idMedico) {
		List<PacienteFacade> list = business.getAllPacientesPorMedico(idMedico);		
		return new ResponseEntity<List<PacienteFacade>>(list, HttpStatus.OK);
	}
	
	
	@GetMapping("consultas")
	public ResponseEntity<List<MedicosPacientes>> getAllConsultas() {
		List<MedicosPacientes> list = dao.getAllHistoriales();		
		return new ResponseEntity<List<MedicosPacientes>>(list, HttpStatus.OK);
	}
	
	@GetMapping("consulta/{id}")
	public ResponseEntity<MedicosPacientes> getConsulta(@PathVariable("id") int idConsulta) {
		MedicosPacientes response = dao.getHistoriales(idConsulta);		
		if(response!=null) {
			return new ResponseEntity<MedicosPacientes>(response, HttpStatus.OK);			
		}else {
			return new ResponseEntity<MedicosPacientes>(HttpStatus.NOT_FOUND);
		}
	}*/
	
	
	
	/*@GetMapping("medicos")
	public ResponseEntity<List<Medico>> getAllMedicos() {
		List<Medico> list = daoPer.getAllMedicos();		
		return new ResponseEntity<List<Medico>>(list, HttpStatus.OK);
	}
	
	@GetMapping("administradores")
	public ResponseEntity<List<PersonalHospital>> getAllAdmin() {
		List<PersonalHospital> list = daoPer.getAllAdministradores();		
		return new ResponseEntity<List<PersonalHospital>>(list, HttpStatus.OK);
	}*/
}
