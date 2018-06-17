package es.hospital.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.hospital.dao.dto.MedicosPacientes;
import es.hospital.dao.dto.Paciente;
import es.hospital.dao.dto.Socios;

@Transactional
@Repository
public class MedicosPacientesDaoSrvImpl implements IMedicosPacientesDaoSrv {
	@PersistenceContext	
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MedicosPacientes> getAllHistoriales() {
		String hql = "FROM MedicosPacientes";
		return (List<MedicosPacientes>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public MedicosPacientes getHistoriale(int idConsulta) {
		return entityManager.find(MedicosPacientes.class, idConsulta);
	}

	@Override
	public List<MedicosPacientes> getAllHistorialesPorPaciente(int idPaciente) {
		String hql = "FROM MedicosPacientes mp where mp.idPaciente="+idPaciente+" order by mp.fecha desc";
		return (List<MedicosPacientes>) entityManager.createQuery(hql).getResultList();
	}

}
