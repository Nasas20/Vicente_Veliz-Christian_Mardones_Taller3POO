package Logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import App.Agua;
import App.Fuego;
import App.Hechizos;
import App.Magos;
import App.Planta;
import App.Tierra;
import App.Fuego;

public class Sistema implements Metodos {
	
	public static ArrayList<Hechizos> listaHechizos = new ArrayList<>();
	public static ArrayList<Magos> listaMagos = new ArrayList<>();

	
	public void leerMagos() throws FileNotFoundException {
		File arch = new File("archivos/magos.txt");
		Scanner scan = new Scanner(arch);
		int n = 1;
		
		while (scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
			
			String nombre = partes[0].trim().toLowerCase();
			String hechizos = partes[1];
			
			String[] magic = hechizos.split("\\|");
			
			ArrayList<Hechizos> magia = new ArrayList<>();
			
			
			for (int i = 0; i < magic.length;i++) {
				for (Hechizos h : listaHechizos) {
					if (h.getNombreHechizo().equalsIgnoreCase(magic[i])) {
						magia.add(h);
						
						
					}
					
				}
			}
			
			Magos m = new Magos(nombre, magia);
			if (magia.isEmpty()) {
				System.out.println("corre" + n);
				n++;
			}
			listaMagos.add(m);
					

		}
		

	}

	@Override
	public void leerHechizoz() throws FileNotFoundException {
		File arch = new File("archivos/hechizos.txt");
		Scanner scan = new Scanner(arch);
		
		while (scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
			
			String nombreHechizo = partes[0].trim();
			String tipo = partes[1].trim().toLowerCase();
			int daño = Integer.valueOf(partes[2].trim());
			
			switch (tipo) {
				case "fuego":
					int duracionQuemaduras = Integer.valueOf(partes[3]);
					Hechizos fuego = new Fuego(nombreHechizo,tipo,daño,duracionQuemaduras);
					listaHechizos.add(fuego);
					break;
					
				case "agua":
					
					String adicional = partes[3];
					String[] partes2 = adicional.split(",");
					int cantidadHeal = Integer.valueOf(partes2[0]);
					int presionAgua = Integer.valueOf(partes2[1]);
					Hechizos agua = new Agua(nombreHechizo, tipo, daño, cantidadHeal, presionAgua);
					listaHechizos.add(agua);
					break;
				
				case "tierra":
					int mejoraDefensa = Integer.valueOf(partes[3].trim());
					Hechizos tierra = new Tierra(nombreHechizo, tipo, daño, mejoraDefensa);
					listaHechizos.add(tierra);
					break;
					
				case "planta":
					String adicionalPlanta = partes[3];
					String[] partes3 = adicionalPlanta.split(",");
					int duracionStun = Integer.valueOf(partes3[0]);
					int cantPlanta = Integer.valueOf(partes3[1]);
					
					Hechizos planta = new Planta(nombreHechizo, tipo, daño, duracionStun, cantPlanta);
					listaHechizos.add(planta);
					break;
					 
					
					
				default:
					System.out.println("nada");
				
			}
			
		}
	}

	@Override
	public void mostrar() { // chaval esto lo hice para ir viendo si entraba no lo borres
		for (Magos magos : listaMagos) {
			System.out.println(magos.getNombreMago());
		}
	}
	
	public void menuAdministrador(Scanner scan) {
		scan.nextLine();
		boolean verAdmin = true;
		
		while (verAdmin) {
			System.out.println("1) agregar mago");
			System.out.println("2) modificar Mago");
			System.out.println("3) eliminar Mago");
			System.out.println("4) agregar hechizo");
			System.out.println("5) modificar hechizo");
			System.out.println("6) eliminar hechizo");
			System.out.println("7) salir");
			System.out.println("");
			System.out.print("ingrese opcion: ");
			int opcion = scan.nextInt();
			
			switch(opcion) {
			 case 1:
				 agregarMago();
				 break;
			 case 2:
				 modificarMago();
				 break;
				 
			 case 3: 
				 elimininarMago(scan);
				 break;
			 case 4:
				 agregarHechizo();
				 break;
				 
			 case 7:
				 verAdmin = false;
				 break;
			}
			
			
		}
		
		
	}
	
	public void menuAnalista() {
		System.out.println("1) top 10 mejores magos: ");
		System.out.println("2) top 3 mejores magos: ");
		System.out.println("3) mostrar todos los hechizos: ");
		System.out.println("4) mostrar todos los magos: ");
		System.out.println("5) mostrar todos los hechizos junto a su puntuacion: ");
		System.out.println("6)mostrar todos los magos junto a su puntuacion: ");
		
		
		
	}

	@Override
	public void agregarMago() {
		Scanner scan = new Scanner(System.in);
		System.out.print("ingrese nombre de mago: ");
		String nombre = scan.nextLine();
		
		Magos m = new Magos(nombre);
		listaMagos.add(m);
		System.out.println("creado");
		System.out.println("");
		
		
	}

	@Override
	public void elimininarMago(Scanner scan) {
		
		int contador = 1;
		for (Magos m : listaMagos) {
			System.out.println(contador +")" +" "+ m.getNombreMago());
			contador++;
			
			
		}
		System.out.println("");
		System.out.println("cual desea eliminar (elija el numero): ");
		int opcion = scan.nextInt();
		listaMagos.remove(opcion-1);
		System.out.println("mago eliminado");
		System.out.println("");
		

	}

	@Override
	public void agregarHechizo() {
		Scanner scan = new Scanner(System.in);
		System.out.println("cual es el tipo de hechizo: ");
		String opcion = scan.nextLine().toLowerCase().trim();
		
		switch (opcion) {
		case "fuego":
			System.out.print("nombre hechizo: ");
			String nombre = scan.nextLine();
			System.out.print("daño: ");
			int daño = scan.nextInt();
			scan.nextLine();
			System.out.print("duracion quemaduras: ");
			int duracion = scan.nextInt();
			
			Hechizos h = new Fuego(nombre,opcion,daño,duracion);
			listaHechizos.add(h);
		
		case "tierra":
			System.out.print("nombre hechizo: ");
			String nombreTierra = scan.nextLine();
			System.out.print("daño: ");
			int dañoTierra = scan.nextInt();
			scan.nextLine();
			System.out.print("mejora defensa: ");
			int mejora = scan.nextInt();
			
			Hechizos tierra = new Tierra(nombreTierra,opcion,dañoTierra,mejora);
			listaHechizos.add(tierra);
			
		case "planta":
			System.out.print("nombre hechizo: ");
			String nombrePlanta = scan.nextLine();
			System.out.print("daño: ");
			int dañoPlanta = scan.nextInt();
			scan.nextLine();
			System.out.print("duracion quemaduras: ");
			int duracionStun = scan.nextInt();
			scan.nextLine();
			System.out.println("cantidad de plantas: ");
			int cantPlantas = scan.nextInt();
			
			Hechizos planta = new Planta(nombrePlanta,opcion,dañoPlanta,duracionStun,cantPlantas);
			listaHechizos.add(planta);
			
		case "agua":
			System.out.print("nombre hechizo: ");
			String nombreAgua = scan.nextLine();
			System.out.print("daño: ");
			int dañoAgua = scan.nextInt();
			scan.nextLine();
			System.out.print("duracion quemaduras: ");
			int heal = scan.nextInt();
			scan.nextLine();
			System.out.println("presion de agua: ");
			int presion = scan.nextInt();
			
			Hechizos agua = new Agua(nombreAgua,opcion,dañoAgua,heal,presion);
			listaHechizos.add(agua);
			
			
		default:
			System.out.println("no se encontro ese tipo de hechizo");
			break;
			
		}
		
		
	}

	@Override
	public void modificarMago() {
		int contador = 1;
		Scanner scan = new Scanner(System.in);
		for (Magos m : listaMagos) {
			System.out.println(contador +")"+m.getNombreMago());
			contador++;

		}
		System.out.println("dime cual quieres modificar: ");
		int opcion = scan.nextInt();
		
		System.out.println("");
		
		System.out.println("");
		
	}

}
