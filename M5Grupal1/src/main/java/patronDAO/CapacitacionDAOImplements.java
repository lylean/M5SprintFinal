package patronDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import patronDAO.Capacitacion;
import patronDAO.CapacitacionDAO;



public class CapacitacionDAOImplements implements CapacitacionDAO {
	private Connection conexion;

	// Constructor que recibe la conexión a la base de datos
	public CapacitacionDAOImplements(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public List<Capacitacion> obtenerCapacitaciones() {
		List<Capacitacion> capacitaciones = new ArrayList();

		try (PreparedStatement st = conexion.prepareStatement("SELECT c.id, c.nombre, c.detalle, c.usuario_id, u.nombre AS nombre_usuario FROM capacitaciones c JOIN usuarios u ON c.usuario_id = u.id");
				ResultSet rs = st.executeQuery()) {
			while (rs.next()) {
				int id = rs.getInt("id");
	            String nombre = rs.getString("nombre");
	            String detalle = rs.getString("detalle");
	            int usuario_id = rs.getInt("usuario_id");
	            String nombreUsuario = rs.getString("nombre_usuario");

	            Capacitacion capacitacion = new Capacitacion();
	            capacitacion.setId(id);
	            capacitacion.setNombre(nombre);
	            capacitacion.setDetalle(detalle);
	            capacitacion.setUsuario_id(usuario_id);
	            capacitacion.setNombreUsuario(nombreUsuario);

	            capacitaciones.add(capacitacion);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return capacitaciones;
	}

	@Override
	public Capacitacion obtenerCapacitacionPorId(int id) {
		Capacitacion capacitacion = null;

		try (PreparedStatement st = conexion.prepareStatement("SELECT c.id, c.nombre, c.detalle, c.usuario_id, u.nombre AS nombre_usuario FROM capacitaciones c JOIN usuarios u ON c.usuario_id = u.id WHERE c.id = ?")) {
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				String nombre = rs.getString("nombre");
				String detalle = rs.getString("detalle");
				int usuario_id = rs.getInt("usuario_id");
				String nombreUsuario = rs.getString("nombre_usuario");

				capacitacion = new Capacitacion();
				capacitacion.setId(id);
				capacitacion.setNombre(nombre);
				capacitacion.setDetalle(detalle);
				capacitacion.setUsuario_id(usuario_id);
				capacitacion.setNombreUsuario(nombreUsuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return capacitacion;
	}

	@Override
	public void agregarCapacitacion(Capacitacion capacitacion) {
		try (PreparedStatement st = conexion
				.prepareStatement("INSERT INTO capacitaciones (nombre, detalle, usuario_id) VALUES (?, ?, ?)")) {
			st.setString(1, capacitacion.getNombre());
			st.setString(2, capacitacion.getDetalle());
			st.setInt(3, capacitacion.getUsuario_id());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void actualizarCapacitacion(Capacitacion capacitacion) {
		try (PreparedStatement st = conexion
				.prepareStatement("UPDATE capacitaciones SET nombre = ?, detalle = ?, usuario_id = ? WHERE id = ?")) {
			st.setString(1, capacitacion.getNombre());
			st.setString(2, capacitacion.getDetalle());
			st.setInt(3, capacitacion.getUsuario_id());
			st.setInt(4, capacitacion.getId());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void eliminarCapacitacion(int id) {
		try (PreparedStatement st = conexion.prepareStatement("DELETE FROM capacitaciones WHERE id = ?")) {
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
