package App;

import java.io.FileNotFoundException;
import java.util.Scanner;

import Logica.Metodos;
import Logica.Sistema;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		Metodos sistema = new Sistema();
		sistema.leerHechizoz();
		sistema.leerMagos();
		//sistema.mostrar();
		
		

		
		
		
		
		
		boolean verMenu = true;
		
		while (verMenu) {
			System.out.println("1) administrador");
			System.out.println("2) analista");
			System.out.println("3) salir");
			
			System.out.print("ingrese opcion: ");
			int usuario = scan.nextInt();
			
			
			switch (usuario) {
			 case 1:
				 sistema.menuAdministrador(scan);
				 break;
			 case 2:
				 sistema.menuAnalista();
				 break;
			 case 3:
			}
			
			
		}
		
		
		
	}

}
