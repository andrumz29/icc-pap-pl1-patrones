
package app1;

import java.math.BigDecimal;

import app1.modelo.Pedido;
import app1.patrones.prototype.ProductoBase;
import app1.patrones.prototype.RegistroPrototipos;
import app1.servicio.ServicioPedidos;

public class PruebasCasos {

    public static void main(String[] args) {

        ServicioPedidos servicio = new ServicioPedidos();
        RegistroPrototipos registro = new RegistroPrototipos();

        System.out.println("==================================");
        System.out.println("       PRUEBAS DE PEDIDOLAB");
        System.out.println("==================================");

        // CA01: Clonar Café dos veces
        System.out.println("\n=== CA01: CLONAR CAFE DOS VECES ===");

        Pedido cafe1 = servicio.crearPedido("cafe");
        Pedido cafe2 = servicio.crearPedido("cafe");

        mostrarPedido(cafe1);
        mostrarPedido(cafe2);

        System.out.println("¿Tienen IDs diferentes?: "
                + !cafe1.id().equals(cafe2.id()));

        // CA02: Comparar clon y objeto del registro
        System.out.println("\n=== CA02: COMPARAR CLON Y PROTOTIPO ===");

        ProductoBase prototipo = registro.obtenerPrototipo("cafe");
        ProductoBase clon = registro.clonar("cafe", "TEST-001");

        System.out.println("¿Son referencias distintas?: "
                + (prototipo != clon));

        System.out.println("ID del prototipo: " + prototipo.id());
        System.out.println("ID del clon: " + clon.id());

        System.out.println("Precio del prototipo: $" + prototipo.precio());
        System.out.println("Precio del clon: $" + clon.precio());

        System.out.println("Descripción del prototipo: "
                + prototipo.descripcion());

        System.out.println("Descripción del clon: "
                + clon.descripcion());

        // CA03: Al primer Café agregar Azúcar y Crema
        System.out.println("\n=== CA03: CAFE CON AZUCAR Y CREMA ===");

        Pedido cafePersonalizado = servicio.agregarIngrediente(
                cafe1.id(), "azucar");

        cafePersonalizado = servicio.agregarIngrediente(
                cafePersonalizado.id(), "crema");

        mostrarPedido(cafePersonalizado);

        // CA04: Consultar el segundo Café sin ingredientes
        System.out.println("\n=== CA04: SEGUNDO CAFE SIN INGREDIENTES ===");

        Pedido segundoCafe = servicio.buscarPedido(cafe2.id());

        mostrarPedido(segundoCafe);

        // CA05: Clonar Ensalada y agregar Tomate y Pollo
        System.out.println("\n=== CA05: ENSALADA CON TOMATE Y POLLO ===");

        Pedido ensalada = servicio.crearPedido("ensalada");

        ensalada = servicio.agregarIngrediente(
                ensalada.id(), "tomate");

        ensalada = servicio.agregarIngrediente(
                ensalada.id(), "pollo");

        mostrarPedido(ensalada);

        // CA06: Clonar Pizza y agregar Queso y Pepperoni
        System.out.println("\n=== CA06: PIZZA CON QUESO Y PEPPERONI ===");

        Pedido pizza = servicio.crearPedido("pizza");

        pizza = servicio.agregarIngrediente(
                pizza.id(), "queso");

        pizza = servicio.agregarIngrediente(
                pizza.id(), "pepperoni");

        mostrarPedido(pizza);

        // CA07: Intentar agregar Queso a Café
        System.out.println("\n=== CA07: INGREDIENTE INCOMPATIBLE ===");

        Pedido cafePrueba = servicio.crearPedido("cafe");

        BigDecimal precioAnterior = cafePrueba.precio();
        String descripcionAnterior = cafePrueba.descripcion();

        try {
            servicio.agregarIngrediente(cafePrueba.id(), "queso");
        } catch (IllegalArgumentException e) {
            System.out.println("Error controlado: " + e.getMessage());
        }

        Pedido cafeDespues = servicio.buscarPedido(cafePrueba.id());

        System.out.println("¿El precio permanece igual?: "
                + precioAnterior.equals(cafeDespues.precio()));

        System.out.println("¿La descripción permanece igual?: "
                + descripcionAnterior.equals(cafeDespues.descripcion()));

        // CA08: Agregar ingrediente sin pedido seleccionado
        System.out.println("\n=== CA08: SIN PEDIDO SELECCIONADO ===");

        try {
            servicio.agregarIngrediente(null, "azucar");
        } catch (IllegalArgumentException e) {
            System.out.println("Error controlado: " + e.getMessage());
        }

        // CA09: Solicitar clon de clave inexistente
        System.out.println("\n=== CA09: CLAVE INEXISTENTE ===");

        try {
            registro.clonar("hamburguesa", "P-999");
        } catch (IllegalArgumentException e) {
            System.out.println("Error controlado: " + e.getMessage());
        }

        // CA10: Agregar dos veces Azúcar a un Café
        System.out.println("\n=== CA10: AZUCAR AGREGADA DOS VECES ===");

        Pedido cafeDobleAzucar = servicio.crearPedido("cafe");

        cafeDobleAzucar = servicio.agregarIngrediente(
                cafeDobleAzucar.id(), "azucar");

        cafeDobleAzucar = servicio.agregarIngrediente(
                cafeDobleAzucar.id(), "azucar");

        mostrarPedido(cafeDobleAzucar);

        // CA11: Reiniciar y volver a clonar Café
        System.out.println("\n=== CA11: REINICIAR Y CLONAR CAFE ===");

        servicio.reiniciarPedidos();

        System.out.println("Pedidos después de reiniciar: "
                + servicio.obtenerPedidos().size());

        Pedido nuevoCafe = servicio.crearPedido("cafe");

        mostrarPedido(nuevoCafe);

        System.out.println("\n==================================");
        System.out.println("       FIN DE LAS PRUEBAS");
        System.out.println("==================================");
    }

    private static void mostrarPedido(Pedido pedido) {

        System.out.println("ID: " + pedido.id());
        System.out.println("Producto: " + pedido.tipo());
        System.out.println("Descripción: " + pedido.descripcion());
        System.out.println("Precio: $" + pedido.precio());
    }
}