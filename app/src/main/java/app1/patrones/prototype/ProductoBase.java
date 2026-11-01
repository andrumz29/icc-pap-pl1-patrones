package app1.patrones.prototype;

import java.math.BigDecimal;
import app1.modelo.Pedido;
import app1.modelo.TipoProducto;

public abstract class ProductoBase implements Pedido, Prototipo<ProductoBase>{
    protected String id;
    protected String descripcion;
    protected BigDecimal precioBase;
    protected TipoProducto tipo;
    
    // constructor
    public ProductoBase(String id, String descripcion, BigDecimal precioBase, TipoProducto tipo) {
        this.id = id;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.tipo = tipo;
    }

     @Override
    public String id() {
        return id;
    }

    @Override
    public TipoProducto tipo() {
        return tipo;
    }

    @Override
    public String descripcion() {
        return descripcion;
    }

    @Override
    public BigDecimal precio() {
        return precioBase;
    }
}