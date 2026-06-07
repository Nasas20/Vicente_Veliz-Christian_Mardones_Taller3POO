package App;

public class Fuego extends Hechizos {
	private int duracionQuemadura;

	public Fuego(String nombreHechizo, String tipo, int daño, int duracionQuemadura) {
		super(nombreHechizo, tipo, daño);
		this.duracionQuemadura = duracionQuemadura;
	}

	@Override
	public double calcular() {
		
		return getDaño() * duracionQuemadura;
	}
	
	public void setDuracionQuemadura(int duracionQuemadura) {
	    this.duracionQuemadura = duracionQuemadura;
	}
	
	public int getDuracionQuemadura() {
	    return duracionQuemadura;
	}
	
}
