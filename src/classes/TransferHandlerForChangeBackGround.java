/**
 * Author: Mohammad Mofeed AlBanna.
 * Web Developer
 * Website: www.MBanna.info
 * Blog: www.OutOfPalBox.net
 * Facebook: www.FB.com/MBanna.info
 */


package classes;

import MainPackage.ConfigTheProgram;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.TransferHandler;

public class TransferHandlerForChangeBackGround extends TransferHandler{

    public TransferHandlerForChangeBackGround(){

    }// end constructor ..

    @Override
    public boolean canImport(JComponent comp, DataFlavor[] transferFlavors){
          for(int i=0; i<transferFlavors.length; i++){
            if(transferFlavors[i].isFlavorJavaFileListType()){
            return true;
            }
        }
        return false;
    }// end if can import

    @Override
     public boolean importData(JComponent comp, Transferable t){
        try{
         if( t.isDataFlavorSupported(DataFlavor.javaFileListFlavor)){
             try{
          java.util.List list = (java.util.List) t.getTransferData(DataFlavor.javaFileListFlavor);
             if(list.get(0).toString().toLowerCase().endsWith(".jpg")||
                list.get(0).toString().toLowerCase().endsWith(".gif")||
                list.get(0).toString().toLowerCase().endsWith(".tiff")||
                list.get(0).toString().toLowerCase().endsWith(".tif")||
                list.get(0).toString().toLowerCase().endsWith(".jpeg")||
                list.get(0).toString().toLowerCase().endsWith(".png")){

                ConfigTheProgram.PathField.setText(list.get(0).toString());
           }
 else{// if this is not image ...
 JOptionPane.showMessageDialog(null,"الصيغ المدعومة : JPG,JPEG,GIF,TIFF,TIF,PNG", "رسالة تحذير", JOptionPane.WARNING_MESSAGE);
 }
  }//end try
             catch(Exception e){
             // do nothing
             }//end catch
             return true;
             }
 }//end try
        catch(Exception e){
    // do nothing
    }//end catch ...
         return false;
    }//end function import

}

