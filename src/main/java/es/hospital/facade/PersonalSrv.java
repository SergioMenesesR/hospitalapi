package es.hospital.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import es.hospital.business.IPersonalBusinessImpl;
import es.hospital.dao.dto.Paciente;
import es.hospital.dao.dto.PersonalHospital;
import es.hospital.dao.mapper.MapperDao;
import es.hospital.facade.dto.Admin;
import es.hospital.facade.dto.Login;
import es.hospital.facade.dto.Medico;
import es.hospital.facade.dto.PacienteFacade;

@Controller
@RequestMapping("api")
public class PersonalSrv {
	@Autowired
	MapperDao mapper;

	@Autowired
	IPersonalBusinessImpl business;
	@CrossOrigin
	@GetMapping("personal/{id}")
	public ResponseEntity<?> getPersonal(@PathVariable("id") int idPersonal) {
		PersonalHospital response = business.getPersonal(idPersonal);
		if (response != null) {
			if (response.getAdministrador()) {
				Admin res = mapper.converterToAdmin(response);
				return new ResponseEntity<Admin>(res, HttpStatus.OK);
			} else {
				Medico res = mapper.converterToMedico(response);
				return new ResponseEntity<Medico>(res, HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<String>("Paciente no encontrado", HttpStatus.NOT_FOUND);
		}

	}
	@CrossOrigin
	@GetMapping("medico/{id}/pacientes")
	public ResponseEntity<?> getPacientesPorMedico(@PathVariable("id") int idMedico) {
		List<Paciente> res = business.getPacientesPorMedico(idMedico);
		if (res != null) {
			List<PacienteFacade> response=new ArrayList<PacienteFacade>();
			for (Paciente x : res) {
				response.add(mapper.converterToPacienteFacede(x));
			}
			return new ResponseEntity<List<PacienteFacade>>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Pacientes no encontrados", HttpStatus.NOT_FOUND);
		}

	}

	@CrossOrigin
	@PostMapping("medico")
	public ResponseEntity<?> addMedico(@RequestBody Medico medico, UriComponentsBuilder builder) {
		try {
			Medico response = business.addMedico(medico);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(builder.path("/medico/{id}").buildAndExpand(response.getId()).toUri());
			return new ResponseEntity<Medico>(response, headers, HttpStatus.CREATED);
		} catch (Exception sql) {
			return new ResponseEntity<String>(sql.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@CrossOrigin
	@PutMapping("medico/{id}")
	public ResponseEntity<?> updateArticle(@PathVariable("id") int idMedico, @RequestBody Medico medico,
			UriComponentsBuilder builder) {
		try {
			Medico response = business.updateMedico(idMedico, medico);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(builder.path("/medico/{id}").buildAndExpand(response.getId()).toUri());
			return new ResponseEntity<Medico>(response, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@CrossOrigin
	@PostMapping("personalLogin")
	public ResponseEntity<?> checkLogin(@RequestBody Login login) {
		try {
			PersonalHospital response = business.checkLogin(login);
			if (response != null) {
				if (response.getAdministrador()) {
					Admin res = mapper.converterToAdmin(response);
					return new ResponseEntity<Admin>(res, HttpStatus.OK);
				} else {
					Medico res = mapper.converterToMedico(response);
					return new ResponseEntity<Medico>(res, HttpStatus.OK);
				}
			} else {
				return new ResponseEntity<String>("Login o contraseña incorrectos", HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
}
