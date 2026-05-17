package Logica;

import java.io.FileNotFoundException;
import java.util.Scanner;

public interface Metodos {
	public void leerMagos() throws FileNotFoundException;
	public void leerHechizoz() throws FileNotFoundException;
	public void mostrar();
	public void menuAdministrador(Scanner scan);
	public void agregarMago(Scanner scan);

}
