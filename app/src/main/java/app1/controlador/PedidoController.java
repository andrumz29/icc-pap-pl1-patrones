
package app1.controlador;

import java.util.List;

import app1.modelo.Pedido;
import app1.servicio.ServicioPedidos;

public class PedidoController {

    private ServicioPedidos servicio;

    public PedidoController() {
        servicio = new ServicioPedidos();
    }

    // Crear un pedido nuevo
    public Pedido crearPedido(String producto) {
        return servicio.crearPedido(producto);
    }

    // Obtener todos los pedidos
    public List<Pedido> obtenerPedidos() {
        return servicio.obtenerPedidos();
    }

    // Buscar un pedido
    public Pedido buscarPedido(String id) {
        return servicio.buscarPedido(id);
    }

    // Agregar un ingrediente
    public Pedido agregarIngrediente(String id, String ingrediente) {
        return servicio.agregarIngrediente(id, ingrediente);
    }

    // Reiniciar pedidos
    public void reiniciarPedidos() {
        servicio.reiniciarPedidos();
    }
}
