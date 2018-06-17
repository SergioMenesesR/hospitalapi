package es.hospital.facade.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import es.hospital.dao.dto.Analisis;

public class ConsultaFacade {
	private Integer id;	    
	private String nomMedico;
	private String diagnostico;
    private Date fecha;
    private String motivoVisita;    
    private String recomendaciones;
    private Analisis analisis;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomMedico() {
		return nomMedico;
	}
	public void setNomMedico(String nomMedico) {
		this.nomMedico = nomMedico;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getMotivoVisita() {
		return motivoVisita;
	}
	public void setMotivoVisita(String motivoVisita) {
		this.motivoVisita = motivoVisita;
	}
	public String getRecomendaciones() {
		return recomendaciones;
	}
	public void setRecomendaciones(String recomendaciones) {
		this.recomendaciones = recomendaciones;
	}
	public Analisis getAnalisis() {
		return analisis;
	}
	public void setAnalisis(Analisis analisis) {
		this.analisis = analisis;
	}
    
}
