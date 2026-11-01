package app1.patrones.prototype;

import java.math.BigDecimal;
import app1.modelo.TipoProducto;

public class Ensalada extends ProductoBase {

    public Ensalada(String id) {
        super(
            id,
            "Ensalada sencilla",
            new BigDecimal("3.00"),
            TipoProducto.ENSALADA
        );
    }

    @Override
    public ProductoBase copiar(String nuevoId) {
        return new Ensalada(nuevoId);
    }
}