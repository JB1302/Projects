package com.resourcemanager.resourcemanager;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.net.URL;

public class main extends Application {

    @Override
    public void start(Stage stage) {
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();

        // Cargar el archivo HTML desde resources
        URL htmlURL = getClass().getResource("/index.html");
        if (htmlURL != null) {
            webEngine.load(htmlURL.toExternalForm());
        } else {
            System.err.println("⚠️ Error: No se encontró 'index.html'. Verifica la ubicación del archivo.");
        }

        StackPane root = new StackPane(webView);
        Scene scene = new Scene(root, 780, 330); // Width x Height

        stage.setTitle("Aplicación con HTML en JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
