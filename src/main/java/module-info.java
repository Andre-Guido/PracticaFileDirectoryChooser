module ni.edu.uam.practicafiledirectorychooser {
    requires javafx.controls;
    requires javafx.fxml;


    opens ni.edu.uam.practicafiledirectorychooser to javafx.fxml;
    exports ni.edu.uam.practicafiledirectorychooser;
}