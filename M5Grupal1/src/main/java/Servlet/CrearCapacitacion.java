package Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Conexion.ConnDB;

/**
 * Servlet implementation class CrearCapacitacion
 */
public class CrearCapacitacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearCapacitacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSPFOLDER/crearcapacitacion.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  try {
		        Connection pan = ConnDB.getInstance().getConnection();

		        // Obtener el nombre del usuario de la sesión
		        HttpSession session = request.getSession();
		        String userName = (String) session.getAttribute("UserName");

		        // Consulta para obtener el usuario_id basado en el nombre de usuario
		        PreparedStatement stUsuario = pan.prepareStatement("SELECT id FROM usuarios WHERE nombre=?");
		        stUsuario.setString(1, userName);
		        ResultSet rsUsuario = stUsuario.executeQuery();

		        int usuarioId = -1; // Valor predeterminado en caso de no encontrar usuario
		        if (rsUsuario.next()) {
		            usuarioId = rsUsuario.getInt("id");
		        }
		        
		        // Cerrar el resultado y el statement
		        rsUsuario.close();
		        stUsuario.close();

		        // Insertar el registro en la tabla capacitaciones
		        PreparedStatement stCapacitacion = pan.prepareStatement("INSERT INTO capacitaciones (nombre, detalle, usuario_id) VALUES (?, ?, ?)");
		        stCapacitacion.setString(1, request.getParameter("validationCustom02"));
		        stCapacitacion.setString(2, request.getParameter("validationCustom05"));
		        stCapacitacion.setInt(3, usuarioId);

		        stCapacitacion.executeUpdate();
		        stCapacitacion.close();

		        response.sendRedirect(request.getContextPath() + "/Contacto");
		    } catch (Exception e) {
		        e.printStackTrace();
		        response.sendRedirect(request.getContextPath() + "/SrvLogin2?error=database");
		    }
	}

}
