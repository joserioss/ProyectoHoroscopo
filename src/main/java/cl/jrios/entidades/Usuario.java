package cl.jrios.entidades;

public class Usuario {

	private Integer id;

	private String correo;

	private String contrasenia;

	private String nombre;

	private Integer anioNacimiento;

	public Usuario() {

	}

	public Usuario(Integer id, String correo, String contrasenia, String nombre, Integer anioNacimiento) {
		super();
		this.id = id;
		this.correo = correo;
		this.contrasenia = contrasenia;
		this.nombre = nombre;
		this.anioNacimiento = anioNacimiento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getAnioNacimiento() {
		return anioNacimiento;
	}

	public void setAnioNacimiento(Integer anioNacimiento) {
		this.anioNacimiento = anioNacimiento;
	}

}
