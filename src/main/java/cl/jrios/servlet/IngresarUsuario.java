package cl.jrios.servlet;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.jrios.dao.UsuarioDao;
import cl.jrios.dto.UsuarioDto;
import cl.jrios.facade.UsuarioFacade;

@WebServlet("/ingresarUsuario")
public class IngresarUsuario extends HttpServlet{

	private static final long serialVersionUID = -5036124858743661882L;
	
	private static final Logger LOG = Logger.getLogger(IngresarUsuario.class.getName());

    private static final UsuarioDao dao = new UsuarioDao();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestCorreo = "";
		String requestContrasenia = "";
		String requestNombre = "";
		Integer requestAnioNacimiento = 0;
		int usuarioGuardado = 0;
		
		requestCorreo = req.getParameter("correo");   
		requestContrasenia = req.getParameter("contrasenia");
		requestNombre = req.getParameter("nombre");   
		requestAnioNacimiento = Integer.parseInt(req.getParameter("anioNacimiento"));
		System.out.println(requestAnioNacimiento);
		
		UsuarioFacade facade = new UsuarioFacade();
		
		UsuarioDto usuario = new UsuarioDto();
		usuario.setCorreo(requestCorreo);
		usuario.setContrasenia(requestContrasenia);
		usuario.setNombre(requestNombre);
		usuario.setAnioNacimiento(requestAnioNacimiento);

		usuarioGuardado = facade.guardarUsuario(usuario);
		
		System.out.println(facade.obtenerUsuarios());
		
		if(usuarioGuardado != 0) {
			req.setAttribute("mostrarMensaje", new Boolean(true));
			req.getRequestDispatcher("Registrar.jsp").forward(req, resp);			
		}
			
	}
    
}
