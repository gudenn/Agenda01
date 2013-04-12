/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

/**
 *
 * @author Jorge
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaEvento extends JFrame {

    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JButton botonGuardar;
    private JButton botonCancelar;
    private TextField nombre;
    private TextField fecha;
    private TextField hrIni;
    private TextField hrFin;
    
    public VentanaEvento(){
        iniciarComponentes();
        Toolkit tool = getToolkit();
        Dimension d = tool.getScreenSize();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(d.width/3, d.height/2);
        setLocation((d.width/2)-(getWidth()/2),(d.height/2)-(getHeight()/2));
        setVisible(true);
        
        //accion 56 w
        //echo Revisado modificado
        botonGuardar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evento){
                conexion c = new conexion();
                c.insertarDatos(nombre.getText(),fecha.getText(),hrIni.getText(),hrFin.getText());
                
            }
        });
    }
    
    private void iniciarComponentes(){
    label1 = new JLabel();
    label2 = new JLabel();
    label3 = new JLabel();
    label4 = new JLabel();
    botonGuardar = new JButton();
    botonCancelar = new JButton();
    nombre = new TextField();
    fecha = new TextField();
    hrIni = new TextField();
    hrFin = new TextField();
    // Titulo
    setTitle("Evento");
    setName("VentanaEvento");
    Container contenedor =  getContentPane();
    contenedor.setLayout(null);
    
    label1.setText("Nombre:");
    label1.setFont(new Font("Arial", Font.PLAIN, 16));
    contenedor.add(label1);
    label1.setBounds(50, 40, 70, 35);
    
    label2.setText("Fecha:");
    label2.setFont(new Font("Arial", Font.PLAIN, 16));
    contenedor.add(label2);
    label2.setBounds(50, 100, 70, 35);
    
    label3.setText("Hora inicio:");
    label3.setFont(new Font("Arial", Font.PLAIN, 16));
    contenedor.add(label3);
    label3.setBounds(50, 160, 70, 35);
    
    label4.setText("Hora fin:");
    label4.setFont(new Font("Arial", Font.PLAIN, 16));
    contenedor.add(label4);
    label4.setBounds(50, 220, 70, 35);
    
    botonGuardar.setText("Guardar");
    botonGuardar.setFont(new Font("Arial", Font.PLAIN, 13));
    contenedor.add(botonGuardar);
    botonGuardar.setBounds(300, 300, 100, 35);

    botonCancelar.setText("Cancelar");
    botonCancelar.setFont(new Font("Arial", Font.PLAIN, 13));
    contenedor.add(botonCancelar);
    botonCancelar.setBounds(50, 300, 100, 35);

    nombre.setBounds(120, 50, 150, 20);
    contenedor.add(nombre);
    
    fecha.setBounds(120, 110, 150, 20);
    contenedor.add(fecha);
    
    hrIni.setBounds(120, 170, 150, 20);
    contenedor.add(hrIni);
    
    hrFin.setBounds(120, 230, 150, 20);
    contenedor.add(hrFin);
    
    }
    
}
