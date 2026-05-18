package Repaso_Tema_10_11.Inventario.Controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import Repaso_Tema_10_11.Inventario.Model.Producto;

public class ProductoController {
    private static final String PATH_PRODUCTO = "producto.dat";
    private static Map<Integer, Producto> m = new HashMap<>();

    public void save() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH_PRODUCTO))) {
            oos.writeObject(m);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void read() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH_PRODUCTO))) {
            m = (HashMap<Integer, Producto>) ois.readObject();
        } catch (IOException | ClassNotFoundException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean insert(Integer id, Producto p) {
        if (m.containsKey(id)) {
            return false;
        }

        m.put(id, p);
        save();
        return true;
    }

    public boolean show() {
        if (m.isEmpty()) {
            return false;
        }

        for (Producto producto : m.values()) {
            System.out.println(producto);
        }
        return true;
    }
}
