package es.hospital.dao;

import java.util.List;

import es.hospital.dao.dto.Analisis;


public interface IAnalisisDaoSrv {
	List<Analisis> getAllAnalisis();
	Analisis getAnalisisById(int id_analisis);
}
