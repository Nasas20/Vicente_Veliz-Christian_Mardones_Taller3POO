package App;

public class Planta extends Hechizos {
	private int stun;
	private int cantPlantas;

	public Planta(String nombreHechizo, String tipo, int daño, int stun, int cantPlantas) {
		super(nombreHechizo, tipo, daño);
		this.cantPlantas = cantPlantas;
		this.stun = stun;
	}

	public int getStun() {
		return stun;
	}

	public int getCantPlantas() {
		return cantPlantas;
	}

	@Override
	public double calcular() {
		
		return getDaño() + (stun * cantPlantas);
	}

	
	

}
