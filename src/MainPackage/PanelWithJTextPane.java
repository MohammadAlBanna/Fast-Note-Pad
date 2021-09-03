/**
 * Author: Mohammad Mofeed AlBanna.
 * Web Developer
 * Website: www.MBanna.info
 * Blog: www.OutOfPalBox.net
 * Facebook: www.FB.com/MBanna.info
 */


// This class to set content of new JTextPane ...
// HTML OR Default JTextPane  Text/Plain
package MainPackage;
import classes.AllFunctions;
import classes.JTextPaneTransferHandler;
import classes.MyEditorKit;
import java.awt.ComponentOrientation;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class PanelWithJTextPane extends javax.swing.JPanel {
static JTextPaneTransferHandler toPaste=new JTextPaneTransferHandler();
// This constructor when user choose new tab .
 public PanelWithJTextPane() {
        initComponents();
        if(FastNotepadFrame.MyTab.getTabCount()>=1){
         ChooseWhatTheSheetIs object= new ChooseWhatTheSheetIs(new JFrame(), true);
         object.setVisible(true);
         if(object.isHTML)
         {
           createHTMLDocument();
         }// end if HTML Document ..

 else if(object.isDefault){
createDefaultDocument();
 }//end else

    }
 else 
{
createDefaultDocument();
}// end else no choice here !
}// end constructor

//******************************************************************************
// This constructor when user choose open file !
 public PanelWithJTextPane(boolean isHTML,boolean isDefault){
 initComponents();
     
 if(isHTML==true)
 createHTMLDocument();
 if(isDefault==true)
 createDefaultDocument();

}
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TextPane = new javax.swing.JTextPane();

        setMinimumSize(new java.awt.Dimension(800, 500));
        setPreferredSize(new java.awt.Dimension(800, 470));

        TextPane.setMinimumSize(new java.awt.Dimension(800, 500));
        jScrollPane1.setViewportView(TextPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public static void createHTMLDocument(){
             TextPane.setEditorKitForContentType("text/html", new MyEditorKit());
             TextPane.setContentType("text/html");
             FastNotepadFrame.RightToLeftOrientation.setJTextPane(TextPane);
             FastNotepadFrame.LeftToRightOrientation.setJTextPane(TextPane);
             FastNotepadFrame.SearchforWords.StartSearch(TextPane);
             TextPane.setTransferHandler(toPaste);
             AllFunctions.setHyperLink(TextPane);
             FastNotepadFrame.selectedFiles.add(new File("null"));
    }// end createHTMLDocument

    public static void createDefaultDocument(){
     TextPane.requestFocusInWindow();
     TextPane.setText("Fast NotePad");
     TextPane.setText("");
     TextPane.setContentType("text/plain");     
     FastNotepadFrame.RightToLeftOrientation.setJTextPane(TextPane);
     FastNotepadFrame.LeftToRightOrientation.setJTextPane(TextPane);
     FastNotepadFrame.SearchforWords.StartSearch(TextPane);
     TextPane.setTransferHandler(toPaste);
     TextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
     SimpleAttributeSet attribs = new SimpleAttributeSet();
     StyleConstants.setAlignment(attribs , StyleConstants.ALIGN_RIGHT);
     TextPane.setParagraphAttributes(attribs,true);
     FastNotepadFrame.selectedFiles.add(new File("null"));
    }//end createDefaultDocument

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextPane TextPane;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
