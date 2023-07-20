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
import patronDAO.CapacitacionDAO;
import patronDAO.CapacitacionDAOImplements;


public class SrvListarCapacitaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CapacitacionDAO capacitacionDAO;
	
	
    public SrvListarCapacitaciones() {
        super();    
    }
    
    @Override
    public void init(){

        	Connection conexion = ConnDB.getInstance().getConnection();
        	capacitacionDAO = new CapacitacionDAOImplements(conexion);

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//obtener todos los registros
		List<Capacitacion> capacitaciones = capacitacionDAO.obtenerCapacitaciones();
		//enviarle las capacitacione a las vistas
		request.setAttribute("capacitaciones", capacitaciones);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSPFOLDER/ListarCapacitaciones.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idEliminarStr = request.getParameter("idEliminar");
	    if (idEliminarStr != null) {
	        int idEliminar = Integer.parseInt(idEliminarStr);
	        capacitacionDAO.eliminarCapacitacion(idEliminar);
	    }
	    
	    // Obtener todos los registros
	    List<Capacitacion> capacitaciones = capacitacionDAO.obtenerCapacitaciones();
	    
	    // Enviar las capacitaciones a la vista
	    request.setAttribute("capacitaciones", capacitaciones);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/JSPFOLDER/ListarCapacitaciones.jsp");
	    dispatcher.forward(request, response);
	}
	

}
