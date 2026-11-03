
package icc.pap.pl1.patrones;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import app1.patrones.prototype.RegistroPrototipos;
import app1.patrones.prototype.ProductoBase;

class AppTest {

    @Test
    void debeCrearCopiasIndependientes() {

        RegistroPrototipos registro = new RegistroPrototipos();

        ProductoBase pedido1 = registro.clonar("cafe", "P-001");
        ProductoBase pedido2 = registro.clonar("cafe", "P-002");

        assertNotSame(pedido1, pedido2);
        assertEquals("P-001", pedido1.id());
        assertEquals("P-002", pedido2.id());
    }
}
