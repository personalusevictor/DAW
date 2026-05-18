package Repaso_Tema_10_11.Inventario.Model;

import java.io.Serializable;

public class Producto implements Serializable {
    private static final String DEFAULT_NOMBRE = "Desconocido";
    private final Double DEFAULT_STOCK = 0.0;

    private Integer id;
    private String nombre;
    private Double stock;

    public Producto(Integer id, String nombre, Double stock) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.trim().isEmpty() || nombre == null) {
            this.nombre = DEFAULT_NOMBRE;
        } else {
            this.nombre = nombre;
        }
    }

    public Double getStock() {
        return stock;
    }

    public void setStock(Double stock) {
        if (stock < 0) {
            this.stock = DEFAULT_STOCK;
        } else {
            this.stock = stock;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Producto other = (Producto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("%n==== Producto =====%nID: %d%nNombre: %s%nStock: %.2f", id, nombre, stock);
    }

}
