module es.ieslosmontecillos.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ieslosmontecillos.demo to javafx.fxml;
    exports es.ieslosmontecillos.demo;
}