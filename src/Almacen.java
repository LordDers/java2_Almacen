import java.io.*;
import java.util.*;

public class Almacen {

	public static void main (String args[]) {

		ArrayList <Distribuidor> arrayDistribuidor = new ArrayList <Distribuidor> ();
		ArrayList <Cliente> arrayCliente = new ArrayList <Cliente> ();

		Scanner sc = new Scanner (System.in);

		int opcion;

		System.out.println("          MENU:");
		System.out.println("1. Mostrar distribuidores");
		System.out.println("2. Introducir Manzanas");
		System.out.println("3. Introducir Lechuga");
		System.out.println("4. Introducir Leches");
		System.out.println("5. Mostrar clientes");
		System.out.println("6. Cesta");
		System.out.println("66. SALIR");

		System.out.print("\nIntroduce una opcion: ");
		opcion = sc.nextInt();

		// Leer "distribuidores.txt"
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

				// Separamos las lineas obtenidas (linea) mediante ", " y lo guardamos en "camposSeparados"
				camposSeparados = linea.split(", ");

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

		} catch(IOException e) {
			System.out.println("Error E/S: "+e);
		}

		// Leer "clientes.txt"
		try {

			BufferedReader br2 = new BufferedReader(new FileReader("clientes.txt"));

			String linea2 = br2.readLine();

			// Creamos un array de tipo String para separar los campos del fichero
			String [] camposSeparados2 = null;

			while (linea2 != null) {

				// Creamos los objetos que participan en el fichero "clientes.txt"
				Cliente cliente = new Cliente ();
				Direccion direccion2 = new Direccion ();

				// Separamos las lineas obtenidas (linea2) mediante ", " y lo guardamos en "camposSeparados2"
				camposSeparados2 = linea2.split(", ");

				// Introducimos los valores capturados del fichero en los objetos creados
				cliente.setNombre(camposSeparados2[0]);
				cliente.setApellidos(camposSeparados2[1]);
				cliente.setDni(camposSeparados2[2]);

				direccion2.setPais(camposSeparados2[3]);
				direccion2.setProvincia(camposSeparados2[4]);
				direccion2.setCiudad(camposSeparados2[5]);
				direccion2.setCalle(camposSeparados2[6]);
				direccion2.setPiso(Integer.parseInt(camposSeparados2[7]));
				direccion2.setLetra(camposSeparados2[8].charAt(0));
				direccion2.setCodigoPostal(Integer.parseInt(camposSeparados2[9]));

				cliente.setNumSocio(Double.parseDouble(camposSeparados2[10]));
				cliente.setDescuento(Double.parseDouble(camposSeparados2[11]));

				// Introducimos los valores(objetos) de "direccion2" en "cliente"
				cliente.setDireccion(direccion2);

				// Añadimos el objeto "cliente" al ArrayList "arrayCliente"
				arrayCliente.add(cliente);

				linea2 = br2.readLine();
			}
		} catch(IOException e) {
			System.out.println("Error E/S: "+e);
		}

		switch (opcion) {

			case 1: {

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
				break;
			}

			// ---------------- 3.12 ----------------

			// Manzanas

			case 2: {

				ArrayList <Manzana> arrayManzana = new ArrayList <Manzana> ();

				System.out.println();
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

							// Asignamos el valor del distribuidor al objeto manzana
							manzana.setDistribuidor(arrayDistribuidor.get(q));
						}
					}

					// Añadimos el objeto "manzana" al ArrayList "arrayManzana"
					arrayManzana.add(manzana);

					System.out.println();
				}

				for(int mm=0; mm<arrayManzana.size(); mm++) {

					System.out.println();
					System.out.println("      ------ DATOS MANZANA " + (mm+1) + " Y DISTRIBUIDOR ------ \n");

					System.out.println("Tipo de manzana: " + arrayManzana.get(mm).getTipoManzana() );
					System.out.println("Procedencia: " + arrayManzana.get(mm).getProcedencia());
					System.out.println("Color : " + arrayManzana.get(mm).getColor() );
					System.out.println("Euros Kilo: " + arrayManzana.get(mm).getEurosKilo());

					System.out.println();

					// Manzana.java (Distribuidor) -- Distribuidor.java (Nombre)
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
				break;
			}


			// Lechuga

			case 3: {

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

						// Si el nombre del distribuidor introducido coincide con uno del arraylist (distribuidores.txt)
						if (distribuidorl.equalsIgnoreCase(arrayDistribuidor.get(q).getNombre())) {

							// Asignamos el valor del distribuidor al objeto lechuga
							lechuga.setDistribuidor(arrayDistribuidor.get(q));
						}
					}

					// Añadimos el objeto "lechuga" al ArrayList "arrayLechuga"
					arrayLechuga.add(lechuga);

					System.out.println();
				}

				for(int ll=0; ll<arrayLechuga.size(); ll++) {

					System.out.println();
					System.out.println("      ------ DATOS LECHUGA " + (ll+1) + " Y DISTRIBUIDOR ------ \n");

					System.out.println("Tipo de lechuga: " + arrayLechuga.get(ll).getTipoLechuga() );
					System.out.println("Procedencia: " + arrayLechuga.get(ll).getProcedencia());
					System.out.println("Color : " + arrayLechuga.get(ll).getColor() );
					System.out.println("Euros Unidad: " + arrayLechuga.get(ll).getEurosUnidad());

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
				break;
			}


			// Leche

			case 4: {

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

						// Si el nombre del distribuidor introducido coincide con uno del arraylist (distribuidores.txt)
						if (distribuidorle.equalsIgnoreCase(arrayDistribuidor.get(q).getNombre())) {

							// Asignamos el valor del distribuidor al objeto leche
							leche.setDistribuidor(arrayDistribuidor.get(q));
						}
					}

					// Añadimos el objeto "leche" al ArrayList "arrayLeche"
					arrayLeche.add(leche);

					System.out.println();
				}

				for (int lee=0; lee<arrayLeche.size(); lee++) {

					System.out.println();
					System.out.println("      ------ DATOS LECHE " + (lee+1) + " Y DISTRIBUIDOR ------ \n");

					System.out.println("Tipo de leche: " + arrayLeche.get(lee).getTipo() );
					System.out.println("Procedencia: " + arrayLeche.get(lee).getProcedencia());
					System.out.println("Euros Unidad: " + arrayLeche.get(lee).getEurosLitro());

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
				break;
			}

			// ---------------- 3.13 ----------------

				// ArrayList <Cliente> arrayCliente = new ArrayList <Cliente> ();

			case 5: {
				
				for(int c=0; c<arrayCliente.size(); c++) {

					System.out.println();
					System.out.println("      ------ DATOS CLIENTE " + (c+1) + " ------ \n");

					System.out.println("Nombre Cliente: " + arrayCliente.get(c).getNombre());
					System.out.println("Apellido Cliente: " + arrayCliente.get(c).getApellidos());
					System.out.println("DNI: " + arrayCliente.get(c).getDni());

					System.out.println("Dirección: ");
					// Cliente.java (Direccion) -- Direccion.java (Pais)
					System.out.println("   País: " + arrayCliente.get(c).getDireccion().getPais());
					System.out.println("   Provincia: " + arrayCliente.get(c).getDireccion().getProvincia());
					System.out.println("   Ciudad: " + arrayCliente.get(c).getDireccion().getCiudad());
					System.out.println("   Calle: " + arrayCliente.get(c).getDireccion().getCalle());
					System.out.println("   Piso: " + arrayCliente.get(c).getDireccion().getPiso());
					System.out.println("   Letra: " + arrayCliente.get(c).getDireccion().getLetra());
					System.out.println("   Código Postal: " + arrayCliente.get(c).getDireccion().getCodigoPostal());

					System.out.println("Número de Socio: " + arrayCliente.get(c).getNumSocio());
					System.out.println("Descuento: " + arrayCliente.get(c).getDescuento() + "%");
					System.out.println("--------------------------------");
					System.out.print("");
				}
				break;
			}

			// ---------------- 3.14 CESTA ----------------

			case 6: {

				Cesta cesta = new Cesta ();

				System.out.println("\n      ------ CESTA ------ \n");

				double descuentocliente = 0.0;

				char mas = 's';

				boolean numsocio = false;

				do {

					System.out.print("Introduce el número de socio: ");
					int numeroSocio = sc.nextInt();

					for (int cli=0; cli<arrayCliente.size(); cli++) {

						// Si el numero de socio introducido coincide con uno del arraylist (clientes.txt)
						if (numeroSocio == (arrayCliente.get(cli).getNumSocio())) {

							// Mostramos los datos del cliente
							System.out.println("Nombre: " + arrayCliente.get(cli).getNombre());
							System.out.println("Apellido: " + arrayCliente.get(cli).getApellidos());
							System.out.println("DNI: " + arrayCliente.get(cli).getDni());
							System.out.println("Numero Socio: " + arrayCliente.get(cli).getNumSocio());

							numsocio = true;
							//System.out.print("Si es: " + numsocio);

							// Asignamos a la variable "descuentocliente" el descuento que tiene
							descuentocliente = arrayCliente.get(cli).getDescuento();
							break;
						}
						else {

							numsocio = false;
							//System.out.print("No es: " + numsocio);
							
						}
					}
				} while (numsocio == false);

				System.out.println();

				// Bucle para ver si quiere pedir mas, en caso de pulsar 'n', sale
				do {

					System.out.println("Introduce el producto a pedir, Manzana, Lechuga o Leche: ");
					String productopedir = sc.next();

					System.out.println("\nIntroduce el código de barras a pedir: ");
					int codbarrasp = sc.nextInt();

					int cantidad = 0;
					double euro = 0.0;
					double total = 0.0;
					String tipomanzana = null;
					String tipolechuga = null;
					String tipoleche = null;

					ArrayList <Manzana> arrayManzanaCesta = new ArrayList <Manzana> ();
					ArrayList <Lechuga> arrayLechugaCesta = new ArrayList <Lechuga> ();
					ArrayList <Leche> arrayLecheCesta = new ArrayList <Leche> ();
			
					try {

						// Leemos "pro.txt"
						BufferedReader br3 = new BufferedReader(new FileReader("productos.txt"));

						String linea3 = br3.readLine();

						// Creamos un array de tipo String para separar los campos del fichero
						String [] camposSeparados3 = null;

						while (linea3 != null) {

							// Creamos los objetos que participan en el fichero "productos.txt"
							Distribuidor distribuidorCesta = new Distribuidor ();
							Direccion direccionCesta = new Direccion ();
							//Contacto contactoCesta = new Contacto ();

							// Separamos las lineas obtenidas (linea3) mediante ", " y lo guardamos en "camposSeparados3"
							camposSeparados3 = linea3.split(", ");

							// Comprobamos si el codigo de barras introducido coincide con uno del fichero "pro.txt"
							if (codbarrasp == Integer.parseInt(camposSeparados3[1])) {

								// Comprobamos si el producto es igual al producto a pedir (Manzana)
								if ((camposSeparados3[0].equalsIgnoreCase(productopedir)) && productopedir.equalsIgnoreCase("Manzana")) {

									// Creamos el objeto "manzanaCesta"
									Manzana manzanaCesta = new Manzana ();

									System.out.println();

									// Enviamos valores recogidos del fichero "productos.txt" a cada objeto "manzanaCesta", "distribuidorCesta" y "direccionCesta"
									manzanaCesta.setTipoManzana(camposSeparados3[2]);
									manzanaCesta.setProcedencia(camposSeparados3[3]);
									manzanaCesta.setColor(camposSeparados3[4]);
									manzanaCesta.setEurosKilo(Double.parseDouble(camposSeparados3[5]));

									distribuidorCesta.setNombre(camposSeparados3[6]);
									distribuidorCesta.setCif(camposSeparados3[7]);

									direccionCesta.setPais(camposSeparados3[8]);
									direccionCesta.setProvincia(camposSeparados3[9]);
									direccionCesta.setCiudad(camposSeparados3[10]);		
									direccionCesta.setCalle(camposSeparados3[11]);
									direccionCesta.setPiso(Integer.parseInt(camposSeparados3[12]));
									direccionCesta.setLetra(camposSeparados3[13].charAt(0));
									direccionCesta.setCodigoPostal(Integer.parseInt(camposSeparados3[14]));

									manzanaCesta.setCodigoBarras(Integer.parseInt(camposSeparados3[1]));

									// Mostramos la información respecto al producto introducido a través del código de barras
									System.out.println(" ------ Datos del producto deseado ------");
									System.out.println("Tipo Manzana: " + manzanaCesta.getTipoManzana());
									// Asignamos en "tipomanzana" el valor del tipo de manzana recogido del objeto
									tipomanzana = manzanaCesta.getTipoManzana();
									System.out.println("Procedencia: " + manzanaCesta.getProcedencia());
									System.out.println("Color: " + manzanaCesta.getColor());
									System.out.println("Euros Unidad: " + manzanaCesta.getEurosKilo());

									// Asignamos a la variable "euro" el valor que vale dicho producto
									euro = manzanaCesta.getEurosKilo();

									System.out.print("\n¿Cuántas deseas pedir? ");
									cantidad = sc.nextInt();

									System.out.println();

									// Asignamos a la variable "total" la multiplicación de la cantidad deseada por lo que vale
									total = (cantidad * euro);

									// Enviamos al objeto "cesta" los valores "euro" y "descuentocliente" para calcular el importe
									cesta.setImporteCompra(total, descuentocliente);

									// Introducimos los valores(objetos) de "distribuidorCesta"  en "manzanaCesta"
									manzanaCesta.setDistribuidor(distribuidorCesta);

									// Añadimos el objeto "manzanaCesta" al ArrayList "arrayManzanaCesta"
									arrayManzanaCesta.add(manzanaCesta);

									for (int mc=0; mc<arrayManzanaCesta.size(); mc++) {

										System.out.println(" ------ Has pedido ------");
										System.out.println("Tipo Manzana: " + arrayManzanaCesta.get(mc).getTipoManzana());
										System.out.println("Distribuidor: " + arrayManzanaCesta.get(mc).getDistribuidor().getNombre());
										System.out.println("Cantidad pedida: " + cantidad);
										System.out.println("Euro por Unidad: " + arrayManzanaCesta.get(mc).getEurosKilo() + "€");
										System.out.println("Total: " + total + "€");
										System.out.println("Descuento: " + descuentocliente + "%");
										// Recogemos el importe a pagar "cesta.getImporteCompra()"
										System.out.println("Total a pagar por " + tipomanzana + ": " + cesta.getImporteCompra() + "€");
									}
								}

								// Comprobamos si el producto es igual al producto a pedir (Lechuga)
								else if ((camposSeparados3[0].equalsIgnoreCase(productopedir)) && productopedir.equalsIgnoreCase("Lechuga")) {

									// Creamos el objeto "lehugaCesta"
									Lechuga lechugaCesta = new Lechuga ();

									System.out.println();

									// Enviamos valores recogidos del fichero "productos.txt" a cada objeto "manzanaCesta", "distribuidorCesta" y "direccionCesta"
									lechugaCesta.setTipoLechuga(camposSeparados3[2]);
									lechugaCesta.setProcedencia(camposSeparados3[3]);
									lechugaCesta.setColor(camposSeparados3[4]);
									lechugaCesta.setEurosUnidad(Double.parseDouble(camposSeparados3[5]));

									distribuidorCesta.setNombre(camposSeparados3[6]);
									distribuidorCesta.setCif(camposSeparados3[7]);

									direccionCesta.setPais(camposSeparados3[8]);
									direccionCesta.setProvincia(camposSeparados3[9]);
									direccionCesta.setCiudad(camposSeparados3[10]);		
									direccionCesta.setCalle(camposSeparados3[11]);
									direccionCesta.setPiso(Integer.parseInt(camposSeparados3[12]));
									direccionCesta.setLetra(camposSeparados3[13].charAt(0));
									direccionCesta.setCodigoPostal(Integer.parseInt(camposSeparados3[14]));

									lechugaCesta.setCodigoBarras(Integer.parseInt(camposSeparados3[1]));

									// Mostramos la información respecto al producto introducido a través del código de barras
									System.out.println(" ------ Datos del producto deseado ------");
									System.out.println("Tipo Lechuga: " + lechugaCesta.getTipoLechuga());
									// Guardamos en "tipolechuga"  el valor del tipo de lechuga recogido del objeto
									tipolechuga = lechugaCesta.getTipoLechuga();
									System.out.println("Procedencia: " + lechugaCesta.getProcedencia());
									System.out.println("Color: " + lechugaCesta.getColor());
									System.out.println("Euros Unidad: " + lechugaCesta.getEurosUnidad());

									// Asignamos a la variable "euro" el valor que vale dicho producto
									euro = lechugaCesta.getEurosUnidad();

									System.out.print("\n¿Cuántas deseas pedir? ");
									cantidad = sc.nextInt();

									System.out.println();

									// Asignamos a la variable "total" la multiplicación de la cantidad deseada por lo que vale
									total = (cantidad * euro);

									// Enviamos al objeto "cesta" los valores "euro" y "descuentocliente" para calcular el importe
									cesta.setImporteCompra(total, descuentocliente);

									// Introducimos los valores(objetos) de "distribuidorCesta"  en "lechugaCesta"
									lechugaCesta.setDistribuidor(distribuidorCesta);

									// Añadimos el objeto "lechugaCesta" al ArrayList "arrayLechugaCesta"
									arrayLechugaCesta.add(lechugaCesta);

									for (int mc=0; mc<arrayLechugaCesta.size(); mc++) {

										System.out.println(" ------ Has pedido ------");
										System.out.println("Tipo Lechuga: " + arrayLechugaCesta.get(mc).getTipoLechuga());
										System.out.println("Distribuidor: " + arrayLechugaCesta.get(mc).getDistribuidor().getNombre());
										System.out.println("Cantidad pedida: " + cantidad);
										System.out.println("Euro por Unidad: " + arrayLechugaCesta.get(mc).getEurosUnidad() + "€");
										System.out.println("Total: " + total + "€");
										System.out.println("Descuento: " + descuentocliente + "%");
										// Recogemos el importe a pagar "cesta.getImporteCompra()"
										System.out.println("Total a pagar por " + tipolechuga + ": " + cesta.getImporteCompra() + "€");
									}
								}

								// Comprobamos si el producto es igual al producto a pedir (Leche)
								else if ((camposSeparados3[0].equalsIgnoreCase(productopedir)) && productopedir.equalsIgnoreCase("Leche")) {

									// Creamos el objeto "manzanaCesta"
									Leche lecheCesta = new Leche ();

									System.out.println();

									// Enviamos valores recogidos del fichero "productos.txt" a cada objeto "manzanaCesta", "distribuidorCesta" y "direccionCesta"
									lecheCesta.setTipo(camposSeparados3[2]);
									lecheCesta.setProcedencia(camposSeparados3[3]);
									lecheCesta.setEurosLitro(Double.parseDouble(camposSeparados3[4]));

									distribuidorCesta.setNombre(camposSeparados3[5]);
									distribuidorCesta.setCif(camposSeparados3[6]);

									direccionCesta.setPais(camposSeparados3[7]);
									direccionCesta.setProvincia(camposSeparados3[8]);
									direccionCesta.setCiudad(camposSeparados3[9]);		
									direccionCesta.setCalle(camposSeparados3[10]);
									direccionCesta.setPiso(Integer.parseInt(camposSeparados3[11]));
									direccionCesta.setLetra(camposSeparados3[12].charAt(0));
									direccionCesta.setCodigoPostal(Integer.parseInt(camposSeparados3[13]));

									lecheCesta.setCodigoBarras(Integer.parseInt(camposSeparados3[1]));

									// Mostramos la información respecto al producto introducido a través del código de barras
									System.out.println(" ------ Datos del producto deseado ------");
									System.out.println("Tipo Leche: " + lecheCesta.getTipo());
									// Guardamos en "tipoleche" el valor del tipo de lechuga recogido del objeto
									tipoleche = lecheCesta.getTipo();
									System.out.println("Procedencia: " + lecheCesta.getProcedencia());
									System.out.println("Euros Litro: " + lecheCesta.getEurosLitro());

									// Asignamos a la variable "euro" el valor que vale dicho producto
									euro = lecheCesta.getEurosLitro();

									System.out.print("\n¿Cuántas deseas pedir? ");
									cantidad = sc.nextInt();

									System.out.println();

									// Asignamos a la variable "total" la multiplicación de la cantidad deseada por lo que vale
									total = (cantidad * euro);

									// Enviamos al objeto "cesta" los valores "euro" y "descuentocliente" para calcular el importe
									cesta.setImporteCompra(total, descuentocliente);

									// Introducimos los valores(objetos) de "distribuidorCesta"  en "lecheCesta"
									lecheCesta.setDistribuidor(distribuidorCesta);

									// Añadimos el objeto "lecheCesta" al ArrayList "arrayLecheCesta"
									arrayLecheCesta.add(lecheCesta);

									for (int mc=0; mc<arrayLecheCesta.size(); mc++) {

										System.out.println(" ------ Has pedido ------");
										System.out.println("Tipo Leche: " + arrayLecheCesta.get(mc).getTipo());
										System.out.println("Distribuidor: " + arrayLecheCesta.get(mc).getDistribuidor().getNombre());
										System.out.println("Cantidad pedida: " + cantidad);
										System.out.println("Euro por Litro: " + arrayLecheCesta.get(mc).getEurosLitro() + "€");
										System.out.println("Total: " + total + "€");
										System.out.println("Descuento: " + descuentocliente + "%");
										// Recogemos el importe a pagar "cesta.getImporteCompra()"
										System.out.println("Total a pagar por " + tipoleche + ": " + cesta.getImporteCompra() + "€");
									}
								}
								else {

									System.out.println("El código de barras no pertenece al producto seleccionado");
								}
							}
							linea3 = br3.readLine();
						}

						System.out.println("\n ------ ------ ------ ------ ------ ------\n");
						System.out.print("¿Desea pedir algo más S/N? ");
						mas = sc.next().charAt(0);

					} catch(IOException e) {
						System.out.println("Error E/S: "+e);
					}
				} while (mas == 'S' || mas == 's'); {
					System.out.println("Gracias por su visita.");
				}
				break;
			}

			case 66: {

				System.out.println();
				System.out.println("Has decidido salir.");
				break;
			}

			default: {

				System.out.println();
				System.out.println("No has seleccionado una opción válida.");
			}
		}
	}
}
