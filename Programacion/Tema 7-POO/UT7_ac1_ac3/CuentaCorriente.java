package UT7_ac1;
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
	
			// CONSTRUCTORES
			CuentaCorriente(String DNI, String nombreTitular) {
				this(DNI, nombreTitular, 0, null);
			}
			
			CuentaCorriente(String DNI, String nombreTitular, int sueldo, String nombreBanco) {
				this.DNI = DNI;
				this.nombreTitular = nombreTitular;
				this.sueldo = sueldo;
				setNombreBanco(nombreBanco);
			}
	
			static CuentaCorriente[] cuentas = new CuentaCorriente[0];
	
			// GETERS/SETERS
			public String getNombreBanco() {
				return nombreBanco;
			}
			
			static void setNombreBanco(String nuevoBanco) {
				if(nombreBanco.equals(null)) System.out.println("Error: El nombre del banco no puede ser null");
				else {
					nombreBanco = nuevoBanco;
				}
			}
			
			
			// METODOS
			// Crear cuenta
			static CuentaCorriente[] crearCuenta() {
				System.out.print("Dime tu DNI: ");
				String dni = sc.next();
				System.out.print("Dime el nombre del titular: ");
				String nombretitular = sc.next();
	
				CuentaCorriente nuevaCuenta = new CuentaCorriente(dni, nombretitular);
	
				cuentas = Arrays.copyOf(cuentas, cuentas.length + 1);
				cuentas[cuentas.length - 1] = nuevaCuenta;
				System.out.println("Cuenta creada correctamente, saldo inicial 0€");
				
				return cuentas;
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
				
				if (cuentaSeleccionada == null) {  // <--- comprobación sencilla
					System.out.println("Error: No existe ninguna cuenta con ese DNI.");
					return 0;  // termina el método
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
					System.out.print("Cuanto dinero desea sacar: ");
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
				System.out.println("Sueldo: " + sueldo +"€");
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
		
		
