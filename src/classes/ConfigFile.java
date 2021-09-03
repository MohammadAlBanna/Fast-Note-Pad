/**
 * Author: Mohammad Mofeed AlBanna.
 * Web Developer
 * Website: www.MBanna.info
 * Blog: www.OutOfPalBox.net
 * Facebook: www.FB.com/MBanna.info
 */


//  this class to save the Configuration that the user did it ,
// like change the background and change the title border color and so on ..

package classes;

import java.awt.Color;
import java.io.Serializable;


public class ConfigFile implements Serializable {
private static final long serialVersionUID = 1L;// set SerialVersion
String thePath;
Color StatusBarForegroundColor;
Color TitleBarForegroundColor;

    public void setStatusBarForegroundColor(Color ForegroundColor) {
        this.StatusBarForegroundColor = ForegroundColor;
    }

    public void setThePath(String thePath) {
        this.thePath = thePath;
    }

    public Color getStatusBarForegroundColor() {
        return StatusBarForegroundColor;
    }

    public void setTitleBarForegroundColor(Color TitleBarForegroundColor) {
        this.TitleBarForegroundColor = TitleBarForegroundColor;
    }

    public Color getTitleBarForegroundColor() {
        return TitleBarForegroundColor;
    }

    public String getThePath() {
        return thePath;
    }

}// end class 
