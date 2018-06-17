package es.hospital.dao.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="medicos_pacientes")
public class MedicosPacientes {

	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_visita")
    private Integer idVisita;	
    
	private int idPersonal;
	
    private int idPaciente;
    
   
    
    @Column(name = "fecha")
    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "M-")
    private Date fecha;
    
    @Column(name = "motivoVisita", length = 300)
    @NotNull
    private String motivoVisita;
    
    @Column(name = "diagnostico", length = 300)
    @NotNull
    private String diagnostico;
    
    @Column(name = "recomendaciones", length = 300)
    @NotNull
    private String recomendaciones;

    private String analisis;
    
	
	public Integer getIdVisita() {
		return idVisita;
	}

	public void setIdVisita(Integer idVisita) {
		this.idVisita = idVisita;
	}
	
	public int getIdPersonal() {
		return idPersonal;
	}

	public void setIdPersonal(int idPersonal) {
		this.idPersonal = idPersonal;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getAnalisis() {
		return analisis;
	}

	public void setAnalisis(String analisis) {
		this.analisis = analisis;
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
        //sb.append("Analisis: ").append(getAnalisis()).append(", ");
        sb.append("Diagnostico: ").append(getDiagnostico()).append(", ");
        sb.append("Fecha: ").append(getFecha()).append(", ");
        //sb.append("IdPaciente: ").append(getIdPaciente()).append(", ");
        sb.append("IdVisita: ").append(getIdVisita()).append(", ");
        sb.append("MotivoVisita: ").append(getMotivoVisita()).append(", ");
        sb.append("Recomendaciones: ").append(getRecomendaciones());
        return sb.toString();
	}
    
    
    
    
}
