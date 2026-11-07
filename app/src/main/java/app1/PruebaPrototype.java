
package app1;

import app1.patrones.prototype.RegistroPrototipos;
import app1.patrones.prototype.ProductoBase;

public class PruebaPrototype {

    public static void main(String[] args) {

        RegistroPrototipos registro = new RegistroPrototipos();

        ProductoBase clon1 = registro.clonar("cafe", "P-001");
        ProductoBase clon2 = registro.clonar("cafe", "P-002");

        System.out.println("=== PRUEBA CA02: PROTOTYPE ===");

        System.out.println("ID clon 1: " + clon1.id());
        System.out.println("ID clon 2: " + clon2.id());

        System.out.println("¿Son objetos diferentes?: " + (clon1 != clon2));

        System.out.println("Precio clon 1: $" + clon1.precio());
        System.out.println("Precio clon 2: $" + clon2.precio());

        System.out.println("Descripción clon 1: " + clon1.descripcion());
        System.out.println("Descripción clon 2: " + clon2.descripcion());
        System.out.println("Identidad del clon 1: " + System.identityHashCode(clon1));
        System.out.println("Identidad del clon 2: " + System.identityHashCode(clon2));
    }
}
