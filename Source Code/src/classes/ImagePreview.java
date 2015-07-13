/**
 * Author: Mohammad Mofeed AlBanna.
 * Web Developer
 * Website: www.MBanna.info
 * Blog: www.OutOfPalBox.net
 * Facebook: www.FB.com/MBanna.info
 */


package classes;
// This to prebiew Image while user select the image when open FileChooser to choose PIC ..
import javax.swing.JFileChooser;
import javax.swing.JComponent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Graphics;
import java.io.File;


public class ImagePreview extends JComponent
                          implements PropertyChangeListener {
    MyImageIcon thumbnail = null;
    File file = null;
    // to change the size of painted panel ( to preview the image )
    public ImagePreview(JFileChooser fc) {
        setPreferredSize(new Dimension(200, 100));
        fc.addPropertyChangeListener(this);
    }

    public void loadImage() {
        if (file == null) {
            thumbnail = null;
            return;
        }
     // Change the size here too ...
        MyImageIcon tmpIcon = new MyImageIcon(file.getPath());
        if (tmpIcon != null) {
            if (tmpIcon.getIconWidth() > 200) {
                thumbnail = new MyImageIcon(tmpIcon.getImage().
                                          getScaledInstance(200, -1,
                                                      Image.SCALE_DEFAULT));
            } else { //no need to miniaturize
                thumbnail = tmpIcon;
            }
        }
    }

    public void propertyChange(PropertyChangeEvent e) {
        boolean update = false;
        String prop = e.getPropertyName();


        if (JFileChooser.DIRECTORY_CHANGED_PROPERTY.equals(prop)) {
            file = null;
            update = true;

        } else if (JFileChooser.SELECTED_FILE_CHANGED_PROPERTY.equals(prop)) {
            file = (File) e.getNewValue();
            update = true;
        }

        if (update) {
            thumbnail = null;
            if (isShowing()) {
                loadImage();
                repaint();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (thumbnail == null) {
            loadImage();
        }
        if (thumbnail != null) {
            int x = getWidth()/2 - thumbnail.getIconWidth()/2;
            int y = getHeight()/2 - thumbnail.getIconHeight()/2;

            if (y < 0) {
                y = 0;
            }

            if (x < 5) {
                x = 5;
            }
            thumbnail.paintIcon(this, g, x, y);
        }
    }
}