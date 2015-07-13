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
import classes.singleton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.text.StyledEditorKit;
import java.awt.Image;


public class ShapesAndSymbols extends javax.swing.JFrame {
 private JPopupMenu menu;
 private JMenuItem copy=new JMenuItem("نسخ");
 private JMenuItem SelectALL=new JMenuItem("تحديد الكل");

    public ShapesAndSymbols() {
        initComponents();
        setLocationRelativeTo(this);
        setPopUpMenu();
        Image im=new MyImageIcon(getClass().getResource("/Images/mainIcon.png")).getImage();
        setIconImage(im);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        closeButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textPane = new javax.swing.JTextPane();

        setTitle("رموز وأشكال خاصة");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("رموز وأشكال :");

        closeButton.setText("إغلاق");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        textPane.setEditable(false);
        textPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                textPaneMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                textPaneMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(textPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(635, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(closeButton)
                .addContainerGap(671, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(closeButton))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
setVisible(false);
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
   // This Function to Read Symbols File ...
   public void ReadShapesAndSymbols(){
    try{

    if(textPane.getText().length()==0)
    {   singleton.getReadingFileObject().setVisible(true);
        AllFunctions.ReadFromFileToJTextPane(textPane, getClass().getResourceAsStream("/Files/ShapesAndSymbols.fnp"));
        }//end if need to read ..
    }//end function
catch(Exception e){
JOptionPane.showMessageDialog(null,"خطأ في قراءة ملف الرموز الخاصة !"+e);
return;
}//end catch
}// end method
//******************************************************************************
 private void setPopUpMenu(){
menu=new JPopupMenu();
copy.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent event){
 Action e=new StyledEditorKit.CopyAction();
 e.actionPerformed(event);
}
});


SelectALL.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent event){
textPane.selectAll();
}
});

menu.add(copy);
menu.addSeparator();
menu.add(SelectALL);

}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane textPane;
    // End of variables declaration//GEN-END:variables

}
