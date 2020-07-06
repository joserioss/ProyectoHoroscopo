package cl.jrios.facade;

import java.util.ArrayList;
import java.util.List;

import cl.jrios.dao.UsuarioDao;
import cl.jrios.dto.UsuarioDto;
import cl.jrios.entidades.Usuario;


public class UsuarioFacade {

	private static final UsuarioDao daoUsuario = new UsuarioDao();
	
	public UsuarioDto servicioEliminarPorId(int id) {
		UsuarioDto usuarioEliminado = servicioBuscarPorId(id);
		int filasAfectadas = daoUsuario.eliminar(id);
		
		return(filasAfectadas != 1)? null: usuarioEliminado;
	}
	
	public UsuarioDto servicioBuscarPorId(int id) {
		Usuario usuarioEntidad = daoUsuario.buscarPorId(id);
		
		UsuarioDto usuarioDto = new UsuarioDto();
		usuarioDto.setCodigo(usuarioEntidad.getId());
		usuarioDto.setCorreo(usuarioEntidad.getCorreo());
		usuarioDto.setNombre(usuarioEntidad.getNombre());
		usuarioDto.setContrasenia(usuarioEntidad.getContrasenia());
		usuarioDto.setAnioNacimiento(usuarioEntidad.getAnioNacimiento());
		
		return usuarioDto;
	}
	
	public int guardarUsuario(UsuarioDto usuariodto) {
		Usuario usuario = new Usuario();
		usuario.setCorreo(usuariodto.getCorreo());
		usuario.setContrasenia(usuariodto.getContrasenia());
		usuario.setNombre(usuariodto.getNombre());
		
		return daoUsuario.ingresar(usuario);
	}
	
	public List<UsuarioDto> obtenerUsuarios(){
		List<UsuarioDto> usuarios = new ArrayList<>();
		List<Usuario> usuariosEntidad = daoUsuario.obtenerTodos();
		
		for(Usuario usuario : usuariosEntidad) {
			UsuarioDto usuarioDto = new UsuarioDto();
			
			usuarioDto.setCodigo(usuario.getId());
			usuarioDto.setCorreo(usuario.getCorreo());
			usuarioDto.setContrasenia(usuario.getContrasenia());
			usuarioDto.setNombre(usuario.getNombre());
			usuarioDto.setAnioNacimiento(usuario.getAnioNacimiento());
			
			usuarios.add(usuarioDto);
		}
		return usuarios;
	}
	
}
