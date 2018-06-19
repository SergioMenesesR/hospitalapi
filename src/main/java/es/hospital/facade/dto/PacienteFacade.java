package es.hospital.facade.dto;

import java.util.Date;
import java.util.List;

public class PacienteFacade extends PacientesFacadeIn{
		
	private Date ultimaVisita; 
	private int id;
	
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getUltimaVisita() {
		return ultimaVisita;
	}
	public void setUltimaVisita(Date ultimaVisita) {
		this.ultimaVisita = ultimaVisita;
	}
	private List<ConsultaFacade> historiales;    
    
	public List<ConsultaFacade> getHistoriales() {
		return historiales;
	}
	public void setHistoriales(List<ConsultaFacade> historiales) {
		this.historiales = historiales;
	}
	
    
    
    
    
}
