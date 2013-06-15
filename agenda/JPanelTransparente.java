/*
 * Package agenda
 */
//package agenda;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
//import javaapplication4.JPanelRound;

/**
 *
 * @author equipo de programacion Agil
 */
public class JPanelTransparente extends JPanelRound {

  private float tran = 0.4f;
  private Evento evento;
  
  public JPanelTransparente() {
  }

  @Override
  protected void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    AlphaComposite old = (AlphaComposite) g2.getComposite();
    g2.setComposite(AlphaComposite.SrcOver.derive(getTran()));
    super.paintComponent(g);
    g2.setComposite(old);
  }
 public void get_nombre() {
     
 } 
  public float getTran() {
    return tran;
  }
  public void setTran(float tran) {
    this.tran = tran;
  }
  public void set_evento(Evento evento)
  {
      this.evento=evento;
  }
  public Evento get_evento()
  {
      return evento;
  }
  
}
