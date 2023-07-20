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


public class Srvlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Srvlogin() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


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
			PreparedStatement st = Pan.prepareStatement("select nombre, tipo from usuarios where nombre=? and tipo=?");
			st.setString(1, request.getParameter("User"));
			st.setString(2, request.getParameter("Pass"));
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				HttpSession sesion = request.getSession();
				sesion.setAttribute("UserName", request.getParameter("User"));
				response.sendRedirect(request.getContextPath() + "/Contacto");
			}else {
				response.sendRedirect("./JSPFOLDER/login.jsp?error=incorrect");
			}
			
			rs.close();
			st.close();
			Pan.close();
			
		}catch(Exception e) {
			System.out.println("No funka query");
			e.printStackTrace();
		}
		
		
		
	}

}
