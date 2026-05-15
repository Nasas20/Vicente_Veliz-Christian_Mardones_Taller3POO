package App;

import java.io.FileNotFoundException;

import Logica.Metodos;
import Logica.Sistema;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Metodos sistema = new Sistema();
		sistema.leerHechizoz();
		sistema.leerMagos();
		sistema.mostrar();
		
		
	}

}
