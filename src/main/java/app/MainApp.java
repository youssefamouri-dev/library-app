package app;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * A small starter JavaFX app: type your name, click "Say hello", and a counter goes up.
 *
 * Structure of every JavaFX app:
 *   Stage (the window)  ->  Scene (the content)  ->  root layout (VBox, HBox, ...)  ->  controls
 */
public class MainApp extends Application {

    private int clicks = 0;

    @Override
    public void start(Stage stage) {
        // 1. Create the controls
        Label title = new Label("My first JavaFX app");
        title.getStyleClass().add("title");

        TextField nameField = new TextField();
        nameField.setPromptText("Type your name");

        Button helloButton = new Button("Say hello");
        Label message = new Label("Nobody said hello yet.");

        // 2. React to events (what happens when the button is clicked)
        helloButton.setOnAction(event -> {
            clicks++;
            String name = nameField.getText().isBlank() ? "stranger" : nameField.getText().trim();
            message.setText("Hello " + name + "! (button clicked " + clicks + " times)");
        });

        // Pressing Enter in the text field does the same as clicking the button
        nameField.setOnAction(event -> helloButton.fire());

        // 3. Put the controls in layouts
        HBox inputRow = new HBox(10, nameField, helloButton);
        inputRow.setAlignment(Pos.CENTER);

        VBox root = new VBox(20, title, inputRow, message);
        root.setAlignment(Pos.CENTER);

        // 4. Create the scene, add the CSS file, and show the window
        Scene scene = new Scene(root, 480, 300);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        stage.setTitle("JavaFX Project");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args); // starts JavaFX, which then calls start(...)
    }
}
