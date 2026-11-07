/*
 * module-info.java : tells Java which libraries (modules) our program needs.
 *
 *  - "requires javafx.controls" -> we use JavaFX buttons, labels, text fields...
 *  - "requires javafx.fxml"     -> we can load .fxml files (optional, for Scene Builder)
 *  - "exports app"              -> JavaFX must be allowed to access our package,
 *                                  because JavaFX itself creates our MainApp object.
 *  - "opens app to javafx.fxml" -> needed only if you use FXML controllers in this package.
 */
module app {
    requires javafx.controls;
    requires javafx.fxml;

    exports app;
    opens app to javafx.fxml;
}
