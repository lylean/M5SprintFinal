package Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import Conexion.ConnDB;

/**
 * Servlet implementation class ServletCrearUsuario
 */
public class ServletCrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCrearUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSPFOLDER/CrearUsuario.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Class.forName(ConnDB.driver);
			System.out.println("CI SIRVE");
		}catch(ClassNotFoundException e){
			System.out.println("NO FUNKA" + e );
		}
		
		
		try {
			Connection Pan = DriverManager.getConnection(ConnDB.url , ConnDB.user , ConnDB.password);
			System.out.println("CI SIRVE");
			//PreparedStatement st = Pan.prepareStatement("select Email, Pass from usuarios where Email=? and Pass=?");

			PreparedStatement st = Pan.prepareStatement("Insert into usuarios ( nombre, tipo) values ( ?, ?);");
			st.setString(1, request.getParameter("User"));
			st.setString(2, request.getParameter("perfil"));
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				
				response.sendRedirect(request.getContextPath() + "/SrvLogin2");
				System.out.println("estas aqui we");
			}
			
			st.close();
			Pan.close();
			
		}catch(Exception e) {
			System.out.println("No funka query");
			e.printStackTrace();
		}
	}

}
