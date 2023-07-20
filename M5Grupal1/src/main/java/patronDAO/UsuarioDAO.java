package patronDAO;

import java.util.List;

public interface UsuarioDAO {
	
	
	List<Usuario> obtenerUsuarios();
	Usuario obtenerUsuarioporID(int id);
	//void agregarUsuario(Usuario usuario);
	void actualizarUsuario(Usuario usuario);
	//void eliminarUsuario(int id);
}
