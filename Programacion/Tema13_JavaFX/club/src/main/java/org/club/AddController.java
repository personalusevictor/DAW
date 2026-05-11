package org.club;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AddController {

    @FXML private TextField txtTitulo;
    @FXML private ComboBox<String> cmbTipo;
    @FXML private TextField txtDuracion;
    @FXML private TextField txtAnio;
    @FXML private ComboBox<String> cmbValoracion;
    @FXML private Label lblMensaje;

    @FXML
    private void initialize() {
        cmbTipo.getItems().addAll("Película", "Serie", "Documental", "Miniserie");
        cmbValoracion.getItems().addAll("⭐", "⭐⭐", "⭐⭐⭐", "⭐⭐⭐⭐", "⭐⭐⭐⭐⭐");
    }

    @FXML
    private void onGuardar() {
        String titulo = txtTitulo.getText().trim();
        String tipo = cmbTipo.getValue();
        String duracion = txtDuracion.getText().trim();
        String anio = txtAnio.getText().trim();
        String valoracion = cmbValoracion.getValue();

        if (titulo.isEmpty() || tipo == null || duracion.isEmpty()) {
            lblMensaje.setText("Rellena los campos obligatorios.");
            lblMensaje.setStyle("-fx-text-fill: #E24B4A;");
            return;
        }

        MediaItem.agregar(new MediaItem(titulo, tipo, duracion, anio, valoracion));
        lblMensaje.setText("¡Guardado correctamente!");
        lblMensaje.setStyle("-fx-text-fill: #1D9E75;");

        txtTitulo.clear();
        cmbTipo.setValue(null);
        txtDuracion.clear();
        txtAnio.clear();
        cmbValoracion.setValue(null);
    }

    @FXML
    private void onVolver() throws Exception {
        App.loadScene("main.fxml");
    }
}