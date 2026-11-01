package app1.patrones.decorator;

import app1.modelo.Pedido;

public abstract class DecoradorIngrediente implements Pedido {

    protected Pedido pedido;

    public DecoradorIngrediente(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String id() {
        return pedido.id();
    }

    @Override
    public app1.modelo.TipoProducto tipo() {
        return pedido.tipo();
    }
}