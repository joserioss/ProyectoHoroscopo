package cl.jrios.dto;

public class UsuarioDto {

	int codigo;

	String correo;

	String contrasenia;

	String nombre;

	int anioNacimiento;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public int getAnioNacimiento() {
		return anioNacimiento;
	}

	public void setAnioNacimiento(int anioNacimiento) {
		this.anioNacimiento = anioNacimiento;
	}

	@Override
	public String toString() {
		return "UsuarioDto [codigo=" + codigo + ", correo=" + correo + ", contrasenia=" + contrasenia + ", nombre="
				+ nombre + ", anioNacimiento=" + anioNacimiento + "] \n";
	}

}
