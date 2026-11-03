package app1.patrones.prototype;

import java.math.BigDecimal;
import app1.modelo.TipoProducto;

public class Cafe extends ProductoBase {

    public Cafe(String id) {
        super(
            id,
            "Cafe",
            new BigDecimal("2.20"),
            TipoProducto.CAFE
        );
    }

    @Override
    public ProductoBase copiar(String nuevoId) {
        return new Cafe(nuevoId);
    }
}