/**
 * Author: Mohammad Mofeed AlBanna.
 * Web Developer
 * Website: www.MBanna.info
 * Blog: www.OutOfPalBox.net
 * Facebook: www.FB.com/MBanna.info
 */


// This Class To check what is the Encoding , UTF OR ANSI OR Unicode Just Dialog ..
package MainPackage;
import classes.MyImageIcon;
import java.awt.Image;

public class ChooseEncoding extends javax.swing.JDialog {

    boolean isDefault=false;
    boolean isANSI=false;
    boolean isNull=false;
    boolean isUNICODE=false;
    public ChooseEncoding(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
        isDefault=false;
        isANSI=false;
        isNull=false;
        isUNICODE=false;
        Image im=new MyImageIcon(getClass().getResource("/Images/mainIcon.png")).getImage();
        setIconImage(im);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        defaultButton = new javax.swing.JButton();
        ANSIButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        UNICODEbutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("ترميز المستند :");
        setAlwaysOnTop(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        defaultButton.setText("إفتراضي(UTF-8)");
        defaultButton.setName("defaultButton"); // NOI18N
        defaultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defaultButtonActionPerformed(evt);
            }
        });

        ANSIButton.setText("ANSI");
        ANSIButton.setName("ANSIButton"); // NOI18N
        ANSIButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ANSIButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("ما هو ترميز المستند :");
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Encoding.PNG"))); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        UNICODEbutton.setText("Unicode");
        UNICODEbutton.setName("UNICODEbutton"); // NOI18N
        UNICODEbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UNICODEbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(UNICODEbutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ANSIButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(defaultButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(defaultButton)
                        .addComponent(ANSIButton)
                        .addComponent(UNICODEbutton)))
                .addGap(11, 11, 11))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void defaultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defaultButtonActionPerformed
   isDefault=true;
   isANSI=false;
   isUNICODE=false;
   dispose();
    }//GEN-LAST:event_defaultButtonActionPerformed

    private void ANSIButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ANSIButtonActionPerformed
  isDefault=false;
  isANSI=true;
  isUNICODE=false;
  dispose();
    }//GEN-LAST:event_ANSIButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
isNull=true;
dispose();
    }//GEN-LAST:event_formWindowClosing

    private void UNICODEbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UNICODEbuttonActionPerformed
  isDefault=false;
  isANSI=false;
  isUNICODE=true;
  dispose();
    }//GEN-LAST:event_UNICODEbuttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ANSIButton;
    private javax.swing.JButton UNICODEbutton;
    private javax.swing.JButton defaultButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

}
