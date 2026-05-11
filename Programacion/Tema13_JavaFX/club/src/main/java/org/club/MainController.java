package org.club;

import javafx.fxml.FXML;
import javafx.application.Platform;

public class MainController {

    @FXML
    private void onAnadir() throws Exception {
        App.loadScene("add.fxml");
    }

    @FXML
    private void onListar() throws Exception {
        App.loadScene("list.fxml");
    }

    @FXML
    private void onSalir() {
        Platform.exit();
    }
		
		@FXML
		private void onEliminar() throws Exception {
    	App.loadScene("delete.fxml");
		}
}