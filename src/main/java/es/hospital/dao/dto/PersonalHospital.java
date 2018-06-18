package es.hospital.dao.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="personal_hospital")
public class PersonalHospital {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_personal")
    private Integer idPersonal;
	
	@Column(name = "dni", length = 9, unique = true)
    @NotNull
    private String dni;
    
    @Column(name = "nombre", length = 15)
    @NotNull
    private String nombre;
    
    @Column(name = "apellido1", length = 15)
    @NotNull
    private String apellido1;
    
    @Column(name = "apellido2", length = 15)
    @NotNull
    private String apellido2;
    
    @Column(name = "especialidad", length = 15)
    private String especialidad;
    
    @Column(name = "administrador")
    private Boolean administrador;
    
    @Column(name = "correo", length = 30, unique = true)
    @NotNull
    private String correo;
    
    @Column(name = "pass", length = 30)
    @NotNull
    private String pass;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public Boolean getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Boolean administrador) {
		this.administrador = administrador;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}	
	
	public Integer getIdPersonal() {
		return idPersonal;
	}

	public void setIdPersonal(Integer idPersonal) {
		this.idPersonal = idPersonal;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
        sb.append("Administrador: ").append(getAdministrador()).append(", ");
        sb.append("Apellido1: ").append(getApellido1()).append(", ");
        sb.append("Apellido2: ").append(getApellido2()).append(", ");
        sb.append("Correo: ").append(getCorreo()).append(", ");
        sb.append("Dni: ").append(getDni()).append(", ");
        sb.append("Especialidad: ").append(getEspecialidad()).append(", ");
        sb.append("IdPersonal: ").append(getIdPersonal()).append(", ");
        sb.append("Nombre: ").append(getNombre()).append(", ");
        sb.append("Pass: ").append(getPass());
        return sb.toString();
	}
    
    
	
}
