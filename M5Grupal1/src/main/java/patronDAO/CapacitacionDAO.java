package patronDAO;

import java.util.List;

public interface CapacitacionDAO {
	
	List<Capacitacion> obtenerCapacitaciones();
    Capacitacion obtenerCapacitacionPorId(int id);
    void agregarCapacitacion(Capacitacion capacitacion);
    void actualizarCapacitacion(Capacitacion capacitacion);
    void eliminarCapacitacion(int id);

}
