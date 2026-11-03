
package app1.vista;

import app1.controlador.PedidoController;
import app1.modelo.Pedido;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class VentanaPrincipal extends JFrame {

    private PedidoController controller;

    private JRadioButton rbCafe;
    private JRadioButton rbEnsalada;
    private JRadioButton rbPizza;

    private JPanel panelIngredientes;
    private JPanel panelDetalle;

    private JTable tablaPedidos;
    private DefaultTableModel modeloTabla;

    private JLabel lblId;
    private JLabel lblProducto;
    private JLabel lblDescripcion;
    private JLabel lblTotal;
    private JLabel lblImagenDetalle;

    private String pedidoSeleccionado = null;

    private final Color NARANJA = new Color(235, 91, 15);
    private final Color CREMA = new Color(255, 247, 238);
    private final Color VERDE = new Color(32, 145, 105);

    public VentanaPrincipal() {

        controller = new PedidoController();

        configurarVentana();
        construirInterfaz();
    }

    private void configurarVentana() {

        setTitle("PedidoLab - Gestion de Pedidos");
        setSize(1050, 720);
        setMinimumSize(new Dimension(850, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setBackground(CREMA);
        setLayout(new BorderLayout(10, 10));
    }

    private void construirInterfaz() {

        // Encabezado
        JPanel encabezado = new JPanel(new BorderLayout());
        encabezado.setBackground(CREMA);
        encabezado.setBorder(new EmptyBorder(15, 20, 10, 20));

       JLabel titulo = new JLabel("PedidoLab");
        titulo.setFont(new Font("Arial", Font.BOLD, 32));
        titulo.setForeground(NARANJA);

        JLabel subtitulo = new JLabel(
            "Prototype + Decorator - Java Swing | Personaliza tu pedido"
        );
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 15));

        encabezado.add(titulo, BorderLayout.NORTH);
        encabezado.add(subtitulo, BorderLayout.SOUTH);

        add(encabezado, BorderLayout.NORTH);

        // Panel principal
        JPanel principal = new JPanel(new GridLayout(2, 2, 12, 12));
        principal.setBackground(CREMA);
        principal.setBorder(new EmptyBorder(5, 15, 15, 15));

        principal.add(crearPanelProductos());
        principal.add(crearPanelPedidos());
        principal.add(crearPanelIngredientes());
        principal.add(crearPanelDetalle());

        add(principal, BorderLayout.CENTER);
    }

    private JPanel crearPanelBase(String titulo) {

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(8, 8));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(230, 210, 190)),
            new EmptyBorder(12, 12, 12, 12)
        ));

        JLabel etiqueta = new JLabel(titulo);
        etiqueta.setFont(new Font("Arial", Font.BOLD, 18));
        etiqueta.setForeground(NARANJA);

        panel.add(etiqueta, BorderLayout.NORTH);

        return panel;
    }

    // SECCION 1: PRODUCTOS

    private JPanel crearPanelProductos() {

        JPanel panel = crearPanelBase("1. Seleccionar producto base");

        JPanel tarjetas = new JPanel(new GridLayout(1, 3, 8, 8));
        tarjetas.setBackground(Color.WHITE);

        rbCafe = new JRadioButton();
        rbEnsalada = new JRadioButton();
        rbPizza = new JRadioButton();

        ButtonGroup grupo = new ButtonGroup();

        grupo.add(rbCafe);
        grupo.add(rbEnsalada);
        grupo.add(rbPizza);

        rbCafe.setSelected(true);

        rbCafe.addActionListener(e -> actualizarIngredientes("cafe"));

        rbEnsalada.addActionListener(e -> actualizarIngredientes("ensalada"));

        rbPizza.addActionListener(e -> actualizarIngredientes("pizza"));

        tarjetas.add(crearTarjeta(
            "Cafe", "$2.20", "cafe.png", rbCafe
        ));

        tarjetas.add(crearTarjeta(
            "Ensalada", "$3.00", "ensalada.png", rbEnsalada
        ));

        tarjetas.add(crearTarjeta(
            "Pizza", "$5.00", "pizza.png", rbPizza
        ));

        JButton btnClonar = new JButton("Clonar producto");
        btnClonar.setBackground(NARANJA);
        btnClonar.setForeground(Color.WHITE);
        btnClonar.setFont(new Font("Arial", Font.BOLD, 15));

        btnClonar.addActionListener(e -> clonarProducto());

        JPanel contenido = new JPanel(new BorderLayout(8, 8));
        contenido.setBackground(Color.WHITE);
        contenido.add(tarjetas, BorderLayout.CENTER);
        contenido.add(btnClonar, BorderLayout.SOUTH);

        panel.add(contenido, BorderLayout.CENTER);

        return panel;
    }

    private JPanel crearTarjeta(
            String nombre, String precio,
            String imagen, JRadioButton radio) {

        JPanel tarjeta = new JPanel(new BorderLayout(5, 5));
        tarjeta.setBackground(CREMA);
        tarjeta.setBorder(BorderFactory.createLineBorder(
            new Color(220, 210, 200)
        ));

        JLabel lblImagen = new JLabel(
            cargarImagen(imagen, 100, 85),
            SwingConstants.CENTER
        );

        JLabel lblNombre = new JLabel(
            nombre, SwingConstants.CENTER
        );
        lblNombre.setFont(new Font("Arial", Font.BOLD, 14));

        JLabel lblPrecio = new JLabel(
            precio, SwingConstants.CENTER
        );

        JPanel inferior = new JPanel(new GridLayout(3, 1));
        inferior.setBackground(CREMA);
        inferior.add(lblNombre);
        inferior.add(lblPrecio);
        inferior.add(radio);

        tarjeta.add(lblImagen, BorderLayout.CENTER);
        tarjeta.add(inferior, BorderLayout.SOUTH);

        return tarjeta;
    }

    // SECCION 2: INGREDIENTES

    

        
private JPanel crearPanelIngredientes() {

    // Panel donde aparecerán los ingredientes
    panelIngredientes = new JPanel();

    panelIngredientes.setLayout(new BoxLayout(
        panelIngredientes, BoxLayout.Y_AXIS
    ));

    panelIngredientes.setBackground(Color.WHITE);

    // Crear panel principal
    JPanel panel = crearPanelBase("2. Agregar ingredientes");

    // Mostrar ingredientes
    panel.add(new JScrollPane(panelIngredientes),
        BorderLayout.CENTER);

    // Botón agregar ingrediente
    JButton btnAgregar = new JButton("Agregar ingrediente");

    btnAgregar.setBackground(VERDE);
    btnAgregar.setForeground(Color.WHITE);
    btnAgregar.setFont(new Font("Arial", Font.BOLD, 15));

    btnAgregar.addActionListener(e -> agregarIngredientes());

    // Botón reiniciar pedidos
    JButton btnReiniciar = new JButton("Reiniciar pedidos");

    btnReiniciar.setBackground(new Color(190, 198, 205));
    btnReiniciar.setForeground(Color.BLACK);
    btnReiniciar.setFont(new Font("Arial", Font.BOLD, 14));

    btnReiniciar.addActionListener(e -> reiniciarPedidos());

    // Panel para los botones
    JPanel botones = new JPanel(new GridLayout(2, 1, 5, 5));

    botones.setBackground(Color.WHITE);
    botones.add(btnAgregar);
    botones.add(btnReiniciar);

    panel.add(botones, BorderLayout.SOUTH);

    // Ingredientes iniciales del café
    actualizarIngredientes("cafe");

    return panel;




    }

    private void actualizarIngredientes(String producto) {

        panelIngredientes.removeAll();

        String[] ingredientes;
        String[] precios;

        switch (producto) {
            case "cafe":
                ingredientes = new String[]{"Azucar", "Crema"};
                precios = new String[]{"$0.50", "$1.20"};
                break;

            case "ensalada":
                ingredientes = new String[]{"Tomate", "Pollo"};
                precios = new String[]{"$1.10", "$1.50"};
                break;

            default:
                ingredientes = new String[]{"Queso", "Pepperoni"};
                precios = new String[]{"$1.00", "$1.10"};
                break;
        }

        for (int i = 0; i < ingredientes.length; i++) {

            JCheckBox check = new JCheckBox(
                ingredientes[i] + "     " + precios[i]
            );

            check.setBackground(Color.WHITE);
            check.setFont(new Font("Arial", Font.PLAIN, 14));
            check.setActionCommand(ingredientes[i]);

            panelIngredientes.add(check);
        }

        panelIngredientes.revalidate();
        panelIngredientes.repaint();
    }

    // SECCION 3: PEDIDOS

    private JPanel crearPanelPedidos() {

        JPanel panel = crearPanelBase("3. Pedidos creados");

        String[] columnas = {
            "ID", "Producto", "Composicion", "Total"
        };

        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        tablaPedidos = new JTable(modeloTabla);
        tablaPedidos.setRowHeight(35);
        tablaPedidos.setSelectionMode(
            ListSelectionModel.SINGLE_SELECTION
        );

        tablaPedidos.getSelectionModel().addListSelectionListener(e -> {

            if (!e.getValueIsAdjusting()) {

                int fila = tablaPedidos.getSelectedRow();

                if (fila >= 0) {
                    pedidoSeleccionado = modeloTabla.getValueAt(
                        fila, 0
                    ).toString();

                    mostrarDetalle();
                }
            }
        });

        panel.add(new JScrollPane(tablaPedidos),
            BorderLayout.CENTER);

        return panel;
    }

    // SECCION 4: DETALLE

    private JPanel crearPanelDetalle() {

        panelDetalle = new JPanel(new BorderLayout(10, 10));
        panelDetalle.setBackground(Color.WHITE);
        panelDetalle.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(230, 210, 190)),
            new EmptyBorder(12, 12, 12, 12)
        ));

        JLabel titulo = new JLabel(
            "4. Detalle del pedido seleccionado"
        );

        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setForeground(NARANJA);

        lblImagenDetalle = new JLabel(
            "Selecciona un pedido", SwingConstants.CENTER
        );

        JPanel informacion = new JPanel(
            new GridLayout(4, 1, 5, 5)
        );
        informacion.setBackground(Color.WHITE);

        lblId = new JLabel("ID: -");
        lblProducto = new JLabel("Producto: -");
        lblDescripcion = new JLabel("Ingredientes: -");
        lblTotal = new JLabel("Total: $0.00");

        lblTotal.setFont(new Font("Arial", Font.BOLD, 24));
        lblTotal.setForeground(NARANJA);

        informacion.add(lblId);
        informacion.add(lblProducto);
        informacion.add(lblDescripcion);
        informacion.add(lblTotal);

        JPanel contenido = new JPanel(new GridLayout(1, 2, 10, 10));
        contenido.setBackground(Color.WHITE);

        contenido.add(lblImagenDetalle);
        contenido.add(informacion);

        panelDetalle.add(titulo, BorderLayout.NORTH);
        panelDetalle.add(contenido, BorderLayout.CENTER);

        return panelDetalle;
    }

    // ACCIONES

    private void clonarProducto() {

        String producto;

        if (rbCafe.isSelected()) {
            producto = "cafe";
        } else if (rbEnsalada.isSelected()) {
            producto = "ensalada";
        } else {
            producto = "pizza";
        }

        try {
            Pedido pedido = controller.crearPedido(producto);

            actualizarTabla();

            pedidoSeleccionado = pedido.id();
            mostrarDetalle();

            JOptionPane.showMessageDialog(
                this, "Pedido creado: " + pedido.id()
            );

        } catch (RuntimeException ex) {
            mostrarError(ex.getMessage());
        }
    }

    private void agregarIngredientes() {

        if (pedidoSeleccionado == null) {
            mostrarError("Primero selecciona un pedido.");
            return;
        }

        boolean agregado = false;

        for (Component componente : panelIngredientes.getComponents()) {

            if (componente instanceof JCheckBox) {

                JCheckBox check = (JCheckBox) componente;

                if (check.isSelected()) {

                    try {
                        controller.agregarIngrediente(
                            pedidoSeleccionado,
                            check.getActionCommand()
                        );

                        agregado = true;

                    } catch (RuntimeException ex) {
                        mostrarError(ex.getMessage());
                        return;
                    }
                }
            }
        }

  if (agregado) {

    actualizarTabla();
    mostrarDetalle();

    for (Component componente : panelIngredientes.getComponents()) {

        if (componente instanceof JCheckBox) {
            ((JCheckBox) componente).setSelected(false);
        }
    }
}
    }

    private void actualizarTabla() {

        modeloTabla.setRowCount(0);

        List<Pedido> pedidos = controller.obtenerPedidos();

        for (Pedido pedido : pedidos) {

            modeloTabla.addRow(new Object[]{
                pedido.id(),
                pedido.tipo(),
                pedido.descripcion(),
                "$" + pedido.precio().setScale(2).toPlainString()
            });
        }
    }

    private void mostrarDetalle() {

        Pedido pedido = controller.buscarPedido(pedidoSeleccionado);

        if (pedido == null) {
            return;
        }

        lblId.setText("ID: " + pedido.id());
        lblProducto.setText("Producto: " + pedido.tipo());
        lblDescripcion.setText(
            "<html>Ingredientes: " + pedido.descripcion() + "</html>"
        );

        lblTotal.setText(
            "Total: $" + pedido.precio().setScale(2).toPlainString()
        );

        String imagen = pedido.tipo().name().toLowerCase() + ".png";

        lblImagenDetalle.setText("");
        lblImagenDetalle.setIcon(cargarImagen(imagen, 170, 140));
    }

    private ImageIcon cargarImagen(
            String nombre, int ancho, int alto) {

        java.net.URL recurso = getClass().getResource(
            "/imagenes/" + nombre
        );

        if (recurso == null) {
            return new ImageIcon();
        }

        Image imagen = new ImageIcon(recurso).getImage();

        Image escalada = imagen.getScaledInstance(
            ancho, alto, Image.SCALE_SMOOTH
        );

        return new ImageIcon(escalada);
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(
            this,
            mensaje,
            "PedidoLab",
            JOptionPane.WARNING_MESSAGE
        );
    }
    
private void reiniciarPedidos() {

    int respuesta = JOptionPane.showConfirmDialog(
        this,
        "¿Estas seguro de que deseas reiniciar todos los pedidos?",
        "Reiniciar pedidos",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE
    );

    if (respuesta == JOptionPane.YES_OPTION) {

        // Reiniciar el servicio
        controller.reiniciarPedidos();

        // Limpiar la tabla
        modeloTabla.setRowCount(0);

        // Quitar el pedido seleccionado
        pedidoSeleccionado = null;

        // Limpiar los detalles
        lblId.setText("ID: -");
        lblProducto.setText("Producto: -");
        lblDescripcion.setText("Ingredientes: -");
        lblTotal.setText("Total: $0.00");

        // Quitar imagen del detalle
        lblImagenDetalle.setIcon(null);
        lblImagenDetalle.setText("Selecciona un pedido");

        // Desmarcar los ingredientes
        for (Component componente : panelIngredientes.getComponents()) {

            if (componente instanceof JCheckBox) {
                ((JCheckBox) componente).setSelected(false);
            }
        }

        // Quitar selección de la tabla
        tablaPedidos.clearSelection();

        JOptionPane.showMessageDialog(
            this,
            "Los pedidos se reiniciaron correctamente."
        );
    }
}

}
