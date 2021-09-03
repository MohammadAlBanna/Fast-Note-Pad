/**
 * Author: Mohammad Mofeed AlBanna.
 * Web Developer
 * Website: www.MBanna.info
 * Blog: www.OutOfPalBox.net
 * Facebook: www.FB.com/MBanna.info
 */


package MainPackage;

import classes.MyImageIcon;
import classes.ConfigFile;
import classes.singleton;
import java.awt.Color;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.JColorChooser;
import classes.PaintMainPanel;
import classes.TransferHandlerForChangeBackGround;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import java.awt.Image;


public class ConfigTheProgram extends javax.swing.JFrame {


    public ConfigTheProgram() {
        initComponents();
        setLocationRelativeTo(this);
        // to drag and drop the image , Just image ..
        PathField.setTransferHandler(new TransferHandlerForChangeBackGround());
        // set Icon ..
        Image im=new MyImageIcon(getClass().getResource("/Images/fnp.png")).getImage();
        setIconImage(im);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewforegroundcolorForStatusBar = new javax.swing.JLabel();
        BrowseButton = new javax.swing.JButton();
        PathField = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        ChooseForegroundFroStatusBar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ViewPicButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        SaveButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ViewPicLabel = new javax.swing.JLabel();
        ViewInProgramButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        DefaultConfigButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        ChooseForegroundForTitles = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        viewforegroundcolorForTitles = new javax.swing.JLabel();

        setTitle("الإعدادات الشكلية ..");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        viewforegroundcolorForStatusBar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        viewforegroundcolorForStatusBar.setText("معاينة اللون ~");

        BrowseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/open image.png"))); // NOI18N
        BrowseButton.setText("إستعراض");
        BrowseButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        BrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrowseButtonActionPerformed(evt);
            }
        });

        ChooseForegroundFroStatusBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MoreColors.png"))); // NOI18N
        ChooseForegroundFroStatusBar.setText("إستعراض");
        ChooseForegroundFroStatusBar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ChooseForegroundFroStatusBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooseForegroundFroStatusBarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18));
        jLabel4.setText("اختيار خلفية صورة للبرنامج :-");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18));
        jLabel3.setText("اختيار لون الخط لشريط الحالة :");

        ViewPicButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search.png"))); // NOI18N
        ViewPicButton.setText("معاينة");
        ViewPicButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ViewPicButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewPicButtonActionPerformed(evt);
            }
        });

        SaveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/gtk_save_as.png"))); // NOI18N
        SaveButton.setText("حفظ التعديلات");
        SaveButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SaveButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        ViewPicLabel.setFont(new java.awt.Font("Tahoma", 0, 12));
        ViewPicLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ViewPicLabel.setText("شاشة معاينة");
        ViewPicLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ViewPicLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jScrollPane1.setViewportView(ViewPicLabel);

        ViewInProgramButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search.png"))); // NOI18N
        ViewInProgramButton.setText("معاينة على البرنامج");
        ViewInProgramButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ViewInProgramButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewInProgramButtonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel5.setText("قم بإختيار الخلفية الخاصة بك من خلال إستعراض أو سحب الصورة وإفلاتها في الحقل :");

        DefaultConfigButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/undo.PNG"))); // NOI18N
        DefaultConfigButton.setText("الإعدادات الإفتراضية");
        DefaultConfigButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        DefaultConfigButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DefaultConfigButtonActionPerformed(evt);
            }
        });

        ExitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/exit.png"))); // NOI18N
        ExitButton.setText("خروج");
        ExitButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        ChooseForegroundForTitles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MoreColors.png"))); // NOI18N
        ChooseForegroundForTitles.setText("إستعراض");
        ChooseForegroundForTitles.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ChooseForegroundForTitles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooseForegroundForTitlesActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18));
        jLabel6.setText("اختيار لون الخط لعناوين الأدوات :");

        viewforegroundcolorForTitles.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        viewforegroundcolorForTitles.setText("معاينة اللون ~");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ExitButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SaveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ViewInProgramButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DefaultConfigButton)
                .addContainerGap(229, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1)
                                    .addComponent(PathField, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(BrowseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ViewPicButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel5))
                        .addContainerGap(104, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(viewforegroundcolorForTitles)
                                .addGap(18, 18, 18)
                                .addComponent(ChooseForegroundForTitles)
                                .addGap(34, 34, 34)))
                        .addGap(40, 40, 40)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(viewforegroundcolorForStatusBar)
                                .addGap(18, 18, 18)
                                .addComponent(ChooseForegroundFroStatusBar)
                                .addGap(34, 34, 34)))
                        .addGap(24, 24, 24))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(566, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addGap(13, 13, 13)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PathField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BrowseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(ViewPicButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ChooseForegroundFroStatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(viewforegroundcolorForStatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ChooseForegroundForTitles, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(viewforegroundcolorForTitles, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExitButton)
                    .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ViewInProgramButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DefaultConfigButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(577, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ChooseForegroundFroStatusBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChooseForegroundFroStatusBarActionPerformed
Color color = JColorChooser.showDialog(this, "اختر اللون : ", Color.cyan);
viewforegroundcolorForStatusBar.setForeground(color);
    }//GEN-LAST:event_ChooseForegroundFroStatusBarActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
try{
ConfigFile PathAndColorObject=new ConfigFile();
PathAndColorObject.setThePath(PathField.getText());
PathAndColorObject.setStatusBarForegroundColor(viewforegroundcolorForStatusBar.getForeground());
PathAndColorObject.setTitleBarForegroundColor(viewforegroundcolorForTitles.getForeground());
ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(System.getProperty("java.io.tmpdir")+"/FastNotePadConfig.fnp"));
out.writeObject(PathAndColorObject);
out.close();
// After save the file , Apply it into the program :
if(!PathField.getText().trim().equalsIgnoreCase("")){
PaintMainPanel.image=ImageIO.read(new File(PathField.getText()));
FastNotepadFrame.MainPanel.repaint();
    }//end if
else{
PaintMainPanel.image = ImageIO.read(getClass().getResource("/Images/MainBackGround.png"));
FastNotepadFrame.MainPanel.repaint();
}
FastNotepadFrame.contentLabel.setForeground(viewforegroundcolorForStatusBar.getForeground());
FastNotepadFrame.OperationsLabel.setForeground(viewforegroundcolorForStatusBar.getForeground());
FastNotepadFrame.linesAndColLabel.setForeground(viewforegroundcolorForStatusBar.getForeground());

// to set Color for title border
FastNotepadFrame.FontPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "إعدادات الخط", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13),viewforegroundcolorForTitles.getForeground())); // NOI18N
FastNotepadFrame.PostionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "مواقع النصوص", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13),viewforegroundcolorForTitles.getForeground())); // NOI18N
FastNotepadFrame.UndoAndRedoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "فعل", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13),viewforegroundcolorForTitles.getForeground())); // NOI18N


// Confirm Message .
JOptionPane.showMessageDialog(null,"تم حفظ الإعدادات التي قمت بها في مجلد الملفات المؤقتة , حذف الملف يعني العودة للإعدادات الإفتراضية !","رسالة", JOptionPane.INFORMATION_MESSAGE);
setVisible(false);

ViewPicLabel.setIcon(null);
PathField.setText("");
}//end try
catch(IIOException r){
JOptionPane.showMessageDialog(null,"الرجاء التأكد من مسار الصورة , او الصيغة ! : "+r, "رسالة خطأ",JOptionPane.ERROR_MESSAGE);
ViewPicLabel.setIcon(null);
PathField.setText("");
return;
}
catch(Exception e){
JOptionPane.showMessageDialog(null,"خطأ في عملية إضافة الصورة كخلفية للبرنامج :"+e, "رسالة خطأ",JOptionPane.ERROR_MESSAGE);
ViewPicLabel.setIcon(null);
PathField.setText("");
return;
}
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void BrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrowseButtonActionPerformed
    try{

    singleton.getchooserImages().addChoosableFileFilter(singleton.getImagesFileFiltersOject());
    singleton.getchooserImages().setFileFilter(singleton.getImagesFileFiltersOject());
    singleton.getchooserImages().setAccessory(singleton.getImagePreviewObject());
    singleton.getchooserImages().setFileView(singleton.getImageFileViewObject());
    int status = singleton.getchooserImages().showOpenDialog(this);

    if(status==JFileChooser.CANCEL_OPTION)
    return;

    else if(status == JFileChooser.APPROVE_OPTION)
         {
    File ImageFile = singleton.getchooserImages().getSelectedFile();
    PathField.setText(ImageFile.getAbsolutePath());
    Icon icon= new MyImageIcon(ImageFile.getAbsolutePath());
    ViewPicLabel.setIcon(icon);
         }// end if !

        }// end try box
     catch(Exception e)
     {
         JOptionPane.showMessageDialog(null,"خطأ في عملية إضافة الصورة , الرجاء  التأكد من الصيغ , الخطأ : "+e, "رسالة خطأ",JOptionPane.ERROR_MESSAGE);
         return;
        }
    }//GEN-LAST:event_BrowseButtonActionPerformed

    private void ViewPicButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewPicButtonActionPerformed
 try{
    Icon icon= new MyImageIcon(PathField.getText());
    ViewPicLabel.setIcon(icon);}
 catch(Exception e){
  JOptionPane.showMessageDialog(null,"خطأ في عملية إضافة الصورة , الرجاء  التأكد من الصيغ , الخطأ : "+e, "رسالة خطأ",JOptionPane.ERROR_MESSAGE);
  return;
 }//end catch
    }//GEN-LAST:event_ViewPicButtonActionPerformed

    private void ViewInProgramButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewInProgramButtonActionPerformed
try{
PaintMainPanel.image=ImageIO.read(new File(PathField.getText()));
FastNotepadFrame.MainPanel.repaint();
FastNotepadFrame.contentLabel.setForeground(viewforegroundcolorForStatusBar.getForeground());
FastNotepadFrame.OperationsLabel.setForeground(viewforegroundcolorForStatusBar.getForeground());
FastNotepadFrame.linesAndColLabel.setForeground(viewforegroundcolorForStatusBar.getForeground());
FastNotepadFrame.FontPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "dddd", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13),Color.RED)); // NOI18N

// Title Borders in frame
FastNotepadFrame.FontPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "إعدادات الخط", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13),viewforegroundcolorForTitles.getForeground())); // NOI18N
FastNotepadFrame.PostionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "مواقع النصوص", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13),viewforegroundcolorForTitles.getForeground())); // NOI18N
FastNotepadFrame.UndoAndRedoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "فعل", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13),viewforegroundcolorForTitles.getForeground())); // NOI18N

        }//end try
catch(IIOException r){
try{
PaintMainPanel.image = ImageIO.read(getClass().getResource("/Images/MainBackGround.png"));
FastNotepadFrame.MainPanel.repaint();
FastNotepadFrame.contentLabel.setForeground(viewforegroundcolorForStatusBar.getForeground());
FastNotepadFrame.OperationsLabel.setForeground(viewforegroundcolorForStatusBar.getForeground());
FastNotepadFrame.linesAndColLabel.setForeground(viewforegroundcolorForStatusBar.getForeground());
// title border in frame
FastNotepadFrame.FontPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "إعدادات الخط", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13),viewforegroundcolorForTitles.getForeground())); // NOI18N
FastNotepadFrame.PostionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "مواقع النصوص", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13),viewforegroundcolorForTitles.getForeground())); // NOI18N
FastNotepadFrame.UndoAndRedoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "فعل", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13),viewforegroundcolorForTitles.getForeground())); // NOI18N

    }
catch(Exception e){
return;
}
}
catch(Exception e){
JOptionPane.showMessageDialog(null,"خطأ في عملية إضافة الصورة كخلفية للبرنامج :"+e, "رسالة خطأ",JOptionPane.ERROR_MESSAGE);
return;
}
    }//GEN-LAST:event_ViewInProgramButtonActionPerformed

    private void DefaultConfigButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DefaultConfigButtonActionPerformed

try{
PathField.setText("");
PaintMainPanel.image = ImageIO.read(getClass().getResource("/Images/MainBackGround.png"));
FastNotepadFrame.MainPanel.repaint();
viewforegroundcolorForStatusBar.setForeground(Color.black);
viewforegroundcolorForTitles.setForeground(Color.black);
FastNotepadFrame.contentLabel.setForeground(Color.black);
FastNotepadFrame.OperationsLabel.setForeground(Color.black);
FastNotepadFrame.linesAndColLabel.setForeground(Color.black);

// to set default to tilte border to frame
FastNotepadFrame.FontPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "إعدادات الخط", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13),Color.black)); // NOI18N
FastNotepadFrame.PostionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "مواقع النصوص", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13),Color.black)); // NOI18N
FastNotepadFrame.UndoAndRedoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "فعل", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13),Color.black)); // NOI18N

    }

catch(Exception e){
JOptionPane.showMessageDialog(null,"خطأ في عملية إضافة الصورة كخلفية للبرنامج :"+e, "رسالة خطأ",JOptionPane.ERROR_MESSAGE);
return;
}
    }//GEN-LAST:event_DefaultConfigButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
 ViewPicLabel.setIcon(null);
 PathField.setText("");
    }//GEN-LAST:event_formWindowClosing

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
 ViewPicLabel.setIcon(null);
 PathField.setText("");
 setVisible(false);
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void ChooseForegroundForTitlesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChooseForegroundForTitlesActionPerformed
Color color = JColorChooser.showDialog(this, "اختر اللون : ", Color.cyan);
viewforegroundcolorForTitles.setForeground(color);
    }//GEN-LAST:event_ChooseForegroundForTitlesActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BrowseButton;
    private javax.swing.JButton ChooseForegroundForTitles;
    private javax.swing.JButton ChooseForegroundFroStatusBar;
    private javax.swing.JButton DefaultConfigButton;
    private javax.swing.JButton ExitButton;
    public static javax.swing.JTextField PathField;
    private javax.swing.JButton SaveButton;
    private javax.swing.JButton ViewInProgramButton;
    private javax.swing.JButton ViewPicButton;
    private javax.swing.JLabel ViewPicLabel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel viewforegroundcolorForStatusBar;
    private javax.swing.JLabel viewforegroundcolorForTitles;
    // End of variables declaration//GEN-END:variables

}
