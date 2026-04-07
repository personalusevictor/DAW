package Tema11_Colecciones.UT11_Clase_Generica_Simple;
public class Main {
    public static void main(String[] args) {
        // Instancia: String y Integer
        Par<String, Integer> edad = new Par<>("Juan", 30);
        edad.mostrar();
    }
}