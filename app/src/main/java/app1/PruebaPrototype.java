
package app1;

import javax.swing.SwingUtilities;
import app1.vista.VentanaPrincipal;

public class PruebaPrototype {

    public static void main(String[] args) {

         SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });

    }
}

       
    

