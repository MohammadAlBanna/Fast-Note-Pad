/**
 * Author: Mohammad Mofeed AlBanna.
 * Web Developer
 * Website: www.MBanna.info
 * Blog: www.OutOfPalBox.net
 * Facebook: www.FB.com/MBanna.info
 */


package MainPackage;

import java.nio.charset.Charset;
import classes.AllFunctions;
import classes.CharsetDetector;
import classes.MyImageIcon;
import classes.ReaderToInputStream;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import classes.singleton;
import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.ButtonGroup;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.LinkedList;
import javax.activation.MimetypesFileTypeMap;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyledDocument;
import classes.PaintMainPanel;
import java.awt.Color;


public class FastNotepadFrame extends JFrame {
//****************************************************************************** Variables ...
static public JTextPane TheCurrentPane;
int TheIndexOfContentPanel;
private ActionEvent event=null;
static private String empty="";
static private String nullValue="null";
public static File OpendFileToLinkedList;
public static LinkedList<File> selectedFiles=new LinkedList<File>();// to get paths of files and save them to LinkedList
public static FastNotepadFrame DefaultFastNotepadFrameObject;
public static JButton Xbutton;
private Object ob=new Object();
String nameOfLabelWhenReadingFile="";
AboutMe AboutMeObject=null;
AboutVersion2 AboutVersion2Object=null;
AboutVersion3 AboutVersion3Object=null;
ConfigTheProgram ConfigTheProgramObject=null;
ViewHTMLCode ViewHTMLCodeObject=null;
ReplaceTextGlobal ReplaceTextGlobalObject=null;
ShapesAndSymbols ShapesAndSymbolsObject=null;
//******************************************************************************
// Constructors .....
public FastNotepadFrame() {
        initComponents();
        AllFunctions.CheckFastNotePadConfig();
        Xbutton = new JButton(new MyImageIcon(getClass().getResource("/Images/XwithOutClick.png")));
        SearchforWords.setVisible(false);       
        Xbutton.setVisible(false);
        OpenNewTabMenuItemActionPerformed(event);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-getWidth())-(((Toolkit.getDefaultToolkit().getScreenSize().width-getWidth())/2)),0);
        AllFunctions.AutoHelp(AllFunctions.Help,OperationsLabel);
        Image im=new MyImageIcon(getClass().getResource("/Images/fnp.png")).getImage();
        setIconImage(im);
        AddPopUpMenuAndListeners();
        TheCurrentPane.requestFocusInWindow();
        TheCurrentPane.setCaretPosition(0);
            }// end constructor if there no Argument here ..
//******************************************************************************
 
public FastNotepadFrame(File pathOfFile) {
        initComponents();
        AllFunctions.CheckFastNotePadConfig();
        Xbutton = new JButton(new MyImageIcon(getClass().getResource("/Images/XwithOutClick.png")));
        SearchforWords.setVisible(false);
        Xbutton.setVisible(false);
        OpenNewTabMenuItemActionPerformed(event);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-getWidth())-(((Toolkit.getDefaultToolkit().getScreenSize().width-getWidth())/2)),0);
        AllFunctions.AutoHelp(AllFunctions.Help,OperationsLabel);
        if(pathOfFile.toString().toLowerCase().endsWith(".fnp"))
        OpentFNPFiles(pathOfFile);
        else if (pathOfFile.toString().toLowerCase().endsWith(".html"))
        OpenHTMLFiles(pathOfFile);
        else if(pathOfFile.toString().toLowerCase().endsWith(".jpg")||
                pathOfFile.toString().toLowerCase().endsWith(".gif")||
                pathOfFile.toString().toLowerCase().endsWith(".tiff")||
                pathOfFile.toString().toLowerCase().endsWith(".tif")||
                pathOfFile.toString().toLowerCase().endsWith(".jpeg")||
                pathOfFile.toString().toLowerCase().endsWith(".png"))
        OpenImageFiles(pathOfFile);

        else
        OpenOtherFilesFile(pathOfFile);
        Image im=new MyImageIcon(getClass().getResource("/Images/fnp.png")).getImage();
        setIconImage(im);
        TheCurrentPane.requestFocusInWindow();
        TheCurrentPane.setCaretPosition(0);
        AddPopUpMenuAndListeners();

 }// end constructor if there no Argument here ..
//******************************************************************************
// Set Listener for get Lines and Cols .
public void setKeyReleasedListener(final JTextPane pane){
pane.addKeyListener(new KeyAdapter() {
@Override
public void keyReleased(KeyEvent evt){
try{
linesAndColLabel.setText(" أحرف : "+pane.getText().length()+"/ أسطر : "+pane.getText().split("\n").length);
UndoMenuItem.setEnabled(UndoAndRedo.getUndoButton().isEnabled());// Set Enabled for Undo Menu Item
RedoMenuItem.setEnabled(UndoAndRedo.getRedoButton().isEnabled());// Set Enabled for Redo Menu Item
//Set Listener for Save files on any update happend;
if(UndoAndRedo.getUndoButton().isEnabled())
    {
 if(!MyTab.getTitleAt(MyTab.getSelectedIndex()).contains("*"))
 {
     MyTab.setTitleAt(MyTab.getSelectedIndex(), MyTab.getTitleAt(MyTab.getSelectedIndex()) + "*");
    try{// Just for the user to see * mark in label
     JPanel panel=(JPanel)MyTab.getTabComponentAt(MyTab.getSelectedIndex());
     JLabel label=(JLabel)panel.getComponent(1);
     String PrevTitle=label.getText();
     MyTab.remove(panel);
     MyTab.remove(label);
     label.setText("*"+PrevTitle);
     panel.add(label, BorderLayout.WEST);
     MyTab.setTabComponentAt(MyTab.getSelectedIndex(), panel);
     }
    catch(Exception e){
    return;
    }//do nothing
        }//end if
 else
  MyTab.setTitleAt(MyTab.getSelectedIndex(),MyTab.getTitleAt(MyTab.getSelectedIndex()));
}//if there any change

//********************************************************************
// This for enter <br> tag if the user click on enter ..
  if(TheCurrentPane.getContentType().equals("text/html"))
if(KeyEvent.getKeyText(evt.getKeyChar()).equals("Enter")){
    String newString ="null";
 try{
           int start=TheCurrentPane.getText().indexOf("<body");// this to get Previous Text and save it !
           int End=TheCurrentPane.getText().indexOf("</body>");
            if(start!=-1||End!=-1)
            {
         newString = TheCurrentPane.getText().substring(start + 6, End - 4);//

         // These to remove </fon> tag from the TextPane ..
         newString=newString.replaceAll("</fon>","");
         newString=newString.replaceAll("</fon","");
         newString=newString.replaceAll("t>","");
         newString=newString.replaceAll("</cod>","");         
         newString=newString.replaceAll("</cod","");
         String theString="<br>";
        TheCurrentPane.getDocument().insertString(TheCurrentPane.getText().length(),"", null);// I don't know Why XD
        TheCurrentPane.setText(newString+theString);

 }//end if
  }//end try box
     catch(Exception e){
     return;
     }// end catch
}//end if
    }//end try box
catch(Exception e){
return;
// do nothing ..
}
}//end OverRid
});
}//end method

//******************************************************************************
public void setMouseReleasedAndPressed(final JTextPane pane){
pane.addMouseListener(new MouseAdapter() {
            @Override
public void mouseReleased(MouseEvent e){
   if(e.isPopupTrigger())
      {   // These to check if this new document , no file there
          if(selectedFiles.get(MyTab.getSelectedIndex()).toString().equals("null"))
          singleton.getEncodingMenu().setEnabled(false);
          else
          singleton.getEncodingMenu().setEnabled(true);
          // to set component orientaion in radio button
          if(TheCurrentPane.getComponentOrientation().isLeftToRight())
          {   singleton.getOrientationRightToLeft().setSelected(false);
              singleton.getOrientationLeftToRight().setSelected(true);}
          else{
          singleton.getOrientationRightToLeft().setSelected(true);
          singleton.getOrientationLeftToRight().setSelected(false);
          }
          // Undo and Redo
          singleton.getUndoPopMenu().setEnabled(UndoAndRedo.getUndoButton().isEnabled());// Set Enabled for Undo Pop Up Menu
          singleton.getRedoPopMenu().setEnabled(UndoAndRedo.getRedoButton().isEnabled());// Set Enabled for Redo Pop Up Menu

          singleton.getPop().show(e.getComponent(),e.getX(),e.getY());

      }


}         
//*****************
            @Override
public void mousePressed(MouseEvent e){
// I'm using this object, don't change the static ALPHA !
 if(ChooseTextColor.ObjectOfColorChooser!=null&&ChooseTextColor.ObjectOfColorChooser.isVisible())
ChooseTextColor.ObjectOfColorChooser.HideWindow();

 if(ChooseBGColor.ObjectOfColorChooser!=null&&ChooseBGColor.ObjectOfColorChooser.isVisible())
 ChooseBGColor.ObjectOfColorChooser.HideWindow();

 pane.setEditable(true);
 if(e.isPopupTrigger())
      {
          // These to check if this new document , no file there
          if(selectedFiles.get(MyTab.getSelectedIndex()).toString().equals("null"))
          singleton.getEncodingMenu().setEnabled(false);
          else
          singleton.getEncodingMenu().setEnabled(true);

          // to set component orientaion in radio button
          if(TheCurrentPane.getComponentOrientation().isLeftToRight())
          {   singleton.getOrientationRightToLeft().setSelected(false);
              singleton.getOrientationLeftToRight().setSelected(true);}
          else{
          singleton.getOrientationRightToLeft().setSelected(true);
          singleton.getOrientationLeftToRight().setSelected(false);
          }
          // Undo and Redo
          singleton.getUndoPopMenu().setEnabled(UndoAndRedo.getUndoButton().isEnabled());// Set Enabled for Undo Pop Up Menu
          singleton.getRedoPopMenu().setEnabled(UndoAndRedo.getRedoButton().isEnabled());// Set Enabled for Redo Pop Up Menu

          singleton.getPop().show(e.getComponent(),e.getX(),e.getY());
      }

  if(MouseEvent.getMouseModifiersText(e.getModifiers()).equals("Ctrl+Button1"))
 pane.setEditable(false);

}

});

pane.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
public void mouseMoved(MouseEvent event){
singleton.getChangesizeObject().setLocation(event.getXOnScreen(),event.getYOnScreen());

}
});
}
//******************************************************************************
public void setMouseClickListener(final JTextPane pane){
pane.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent event){
//**************************
// This to Update the Icon ....
Element element =pane.getStyledDocument().getCharacterElement(pane.getCaretPosition());
AttributeSet attributeSet = element.getAttributes();
Icon icon = StyleConstants.getIcon(attributeSet);
if(icon!=null){
singleton.getChangesizeObject().heightTextField.setText(String.valueOf(icon.getIconHeight()));
singleton.getChangesizeObject().widthTextField.setText(String.valueOf(icon.getIconWidth()));
singleton.getChangesizeObject().TheCurrentIcon=icon;
singleton.getChangesizeObject().TheCurrentPane=TheCurrentPane;
singleton.getChangesizeObject().setVisible(true);
 }//end if

//Set Listener for Save files on any update happend;
if(UndoAndRedo.getUndoButton().isEnabled())
    {
 if(!MyTab.getTitleAt(MyTab.getSelectedIndex()).contains("*"))
 {
     MyTab.setTitleAt(MyTab.getSelectedIndex(), MyTab.getTitleAt(MyTab.getSelectedIndex()) + "*");
    try{// Just for the user to see * mark in label
     JPanel panel=(JPanel)MyTab.getTabComponentAt(MyTab.getSelectedIndex());
     JLabel label=(JLabel)panel.getComponent(1);
     String PrevTitle=label.getText();
     MyTab.remove(panel);
     MyTab.remove(label);
     label.setText("*"+PrevTitle);
     panel.add(label, BorderLayout.WEST);
     MyTab.setTabComponentAt(MyTab.getSelectedIndex(), panel);
     }
    catch(Exception e){
    return;
    }//do nothing
        }//end if
 else
  MyTab.setTitleAt(MyTab.getSelectedIndex(),MyTab.getTitleAt(MyTab.getSelectedIndex()));
}//if there any change
}
});

}
//******************************************************************************
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new classes.PaintMainPanel();
        UndoAndRedoPanel = new javax.swing.JPanel();
        UndoAndRedo = new Components.UndoAndRedoForTextPane();
        PostionPanel = new javax.swing.JPanel();
        RightToLeftOrientation = new Components.SetOrientationRightToLeftForTextPane();
        LeftToRightOrientation = new Components.SetOrientationLeftToRightForTextPane();
        textInCenterForTextPane1 = new Components.TextInCenterForTextPane();
        textInRightForTextPane1 = new Components.TextInRightForTextPane();
        textInLeftForTextPane1 = new Components.TextInLeftForTextPane();
        FontPanel = new javax.swing.JPanel();
        selectFontComboBox = new Components.SelectedFontForTextPane();
        SelectSizeComboBox = new Components.SelectedSizeForTextPane();
        boldTextForTextPane2 = new Components.BoldTextForTextPane();
        italicTextForTextPane2 = new Components.ItalicTextForTextPane();
        underLineTextForTextPane2 = new Components.UnderLineTextForTextPane();
        ChooseTextColor = new Components.ChooseColorForTextForTextPane();
        ChooseBGColor = new Components.ChooseBGColorForTextForTextPane();
        MyTab = new javax.swing.JTabbedPane();
        statusBarPanel = new javax.swing.JSplitPane();
        linesAndColLabel = new javax.swing.JLabel();
        OperationsLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        contentLabel = new javax.swing.JLabel();
        SearchforWords = new Components.SearchWordsForTextPane();
        MenuBar = new javax.swing.JMenuBar();
        FileMenuItem = new javax.swing.JMenu();
        OpenNewTabMenuItem = new javax.swing.JMenuItem();
        OpenFileMenuItem = new javax.swing.JMenuItem();
        SaveMenuItem = new javax.swing.JMenuItem();
        SaveAsMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        PrintMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        ExitMenuItem = new javax.swing.JMenuItem();
        EditMenu = new javax.swing.JMenu();
        UndoMenuItem = new javax.swing.JMenuItem();
        RedoMenuItem = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        FontPlusPlus = new javax.swing.JMenuItem();
        FontMinMin = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        CutMenuItem = new javax.swing.JMenuItem();
        CopyMenuItem = new javax.swing.JMenuItem();
        DefaultPastMenuItem = new javax.swing.JMenuItem();
        HTMLPasteMenuItem = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        ConfigTheProgram = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        ReplaceTextMenuItem = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        SearchMenuItem = new javax.swing.JMenuItem();
        AddMenu = new javax.swing.JMenu();
        AddPicMenuItem = new javax.swing.JMenuItem();
        AddpicFromNetMenuItem = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        AddShapeAndSymbols = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        AddURLMenuItem = new javax.swing.JMenuItem();
        AboutMenu = new javax.swing.JMenu();
        AboutProgrammerMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        AboutVersion2MenuItem = new javax.swing.JMenuItem();
        AboutVersion3MenuItem = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        HelpMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Fast Notepad V3");
        setMinimumSize(new java.awt.Dimension(700, 500));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        UndoAndRedoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "فعل", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13))); // NOI18N
        UndoAndRedoPanel.setOpaque(false);

        javax.swing.GroupLayout UndoAndRedoPanelLayout = new javax.swing.GroupLayout(UndoAndRedoPanel);
        UndoAndRedoPanel.setLayout(UndoAndRedoPanelLayout);
        UndoAndRedoPanelLayout.setHorizontalGroup(
            UndoAndRedoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UndoAndRedoPanelLayout.createSequentialGroup()
                .addComponent(UndoAndRedo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        UndoAndRedoPanelLayout.setVerticalGroup(
            UndoAndRedoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UndoAndRedo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        PostionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "مواقع النصوص", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13))); // NOI18N
        PostionPanel.setOpaque(false);

        javax.swing.GroupLayout PostionPanelLayout = new javax.swing.GroupLayout(PostionPanel);
        PostionPanel.setLayout(PostionPanelLayout);
        PostionPanelLayout.setHorizontalGroup(
            PostionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PostionPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textInLeftForTextPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textInCenterForTextPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textInRightForTextPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LeftToRightOrientation, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RightToLeftOrientation, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PostionPanelLayout.setVerticalGroup(
            PostionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textInLeftForTextPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(textInCenterForTextPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(LeftToRightOrientation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(RightToLeftOrientation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(textInRightForTextPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        FontPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "إعدادات الخط", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13))); // NOI18N
        FontPanel.setOpaque(false);

        javax.swing.GroupLayout FontPanelLayout = new javax.swing.GroupLayout(FontPanel);
        FontPanel.setLayout(FontPanelLayout);
        FontPanelLayout.setHorizontalGroup(
            FontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FontPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ChooseTextColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ChooseBGColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectFontComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SelectSizeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boldTextForTextPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(italicTextForTextPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(underLineTextForTextPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        FontPanelLayout.setVerticalGroup(
            FontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FontPanelLayout.createSequentialGroup()
                .addGroup(FontPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ChooseTextColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ChooseBGColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selectFontComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SelectSizeComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boldTextForTextPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(italicTextForTextPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(underLineTextForTextPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        MyTab.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        MyTab.setMinimumSize(new java.awt.Dimension(800, 500));
        MyTab.setPreferredSize(new java.awt.Dimension(800, 500));
        MyTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MyTabMouseClicked(evt);
            }
        });
        MyTab.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                MyTabStateChanged(evt);
            }
        });

        statusBarPanel.setDividerLocation(650);
        statusBarPanel.setOpaque(false);

        linesAndColLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        linesAndColLabel.setText("أحرف:0 / أسطر :0");
        linesAndColLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        statusBarPanel.setRightComponent(linesAndColLabel);

        OperationsLabel.setFont(new java.awt.Font("Arial", 1, 14));
        OperationsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OperationsLabel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        statusBarPanel.setLeftComponent(OperationsLabel);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel4.setOpaque(false);

        contentLabel.setFont(new java.awt.Font("Arial", 0, 13));
        contentLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        SearchforWords.setOpaque(false);

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                .addComponent(UndoAndRedoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PostionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FontPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE))
            .addComponent(SearchforWords, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
            .addComponent(MyTab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(UndoAndRedoPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FontPanel, javax.swing.GroupLayout.Alignment.LEADING, 0, 56, Short.MAX_VALUE)
                    .addComponent(PostionPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MyTab, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusBarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SearchforWords, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        FileMenuItem.setText("ملف");
        FileMenuItem.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        OpenNewTabMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        OpenNewTabMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add tab.png"))); // NOI18N
        OpenNewTabMenuItem.setText("لسان جديد");
        OpenNewTabMenuItem.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        OpenNewTabMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenNewTabMenuItemActionPerformed(evt);
            }
        });
        FileMenuItem.add(OpenNewTabMenuItem);

        OpenFileMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        OpenFileMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Files.png"))); // NOI18N
        OpenFileMenuItem.setText("إفتح ملف ..");
        OpenFileMenuItem.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        OpenFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenFileMenuItemActionPerformed(evt);
            }
        });
        FileMenuItem.add(OpenFileMenuItem);

        SaveMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        SaveMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save.png"))); // NOI18N
        SaveMenuItem.setText("حفظ");
        SaveMenuItem.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        SaveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveMenuItemActionPerformed(evt);
            }
        });
        FileMenuItem.add(SaveMenuItem);

        SaveAsMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/gtk_save_as.png"))); // NOI18N
        SaveAsMenuItem.setText("حفظ بإسم ..");
        SaveAsMenuItem.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        SaveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveAsMenuItemActionPerformed(evt);
            }
        });
        FileMenuItem.add(SaveAsMenuItem);
        FileMenuItem.add(jSeparator1);

        PrintMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        PrintMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/print.png"))); // NOI18N
        PrintMenuItem.setText("طباعة");
        PrintMenuItem.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        PrintMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintMenuItemActionPerformed(evt);
            }
        });
        FileMenuItem.add(PrintMenuItem);
        FileMenuItem.add(jSeparator2);

        ExitMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/exit.png"))); // NOI18N
        ExitMenuItem.setText("خروج");
        ExitMenuItem.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        ExitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitMenuItemActionPerformed(evt);
            }
        });
        FileMenuItem.add(ExitMenuItem);

        FileMenuItem.setText("ملف");

        MenuBar.add(FileMenuItem);

        EditMenu.setText("تحرير");
        EditMenu.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        EditMenu.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                EditMenuMenuSelected(evt);
            }
        });

        UndoMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        UndoMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/undo.PNG"))); // NOI18N
        UndoMenuItem.setText("تراجع");
        UndoMenuItem.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        UndoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UndoMenuItemActionPerformed(evt);
            }
        });
        EditMenu.add(UndoMenuItem);

        RedoMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        RedoMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/redo.PNG"))); // NOI18N
        RedoMenuItem.setText("تقدم");
        RedoMenuItem.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        RedoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RedoMenuItemActionPerformed(evt);
            }
        });
        EditMenu.add(RedoMenuItem);
        EditMenu.add(jSeparator3);

        FontPlusPlus.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_EQUALS, java.awt.event.InputEvent.CTRL_MASK));
        FontPlusPlus.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        FontPlusPlus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/font+.png"))); // NOI18N
        FontPlusPlus.setText("خط++");
        FontPlusPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FontPlusPlusActionPerformed(evt);
            }
        });
        EditMenu.add(FontPlusPlus);

        FontMinMin.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_MINUS, java.awt.event.InputEvent.CTRL_MASK));
        FontMinMin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/font decrease.png"))); // NOI18N
        FontMinMin.setText("خط--");
        FontMinMin.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        FontMinMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FontMinMinActionPerformed(evt);
            }
        });
        EditMenu.add(FontMinMin);
        EditMenu.add(jSeparator8);

        CutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        CutMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cut.png"))); // NOI18N
        CutMenuItem.setText("قص");
        CutMenuItem.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        CutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CutMenuItemActionPerformed(evt);
            }
        });
        EditMenu.add(CutMenuItem);

        CopyMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        CopyMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        CopyMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Copy.png"))); // NOI18N
        CopyMenuItem.setText("نسخ");
        CopyMenuItem.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        CopyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopyMenuItemActionPerformed(evt);
            }
        });
        EditMenu.add(CopyMenuItem);

        DefaultPastMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        DefaultPastMenuItem.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        DefaultPastMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/default paste.png"))); // NOI18N
        DefaultPastMenuItem.setText("لصق-مستندات عادية");
        DefaultPastMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DefaultPastMenuItemActionPerformed(evt);
            }
        });
        EditMenu.add(DefaultPastMenuItem);

        HTMLPasteMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK));
        HTMLPasteMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK));
        HTMLPasteMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/paste html.png"))); // NOI18N
        HTMLPasteMenuItem.setText("لصق-مستند ويب");
        HTMLPasteMenuItem.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        HTMLPasteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HTMLPasteMenuItemActionPerformed(evt);
            }
        });
        EditMenu.add(HTMLPasteMenuItem);
        EditMenu.add(jSeparator9);

        ConfigTheProgram.setText("إعدادات شكلية");
        ConfigTheProgram.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        ConfigTheProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfigTheProgramActionPerformed(evt);
            }
        });
        EditMenu.add(ConfigTheProgram);
        EditMenu.add(jSeparator10);

        ReplaceTextMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        ReplaceTextMenuItem.setText("إستبدال نصوص");
        ReplaceTextMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Replace MenuItem.png"))); // NOI18N
        ReplaceTextMenuItem.setText("إستبدال النصوص");
        ReplaceTextMenuItem.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        ReplaceTextMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReplaceTextMenuItemActionPerformed(evt);
            }
        });
        EditMenu.add(ReplaceTextMenuItem);
        EditMenu.add(jSeparator4);

        SearchMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        SearchMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search.png"))); // NOI18N
        SearchMenuItem.setText("إبحث ...");
        SearchMenuItem.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        SearchMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchMenuItemActionPerformed(evt);
            }
        });
        EditMenu.add(SearchMenuItem);

        EditMenu.setText("تحرير");

        MenuBar.add(EditMenu);

        AddMenu.setText("إدراج");
        AddMenu.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        AddPicMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        AddPicMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/open image.png"))); // NOI18N
        AddPicMenuItem.setText("إدراج صورة من الجهاز..");
        AddPicMenuItem.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        AddPicMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPicMenuItemActionPerformed(evt);
            }
        });
        AddMenu.add(AddPicMenuItem);

        AddpicFromNetMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        AddpicFromNetMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/downloadpic.png"))); // NOI18N
        AddpicFromNetMenuItem.setText("إدراج صورة من الإنترنت ..");
        AddpicFromNetMenuItem.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        AddpicFromNetMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddpicFromNetMenuItemActionPerformed(evt);
            }
        });
        AddMenu.add(AddpicFromNetMenuItem);
        AddMenu.add(jSeparator6);

        AddShapeAndSymbols.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        AddShapeAndSymbols.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add symbols.png"))); // NOI18N
        AddShapeAndSymbols.setText("إدراج رموز وأشكال");
        AddShapeAndSymbols.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        AddShapeAndSymbols.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddShapeAndSymbolsActionPerformed(evt);
            }
        });
        AddMenu.add(AddShapeAndSymbols);
        AddMenu.add(jSeparator7);

        AddURLMenuItem.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        AddURLMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        AddURLMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Internet url.png"))); // NOI18N
        AddURLMenuItem.setText("إدراج رابط في مستند HTML");
        AddURLMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        AddURLMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddURLMenuItemActionPerformed(evt);
            }
        });
        AddMenu.add(AddURLMenuItem);

        MenuBar.add(AddMenu);

        AboutMenu.setText("حول");
        AboutMenu.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        AboutProgrammerMenuItem.setText("حول المبرمج");
        AboutProgrammerMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/about.png"))); // NOI18N
        AboutProgrammerMenuItem.setText("حول المبرمج");
        AboutProgrammerMenuItem.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        AboutProgrammerMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutProgrammerMenuItemActionPerformed1(evt);
            }
        });
        AboutMenu.add(AboutProgrammerMenuItem);

        jMenu1.setText("حول النسخ");
        jMenu1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        AboutVersion2MenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Etoile V2.png"))); // NOI18N
        AboutVersion2MenuItem.setText("النسخة الثانية");
        AboutVersion2MenuItem.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        AboutVersion2MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutVersion2MenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(AboutVersion2MenuItem);

        AboutVersion3MenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Etoile V3.png"))); // NOI18N
        AboutVersion3MenuItem.setText("النسخة الثالثة");
        AboutVersion3MenuItem.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        AboutVersion3MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutVersion3MenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(AboutVersion3MenuItem);

        AboutMenu.add(jMenu1);
        AboutMenu.add(jSeparator5);

        HelpMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/help.png"))); // NOI18N
        HelpMenuItem.setText("مساعدة");
        HelpMenuItem.setText("مساعدة");
        HelpMenuItem.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        HelpMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HelpMenuItemActionPerformed(evt);
            }
        });
        AboutMenu.add(HelpMenuItem);

        AboutMenu.setText("حول");

        MenuBar.add(AboutMenu);

        MenuBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OpenNewTabMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenNewTabMenuItemActionPerformed
JPanel theContentPanel=new PanelWithJTextPane();
if(ChooseWhatTheSheetIs.isNull==true){
return;
}

try{
JPanel TheXPanel=new JPanel();
JLabel ThexLabel=new JLabel();
TheXPanel.setOpaque(false);
Xbutton = new JButton(singleton.getXButtonIcon());
ThexLabel.setText("لسان جديد");
ThexLabel.setIcon(singleton.getTabIcon());
ThexLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
TheXPanel.add(Xbutton, BorderLayout.WEST);
TheXPanel.add(ThexLabel, BorderLayout.EAST);
ChangeTheCloseButtonProperty(Xbutton,theContentPanel);// To add Action Listener for the button
MyTab.addTab("لسان جديد",theContentPanel);
if(MyTab.getTabCount()>1)
{
Xbutton.setVisible(true);
AllFunctions.GetButtonOfFirstTab().setVisible(true);
    }

MyTab.setTabComponentAt(MyTab.getTabCount()-1, TheXPanel);
int TabCount=MyTab.getTabCount();
MyTab.setSelectedIndex(TabCount-1);
SearchforWords.StartSearch(TheCurrentPane);

        }// end try
catch(Exception e){
JOptionPane.showMessageDialog(null,"خطأ في انشاء اللسان , الرجاء المحاولة لاحقا ً !"+e,"رسالة خطأ",JOptionPane.ERROR_MESSAGE);
return;
}//end catch
    }//GEN-LAST:event_OpenNewTabMenuItemActionPerformed

    private void PrintMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintMenuItemActionPerformed
try{
TheCurrentPane.print();
}//end try box
catch(Exception e){
JOptionPane.showMessageDialog(null,"خطأ في عملية الطباعة , الرجاء المحاولة لاحقا ً بعد إصلاح الخلل !", "خطأ", JOptionPane.ERROR_MESSAGE);
return;
}//end catch
    }//GEN-LAST:event_PrintMenuItemActionPerformed

    private void ExitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitMenuItemActionPerformed
System.exit(0);
    }//GEN-LAST:event_ExitMenuItemActionPerformed

    private void SaveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveMenuItemActionPerformed
try{
if(MyTab.getTitleAt(MyTab.getSelectedIndex()).contains("Fast NotePad Help"))
{
JOptionPane.showMessageDialog(null,"لا يمكن التعديل على ملف المساعدة ....", "رسالة تحذير",JOptionPane.WARNING_MESSAGE);
return;
}//end if this is new documents ..

if(MyTab.getTitleAt(MyTab.getSelectedIndex()).contains("لسان جديد"))
{
SaveAsMenuItemActionPerformed(event);
}//end if this is new documents ..
else{ 
        try{ 
       if(TheCurrentPane.getContentType().equals("text/plain")&&selectedFiles.get(MyTab.getSelectedIndex()).toString().toLowerCase().endsWith(".fnp")){
       AllFunctions.SaveContentOfJTextPane(TheCurrentPane, selectedFiles.get(MyTab.getSelectedIndex()));
       }

    // if the user opend an image ..
    else if(selectedFiles.get(MyTab.getSelectedIndex()).toString().toLowerCase().endsWith(".jpg")||
                selectedFiles.get(MyTab.getSelectedIndex()).toString().toLowerCase().endsWith(".gif")||
                selectedFiles.get(MyTab.getSelectedIndex()).toString().toLowerCase().endsWith(".tiff")||
                selectedFiles.get(MyTab.getSelectedIndex()).toString().toLowerCase().endsWith(".tif")||
                selectedFiles.get(MyTab.getSelectedIndex()).toString().toLowerCase().endsWith(".png"))
       {
           JOptionPane.showMessageDialog(null, "هذه صورة مباشرة تم عرضها في هذا المستند , لحفظ التعديلات يُرجى حفظ المستند بصيغة FNP", " معلومات", JOptionPane.INFORMATION_MESSAGE);
           SaveAsMenuItemActionPerformed(event);
           return;
    }//end if this is an Image
       
  // like c , c++ .. etc
  else if(TheCurrentPane.getContentType().equals("text/plain")&&!selectedFiles.get(MyTab.getSelectedIndex()).toString().toLowerCase().endsWith(".fnp")){
       FileWriter writer=new FileWriter(selectedFiles.get(MyTab.getSelectedIndex()));
       writer.write(TheCurrentPane.getText());
       writer.flush();
       writer.close();
 }

  else if(TheCurrentPane.getContentType().equals("text/html")){
       FileWriter writer=new FileWriter(selectedFiles.get(MyTab.getSelectedIndex()));
       writer.write(TheCurrentPane.getText());
       writer.flush();
       writer.close();
 }

     OperationsLabel.setText("تم حفظ : "+selectedFiles.get(MyTab.getSelectedIndex()).toString()+" بنجاح ");
     MyTab.setTitleAt(MyTab.getSelectedIndex(),selectedFiles.get(MyTab.getSelectedIndex()).getName());
     try{// this to change the label of tab components ...
     JPanel panel=(JPanel)MyTab.getTabComponentAt(MyTab.getSelectedIndex());
     JLabel label=(JLabel)panel.getComponent(1);
     MyTab.remove(panel);
     MyTab.remove(label);
     label.setText(selectedFiles.get(MyTab.getSelectedIndex()).getName());
     panel.add(label, BorderLayout.WEST);
     MyTab.setTabComponentAt(MyTab.getSelectedIndex(), panel);
     }
    catch(Exception e){//do nothing
    return;
    }//end catch

        }// end try of saving file
      catch(Exception e)
      {   
         JOptionPane.showMessageDialog(this,"خطأ في حفظ الملف .. الرجاء إعادة المحاولة لاحقا ً !"+e,"رسالة خطأ",JOptionPane.ERROR_MESSAGE);
          return;
      }
}//end big else
        }//end try box
catch(Exception e){
JOptionPane.showMessageDialog(null," خطأ في حفظ الملف .. الرجاء إعادة المحاولة لاحقا ً !"+e, "رسالة خطأ", JOptionPane.ERROR_MESSAGE);
return;
}

UndoAndRedo.setJTextPane(TheCurrentPane);
    }//GEN-LAST:event_SaveMenuItemActionPerformed

    private void SaveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveAsMenuItemActionPerformed
  try{
// These to remove all choosable ..
singleton.getchooserFiles().removeChoosableFileFilter(singleton.getFNPfilesFilterObject());
singleton.getchooserFiles().removeChoosableFileFilter(singleton.getHTMLfilesFilterObject());
singleton.getchooserFiles().removeChoosableFileFilter(singleton.getTXTfilesFilterObject());
singleton.getchooserFiles().removeChoosableFileFilter(singleton.getImagesFileFiltersOject());

      String theNameOfFileWithExtension="null";
      ifFileExist ifExistClass;// Object to check if the file is exist or not !!
 
      if(TheCurrentPane.getContentType().equals("text/plain"))
      {
          singleton.getchooserFiles().addChoosableFileFilter(singleton.getFNPfilesFilterObject());
          singleton.getchooserFiles().setFileFilter(singleton.getFNPfilesFilterObject());
      }//end if
      else if(TheCurrentPane.getContentType().equals("text/html"))
      {
          singleton.getchooserFiles().addChoosableFileFilter(singleton.getHTMLfilesFilterObject());
          singleton.getchooserFiles().setFileFilter(singleton.getHTMLfilesFilterObject());
      }// end if


      singleton.getchooserFiles().setSelectedFile(singleton.getEmptyPath());
      singleton.getchooserFiles().setDialogTitle("حفظ الملف بإسم : ");
      int result=singleton.getchooserFiles().showDialog(TheCurrentPane,"إحفظ");
      File nameOfFile=singleton.getchooserFiles().getSelectedFile();
      
      // if the user choose close the JFileChooser;
      if(result==JFileChooser.CANCEL_OPTION)
      { return;}

      String[] theExtension=nameOfFile.toString().split("\\.");// if there is Extension
      if(singleton.getchooserFiles().getFileFilter().getDescription().equals("*.fnp"))
      if(theExtension.length==1)
      theNameOfFileWithExtension = nameOfFile + ".fnp";
      else
      theNameOfFileWithExtension = theExtension[0] + "." + theExtension[1];

      else if(singleton.getchooserFiles().getFileFilter().getDescription().equals("*.html"))
      if(theExtension.length==1)
      theNameOfFileWithExtension=nameOfFile+".html";
      else
      theNameOfFileWithExtension=theExtension[0]+"."+theExtension[1];

      else if(singleton.getchooserFiles().getFileFilter().getDescription().equals("All Files"))
      {
          try{
      theExtension=nameOfFile.toString().split("\\.");// Just To check if the user enter dot or not !
      theExtension[1].toString();// to make exception and add .fnp to the name
      theNameOfFileWithExtension=nameOfFile.toString();// that will contain extension ..
          }//end try
          catch(Exception e){
          if(TheCurrentPane.getContentType().equals("text/html"))
          theNameOfFileWithExtension=nameOfFile+".html";
          else
          theNameOfFileWithExtension=nameOfFile+".fnp";
          }//end catch
 }//end if selected ALL FILES

      // check the existing file ...
      if(new File(theNameOfFileWithExtension).exists()){
      ifExistClass=new ifFileExist(new JFrame(),true,nameOfFile.toString());
      ifExistClass.setVisible(true);
      if(ifExistClass.noAnswer==true||(ifExistClass.yesAnswer==false&&ifExistClass.noAnswer==false))
      return;
      }// end if exist

       // Save the content of JTextPane to file , and add the path to Linked list
       if(TheCurrentPane.getContentType().equals("text/plain")&&theNameOfFileWithExtension.endsWith(".fnp")){
           AllFunctions.SaveContentOfJTextPane(TheCurrentPane, theNameOfFileWithExtension);
           selectedFiles.set(MyTab.getSelectedIndex(),new File(theNameOfFileWithExtension));
       }
  // like c , c++ .. etc
  else if(TheCurrentPane.getContentType().equals("text/plain")&&!theNameOfFileWithExtension.endsWith(".fnp")){
        ChooseEncoding ChooseEncodingObject=new ChooseEncoding(new JFrame(),true);
        ChooseEncodingObject.setVisible(true);
        // if close the dialog
        if(ChooseEncodingObject.isNull==true){
        return;
        }// if the user clicked close ..

      if(ChooseEncodingObject.isDefault)  {
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(theNameOfFileWithExtension),"utf-8"));
      bw.write(TheCurrentPane.getText(), 0, TheCurrentPane.getText().length());
      bw.close();
      selectedFiles.set(MyTab.getSelectedIndex(),new File(theNameOfFileWithExtension));
           }// end if he choose UTF

      else if (ChooseEncodingObject.isANSI)  {
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(theNameOfFileWithExtension),"cp1256"));
      bw.write(TheCurrentPane.getText(), 0, TheCurrentPane.getText().length());
      bw.close();
      selectedFiles.set(MyTab.getSelectedIndex(),new File(theNameOfFileWithExtension));
           }// end if he choose ANSI

      else if (ChooseEncodingObject.isUNICODE)  {
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(theNameOfFileWithExtension),"unicode"));
      bw.write(TheCurrentPane.getText(), 0, TheCurrentPane.getText().length());
      bw.close();
      selectedFiles.set(MyTab.getSelectedIndex(),new File(theNameOfFileWithExtension));
           }// end if he choose ANSI

 }

  else if(TheCurrentPane.getContentType().equals("text/html")){
        ChooseEncoding ChooseEncodingObject=new ChooseEncoding(new JFrame(),true);
        ChooseEncodingObject.setVisible(true);
        // if close the dialog
        if(ChooseEncodingObject.isNull==true){
        return;
        }// if the user clicked close ..

       if(ChooseEncodingObject.isDefault)  {
       Writer write=new OutputStreamWriter(new FileOutputStream(theNameOfFileWithExtension),"UTF-8");
       write.write(TheCurrentPane.getText());
       write.flush();
       write.close();
       }//end if is utf-8

       else if (ChooseEncodingObject.isANSI)  {
       Writer write=new OutputStreamWriter(new FileOutputStream(theNameOfFileWithExtension),"cp1256");
       write.write(TheCurrentPane.getText());
       write.flush();
       write.close();
        }// end if ANSI

       else if (ChooseEncodingObject.isUNICODE)  {
       Writer write=new OutputStreamWriter(new FileOutputStream(theNameOfFileWithExtension),"Unicode");
       write.write(TheCurrentPane.getText());
       write.flush();
       write.close();
        }// end if ANSI

       selectedFiles.set(MyTab.getSelectedIndex(),new File(theNameOfFileWithExtension));
 }
     OperationsLabel.setText("تم حفظ : "+theNameOfFileWithExtension+" بنجاح ");
     MyTab.setTitleAt(MyTab.getSelectedIndex(),nameOfFile.getName());// for first PaintMainPanel

     try{// to change the name of label in tab component ...
     JPanel panel=(JPanel)MyTab.getTabComponentAt(MyTab.getSelectedIndex());
     JLabel label=(JLabel)panel.getComponent(1);
     MyTab.remove(panel);
     MyTab.remove(label);
     label.setText(nameOfFile.getName());
     panel.add(label, BorderLayout.WEST);
     MyTab.setTabComponentAt(MyTab.getSelectedIndex(), panel);
     }
catch(Exception e){
return;
}//do nothing if there can't reName for tab ...

      }//end try
     
     catch(Exception e)
  {      
          JOptionPane.showMessageDialog(null," خطأ في حفظ الملف .. الرجاء إعادة المحاولة لاحقا ً !"+e,"رسالة خطأ",JOptionPane.ERROR_MESSAGE);
          return;
      }// end catch ...

  UndoAndRedo.setJTextPane(TheCurrentPane);
    }//GEN-LAST:event_SaveAsMenuItemActionPerformed

    private void OpenFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenFileMenuItemActionPerformed
  try {
    singleton.getchooserFiles().addChoosableFileFilter(singleton.getFNPfilesFilterObject());    
    singleton.getchooserFiles().addChoosableFileFilter(singleton.getHTMLfilesFilterObject());
    singleton.getchooserFiles().addChoosableFileFilter(singleton.getTXTfilesFilterObject());
    singleton.getchooserFiles().addChoosableFileFilter(singleton.getImagesFileFiltersOject());
    singleton.getchooserFiles().setFileView(singleton.getALLfilesViewObject());
    singleton.getchooserFiles().setDialogTitle("إختر ملف :");
    singleton.getchooserFiles().setSelectedFile(singleton.getEmptyPath());

    int status = singleton.getchooserFiles().showOpenDialog(this);
    // if the user choose cancel
    if(status==JFileChooser.CANCEL_OPTION)
    return;
    
    OpendFileToLinkedList = singleton.getchooserFiles().getSelectedFile();// add the selected file from file chooser
    
    String[] getExtentionOfFile=OpendFileToLinkedList.getName().split("\\.");
    if(getExtentionOfFile[1].equalsIgnoreCase("fnp"))
    OpentFNPFiles(OpendFileToLinkedList);

    else if(getExtentionOfFile[1].equalsIgnoreCase("html"))
    OpenHTMLFiles(OpendFileToLinkedList);

     else if(getExtentionOfFile[1].equalsIgnoreCase("jpg")||
                getExtentionOfFile[1].equalsIgnoreCase("gif")||
                getExtentionOfFile[1].equalsIgnoreCase("tiff")||
                getExtentionOfFile[1].equalsIgnoreCase("tif")||
                getExtentionOfFile[1].equalsIgnoreCase("png"))
   OpenImageFiles(OpendFileToLinkedList);
   
    else
    {
      OpenOtherFilesFile(OpendFileToLinkedList);
    }//end else if not txt or fnp

      }
     catch (Exception e) {
      JOptionPane.showMessageDialog(null,"خطأ في عملية فتح الملف , الرجاء التأكد من صيغة الملف ثم المحاولة مرة اخرى !"+e, "رسالة خطأ",JOptionPane.ERROR_MESSAGE);
      return;
    }

    }//GEN-LAST:event_OpenFileMenuItemActionPerformed

    private void AddPicMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddPicMenuItemActionPerformed

     try{
    
    singleton.getchooserImages().addChoosableFileFilter(singleton.getImagesFileFiltersOject());
    singleton.getchooserImages().setFileFilter(singleton.getImagesFileFiltersOject());
    singleton.getchooserImages().setAccessory(singleton.getImagePreviewObject());
    singleton.getchooserImages().setFileView(singleton.getImageFileViewObject());

    singleton.getchooserFiles().setDialogTitle("إختر صورة :");
    int status = singleton.getchooserImages().showOpenDialog(this);

    if(status==JFileChooser.CANCEL_OPTION)
    return;

    else if(status == JFileChooser.APPROVE_OPTION)
         {
    File ImageFile = singleton.getchooserImages().getSelectedFile();
    Icon icon= new MyImageIcon(ImageFile.getAbsolutePath());
    TheCurrentPane.insertIcon(icon);
         }// end if !

        }// end try box
     catch(Exception e)
     {
         JOptionPane.showMessageDialog(null,"خطأ في عملية إضافة الصورة .. الرجاء المحاولة لاحقا ً !"+e, "رسالة خطأ",JOptionPane.ERROR_MESSAGE);
         return;
        }
    }//GEN-LAST:event_AddPicMenuItemActionPerformed

    private void AddpicFromNetMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddpicFromNetMenuItemActionPerformed

String theURL=null;
String http="http://";
try{
theURL=JOptionPane.showInputDialog(null,"أدخل الرابط المباشر للصورة : ","رابط الصورة",JOptionPane.INFORMATION_MESSAGE).toLowerCase();
if(!theURL.contains(http))
theURL=http+theURL;
if(theURL.equals(nullValue)||theURL.equals(empty))
{
    JOptionPane.showMessageDialog(null, "الرجاء إدخال رابط !!", "تحذير", JOptionPane.WARNING_MESSAGE);
    return;
        }
if(theURL.toLowerCase().endsWith(".jpg")||theURL.toLowerCase().endsWith(".png")||theURL.toLowerCase().endsWith(".gif")||
        theURL.toLowerCase().endsWith(".jpeg")||theURL.toLowerCase().endsWith(".tif")||
        theURL.toLowerCase().endsWith(".tiff"))
try{
URL e=new URL(theURL);
AllFunctions.AddImage(e,TheCurrentPane);
}
catch(Exception e){
OperationsLabel.setText("فشل تحميل الصورة !");
return;
}
else
{
 JOptionPane.showMessageDialog(null,"الرجاء إدخال رابط مباشر للصورة , بحيث يحتوي على الصيغ التي يقبلها البرنامج !", "رسالة خطأ",JOptionPane.ERROR_MESSAGE);
 return;
}
   }// end big try
catch(Exception e){
  return;}
    }//GEN-LAST:event_AddpicFromNetMenuItemActionPerformed

    private void SearchMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchMenuItemActionPerformed
        SearchforWords.setVisible(true);
        SearchforWords.getSearchField().requestFocusInWindow();
}//GEN-LAST:event_SearchMenuItemActionPerformed

    private void HTMLPasteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HTMLPasteMenuItemActionPerformed
try{
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        final Transferable contents = clipboard.getContents(null);
        DataFlavor[] s=contents.getTransferDataFlavors();
        final DataFlavor data= DataFlavor.selectBestTextFlavor(s);
        
        Reader reader;
        try{               
            reader=data.getReaderForText(contents);
            ReaderToInputStream o=new ReaderToInputStream(reader);
            // This Copied text ..
            String mydata=AllFunctions.convertStreamToString(o);

            int start=mydata.indexOf("<body");
            int End=mydata.indexOf("</body>");
            // if there is body tags in the text .......
            if(start!=-1||End!=-1)
            {
            String newString = mydata.substring(start, End + 7);           
            String thefinalString =newString.replaceAll("<o:p></o:p>","");
            start=TheCurrentPane.getText().indexOf("<body");
            End=TheCurrentPane.getText().indexOf("</body>");
            if(start!=-1||End!=-1)
            {
            newString = TheCurrentPane.getText().substring(start + 6, End - 4);//
            try{
             
             TheCurrentPane.setText(newString+"\n"+thefinalString);
             // Now to remove fucking blocks !
             String allTextwithBlocks=TheCurrentPane.getText();
             allTextwithBlocks =allTextwithBlocks.replaceAll("&#65533","&#160");// to hide some blocks .4.
             TheCurrentPane.setText(allTextwithBlocks);
                }//end try if there unclosed blocks
            catch(java.lang.RuntimeException e){
JOptionPane.showMessageDialog(null,"يوجد بعض blocks لم يتم اغلاقها بشكل جيد في النصوص البرمجية , الرجاء مراجعتها .", "رسالة خطأ",JOptionPane.ERROR_MESSAGE);
return;
}//end catch
              }
                   
}// end if there is body tag in the all text
 else{

            String thefinalString =mydata.replaceAll("<o:p></o:p>","");
            start=TheCurrentPane.getText().indexOf("<body");
            End=TheCurrentPane.getText().indexOf("</body>");
            if(start!=-1||End!=-1)
            {
            String newString = TheCurrentPane.getText().substring(start + 6, End - 4);//
            try{
            TheCurrentPane.setText(newString+"\n"+thefinalString);
            // Now to remove fucking blocks !
             String allTextwithBlocks=TheCurrentPane.getText();
             allTextwithBlocks =allTextwithBlocks.replaceAll("&#65533","&#160");// to hide some blocks .4.
             allTextwithBlocks =allTextwithBlocks.replaceAll("<o p=\"#DEFAULT\">","");// to hide some blocks .4.
             allTextwithBlocks =allTextwithBlocks.replaceAll("&#160;</o>","");// to hide some blocks .4.
             TheCurrentPane.setText(allTextwithBlocks);
                }//end try if there is unclosed blocks ..
            catch(java.lang.RuntimeException e){
JOptionPane.showMessageDialog(null,"يوجد بعض blocks لم يتم اغلاقها بشكل جيد في النصوص البرمجية , الرجاء مراجعتها .", "رسالة خطأ",JOptionPane.ERROR_MESSAGE);
return;
}//end catch
             }//end if there is body tag
            else
            {
            String newString = TheCurrentPane.getText().substring(start + 6, End - 4);
            try{
            TheCurrentPane.setText(newString+"\n"+thefinalString);
            // Now to remove fucking blocks !
             String allTextwithBlocks=TheCurrentPane.getText();
             allTextwithBlocks =allTextwithBlocks.replaceAll("&#65533","&#160");// to hide some blocks .4.
             allTextwithBlocks =allTextwithBlocks.replaceAll("<o p=\"#DEFAULT\">","");// to hide some blocks .4.
             allTextwithBlocks =allTextwithBlocks.replaceAll("&#160;</o>","");// to hide some blocks .4.
             TheCurrentPane.setText(allTextwithBlocks);
            }//en if there is unclosed blocks
            catch(java.lang.RuntimeException e){
            JOptionPane.showMessageDialog(null,"يوجد بعض blocks لم يتم اغلاقها بشكل جيد في النصوص البرمجية , الرجاء مراجعتها .", "رسالة خطأ",JOptionPane.ERROR_MESSAGE);
            return;
            }//end catch
            }//end else there is no body
                
}//end else there is not body tag in the text , but there is <p> tag ...
               
  
        }// end big try
catch(Exception e){
Action pastOnly=new StyledEditorKit.PasteAction();
pastOnly.actionPerformed(event);
return;
      }// end catch box
        

}//end big try
catch(Exception e){// do nothing
Action pastOnly=new StyledEditorKit.PasteAction();
pastOnly.actionPerformed(event);
    return;      
}// end catch

    }//GEN-LAST:event_HTMLPasteMenuItemActionPerformed

    private void CopyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopyMenuItemActionPerformed
  Action e=new StyledEditorKit.CopyAction();
  e.actionPerformed(event);
}//GEN-LAST:event_CopyMenuItemActionPerformed

    private void CutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CutMenuItemActionPerformed
        Action fontAction = new StyledEditorKit.CutAction();
        fontAction.actionPerformed(null);
}//GEN-LAST:event_CutMenuItemActionPerformed

    private void RedoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RedoMenuItemActionPerformed
        UndoAndRedo.getRedoButton().doClick();        
}//GEN-LAST:event_RedoMenuItemActionPerformed

    private void UndoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UndoMenuItemActionPerformed
        UndoAndRedo.getUndoButton().doClick();       
}//GEN-LAST:event_UndoMenuItemActionPerformed

    private void AddURLMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddURLMenuItemActionPerformed
String theURL;
try{
theURL=JOptionPane.showInputDialog(null,"الرجاء إدخال الرابط الإلكتروني :","إدخال رابط",JOptionPane.INFORMATION_MESSAGE);
theURL=theURL.replaceAll("http://","");

if(theURL.equals(nullValue)||theURL.equals(empty))
{
    JOptionPane.showMessageDialog(null, "الرجاء إدخال رابط !!", "تحذير", JOptionPane.WARNING_MESSAGE);
    return;
        }
 
 else
     try{
           int start=TheCurrentPane.getText().indexOf("<body");// this to get Previous Text and save it !
           int End=TheCurrentPane.getText().indexOf("</body>");
            if(start!=-1||End!=-1)
            {
            String newString = TheCurrentPane.getText().substring(start + 6, End - 4);//
            String theString=JOptionPane.showInputDialog(null,"هل تريد إدخال وصف للرابط ؟","ادخال وصف للرابط :",JOptionPane.INFORMATION_MESSAGE);
            if(theString.equals(nullValue)||theString.equals(empty))
            TheCurrentPane.setText(newString+"\n"+"<a href='http://"+theURL+"'>"+theURL+"</a>");
            else
            TheCurrentPane.setText(newString+"\n"+"<a href='http://"+theURL+"'>"+theString+"</a>");
            }
    }
     catch(Exception e){
    // do nothing
    return;
     }
}//end big try
catch(Exception e){
    return;}
    }//GEN-LAST:event_AddURLMenuItemActionPerformed

    private void MyTabStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_MyTabStateChanged
try{
        TheCurrentPane=AllFunctions.getCurrentJTextPane(MyTab);
        SearchforWords.StartSearch(TheCurrentPane);
        setKeyReleasedListener(TheCurrentPane);
        setMouseReleasedAndPressed(TheCurrentPane);
        setMouseClickListener(TheCurrentPane);
        RightToLeftOrientation.setJTextPane(TheCurrentPane);
        LeftToRightOrientation.setJTextPane(TheCurrentPane);
      //************************************************************************
      KeyStroke CtrlVStrok= KeyStroke.getKeyStroke("ctrl V");
      KeyStroke OrientationStrok= KeyStroke.getKeyStroke("ctrl released SHIFT");
      Action CtrlVAction = new PastKeyStrokeClass();
      Action OrientationAction = new setComponentOrientation();      
      InputMap inputMap = TheCurrentPane.getInputMap();
      inputMap.put(CtrlVStrok, "the Ctrl+ V action");
      inputMap.put(OrientationStrok, "the Orientation action");
      ActionMap actionMap = TheCurrentPane.getActionMap();
      actionMap.put("the Ctrl+ V action", CtrlVAction);
      actionMap.put("the Orientation action", OrientationAction);
      //************************************************************************
     
        if(TheCurrentPane.getContentType().equals("text/html"))
        {
            AddURLMenuItem.setEnabled(true);
            singleton.getViewHTMLCodeMenuItem().setEnabled(true);
            HTMLPasteMenuItem.setEnabled(true);
            singleton.getHTMLPastePopMenu().setEnabled(true);
            DefaultPastMenuItem.setEnabled(false);
            singleton.getDefaultPastePopMenu().setEnabled(false);
            AddpicFromNetMenuItem.setEnabled(false);
            AddPicMenuItem.setEnabled(false);
            ReplaceTextMenuItem.setEnabled(false);

        }// end if its HTML
        else{
        AddURLMenuItem.setEnabled(false);
        singleton.getViewHTMLCodeMenuItem().setEnabled(false);
        DefaultPastMenuItem.setEnabled(true);
        singleton.getDefaultPastePopMenu().setEnabled(true);
        HTMLPasteMenuItem.setEnabled(false);
        singleton.getHTMLPastePopMenu().setEnabled(false);
        AddpicFromNetMenuItem.setEnabled(true);
        AddPicMenuItem.setEnabled(true);
        ReplaceTextMenuItem.setEnabled(true);
        }// end else if its plain text ..

// get Lines and characters
linesAndColLabel.setText(" أحرف : "+TheCurrentPane.getText().length()+"/ أسطر : "+TheCurrentPane.getText().split("\n").length);

UndoAndRedo.setJTextPane(TheCurrentPane);
contentLabel.setText("نوع المستند : "+TheCurrentPane.getContentType());
TheCurrentPane.requestFocusInWindow();
        }//end try box
catch(Exception e){
return;
}
    }//GEN-LAST:event_MyTabStateChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

for(int x=0;x<MyTab.getTabCount();x++)
{
String theTitle=MyTab.getTitleAt(x);
if(theTitle.contains("*"))
{

singleton.getInWindowsCloseObject().setVisible(true);
if(singleton.getInWindowsCloseObject().noAnswer==true||(singleton.getInWindowsCloseObject().noAnswer==false&&singleton.getInWindowsCloseObject().yesAnswer==false))
return;
else
System.exit(0);
}//end if contain *
}//end for loop
// no contain *
System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void AddShapeAndSymbolsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddShapeAndSymbolsActionPerformed
if(ShapesAndSymbolsObject==null){
ShapesAndSymbolsObject=new ShapesAndSymbols();
ShapesAndSymbolsObject.setVisible(true);
ShapesAndSymbolsObject.ReadShapesAndSymbols();
}
 else{
ShapesAndSymbolsObject.setVisible(true);
ShapesAndSymbolsObject.ReadShapesAndSymbols();
 }

    }//GEN-LAST:event_AddShapeAndSymbolsActionPerformed

    private void DefaultPastMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DefaultPastMenuItemActionPerformed
        // This to Check if this is image ..
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = clipboard.getContents(null);
        // to copy images ..
        if(contents.isDataFlavorSupported(DataFlavor.imageFlavor))
        {
            try{
        
        BufferedImage theImage=(BufferedImage)contents.getTransferData(DataFlavor.imageFlavor);
        if(new Color(theImage.getRGB(0,0)).equals(Color.black))
        TheCurrentPane.insertIcon(new MyImageIcon(AllFunctions.makeColorTransparent(theImage,Color.black)));
        else
        TheCurrentPane.insertIcon(new MyImageIcon(theImage));
            }//end try
         catch(Exception e){
         JOptionPane.showMessageDialog(null,"خطأ في عملية نسخ الصورة ولصقها في المستند , يمكنك تحميل الصورة من خلال البرنامج بالضغط على : \n إدارج -> إدراج صورة من الإنترنت .");
         return;
         }
        }

// check the text ..
Action pastOnly=new StyledEditorKit.PasteAction();
pastOnly.actionPerformed(event);
    }//GEN-LAST:event_DefaultPastMenuItemActionPerformed

    private void FontPlusPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FontPlusPlusActionPerformed
AttributeSet attrs=((StyledEditorKit)TheCurrentPane.getEditorKit()).getInputAttributes();
// to get size
int size=StyleConstants.getFontSize(attrs);
size=size+1;
Action fontAction = new StyledEditorKit.FontSizeAction("size",size);
fontAction.actionPerformed(null);
    }//GEN-LAST:event_FontPlusPlusActionPerformed

    private void FontMinMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FontMinMinActionPerformed
AttributeSet attrs=((StyledEditorKit)TheCurrentPane.getEditorKit()).getInputAttributes();
// to get size
int size=StyleConstants.getFontSize(attrs);
size=size-1;
Action fontAction = new StyledEditorKit.FontSizeAction("size",size);
fontAction.actionPerformed(null);
    }//GEN-LAST:event_FontMinMinActionPerformed

    private void HelpMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HelpMenuItemActionPerformed
  ReadHelpFile();
    }//GEN-LAST:event_HelpMenuItemActionPerformed

    private void ReplaceTextMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReplaceTextMenuItemActionPerformed

if(ReplaceTextGlobalObject==null){
ReplaceTextGlobalObject=new ReplaceTextGlobal();
ReplaceTextGlobalObject.setJTextPane(TheCurrentPane);
ReplaceTextGlobalObject.setVisible(true);
}
 else
{
ReplaceTextGlobalObject.setJTextPane(TheCurrentPane);
ReplaceTextGlobalObject.setVisible(true);
 }
    }//GEN-LAST:event_ReplaceTextMenuItemActionPerformed

    private void AboutVersion2MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutVersion2MenuItemActionPerformed
      if(AboutVersion2Object==null){
        AboutVersion2Object=new AboutVersion2();
        AboutVersion2Object.ShowWindow();
        }
 else{
 AboutVersion2Object.ShowWindow();
 }
}//GEN-LAST:event_AboutVersion2MenuItemActionPerformed

    private void AboutProgrammerMenuItemActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutProgrammerMenuItemActionPerformed1
        // Using Proxy design pattern ..
        if(AboutMeObject==null){
        AboutMeObject=new AboutMe();
        AboutMeObject.ShowWindow();
        }
 else
 {
 AboutMeObject.ShowWindow();
 }//end else the object not null
}//GEN-LAST:event_AboutProgrammerMenuItemActionPerformed1

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
// I'm using this object, don't change the static ALPHA !
 if(ChooseTextColor.ObjectOfColorChooser!=null&&ChooseTextColor.ObjectOfColorChooser.isVisible())
ChooseTextColor.ObjectOfColorChooser.HideWindow();

 if(ChooseBGColor.ObjectOfColorChooser!=null&&ChooseBGColor.ObjectOfColorChooser.isVisible())
 ChooseBGColor.ObjectOfColorChooser.HideWindow();
    }//GEN-LAST:event_formMouseClicked

    private void MyTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MyTabMouseClicked
// I'm using this object, don't change the static ALPHA !
 if(ChooseTextColor.ObjectOfColorChooser!=null&&ChooseTextColor.ObjectOfColorChooser.isVisible())
ChooseTextColor.ObjectOfColorChooser.HideWindow();

 if(ChooseBGColor.ObjectOfColorChooser!=null&&ChooseBGColor.ObjectOfColorChooser.isVisible())
 ChooseBGColor.ObjectOfColorChooser.HideWindow();
      
    }//GEN-LAST:event_MyTabMouseClicked

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
MainPanel.resize(new Dimension(getWidth(),getHeight()));
PaintMainPanel.mywidth=getWidth();
PaintMainPanel.myheight=getHeight();
MainPanel.repaint();
    }//GEN-LAST:event_formComponentResized

    private void ConfigTheProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfigTheProgramActionPerformed
        if(ConfigTheProgramObject==null){
         ConfigTheProgramObject=new ConfigTheProgram();
         ConfigTheProgramObject.setVisible(true);
        }
 else
        {
 ConfigTheProgramObject.setVisible(true);
 }
    }//GEN-LAST:event_ConfigTheProgramActionPerformed

    private void AboutVersion3MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutVersion3MenuItemActionPerformed
      if(AboutVersion3Object==null){
        AboutVersion3Object=new AboutVersion3();
        AboutVersion3Object.ShowWindow();
        }
 else{
 AboutVersion3Object.ShowWindow();
 }
    }//GEN-LAST:event_AboutVersion3MenuItemActionPerformed

    private void EditMenuMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_EditMenuMenuSelected
// this if the user make changes in the document and don't click andy button ..
// when click on tahrer it will check =)
UndoMenuItem.setEnabled(UndoAndRedo.getUndoButton().isEnabled());// Set Enabled for Undo Menu Item
RedoMenuItem.setEnabled(UndoAndRedo.getRedoButton().isEnabled());// Set Enabled for Redo Menu Item
    }//GEN-LAST:event_EditMenuMenuSelected

  //****************************************************************************
  public void OpentFNPFiles(final File theFile){      
   String typeoffile=String.valueOf(new MimetypesFileTypeMap().getContentType(theFile));
   setState (JFrame.NORMAL );
   toFront();


    if(!typeoffile.equals(singleton.getMaintype()))
    {JOptionPane.showMessageDialog(null,"خطأ في صيغة الملف !!");
    return;
    }
    try{
    new SwingWorker() {
    protected Void doInBackground() {
   // to Open new Tab if its not new !!
    if(!MyTab.getTitleAt(MyTab.getSelectedIndex()).equals("لسان جديد")||!TheCurrentPane.getContentType().equals("text/plain"))
    {
// This to add tab with the X button
try{// to add X image in the PaintMainPanel then add them to tab !!
JPanel TheXPanel=new JPanel();
JLabel ThexLabel=new JLabel();
TheXPanel.setOpaque(false);
Xbutton = new JButton(singleton.getXButtonIcon());
ThexLabel.setText("لسان جديد");
ThexLabel.setIcon(singleton.getTabIcon());
ThexLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
TheXPanel.add(Xbutton, BorderLayout.WEST);
TheXPanel.add(ThexLabel, BorderLayout.EAST);
JPanel theContentPanel=new PanelWithJTextPane(false,true);
ChangeTheCloseButtonProperty(Xbutton,theContentPanel);// To add Action Listener for the button
FastNotepadFrame.MyTab.addTab("لسان جديد",theContentPanel);
if(!Xbutton.isVisible()&&MyTab.getTabCount()>1)
{
Xbutton.setVisible(true);
AllFunctions.GetButtonOfFirstTab().setVisible(true);
    }
MyTab.setTabComponentAt(MyTab.getTabCount()-1, TheXPanel);
int TabCount=MyTab.getTabCount();
MyTab.setSelectedIndex(TabCount-1);

        }// end try
catch(Exception e){
JOptionPane.showMessageDialog(null,"خطأ في انشاء اللسان , الرجاء المحاولة لاحقا ً !","رسالة خطأ",JOptionPane.ERROR_MESSAGE);
return null;
}//end catch
}//end if the name of tab is new tab !

  // to read the file !!
     final String[] JustFileName=theFile.getName().split("\\.");
      try{
     JPanel panel=(JPanel)MyTab.getTabComponentAt(MyTab.getSelectedIndex());
     JLabel label=(JLabel)panel.getComponent(1);
     MyTab.remove(panel);
     MyTab.remove(label);
     nameOfLabelWhenReadingFile=JustFileName[0];
     label.setText(JustFileName[0]);
     panel.add(label, BorderLayout.WEST);
     MyTab.setTabComponentAt(MyTab.getSelectedIndex(), panel);
     }
    catch(Exception e){
    return null;
    }//do nothing
selectedFiles.set(MyTab.getSelectedIndex(),theFile);
MyTab.setTitleAt(MyTab.getSelectedIndex(),nameOfLabelWhenReadingFile);
singleton.getReadingFileObject().setVisible(true);
return null;
  }
         
  @Override
      public void done(){
      synchronized(ob){
      try{
     AllFunctions.ReadFromFileToJTextPane(TheCurrentPane, theFile);    
      }//end try
catch(Exception e){
     JOptionPane.showMessageDialog(null,"خطأ في فتح الملف , الرجاءالتأكد من صيغة الملف ان كان يدعمها البرنامج او لا !"+e,"معلومات",JOptionPane.INFORMATION_MESSAGE);
     return;
}//end catch
 }//end synchronize ..
 }// end done function
         }.execute();
OperationsLabel.setText("تم فتح الملف : "+theFile+" بنجاح ");

    }//end try
     catch(Exception e){
     JOptionPane.showMessageDialog(null,"خطأ في فتح الملف , الرجاءالتأكد من صيغة الملف ان كان يدعمها البرنامج او لا !"+e,"معلومات",JOptionPane.INFORMATION_MESSAGE);
     return;}
     contentLabel.setText("نوع المستند : "+TheCurrentPane.getContentType());

    }//end Method
  //****************************************************************************
  private  void ReadHelpFile(){
        
 try{
    new SwingWorker() {
    protected Void doInBackground() {
   // to Open new Tab if its not new !!
    if(!MyTab.getTitleAt(MyTab.getSelectedIndex()).equals("لسان جديد")||!TheCurrentPane.getContentType().equals("text/plain"))
    {   // This to add tab with the X button
try{// to add X image in the PaintMainPanel then add them to tab !!
JPanel TheXPanel=new JPanel();
JLabel ThexLabel=new JLabel();
TheXPanel.setOpaque(false);
Xbutton = new JButton(singleton.getXButtonIcon());
ThexLabel.setText("لسان جديد");
ThexLabel.setIcon(singleton.getTabIcon());
ThexLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
TheXPanel.add(Xbutton, BorderLayout.WEST);
TheXPanel.add(ThexLabel, BorderLayout.EAST);
JPanel theContentPanel=new PanelWithJTextPane(false,true);
ChangeTheCloseButtonProperty(Xbutton,theContentPanel);// To add Action Listener for the button
FastNotepadFrame.MyTab.addTab("لسان جديد",theContentPanel);
if(!Xbutton.isVisible()&&MyTab.getTabCount()>1)
{
Xbutton.setVisible(true);
AllFunctions.GetButtonOfFirstTab().setVisible(true);
    }
MyTab.setTabComponentAt(MyTab.getTabCount()-1, TheXPanel);
int TabCount=MyTab.getTabCount();
MyTab.setSelectedIndex(TabCount-1);

        }// end try
catch(Exception e){
JOptionPane.showMessageDialog(null,"خطأ في انشاء اللسان , الرجاء المحاولة لاحقا ً !","رسالة خطأ",JOptionPane.ERROR_MESSAGE);
return null;
}//end catch
}//end if the name of tab is new tab !
 // to read the file !!

      try{
     JPanel panel=(JPanel)MyTab.getTabComponentAt(MyTab.getSelectedIndex());
     JLabel label=(JLabel)panel.getComponent(1);
     MyTab.remove(panel);
     MyTab.remove(label);
     label.setText("Fast NotePad Help");
     panel.add(label, BorderLayout.WEST);
     MyTab.setTabComponentAt(MyTab.getSelectedIndex(), panel);
     }
    catch(Exception e){
    return null;
    }//do nothing
     MyTab.setTitleAt(MyTab.getSelectedIndex(),"Fast NotePad Help");
     singleton.getReadingFileObject().setVisible(true);
     return null;
  }// end do in background


  @Override
      public void done(){       
      synchronized(ob){
      try{
      AllFunctions.ReadFromFileToJTextPane(TheCurrentPane,getClass().getResourceAsStream("/Files/Fast NotePad Help.fnp"));
      }//end try
     catch(Exception e){
     JOptionPane.showMessageDialog(null,"خطأ في فتح الملف , الرجاءالتأكد من صيغة الملف ان كان يدعمها البرنامج او لا !"+e,"معلومات",JOptionPane.INFORMATION_MESSAGE);
     return;
}//end catch
 }//end synchronize ..

 }}.execute();
 OperationsLabel.setText("تم فتح ملف المساعدة بنجاح ...");
    }//end try
     catch(Exception e){
     JOptionPane.showMessageDialog(null,"خطأ في فتح الملف , الرجاءالتأكد من صيغة الملف ان كان يدعمها البرنامج او لا !"+e,"معلومات",JOptionPane.INFORMATION_MESSAGE);
     return;}
     contentLabel.setText("نوع المستند : "+TheCurrentPane.getContentType());

  }//end function
  //****************************************************************************
  public void OpenOtherFilesFile(final File theFile){
  try{
   setState (JFrame.NORMAL );
   toFront();

// To prevent Freezing ..
SwingUtilities.invokeLater(new Runnable(){public void run(){
if(!MyTab.getTitleAt(MyTab.getSelectedIndex()).equals("لسان جديد"))
{
try{// to add new PaintMainPanel with X buttom ..
JPanel TheXPanel=new JPanel();
JLabel ThexLabel=new JLabel();
TheXPanel.setOpaque(false);
Xbutton = new JButton(singleton.getXButtonIcon());
ThexLabel.setText("لسان جديد");
ThexLabel.setIcon(singleton.getTabIcon());
ThexLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
TheXPanel.add(Xbutton, BorderLayout.WEST);
TheXPanel.add(ThexLabel, BorderLayout.EAST);
JPanel theContentPanel=new PanelWithJTextPane(false,true);
ChangeTheCloseButtonProperty(Xbutton,theContentPanel);// To add Action Listener for the button
FastNotepadFrame.MyTab.addTab("لسان جديد",theContentPanel);

if(!Xbutton.isVisible()&&MyTab.getTabCount()>1)
{
Xbutton.setVisible(true);
AllFunctions.GetButtonOfFirstTab().setVisible(true);
    }
MyTab.setTabComponentAt(MyTab.getTabCount()-1, TheXPanel);
int TabCount=MyTab.getTabCount();
MyTab.setSelectedIndex(TabCount-1);
        }// end try
catch(Exception e){
JOptionPane.showMessageDialog(null,"خطأ في انشاء اللسان , الرجاء المحاولة لاحقا ً !"+e,"رسالة خطأ",JOptionPane.ERROR_MESSAGE);
return;
}//end catch
      }//end if

        try{
        singleton.getReadingFileObject().setVisible(true);// To view Reading Screen ..
        StyledDocument doc=new DefaultStyledDocument();
        TheCurrentPane.setStyledDocument (doc);

        // This to get Encoding
        CharsetDetector cd = new CharsetDetector();
        Charset charset = cd.detectCharset(theFile,singleton.getCharsetsToBeTested());
        if (charset != null) {
        Reader fin = new InputStreamReader(new FileInputStream(theFile),charset);
        BufferedReader br = new BufferedReader(fin);
        char buffer[] = new char[1000];
        int len;
        while ((len = br.read (buffer, 0, buffer.length)) != -1) {
        doc.insertString(doc.getLength(),new String (buffer, 0, len), null);}// end while

        selectedFiles.set(MyTab.getSelectedIndex(),theFile);
        fin.close();
        br.close();
       
 }// end if

        else{
        Reader fin = new InputStreamReader(new FileInputStream(theFile),"cp1256");
        BufferedReader br = new BufferedReader(fin);
        char buffer[] = new char[1000];
        int len;
        while ((len = br.read (buffer, 0, buffer.length)) != -1) {
        // Insert into pane
        doc.insertString(doc.getLength(),new String (buffer, 0, len), null);}// end while

        selectedFiles.set(MyTab.getSelectedIndex(),theFile);
        fin.close();
        br.close();
        }//end else

     singleton.getReadingFileObject().setVisible(false);// to hide the reading screen .
     }//end try
        catch(Exception e){
        JOptionPane.showMessageDialog(null,"خطأ في عملية فتح الملف , الرجاء التأكد من صيغة الملف ثم المحاولة مرة اخرى !"+e, "رسالة خطأ",JOptionPane.ERROR_MESSAGE);
        return;
        }//end catch

        UndoAndRedo.setJTextPane(TheCurrentPane);
        linesAndColLabel.setText(" أحرف : "+TheCurrentPane.getText().length()+"/ أسطر : "+TheCurrentPane.getText().split("\n").length);

             // to set Title ..
     MyTab.setTitleAt(MyTab.getSelectedIndex(),theFile.getName());
     try{
     JPanel panel=(JPanel)MyTab.getTabComponentAt(MyTab.getSelectedIndex());
     JLabel label=(JLabel)panel.getComponent(1);
     MyTab.remove(panel);
     MyTab.remove(label);
     label.setText(theFile.getName());
     panel.add(label, BorderLayout.WEST);
     MyTab.setTabComponentAt(MyTab.getSelectedIndex(), panel);
     }// end try
    catch(Exception e){
        return;}//do nothing

  }}); // end Invoke Later
  }//end try
  catch(Exception e)
  {
 JOptionPane.showMessageDialog(null,"خطأ في عملية فتح الملف , الرجاء التأكد من صيغة الملف ثم المحاولة مرة اخرى !", "رسالة خطأ",JOptionPane.ERROR_MESSAGE);
 return;
  }//end catch

  }//end Method
  //****************************************************************************
  public void OpenHTMLFiles(final File theFile){
  try{
   setState (JFrame.NORMAL );
   toFront();
 // To prevent the Freez of frame ..
 SwingUtilities.invokeLater(new Runnable(){
 public void run(){

 if(!MyTab.getTitleAt(MyTab.getSelectedIndex()).equals("لسان جديد")||!TheCurrentPane.getContentType().equals("text/html"))
 {
try{// to add X button and new PaintMainPanel ..
JPanel TheXPanel=new JPanel();
JLabel ThexLabel=new JLabel();
TheXPanel.setOpaque(false);
Xbutton = new JButton(singleton.getXButtonIcon());
ThexLabel.setText("لسان جديد");
ThexLabel.setIcon(singleton.getTabIcon());
ThexLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
TheXPanel.add(Xbutton, BorderLayout.WEST);
TheXPanel.add(ThexLabel, BorderLayout.EAST);
JPanel theContentPanel=new PanelWithJTextPane(true,false);
ChangeTheCloseButtonProperty(Xbutton,theContentPanel);// To add Action Listener for the button
FastNotepadFrame.MyTab.addTab("لسان جديد",theContentPanel);

if(!Xbutton.isVisible()&&MyTab.getTabCount()>1)
{
Xbutton.setVisible(true);
AllFunctions.GetButtonOfFirstTab().setVisible(true);
    }
MyTab.setTabComponentAt(MyTab.getTabCount()-1, TheXPanel);
int TabCount=MyTab.getTabCount();
MyTab.setSelectedIndex(TabCount-1);
        }// end try
catch(Exception e){
JOptionPane.showMessageDialog(null,"خطأ في انشاء اللسان , الرجاء المحاولة لاحقا ً !"+e,"رسالة خطأ",JOptionPane.ERROR_MESSAGE);
return;
}//end catch
 }//end if
 
        try{
        singleton.getReadingFileObject().setVisible(true);// to view the reading screen .
         // This to get Encoding
        CharsetDetector cd = new CharsetDetector();
        Charset charset = cd.detectCharset(theFile, singleton.getCharsetsToBeTested());

        if (charset != null) {
        Reader fin = new InputStreamReader(new FileInputStream(theFile),charset);
        BufferedReader br = new BufferedReader (fin);
        String alltext="";
        String line;
        while((line=br.readLine())!=null)
        {  alltext=alltext+line;
        }
       // Insert Text to The Text Pane Content Text/HTML
         TheCurrentPane.setText(alltext);
         selectedFiles.set(MyTab.getSelectedIndex(),theFile);
         TheCurrentPane.setCaretPosition(0);
         UndoAndRedo.setJTextPane(TheCurrentPane);
        }
        else{
        Reader fin = new InputStreamReader(new FileInputStream(theFile),"UTF-8");
        BufferedReader br = new BufferedReader (fin);
        String alltext="";
        String line;
        while((line=br.readLine())!=null)
        {  alltext=alltext+line;
        }
         // Insert Text to The Text Pane Content Text/HTML
         TheCurrentPane.setText(alltext);
         selectedFiles.set(MyTab.getSelectedIndex(),theFile);
         TheCurrentPane.setCaretPosition(0);
         UndoAndRedo.setJTextPane(TheCurrentPane);
        }

      singleton.getReadingFileObject().setVisible(false);
      }//end try box
        catch(Exception e){
         JOptionPane.showMessageDialog(null,"خطأ في عملية فتح الملف , الرجاء التأكد من صيغة الملف ثم المحاولة مرة اخرى !", "رسالة خطأ",JOptionPane.ERROR_MESSAGE);
         return;
        }//end catch
        linesAndColLabel.setText(" أحرف : "+TheCurrentPane.getText().length()+"/ أسطر : "+TheCurrentPane.getText().split("\n").length);


     MyTab.setTitleAt(MyTab.getSelectedIndex(),theFile.getName());
     try{
     JPanel panel=(JPanel)MyTab.getTabComponentAt(MyTab.getSelectedIndex());
     JLabel label=(JLabel)panel.getComponent(1);
     MyTab.remove(panel);
     MyTab.remove(label);
     label.setText(theFile.getName());
     panel.add(label, BorderLayout.WEST);
     MyTab.setTabComponentAt(MyTab.getSelectedIndex(), panel);
     }
    catch(Exception e){
        return;}//do nothing

      }});// end Invoke Later ..

    }//end try
   catch(Exception e)
   {
   JOptionPane.showMessageDialog(null,"خطأ في عملية فتح الملف , الرجاء التأكد من صيغة الملف ثم المحاولة مرة اخرى !"+e, "رسالة خطأ",JOptionPane.ERROR_MESSAGE);
   return;
  }//end catch
 
  }//end Method
  //****************************************************************************
  public void OpenImageFiles(final File ImageFile){
   setState (JFrame.NORMAL );
   toFront();
 try{
 SwingUtilities.invokeLater(new Runnable(){
 public void run(){
         // to Open new Tab if its not new !!
        if(!MyTab.getTitleAt(MyTab.getSelectedIndex()).equals("لسان جديد")||TheCurrentPane.getContentType().equals("text/html"))
        {   // This to add tab with the X button

try{// to add X image in the PaintMainPanel then add them to tab !!
JPanel TheXPanel=new JPanel();
JLabel ThexLabel=new JLabel();
TheXPanel.setOpaque(false);
Xbutton = new JButton(singleton.getXButtonIcon());
ThexLabel.setText("لسان جديد");
ThexLabel.setIcon(singleton.getTabIcon());
ThexLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
TheXPanel.add(Xbutton, BorderLayout.WEST);
TheXPanel.add(ThexLabel, BorderLayout.EAST);
JPanel theContentPanel=new PanelWithJTextPane(false,true);
ChangeTheCloseButtonProperty(Xbutton,theContentPanel);// To add Action Listener for the button
FastNotepadFrame.MyTab.addTab("لسان جديد",theContentPanel);

if(!Xbutton.isVisible()&&MyTab.getTabCount()>1)
{
Xbutton.setVisible(true);
AllFunctions.GetButtonOfFirstTab().setVisible(true);
    }
MyTab.setTabComponentAt(MyTab.getTabCount()-1, TheXPanel);
int TabCount=MyTab.getTabCount();
MyTab.setSelectedIndex(TabCount-1);
        }// end try
catch(Exception e){
JOptionPane.showMessageDialog(null,"خطأ في انشاء اللسان , الرجاء المحاولة لاحقا ً !"+e,"رسالة خطأ",JOptionPane.ERROR_MESSAGE);
return;
}//end catch

      }//end if the name of tab is new tab !
        
  Icon icon=new MyImageIcon(ImageFile.getAbsolutePath());
  TheCurrentPane.insertIcon(icon);
  UndoAndRedo.setJTextPane(TheCurrentPane);
  selectedFiles.set(MyTab.getSelectedIndex(),ImageFile);

    // to set Title for tab!!
     try{
     JPanel panel=(JPanel)MyTab.getTabComponentAt(MyTab.getSelectedIndex());
     JLabel label=(JLabel)panel.getComponent(1);
     MyTab.remove(panel);
     MyTab.remove(label);
     label.setText(ImageFile.getName());
     panel.add(label, BorderLayout.WEST);
     MyTab.setTabComponentAt(MyTab.getSelectedIndex(), panel);
     }
    catch(Exception e){
        return;
    }//do nothing
  MyTab.setTitleAt(MyTab.getSelectedIndex(),ImageFile.getName());
  contentLabel.setText("نوع المستند : "+TheCurrentPane.getContentType());
  }});// end Swing Invoke Later ...

 }catch(Exception e){
 return;}// end catch ..

    }//end function
  //****************************************************************************
  public void ChangeTheCloseButtonProperty(JButton button,final JPanel ContentPanel){
try{
button.setContentAreaFilled(false);
button.setBorderPainted(false);
button.setRolloverIcon(singleton.getXButtonOver());
button.setPreferredSize(new Dimension(20,15));

if(MyTab.getTabCount()<=1)
Xbutton.setVisible(false);

button.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
//First Thing check if the document is not save the changed
if(MyTab.getTitleAt(MyTab.indexOfComponent(ContentPanel)).contains("*")){
int TheChoice=JOptionPane.showConfirmDialog(null,"هل تريد حفظ التغييرات التي اجريتها على هذا اللسان ؟","رسالة تأكيد",JOptionPane.YES_NO_CANCEL_OPTION);
if(TheChoice==JOptionPane.YES_OPTION)
SaveMenuItemActionPerformed(event);

else if(TheChoice==JOptionPane.CANCEL_OPTION||TheChoice==JOptionPane.CLOSED_OPTION)
return;

else{
TheIndexOfContentPanel= MyTab.indexOfComponent(ContentPanel);
selectedFiles.remove(TheIndexOfContentPanel);// to remove the path from Linked List

MyTab.removeTabAt(TheIndexOfContentPanel);
if(MyTab.getTabCount()<=1)
AllFunctions.GetButtonOfFirstTab().setVisible(false);
}//end else
            }//end big if there is change in the text pane
else
{
TheIndexOfContentPanel= MyTab.indexOfComponent(ContentPanel);
selectedFiles.remove(TheIndexOfContentPanel);// remove the path from linked list
MyTab.removeTabAt(TheIndexOfContentPanel);
if(MyTab.getTabCount()<=1)
AllFunctions.GetButtonOfFirstTab().setVisible(false);
}//end else
        }
});

      }//end try
catch(Exception e){
    // do nothing
    return;}
    }//end function
 //*****************************************************************************
  private void AddPopUpMenuAndListeners(){
  try{
// Set ActionListener for Basic Operations .
JMenuItem CutPopMenu=new JMenuItem("قص");
JMenuItem CopyPopMenu=new JMenuItem("نسخ");
JMenuItem utfMeuItem=new JMenuItem("UTF-8");
JMenuItem unicodeMenuItem=new JMenuItem("Unicode");
JMenuItem ansiMenuItem=new JMenuItem("ANSI");
singleton.getEncodingMenu().add(ansiMenuItem);
singleton.getEncodingMenu().add(utfMeuItem);
singleton.getEncodingMenu().add(unicodeMenuItem);
//***************** To set Component Orientation
singleton.getEncodingMenu().setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
utfMeuItem.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
unicodeMenuItem.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
ansiMenuItem.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
CutPopMenu.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

CutPopMenu.setIcon(new MyImageIcon(getClass().getResource("/Images/Cut.png"))); // NOI18N
CopyPopMenu.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
CopyPopMenu.setIcon(new MyImageIcon(getClass().getResource("/Images/Copy.png"))); // NOI18N

singleton.getDefaultPastePopMenu().setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
singleton.getDefaultPastePopMenu().setIcon(new MyImageIcon(getClass().getResource("/Images/default paste.png"))); // NOI18N

singleton.getHTMLPastePopMenu().setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
singleton.getHTMLPastePopMenu().setIcon(new MyImageIcon(getClass().getResource("/Images/paste html.png"))); // NOI18N

singleton.getUndoPopMenu().setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
singleton.getUndoPopMenu().setIcon(new MyImageIcon(getClass().getResource("/Images/undo.PNG"))); // NOI18N

singleton.getRedoPopMenu().setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
singleton.getRedoPopMenu().setIcon(new MyImageIcon(getClass().getResource("/Images/redo.PNG"))); // NOI18N

singleton.getViewHTMLCodeMenuItem().setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
singleton.getViewHTMLCodeMenuItem().setIcon(new MyImageIcon(getClass().getResource("/Images/htmleditor.png"))); // NOI18N

//****************** To set Listeners ..
utfMeuItem.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent event){
if(TheCurrentPane.getContentType().equals("text/plain"))
AllFunctions.ReadOtherFilesWithEncoding(TheCurrentPane, selectedFiles.get(MyTab.getSelectedIndex()),"utf-8");
else if(TheCurrentPane.getContentType().equals("text/html"))   
AllFunctions.ReadHTMLFilesWithEncoding(TheCurrentPane, selectedFiles.get(MyTab.getSelectedIndex()),"utf-8");
}
});
//*****************
unicodeMenuItem.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent event){
if(TheCurrentPane.getContentType().equals("text/plain"))
AllFunctions.ReadOtherFilesWithEncoding(TheCurrentPane, selectedFiles.get(MyTab.getSelectedIndex()),"unicode");
else if(TheCurrentPane.getContentType().equals("text/html"))
AllFunctions.ReadHTMLFilesWithEncoding(TheCurrentPane, selectedFiles.get(MyTab.getSelectedIndex()),"unicode");
}
});
//*****************
ansiMenuItem.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent event){
if(TheCurrentPane.getContentType().equals("text/plain"))
AllFunctions.ReadOtherFilesWithEncoding(TheCurrentPane, selectedFiles.get(MyTab.getSelectedIndex()),"cp1256");
else if(TheCurrentPane.getContentType().equals("text/html"))
AllFunctions.ReadHTMLFilesWithEncoding(TheCurrentPane, selectedFiles.get(MyTab.getSelectedIndex()),"cp1256");
}
});
//*****************

singleton.getUndoPopMenu().addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
UndoMenuItemActionPerformed(event);
            }
        });
//******************
singleton.getRedoPopMenu().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
RedoMenuItemActionPerformed(event);
            }
        });
//******************
CutPopMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
CutMenuItemActionPerformed(event);
            }
        });
//******************
CopyPopMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
CopyMenuItemActionPerformed(event);
            }
        });
//******************
singleton.getHTMLPastePopMenu().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
HTMLPasteMenuItemActionPerformed(event);
            }
        });
//******************
singleton.getDefaultPastePopMenu().addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
DefaultPastMenuItemActionPerformed(event);
            }
        });
//******************
singleton.getOrientationRightToLeft().setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
singleton.getOrientationLeftToRight().setSelected(true);
singleton.getOrientationLeftToRight().setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

ButtonGroup group=new ButtonGroup();
group.add(singleton.getOrientationRightToLeft());
group.add(singleton.getOrientationLeftToRight());
singleton.getOrientationRightToLeft().addItemListener(new ItemListener() {
 public void itemStateChanged(ItemEvent e) {
if(e.getItem().equals(singleton.getOrientationRightToLeft()))
{  TheCurrentPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
     }
            }
        });
//*************************
singleton.getOrientationLeftToRight().addItemListener(new ItemListener() {
 public void itemStateChanged(ItemEvent e) {
if(e.getItem().equals(singleton.getOrientationLeftToRight()))
TheCurrentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            }
        });
//*************************
        singleton.getViewHTMLCodeMenuItem().addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){
        try{
        if(ViewHTMLCodeObject==null){
        ViewHTMLCodeObject=new ViewHTMLCode();
        ViewHTMLCodeObject.setText(TheCurrentPane.getText(),MyTab.getTitleAt(MyTab.getSelectedIndex()));
        ViewHTMLCodeObject.setVisible(true);
        }
        else{
        ViewHTMLCodeObject.setText(TheCurrentPane.getText(),MyTab.getTitleAt(MyTab.getSelectedIndex()));
        ViewHTMLCodeObject.setVisible(true);
        }
  }//end try box
        catch(Exception e){
        return;
        }//end catch
       }
        });
//*****************
        singleton.getPop().add(singleton.getUndoPopMenu());
        singleton.getPop().add(singleton.getRedoPopMenu());
        singleton.getPop().addSeparator();
        singleton.getPop().add(CutPopMenu);
        singleton.getPop().add(CopyPopMenu);
        singleton.getPop().addSeparator();
        singleton.getPop().add(singleton.getEncodingMenu());
        singleton.getPop().addSeparator();
        singleton.getPop().add(singleton.getDefaultPastePopMenu());
        singleton.getPop().add(singleton.getHTMLPastePopMenu());
        singleton.getPop().addSeparator();
        singleton.getPop().add(singleton.getOrientationRightToLeft());
        singleton.getPop().add(singleton.getOrientationLeftToRight());
        singleton.getPop().addSeparator();
        singleton.getPop().add(singleton.getViewHTMLCodeMenuItem());
      }// end try
      catch(Exception e){
      JOptionPane.showMessageDialog(null,"خطأ في تكوين القوائم المنسدلة , الرجاء اعادة تحميل البرنامج !","رسالة خطأ",JOptionPane.ERROR_MESSAGE);
      // do nothing
      return;}
}//end functions



  //*****************************************************************************
  public static void main(final String args[]) {
SwingUtilities.invokeLater(new Runnable(){
public void run(){
  // to set Look And Feel ..
    try {
   UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    // if the main has arguments ..
  if(args.length>0)
  {
      AllFunctions.CheckAndSendPathToServer(args[0]);
  }// end if there is an argument in main Argument ..
   // else if the main doesn't have any argument , create object and and set visible true !!
  else{
     DefaultFastNotepadFrameObject= new FastNotepadFrame();
     DefaultFastNotepadFrameObject.setVisible(true);
     AllFunctions.createSocketServer();
  }//end else No argument in main
           } catch (Exception e) {
    JOptionPane.showMessageDialog(null,"خطأ في عملية بناء البرنامج : "+e, "رسالة خطأ", JOptionPane.ERROR_MESSAGE);
    System.exit(0);
    }// end catch ..

}// end run ..
});
     }//end main ..
 //*****************************************************************************
 // This Class to Make for CTRL+V ..
class PastKeyStrokeClass extends AbstractAction {

        public PastKeyStrokeClass(){
        }//Empty Constructor

        public void actionPerformed(ActionEvent event){
        if(TheCurrentPane.getContentType().equals("text/html"))
        HTMLPasteMenuItemActionPerformed(null);
        else if(TheCurrentPane.getContentType().equals("text/plain"))
        DefaultPastMenuItemActionPerformed(null);
       }//end function ..

    }// end class past KeyStrokeClas

// This Class to Make for component orientation ..
class setComponentOrientation extends AbstractAction {

        public setComponentOrientation(){
        }//Empty Constructor

        public void actionPerformed(ActionEvent event){
        if(TheCurrentPane.getComponentOrientation().isLeftToRight())
        TheCurrentPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        else
        TheCurrentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
       }//end function ..

    }// end class past KeyStrokeClas


 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu AboutMenu;
    private javax.swing.JMenuItem AboutProgrammerMenuItem;
    private javax.swing.JMenuItem AboutVersion2MenuItem;
    private javax.swing.JMenuItem AboutVersion3MenuItem;
    private javax.swing.JMenu AddMenu;
    private javax.swing.JMenuItem AddPicMenuItem;
    private javax.swing.JMenuItem AddShapeAndSymbols;
    private javax.swing.JMenuItem AddURLMenuItem;
    private javax.swing.JMenuItem AddpicFromNetMenuItem;
    private Components.ChooseBGColorForTextForTextPane ChooseBGColor;
    private Components.ChooseColorForTextForTextPane ChooseTextColor;
    private javax.swing.JMenuItem ConfigTheProgram;
    private javax.swing.JMenuItem CopyMenuItem;
    private javax.swing.JMenuItem CutMenuItem;
    private javax.swing.JMenuItem DefaultPastMenuItem;
    private javax.swing.JMenu EditMenu;
    private javax.swing.JMenuItem ExitMenuItem;
    private javax.swing.JMenu FileMenuItem;
    private javax.swing.JMenuItem FontMinMin;
    public static javax.swing.JPanel FontPanel;
    private javax.swing.JMenuItem FontPlusPlus;
    private javax.swing.JMenuItem HTMLPasteMenuItem;
    private javax.swing.JMenuItem HelpMenuItem;
    public static Components.SetOrientationLeftToRightForTextPane LeftToRightOrientation;
    public static javax.swing.JPanel MainPanel;
    private javax.swing.JMenuBar MenuBar;
    public static javax.swing.JTabbedPane MyTab;
    private javax.swing.JMenuItem OpenFileMenuItem;
    private javax.swing.JMenuItem OpenNewTabMenuItem;
    public static javax.swing.JLabel OperationsLabel;
    public static javax.swing.JPanel PostionPanel;
    private javax.swing.JMenuItem PrintMenuItem;
    private javax.swing.JMenuItem RedoMenuItem;
    private javax.swing.JMenuItem ReplaceTextMenuItem;
    public static Components.SetOrientationRightToLeftForTextPane RightToLeftOrientation;
    private javax.swing.JMenuItem SaveAsMenuItem;
    private static javax.swing.JMenuItem SaveMenuItem;
    private javax.swing.JMenuItem SearchMenuItem;
    public static Components.SearchWordsForTextPane SearchforWords;
    private Components.SelectedSizeForTextPane SelectSizeComboBox;
    public static Components.UndoAndRedoForTextPane UndoAndRedo;
    public static javax.swing.JPanel UndoAndRedoPanel;
    private javax.swing.JMenuItem UndoMenuItem;
    private Components.BoldTextForTextPane boldTextForTextPane2;
    public static javax.swing.JLabel contentLabel;
    private Components.ItalicTextForTextPane italicTextForTextPane2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    public static javax.swing.JLabel linesAndColLabel;
    private Components.SelectedFontForTextPane selectFontComboBox;
    private javax.swing.JSplitPane statusBarPanel;
    private Components.TextInCenterForTextPane textInCenterForTextPane1;
    private Components.TextInLeftForTextPane textInLeftForTextPane1;
    private Components.TextInRightForTextPane textInRightForTextPane1;
    private Components.UnderLineTextForTextPane underLineTextForTextPane2;
    // End of variables declaration//GEN-END:variables





}
