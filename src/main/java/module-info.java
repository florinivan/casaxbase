module com.phimes.casaxbase {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires com.github.albfernandez.javadbf;
    requires java.sql;

    opens com.phimes.casaxbase to javafx.fxml;
    exports com.phimes.casaxbase;
}