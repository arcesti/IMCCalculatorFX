package br.unoeste.imccalculatorfx;

import br.unoeste.imccalculatorfx.entity.Pessoa;
import br.unoeste.imccalculatorfx.util.IMC;
import br.unoeste.imccalculatorfx.util.Singleton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainController {
    public Label lbPeso;
    public Label lbAltura;
    @FXML
    private Label lbCondicao;

    @FXML
    private Label lbIMC;

    @FXML
    private Slider slAltura;

    @FXML
    private Slider slPeso;

    @FXML
    private TextField tfNome;

    private void valoresIniciais() {
        tfNome.setText("");
        slPeso.setValue(60);
        slAltura.setValue(160);
        lbPeso.setText("60");
        lbAltura.setText("1,6");
    }
    @FXML
    void onSalvarHistorico(ActionEvent event) {
        if(!tfNome.getText().isEmpty()) {
            //salvar via serialização
            Pessoa pessoa = new Pessoa(tfNome.getText(),
                                      (int)slPeso.getValue(),
                                      slAltura.getValue()/100,
                                      Double.parseDouble(lbIMC.getText().replace(",",".")));
            Singleton.getRepo().add(pessoa);
            valoresIniciais();
            calcImc();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Informe seu nome");
            alert.showAndWait();
            Platform.runLater(() -> {
                tfNome.requestFocus();
            });
        }
    }

    public void onPesoMouseClicked(MouseEvent mouseEvent) {
        lbPeso.setText(String.format("%.0f",slPeso.getValue()));
        calcImc();
    }

    public void onPesoMouseDragged(MouseEvent mouseEvent) {
        lbPeso.setText(String.format("%.0f",slPeso.getValue()));
        calcImc();
    }

    public void onAlturaMouseClicked(MouseEvent mouseEvent) {
        lbAltura.setText(String.format("%.2f",slAltura.getValue()/100));
        calcImc();
    }

    public void onAlturaMouseDragged(MouseEvent mouseEvent) {
        lbAltura.setText(String.format("%.2f",slAltura.getValue()/100));
        calcImc();
    }
    private void calcImc() {
        int peso = (int)slPeso.getValue();
        double altura = slAltura.getValue()/100;
        double imc = IMC.getImc(peso, altura);
        lbIMC.setText(String.format("%.1f", imc));
        lbCondicao.setText(IMC.getCondicao(imc));
    }

    public void onNovoIMC(ActionEvent actionEvent) {
    }

    public void onMostrarHistorico(ActionEvent actionEvent) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(IMCCalculator.class.getResource("table-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Histórico");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }
}