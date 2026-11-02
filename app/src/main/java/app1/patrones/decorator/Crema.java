package app1.patrones.decorator;

import java.math.BigDecimal;

import app1.modelo.Pedido;

public class Crema extends DecoradorIngrediente {

    public Crema(Pedido pedido) {
        super(pedido);
    }

    @Override
    public String descripcion() {
        return pedido.descripcion() + " + Crema";
    }

    @Override
    public BigDecimal precio() {
        return pedido.precio().add(new BigDecimal("1.20"));
    }
}