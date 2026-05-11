package org.club;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

public class ListController {

    @FXML private VBox contenedor;
    @FXML private Label lblVacio;

    @FXML
    private void initialize() {
        if (MediaItem.isEmpty()) {
            lblVacio.setVisible(true);
            return;
        }

        lblVacio.setVisible(false);

        for (int i = 0; i < MediaItem.size(); i++) {
					contenedor.getChildren().add(crearTarjeta(MediaItem.get(i)));
				}
    }

    private VBox crearTarjeta(MediaItem item) {
        VBox card = new VBox(6);
        card.setStyle(
            "-fx-background-color: white;" +
            "-fx-border-color: #e0e0e0;" +
            "-fx-border-radius: 10;" +
            "-fx-background-radius: 10;" +
            "-fx-padding: 14 18 14 18;"
        );

        Label titulo = new Label(item.getTitulo());
        titulo.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-text-fill: #1a1a2e;");

        Label meta = new Label(item.getTipo() + "  ·  " + item.getDuracion());
        meta.setStyle("-fx-font-size: 12px; -fx-text-fill: #888888;");

        String extraTexto = "";
        if (item.getAnio() != null && !item.getAnio().isEmpty()) {
            extraTexto += "Año: " + item.getAnio() + "   ";
        }
        if (item.getValoracion() != null && !item.getValoracion().isEmpty()) {
            extraTexto += item.getValoracion();
        }

        Label extra = new Label(extraTexto);
        extra.setStyle("-fx-font-size: 12px; -fx-text-fill: #aaaaaa;");

        card.getChildren().addAll(titulo, meta, extra);
        return card;
    }

    @FXML
    private void onVolver() throws Exception {
        App.loadScene("main.fxml");
    }
}