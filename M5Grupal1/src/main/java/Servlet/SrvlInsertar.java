package Servlet;

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


public class SrvlInsertar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SrvlInsertar() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Establecer conexion
		try {
			Class.forName(ConnDB.driver);	
		}catch(ClassNotFoundException e){
			System.out.println("No funka");
		}
		
		//Validar CREDS
		try {
			Connection Conn = DriverManager.getConnection(ConnDB.url , ConnDB.user , ConnDB.password);
			System.out.println("CI SIRVE");
		//Instruccion Query
			PreparedStatement st = Conn.prepareStatement("insert into modulo5 (nombre,apellido,ciudad,mensaje) values(?,?,?,?)");
		//Definiendo/Otorgando información del formulario
			st.setString(1, request.getParameter("validationCustom01"));
			st.setString(2, request.getParameter("validationCustom02"));
			st.setString(3, request.getParameter("validationCustom03"));
			st.setString(4, request.getParameter("validationCustom05"));
		//Ejecutar Query
			st.executeUpdate();
			
		//Cerrrar sentencia
			st.close();
		//Cerrar conexcion
			Conn.close();
		response.sendRedirect("/M5Grupal1/JSPFOLDER/Index.jsp");
		
		}catch(Exception e){
			System.out.println("No funka" + e);
		
	}
}
}
