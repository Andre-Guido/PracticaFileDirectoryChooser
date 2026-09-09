package ni.edu.uam.practicafiledirectorychooser;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuPrincipalController {
    @FXML
    private AnchorPane apPrincipal;

    @FXML
    private void abrirRegistroEstudiante() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("registro-estudiante.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Registro de Estudiantes");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void abrirRegistroProyecto() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("registro-proyecto.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Registro de Películas");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void cerrarPrograma() {
        ((Stage) apPrincipal.getScene().getWindow()).close();
    }
}
