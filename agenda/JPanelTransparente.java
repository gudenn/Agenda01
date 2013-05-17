/*
 * Package agenda
 */
package agenda;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
//import javaapplication4.JPanelRound;

/**
 *
 * @author equipo de programacion Agil
 */
public class JPanelTransparente extends JPanelRound {

  private float tran = 0.4f;

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

  public float getTran() {
    return tran;
  }

  public void setTran(float tran) {
    this.tran = tran;
  }
}
