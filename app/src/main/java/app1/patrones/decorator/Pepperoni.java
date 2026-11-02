package app1.patrones.decorator;

import java.math.BigDecimal;

import app1.modelo.Pedido;

public class Pepperoni extends DecoradorIngrediente {

    public Pepperoni(Pedido pedido) {
        super(pedido);
    }

    @Override
    public String descripcion() {
        return pedido.descripcion() + " + Pepperoni";
    }

    @Override
    public BigDecimal precio() {
        return pedido.precio().add(new BigDecimal("1.10"));
    }
}