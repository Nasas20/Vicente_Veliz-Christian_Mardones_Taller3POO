//Vicente Veliz | Carrera : ICCI | 22.012.230-1
//Christian Mardones | Carrera : ICCI | 22.026.428-9

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
			System.out.println("1) Administrador");
			System.out.println("2) Analista");
			System.out.println("3) Salir");
			
			System.out.print("Ingrese opcion: ");
			int usuario = 0;
			
			try {
				usuario = scan.nextInt();
			} catch (Exception e) {
				System.out.println("Error! : " + e);
				System.out.println("Ingrese un valor valido.");
				scan.nextLine();
				// TODO: handle exception
			}
			
			
			switch (usuario) {
			 case 1:
				 sistema.menuAdministrador(scan);
				 break;
			 case 2:
				 sistema.menuAnalista();
				 break;
			 case 3:
				 verMenu = false;
				 break;
			}
			System.out.println();
		}
	}
}
