package br.unoeste.imccalculatorfx;

import br.unoeste.imccalculatorfx.util.Singleton;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import javax.swing.*;
import java.io.IOException;

public class IMCCalculator extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(IMCCalculator.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("IMCCalculatorFx v0.1!");
        stage.setScene(scene);
        stage.show();
        if(!Singleton.ler()) {
            JOptionPane.showMessageDialog(null, "Não há dados para serem recuperados!");
        }
        Singleton.ler();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                Singleton.salvar();
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}