package Tema11_Colecciones.UT11_Clase_Generica_Simple;

public class Par<K, V> {
    private K clave;
    private V valor;

    public Par(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public K getClave() { return clave; }
    public V getValor() { return valor; }

    public void mostrar() {
        System.out.println("Clave: " + clave + ", Valor: " + valor);
    }
}
