
package app1.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import app1.modelo.Pedido;
import app1.modelo.TipoProducto;
import app1.patrones.decorator.*;
import app1.patrones.prototype.RegistroPrototipos;

public class ServicioPedidos {

    private RegistroPrototipos registro;
    private List<Pedido> pedidos;
    private int contadorId;
// constructor con inicialización de los atributos
    public ServicioPedidos() {
        registro = new RegistroPrototipos();
        pedidos = new ArrayList<>();
        contadorId = 1;
    }

    // Crear un pedido nuevo mediante Prototype
    public Pedido crearPedido(String claveProducto) {

        String nuevoId = String.format("P-%03d", contadorId);

        Pedido nuevoPedido = registro.clonar(claveProducto, nuevoId);

        pedidos.add(nuevoPedido);
        contadorId++;

        return nuevoPedido;
    }

    // Obtener todos los pedidos
    public List<Pedido> obtenerPedidos() {
        return List.copyOf(pedidos);
    }

    // Buscar un pedido por su ID
    public Pedido buscarPedido(String id) {

        for (Pedido pedido : pedidos) {
            if (pedido.id().equals(id)) {
                return pedido;
            }
        }

        return null;
    }

    // Agregar un ingrediente a un pedido
    public Pedido agregarIngrediente(String idPedido, String ingrediente) {

        Pedido pedido = buscarPedido(idPedido);

        if (pedido == null) {
            throw new IllegalArgumentException(
                "No existe el pedido seleccionado."
            );
        }
            //trim elimina los espacios y tolower case convierte a minissculas para evitar errorres 
        String nombre = ingrediente.trim().toLowerCase();

        if (!esCompatible(pedido.tipo(), nombre)) {
            throw new IllegalArgumentException("El ingrediente " + ingrediente + " no es compatible con " + pedido.tipo()         );
        }

        Pedido personalizado;

        switch (nombre) {
            case "azucar":
            case "azúcar":
                //se crea un decorador y se asigna a una variable 
                personalizado = new Azucar(pedido);
                break;

            case "crema":
                personalizado = new Crema(pedido);
                break;

            case "tomate":
                personalizado = new Tomate(pedido);
                break;

            case "pollo":
                personalizado = new Pollo(pedido);
                break;

            case "queso":
                personalizado = new Queso(pedido);
                break;

            case "pepperoni":
                personalizado = new Pepperoni(pedido);
                break;

            default:
                throw new IllegalArgumentException(
                    "Ingrediente inexistente: " + ingrediente
                );
        }

        // Sustituir el pedido anterior por el decorado
        pedidos.set(pedidos.indexOf(pedido), personalizado);

        return personalizado;
    }

    // Validar ingredientes permitidos por producto
    private boolean esCompatible( TipoProducto tipo, String ingrediente) {

        Set<String> permitidos;

        switch (tipo) {
            case CAFE:
                permitidos = Set.of("azucar", "azúcar", "crema");
                break;

            case ENSALADA:
                permitidos = Set.of("tomate", "pollo");
                break;

            case PIZZA:
                permitidos = Set.of("queso", "pepperoni");
                break;
                //no coincide retorna una falso
            default:
                return false;
        }

        return permitidos.contains(ingrediente);
    }

    // Reiniciar los pedidos creados
    public void reiniciarPedidos() {
        pedidos.clear();
        contadorId = 1;
    }
}
