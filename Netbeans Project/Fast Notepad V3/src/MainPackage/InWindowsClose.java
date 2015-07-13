/**
 * Author: Mohammad Mofeed AlBanna.
 * Web Developer
 * Website: www.MBanna.info
 * Blog: www.OutOfPalBox.net
 * Facebook: www.FB.com/MBanna.info
 */


// This Class To Check if there any change for any tap when he closing it ,
//then ask the user if he wanna close the program or no ...
package MainPackage;
import classes.MyImageIcon;
import java.awt.Image;


public class InWindowsClose extends javax.swing.JDialog {

  public boolean yesAnswer=false;
  public boolean noAnswer=false;
    public InWindowsClose(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
        Image im=new MyImageIcon(getClass().getResource("/Images/mainIcon.png")).getImage();
        setIconImage(im);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TilteLabel = new javax.swing.JLabel();
        YesButton = new javax.swing.JButton();
        NoButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("رسالة تأكيد");
        setResizable(false);

        TilteLabel.setFont(new java.awt.Font("Arial", 1, 15));
        TilteLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        TilteLabel.setText("توجد بعض المستندات لم يتم حفظ التعديلات التي أُجريت عليها , هل ما زلت تريد اغلاق البرنامج ؟");
        TilteLabel.setName("TilteLabel"); // NOI18N

        YesButton.setText("نعم");
        YesButton.setName("YesButton"); // NOI18N
        YesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YesButtonActionPerformed(evt);
            }
        });

        NoButton.setText("لا");
        NoButton.setName("NoButton"); // NOI18N
        NoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoButtonActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Alert.png"))); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(NoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(YesButton))
                    .addComponent(TilteLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TilteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(YesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(jLabel1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void YesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YesButtonActionPerformed
        yesAnswer=true;
        noAnswer=false;
        dispose();
}//GEN-LAST:event_YesButtonActionPerformed

    private void NoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoButtonActionPerformed
        yesAnswer=false;
        noAnswer=true;
        dispose();
}//GEN-LAST:event_NoButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton NoButton;
    private javax.swing.JLabel TilteLabel;
    private javax.swing.JButton YesButton;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
