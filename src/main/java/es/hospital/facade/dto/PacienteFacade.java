package es.hospital.facade.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class PacienteFacade extends PacientesFacadeIn{
		
	private Date ultimaVisita; 
	
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
