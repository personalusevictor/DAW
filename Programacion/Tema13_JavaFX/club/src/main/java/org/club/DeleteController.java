package org.club;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.Priority;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Pos;

public class DeleteController {

    @FXML private VBox contenedor;
    @FXML private Label lblVacio;
    @FXML private Label lblMensaje;

    @FXML
    private void initialize() {
        cargarLista();
    }

    private void cargarLista() {
        contenedor.getChildren().clear();
        contenedor.getChildren().add(lblVacio);
        contenedor.getChildren().add(lblMensaje);

        if (MediaItem.isEmpty()) {
            lblVacio.setVisible(true);
            return;
        }

        lblVacio.setVisible(false);

        for (int i = 0; i < MediaItem.size(); i++) {
            contenedor.getChildren().add(crearFila(i));
        }
    }

    private HBox crearFila(int index) {
        HBox fila = new HBox(10);
        fila.setAlignment(Pos.CENTER_LEFT);
        fila.setStyle(
            "-fx-background-color: white;" +
            "-fx-border-color: #e0e0e0;" +
            "-fx-border-radius: 10;" +
            "-fx-background-radius: 10;" +
            "-fx-padding: 12 16 12 16;"
        );

        MediaItem item = MediaItem.get(index);

        VBox info = new VBox(3);
        Label titulo = new Label(item.getTitulo());
        titulo.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #1a1a2e;");
        Label meta = new Label(item.getTipo() + "  ·  " + item.getDuracion());
        meta.setStyle("-fx-font-size: 11px; -fx-text-fill: #888;");
        info.getChildren().addAll(titulo, meta);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Button btnEliminar = new Button("Eliminar");
        btnEliminar.setStyle(
            "-fx-background-color: #E24B4A; -fx-text-fill: white;" +
            "-fx-font-size: 12px; -fx-background-radius: 8;" +
            "-fx-padding: 6 12; -fx-cursor: hand; -fx-border-color: transparent;"
        );

        final int idx = index;
        btnEliminar.setOnAction(e -> {
            MediaItem.eliminar(idx);
            lblMensaje.setText("Eliminado correctamente.");
            lblMensaje.setStyle("-fx-font-size: 12px; -fx-text-fill: #1D9E75;");
            cargarLista();
        });

        fila.getChildren().addAll(info, spacer, btnEliminar);
        return fila;
    }

    @FXML
    private void onVolver() throws Exception {
        App.loadScene("main.fxml");
    }
}