package app1.patrones.decorator;

import java.math.BigDecimal;

import app1.modelo.Pedido;

public class Queso extends DecoradorIngrediente {

    public Queso(Pedido pedido) {
        super(pedido);
    }

    @Override
    public String descripcion() {
        return pedido.descripcion() + " + Queso";
    }

    @Override
    public BigDecimal precio() {
        return pedido.precio().add(new BigDecimal("1.00"));
    }
}