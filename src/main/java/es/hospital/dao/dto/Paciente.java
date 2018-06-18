package es.hospital.dao.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="pacientes")
public class Paciente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_paciente")
    private int idPaciente;
	
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
    
    @Column(name = "numTelf")
    @NotNull
    private Integer numTelf;
    
    @Column(name = "numMovil")
    private Integer numMovil;
    
    @Column(name = "direccion", length = 30)
    private String direccion;
    
    @Column(name = "codPostal")
    private Integer codPostal;
    
    @Column(name = "NombrePersonaContacto", length = 15)
    private String nombrePersonaContacto;
    
    @Column(name = "telfContacto")
    private Integer telfContacto;
    
    @Column(name = "relacion", length = 15)
    private String relacion;
    
    @Column(name = "correo", length = 30, unique = true)
    private String correo;
    
    @Column(name = "pass", length = 30)
    private String pass;
    
    @Column(name = "nSeguridadSocial", length = 9)
    @NotNull
    private String nseguridadSocial;
    
    @Column(name = "alergias", length = 100)
    private String alergias;
    
    @Column(name = "enfermedades", length = 100)
    private String enfermedades;
    
    private String antecedentesFamiliares;
    
    @Column(name = "Observaciones", length = 3000)
    private String observaciones;
    
    
    /*@OneToMany(mappedBy = "idPaciente")
    private Set<MedicosPacientes> medicosPacienteses;*/


    
	public String getAntecedentesFamiliares() {
		return antecedentesFamiliares;
	}


	public void setAntecedentesFamiliares(String antecedentesFamiliares) {
		this.antecedentesFamiliares = antecedentesFamiliares;
	}


	public int getId_paciente() {
		return idPaciente;
	}


	public void setId_paciente(int id_paciente) {
		this.idPaciente = id_paciente;
	}


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


	public Integer getNumTelf() {
		return numTelf;
	}


	public void setNumTelf(Integer numTelf) {
		this.numTelf = numTelf;
	}


	public Integer getNumMovil() {
		return numMovil;
	}


	public void setNumMovil(Integer numMovil) {
		this.numMovil = numMovil;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public Integer getCodPostal() {
		return codPostal;
	}


	public void setCodPostal(Integer codPostal) {
		this.codPostal = codPostal;
	}


	public String getNombrePersonaContacto() {
		return nombrePersonaContacto;
	}


	public void setNombrePersonaContacto(String nombrePersonaContacto) {
		this.nombrePersonaContacto = nombrePersonaContacto;
	}


	public Integer getTelfContacto() {
		return telfContacto;
	}


	public void setTelfContacto(Integer telfContacto) {
		this.telfContacto = telfContacto;
	}


	public String getRelacion() {
		return relacion;
	}


	public void setRelacion(String relacion) {
		this.relacion = relacion;
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


	public String getNseguridadSocial() {
		return nseguridadSocial;
	}


	public void setNseguridadSocial(String nseguridadSocial) {
		this.nseguridadSocial = nseguridadSocial;
	}


	public String getAlergias() {
		return alergias;
	}


	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}


	public String getEnfermedades() {
		return enfermedades;
	}


	public void setEnfermedades(String enfermedades) {
		this.enfermedades = enfermedades;
	}


	


	public String getObservaciones() {
		return observaciones;
	}


	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
        sb.append("Alergias: ").append(getAlergias()).append(", ");
        sb.append("Apellido1: ").append(getApellido1()).append(", ");
        sb.append("Apellido2: ").append(getApellido2()).append(", ");
        sb.append("CodPostal: ").append(getCodPostal()).append(", ");
        sb.append("Correo: ").append(getCorreo()).append(", ");
        sb.append("Direccion: ").append(getDireccion()).append(", ");
        sb.append("Dni: ").append(getDni()).append(", ");
        sb.append("Enfermedades: ").append(getEnfermedades()).append(", ");
        sb.append("IdPaciente: ").append(getId_paciente()).append(", ");
       // sb.append("MedicosPacienteses: ").append(getMedicosPacienteses() == null ? "null" : getMedicosPacienteses().size()).append(", ");
        sb.append("Nombre: ").append(getNombre()).append(", ");
        sb.append("NombrePersonaContacto: ").append(getNombrePersonaContacto()).append(", ");
        sb.append("NseguridadSocial: ").append(getNseguridadSocial()).append(", ");
        sb.append("NumMovil: ").append(getNumMovil()).append(", ");
        sb.append("NumTelf: ").append(getNumTelf()).append(", ");
        sb.append("Observaciones: ").append(getObservaciones()).append(", ");
        sb.append("Pass: ").append(getPass()).append(", ");
        sb.append("Relacion: ").append(getRelacion()).append(", ");
        sb.append("TelfContacto: ").append(getTelfContacto());
        return sb.toString();
	}
	
	

}
