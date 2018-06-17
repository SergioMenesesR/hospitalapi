package es.hospital.facade.dto;

public class PacientesFacadeIn {
	private int id;
	private String nombre;	
	private String apellido1;    
    private String apellido2;
    private String nSeguridadSocial;
    private Integer nTelefono;    
    private Integer movil;
    private String email;
    private String dni;    
    private String direccion;    
    private Integer codPostal;    
    private String nomContacto;    
    private Integer telfContacto;    
    private String relacion;
    private String alergias;    
    private String enfermedades;    
    private String antecedentesFamiliares;    
    private String observaciones;
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getnSeguridadSocial() {
		return nSeguridadSocial;
	}
	public void setnSeguridadSocial(String nSeguridadSocial) {
		this.nSeguridadSocial = nSeguridadSocial;
	}
	public Integer getnTelefono() {
		return nTelefono;
	}
	public void setnTelefono(Integer nTelefono) {
		this.nTelefono = nTelefono;
	}
	public Integer getMovil() {
		return movil;
	}
	public void setMovil(Integer movil) {
		this.movil = movil;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
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
	public String getNomContacto() {
		return nomContacto;
	}
	public void setNomContacto(String nomContacto) {
		this.nomContacto = nomContacto;
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
	public String getAntecedentesFamiliares() {
		return antecedentesFamiliares;
	}
	public void setAntecedentesFamiliares(String antecedentesFamiliares) {
		this.antecedentesFamiliares = antecedentesFamiliares;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
}
