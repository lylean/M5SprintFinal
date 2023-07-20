package Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import patronDAO.Capacitacion;
import patronDAO.CapacitacionDAO;
import patronDAO.CapacitacionDAOImplements;
import patronDAO.Usuario;
import patronDAO.UsuarioDAO;
import patronDAO.UsuarioDAOImplements;
import Conexion.ConnDB;

public class ServletEditarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ServletEditarUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//obtenemos el id del registrar a editar
		int idEditar = Integer.parseInt(request.getParameter("idEditar"));
		
		//creamos la instancia de coneion
		UsuarioDAO usuarioDAO = new UsuarioDAOImplements(ConnDB.getInstance().getConnection());
		
		//creamos la instancia para usar el dao
		Usuario usuario = usuarioDAO.obtenerUsuarioporID(idEditar);
		
		//establezco los atributos
		request.setAttribute("id", usuario.getId());
		request.setAttribute("nombre", usuario.getNombre());
		request.setAttribute("tipo", usuario.getTipo());
		
		//cargo a la vista
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSPFOLDER/EditarUsuario.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 if (request.getParameter("actualizar") != null) {
	            // Obtener el ID del registro a actualizar desde los parámetros de la solicitud
	            int id = Integer.parseInt(request.getParameter("id"));

	            // Obtener los valores actualizados del formulario
	            String nombre = request.getParameter("nombre");
	            String tipo = request.getParameter("tipo");

	            // Actualizar la capacitación en la base de datos utilizando el DAO
	            UsuarioDAO usuarioDAO = new UsuarioDAOImplements(ConnDB.getInstance().getConnection());
	            Usuario usuario = usuarioDAO.obtenerUsuarioporID(id);
	            usuario.setNombre(nombre);
	            usuario.setTipo(tipo);
	            usuarioDAO.actualizarUsuario(usuario);
	        }

	        // Redireccionar a otro servlet o página
	        RequestDispatcher dispatcher = request.getRequestDispatcher("./ServletListarUsuarios");
	        dispatcher.forward(request, response);
	}

}
