# PedidoLab

## Descripción del proyecto

PedidoLab es un proyecto desarrollado en Java que tiene como finalidad crear una aplicación para gestionar pedidos de productos personalizados. La aplicación permitirá seleccionar productos, agregar ingredientes, visualizar los pedidos y calcular el precio total.

Para desarrollar el proyecto se utilizarán los patrones de diseño Prototype y Decorator, junto con la arquitectura Modelo-Vista-Controlador (MVC), para mantener el código organizado y facilitar su desarrollo.

## Estructura de carpetas y paquetes

El proyecto está organizado en diferentes paquetes para separar las responsabilidades de cada parte de la aplicación.

- **modelo:** contiene las clases Producto, Ingrediente y Pedido, que representan la información principal de la aplicación.
- **vista:** contiene la clase VentanaPrincipal, donde posteriormente se desarrollará la interfaz gráfica utilizando Java Swing.
- **controlador:**     contiene la clase PedidoController, encargada de gestionar las acciones del usuario.
- **patrones:** contiene las clases necesarias para trabajar con los patrones de diseño:
  - **prototype:** incluye ProductoPrototype y ProductoConcreto, que servirán para crear copias de productos.
  - **decorator:** incluye ProductoDecorator e IngredienteDecorator, que permitirán agregar ingredientes y personalizar los productos.
- **servicio:** contiene la clase PedidoService, donde se organizarán las operaciones relacionadas con los pedidos.
- **Main.java:** será la clase principal desde donde se iniciará la aplicación.
## Actualización del proyecto

Se actualizó la estructura del proyecto y se completó la implementación de los patrones de diseño Prototype y Decorator utilizando Java y Java Swing.

Actualmente, el proyecto está organizado en los siguientes paquetes:

- **`modelo`:** contiene `Pedido` y `TipoProducto`, que representan la estructura de los pedidos y los tipos de productos.
- **`vista`:** contiene `VentanaPrincipal`, donde se desarrolló la interfaz gráfica con Java Swing.
- **`controlador`:** contiene `PedidoController`, encargado de comunicar la interfaz con el servicio de pedidos.
- **`patrones`:** contiene las implementaciones de los patrones de diseño:
  - **`prototype`:** incluye `Prototipo`, `ProductoBase`, `Cafe`, `Ensalada`, `Pizza` y `RegistroPrototipos`, utilizados para crear copias independientes de los productos.
  - **`decorator`:** incluye `DecoradorIngrediente`, `Azucar`, `Crema`, `Tomate`, `Pollo`, `Queso` y `Pepperoni`, utilizados para personalizar los pedidos agregando ingredientes y costos adicionales.
- **`servicio`:** contiene `ServicioPedidos`, encargado de crear, buscar, personalizar, validar y reiniciar los pedidos.
- **`PruebaPrototype.java`:** permite iniciar la aplicación gráfica.
- **`PruebasCasos.java`:** contiene las pruebas de los once casos definidos para verificar el funcionamiento de Prototype, Decorator y las validaciones.
- **`resources/imagenes`:** almacena las imágenes de los productos utilizadas en la interfaz gráfica.

También se completaron las pruebas de los once casos, verificando la creación de clones independientes, la personalización de productos, el cálculo de precios, las validaciones y el reinicio de pedidos.
![Interfaz de PedidoLab](Interfaz%20de%20PedidoLab.png)
![Boceto de PedidoLab](boceto.jpeg)