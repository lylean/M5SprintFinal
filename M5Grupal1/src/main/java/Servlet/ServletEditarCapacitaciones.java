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
import Conexion.ConnDB;

public class ServletEditarCapacitaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ServletEditarCapacitaciones() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 // obtenemos el ID del registro a editar desde los parámetros de la solicitud
        int idEditar = Integer.parseInt(request.getParameter("idEditar"));
        
        //Crea una instancia de la implementación del DAO y obtiene la conexión
        CapacitacionDAO capacitacionDAO = new CapacitacionDAOImplements(ConnDB.getInstance().getConnection());
        
        // Utiliza el DAO para obtener la capacitación por ID
        Capacitacion capacitacion = capacitacionDAO.obtenerCapacitacionPorId(idEditar);
        
     // establezco los atributos de solicitud con los datos de la capacitación
        request.setAttribute("id", capacitacion.getId());
        request.setAttribute("nombre", capacitacion.getNombre());
        request.setAttribute("detalle", capacitacion.getDetalle());
        request.setAttribute("nombreUsuario", capacitacion.getNombreUsuario());

        // cargo a la vista 
        RequestDispatcher dispatcher = request.getRequestDispatcher("/JSPFOLDER/EditarCapacitaciones.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   if (request.getParameter("actualizar") != null) {
	            // Obtener el ID del registro a actualizar desde los parámetros de la solicitud
	            int id = Integer.parseInt(request.getParameter("id"));

	            // Obtener los valores actualizados del formulario
	            String nombre = request.getParameter("nombre");
	            String detalle = request.getParameter("detalle");
	            String nombreUsuario = request.getParameter("nombreUsuario");

	            // Actualizar la capacitación en la base de datos utilizando el DAO
	            CapacitacionDAO capacitacionDAO = new CapacitacionDAOImplements(ConnDB.getInstance().getConnection());
	            Capacitacion capacitacion = capacitacionDAO.obtenerCapacitacionPorId(id);
	            capacitacion.setNombre(nombre);
	            capacitacion.setDetalle(detalle);
	            capacitacion.setNombreUsuario(nombreUsuario);
	            capacitacionDAO.actualizarCapacitacion(capacitacion);
	        }

	        // Redireccionar a otro servlet o página
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/SrvListarCapacitaciones");
	        dispatcher.forward(request, response);
	    }

}
