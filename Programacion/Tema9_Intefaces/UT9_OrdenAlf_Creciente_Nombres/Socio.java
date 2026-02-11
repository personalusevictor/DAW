package Tema9_Intefaces.UT9_OrdenAlf_Creciente_Nombres;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Socio implements Comparable {

    int id; 
    String nombre;
    LocalDate fechaNacimiento;

    public Socio(int id, String nombre, String fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        //establecemos el formato español para las fechas:
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.fechaNacimiento = LocalDate.parse(fechaNacimiento, f);
    }

    int edad() {
        return (int) fechaNacimiento.until(LocalDate.now(), ChronoUnit.YEARS);
    }
    @Override
    public int compareTo(Object ob) {
        Socio otroSocio = (Socio) ob;
				return nombre.compareTo(otroSocio.nombre);
    }

    public String toString() {
        return "\nId: " + id + " Nombre: " + nombre + " Edad: " + edad();
    } 
}
