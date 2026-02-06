package Tema9_Intefaces.UT9_Sistema_Gestion_Pagos.Classes;

import java.util.UUID;
import Tema9_Intefaces.UT9_Sistema_Gestion_Pagos.Interfaces.MetodoPago;

public class Cripto implements MetodoPago {

    private String direccionWallet;

    public Cripto(String direccionWallet) {
        this.direccionWallet = direccionWallet;
    }

    @Override
    public void procesarPago(double importe) {
        String hash = UUID.randomUUID().toString();
				System.out.println("Direccion Wallet: "+direccionWallet);
        System.out.println("Pago de " + importe + "€ realizado con Criptomoneda");
        System.out.println("Hash de la transacción: " + hash);
    }

    @Override
    public String obtenerNombre() {
        return "Criptomoneda";
    }
}