package app1.patrones.prototype;

import java.util.HashMap;
import java.util.Map;

public class RegistroPrototipos {
// usamos buenas practicas Usamos un HashMap en RegistroPrototipos para guardar y buscar fácilmente nuestros prototipos mediante una clave.
    private Map<String, ProductoBase> prototipos;

    public RegistroPrototipos() {
        prototipos = new HashMap<>();

        prototipos.put("cafe", new Cafe("PROTO-CAFE"));
        prototipos.put("ensalada", new Ensalada("PROTO-ENSALADA"));
        prototipos.put("pizza", new Pizza("PROTO-PIZZA"));
    }

    public ProductoBase clonar(String clave, String nuevoId) {

        ProductoBase prototipo = prototipos.get(clave.toLowerCase());

        if (prototipo == null) {
            throw new IllegalArgumentException(
                "No existe un prototipo con la clave: " + clave
            );
        }

        return prototipo.copiar(nuevoId);
    }
}