import java.util.*;
	/* ---------------------------
	   CLASE - 1: CUENTA CORRIENTE
	   ---------------------------*/
		 class CuentaCorriente {
			static final Scanner sc = new Scanner(System.in);
	
			// ATRIBUTOS
			String DNI;
			public String nombreTitular;
			private double sueldo;
			static String nombreBanco;
			Gestor gestor;
	
			// CONSTRUCTORES
			CuentaCorriente(String DNI, String nombreTitular) {
				this(DNI, nombreTitular, 0, null, null);
			}
			
			CuentaCorriente(String DNI, String nombreTitular, int sueldo, String nombreBanco) {
				this.DNI = DNI;
				this.nombreTitular = nombreTitular;
				this.sueldo = sueldo;
				setNombreBanco(nombreBanco);
				this.gestor = null;
			}
			
			CuentaCorriente(String DNI, String nombreTitular, int sueldo, String nombreBanco, Gestor gestor) {
				this.DNI = DNI;
				this.nombreTitular = nombreTitular;
				this.sueldo = sueldo;
				setNombreBanco(nombreBanco);
				this.gestor = gestor;
			}
	
			static CuentaCorriente[] cuentas = new CuentaCorriente[0];
			
			// GETERS/SETERS
			public String getNombreBanco() {
				return nombreBanco;
			}
			
			static void setNombreBanco(String nuevoBanco) {
					nombreBanco = nuevoBanco;
			}
			
			void AsignarGestor(Gestor g) {
				this.gestor = g;
				System.out.println("\nGestor asignado correctamente a la cuenta "+nombreTitular);
			}	
			// METODOS
			// Crear cuenta
			static CuentaCorriente[] crearCuenta() {
				System.out.print("Dime tu DNI: ");
				String dni = sc.next();
				System.out.print("Dime el nombre del titular: ");
				String nombretitular = sc.next();
				System.out.print("En que banco estas creando la cuenta: ");
				String nombreBanco = sc.next();
	
				CuentaCorriente nuevaCuenta = new CuentaCorriente(dni, nombretitular, 0, nombreBanco);
	
				cuentas = Arrays.copyOf(cuentas, cuentas.length + 1);
				cuentas[cuentas.length - 1] = nuevaCuenta;
				System.out.println("Cuenta creada correctamente, saldo inicial 0€");
				
				return cuentas;
			}
			
			static void AsignarGestorMenu() {
				if(cuentas.length == 0) {
					System.out.println("Error: No hay ninguna cuenta creada");
					return;
				}
				
				System.out.print("Dime el DNI de la cuenta a la que quieres asignar el gestor: ");
				String DNIBuscar = sc.next();
				
				CuentaCorriente cuenta = CuentaCorriente.buscarCuenta(DNIBuscar);
				
				if(cuenta == null) {
					System.out.println("Error: No hay ninguna cuenta con ese DNI");
					return;
				}
				
				System.out.print("Nombre del Gestor: ");
				String nombre = sc.next();
				System.out.print("Telefono del Gestor: ");
				String telefono = sc.next();
				System.out.print("Importe Maximo Permitido del Gestor (Si no desea que haya importe máximo dejalo en 0): ");
				double importemaximo = sc.nextDouble();
				
				Gestor g;
				
				if (importemaximo == 0) g = new Gestor(nombre, telefono);
				else g = new Gestor(nombre, telefono, importemaximo);
				
				cuenta.AsignarGestor(g);
			}
			
			// Sacar dinero
			static double sacarDinero() {
				double sueldoSacar;
				String dniCuenta;
	
				if (cuentas.length == 0) {
					System.out.println("Error: No hay ninguna cuenta creada");
					return 0;
				}
	
				System.out.print("Selecciona el DNI de tu cuenta: ");
				dniCuenta = sc.next();
				
				CuentaCorriente cuentaSeleccionada = CuentaCorriente.buscarCuenta(dniCuenta);
				
				if (cuentaSeleccionada == null) {
					System.out.println("Error: No existe ninguna cuenta con ese DNI.");
					return 0;
				}
	
				do {
					System.out.print("Cuanto dinero desea sacar: ");
					sueldoSacar = sc.nextDouble();
					if (sueldoSacar <= 0) {
						System.out.println("Error: El dinero a sacar debe ser mayor que 0.");
					} else if (!comprobacionSacar(cuentaSeleccionada, sueldoSacar)) {
					} else {
						cuentaSeleccionada.sueldo -= sueldoSacar;
						System.out.println("Dinero retirado correctamente. Nuevo saldo: " + cuentaSeleccionada.sueldo + "€");
						return sueldoSacar;
					}
				} while (true);
			}
			
			// Metodo auxiliar para comprobar si el hay saldo suficiente
			static boolean comprobacionSacar(CuentaCorriente cuenta, double sueldoSacar) {
				
				if(sueldoSacar > cuenta.sueldo) {
					System.out.println("Error: Sueldo insuficiente");
					return false;
				}
				return true;
			}
			
			static CuentaCorriente buscarCuenta(String dniBuscar){
				for(CuentaCorriente dato : cuentas) {
					if(dato.DNI.equals(dniBuscar)) return dato;
				}
				return null;
			}
	
			// Ingresar dinero
			static double ingresarDinero() {
				double sueldoIngresar;
				String dniCuenta;
	
				if (cuentas.length == 0) {
					System.out.println("Error: No hay ninguna cuenta creada");
					return 0;
				}
	
				System.out.print("Selecciona el DNI de tu cuenta: ");
				dniCuenta = sc.next();
				
				CuentaCorriente cuentaSeleccionada = CuentaCorriente.buscarCuenta(dniCuenta);
				
				if (cuentaSeleccionada == null) {
					System.out.println("Error: No existe ninguna cuenta con ese DNI.");
					return 0;  // termina el método
				}
				
				do {
					System.out.print("Cuanto dinero desea ingresar: ");
					sueldoIngresar = sc.nextDouble();
					if (sueldoIngresar <= 0) {
						System.out.println("Error: El dinero a ingresar debe ser mayor que 0.");
					} else {
						cuentaSeleccionada.sueldo += sueldoIngresar;
						System.out.println("Dinero ingresado correctamente. Nuevo saldo: " + cuentaSeleccionada.sueldo + "€");
						return sueldoIngresar;
					}
				} while (true);
			}
			
			// Mostrar un Usuario Unico
			void mostrarUnico() {
				System.out.println("Titular: " + nombreTitular);
				System.out.println("DNI: " + DNI);
				System.out.println("Sueldo: " + sueldo +"$");
				System.out.println("Banco: " + nombreBanco);
				System.out.println("-------------------------");
			}
			
			// Mostrar Información de todos los Usuarios
			static void mostrarInformacion() {
				if(cuentas.length == 0){
					System.out.println("Error: No hay ninguna cuenta creada");
					return;
				}
				
				
				System.out.println("--- Todas las cuentas ---");
				for(CuentaCorriente dato : cuentas) {
					dato.mostrarUnico();
				}
			}
		}
		
	