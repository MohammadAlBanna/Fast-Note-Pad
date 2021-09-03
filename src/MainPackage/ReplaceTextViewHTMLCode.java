/**
 * Author: Mohammad Mofeed AlBanna.
 * Web Developer
 * Website: www.MBanna.info
 * Blog: www.OutOfPalBox.net
 * Facebook: www.FB.com/MBanna.info
 */


package MainPackage;

import classes.AllFunctions;
import classes.MyImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.ComponentOrientation;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.text.StyledEditorKit;
import javax.swing.Action;

public class ReplaceTextViewHTMLCode extends javax.swing.JFrame {

    JTextPane pane;
    private JPopupMenu menu;
    private JMenuItem copy=new JMenuItem("نسخ");
    private JMenuItem past=new JMenuItem("لصق");
    private JMenuItem SelectALL=new JMenuItem("تحديد الكل");
    private boolean isArea1=false;
    private boolean isArea2=false;

    public ReplaceTextViewHTMLCode() {
    initComponents();
    setLocationRelativeTo(this);
    group1.add(JustAllWords);
    group1.add(JustSplittedWord);
    Image im=new MyImageIcon(getClass().getResource("/Images/Replace MenuItem.png")).getImage();
    setIconImage(im);
    setPopUpMenu();
    }//end counstructor ..

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        group1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        area1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        area2 = new javax.swing.JTextArea();
        CloseButton = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        JustSplittedWord = new javax.swing.JRadioButton();
        JustAllWords = new javax.swing.JRadioButton();
        caseSensetive = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("إستبدال النصوص");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel1.setText("إستبدل النص التالي :");

        area1.setColumns(20);
        area1.setFont(new java.awt.Font("Arial", 1, 14));
        area1.setRows(5);
        area1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                area1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                area1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                area1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(area1);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel2.setText("بالنص التالي :");

        area2.setColumns(20);
        area2.setFont(new java.awt.Font("Arial", 0, 14));
        area2.setRows(5);
        area2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                area2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                area2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                area2MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(area2);

        CloseButton.setText("إغلاق");
        CloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseButtonActionPerformed(evt);
            }
        });

        SaveButton.setText("حفظ");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Replace.png"))); // NOI18N

        JustSplittedWord.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        JustSplittedWord.setSelected(true);
        JustSplittedWord.setText("استبدل فقط الكلمات المنفصلة");
        JustSplittedWord.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JustSplittedWordItemStateChanged(evt);
            }
        });

        JustAllWords.setText("استبدل الكلمات المتصلة والمنفصلة");
        JustAllWords.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        caseSensetive.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        caseSensetive.setText("طابق حالة الاحرف");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JustAllWords)
                    .addComponent(JustSplittedWord)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(caseSensetive)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(346, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CloseButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SaveButton)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(324, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(20, 20, 20))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JustSplittedWord)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JustAllWords)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(caseSensetive))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CloseButton)
                    .addComponent(SaveButton)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
try{
if(JustSplittedWord.isSelected()){
String PrevText=pane.getText(0,pane.getDocument().getLength());

if(!caseSensetive.isSelected()){

String ReplacedText= AllFunctions.replaceAllWords(PrevText,area1.getText(),area2.getText());
ViewHTMLCode.textPane.setText(ReplacedText);
    }//if there are'nt case sensetive
else
{ 
String ReplacedText= AllFunctions.replaceAllWordsWithCaseSensetive(PrevText,area1.getText(),area2.getText());
ViewHTMLCode.textPane.setText(ReplacedText);
}//end else if there are case sensetive
    }//end if
//*****************
else
{

String PrevText=pane.getText(0,pane.getDocument().getLength());
String ReplacedText=  PrevText.replaceAll(area1.getText(),area2.getText());
ViewHTMLCode.textPane.setText(ReplacedText);
}//end else
        }//end try
catch(java.lang.RuntimeException e){
JOptionPane.showMessageDialog(null,"يوجد بعض blocks لم يتم اغلاقها بشكل جيد في النصوص البرمجية , الرجاء مراجعتها .", "رسالة خطأ",JOptionPane.ERROR_MESSAGE);
return;
}//end catch

catch(Exception e){
JOptionPane.showMessageDialog(null,"خطأ في عملية استبدال النصوص , الرجاء المحاولة لاحقا ً !"+e,"رسالة خطأ",JOptionPane.ERROR_MESSAGE);
return;
}//end catch

dispose();// Close Screen
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void CloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseButtonActionPerformed
 dispose();
    }//GEN-LAST:event_CloseButtonActionPerformed

    private void JustSplittedWordItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JustSplittedWordItemStateChanged
if(JustSplittedWord.isSelected())
caseSensetive.setEnabled(true);
else{
caseSensetive.setSelected(true);
caseSensetive.setEnabled(false);
        }
    }//GEN-LAST:event_JustSplittedWordItemStateChanged

    private void area1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_area1MousePressed
if(area1.getText().length()==0){
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
    }//GEN-LAST:event_area1MousePressed

    private void area1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_area1MouseReleased
if(area1.getText().length()==0){
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
    }//GEN-LAST:event_area1MouseReleased

    private void area2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_area2MousePressed
if(area2.getText().length()==0){
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
    }//GEN-LAST:event_area2MousePressed

    private void area2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_area2MouseReleased
if(area2.getText().length()==0){
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
    }//GEN-LAST:event_area2MouseReleased

    private void area1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_area1MouseClicked
isArea1=true;
isArea2=false;
    }//GEN-LAST:event_area1MouseClicked

    private void area2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_area2MouseClicked
isArea1=false;
isArea2=true;
    }//GEN-LAST:event_area2MouseClicked

    public void setJTextPane(JTextPane pane){
    this.pane=pane;
    }


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
if(isArea1)
area1.selectAll();
else if(isArea2)
area2.selectAll();
}
});

menu.add(copy);
menu.add(past);
menu.addSeparator();
menu.add(SelectALL);

}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CloseButton;
    private javax.swing.JRadioButton JustAllWords;
    private javax.swing.JRadioButton JustSplittedWord;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextArea area1;
    private javax.swing.JTextArea area2;
    private javax.swing.JCheckBox caseSensetive;
    private javax.swing.ButtonGroup group1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

}
