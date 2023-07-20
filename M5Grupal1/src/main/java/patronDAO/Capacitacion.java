package patronDAO;

public class Capacitacion {
	
	 private int id;
	 private String nombre;
	 private String detalle;
	 private int usuario_id;
	 private String nombreUsuario;
	 
	public Capacitacion() {

		this.id = id;
		this.nombre = nombre;
		this.detalle = detalle;
		this.usuario_id = usuario_id;
		this.nombreUsuario = nombreUsuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsurio) {
		this.nombreUsuario = nombreUsurio;
	}
	 
	 
	 
}
