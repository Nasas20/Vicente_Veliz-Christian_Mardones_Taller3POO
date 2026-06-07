package App;

public abstract class Hechizos {
	private String nombreHechizo;
	private String tipo;
	private int daño;
	
	public Hechizos(String nombreHechizo, String tipo, int daño) {
		this.nombreHechizo = nombreHechizo;
		this.tipo = tipo;
		this.daño = daño;
	}

	public String getNombreHechizo() {
		return nombreHechizo;
	}

	public String getTipo() {
		return tipo;
	}

	public int getDaño() {
		return daño;
	}
	
	public void setNombreHechizo(String nombreHechizo) {
	    this.nombreHechizo = nombreHechizo;
	}

	public void setDaño(int daño) {
	    this.daño = daño;
	}
	
	
	public abstract double calcular();
}
