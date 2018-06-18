package es.hospital.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.hospital.dao.dto.Analisis;
@Transactional
@Repository
public class AnalisisDaoSrvImpl implements IAnalisisDaoSrv {
	@PersistenceContext	
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")	
	@Override
	public List<Analisis> getAllAnalisis() {
		String hql = "FROM Analisis";
		return (List<Analisis>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Analisis getAnalisisById(int id_analisis) {
		return entityManager.find(Analisis.class, id_analisis);
	}

}
