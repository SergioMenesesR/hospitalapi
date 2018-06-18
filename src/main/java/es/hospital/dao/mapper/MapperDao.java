package es.hospital.dao.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.hospital.dao.IAnalisisDaoSrv;
import es.hospital.dao.IMedicosPacientesDaoSrv;
import es.hospital.dao.IPersonalDaoSrv;
import es.hospital.dao.dto.MedicosPacientes;
import es.hospital.dao.dto.Paciente;
import es.hospital.dao.dto.PersonalHospital;
import es.hospital.facade.dto.Admin;
import es.hospital.facade.dto.ConsultaFacade;
import es.hospital.facade.dto.ConsultaFacadeIn;
import es.hospital.facade.dto.Medico;
import es.hospital.facade.dto.PacienteFacade;
import es.hospital.facade.dto.PacientesFacadeIn;

@Component
public class MapperDao {
	@Autowired
	IMedicosPacientesDaoSrv historialDao;
	@Autowired
	IAnalisisDaoSrv analisisDao;
	@Autowired IPersonalDaoSrv medicoDao;
	
	public PersonalHospital converterToPersonalHospital(Medico medico) {
		PersonalHospital ph=new PersonalHospital();
		ph.setApellido1(medico.getApellido1());
		ph.setApellido2(medico.getApellido2());
		ph.setCorreo(medico.getCorreo());
		ph.setDni(medico.getDni());
		ph.setEspecialidad(medico.getEspecialidad());
		ph.setNombre(medico.getNombre());
		ph.setAdministrador(false);		
		return ph;
	}

	public Paciente converterToPacienteDao(PacientesFacadeIn pa) {
		Paciente res= new Paciente();
		res.setAlergias(pa.getAlergias());
		res.setAntecedentesFamiliares(pa.getAntecedentesFamiliares());
		res.setApellido1(pa.getApellido1());
		res.setApellido2(pa.getApellido2());
		res.setCodPostal(pa.getCodPostal());
		res.setDireccion(pa.getDireccion());
		res.setDni(pa.getDni());
		res.setCorreo(pa.getEmail());
		res.setEnfermedades(pa.getEnfermedades());
		res.setId_paciente(pa.getId());
		res.setNumMovil(pa.getMovil());
		res.setNombre(pa.getNombre());
		res.setNombrePersonaContacto(pa.getNomContacto());
		res.setNseguridadSocial(pa.getnSeguridadSocial());
		res.setNumTelf(pa.getnTelefono());
		res.setObservaciones(pa.getObservaciones());
		res.setRelacion(pa.getRelacion());
		res.setTelfContacto(pa.getTelfContacto());
		
		return res;
	}
	
	public PacienteFacade converterToPacienteFacede(Paciente pa) {
		PacienteFacade res = new PacienteFacade();

		res.setAlergias(pa.getAlergias());
		res.setAntecedentesFamiliares(pa.getAntecedentesFamiliares());
		res.setApellido1(pa.getApellido1());
		res.setApellido2(pa.getApellido2());
		res.setCodPostal(pa.getCodPostal());
		res.setDireccion(pa.getDireccion());
		res.setDni(pa.getDni());
		res.setEmail(pa.getCorreo());
		res.setEnfermedades(pa.getEnfermedades());
		res.setId(pa.getId_paciente());
		res.setMovil(pa.getNumMovil());
		res.setNombre(pa.getNombre());
		res.setNomContacto(pa.getNombrePersonaContacto());
		res.setnSeguridadSocial(pa.getNseguridadSocial());
		res.setnTelefono(pa.getNumTelf());
		res.setObservaciones(pa.getObservaciones());
		res.setRelacion(pa.getRelacion());
		res.setTelfContacto(pa.getTelfContacto());
		List<MedicosPacientes> listaHistoriales = historialDao.getAllHistorialesPorPaciente(res.getId());
		List<ConsultaFacade> historialesPaciente = new ArrayList<ConsultaFacade>();
		for (MedicosPacientes x : listaHistoriales) {
			historialesPaciente.add(converterToHistorial(x));
		}
		res.setHistoriales(historialesPaciente);
		res.setUltimaVisita(listaHistoriales.get(0).getFecha());
		return res;
	}

	public ConsultaFacade converterToHistorial(MedicosPacientes mp) {

		ConsultaFacade h = new ConsultaFacade();
		h.setDiagnostico(mp.getDiagnostico());
		h.setFecha(mp.getFecha());
		h.setId(mp.getIdVisita());
		h.setMotivoVisita(mp.getMotivoVisita());
		h.setRecomendaciones(mp.getRecomendaciones());
		if (mp.getAnalisis() != null) {
			h.setAnalisis(analisisDao.getAnalisisById(Integer.parseInt(mp.getAnalisis())));
		} else {
			h.setAnalisis(null);
		}
		Medico m=medicoDao.getMedico(mp.getIdPersonal());
		h.setNomMedico(m.getNombre()+", "+m.getApellido1()+" "+m.getApellido2());

		return h;
	}

	public Medico converterToMedico(PersonalHospital ph) {
		Medico m=null;
		if(!ph.getAdministrador()) {
			m=new Medico();
			m.setApellido1(ph.getApellido1());
			m.setApellido2(ph.getApellido2());
			m.setCorreo(ph.getCorreo());
			m.setDni(ph.getDni());
			m.setEspecialidad(ph.getEspecialidad());
			m.setId(ph.getIdPersonal());
			m.setNombre(ph.getNombre());
			m.setAdmin(ph.getAdministrador());
		}
		return m;
	}
	
	public Admin converterToAdmin(PersonalHospital ph) {
		Admin m=null;
		if(ph.getAdministrador()) {
			m=new Admin();
			m.setApellido1(ph.getApellido1());
			m.setApellido2(ph.getApellido2());
			m.setCorreo(ph.getCorreo());
			m.setDni(ph.getDni());
			m.setId(ph.getIdPersonal());
			m.setNombre(ph.getNombre());
			m.setAdmin(ph.getAdministrador());
		}
		return m;
	}
	
	public MedicosPacientes converterToHistorialDao(ConsultaFacadeIn his) {
		MedicosPacientes mp=new MedicosPacientes();
		mp.setDiagnostico(his.getDiagnostico());
		mp.setMotivoVisita(his.getMotivoVisita());
		mp.setRecomendaciones(his.getRecomendaciones());
		mp.setIdPersonal(his.getIdMedico());
		return mp;		
	}

}
