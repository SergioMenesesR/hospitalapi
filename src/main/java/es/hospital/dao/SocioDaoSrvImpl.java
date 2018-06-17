package es.hospital.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.hospital.dao.dto.Article;
import es.hospital.dao.dto.Socios;



@Transactional
@Repository
public class SocioDaoSrvImpl implements ISocioDaoSrv {
	@PersistenceContext	
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Socios> getAllSocios() {
		String hql = "FROM Socios";
		return (List<Socios>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Socios getSociosById(int SociosId) {
		// TODO Auto-generated method stub
		return entityManager.find(Socios.class, SociosId);
	}

	@Override
	public Socios addSocios(Socios Socios) {
		entityManager.persist(Socios);
		
		return Socios;
	}

	@Override
	public Socios updateSocios(Socios socio) {
		Socios soc = getSociosById(socio.getId());
		soc.setNombre(socio.getNombre());
		entityManager.flush();
		return soc;
	}

	@Override
	public void deleteSocios(int SociosId) {
		entityManager.remove(getSociosById(SociosId));

	}

	@Override
	public boolean SociosExists(String title, String category) {
		// TODO Auto-generated method stub
		return false;
	}

}
