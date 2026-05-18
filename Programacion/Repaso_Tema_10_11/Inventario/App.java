package Repaso_Tema_10_11.Inventario;

import Repaso_Tema_10_11.Inventario.Controller.ProductoController;
import Repaso_Tema_10_11.Inventario.Model.Producto;

public class App {

    public static void main(String[] args) {
        ProductoController ut1 = new ProductoController();
        ut1.read();

        System.out.println(ut1.insert(1, new Producto(1, "Raúl", 1000.0)));
        ut1.show();

        ut1.save();

    }
}
