/**
 * Author: Mohammad Mofeed AlBanna.
 * Web Developer
 * Website: www.MBanna.info
 * Blog: www.OutOfPalBox.net
 * Facebook: www.FB.com/MBanna.info
 */


package classes;

import java.awt.Color;
import java.io.Serializable;
import javax.swing.Icon;
 

public class ContentOfJTextPane implements Serializable{
private static final long serialVersionUID = 1L;
String theFont;
int theSize;
int alignment;
Color textColor;
Color textBGColor;
Character character;//if character
Icon icon;//if icon
boolean isBold;
boolean isItalic;
boolean isUnderLing;



    public int getAlignment() {
        return alignment;
    }

    public void setAlignment(int alignment) {
        this.alignment = alignment;
    }

    
    public boolean isIsBold() {
        return isBold;
    }

    public boolean isIsItalic() {
        return isItalic;
    }

    public boolean isIsUnderLing() {
        return isUnderLing;
    }

    public void setIsBold(boolean isBold) {
        this.isBold = isBold;
    }

    public void setIsItalic(boolean isItalic) {
        this.isItalic = isItalic;
    }

    public void setIsUnderLing(boolean isUnderLing) {
        this.isUnderLing = isUnderLing;
    }


    public void setCharacter(Character character) {
        this.character = character;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public Character getCharacter() {
        return character;
    }

    public Icon getIcon() {
        return icon;
    }


    public void setTextBGColor(Color textBGColor) {
        this.textBGColor = textBGColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }



    public void setTheFont(String theFont) {
        this.theFont = theFont;
    }

    public void setTheSize(int theSize) {
        this.theSize = theSize;
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Color getTextBGColor() {
        return textBGColor;
    }

    public Color getTextColor() {
        return textColor;
    }



    public String getTheFont() {
        return theFont;
    }

    public int getTheSize() {
        return theSize;
    }


}
