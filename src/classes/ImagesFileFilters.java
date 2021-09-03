/**
 * Author: Mohammad Mofeed AlBanna.
 * Web Developer
 * Website: www.MBanna.info
 * Blog: www.OutOfPalBox.net
 * Facebook: www.FB.com/MBanna.info
 */


package classes;
// To Filter These Extensions .... And just show these extensions to the use
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;



class Utilse{
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
        java.net.URL imgURL = ImagesFileFilters.class.getResource(path);
        if (imgURL != null) {
            return new MyImageIcon(imgURL);
        } else {
            JOptionPane.showMessageDialog(null,"خطأ في عملية تصفية الصور !","رسالة خطأ",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}



public class ImagesFileFilters extends FileFilter {

    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = Utilsser.getExtension(f);
        if (extension != null) {
            if (extension.equalsIgnoreCase(Utilse.tiff) ||
                extension.equalsIgnoreCase(Utilse.tif) ||
                extension.equalsIgnoreCase(Utilse.gif) ||
                extension.equalsIgnoreCase(Utilse.jpeg) ||
                extension.equalsIgnoreCase(Utilse.jpg) ||
                extension.equalsIgnoreCase(Utilse.png)) {
                    return true;
            } else {
                return false;
            }
        }

        return false;
    }

    //The description of this filter
    public String getDescription() {
        return "*.JPG,*.JPEG,*.PNG,*.GIF,*.TIFF,*.TIF";
    }
}
