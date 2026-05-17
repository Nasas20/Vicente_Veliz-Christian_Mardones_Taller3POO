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
				 agregarMago(scan);
			}
			
		}
		
		
	}

	@Override
	public void agregarMago(Scanner scan) {
		System.out.print("ingrese nombre de mago: ");
		String nombre = scan.nextLine();
		
		Magos m = new Magos(nombre);
		listaMagos.add(m);
		System.out.println("creado");
		System.out.println("");
		
		
	}

}
