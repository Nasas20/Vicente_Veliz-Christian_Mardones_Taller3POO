package App;

import java.util.ArrayList;

public class Magos {
	private String nombreMago;
	private ArrayList<Hechizos> listaHechizos = new ArrayList<>();
	public static double total =0;
	
	public Magos(String nombreMago, ArrayList<Hechizos> listaHechizos) {
		super();
		this.nombreMago = nombreMago;
		this.listaHechizos = listaHechizos;
	}
	
	public Magos (String nombre) {
		this.nombreMago = nombre;
	}
	
	
	public double calcularPuntaje() {
		
		double total = 0;
		for (Hechizos hechizos : this.listaHechizos) {
			total += hechizos.calcular();
			this.total = total;
		}
		
		
		return total;
	}


	public String getNombreMago() {
		return nombreMago;
	}
	
	public void setNombreMago(String nombreMago) {
	    this.nombreMago = nombreMago;
	}


	public ArrayList<Hechizos> getListaHechizos() {
		return listaHechizos;
	}


	public static double getTotal() {
		return total;
	}


	public static void setTotal(double total) {
		Magos.total = total;
	}
	
	
}
