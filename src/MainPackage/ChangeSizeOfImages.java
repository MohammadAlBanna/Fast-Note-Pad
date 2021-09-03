/**
 * Author: Mohammad Mofeed AlBanna.
 * Web Developer
 * Website: www.MBanna.info
 * Blog: www.OutOfPalBox.net
 * Facebook: www.FB.com/MBanna.info
 */


// This Class to change the size of images on clicked on it ..
package MainPackage;

import classes.MyImageIcon;
import com.sun.awt.AWTUtilities;
import java.awt.Graphics2D;
import java.awt.Cursor;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import classes.PaintResizePanel;
import java.awt.RenderingHints;


public class ChangeSizeOfImages extends javax.swing.JDialog {

    JTextPane TheCurrentPane;
    Icon TheCurrentIcon;
    Icon TheResizedIcon;
    int Width;
    int Height;
    public ChangeSizeOfImages() {
      initComponents();
      AWTUtilities.setWindowOpaque(this,false);
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new PaintResizePanel();
        jLabel1 = new javax.swing.JLabel();
        heightTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        widthTextField = new javax.swing.JTextField();
        SaveButton = new javax.swing.JButton();
        CloseButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setAlwaysOnTop(true);
        setUndecorated(true);

        jPanel1.setName("jPanel1"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 15));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("تغيير ابعاد الصورة :");
        jLabel1.setName("jLabel1"); // NOI18N

        heightTextField.setText("0");
        heightTextField.setName("heightTextField"); // NOI18N
        heightTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                heightTextFieldMouseReleased(evt);
            }
        });
        heightTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                heightTextFieldActionPerformed(evt);
            }
        });
        heightTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                heightTextFieldKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 13));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("الطول :");
        jLabel2.setName("jLabel2"); // NOI18N

        widthTextField.setText("0");
        widthTextField.setName("widthTextField"); // NOI18N
        widthTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                widthTextFieldMouseReleased(evt);
            }
        });
        widthTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                widthTextFieldActionPerformed(evt);
            }
        });
        widthTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                widthTextFieldKeyReleased(evt);
            }
        });

        SaveButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        SaveButton.setForeground(new java.awt.Color(255, 255, 255));
        SaveButton.setText("حفظ");
        SaveButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        SaveButton.setBorderPainted(false);
        SaveButton.setContentAreaFilled(false);
        SaveButton.setName("SaveButton"); // NOI18N
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        CloseButton.setFont(new java.awt.Font("Tahoma", 1, 11));
        CloseButton.setForeground(new java.awt.Color(255, 255, 255));
        CloseButton.setText("اغلاق");
        CloseButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        CloseButton.setBorderPainted(false);
        CloseButton.setContentAreaFilled(false);
        CloseButton.setName("CloseButton"); // NOI18N
        CloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 13));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("العرض :");
        jLabel3.setName("jLabel3"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CloseButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SaveButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(widthTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(heightTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(heightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(widthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton)
                    .addComponent(CloseButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseButtonActionPerformed
setVisible(false);
    }//GEN-LAST:event_CloseButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed

try{
Width=Integer.valueOf(widthTextField.getText());
Height=Integer.valueOf(heightTextField.getText());
removeIcon(TheCurrentPane,TheCurrentIcon);
// Be ready here alpha , ARGB_PRE to set transparency for PNG files =)
BufferedImage myBuffer=new BufferedImage(TheCurrentIcon.getIconWidth(), TheCurrentIcon.getIconHeight(),BufferedImage.TYPE_INT_ARGB_PRE);
TheCurrentIcon.paintIcon(this, myBuffer.createGraphics(), 0, 0);
myBuffer= resizeImage(myBuffer,BufferedImage.TYPE_INT_ARGB_PRE);
TheResizedIcon=new MyImageIcon(myBuffer);
TheCurrentPane.insertIcon(TheResizedIcon);
dispose();
        }//end try
catch(Exception e){
return;// do nothing
}
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void heightTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_heightTextFieldKeyReleased
try{
Integer.parseInt(heightTextField.getText());
}catch(Exception e){
heightTextField.setText("0");
}


    }//GEN-LAST:event_heightTextFieldKeyReleased

    private void widthTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_widthTextFieldKeyReleased

try{
Integer.parseInt(widthTextField.getText());
}catch(Exception e){
widthTextField.setText("0");
}
    }//GEN-LAST:event_widthTextFieldKeyReleased

    private void heightTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_heightTextFieldActionPerformed
SaveButtonActionPerformed(null);
    }//GEN-LAST:event_heightTextFieldActionPerformed

    private void widthTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_widthTextFieldActionPerformed
SaveButtonActionPerformed(null);
    }//GEN-LAST:event_widthTextFieldActionPerformed

    private void heightTextFieldMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_heightTextFieldMouseReleased
heightTextField.setSelectionStart(0);
heightTextField.setSelectionEnd(heightTextField.getText().length());
    }//GEN-LAST:event_heightTextFieldMouseReleased

    private void widthTextFieldMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_widthTextFieldMouseReleased
widthTextField.setSelectionStart(0);
widthTextField.setSelectionEnd(widthTextField.getText().length());
    }//GEN-LAST:event_widthTextFieldMouseReleased
// To Remove An Icon from JTextPane ...
private void removeIcon(JTextPane pane,Icon Myicon){

for (int i=0; i<pane.getStyledDocument().getLength(); i++)
{
Element element =pane.getStyledDocument().getCharacterElement(i);
AttributeSet attributeSet = element.getAttributes();
Icon icon = StyleConstants.getIcon(attributeSet);
if (icon != null&&icon.equals(Myicon))
{
try
{
pane.getStyledDocument().remove(i, 1);
pane.getStyledDocument().insertString(i, " ", new SimpleAttributeSet());
icon = null;
}

catch (Exception exc)
{
break;
}
break;
}
}
}
//************************************************
// To Resize An Icon from JTextPane OR for copied image from websites .. or another
public BufferedImage resizeImage(BufferedImage originalImage, int type){
 
	BufferedImage resizedImage = new BufferedImage(Width, Height, type);
	Graphics2D g = resizedImage.createGraphics();
        // Make quality of image ..
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawImage(originalImage, 0, 0, Width, Height, null);
	g.dispose();

    



	return resizedImage;
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CloseButton;
    private javax.swing.JButton SaveButton;
    public javax.swing.JTextField heightTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField widthTextField;
    // End of variables declaration//GEN-END:variables

}
