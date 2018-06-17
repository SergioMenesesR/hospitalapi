package es.hospital.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.hospital.dao.dto.Analisis;
import es.hospital.dao.dto.Article;
import es.hospital.dao.dto.MedicosPacientes;
import es.hospital.dao.dto.Paciente;
import es.hospital.dao.mapper.MapperDao;
import es.hospital.facade.dto.AnalisisFacade;
import es.hospital.facade.dto.ConsultaFacade;
import es.hospital.facade.dto.Login;
import es.hospital.facade.dto.PacienteFacade;
import es.hospital.facade.dto.PacientesFacadeIn;

@Transactional
@Repository
public class PacientesDaoSrvImpl implements IPacientesDaoSrv {
	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	MapperDao mapper;
	@Autowired IMedicosPacientesDaoSrv consultasDao;

	@SuppressWarnings("unchecked")
	@Override
	public List<Paciente> getAllPacientes() {
		String hql = "FROM Paciente";
		List<Paciente> res = entityManager.createQuery(hql).getResultList();
		return res;		 
	}

	@Override
	public List<Paciente> getAllPacientesPorMedico(int idMedico) {
		String hql = "FROM Paciente p where p.idPaciente in (select m.idPaciente from MedicosPacientes m where m.idPersonal="
				+ idMedico + ")";
		List<Paciente> res = entityManager.createQuery(hql).getResultList();		
		return res;
	}

	@Override
	public Paciente getPaciente(int idPaciente) {
		Paciente p = entityManager.find(Paciente.class, idPaciente);
		if (p != null) {
			return p;//mapper.converterToPacienteFacede(p);
		} else {
			return null;
		}
	}

	@Override
	public Paciente addPaciente(PacientesFacadeIn paciente) {
		Paciente p = mapper.converterToPacienteDao(paciente);
		p.setPass("1234");
		entityManager.persist(p);
		return p;
	}

	@Override
	public Paciente updatePaciente(int idPaciente,PacientesFacadeIn pa) {
		Paciente res= getPaciente(idPaciente);
		res.setAlergias(pa.getAlergias());
		res.setAntecedentesFamiliares(pa.getAntecedentesFamiliares());
		res.setApellido1(pa.getApellido1());
		res.setApellido2(pa.getApellido2());
		res.setCodPostal(pa.getCodPostal());
		res.setDireccion(pa.getDireccion());
		res.setDni(pa.getDni());
		res.setCorreo(pa.getEmail());
		res.setEnfermedades(pa.getEnfermedades());
		res.setNumMovil(pa.getMovil());
		res.setNombre(pa.getNombre());
		res.setNombrePersonaContacto(pa.getNomContacto());
		res.setNseguridadSocial(pa.getnSeguridadSocial());
		res.setNumTelf(pa.getnTelefono());
		res.setObservaciones(pa.getObservaciones());
		res.setRelacion(pa.getRelacion());
		res.setTelfContacto(pa.getTelfContacto());
		entityManager.flush();
		return res;
	}

	@Override
	public MedicosPacientes addConsulta(MedicosPacientes mp) {
		entityManager.persist(mp);
		return mp;
	}

	@Override
	public MedicosPacientes addAnalisis(int idConsulta, AnalisisFacade an) {
		Analisis analisis=new Analisis();
		analisis.setContenido(an.getContenido());
		entityManager.persist(analisis);
		MedicosPacientes mp=consultasDao.getHistoriale(idConsulta);
		mp.setAnalisis(analisis.getId_analisis()+"");
		return mp;
	}

	@Override
	public Paciente checkLogin(Login login) {
		String hql = "FROM Paciente p where p.correo='"+login.getEmail()+"' and p.pass='"+login.getPass()+"'";
		Paciente res = (Paciente) entityManager.createQuery(hql).getSingleResult();		
		return res;
	}

}
