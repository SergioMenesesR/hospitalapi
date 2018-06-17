package es.hospital.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import es.hospital.business.ISocioBusinessSrv;
import es.hospital.dao.dto.Article;
import es.hospital.dao.dto.Socios;
import es.hospital.facade.dto.SociosFacade;
import es.hospital.facade.mapper.MapperFacede;

@Controller
@RequestMapping("api")
public class SocioSrv {

	@Autowired
	private ISocioBusinessSrv socioBusiness;
	
	@Autowired
	private MapperFacede mapper;
	@GetMapping("socios")
	public ResponseEntity<List<SociosFacade>> getAllArticles() {
		List<Socios> list = socioBusiness.getAllSocios();
		List<SociosFacade> lista=new ArrayList<SociosFacade>();
		
		for (Socios socio : list) {
			lista.add(mapper.converterToSociosFacede(socio));
		}
		
		return new ResponseEntity<List<SociosFacade>>(lista, HttpStatus.OK);
	}	
	
	@PostMapping("socios")
	public ResponseEntity<SociosFacade> addArticle(@RequestBody Socios socio, UriComponentsBuilder builder) {
        //boolean flag = socioBusiness.addSocio(socio);
        Socios soc =socioBusiness.addSocio(socio);
        SociosFacade so=mapper.converterToSociosFacede(socio);
        /*if (flag == false) {
        	return new ResponseEntity<SociosFacade>(HttpStatus.CONFLICT);
        }*/
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/socio/{id}").buildAndExpand(socio.getId()).toUri());
        return new ResponseEntity<SociosFacade>(so,headers, HttpStatus.CREATED);
	}
	
	@PutMapping("socio")
	public ResponseEntity<Socios> updateArticle(@RequestBody Socios socio) {
		Socios response=socioBusiness.updateSocio(socio);
		return new ResponseEntity<Socios>(response, HttpStatus.OK);
	}
	@DeleteMapping("socio/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		socioBusiness.deleteSocio(id);;
		return new ResponseEntity<Void>(HttpStatus.OK);
	}	
	
	@GetMapping("socio/{id}")
	public ResponseEntity<Socios> getArticleById(@PathVariable("id") Integer id) {
		Socios response = socioBusiness.getSocioById(id);
		return new ResponseEntity<Socios>(response, HttpStatus.OK);
	}
	
	
	
	
	
	
}
