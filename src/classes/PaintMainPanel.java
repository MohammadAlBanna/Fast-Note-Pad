/**
 * Author: Mohammad Mofeed AlBanna.
 * Web Developer
 * Website: www.MBanna.info
 * Blog: www.OutOfPalBox.net
 * Facebook: www.FB.com/MBanna.info
 */

package classes;


import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class PaintMainPanel extends JPanel{

     public static BufferedImage image;
     public static int mywidth;
     public static int myheight;

    public PaintMainPanel(){
        try{
        image = ImageIO.read(getClass().getResource("/Images/MainBackGround.png"));
        mywidth=image.getWidth();
        myheight=image.getHeight();
        }
        catch(Exception e){
        // do nothing
        }
        }


        @Override
        public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2.drawImage(image, 0, 0, mywidth, myheight, null);

 }// end paintComponent method

}// end class 
