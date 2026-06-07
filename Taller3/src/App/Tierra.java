package App;

public class Tierra extends Hechizos {
	private int mejoraDefensa;

	public Tierra(String nombreHechizo, String tipo, int daño, int mejoraDefensa) {
		super(nombreHechizo, tipo, daño);
		this.mejoraDefensa = mejoraDefensa;
	}

	public int getMejoraDefensa() {
		return mejoraDefensa;
	}

	@Override
	public double calcular() {
		
		return (getDaño()*mejoraDefensa)/2;
	}
	
	public void setMejoraDefensa(int mejoraDefensa) {
	    this.mejoraDefensa = mejoraDefensa;
	}
	
}
