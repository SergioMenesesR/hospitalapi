package es.hospital.dao;

import java.util.List;

import es.hospital.dao.dto.Socios;





public interface ISocioDaoSrv {
	List<Socios> getAllSocios();
    Socios getSociosById(int SociosId);
    Socios addSocios(Socios Socios);
    Socios updateSocios(Socios Socios);
    void deleteSocios(int SociosId);
    boolean SociosExists(String title, String category);

}
