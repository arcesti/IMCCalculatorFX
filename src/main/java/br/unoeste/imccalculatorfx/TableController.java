package br.unoeste.imccalculatorfx;

import br.unoeste.imccalculatorfx.entity.Pessoa;
import br.unoeste.imccalculatorfx.util.Singleton;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class TableController implements Initializable {
    public TableView <Pessoa> tabela;
    public TableColumn <Pessoa,String> colNome;
    public TableColumn <Pessoa, Integer> colPeso;
    public TableColumn <Pessoa, Double> colAltura;
    public TableColumn <Pessoa, Double> colImc;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        colAltura.setCellValueFactory(new PropertyValueFactory<>("altura"));
        colImc.setCellValueFactory(new PropertyValueFactory<>("imc"));
        tabela.setItems(FXCollections.observableArrayList(Singleton.getRepo().getList()));
    }
}
