/**
 * Author: Mohammad Mofeed AlBanna.
 * Web Developer
 * Website: www.MBanna.info
 * Blog: www.OutOfPalBox.net
 * Facebook: www.FB.com/MBanna.info
 */


package MainPackage;

import com.sun.awt.AWTUtilities;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class AboutVersion3 extends javax.swing.JDialog {

private Timer ShowTimer;
private Timer HideTimer;
    public AboutVersion3() {
   
        initComponents();      
        setVisible(false);
        setLocationRelativeTo(this);
        AWTUtilities.setWindowOpaque(this,false);

  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });

        jPanel1.setOpaque(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/AboutVersion3.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, Short.MAX_VALUE)
        );

        jLabel2.setBackground(new java.awt.Color(204, 204, 255));
        jLabel2.setFont(new java.awt.Font("Blackadder ITC", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Over the mouse on card to hide..");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel2.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jLabel2)
                .addContainerGap(187, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
 HideWindow();
    }//GEN-LAST:event_formMouseEntered


 //*****************************************************************************
// To Show the Card Window ...
int counterForShowWindow=0;
public void ShowWindow(){
if(HideTimer!=null){
HideTimer.stop();
HideTimer=null;
}//end if

if(!this.isVisible())
{
setSize(new Dimension(510,0));
setVisible(true);
}//end if
counterForShowWindow=0;

if(ShowTimer==null)
ShowTimer=new Timer(10,new ActionListener(){
public void actionPerformed(ActionEvent event){

if(counterForShowWindow<= 635)
{
counterForShowWindow=counterForShowWindow+10;
setSize(new Dimension(510,counterForShowWindow));
    }//end if
else{
if(ShowTimer!=null)
{
ShowTimer.stop();
    }//end if
}//end else
}
});
ShowTimer.start();
}//end function Show window

//******************************************************************************
// to Hide Card Window ..
int counterForHideWindow=  635;
public void HideWindow(){
         if(ShowTimer!=null){
          ShowTimer.stop();
          ShowTimer=null;
           }//end if

counterForHideWindow=  635;
if(HideTimer==null)
HideTimer=new Timer(10,new ActionListener(){
public void actionPerformed(ActionEvent event){
if(counterForHideWindow>=0)
{
counterForHideWindow=counterForHideWindow-10;
setSize(new Dimension(510,counterForHideWindow));
    }//end if
else{
if(HideTimer!=null)
{
setPreferredSize(new Dimension(0,0));
HideTimer.stop();
setVisible(false);
    }//end if
}//end else
}
});
HideTimer.start();
}//end function Show window

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
