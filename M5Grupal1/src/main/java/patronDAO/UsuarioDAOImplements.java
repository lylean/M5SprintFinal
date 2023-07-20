package patronDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import patronDAO.Usuario;
import patronDAO.UsuarioDAO;

public class UsuarioDAOImplements implements UsuarioDAO{

	private Connection conexion;
	
	public UsuarioDAOImplements(Connection conexion) {
		this.conexion = conexion;
	}
	
	@Override
	public List<Usuario> obtenerUsuarios(){
		List<Usuario> usuarios = new ArrayList();
		
		try(PreparedStatement st = conexion.prepareStatement("Select * from usuarios");
				ResultSet rs = st.executeQuery()){
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String tipo = rs.getString("tipo");
				
				Usuario usuario = new Usuario();
				usuario.setId(id);
				usuario.setNombre(nombre);
				usuario.setTipo(tipo);
				
				usuarios.add(usuario);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	return usuarios;
	}
	
	@Override
	public Usuario obtenerUsuarioporID(int id) {
		Usuario usuario = null;
		
		try(PreparedStatement st = conexion.prepareStatement("Select * from usuarios where id = ?")){
				st.setInt(1, id);
				ResultSet rs= st.executeQuery();

				if(rs.next()) {
					String nombre = rs.getString("nombre");
					String tipo = rs.getString("tipo");
					
					usuario = new Usuario();
					usuario.setId(id);
					usuario.setNombre(nombre);
					usuario.setTipo(tipo);
				}
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		return usuario;
	}
	
	@Override
	public void actualizarUsuario(Usuario usuario) {
		try (PreparedStatement st = conexion
				.prepareStatement("UPDATE usuarios SET nombre = ?, tipo = ? WHERE id = ?")) {
			st.setString(1, usuario.getNombre());
			st.setString(2, usuario.getTipo());
			st.setInt(3, usuario.getId());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
