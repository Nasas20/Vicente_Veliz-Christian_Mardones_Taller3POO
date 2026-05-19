package App;

public class Agua extends Hechizos {
	private int cantidadHeal;
	private int presionAgua;
	private int cambio;

	public Agua(String nombreHechizo, String tipo, int daño, int cantidadHeal, int presionAgua  ) {
		super(nombreHechizo, tipo, daño);
		this.cantidadHeal = cantidadHeal;
		this.presionAgua = presionAgua;
	}

	public int getCantidadHeal() {
		return cantidadHeal;
	}

	public int getPresionAgua() {
		return presionAgua;
	}

	@Override
	public double calcular() {
		
		return (getDaño() + getCantidadHeal() + getPresionAgua())*2;
	}

	
	
	

}
