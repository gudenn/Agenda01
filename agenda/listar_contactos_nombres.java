/**
 *
 * @author juanki
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.*;

public class listar_contactos_nombres extends JDialog {

    private static final long serialVersionUID = 1L;
    private JTable table = new JTable();
    private JButton aceptar = new JButton();
    private JButton cancelar = new JButton();
    ;
    private JPanel panel_tabla = new JPanel();
    private MiEvento evento = new MiEvento();
    private JScrollPane scrollPane;
    Operaciones operaciones = new Operaciones();

    public listar_contactos_nombres(java.awt.Frame parent, boolean modal) {

        super(parent, modal);
        iniciando_componentes();
        Object[] columnNames = {"id", "nombre", "agregado"};

        // DefaultTableModel model = new DefaultTableModel(operaciones.nombrePersonas(), columnNames);
        //operaciones.nombrePersonas();
        table = new JTable(operaciones.nombrePersonas()) {
            private static final long serialVersionUID = 1L;

            /*@Override
             public Class getColumnClass(int column) {
             return getValueAt(0, column).getClass();
             }*/
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return Boolean.class;
                    case 3:
                        return Double.class;
                    default:
                        return Boolean.class;
                }
            }
        };
        // table.setPreferredScrollableViewportSize(table.getPreferredSize());
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 5, 200, 200);
        panel_tabla.add(scrollPane);
        // getContentPane().setLayout(null);
        getContentPane().add(aceptar);
        getContentPane().add(cancelar);
        getContentPane().add(panel_tabla);



    }

    public void cerrar() {
        this.dispose();
    }

    public JTable get_tabla() {
        return table;
    }

    public JScrollPane get_panel_tabla() {
        return scrollPane;
    }

    public void iniciando_componentes() {
        panel_tabla.setBounds(5, 5, 200, 200);
        panel_tabla.setLayout(null);
        aceptar.setBounds(60, 230, 100, 20);
        aceptar.setText("Aceptar");
        aceptar.addActionListener(evento);
        cancelar.setBounds(180, 230, 100, 20);
        cancelar.setText("Cancelar");
        cancelar.addActionListener(evento);
    }

    public void validar_y_guardar() {
        this.dispose();
    }
    /*public static void main(String[] args) {
     listar_contactos_nombres frame = new listar_contactos_nombres();
     // frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
     frame.pack();
     frame.setBounds(150, 150,425,300);
     frame.setVisible(true);
     }*/

    class MiEvento implements ActionListener {

        public void actionPerformed(ActionEvent e) {


            if (e.getSource().equals(aceptar)) {
                validar_y_guardar();

            }
            if (e.getSource().equals(cancelar)) {
                cerrar();

            }
        }
    }
}