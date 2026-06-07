package App;

public class Agua extends Hechizos {
	private int cantidadHeal;
	private int presionAgua;

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
	
	public void setCantidadHeal(int cantidadHeal) {
	    this.cantidadHeal = cantidadHeal;
	}
	
	public void setPresionAgua(int presionAgua) {
	    this.presionAgua = presionAgua;
	}
	
}
