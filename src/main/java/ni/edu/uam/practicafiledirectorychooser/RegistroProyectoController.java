package ni.edu.uam.practicafiledirectorychooser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

public class RegistroProyectoController {
    @FXML
    private TextField txtNombreProyecto;
    @FXML
    private TextField txtNombreResponsable;
    @FXML
    private TextField txtDescripcion;
    @FXML
    private TextField txtRequerimiento;
    @FXML
    private TextField txtDirectorio;
    @FXML
    private Button btnSeleccionarArchivo;
    @FXML
    private Button btnSeleccionarDirectorio;

    @FXML
    private void seleccionarArchivo() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Seleccionar Archivo");
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Archivo TXT", "*.txt"),
                new FileChooser.ExtensionFilter("Archivo PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("Archivo Excel", "*.xlsx"),
                new FileChooser.ExtensionFilter("Archivo Word", "*.docx")
        );
        File f = fc.showOpenDialog(btnSeleccionarArchivo.getScene().getWindow());
        if (f != null) {
            txtRequerimiento.setText(f.getAbsolutePath());
        }
    }

    @FXML
    private void seleccionarDirectorio(){
        DirectoryChooser dc = new DirectoryChooser();
        dc.setTitle("Seleccionar Directorio");
        dc.setInitialDirectory(new File(System.getProperty("C:\\")));
        File f = dc.showDialog(btnSeleccionarDirectorio.getScene().getWindow());
        if (f != null) {
            txtDirectorio.setText(f.getAbsolutePath());
        }
    }

    @FXML
    private void guardarDatos() {

    }

    private boolean validarFormulario(){
        return true;
    }

    private void limpiarDatos() {
        txtNombreProyecto.clear();
        txtNombreResponsable.clear();
        txtDescripcion.clear();
        txtRequerimiento.clear();
        txtDirectorio.clear();
    }
}
