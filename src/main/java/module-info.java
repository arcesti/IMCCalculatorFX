module br.unoeste.imccalculatorfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens br.unoeste.imccalculatorfx to javafx.fxml;
    opens br.unoeste.imccalculatorfx.entity to javafx.fxml;
    exports br.unoeste.imccalculatorfx;
    exports br.unoeste.imccalculatorfx.entity;
}