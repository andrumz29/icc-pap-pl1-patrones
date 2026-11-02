package app1.patrones.decorator;

import java.math.BigDecimal;

import app1.modelo.Pedido;

public class Azucar extends DecoradorIngrediente {

    public Azucar(Pedido pedido) {
        super(pedido);
    }

    @Override
    public String descripcion() {
        return pedido.descripcion() + " + Azúcar";
    }

    @Override
    public BigDecimal precio() {
        return pedido.precio().add(new BigDecimal("0.50"));
    }
}