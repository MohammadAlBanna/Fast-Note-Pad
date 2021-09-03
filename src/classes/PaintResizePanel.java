/**
 * Author: Mohammad Mofeed AlBanna.
 * Web Developer
 * Website: www.MBanna.info
 * Blog: www.OutOfPalBox.net
 * Facebook: www.FB.com/MBanna.info
 */


package classes;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;
import java.awt.Graphics;


public class PaintResizePanel extends JPanel{
   public PaintResizePanel(){
    super.setOpaque(false);
  }

    @Override
    public void paint(Graphics g) {


            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
	    RoundRectangle2D r0 = new RoundRectangle2D.Double(0,0,144,133,20,20);
            g2.setPaint(Color.BLACK);
            g2.fill(r0);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
            super.paint(g2);

}// end function paint
}
