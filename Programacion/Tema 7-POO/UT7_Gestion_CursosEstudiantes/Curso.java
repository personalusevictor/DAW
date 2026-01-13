package UT7_Gestion_CursosEstudiantes;

public class Curso {
	
	/* ------------------
	   ATRIBUTOS PRIVADOS
	   ------------------ */
		 
	private String nombreCurso;
	private String codigo;
	private Estudiante estudiantes[];
	private int cantidadEstudiante;
	
	private static int contadorCursos = 1; // Contador de Cursos Existentes
	
	Curso (String nombreCurso, int CapacidadMaxima) {
		this.setNombreCurso(nombreCurso);
		generarCodigo();
		this.estudiantes = new Estudiante[CapacidadMaxima];
		this.cantidadEstudiante = 0;
	}
	
	/* -----------------
	   GETTERS Y SETTERS
	   ----------------- */

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		if(nombreCurso == null || nombreCurso.trim().isEmpty()) {
			System.out.println("Error: El nombre no es valido");
		} else {
			this.nombreCurso = nombreCurso.substring(0, 1).toUpperCase() + nombreCurso.substring(1);
		}
	}

	public String getCodigo() {
		return codigo;
	}
	
	public int getCapacidadMaxima() {
		return estudiantes.length;
	}
	
	public int getPlazasDisponibles() {
		return estudiantes.length - cantidadEstudiante;
	}

	/* ------------------------------------------
	   METODO PRIVADO - GENERAR CODIGO AUTOMATICO
	   ------------------------------------------ */

	private void generarCodigo() {
		this.codigo = String.format("CUR-%03d", contadorCursos); // %3d lo utilizo para que coja 3 numeros enteros.
		contadorCursos++;
	}
	
	/* -------------------
	   METODOS PRINCIPALES
	   ------------------- */
	
	public boolean hayEspacio() {
		return cantidadEstudiante < estudiantes.length;
	}
	
	public void agregarEstudiante(Estudiante nuevoEstudiante) {
		
		if(nuevoEstudiante == null ) {
			System.out.println("Error: El estudiante no puede ser nulo");
		}
		
		if(!hayEspacio()) {
			System.out.println("Error: No hay espacio en el curso");
		}
		
		estudiantes[cantidadEstudiante] = nuevoEstudiante;
		cantidadEstudiante++;
		
		System.out.println("Estudiante "+nuevoEstudiante.getNombre() + "añadido correctamente");
	
	/* -- OTRA FORMA DE HACERLO --
	nuevoEstudiante = new Estudiante(nombre, edad, promedio);
	
	estudiantes = arrays.CopyOf(estudiantes, estudiantes.length + 1);
	estudiantes[estudiantes.length - 1] = nuevoEstudiante;
	
	System.out.println("Estudiante" +nuevoEstudiante.getNombre() + "añadido correctamente");
	
	
	Cosas a tener en cuenta de este modo: tendrías que pasar por parametros los datos del estudiante, y rediseñar la clase main*/
	}
	
	public void mostrarInformacionCurso() {
		
		System.out.println("\n----------------------------");
		System.out.println("Nombre: "+getNombreCurso());
		System.out.println("Codigo: "+getCodigo());
		System.out.println("Capacidad Total: "+estudiantes.length);
		System.out.println("Estudiantes Inscritos: "+cantidadEstudiante);
		System.out.println("Plazas Disponibles: "+getPlazasDisponibles());
		System.out.println("----------------------------");
		
		if(cantidadEstudiante == 0) {
			System.out.println("No hay estudiantes inscritos");
		} else {
			System.out.println("Lista de estudiantes: \n");
			for (int i = 1; i < cantidadEstudiante; i++) {
				estudiantes[i - 1].mostrarInformacion();
			}
		}
	}
}
