package app1.patrones.decorator;

import java.math.BigDecimal;

import app1.modelo.Pedido;

public class Pollo extends DecoradorIngrediente {

    public Pollo(Pedido pedido) {
        super(pedido);
    }

    @Override
    public String descripcion() {
        return pedido.descripcion() + " + Pollo";
    }

    @Override
    public BigDecimal precio() {
        return pedido.precio().add(new BigDecimal("1.50"));
    }
}