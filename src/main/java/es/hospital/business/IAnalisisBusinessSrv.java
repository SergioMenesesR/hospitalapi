package es.hospital.business;

import java.util.List;

import es.hospital.dao.dto.Analisis;

public interface IAnalisisBusinessSrv {
	List<Analisis> getAllAnalisis();
	Analisis getAnalisisById(int id_analisis);
}
