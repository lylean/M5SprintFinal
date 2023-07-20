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


public class SrvLogin2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SrvLogin2() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSPFOLDER/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			Class.forName(ConnDB.driver);
			System.out.println("CI SIRVE");
		}catch(ClassNotFoundException e){
			System.out.println("NO FUNKA" + e );
		}
		
		
		try {
			//conexion antigua
			//Connection Pan = DriverManager.getConnection(ConnDB.url , ConnDB.user , ConnDB.password);
			
			Connection pan = ConnDB.getInstance().getConnection();
			System.out.println("CI SIRVE");
			//PreparedStatement st = Pan.prepareStatement("select Email, Pass from usuarios where Email=? and Pass=?");

			PreparedStatement st = pan.prepareStatement("select nombre, tipo from usuarios where nombre=? and tipo=?");
			st.setString(1, request.getParameter("User"));
			st.setString(2, request.getParameter("Pass"));
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				HttpSession sesion = request.getSession();
				sesion.setAttribute("UserName", request.getParameter("User"));
				response.sendRedirect(request.getContextPath() + "/Contacto");
			}else {
				response.sendRedirect(request.getContextPath() + "/SrvLogin2?error=incorrect");
			}
			
			rs.close();
			st.close();
			//este cierro ya no se pone porque se implemento el cierre de conexiones con el patron singleton
			//pan.close();
			
		}catch(Exception e) {
			System.out.println("No funka query");
			e.printStackTrace();
		}
	}

}
