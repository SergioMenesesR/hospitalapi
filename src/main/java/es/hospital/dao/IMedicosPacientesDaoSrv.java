package es.hospital.dao;

import java.util.List;
import es.hospital.dao.dto.MedicosPacientes;

public interface IMedicosPacientesDaoSrv {
	 List<MedicosPacientes> getAllHistoriales();
	 List<MedicosPacientes> getAllHistorialesPorPaciente(int idPaciente);
	 MedicosPacientes getHistoriale(int idConsulta);
}
