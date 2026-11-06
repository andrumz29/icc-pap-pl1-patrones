# Evidencias APP1 — PedidoLab

**Repositorio:** https://github.com/andrumz29/icc-pap-pl1-patrones
**Integrantes:** Andres Eduardo Mendez 
**Fecha:** 06/11/2026

## Casos de prueba

| Caso | Entrada | Resultado esperado | Resultado real | Evidencia | Estado |
|---|---|---|---|---|---|
| CA01 | Seleccionar Café y presionar el boton Clonar producto. | Se debe crear un nuevo pedido con un ID diferente y precio de $2.20. | Se creo correctamente el pedido P-001 con su precio de $2.20. | Captura de Café clonado. | Aprobado |
| CA02 | Seleccionar Ensalada y clonar el producto. | Se debe crear una ensalada con precio inicial de $3.00. | Se creo correctamente la ensalada con su precio de $3.00. | Captura de Ensalada clonada. | Aprobado |
| CA03 | Seleccionar Pizza y clonar el producto. | Se debe crear una pizza con precio inicial de $5.00. | Se creo correctamente la pizza y aparecio en la tabla de pedidos. | Captura de Pizza clonada. | Aprobado |
| CA04 | Seleccionar un Café y agregar Azúcar. | La descripción debe actualizarse y el precio aumentar $0.50. | Se agrego el azúcar correctamente y el precio cambio de $2.20 a $2.70. | Captura de Café con azúcar. | Aprobado |
| CA05 | Seleccionar un Café y agregar Crema. | El precio debe aumentar $1.20. | Se agrego la crema correctamente y el precio cambio de $2.20 a $3.40. | Captura de Café con crema. | Aprobado |
| CA06 | Crear una Ensalada y agregar Tomate y Pollo. | Se deben agregar los dos ingredientes y el total debe ser $5.60. | Se agregaron los ingredientes correctamente y el total fue de $5.60. | Captura de Ensalada personalizada. | Aprobado |
| CA07 | Crear una Pizza y agregar Queso y Pepperoni. | Se deben agregar los dos ingredientes y el total debe ser $7.10. | Se agregaron correctamente los ingredientes y el total fue de $7.10. | Captura de Pizza personalizada. | Aprobado |
| CA08 | Crear dos cafés y agregar ingredientes solamente al primero. | El segundo café debe mantener su precio original y no cambiar sus ingredientes. | Se comprobo que el primer café cambio a $3.90 y el segundo se mantuvo en $2.20. | Captura de los dos pedidos. | Aprobado |
| CA09 | Seleccionar un ingrediente que no corresponda al producto. | El sistema debe mostrar un mensaje de error y no permitir agregar un ingrediente incompatible. | El sistema mostro un mensaje indicando que el ingrediente no es compatible con el producto. | Captura del mensaje de error. | Aprobado |
| CA10 | Presionar el boton Agregar ingrediente sin seleccionar un pedido. | El sistema debe mostrar un mensaje indicando que primero se debe seleccionar un pedido. | El sistema valida que exista un pedido seleccionado antes de agregar ingredientes. | Captura del mensaje de advertencia. | Pendiente de adjuntar evidencia |
| CA11 | Presionar Reiniciar pedidos y confirmar la operación. | Se deben eliminar todos los pedidos, limpiar la tabla y reiniciar el contador de IDs sin modificar los prototipos. | Los pedidos se eliminaron correctamente y al crear otro producto el contador volvió a empezar desde P-001. | Captura de la tabla vacía y nuevo pedido. | Aprobado |

## Identificación de patrones

- **Prototype:** Se utiliza la interfaz `Prototipo<T>` que contiene el metodo `copiar(String nuevoId)`. La clase `ProductoBase` implementa esta interfaz y las clases `Cafe`, `Ensalada` y `Pizza` realizan la copia de cada producto. El registro de los prototipos se encuentra en `RegistroPrototipos.java`, donde se guardan los productos originales y se utiliza el metodo `clonar()` para generar nuevas copias con diferentes identificadores.

- **Decorator:** Se utiliza la clase abstracta `DecoradorIngrediente`, que implementa la interfaz `Pedido` y contiene una referencia llamada `pedido` al objeto que se desea decorar. Algunos decoradores concretos son `Azucar.java` y `Crema.java`. Estos permiten agregar ingredientes al pedido sin modificar las clases originales de los productos.

- **Integración:** La integración de los dos patrones se realiza principalmente en el metodo `agregarIngrediente()` de la clase `ServicioPedidos.java`. Primero se crea un pedido mediante la clonación de un prototipo y despues se pueden agregar ingredientes utilizando los decoradores. Por ejemplo, un Café puede recibir primero Azúcar y despues Crema, aumentando su descripción y su precio sin modificar el prototipo original.

## Decisiones de diseño

1. Se decidio utilizar el patron Prototype para poder crear diferentes pedidos a partir de productos originales ya registrados. De esta manera cada pedido tiene su propio ID y se puede personalizar sin afectar a los demas productos.

2. Se utilizo el patron Decorator para agregar ingredientes de una manera mas sencilla, evitando crear una clase diferente para cada combinación de productos. Tambien se utilizo `BigDecimal` para manejar los precios y evitar errores en las operaciones decimales.

## Conclusiones

1. Con este proyecto pude comprender mejor como funciona el patron Prototype, ya que permite crear copias de objetos sin tener que construirlos desde cero cada vez que se necesita un producto nuevo.

2. Aprendi que el patron Decorator permite agregar nuevas caracteristicas a un objeto sin modificar su clase original. En nuestro caso se utilizo para agregar ingredientes y aumentar el precio de cada pedido.

3. Al realizar este proyecto tambien pude practicar el uso de Java, la programación orientada a objetos y la creacion de interfaces graficas con Swing. Ademas comprendi la importancia de separar las responsabilidades en diferentes clases para tener un codigo mas ordenado y facil de mantener.