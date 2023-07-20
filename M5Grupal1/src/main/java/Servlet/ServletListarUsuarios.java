package Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Conexion.ConnDB;
import patronDAO.Capacitacion;
import patronDAO.Usuario;
import patronDAO.UsuarioDAO;
import patronDAO.UsuarioDAOImplements;


public class ServletListarUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioDAO usuarioDAO;

    public ServletListarUsuarios() {
        super();
    }
    
    @Override
    public void init() {
    	Connection conexion = ConnDB.getInstance().getConnection();
    	usuarioDAO = new UsuarioDAOImplements(conexion);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//obtener todos los registros
		List<Usuario> usuarios = usuarioDAO.obtenerUsuarios();
		//enviarle los registros a la vista
		request.setAttribute("usuarios", usuarios);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSPFOLDER/ListarUsuarios.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Obtener todos los registros
	    List<Usuario> usuarios = usuarioDAO.obtenerUsuarios();
	    
	    // Enviar las capacitaciones a la vista
	    request.setAttribute("usuarios", usuarios);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSPFOLDER/ListarUsuarios.jsp");
	    dispatcher.forward(request, response);
	}

}
