package es.hospital.facade.dto;

import java.util.Date;

import es.hospital.dao.dto.Analisis;

public class ConsultaFacadeIn {
	private int idMedico;
    private String motivoVisita;    
    private String diagnostico;
    private String recomendaciones;
    
    public String getMotivoVisita() {
		return motivoVisita;
	}
	public void setMotivoVisita(String motivoVisita) {
		this.motivoVisita = motivoVisita;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getRecomendaciones() {
		return recomendaciones;
	}
	public void setRecomendaciones(String recomendaciones) {
		this.recomendaciones = recomendaciones;
	}
	public int getIdMedico() {
		return idMedico;
	}
	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}
    

}
