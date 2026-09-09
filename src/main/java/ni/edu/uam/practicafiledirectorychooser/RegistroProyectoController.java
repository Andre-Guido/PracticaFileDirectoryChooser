package ni.edu.uam.practicafiledirectorychooser;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.Optional;

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
    private void seleccionarDirectorio() {
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
        if (!validarFormulario()) {
            Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacion.setTitle("Confirmación");
            confirmacion.setHeaderText("¿Seguro que quiere guardar el proyecto?");
            confirmacion.setContentText("Proyecto: " +  txtNombreProyecto.getText());

            Optional<ButtonType> respuesta = confirmacion.showAndWait();
            if(respuesta.isPresent() && respuesta.get() == ButtonType.OK){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Proyecto guardado");
                alert.setHeaderText("Proyecto guardado");
                alert.setContentText("Proyecto guardado");
                limpiarDatos();
            }
        }
    }

    private boolean validarFormulario() {
        if (txtNombreProyecto.getText().isEmpty() || txtNombreResponsable.getText().isEmpty() ||
                txtDescripcion.getText().isEmpty() || txtRequerimiento.getText().isEmpty() ||
                txtDirectorio.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de validación");
            alert.setHeaderText(null);
            alert.setContentText("Todos los campos son obligatorios.");
            alert.showAndWait();
            return false;
        }
        return true;
    }

    @FXML
    private void limpiarDatos() {
        txtNombreProyecto.clear();
        txtNombreResponsable.clear();
        txtDescripcion.clear();
        txtRequerimiento.clear();
        txtDirectorio.clear();
    }
}
