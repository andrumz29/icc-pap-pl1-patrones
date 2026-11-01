package app1.modelo;


import java.math.BigDecimal;

public interface Pedido {

    String descripcion();

    BigDecimal precio();

    String id();

    TipoProducto tipo();
}