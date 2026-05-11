package org.club;

public class MediaItem {
    private String titulo;
    private String tipo;
    private String duracion;
    private String anio;
    private String valoracion;

    public MediaItem(String titulo, String tipo, String duracion, String anio, String valoracion) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.duracion = duracion;
        this.anio = anio;
        this.valoracion = valoracion;
    }

    public String getTitulo()     { return titulo; }
    public String getTipo()       { return tipo; }
    public String getDuracion()   { return duracion; }
    public String getAnio()       { return anio; }
    public String getValoracion() { return valoracion; }

    // Array dinámico manual
    private static MediaItem[] items = new MediaItem[2];
    private static int cantidad = 0;

    public static void agregar(MediaItem item) {
        if (cantidad == items.length) {
            // Duplicar tamaño cuando se llena
            MediaItem[] nuevo = new MediaItem[items.length * 2];
            for (int i = 0; i < cantidad; i++) {
                nuevo[i] = items[i];
            }
            items = nuevo;
        }
        items[cantidad] = item;
        cantidad++;
    }
		
		public static void eliminar(int index) {
			for (int i = index; i < cantidad - 1; i++) {
					items[i] = items[i + 1];
			}
			items[cantidad - 1] = null;
			cantidad--;
	}

    public static MediaItem get(int i) {
        return items[i];
    }

    public static int size() {
        return cantidad;
    }

    public static boolean isEmpty() {
        return cantidad == 0;
    }
}