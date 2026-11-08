package app1.patrones.prototype;

import java.math.BigDecimal;
import app1.modelo.Pedido;
import app1.modelo.TipoProducto;
//ProductoBase como abstract porque funciona como una clase base que contiene los atributos y métodos comunes de los productos 
// No necesitamos crear un producto genérico, sino clases concretas que hereden sus características
public abstract class ProductoBase implements Pedido, Prototipo<ProductoBase>{

    //protected permite  que las clases hijas, como Cafe, Pizza y Ensalada, puedan acceder a estos atributos.
    protected String id;
    protected String descripcion;
    protected BigDecimal precioBase;
    protected TipoProducto tipo;
    
    // constructor recibe los datos necesarios 
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
//
    @Override
    public String descripcion() {
        return descripcion;
    }
// El método precio() devuelve el precio base del producto, que es un valor fijo definido en cada subclase concreta (Cafe, Pizza, Ensalada).
    @Override
    public BigDecimal precio() {
        return precioBase;
    }
}