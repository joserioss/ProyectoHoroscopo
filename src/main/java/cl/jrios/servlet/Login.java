package cl.jrios.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cl.jrios.dto.UsuarioDto;
import cl.jrios.facade.UsuarioFacade;


@WebServlet("/login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 2563849836255617228L;

	private static final Logger LOG = Logger.getLogger(Login.class.getName());

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestLogin = "";
		String requestPass = "";
		
		boolean usuarioOk  = false;
		boolean passwordOk = false;

		UsuarioFacade facade = new UsuarioFacade();
		List<UsuarioDto> listaUsuario = new ArrayList<>();
//		Creo una lista con todos los usuarios de la base de datos y sus respectivos datos
		listaUsuario = facade.obtenerUsuarios();
//		Guardo los valores ingresado en el form de index 		
		requestLogin = req.getParameter("login");
		requestPass = req.getParameter("pass");
		
//		Recorro la lista de usuario y la comparo con el correo y la contraseña
		for(UsuarioDto usuario : listaUsuario) {
			if(requestLogin.equals(usuario.getCorreo())) {
				usuarioOk = true;
				if(requestPass.equals(usuario.getContrasenia())) {
					passwordOk = true;
				}
			}	
		}
//		En el caso de que ambas sean correctas, los bolean cambian a true y se ingresa al siguiente .jsp		
		if(usuarioOk && passwordOk) {
			HttpSession sesionUsuario = req.getSession(true);
			sesionUsuario.setAttribute("NombreLogin", requestLogin);
			RequestDispatcher rd = req.getRequestDispatcher("Principal.jsp");
			rd.forward(req, resp);
		}
//		De ser incorrecto aparece una ventana modal que indica el error		
		else if (usuarioOk && !passwordOk) {
			req.setAttribute("mostrarError1", new Boolean(true));
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			
		} else if (!usuarioOk) {
			req.setAttribute("mostrarError2", new Boolean(true));
			req.getRequestDispatcher("index.jsp").forward(req, resp);

		}

	}

}
