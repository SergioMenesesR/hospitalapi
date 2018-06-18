package es.hospital.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import es.hospital.business.IAnalisisBusinessSrv;
import es.hospital.dao.dto.Analisis;

@Controller
@RequestMapping("api")
public class AnalisisSrv {
	
	@Autowired
	private IAnalisisBusinessSrv analisisBusness;
	
	@GetMapping("analisis")
	public ResponseEntity<List<Analisis>> getAllAnalisis() {
		List<Analisis> list = analisisBusness.getAllAnalisis();		
		return new ResponseEntity<List<Analisis>>(list, HttpStatus.OK);
	}	
	
	
	@GetMapping("analisis/{id}")
	public ResponseEntity<Analisis> getAnalisisById(@PathVariable("id") Integer id) {
		Analisis response = analisisBusness.getAnalisisById(id);
		return new ResponseEntity<Analisis>(response, HttpStatus.OK);
	}
}
