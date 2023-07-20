package Conexion;

//adaptacion para el modelo singleton, primero importar estas librerias
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnDB {
	// credenciaes del driver
	public static String url = "jdbc:mysql://localhost:3306/prevencion_riesgos";
	public static String user = "root";
	public static String password = "Lloveless9$";
	public static String driver = "com.mysql.cj.jdbc.Driver";

	// agregamos estas intancias para cumplir con el modelo singleton
	// la primera es una forma de volver este mismo archivo una instancia
	// la segunda es la integracion del objeto connection de la libreria
	private static ConnDB instance;
	private Connection conexion;

	// Constructor privado para evitar la creación de instancias desde fuera de la
	// clase
	private ConnDB() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// metodo estatico que devuelve la unica instancia de la clase
	public static ConnDB getInstance() {
		if (instance == null) {
			instance = new ConnDB();
		}
		return instance;
	}

	// Método para obtener la conexión a la base de datos
	public Connection getConnection() {
		if (conexion == null) {

			try {
				// Establece la conexión a la base de datos utilizando las credenciales
				// proporcionadas
				conexion = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conexion;
	}
}
