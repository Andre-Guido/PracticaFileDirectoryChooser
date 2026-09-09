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

public class RegistroEstudianteController {
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtEdad;
    @FXML
    private TextField txtCarrera;
    @FXML
    private TextField txtCarnet;
    @FXML
    private TextField txtRequerimiento;
    @FXML
    private TextField txtDirectorio;
    @FXML
    private Button btnAgregarRequerimiento;
    @FXML
    private Button btnDirectorio;

    @FXML
    private void agregarRequerimiento() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Agregar Archivo");
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Archivo TXT", "*.txt"),
                new FileChooser.ExtensionFilter("Archivo PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("Archivo Excel", "*.xlsx"),
                new FileChooser.ExtensionFilter("Archivo Word", "*.docx")
        );
        File f = fc.showOpenDialog(btnAgregarRequerimiento.getScene().getWindow());
        if (f != null) {
            txtRequerimiento.setText(f.getAbsolutePath());
        }
    }

    @FXML
    private void seleccionarDirectorio() {
        DirectoryChooser dc = new DirectoryChooser();
        dc.setTitle("Seleccionar Directorio");
        dc.setInitialDirectory(new File("C:\\"));
        File f = dc.showDialog(btnDirectorio.getScene().getWindow());
        if (f != null) {
            txtDirectorio.setText(f.getAbsolutePath());
        }
    }

    @FXML
    private void guardarDatos() {
        if (!validarFormulario()) {
            Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacion.setTitle("Confirmación");
            confirmacion.setHeaderText("¿Seguro que quiere guardar los datos del estudiante?");
            confirmacion.setContentText("Estudiante: " +  txtNombre.getText());

            Optional<ButtonType> respuesta = confirmacion.showAndWait();
            if(respuesta.isPresent() && respuesta.get() == ButtonType.OK){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Estudiante guardado");
                alert.setHeaderText("Estudiante guardado");
                alert.setContentText("Estudiante guardado");
                limpiarDatos();
            }
        }
    }

    private boolean validarFormulario() {
        if (txtNombre.getText().isEmpty() || txtEdad.getText().isEmpty() ||
                txtCarrera.getText().isEmpty() || txtCarnet.getText().isEmpty() ||
                txtRequerimiento.getText().isEmpty() || txtDirectorio.getText().isEmpty()) {
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
        txtNombre.clear();
        txtEdad.clear();
        txtCarrera.clear();
        txtCarnet.clear();
        txtRequerimiento.clear();
        txtDirectorio.clear();
    }
}
