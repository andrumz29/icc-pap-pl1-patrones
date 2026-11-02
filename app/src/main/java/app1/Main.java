
package app1;

import app1.modelo.Pedido;
import app1.patrones.prototype.RegistroPrototipos;
import app1.servicio.ServicioPedidos;

public class Main {

    public static void main(String[] args) {

        ServicioPedidos servicio = new ServicioPedidos();

        // Crear un pedido de café
        Pedido cafe = servicio.crearPedido("cafe");

        System.out.println("PEDIDO ORIGINAL");
        System.out.println(cafe.descripcion());
        System.out.println("Total: $" + cafe.precio());

        // Agregar azúcar
        Pedido cafeAzucar = servicio.agregarIngrediente(
                cafe.id(), "azucar");

        System.out.println("\nPEDIDO CON AZUCAR");
        System.out.println(cafeAzucar.descripcion());
        System.out.println("Total: $" + cafeAzucar.precio());

        // Agregar crema
        Pedido cafeCompleto = servicio.agregarIngrediente(
                cafe.id(), "crema");

        System.out.println("\nPEDIDO CON AZUCAR Y CREMA");
        System.out.println(cafeCompleto.descripcion());
        System.out.println("Total: $" + cafeCompleto.precio());
    }
}
