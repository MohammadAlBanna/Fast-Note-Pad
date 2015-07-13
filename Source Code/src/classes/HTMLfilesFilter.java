/**
 * Author: Mohammad Mofeed AlBanna.
 * Web Developer
 * Website: www.MBanna.info
 * Blog: www.OutOfPalBox.net
 * Facebook: www.FB.com/MBanna.info
 */


package classes;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

class UtilsHtml {
    public final static String html= "html";
  
  
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
        java.net.URL imgURL = UtilsHtml.class.getResource(path);
        if (imgURL != null) {
            return new MyImageIcon(imgURL);
        } else {
            JOptionPane.showMessageDialog(null,"خطأ في عملية تصفية الملفات ...","رسالة خطأ",JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }
}



public class HTMLfilesFilter extends FileFilter {

    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = UtilsHtml.getExtension(f);
        if (extension != null) {
            if (extension.equalsIgnoreCase(UtilsHtml.html)
                ) {
                    return true;
            } else {
                return false;
            }
        }

        return false;
    }

    //The description of this filter
    public String getDescription() {
        return "*.html";
    }
}
