package es.hospital.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.hospital.dao.dto.PersonalHospital;
import es.hospital.dao.mapper.MapperDao;
import es.hospital.dao.util.AlertasCorreo;
import es.hospital.dao.util.PasswordGenerator;
import es.hospital.facade.dto.Admin;
import es.hospital.facade.dto.Login;
import es.hospital.facade.dto.Medico;

@Transactional
@Repository
public class PersonalDaoSrvImpl implements IPersonalDaoSrv {
	@PersistenceContext	
	private EntityManager entityManager;
	
	@Autowired
	private MapperDao mapper;
	@Autowired
	AlertasCorreo correo;
	

	@Override
	public List<Medico> getAllMedicos() {
		String hql = "FROM PersonalHospital ph where ph.administrador=false";
		List<PersonalHospital> lista=entityManager.createQuery(hql).getResultList();
		List<Medico> response=new ArrayList<Medico>();			
		for (PersonalHospital x : lista) {
			response.add(mapper.converterToMedico(x));
		}
		return response;
	}
	
	@Override
	public Medico getMedico(int idMedico) {		
		PersonalHospital ph=entityManager.find(PersonalHospital.class, idMedico);
		if(!ph.getAdministrador()) {
			Medico medico=mapper.converterToMedico(ph);
			return medico;
		}
		return null; 
	}

	@Override
	public List<Admin> getAllAdministradores() {
		String hql = "FROM PersonalHospital ph where ph.administrador=true";
		List<PersonalHospital> lista=entityManager.createQuery(hql).getResultList();
		List<Admin> response=new ArrayList<Admin>();			
		for (PersonalHospital x : lista) {
			response.add(mapper.converterToAdmin(x));
		}
		return response;
	}

	@Override
	public Admin getAdmin(int idAdmin) {
		PersonalHospital ph=entityManager.find(PersonalHospital.class, idAdmin);
		if(!ph.getAdministrador()) {
			Admin admin=mapper.converterToAdmin(ph);
			return admin;
		}
		return null;
	}

	
	@Override
	public PersonalHospital getPersonal(int idPersonal) {
		// TODO Auto-generated method stub
		return entityManager.find(PersonalHospital.class, idPersonal);
	}

	@Override
	public Medico addMedico(Medico medico) {
		PersonalHospital ph=mapper.converterToPersonalHospital(medico);
		System.out.println("DNI: "+ph.getDni());
		ph.setPass(PasswordGenerator.getPassword(
				PasswordGenerator.MINUSCULAS+
				PasswordGenerator.MAYUSCULAS+
				PasswordGenerator.ESPECIALES,10));
		System.out.println("------Contraseña generada:  -"+ph.getPass()+"-");
		entityManager.persist(ph);	
		System.out.println("Todo OK");
//		if(ph!=null) {
//			String body="Bienvenido, su contraseña es: "+ph.getPass();
//			correo.sendEmail(ph.getCorreo(), AlertasCorreo.SUBJECT_NEW, body);
//		}
		return mapper.converterToMedico(ph);
	}

	@Override
	public Medico updateMedico(int idMedico, Medico medico) {
		PersonalHospital ph=getPersonal(idMedico);
		ph.setApellido1(medico.getApellido1());
		ph.setApellido2(medico.getApellido2());
		ph.setCorreo(medico.getCorreo());
		ph.setDni(medico.getNombre());
		ph.setEspecialidad(medico.getEspecialidad());
		ph.setNombre(medico.getNombre());
		entityManager.flush();
		return mapper.converterToMedico(ph);
	}

	@Override
	public PersonalHospital checkLogin(Login login) {
		String hql = "FROM PersonalHospital ph where ph.correo= '"+login.getEmail()+"' and ph.pass= '"+login.getPass()+"'";
		PersonalHospital res = (PersonalHospital) entityManager.createQuery(hql).getSingleResult();		
		return res;
	}
	
	
}
