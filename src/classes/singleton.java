/**
 * Author: Mohammad Mofeed AlBanna.
 * Web Developer
 * Website: www.MBanna.info
 * Blog: www.OutOfPalBox.net
 * Facebook: www.FB.com/MBanna.info
 */

package classes;

import MainPackage.ChangeSizeOfImages;
import MainPackage.InWindowsClose;
import MainPackage.ReadingFileImage;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.Icon;
import javax.swing.JMenu;


public class singleton {
    
    static ChangeSizeOfImages changesizeObject=new ChangeSizeOfImages();
    static JPopupMenu pop=new JPopupMenu();
    static JRadioButtonMenuItem OrientationRightToLeft=new JRadioButtonMenuItem("قراءة النص من اليمين لليسار");
    static JRadioButtonMenuItem OrientationLeftToRight=new JRadioButtonMenuItem("قراءة النص من اليسار لليمين");
    static JMenuItem UndoPopMenu=new JMenuItem("تراجع");
    static JMenuItem RedoPopMenu=new JMenuItem("تقدم");
    static JMenuItem ViewHTMLCodeMenuItem=new JMenuItem("فتح محررة HTML");
    static JMenuItem DefaultPastePopMenu=new JMenuItem("لصق-مستندات عادية");   
    static JFileChooser chooserFiles = new JFileChooser();// Like This , the last path will be Still :)
    static JFileChooser chooserImages = new JFileChooser();
    static JFileChooser chooserHTML = new JFileChooser();
    static FNPfilesFilter FNPfilesFilterObject= new FNPfilesFilter();
    static ALLfilesView ALLfilesViewObject= new ALLfilesView();
    static TXTfilesFilter TXTfilesFilterObject=new TXTfilesFilter();
    static ImagesFileFilters ImagesFileFiltersOject= new ImagesFileFilters();
    static ImagePreview ImagePreviewObject=new ImagePreview(chooserImages);
    static String maintype=new String("application/octet-stream");
    static InWindowsClose InWindowsCloseObject=new InWindowsClose(new JFrame(),true);
    static ImageFileView ImageFileViewObject=new ImageFileView();
    static HTMLfilesFilter HTMLfilesFilterObject=new HTMLfilesFilter();         
    static File EmptyPath=new File("");// this for remove file name from file chooser ..
    static String[] charsetsToBeTested = {"UTF-8","unicode","cp1256","windows-1253","UTF-16", "ISO-8859-7"};
    static Icon XButtonIcon=new MyImageIcon(ClassLoader.getSystemClassLoader().getClass().getResource("/Images/XwithOutClick.png"));
    static Icon TabIcon =new MyImageIcon(ClassLoader.getSystemClassLoader().getClass().getResource("/Images/noteIco.png"));
    static Icon XButtonOver =new MyImageIcon(ClassLoader.getSystemClassLoader().getClass().getResource("/Images/xOnClick.png"));
    static ReadingFileImage ReadingFileObject=new ReadingFileImage();
    static JMenu EncodingMenu=new JMenu("قراءة الملف بترميز :");

    public static JMenu getEncodingMenu() {
        return EncodingMenu;
    }

    public static ReadingFileImage getReadingFileObject() {
        return ReadingFileObject;
    }
   
    public static Icon getXButtonOver() {
        return XButtonOver;
    }


    public static Icon getTabIcon() {
        return TabIcon;
    }

    public static Icon getXButtonIcon() {
        return XButtonIcon;
    }


    public static String[] getCharsetsToBeTested() {
        return charsetsToBeTested;
    }



      public static File getEmptyPath() {
        return EmptyPath;
    }



    public static HTMLfilesFilter getHTMLfilesFilterObject() {
        return HTMLfilesFilterObject;
    }



      public static JFileChooser getChooserHTML() {
        return chooserHTML;
    }


    public static ImageFileView getImageFileViewObject() {
        return ImageFileViewObject;
    }


    public static InWindowsClose getInWindowsCloseObject() {
        return InWindowsCloseObject;
    }

    public static JFileChooser getchooserImages() {
        return chooserImages;
    }



    public static String getMaintype() {
        return maintype;
    }

    public static ImagePreview getImagePreviewObject() {
        return ImagePreviewObject;
    }



    public static TXTfilesFilter getTXTfilesFilterObject() {
        return TXTfilesFilterObject;
    }

    public static ImagesFileFilters getImagesFileFiltersOject() {
        return ImagesFileFiltersOject;
    }


    public static ALLfilesView getALLfilesViewObject() {
        return ALLfilesViewObject;
    }



    public static FNPfilesFilter getFNPfilesFilterObject() {
        return FNPfilesFilterObject;
    }


    public static JFileChooser getchooserFiles() {
        return chooserFiles;
    }


    static JMenuItem HTMLPastePopMenu=new JMenuItem("لصق-مستند ويب");

    public static JMenuItem getHTMLPastePopMenu() {
        return HTMLPastePopMenu;
    }

   public static JMenuItem getDefaultPastePopMenu() {
        return DefaultPastePopMenu;
    }


    public static JMenuItem getViewHTMLCodeMenuItem() {
        return ViewHTMLCodeMenuItem;
    }


    public static JMenuItem getRedoPopMenu() {
        return RedoPopMenu;
    }



    public static JMenuItem getUndoPopMenu() {
        return UndoPopMenu;
    }



    public static JRadioButtonMenuItem getOrientationLeftToRight() {
        return OrientationLeftToRight;
    }



    public static JRadioButtonMenuItem getOrientationRightToLeft() {
        return OrientationRightToLeft;
    }


public static ChangeSizeOfImages getChangesizeObject() {
        return changesizeObject;
    }// end function


 public static JPopupMenu getPop() {
        return pop;
    }


}

