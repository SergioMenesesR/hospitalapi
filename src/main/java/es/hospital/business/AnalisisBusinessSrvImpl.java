package es.hospital.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.hospital.dao.IAnalisisDaoSrv;
import es.hospital.dao.dto.Analisis;
@Service
public class AnalisisBusinessSrvImpl implements IAnalisisBusinessSrv {
	@Autowired
	private IAnalisisDaoSrv daoSrv;
	@Override
	public List<Analisis> getAllAnalisis() {
		// TODO Auto-generated method stub
		return daoSrv.getAllAnalisis();
	}

	@Override
	public Analisis getAnalisisById(int id_analisis) {
		// TODO Auto-generated method stub
		return daoSrv.getAnalisisById(id_analisis);
	}

}
