package Logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
			System.out.println();
			System.out.println("1) Agregar mago");
			System.out.println("2) Modificar Mago");
			System.out.println("3) Eliminar Mago");
			System.out.println("4) Agregar hechizo");
			System.out.println("5) Modificar hechizo");
			System.out.println("6) Eliminar hechizo");
			System.out.println("7) Salir");
			System.out.println("");
			System.out.print("Ingrese opcion: ");
			int opcion = 0;
			
			try {
				opcion = scan.nextInt();
			} catch (Exception e) {
				System.out.println("Error! : " + e);
				System.out.println("Ingrese un valor valido.");
				scan.nextLine();
				// TODO: handle exception
			}
			
			switch(opcion) {
		    case 1:
		        agregarMago();
		        guardarMagos();
		        break;
		    case 2:
		        modificarMago();
		        guardarMagos();
		        break;
		    case 3:
		        elimininarMago(scan);
		        guardarMagos();
		        break;
		    case 4:
		        agregarHechizo();
		        guardarHechizos();
		        break;
		    case 5:
		        modificarHechizo();
		        guardarHechizos();
		        break;
		    case 6:
		        eliminarHechizo();
		        guardarHechizos();
		        guardarMagos(); 
		        break;
		    case 7:
		        verAdmin = false;
		        break;
		    }
		}
	}
	
	public void menuAnalista() {
	    Scanner scan = new Scanner(System.in);
	    boolean verAnalista = true;

	    while (verAnalista) {
	        System.out.println("\n-- Menu Analista --");
	        System.out.println("1) Top 10 mejores hechizos");
	        System.out.println("2) Top 3 mejores magos");
	        System.out.println("3) Mostrar todos los hechizos");
	        System.out.println("4) Mostrar todos los magos");
	        System.out.println("5) Mostrar todos los hechizos con puntuacion");
	        System.out.println("6) Mostrar todos los magos con puntuacion");
	        System.out.println("7) Volver");
	        System.out.print("ingrese opcion: ");
	        int opcion = scan.nextInt();

	        switch (opcion) {
	            case 1: 
	            	top10Hechizos();        
	                break;
	            
	            case 2: 
	            	top3Magos();            
	                break;
	            
	            case 3: 
	            	mostrarHechizos();      
	                break;
	            
	            case 4: 
	            	mostrarMagos();         
	                break;
	            
	            case 5: 
	            	mostrarHechizosConPuntaje(); 
	                break;
	            
	            case 6: 
	            	mostrarMagosConPuntaje();    
	                break;
	            
	            case 7: 
	            	verAnalista = false;    
	                break;
	            default: System.out.println("Opcion no valida.");
	        }
	    }
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
			
			break;
		
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
			
			break;
			
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
			
			break;
			
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
			
			break;
			
			
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
	        System.out.println(contador + ") " + m.getNombreMago());
	        contador++;
	    }

	    System.out.print("dime cual quieres modificar: ");
	    int opcion = 0;
	    
	    while (opcion > contador-1 || opcion < 1 ) {
	    	try {
				opcion = scan.nextInt();
				
				if (opcion > contador-1 || opcion < 1 ) {
					System.out.println("Escoja una opcion valida.");
				}
				
			} catch (Exception e) {
				System.out.println("Error! : " + e);
				System.out.println("Ingrese un valor valido.");
				scan.nextLine();
				// TODO: handle exception
			}
	    }

	    Magos magoSeleccionado = listaMagos.get(opcion - 1);

	    boolean verModificar = true;
	    while (verModificar) {
	        System.out.println("\n-- Modificar: " + magoSeleccionado.getNombreMago() + " --");
	        System.out.println("1) Cambiar nombre");
	        System.out.println("2) Agregar hechizo");
	        System.out.println("3) Eliminar hechizo");
	        System.out.println("4) Volver");
	        System.out.print("ingrese opcion: ");
	        int subOpcion = scan.nextInt();
	        scan.nextLine();

	        switch (subOpcion) {
	            case 1:
	                System.out.print("Nuevo nombre: ");
	                String nuevoNombre = scan.nextLine();
	                magoSeleccionado.setNombreMago(nuevoNombre);
	                System.out.println("Nombre actualizado.");
	                break;

	            case 2:
	                int cont = 1;
	                System.out.println("Hechizos disponibles:");
	                for (Hechizos h : listaHechizos) {
	                    System.out.println(cont + ") " + h.getNombreHechizo());
	                    cont++;
	                }
	                System.out.print("Elige el numero del hechizo a agregar: ");
	                int numAgregar = scan.nextInt();
	                scan.nextLine();
	                Hechizos hNuevo = listaHechizos.get(numAgregar - 1);
	                if (!magoSeleccionado.getListaHechizos().contains(hNuevo)) {
	                    magoSeleccionado.getListaHechizos().add(hNuevo);
	                    System.out.println("Hechizo agregado.");
	                } else {
	                    System.out.println("El mago ya tiene ese hechizo.");
	                }
	                break;

	            case 3:
	                if (magoSeleccionado.getListaHechizos().isEmpty()) {
	                    System.out.println("Este mago no tiene hechizos.");
	                } else {
	                    int cont2 = 1;
	                    for (Hechizos h : magoSeleccionado.getListaHechizos()) {
	                        System.out.println(cont2 + ") " + h.getNombreHechizo());
	                        cont2++;
	                    }
	                    System.out.print("Elige el numero del hechizo a eliminar: ");
	                    int numEliminar = scan.nextInt();
	                    scan.nextLine();
	                    magoSeleccionado.getListaHechizos().remove(numEliminar - 1);
	                    System.out.println("Hechizo eliminado.");
	                }
	                break;

	            case 4:
	                verModificar = false;
	                break;

	            default:
	                System.out.println("Opcion no valida.");
	        }
	    }
	}
	
	@Override
	public void modificarHechizo() {
	    Scanner scan = new Scanner(System.in);
	    int contador = 1;

	    for (Hechizos h : listaHechizos) {
	        System.out.println(contador + ") " + h.getNombreHechizo() + " [" + h.getTipo() + "]");
	        contador++;
	    }

	    System.out.print("Cual desea modificar: ");
	    int opcion = scan.nextInt();
	    scan.nextLine();

	    Hechizos seleccionado = listaHechizos.get(opcion - 1);

	    System.out.println("\n-- Modificar: " + seleccionado.getNombreHechizo() + " --");
	    System.out.println("1) Cambiar nombre");
	    System.out.println("2) Cambiar daño");
	    System.out.println("3) Cambiar atributos especificos");
	    System.out.print("ingrese opcion: ");
	    int subOpcion = scan.nextInt();
	    scan.nextLine();

	    switch (subOpcion) {
	        case 1:
	            System.out.print("Nuevo nombre: ");
	            String nuevoNombre = scan.nextLine();
	            seleccionado.setNombreHechizo(nuevoNombre);
	            System.out.println("Nombre actualizado.");
	            break;

	        case 2:
	            System.out.print("Nuevo daño: ");
	            int nuevoDaño = scan.nextInt();
	            seleccionado.setDaño(nuevoDaño);
	            System.out.println("Daño actualizado.");
	            break;

	        case 3:
	            if (seleccionado instanceof Fuego) {
	                Fuego f = (Fuego) seleccionado;
	                System.out.print("Nueva duracion quemadura: ");
	                f.setDuracionQuemadura(scan.nextInt());

	            } else if (seleccionado instanceof Tierra) {
	                Tierra t = (Tierra) seleccionado;
	                System.out.print("Nueva mejora defensa: ");
	                t.setMejoraDefensa(scan.nextInt());

	            } else if (seleccionado instanceof Planta) {
	                Planta p = (Planta) seleccionado;
	                System.out.print("Nuevo stun: ");
	                p.setStun(scan.nextInt());
	                System.out.print("Nueva cantidad de plantas: ");
	                p.setCantPlantas(scan.nextInt());

	            } else if (seleccionado instanceof Agua) {
	                Agua a = (Agua) seleccionado;
	                System.out.print("Nueva cantidad heal: ");
	                a.setCantidadHeal(scan.nextInt());
	                System.out.print("Nueva presion agua: ");
	                a.setPresionAgua(scan.nextInt());
	            }
	            System.out.println("Atributos actualizados.");
	            break;

	        default:
	            System.out.println("Opcion no valida.");
	    }
	}

	@Override
	public void eliminarHechizo() {
	    Scanner scan = new Scanner(System.in);
	    int contador = 1;

	    for (Hechizos h : listaHechizos) {
	        System.out.println(contador + ") " + h.getNombreHechizo() + " [" + h.getTipo() + "]");
	        contador++;
	    }

	    System.out.print("Cual desea eliminar (elija el numero): ");
	    int opcion = scan.nextInt();

	    Hechizos aEliminar = listaHechizos.get(opcion - 1);

	    // Eliminar de la lista de cada mago que lo tenga
	    for (Magos m : listaMagos) {
	        m.getListaHechizos().remove(aEliminar);
	    }

	    listaHechizos.remove(opcion - 1);
	    System.out.println("Hechizo eliminado.");
	}
	
	private void top10Hechizos() {
	    ArrayList<Hechizos> ordenados = new ArrayList<>(listaHechizos);
	    ordenados.sort((a, b) -> Double.compare(b.calcular(), a.calcular()));

	    System.out.println("\n--- Top 10 Mejores Hechizos ---");
	    int limite = Math.min(10, ordenados.size());
	    for (int i = 0; i < limite; i++) {
	        Hechizos h = ordenados.get(i);
	        System.out.println((i + 1) + ") " + h.getNombreHechizo()
	            + " [" + h.getTipo() + "] - Puntaje: " + h.calcular());
	    }
	}

	private void top3Magos() {
	    ArrayList<Magos> ordenados = new ArrayList<>(listaMagos);
	    ordenados.sort((a, b) -> Double.compare(b.calcularPuntaje(), a.calcularPuntaje()));

	    System.out.println("\n--- Top 3 Mejores Magos ---");
	    int limite = Math.min(3, ordenados.size());
	    for (int i = 0; i < limite; i++) {
	        Magos m = ordenados.get(i);
	        System.out.println((i + 1) + ") " + m.getNombreMago()
	            + " - Puntaje: " + m.calcularPuntaje());
	    }
	}

	private void mostrarHechizos() {
	    System.out.println("\n--- Todos los Hechizos ---");
	    for (Hechizos h : listaHechizos) {
	        System.out.println("- " + h.getNombreHechizo() + " [" + h.getTipo() + "]");
	    }
	}

	private void mostrarMagos() {
	    System.out.println("\n--- Todos los Magos ---");
	    for (Magos m : listaMagos) {
	        System.out.println("- " + m.getNombreMago());
	    }
	}

	private void mostrarHechizosConPuntaje() {
	    System.out.println("\n--- Hechizos con Puntuacion ---");
	    for (Hechizos h : listaHechizos) {
	        System.out.println("- " + h.getNombreHechizo()
	            + " [" + h.getTipo() + "] - Puntaje: " + h.calcular());
	    }
	}

	private void mostrarMagosConPuntaje() {
	    System.out.println("\n--- Magos con Puntuacion ---");
	    for (Magos m : listaMagos) {
	        System.out.println("- " + m.getNombreMago()
	            + " - Puntaje: " + m.calcularPuntaje());
	    }
	}
	
	private void guardarHechizos() {
	    try {
	        BufferedWriter bw = new BufferedWriter(new FileWriter("archivos/hechizos.txt"));

	        for (Hechizos h : listaHechizos) {
	            StringBuilder linea = new StringBuilder();
	            linea.append(h.getNombreHechizo()).append(";")
	                 .append(h.getTipo()).append(";")
	                 .append(h.getDaño()).append(";");

	            if (h instanceof Fuego) {
	                Fuego f = (Fuego) h;
	                linea.append(f.getDuracionQuemadura());

	            } else if (h instanceof Tierra) {
	                Tierra t = (Tierra) h;
	                linea.append(t.getMejoraDefensa());

	            } else if (h instanceof Planta) {
	                Planta p = (Planta) h;
	                linea.append(p.getStun()).append(",").append(p.getCantPlantas());

	            } else if (h instanceof Agua) {
	                Agua a = (Agua) h;
	                linea.append(a.getCantidadHeal()).append(",").append(a.getPresionAgua());
	            }

	            bw.write(linea.toString());
	            bw.newLine();
	        }

	        bw.close();
	        System.out.println("Hechizos guardados correctamente.");

	    } catch (IOException e) {
	        System.out.println("Error al guardar hechizos: " + e.getMessage());
	    }
	}

	private void guardarMagos() {
	    try {
	        BufferedWriter bw = new BufferedWriter(new FileWriter("archivos/magos.txt"));

	        for (Magos m : listaMagos) {
	            StringBuilder linea = new StringBuilder();
	            linea.append(m.getNombreMago()).append(";");

	            ArrayList<Hechizos> hechizos = m.getListaHechizos();
	            for (int i = 0; i < hechizos.size(); i++) {
	                linea.append(hechizos.get(i).getNombreHechizo());
	                if (i < hechizos.size() - 1) {
	                    linea.append("|");
	                }
	            }

	            bw.write(linea.toString());
	            bw.newLine();
	        }

	        bw.close();
	        System.out.println("Magos guardados correctamente.");

	    } catch (IOException e) {
	        System.out.println("Error al guardar magos: " + e.getMessage());
	    }
	}
	
}
