package instrumentos;

import instrumentos.modelo.GestorInstrumentos;
import instrumentos.modelo.Instrumento;
import instrumentos.modelo.TablaInstrumentos;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Consulta extends JFrame {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            JFrame.setDefaultLookAndFeelDecorated(true);
        } catch (ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | UnsupportedLookAndFeelException ex) {
            System.err.printf("Excepción: '%s'%n ", ex.getMessage());
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                mostrarInterfaz();
            }

        });
    }

    public Consulta() {
        super("Consulta de instrumentos");
        configurar();
    }

    private void configurar() {
        ajustarComponentes(getContentPane());
        setResizable(true);
        setSize(800, 600);
        setMinimumSize(new Dimension(400, 300));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void ajustarComponentes(Container c)  {
       
            c.setLayout(new BorderLayout());
            GestorInstrumentos g;
        try {
            Instrumento ins = new Instrumento(4, "Pulgómetro", "Celcius");
            g = GestorInstrumentos.obtenerInstancia();
              boolean exitoA = g.agregar(ins);
            System.out.println(exitoA);
        } catch (InstantiationException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
        }
            
          
            c.add(BorderLayout.CENTER,
                    panelPrincipal = new JPanel());
            panelPrincipal.setLayout(new BorderLayout());
            
            try {
                panelPrincipal.add(BorderLayout.CENTER,
                        new JScrollPane(
                                tablaInstrumentos
                                        = new JTable(TablaInstrumentos.obtenerInstancia()),
                                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
                        )
                );
                
                panelPrincipal.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
                
                tablaInstrumentos.setRowSelectionAllowed(true);
                
            } catch (Exception ex) {
                System.err.printf(ex.getMessage());
                JOptionPane.showMessageDialog(null,
                        "No se pudo cargar la tabla de estudiantes",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
       
    }

    public void init() {
        setVisible(true);
    }

    public static void mostrarInterfaz() {
        new Consulta().init();
    }

    private JPanel panelPrincipal;
    private JTable tablaInstrumentos;
}
