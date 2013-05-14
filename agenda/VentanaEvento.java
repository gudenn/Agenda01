/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

/**
 *
 * @author Jorge
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



public class VentanaEvento extends JFrame {
    private java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("dd/MM/yyyy");  
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JComboBox hora_ini;
    private javax.swing.JComboBox minuto_ini;
    private javax.swing.JComboBox hora_fin;
    private javax.swing.JComboBox minuto_fin;
    
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JButton botonGuardar;
    private JButton botonCancelar;
    private TextField nombre;
    //private TextField fecha;
    //AtTimeField a;
    
     
    
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
        MiEvento evento=new MiEvento();
        botonGuardar.addActionListener(evento);
        hora_fin.addActionListener(evento);
        minuto_fin.addActionListener(evento);
        botonCancelar.addActionListener(evento);
    }
    
    private void iniciarComponentes(){
    label1 = new JLabel();
    label2 = new JLabel();
    label3 = new JLabel();
    label4 = new JLabel();
    botonGuardar = new JButton();
    botonCancelar = new JButton();
    nombre = new TextField();

    fecha = new JDateChooser();
    
    hora_ini= new JComboBox();
    
    hora_fin= new JComboBox();
    hora_fin.addItem("--");
    for(int h=0;h<24;h++)
    {
    hora_fin.addItem(h);
    hora_ini.addItem(h);
    }
    minuto_ini= new JComboBox();
    minuto_fin= new JComboBox();
    minuto_fin.addItem("--");
    for(int m=0;m<60;m++)
    {
    minuto_fin.addItem(m);
    minuto_ini.addItem(m);
    }
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
    //fecha.setFocusable(true);
    //fecha.setFocusTraversalKeysEnabled(true);
    fecha.setVerifyInputWhenFocusTarget(true);
    Date d=new Date();
    fecha.setMinSelectableDate(d);
   
    contenedor.add(fecha);
    
    hora_ini.setBounds(120, 170, 40, 20);
    
    contenedor.add(hora_ini);      
    minuto_ini.setBounds(180, 170, 40, 20);
    contenedor.add(minuto_ini);
    hora_fin.setBounds(120, 230, 40, 20);
    
    contenedor.add(hora_fin);
    minuto_fin.setBounds(180, 230, 40, 20);
    contenedor.add(minuto_fin);
    }
    public void validar_y_guardar()
    {
      
      System.out.println(fecha.isValidateRoot());  
      if(nombre.getText().trim().length()==0)
        {
         JOptionPane.showMessageDialog(this, "El nombre del evento esta vacio");
        } else{
         if(((hora_fin.getSelectedItem().equals("--")))){
                String hrs_ini=""+hora_ini.getSelectedItem()+":"+minuto_ini.getSelectedItem(); 
                String hrs_fin=""+hora_fin.getSelectedItem()+":"+minuto_fin.getSelectedItem();
             try{
                String date=sdf.format(fecha.getDate());
                System.out.println(date+" "+hrs_ini+" "+hrs_fin);
                Operaciones o = new Operaciones();
                o.insertarDatos(nombre.getText(),date,hrs_ini,hrs_fin);
             }catch( Exception e){
             JOptionPane.showMessageDialog(this, "la fecha no es valida");
            
             }
         }else{
         if(((int)hora_ini.getSelectedItem())>((int)hora_fin.getSelectedItem()))
            {
              JOptionPane.showMessageDialog(this, "la hora de finalizacion del evento es menor que la hora de inicio");
            } else{             
                            
                String hrs_ini=""+hora_ini.getSelectedItem()+":"+minuto_ini.getSelectedItem(); 
                String hrs_fin=""+hora_fin.getSelectedItem()+":"+minuto_fin.getSelectedItem();
             try{
                String date=sdf.format(fecha.getDate());
                System.out.println(date+" "+hrs_ini+" "+hrs_fin);
                Operaciones o = new Operaciones();
                o.insertarDatos(nombre.getText(),date,hrs_ini,hrs_fin);
             }catch( Exception e){
             JOptionPane.showMessageDialog(this, "la fecha no es valida");
            
             }
             }
         } 
          
          
              
       
        
      
      
      }
    }
    public void cerrar(){
    System.exit(1);
    }
 class MiEvento implements ActionListener{
	
  public void actionPerformed( ActionEvent e ){
			
  
    if( e.getSource().equals( botonGuardar ) )
    {
       validar_y_guardar();
    }
    if( e.getSource().equals( botonCancelar ) )
    {
       
       cerrar();
    }
    if(e.getSource().equals(hora_fin))
    {
      if(hora_fin.getSelectedItem().equals("--"))
       {
         minuto_fin.setSelectedIndex(0);
        }else{
         minuto_fin.setSelectedIndex(1);
        }   
    }
    if(e.getSource().equals(minuto_fin))
    {
      if(minuto_fin.getSelectedItem().equals("--"))
       {
         hora_fin.setSelectedIndex(0);
        }else{
         hora_fin.setSelectedIndex(1);
        }   
    }
  }
			
}
}
