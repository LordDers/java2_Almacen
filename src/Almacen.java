import java.io.*;
import java.util.*;

public class Almacen {

	public static void main (String args[]) {

		ArrayList <Distribuidor> arrayDistribuidor = new ArrayList <Distribuidor> ();

		try {

			BufferedReader br = new BufferedReader(new FileReader("distribuidores.txt"));

			String linea = br.readLine();

			// Creamos un array de tipo String para separar los campos del fichero
			String [] camposSeparados = null;

			//ArrayList <Distribuidor> arrayDistribuidor = new ArrayList <Distribuidor> ();

			while (linea != null) {

				// Creamos los objetos que participan en el fichero "distribuidores.txt"
				Distribuidor distribuidor = new Distribuidor ();
				Direccion direccion = new Direccion ();
				Contacto contacto = new Contacto ();

				camposSeparados = linea.split(", ");

				//introducimos los valores en los objetos para despues añadirlos al ArrayList

				// Introducimos los valores capturados del fichero en los objetos creados
				distribuidor.setNombre(camposSeparados[0]);
				distribuidor.setCif(camposSeparados[1]);

				direccion.setPais(camposSeparados[2]);
				direccion.setProvincia(camposSeparados[3]);
				direccion.setCiudad(camposSeparados[4]);
				direccion.setCalle(camposSeparados[5]);
				direccion.setPiso(Integer.parseInt(camposSeparados[6]));
				direccion.setLetra(camposSeparados[7].charAt(0));
				direccion.setCodigoPostal(Integer.parseInt(camposSeparados[8]));

				contacto.setDni(camposSeparados[9]);
				contacto.setNombre(camposSeparados[10]);
				contacto.setApellido(camposSeparados[11]);
				contacto.setEdad(Integer.parseInt(camposSeparados[12]));
				contacto.setNacionalidad(camposSeparados[13]);
				contacto.setNacimiento(camposSeparados[14]);
				contacto.setSexo(camposSeparados[15]);
				contacto.setTelefono(Integer.parseInt(camposSeparados[16]));
				contacto.setEmail(camposSeparados[17]);

				// Introducimos los valores(objetos) de "direccion" y "contacto" en "distribuidor"
				distribuidor.setDireccion(direccion);
				distribuidor.setPersonaContacto(contacto);

				// Añadimos el objeto "distribuidor" al ArrayList "arrayDistribuidor"
				arrayDistribuidor.add(distribuidor);

				linea = br.readLine();
			}

			for(int i=0; i<arrayDistribuidor.size(); i++) {

				System.out.println();
				System.out.println("      ------ DATOS DISTRIBUIDOR " + (i+1) + " ------ \n");

				System.out.println("Nombre Distribuidor: " + arrayDistribuidor.get(i).getNombre());
				System.out.println("C.I.F.: " + arrayDistribuidor.get(i).getCif());

				System.out.println("Dirección: ");
				System.out.println("   País: " + arrayDistribuidor.get(i).getDireccion().getPais());
				System.out.println("   Provincia: " + arrayDistribuidor.get(i).getDireccion().getProvincia());
				System.out.println("   Ciudad: " + arrayDistribuidor.get(i).getDireccion().getCiudad());
				System.out.println("   Calle: " + arrayDistribuidor.get(i).getDireccion().getCalle());
				System.out.println("   Piso: " + arrayDistribuidor.get(i).getDireccion().getPiso());
				System.out.println("   Letra: " + arrayDistribuidor.get(i).getDireccion().getLetra());
				System.out.println("   Código Postal: " + arrayDistribuidor.get(i).getDireccion().getCodigoPostal());

				System.out.println("Contacto de Persona: ");
				System.out.println("   DNI: " + arrayDistribuidor.get(i).getPersonaContacto().getDni());
				System.out.println("   Nombre: " + arrayDistribuidor.get(i).getPersonaContacto().getNombre());
				System.out.println("   Apellido: " + arrayDistribuidor.get(i).getPersonaContacto().getApellido());
				System.out.println("   Edad: " + arrayDistribuidor.get(i).getPersonaContacto().getEdad());
				System.out.println("   Nacionalidad: " + arrayDistribuidor.get(i).getPersonaContacto().getNacionalidad());
				System.out.println("   Fecha de Nacimiento: " + arrayDistribuidor.get(i).getPersonaContacto().getNacimiento());
				System.out.println("   Sexo: " + arrayDistribuidor.get(i).getPersonaContacto().getSexo());
				System.out.println("   Telefono: " + arrayDistribuidor.get(i).getPersonaContacto().getTelefono());
				System.out.println("   E-mail: " + arrayDistribuidor.get(i).getPersonaContacto().getEmail());
				System.out.println("--------------------------------");
				System.out.print("");
			}
			
		} catch(IOException e) {
			System.out.println("Error E/S: "+e);
		}

		// ---------------- 3.12 ----------------

		Scanner sc = new Scanner (System.in);

		System.out.println();

		// Manzanas

		ArrayList <Manzana> arrayManzana = new ArrayList <Manzana> ();

		System.out.println("      ------ MANZANAS ------ \n");
		System.out.println("A continuación, introduciremos dos manzanas.");

		for (int m=1; m<=2; m++) {

			Manzana manzana = new Manzana ();
			// Para enviar el nombre del distribuidor
			Distribuidor distribuidor = new Distribuidor();

			System.out.print("Introduce el tipo de manzana: ");
			manzana.setTipoManzana(sc.next());

			System.out.print("Procedencia: ");
			manzana.setProcedencia(sc.next());

			System.out.print("Color: ");
			manzana.setColor(sc.next());

			System.out.print("Introduce el precio por kilo: ");
			manzana.setEurosKilo(sc.nextDouble());

			System.out.print("Introduce el distribuidor de la manzana: ");
			//manzana.setDistribuidor(sc.next());
			String distribuidorm = sc.next();
			distribuidor.setNombre(distribuidorm);

			for(int q=0; q<arrayDistribuidor.size(); q++) {

				// Si el nombre del distribuidor introducido coincide con uno del arraylist (distribuidores.txt)
				if (distribuidorm.equalsIgnoreCase(arrayDistribuidor.get(q).getNombre())) {

					//le asignamos el valor del distribuidor al objeto manzana
					manzana.setDistribuidor(arrayDistribuidor.get(q));
				}
			}

			// Añadimos el objeto "manzana" al ArrayList "arrayManzana"
			arrayManzana.add(manzana);

			System.out.println();
		}

		for(int mm=0; mm<arrayManzana.size(); mm++) {

			System.out.println();
			System.out.println("      ------ DATOS MANZANA " + (mm+1) +" Y DISTRIBUIDOR ------ \n");

			System.out.println("Tipo de manzana: "+arrayManzana.get(mm).getTipoManzana() );
            System.out.println("Procedencia: "+arrayManzana.get(mm).getProcedencia());
            System.out.println("Color : "+arrayManzana.get(mm).getColor() );
            System.out.println("Euros Kilo: "+arrayManzana.get(mm).getEurosKilo());

            System.out.println();

            // // Manzana.java (Distribuidor) -- Distribuidor.java (Nombre)
			System.out.println("Nombre Distribuidor: " + arrayManzana.get(mm).getDistribuidor().getNombre());
			System.out.println("C.I.F.: " + arrayManzana.get(mm).getDistribuidor().getCif());

			System.out.println("Dirección: ");
			// Manzana.java (Distribuidor) -- Distribuidor.java (Nombre, Direccion) -- Direccion.java (Pais)
			System.out.println("   País: " + arrayManzana.get(mm).getDistribuidor().getDireccion().getPais());
			System.out.println("   Provincia: " + arrayManzana.get(mm).getDistribuidor().getDireccion().getProvincia());
			System.out.println("   Ciudad: " + arrayManzana.get(mm).getDistribuidor().getDireccion().getCiudad());
			System.out.println("   Calle: " + arrayManzana.get(mm).getDistribuidor().getDireccion().getCalle());
			System.out.println("   Piso: " + arrayManzana.get(mm).getDistribuidor().getDireccion().getPiso());
			System.out.println("   Letra: " + arrayManzana.get(mm).getDistribuidor().getDireccion().getLetra());
			System.out.println("   Código Postal: " + arrayManzana.get(mm).getDistribuidor().getDireccion().getCodigoPostal());

			System.out.println("Contacto de Persona: ");
			// Manzana.java (Distribuidor) -- Distribuidor.java (Nombre, PersonaContacto) -- Contacto.java (Dni)
			System.out.println("   DNI: " + arrayManzana.get(mm).getDistribuidor().getPersonaContacto().getDni());
			System.out.println("   Nombre: " + arrayManzana.get(mm).getDistribuidor().getPersonaContacto().getNombre());
			System.out.println("   Apellido: " + arrayManzana.get(mm).getDistribuidor().getPersonaContacto().getApellido());
			System.out.println("   Edad: " + arrayManzana.get(mm).getDistribuidor().getPersonaContacto().getEdad());
			System.out.println("   Nacionalidad: " + arrayManzana.get(mm).getDistribuidor().getPersonaContacto().getNacionalidad());
			System.out.println("   Fecha de Nacimiento: " + arrayManzana.get(mm).getDistribuidor().getPersonaContacto().getNacimiento());
			System.out.println("   Sexo: " + arrayManzana.get(mm).getDistribuidor().getPersonaContacto().getSexo());
			System.out.println("   Telefono: " + arrayManzana.get(mm).getDistribuidor().getPersonaContacto().getTelefono());
			System.out.println("   E-mail: " + arrayManzana.get(mm).getDistribuidor().getPersonaContacto().getEmail());
			System.out.println("--------------------------------");
			System.out.print("");
		}


		// Lechuga

		ArrayList <Lechuga> arrayLechuga = new ArrayList <Lechuga> ();

		System.out.println("\n      ------ LECHUGA ------ \n");
		System.out.println("A continuación, introduciremos una lechuga.");

		for (int l=0; l<1; l++) {

			Lechuga lechuga = new Lechuga ();
			// Para enviar el nombre del distribuidor
			Distribuidor distribuidor = new Distribuidor();

			System.out.print("Introduce el tipo de Lechuga: ");
			lechuga.setTipoLechuga(sc.next());

			System.out.print("Procedencia: ");
			lechuga.setProcedencia(sc.next());

			System.out.print("Color: ");
			lechuga.setColor(sc.next());

			System.out.print("Introduce el precio por unidad: ");
			lechuga.setEurosUnidad(sc.nextDouble());

			System.out.print("Introduce el distribuidor de la Lechuga: ");
			String distribuidorl = sc.next();
			distribuidor.setNombre(distribuidorl);

			for (int q=0; q<arrayDistribuidor.size(); q++) {

				if (distribuidorl.equalsIgnoreCase(arrayDistribuidor.get(q).getNombre())) {

					lechuga.setDistribuidor(arrayDistribuidor.get(q));
				}
			}

			arrayLechuga.add(lechuga);

			System.out.println();
		}

		for(int ll=0; ll<arrayLechuga.size(); ll++) {

			System.out.println();
			System.out.println("      ------ DATOS LECHUGA " + (ll+1) +" Y DISTRIBUIDOR ------ \n");

			System.out.println("Tipo de lechuga: "+arrayLechuga.get(ll).getTipoLechuga() );
            System.out.println("Procedencia: "+arrayLechuga.get(ll).getProcedencia());
            System.out.println("Color : "+arrayLechuga.get(ll).getColor() );
            System.out.println("Euros Unidad: "+arrayLechuga.get(ll).getEurosUnidad());

            System.out.println();

            // Lechuga.java (Distribuidor) -- Distribuidor.java (Nombre)
			System.out.println("Nombre Distribuidor: " + arrayLechuga.get(ll).getDistribuidor().getNombre());
			System.out.println("C.I.F.: " + arrayLechuga.get(ll).getDistribuidor().getCif());

			System.out.println("Dirección: ");
			// Lechuga.java (Distribuidor) -- Distribuidor.java (Nombre, Direccion) -- Direccion.java (Pais)
			System.out.println("   País: " + arrayLechuga.get(ll).getDistribuidor().getDireccion().getPais());
			System.out.println("   Provincia: " + arrayLechuga.get(ll).getDistribuidor().getDireccion().getProvincia());
			System.out.println("   Ciudad: " + arrayLechuga.get(ll).getDistribuidor().getDireccion().getCiudad());
			System.out.println("   Calle: " + arrayLechuga.get(ll).getDistribuidor().getDireccion().getCalle());
			System.out.println("   Piso: " + arrayLechuga.get(ll).getDistribuidor().getDireccion().getPiso());
			System.out.println("   Letra: " + arrayLechuga.get(ll).getDistribuidor().getDireccion().getLetra());
			System.out.println("   Código Postal: " + arrayLechuga.get(ll).getDistribuidor().getDireccion().getCodigoPostal());

			System.out.println("Contacto de Persona: ");
			// Lechuga.java (Distribuidor) -- Distribuidor.java (Nombre, PersonaContacto) -- Contacto.java (Dni)
			System.out.println("   DNI: " + arrayLechuga.get(ll).getDistribuidor().getPersonaContacto().getDni());
			System.out.println("   Nombre: " + arrayLechuga.get(ll).getDistribuidor().getPersonaContacto().getNombre());
			System.out.println("   Apellido: " + arrayLechuga.get(ll).getDistribuidor().getPersonaContacto().getApellido());
			System.out.println("   Edad: " + arrayLechuga.get(ll).getDistribuidor().getPersonaContacto().getEdad());
			System.out.println("   Nacionalidad: " + arrayLechuga.get(ll).getDistribuidor().getPersonaContacto().getNacionalidad());
			System.out.println("   Fecha de Nacimiento: " + arrayLechuga.get(ll).getDistribuidor().getPersonaContacto().getNacimiento());
			System.out.println("   Sexo: " + arrayLechuga.get(ll).getDistribuidor().getPersonaContacto().getSexo());
			System.out.println("   Telefono: " + arrayLechuga.get(ll).getDistribuidor().getPersonaContacto().getTelefono());
			System.out.println("   E-mail: " + arrayLechuga.get(ll).getDistribuidor().getPersonaContacto().getEmail());
			System.out.println("--------------------------------");
			System.out.print("");
		}


		// Leche

		ArrayList <Leche> arrayLeche = new ArrayList <Leche> ();

		System.out.println("\n      ------ LECHES ------ \n");
		System.out.println("A continuación, introduciremos dos leches.");

		for (int le=0; le<2; le++) {

			Leche leche = new Leche ();
			// Para enviar el nombre del distribuidor
			Distribuidor distribuidor = new Distribuidor ();

			System.out.print("Introduce el tipo de Leche: ");
			leche.setTipo(sc.next());

			System.out.print("Procedencia: ");
			leche.setProcedencia(sc.next());

			System.out.print("Introduce el precio por litro: ");
			leche.setEurosLitro(sc.nextDouble());

			System.out.print("Introduce el distribuidor de la Leche: ");
			String distribuidorle = sc.next();
			distribuidor.setNombre(distribuidorle);

			for (int q=0; q<arrayDistribuidor.size(); q++) {

				if (distribuidorle.equalsIgnoreCase(arrayDistribuidor.get(q).getNombre())) {

					leche.setDistribuidor(arrayDistribuidor.get(q));
				}
			}

			arrayLeche.add(leche);

			System.out.println();
		}

		for (int lee=0; lee<arrayLeche.size(); lee++) {

			System.out.println();
			System.out.println("      ------ DATOS LECHE " + (lee+1) +" Y DISTRIBUIDOR ------ \n");

			System.out.println("Tipo de leche: "+arrayLeche.get(lee).getTipo() );
            System.out.println("Procedencia: "+arrayLeche.get(lee).getProcedencia());
            System.out.println("Euros Unidad: "+arrayLeche.get(lee).getEurosLitro());

            System.out.println();

            // Leche.java (Distribuidor) -- Distribuidor.java (Nombre)
			System.out.println("Nombre Distribuidor: " + arrayLeche.get(lee).getDistribuidor().getNombre());
			System.out.println("C.I.F.: " + arrayLeche.get(lee).getDistribuidor().getCif());

			System.out.println("Dirección: ");
			// Leche.java (Distribuidor) -- Distribuidor.java (Nombre, Direccion) -- Direccion.java (Pais)
			System.out.println("   País: " + arrayLeche.get(lee).getDistribuidor().getDireccion().getPais());
			System.out.println("   Provincia: " + arrayLeche.get(lee).getDistribuidor().getDireccion().getProvincia());
			System.out.println("   Ciudad: " + arrayLeche.get(lee).getDistribuidor().getDireccion().getCiudad());
			System.out.println("   Calle: " + arrayLeche.get(lee).getDistribuidor().getDireccion().getCalle());
			System.out.println("   Piso: " + arrayLeche.get(lee).getDistribuidor().getDireccion().getPiso());
			System.out.println("   Letra: " + arrayLeche.get(lee).getDistribuidor().getDireccion().getLetra());
			System.out.println("   Código Postal: " + arrayLeche.get(lee).getDistribuidor().getDireccion().getCodigoPostal());

			System.out.println("Contacto de Persona: ");
			// Leche.java (Distribuidor) -- Distribuidor.java (Nombre, PersonaContacto) -- Contacto.java (Dni)
			System.out.println("   DNI: " + arrayLeche.get(lee).getDistribuidor().getPersonaContacto().getDni());
			System.out.println("   Nombre: " + arrayLeche.get(lee).getDistribuidor().getPersonaContacto().getNombre());
			System.out.println("   Apellido: " + arrayLeche.get(lee).getDistribuidor().getPersonaContacto().getApellido());
			System.out.println("   Edad: " + arrayLeche.get(lee).getDistribuidor().getPersonaContacto().getEdad());
			System.out.println("   Nacionalidad: " + arrayLeche.get(lee).getDistribuidor().getPersonaContacto().getNacionalidad());
			System.out.println("   Fecha de Nacimiento: " + arrayLeche.get(lee).getDistribuidor().getPersonaContacto().getNacimiento());
			System.out.println("   Sexo: " + arrayLeche.get(lee).getDistribuidor().getPersonaContacto().getSexo());
			System.out.println("   Telefono: " + arrayLeche.get(lee).getDistribuidor().getPersonaContacto().getTelefono());
			System.out.println("   E-mail: " + arrayLeche.get(lee).getDistribuidor().getPersonaContacto().getEmail());
			System.out.println("--------------------------------");
			System.out.print("");
		}
	}
}