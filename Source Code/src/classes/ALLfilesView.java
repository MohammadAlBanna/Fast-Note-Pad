/**
 * Author: Mohammad Mofeed AlBanna.
 * Web Developer
 * Website: www.MBanna.info
 * Blog: www.OutOfPalBox.net
 * Facebook: www.FB.com/MBanna.info
 */

// This class to add Image for all these file when view it ...
package classes;
  
import java.io.File;
import javax.swing.Icon;
import javax.swing.filechooser.FileView;

     
class UtilsAllFiles {
    public final static String fnp= "fnp";
    public final static String html= "html";
    public final static String txt= "txt";
    public final static String jpeg = "jpeg";
    public final static String jpg = "jpg";
    public final static String gif = "gif";
    public final static String tiff = "tiff";
    public final static String tif = "tif";
    public final static String png = "png";


    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }

    protected static MyImageIcon createImageIcon(String path) {
        java.net.URL imgURL = UtilsAllFiles.class.getResource(path);
        if (imgURL != null) {
            return new MyImageIcon(imgURL);
        } else {
            return null;
        }
    }
}
 
public class ALLfilesView  extends FileView {
    MyImageIcon fnpIcon = UtilsAllFiles.createImageIcon("/Images/fnp.png");
    MyImageIcon htmlIcon = UtilsAllFiles.createImageIcon("/Images/html.png");
    MyImageIcon txtIcon = UtilsAllFiles.createImageIcon("/Images/txt.png");
    MyImageIcon jpgIcon = UtilsAllFiles.createImageIcon("/Images/jpg.png");
    MyImageIcon gifIcon = UtilsAllFiles.createImageIcon("/Images/gif.png");
    MyImageIcon tiffIcon = UtilsAllFiles.createImageIcon("/Images/tiff.png");
    MyImageIcon pngIcon = UtilsAllFiles.createImageIcon("/Images/png.png");
    MyImageIcon tifIcon = UtilsAllFiles.createImageIcon("/Images/tif.png");
    MyImageIcon jpegIcon = UtilsAllFiles.createImageIcon("/Images/jpeg.png");


    @Override
    public String getName(File f) {
        return null; //let the L&F FileView figure this out
    }

    @Override
    public String getDescription(File f) {
        return null; //let the L&F FileView figure this out
    }

    @Override
    public Boolean isTraversable(File f) {
        return null; //let the L&F FileView figure this out
    }

    @Override
    public String getTypeDescription(File f) {
        String extension = UtilsAllFiles.getExtension(f);
        String type = null;

        if (extension != null) {
            if (extension.equalsIgnoreCase(UtilsAllFiles.fnp))
                type = "*.fnp";
            else if (extension.equalsIgnoreCase(UtilsAllFiles.html))
                type = "*.html";
            else if (extension.equalsIgnoreCase(UtilsAllFiles.txt))
                 type = "*.txt";
            else if(extension.equalsIgnoreCase(Utils.jpg))
              type="*.jpg";
            else if(extension.equalsIgnoreCase(Utils.jpeg))
              type = "*.jpeg";
            else if (extension.equalsIgnoreCase(Utils.gif))
              type = "*.gif";
            else if (extension.equalsIgnoreCase(Utils.tiff))
              type="*.tiff";
            else if (extension.equalsIgnoreCase(Utils.tif))
              type = "*.tif";
            else if (extension.equalsIgnoreCase(Utils.png))
              type = "*.png";

        }
        return type;
    }

    @Override
    public Icon getIcon(File f) {
        String extension = UtilsAllFiles.getExtension(f);
        Icon icon = null;

        if (extension != null) {
            if (extension.equalsIgnoreCase(UtilsAllFiles.fnp))
                icon = fnpIcon;
            else if(extension.equalsIgnoreCase(UtilsAllFiles.html))
               icon=htmlIcon;
            else if(extension.equalsIgnoreCase(UtilsAllFiles.txt))
               icon=txtIcon;

            else if(extension.equalsIgnoreCase(Utils.jpg))
              icon=jpgIcon;
            else if(extension.equalsIgnoreCase(Utils.jpeg))
              icon =jpegIcon;
            else if (extension.equalsIgnoreCase(Utils.gif))
              icon =gifIcon;
            else if (extension.equalsIgnoreCase(Utils.tiff))
              icon=tiffIcon;
            else if (extension.equalsIgnoreCase(Utils.tif))
              icon=tifIcon;
            else if (extension.equalsIgnoreCase(Utils.png))
              icon =pngIcon;
        }
        return icon;
    }
}
