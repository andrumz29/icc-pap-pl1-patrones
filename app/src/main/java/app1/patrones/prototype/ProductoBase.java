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
    public String descripcion() {
        // TODO Auto-generated method stub
        return descripcion;
    }

    @Override
    public String id() {
        // TODO Auto-generated method stub
        return id;
    }

    @Override
    public BigDecimal precio() {
        // TODO Auto-generated method stub
        return precioBase;
    }

    @Override
    public TipoProducto tipo() {
        // TODO Auto-generated method stub
        return tipo;
    }

   
    //los override
    
}