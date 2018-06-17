package es.hospital.dao.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="analisis")
public class Analisis {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_analisis")
    private int id_analisis;
	
	private String contenido;

	public int getId_analisis() {
		return id_analisis;
	}

	public void setId_analisis(int id_analisis) {
		this.id_analisis = id_analisis;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	
}
