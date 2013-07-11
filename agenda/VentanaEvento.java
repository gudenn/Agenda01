
/**
 * Calendario
 *
 * @author equipo de programacion Agil
 */
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;
import javax.swing.text.DateFormatter;

public class VentanaEvento extends javax.swing.JDialog {

    private java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JComboBox hora_ini;
    private javax.swing.JComboBox minuto_ini;
    private javax.swing.JComboBox hora_fin;
    private javax.swing.JComboBox minuto_fin;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    listar_contactos_nombres listarnombres;
    agregar_nota nuevanota;
    Operaciones operaciones = new Operaciones();
    private JButton agregarNombre;
    private JButton agregarNota;
    private JButton botonGuardar;
    private JButton botonCancelar;
    private TextField nombre;
    JPanel contenedor = new JPanel();
    private JTable contactos = new JTable();

    public VentanaEvento(Date fecha_por_defecto, int hora_def, int min_def) {

        Toolkit tool = getToolkit();
        Dimension d = tool.getScreenSize();
        setModal(true);
        // setLayout(null);
        setBounds(0, 0, 350, 300);
        iniciarComponentes(fecha_por_defecto, hora_def, min_def);
        MiEvento evento = new MiEvento();
        MiEvento evento2 = new MiEvento();
        botonGuardar.addActionListener(evento);
        hora_fin.addActionListener(evento2);
        minuto_fin.addActionListener(evento);
        botonCancelar.addActionListener(evento);
        agregarNombre.addActionListener(evento);
        agregarNota.addActionListener(evento);

    }

    private void iniciarComponentes(Date fecha_por_defecto, int hora_def, int min_def) {
        contenedor = new JPanel();
        contenedor.setBounds(0, 0, 350, 300);
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();

        label5 = new JLabel();

        botonGuardar = new JButton();
        botonCancelar = new JButton();

        listarnombres = new listar_contactos_nombres(null, rootPaneCheckingEnabled);
        listarnombres.setBounds(150, 150, 300, 300);
        nuevanota = new agregar_nota(null, rootPaneCheckingEnabled);
        agregarNombre = new JButton();
        agregarNota = new JButton();

        nombre = new TextField();

        fecha = new JDateChooser();

        hora_ini = new JComboBox();

        hora_fin = new JComboBox();
        hora_fin.addItem("--");
        for (int h = 0; h < 24; h++) {
            hora_fin.addItem(h);
            hora_ini.addItem(h);
        }
        minuto_ini = new JComboBox();
        minuto_fin = new JComboBox();
        minuto_fin.addItem("--");
        for (int m = 0; m < 60; m++) {
            minuto_fin.addItem(m);
            minuto_ini.addItem(m);
        }
        hora_ini.setSelectedItem(hora_def);
        minuto_ini.setSelectedItem(min_def);
        setLayout(null);

        label1.setText("Nombre:");
        label1.setFont(new Font("Arial", Font.PLAIN, 16));
        contenedor.add(label1);
        label1.setBounds(50, 30, 70, 35);

        label2.setText("Fecha:");
        label2.setFont(new Font("Arial", Font.PLAIN, 16));
        contenedor.add(label2);
        label2.setBounds(50, 60, 70, 35);

        label3.setText("Hora inicio:");
        label3.setFont(new Font("Arial", Font.PLAIN, 16));
        contenedor.add(label3);
        label3.setBounds(50, 90, 70, 35);

        label4.setText("Hora fin:");
        label4.setFont(new Font("Arial", Font.PLAIN, 16));
        contenedor.add(label4);
        label4.setBounds(50, 120, 70, 35);

        agregarNombre.setText("AgregarContacto");
        agregarNombre.setFont(new Font("Arial", Font.PLAIN, 13));
        contenedor.add(agregarNombre);
        agregarNombre.setBounds(50, 160, 130, 20);

        agregarNota.setText("Agregar Nota");
        agregarNota.setFont(new Font("Arial", Font.PLAIN, 13));
        contenedor.add(agregarNota);
        agregarNota.setBounds(200, 160, 130, 20);

        botonGuardar.setText("Guardar");
        botonGuardar.setFont(new Font("Arial", Font.PLAIN, 13));
        contenedor.add(botonGuardar);
        botonGuardar.setBounds(200, 180, 100, 35);

        botonCancelar.setText("Cancelar");
        botonCancelar.setFont(new Font("Arial", Font.PLAIN, 13));
        contenedor.add(botonCancelar);
        botonCancelar.setBounds(50, 180, 100, 35);

        nombre.setBounds(120, 40, 150, 20);
        contenedor.add(nombre);

        fecha.setBounds(120, 70, 150, 24);

        fecha.setVerifyInputWhenFocusTarget(true);
        Date d = new Date();
        fecha.setMinSelectableDate(d);
        if (fecha_por_defecto.after(d)) {
            fecha.setDate(fecha_por_defecto);
        } else {
            fecha.setDate(d);
        }


        contenedor.add(fecha);

        hora_ini.setBounds(120, 100, 50, 20);

        contenedor.add(hora_ini);
        minuto_ini.setBounds(180, 100, 50, 20);
        contenedor.add(minuto_ini);
        hora_fin.setBounds(120, 130, 50, 20);

        contenedor.add(hora_fin);
        minuto_fin.setBounds(180, 130, 50, 20);
        contenedor.add(minuto_fin);
        contenedor.setLayout(null);
        add(contenedor);

    }

    public void validar_y_guardar() {

        System.out.println(fecha.isValidateRoot());
        if (nombre.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "El nombre del evento esta vacio");
        } else {
            if (((hora_fin.getSelectedItem().equals("--")))) {
                String hrs_ini = "" + hora_ini.getSelectedItem() + ":" 
                                    + minuto_ini.getSelectedItem();
                String hrs_fin = "" + hora_fin.getSelectedItem() + ":" 
                                    + minuto_fin.getSelectedItem();
                String nota = nuevanota.getNota();
                try {
                    String date = sdf.format(fecha.getDate());
                    System.out.println(date + " " + hrs_ini + " " + hrs_fin);
                    Operaciones o = new Operaciones();
                    o.insertarDatos(nombre.getText(), date, hrs_ini, hrs_fin, 
                                    nota, listarnombres.get_tabla());
                    dispose();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "la fecha no es valida");

                }
            } else {
                if (((int) hora_ini.getSelectedItem()) > ((int) hora_fin.getSelectedItem())) {
                    JOptionPane.showMessageDialog(this, 
                            "la hora de finalizacion del evento es "
                            + "menor que la hora de inicio");
                } else {

                    String hrs_ini = "" + hora_ini.getSelectedItem() 
                                        + ":" + minuto_ini.getSelectedItem();
                    String hrs_fin = "" + hora_fin.getSelectedItem()
                                        + ":" + minuto_fin.getSelectedItem();
                    String nota = nuevanota.getNota();

                    try {
                        String date = sdf.format(fecha.getDate());
                        System.out.println(date + " " + hrs_ini + " " + hrs_fin);
                        Operaciones o = new Operaciones();
                        o.insertarDatos(nombre.getText(), date, hrs_ini, hrs_fin,
                                        nota, contactos);
                        dispose();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "la fecha no es valida");

                    }
                }
            }
        }
    }

    public void cerrar() {
        dispose();
    }

    class MiEvento implements ActionListener {

        public void actionPerformed(ActionEvent e) {


            if (e.getSource().equals(botonGuardar)) {
                validar_y_guardar();

            }
            if (e.getSource().equals(botonCancelar)) {

                cerrar();
            }

            if (e.getSource().equals(agregarNombre)) {

                listarnombres.setVisible(true);
            }

            if (e.getSource().equals(agregarNota)) {

                nuevanota.setVisible(true);
            }

            if (e.getSource().equals(hora_fin)) {
                if (hora_fin.getSelectedItem().equals("--")) {

                    minuto_fin.setSelectedIndex(0);
                } else {

                    if (minuto_fin.getSelectedItem().equals("--")) {
                        minuto_fin.setSelectedIndex(1);
                    }
                }
            }
            if (e.getSource().equals(minuto_fin)) {
                if (minuto_fin.getSelectedItem().equals("--")) {
                    hora_fin.setSelectedIndex(0);
                } else {
                    if (hora_fin.getSelectedItem().equals("--")) {
                        hora_fin.setSelectedIndex(1);
                    }
                }
            }
        }
    }
}
