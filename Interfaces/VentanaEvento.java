package Interfaces;


/**
 * Calendario
 *
 * @author equipo de programacion Agil
 */
import Interfaces.ListarContactosNombres;
import Conexion.Operaciones;
import Interfaces.AgregarNota;
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
    private javax.swing.JComboBox horaIni;
    private javax.swing.JComboBox minutoIni;
    private javax.swing.JComboBox horaFin;
    private javax.swing.JComboBox minutoFin;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    ListarContactosNombres listarNombres;
    AgregarNota nuevaNota;
    Operaciones operaciones = new Operaciones();
    private JButton agregarNombre;
    private JButton agregarNota;
    private JButton botonGuardar;
    private JButton botonCancelar;
    private TextField nombre;
    JPanel contenedor = new JPanel();
    private JTable contactos = new JTable();

    public VentanaEvento(Date fechaPorDefecto, int horaDef, int minDef) {

        Toolkit tool = getToolkit();
        Dimension d = tool.getScreenSize();
        setModal(true);
        // setLayout(null);
        setBounds(0, 0, 350, 300);
        iniciarComponentes(fechaPorDefecto, horaDef, minDef);
        MiEvento evento = new MiEvento();
        MiEvento evento2 = new MiEvento();
        botonGuardar.addActionListener(evento);
        horaFin.addActionListener(evento2);
        minutoFin.addActionListener(evento);
        botonCancelar.addActionListener(evento);
        agregarNombre.addActionListener(evento);
        agregarNota.addActionListener(evento);

    }

    private void iniciarComponentes(Date fechaPorDefecto, int horaDef, int minDef) {
        contenedor = new JPanel();
        contenedor.setBounds(0, 0, 350, 300);
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();

        label5 = new JLabel();

        botonGuardar = new JButton();
        botonCancelar = new JButton();

        listarNombres = new ListarContactosNombres(null, rootPaneCheckingEnabled);
        listarNombres.setBounds(150, 150, 300, 300);
        nuevaNota = new AgregarNota(null, rootPaneCheckingEnabled);
        agregarNombre = new JButton();
        agregarNota = new JButton();

        nombre = new TextField();

        fecha = new JDateChooser();

        horaIni = new JComboBox();

        horaFin = new JComboBox();
        horaFin.addItem("--");
        for (int h = 0; h < 24; h++) {
            horaFin.addItem(h);
            horaIni.addItem(h);
        }
        minutoIni = new JComboBox();
        minutoFin = new JComboBox();
        minutoFin.addItem("--");
        for (int m = 0; m < 60; m++) {
            minutoFin.addItem(m);
            minutoIni.addItem(m);
        }
        horaIni.setSelectedItem(horaDef);
        minutoIni.setSelectedItem(minDef);
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
        if (fechaPorDefecto.after(d)) {
            fecha.setDate(fechaPorDefecto);
        } else {
            fecha.setDate(d);
        }


        contenedor.add(fecha);

        horaIni.setBounds(120, 100, 50, 20);

        contenedor.add(horaIni);
        minutoIni.setBounds(180, 100, 50, 20);
        contenedor.add(minutoIni);
        horaFin.setBounds(120, 130, 50, 20);

        contenedor.add(horaFin);
        minutoFin.setBounds(180, 130, 50, 20);
        contenedor.add(minutoFin);
        contenedor.setLayout(null);
        add(contenedor);

    }

    public void validarYGuardar() {

        System.out.println(fecha.isValidateRoot());
        if (nombre.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "El nombre del evento esta vacio");
        } else {
            if (((horaFin.getSelectedItem().equals("--")))) {
                String hrs_ini = "" + horaIni.getSelectedItem() + ":" 
                                    + minutoIni.getSelectedItem();
                String hrs_fin = "" + horaFin.getSelectedItem() + ":" 
                                    + minutoFin.getSelectedItem();
                String nota = nuevaNota.getNota();
                try {
                    String date = sdf.format(fecha.getDate());
                    System.out.println(date + " " + hrs_ini + " " + hrs_fin);
                    Operaciones o = new Operaciones();
                    o.insertarDatos(nombre.getText(), date, hrs_ini, hrs_fin, 
                                    nota, listarNombres.get_tabla());
                    dispose();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "la fecha no es valida");

                }
            } else {
                if (((int) horaIni.getSelectedItem()) > ((int) horaFin.getSelectedItem())) {
                    JOptionPane.showMessageDialog(this, 
                            "la hora de finalizacion del evento es "
                            + "menor que la hora de inicio");
                } else {

                    String hrs_ini = "" + horaIni.getSelectedItem() 
                                        + ":" + minutoIni.getSelectedItem();
                    String hrs_fin = "" + horaFin.getSelectedItem()
                                        + ":" + minutoFin.getSelectedItem();
                    String nota = nuevaNota.getNota();

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
                validarYGuardar();

            }
            if (e.getSource().equals(botonCancelar)) {

                cerrar();
            }

            if (e.getSource().equals(agregarNombre)) {

                listarNombres.setVisible(true);
            }

            if (e.getSource().equals(agregarNota)) {

                nuevaNota.setVisible(true);
            }

            if (e.getSource().equals(horaFin)) {
                if (horaFin.getSelectedItem().equals("--")) {

                    minutoFin.setSelectedIndex(0);
                } else {

                    if (minutoFin.getSelectedItem().equals("--")) {
                        minutoFin.setSelectedIndex(1);
                    }
                }
            }
            if (e.getSource().equals(minutoFin)) {
                if (minutoFin.getSelectedItem().equals("--")) {
                    horaFin.setSelectedIndex(0);
                } else {
                    if (horaFin.getSelectedItem().equals("--")) {
                        horaFin.setSelectedIndex(1);
                    }
                }
            }
        }
    }
}
