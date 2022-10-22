module ecole221.schoolproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.java;
    requires java.sql;

    opens ecole221.schoolproject.controllers to javafx.fxml;
    exports ecole221.schoolproject;
    exports ecole221.schoolproject.entites;
    exports ecole221.schoolproject.controllers;
}
