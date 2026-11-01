package app1.patrones.prototype;

import java.math.BigDecimal;
import app1.modelo.TipoProducto;

public class Pizza extends ProductoBase {

    public Pizza(String id) {
        super(
            id,
            "Pizza sencilla",
            new BigDecimal("5.00"),
            TipoProducto.PIZZA
        );
    }

    @Override
    public ProductoBase copiar(String nuevoId) {
        return new Pizza(nuevoId);
    }
}