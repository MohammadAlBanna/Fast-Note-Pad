/**
 * Author: Mohammad Mofeed AlBanna.
 * Web Developer
 * Website: www.MBanna.info
 * Blog: www.OutOfPalBox.net
 * Facebook: www.FB.com/MBanna.info
 */


package MainPackage;


import classes.MyImageIcon;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.Action;
import javax.swing.text.StyledEditorKit;
import java.awt.Image;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.JMenu;

 public class ViewHTMLCode extends javax.swing.JFrame {
     
 private JPopupMenu menu;
 private JMenu textSize=new JMenu("حجم الخط");
 private JMenuItem copy=new JMenuItem("نسخ");
 private JMenuItem past=new JMenuItem("لصق");
 private JMenuItem ten=new JMenuItem("10");
 private JMenuItem twenty=new JMenuItem("20");
 private JMenuItem thirty=new JMenuItem("30");
 private JMenuItem forty=new JMenuItem("40");
 private JMenuItem fifty=new JMenuItem("50");
 private JMenuItem SelectALL=new JMenuItem("تحديد الكل");
 private ReplaceTextViewHTMLCode ReplaceTextViewHTMLCodeObject=null;
 Font FontObject=new Font("Tahoma", 0, 18);

 public ViewHTMLCode() {
        initComponents();
        setLocationRelativeTo(this);
        SearchField.StartSearch(textPane);
        undoAndredo.setJTextPane(textPane);
        setPopUpMenu();
        setKeyStrokes();
        SearchField.getXButton().setVisible(false);        
        Image im=new MyImageIcon(getClass().getResource("/Images/htmleditor.png")).getImage();
        setIconImage(im);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        saveButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        SearchField = new Components.SearchWordsForTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        textPane = new javax.swing.JTextPane();
        undoAndredo = new Components.UndoAndRedoForTextPane();
        jSeparator1 = new javax.swing.JSeparator();
        ReplaceTextButton = new javax.swing.JButton();

        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save.png"))); // NOI18N
        saveButton.setText("حفظ");
        saveButton.setToolTipText("Ctrl+S");
        saveButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        saveButton.setName("saveButton"); // NOI18N
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/exit.png"))); // NOI18N
        closeButton.setText("إغلاق");
        closeButton.setToolTipText("Ctrl+E");
        closeButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        closeButton.setName("closeButton"); // NOI18N
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        SearchField.setName("SearchField"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        textPane.setFont(new java.awt.Font("Tahoma", 0, 18));
        textPane.setName("textPane"); // NOI18N
        textPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                textPaneMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                textPaneMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(textPane);

        undoAndredo.setName("undoAndredo"); // NOI18N

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setName("jSeparator1"); // NOI18N

        ReplaceTextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Replace MenuItem.png"))); // NOI18N
        ReplaceTextButton.setText("إستبدال النص");
        ReplaceTextButton.setToolTipText("Ctrl+R");
        ReplaceTextButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ReplaceTextButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ReplaceTextButton.setName("ReplaceTextButton"); // NOI18N
        ReplaceTextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReplaceTextButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(closeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ReplaceTextButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(undoAndredo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 961, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SearchField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(closeButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(ReplaceTextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(undoAndredo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
try{
String allText=textPane.getText();
FastNotepadFrame.TheCurrentPane.setText(allText);
        }//end try
catch(java.lang.RuntimeException e){
JOptionPane.showMessageDialog(null,"يوجد بعض blocks لم يتم اغلاقها بشكل جيد في النصوص البرمجية , الرجاء مراجعتها .", "رسالة خطأ",JOptionPane.ERROR_MESSAGE);
return;
}//end catch
catch(Exception e){
JOptionPane.showMessageDialog(null,"خطأ في عملية اضافة النصوص البرمجية , الرجاء المحاولة لاحقا ً .", "رسالة خطأ",JOptionPane.ERROR_MESSAGE);
return;
}
    }//GEN-LAST:event_saveButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void textPaneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textPaneMousePressed
if(textPane.getText().length()==0){
copy.setEnabled(false);
SelectALL.setEnabled(false);
}// end if there is no text ..
else
{
copy.setEnabled(true);
SelectALL.setEnabled(true);
}// end if there is text

if(evt.isPopupTrigger())
{
menu.show(evt.getComponent(),evt.getX(),evt.getY());
}
    }//GEN-LAST:event_textPaneMousePressed

    private void textPaneMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textPaneMouseReleased
if(textPane.getText().length()==0){
copy.setEnabled(false);
SelectALL.setEnabled(false);
}// end if there is no text ..
else
{
copy.setEnabled(true);
SelectALL.setEnabled(true);
}// end if there is text

if(evt.isPopupTrigger())
{
menu.show(evt.getComponent(),evt.getX(),evt.getY());
}
    }//GEN-LAST:event_textPaneMouseReleased

    private void ReplaceTextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReplaceTextButtonActionPerformed

        if(ReplaceTextViewHTMLCodeObject==null){
 ReplaceTextViewHTMLCodeObject=new ReplaceTextViewHTMLCode();
 ReplaceTextViewHTMLCodeObject.setJTextPane(textPane);
 ReplaceTextViewHTMLCodeObject.setVisible(true);
        }
 else{
  ReplaceTextViewHTMLCodeObject.setJTextPane(textPane);
ReplaceTextViewHTMLCodeObject.setVisible(true);
 }

    }//GEN-LAST:event_ReplaceTextButtonActionPerformed
// This Function to set pop up menu : copy / past select all ..
private void setPopUpMenu(){
menu=new JPopupMenu();
copy.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent event){
 Action e=new StyledEditorKit.CopyAction();
 e.actionPerformed(event);
}
});

past.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent event){
Action pastOnly=new StyledEditorKit.PasteAction();
pastOnly.actionPerformed(event);
}
});

SelectALL.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent event){
textPane.selectAll();
}
});


ten.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent event){
textPane.setFont(new java.awt.Font("Tahoma", 0, 10));
}
});

twenty.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent event){
textPane.setFont(new java.awt.Font("Tahoma", 0, 20));
}
});

thirty.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent event){
textPane.setFont(new java.awt.Font("Tahoma", 0, 30));
}
});


forty.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent event){
textPane.setFont(new java.awt.Font("Tahoma", 0, 40));
}
});

fifty.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent event){
textPane.setFont(new java.awt.Font("Tahoma", 0, 50));
}
});

// Now to set component orientation
textSize.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
ten.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
twenty.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
thirty.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
forty.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
fifty.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
copy.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
past.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
SelectALL.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

textSize.add(ten);
textSize.add(twenty);
textSize.add(thirty);
textSize.add(forty);
textSize.add(fifty);

menu.add(copy);
menu.add(past);
menu.addSeparator();
menu.add(textSize);
menu.addSeparator();
menu.add(SelectALL);

}

//******************************************************************************
// Importatnt Classes  ..
// This Class to Make for CTRL+S ..
private class SaveKeyStrokeClass extends AbstractAction {

        public SaveKeyStrokeClass(){
        }//Empty Constructor

        public void actionPerformed(ActionEvent event){
        saveButtonActionPerformed(null);
       }//end function ..

    }// end class CTRL+S KeyStrokeClass

//******************************************************************************
// This Class to Make for CTRL+Q ..
private class ShowReplaceTextKeyStrokeClass extends AbstractAction {

        public ShowReplaceTextKeyStrokeClass(){
        }//Empty Constructor

        public void actionPerformed(ActionEvent event){
        ReplaceTextButtonActionPerformed(null);
       }//end function ..

    }// end class CTRL+Q KeyStrokeClass
//******************************************************************************
// This Class to Make for CTRL+E ..
private class ExitKeyStrokeClass extends AbstractAction {

        public ExitKeyStrokeClass(){
        }//Empty Constructor

        public void actionPerformed(ActionEvent event){
        setVisible(false);
       }//end function ..

    }// end class CTRL+Q KeyStrokeClass
//******************************************************************************
// This Class to Make for CTRL+Z ..
private class UndoKeyStrokeClass extends AbstractAction {

        public UndoKeyStrokeClass(){
        }//Empty Constructor

        public void actionPerformed(ActionEvent event){
         undoAndredo.getUndoButton().doClick();
       }//end function ..

    }// end class CTRL+Z KeyStrokeClass
//******************************************************************************
// This Class to Make for CTRL+Y ..
private class RedoKeyStrokeClass extends AbstractAction {

        public RedoKeyStrokeClass(){
        }//Empty Constructor

        public void actionPerformed(ActionEvent event){
         undoAndredo.getRedoButton().doClick();
       }//end function ..

    }// end class CTRL+Y KeyStrokeClass

//******************************************************************************
private void setKeyStrokes(){
      KeyStroke CtrlSStrok= KeyStroke.getKeyStroke("ctrl S");
      KeyStroke CtrlQStrok= KeyStroke.getKeyStroke("ctrl R");
      KeyStroke CtrlEStrok= KeyStroke.getKeyStroke("ctrl E");
      KeyStroke CtrlZStrok= KeyStroke.getKeyStroke("ctrl Z");
      KeyStroke CtrlYStrok= KeyStroke.getKeyStroke("ctrl Y");

      Action CtrlSAction = new SaveKeyStrokeClass();
      Action CtrlQAction = new ShowReplaceTextKeyStrokeClass();
      Action CtrlEAction = new ExitKeyStrokeClass();
      Action CtrlZAction = new UndoKeyStrokeClass();
      Action CtrlYAction = new RedoKeyStrokeClass();

      InputMap inputMap = textPane.getInputMap();
      inputMap.put(CtrlSStrok, "the Ctrl+ S action");
      inputMap.put(CtrlQStrok, "the Ctrl+ R action");
      inputMap.put(CtrlEStrok, "the Ctrl+ E action");
      inputMap.put(CtrlZStrok, "the Ctrl+ Z action");
      inputMap.put(CtrlYStrok, "the Ctrl+ Y action");

      ActionMap actionMap = textPane.getActionMap();
      actionMap.put("the Ctrl+ S action", CtrlSAction);
      actionMap.put("the Ctrl+ R action", CtrlQAction);
      actionMap.put("the Ctrl+ E action", CtrlEAction);
      actionMap.put("the Ctrl+ Z action", CtrlZAction);
      actionMap.put("the Ctrl+ Y action", CtrlYAction);

}//end function
//******************************************************************************
public void setText(String text,String theTabName) throws Exception{
textPane.setText(text);
textPane.setFont(FontObject);
setTitle(" -محررة HTML- "+theTabName);
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ReplaceTextButton;
    private Components.SearchWordsForTextPane SearchField;
    private javax.swing.JButton closeButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton saveButton;
    public static javax.swing.JTextPane textPane;
    private Components.UndoAndRedoForTextPane undoAndredo;
    // End of variables declaration//GEN-END:variables



}
