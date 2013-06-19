/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


//import Objetos.Persona;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.Unmarshaller.Listener;
//comentario
/**
 *
 * @author taniao
 */
public class GUI extends javax.swing.JFrame {
    
    Operaciones operaciones;
    listar_contactos listarcontactos; 
    VentanaEvento crear_evento;
    Agregar_contacto formulario_agregar_contacto;
    ImageIcon ifondo=new ImageIcon();
    JLabel lfondo=new JLabel();
    private java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("dd/MM/yyyy");  
    
    
    public GUI() {
       initComponents();
       operaciones=new Operaciones(); 
       operaciones.conectar();
       init_componentes();
    }
    public void init_componentes()
    {
        jLabel1.setText("Eventos");
        String fecha=sdf.format(calendario.getDate());
        jLabel2.setText(fecha);
        listar_resp(operaciones.get_eventos(fecha)); 
    }
      public void FileCopy(String sourceFile, String destinationFile) {
		System.out.println("Desde: " + sourceFile);
		System.out.println("Hacia: " + destinationFile);

		try {
			File inFile = new File(sourceFile);
			File outFile = new File(destinationFile);

			FileInputStream in = new FileInputStream(inFile);
			FileOutputStream out = new FileOutputStream(outFile);

			int c;
			while( (c = in.read() ) != -1)
				out.write(c);

			in.close();
			out.close();
		} catch(IOException e) {
			System.err.println("Hubo un error de entrada/salida!!!");
		}
	}
      public void actualizar_bd(String ruta)
      {
          operaciones.actualizar_bd(ruta);
      }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        calendario = new com.toedter.calendar.JCalendar();
        jLabel1 = new javax.swing.JLabel();
        Boton_buscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        panel_eventos = new javax.swing.JPanel();
        agregar_evento = new javax.swing.JButton();
        agregar_contacto = new javax.swing.JButton();
        listar_contactos = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        ajustes = new javax.swing.JMenu();
        exportar_bd = new javax.swing.JMenuItem();
        importar_bd = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        calendario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                calendarioMouseReleased(evt);
            }
        });

        Boton_buscar.setText("Buscar");
        Boton_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_buscarActionPerformed(evt);
            }
        });

        jLabel3.setText("Seleciona una fecha");

        javax.swing.GroupLayout panel_eventosLayout = new javax.swing.GroupLayout(panel_eventos);
        panel_eventos.setLayout(panel_eventosLayout);
        panel_eventosLayout.setHorizontalGroup(
            panel_eventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 195, Short.MAX_VALUE)
        );
        panel_eventosLayout.setVerticalGroup(
            panel_eventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(panel_eventos);

        agregar_evento.setText("Agregar Evento");
        agregar_evento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_eventoActionPerformed(evt);
            }
        });

        agregar_contacto.setText("Agregar Contacto");
        agregar_contacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_contactoActionPerformed(evt);
            }
        });

        listar_contactos.setText("Listar Contactos");
        listar_contactos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listar_contactosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(listar_contactos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(agregar_contacto, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(agregar_evento, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(Boton_buscar))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Boton_buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(agregar_evento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(agregar_contacto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(listar_contactos)
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Agenda", jPanel1);

        jMenuBar1.add(jMenu1);

        ajustes.setText("Ajustes");

        exportar_bd.setText("Exportar Base de Dstos");
        exportar_bd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportar_bdActionPerformed(evt);
            }
        });
        ajustes.add(exportar_bd);

        importar_bd.setText("Importar Base de Datos");
        importar_bd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importar_bdActionPerformed(evt);
            }
        });
        ajustes.add(importar_bd);

        jMenuBar1.add(ajustes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void calendarioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calendarioMouseReleased
        System.out.println("jjjjjjjjjjjjj");
}//GEN-LAST:event_calendarioMouseReleased

    private void Boton_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_buscarActionPerformed
        //captur evento del boton
        jLabel1.setText("Eventos");
        String fecha=sdf.format(calendario.getDate());
        jLabel2.setText(fecha);
        listar_resp(operaciones.get_eventos(fecha));
}//GEN-LAST:event_Boton_buscarActionPerformed

    private void agregar_eventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_eventoActionPerformed
      
        String hora=""+calendario.getDate().getHours();
        String minuto=""+calendario.getDate().getMinutes();
        crear_evento = new VentanaEvento(calendario.getDate(),Integer.parseInt(hora),Integer.parseInt(minuto));
        crear_evento.setLocation(this.location().x+150, this.location().y+80);
        crear_evento.setVisible(true);
}//GEN-LAST:event_agregar_eventoActionPerformed

    private void agregar_contactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_contactoActionPerformed
   
        formulario_agregar_contacto=new Agregar_contacto(this,true, operaciones,calendario.getDate());
        formulario_agregar_contacto.setLocation(this.location().x+150, this.location().y+80);
        formulario_agregar_contacto.setVisible(true);
        initComponents();//actualiza el panel
}//GEN-LAST:event_agregar_contactoActionPerformed

    private void listar_contactosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listar_contactosActionPerformed
        listarcontactos=new listar_contactos(this,true, operaciones);
        listarcontactos.setLocation(this.location().x+150, this.location().y+80);
        listarcontactos.setVisible(true);
}//GEN-LAST:event_listar_contactosActionPerformed

    private void exportar_bdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportar_bdActionPerformed
       JFileChooser exportar=new JFileChooser();
       String ruta = "";
       try{
           exportar.setFileSelectionMode(exportar.DIRECTORIES_ONLY);
           int status= exportar.showSaveDialog(null);
           if(status==exportar.APPROVE_OPTION){
           ruta = exportar.getSelectedFile().getAbsolutePath();
           ruta=ruta+"/registro.db";
           if(new File(ruta).exists())
                {
                if(JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(this,"El fichero existe,deseas reemplazarlo?","Titulo",JOptionPane.YES_NO_OPTION))
                  {
                      
                      FileCopy("BD/registro.db", ruta);
                  }
                }else{
                     FileCopy("BD/registro.db", ruta);
               }
             }
       }catch (Exception ex){
        ex.printStackTrace();
       }
 
    }//GEN-LAST:event_exportar_bdActionPerformed

    private void importar_bdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importar_bdActionPerformed
        JFileChooser importar=new JFileChooser();
        String ruta = "";
        try{
           int status= importar.showSaveDialog(null);
           if(status==importar.APPROVE_OPTION){
           ruta = importar.getSelectedFile().getAbsolutePath();
                      actualizar_bd(ruta);
                      //System.out.println(ruta);
           }
       }catch (Exception ex){
        ex.printStackTrace();
       }
    }//GEN-LAST:event_importar_bdActionPerformed

    public void listar_resp(ResultSet matriz)
    {
        //recorrer matriz de resultados y colocar en el panel de de paneles.
        panel_eventos.removeAll();
        
        try{
          int i=0;  
          while(matriz.next())
          {
           final JPanelTransparente paneli =new JPanelTransparente();
           paneli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneliMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paneliMouseExited(evt,paneli);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                paneliMouseEntered(evt,paneli);
            }
        });
           
           paneli.setLayout(null);
           paneli.setBounds(5, (55*i)+10, 160, 50);
           paneli.setToolTipText(matriz.getString(3));
           
           JLabel texto=new JLabel();
           texto.setText(matriz.getString(2));
           texto.setBounds(30, 0, 150, 15);
           
           JLabel texto_hora=new JLabel();
           texto_hora.setText("De "+matriz.getString(4)+" a "+matriz.getString(5));
           texto_hora.setBounds(30, 15, 100, 15);
           paneli.add(texto_hora);
           paneli.add(texto);
           Evento evento=new Evento(Integer.parseInt(matriz.getString(1)),matriz.getString(2),matriz.getString(3),matriz.getString(4),matriz.getString(5));
           paneli.set_evento(evento);
           
           panel_eventos.add(paneli);
           i++;
          }  
          
            
          }catch(Exception e){
             System.out.println("Problema al imprimir la base de datos en listar_resp");
        }
        //panel.repaint();
        panel_eventos.setVisible(true);
        panel_eventos.repaint();
     
        //System.out.println("llego hasta recyperar consulta");
    }
     private void paneliMouseClicked(java.awt.event.MouseEvent evt) {                                     
        
         Ventana_Evento ve=new Ventana_Evento(this, true);
         Evento evento = ((JPanelTransparente)evt.getComponent()).get_evento();
         ve.set_evento(evento);
         
         ve.setVisible(true);
    }
    private void paneliMouseEntered(java.awt.event.MouseEvent evt, JPanelTransparente paneli)
    {
        paneli.setColorSecundario(Color.cyan);
        paneli.setSize(paneli.getSize().width+5, paneli.getSize().height+5);
    }
    private void paneliMouseExited(java.awt.event.MouseEvent evt, JPanelTransparente paneli)
    {
        paneli.setSize(paneli.getSize().width-5, paneli.getSize().height-5);
        paneli.setColorSecundario(Color.black);
    }
    /**
     * @param args the command line arguments
     */
    class MiEvento implements ActionListener {

    public void actionPerformed(ActionEvent e) {


      /*if (e.getSource().equals(botonGuardar)) {
       
        
      }*/
    }
  }
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton_buscar;
    private javax.swing.JButton agregar_contacto;
    private javax.swing.JButton agregar_evento;
    private javax.swing.JMenu ajustes;
    private com.toedter.calendar.JCalendar calendario;
    private javax.swing.JMenuItem exportar_bd;
    private javax.swing.JMenuItem importar_bd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton listar_contactos;
    private javax.swing.JPanel panel_eventos;
    // End of variables declaration//GEN-END:variables

 	
 
}
