module com.example.cateringfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cateringfx to javafx.fxml;
    opens com.example.cateringfx.model to javafx.base;
    exports com.example.cateringfx;
}