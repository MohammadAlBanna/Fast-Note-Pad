/**
 * Author: Mohammad Mofeed AlBanna.
 * Web Developer
 * Website: www.MBanna.info
 * Blog: www.OutOfPalBox.net
 * Facebook: www.FB.com/MBanna.info
 */


package classes;
import MainPackage.FastNotepadFrame;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.TransferHandler;
import javax.swing.JTextPane;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Element;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;


//END OF THE CLASS StringTransferHandler
public class JTextPaneTransferHandler extends TransferHandler{

    public JTextPaneTransferHandler(){
 
    }// end constructor ..

    @Override
    public boolean canImport(JComponent comp, DataFlavor[] transferFlavors){
        JTextPaneSelection s = new JTextPaneSelection(""); //Dummy object
        boolean retour = false;
        for(int i=0; i<transferFlavors.length; i++){
            if(s.isDataFlavorSupported(transferFlavors[i])||transferFlavors[i].isFlavorJavaFileListType()){
                retour = true;
            }
        }
        return retour;
    }

    @Override
    protected Transferable createTransferable(JComponent c){
        JTextPane aTextPane = (JTextPane)c;
        int start = aTextPane.getSelectionStart();
        int end = aTextPane.getSelectionEnd();
        StyledDocument aSDoc = aTextPane.getStyledDocument();
        DefaultStyledDocument dSDocSelection = copyDocument(aSDoc, start, end);
        return (new JTextPaneSelection(dSDocSelection));
    }

    public static DefaultStyledDocument copyDocument(StyledDocument src, int selectionStart, int selectionEnd) {
        Element rootElement, paragraphElement, textElement;
        SimpleAttributeSet copyAttrs;
        int startOffset, endOffset;
        String copy_string;

        rootElement = src.getDefaultRootElement();
        DefaultStyledDocument copyDoc = new DefaultStyledDocument();

        for (int lpParagraph=0; lpParagraph<rootElement.getElementCount(); lpParagraph++){
            paragraphElement = rootElement.getElement(lpParagraph);

            //Check if the paragraph need to be copy
            if(paragraphElement.getEndOffset() < selectionStart){
                continue; //Go to the next paragraph
            }
            if(paragraphElement.getStartOffset() > selectionEnd){
                break; //Exit the boucle
            }

            for (int lpText=0; lpText<paragraphElement.getElementCount(); lpText++) {
                textElement = paragraphElement.getElement(lpText);

                //Check if the Element need to be copy
                if(textElement.getEndOffset() < selectionStart){
                    continue; //Go to the next Element
                }
                if(textElement.getStartOffset() > selectionEnd){
                    break; //Exit the boucle
                }

                copyAttrs = new SimpleAttributeSet(textElement.getAttributes());

                //Find the value of startOffset and endOffset
                if(textElement.getStartOffset() < selectionStart){
                    startOffset = selectionStart;
                }else{
                    startOffset = textElement.getStartOffset();
                }
                if(textElement.getEndOffset() > selectionEnd){
                    endOffset = selectionEnd;
                }else{
                    endOffset = textElement.getEndOffset();
                }

                try{
                    copy_string = src.getText(startOffset, (endOffset-startOffset));
                    copyDoc.insertString(copyDoc.getLength(), copy_string, copyAttrs);
                }catch (BadLocationException e){
   // do nothing
                }
            }
            //Modify the Style of the paragraph
            copyAttrs = new SimpleAttributeSet(paragraphElement.getAttributes());
            startOffset = paragraphElement.getStartOffset();
            endOffset = paragraphElement.getEndOffset();
            copyDoc.setParagraphAttributes(startOffset, (endOffset-startOffset), copyAttrs, true);
        }

        return copyDoc;
    }

    @Override
    public void exportToClipboard(JComponent comp, Clipboard clip, int action) {
        super.exportToClipboard(comp, clip, action);
    }

    @Override
    public int getSourceActions(JComponent c) {
        return COPY_OR_MOVE;
    }

    @Override
    protected void exportDone(JComponent source, Transferable data, int action){
        JTextPane srcTextPane = (JTextPane)source;
        if(action == MOVE){
            srcTextPane.replaceSelection("");
        }
    }

    @Override
    public boolean importData(JComponent comp, Transferable t){
     try{
     if(canImport(comp, t.getTransferDataFlavors())){

            if(t.isDataFlavorSupported(JTextPaneSelection.DSDocFlavor)){
                JTextPane theTextPane = (JTextPane)comp;
                theTextPane.replaceSelection("");
                StyledDocument theSDoc = new DefaultStyledDocument();
                try{
                    theSDoc = (StyledDocument)t.getTransferData(JTextPaneSelection.DSDocFlavor);
                }catch(Exception e){

                }
                int thePos = theTextPane.getCaretPosition();
                insertDocument(theSDoc, thePos, theTextPane);
                return true;

            }
 // else if this is file Or Image it will read it =))))) By Alpha ...
 else if(t.isDataFlavorSupported(DataFlavor.javaFileListFlavor)&&FastNotepadFrame.DefaultFastNotepadFrameObject!=null){
 try{
    java.util.List list = (java.util.List) t.getTransferData(DataFlavor.javaFileListFlavor);
        if(list.get(0).toString().toLowerCase().endsWith(".fnp"))
        FastNotepadFrame.DefaultFastNotepadFrameObject.OpentFNPFiles(new File(list.get(0).toString()));
        else if (list.get(0).toString().toLowerCase().endsWith(".html"))
        FastNotepadFrame.DefaultFastNotepadFrameObject.OpenHTMLFiles(new File(list.get(0).toString()));
        else if(list.get(0).toString().toLowerCase().endsWith(".jpg")||
                list.get(0).toString().toLowerCase().endsWith(".gif")||
                list.get(0).toString().toLowerCase().endsWith(".tiff")||
                list.get(0).toString().toLowerCase().endsWith(".tif")||
                list.get(0).toString().toLowerCase().endsWith(".jpeg")||
                list.get(0).toString().toLowerCase().endsWith(".png"))

                {
         
        // if it is the HTML document
         if(FastNotepadFrame.TheCurrentPane.getContentType().endsWith("text/html"))
         {
         JOptionPane.showMessageDialog(null,"لا يمكن إضافة الصورة بشكل مباشر في مستندات HTML الا من خلال رابط الكتروني لها!","رسالة تحذير",JOptionPane.WARNING_MESSAGE);
         }//end if this is html document ..
         else{
         Icon icon= new MyImageIcon(list.get(0).toString());
         FastNotepadFrame.TheCurrentPane.insertIcon(icon);
             }//end else this is text/plain document
 }
        // else this is'nt known extension ..
        else
        FastNotepadFrame.DefaultFastNotepadFrameObject.OpenOtherFilesFile(new File(list.get(0).toString()));

    }//end try box
    catch(Exception e){
   // Do Nothing
    }
 }//end if this is file


            else {
                String textString = "";
                try{
                    textString = (String)t.getTransferData(DataFlavor.stringFlavor);
                    JTextPane aTextPane = (JTextPane)comp;
                    aTextPane.replaceSelection(textString);
                }catch(Exception e){
 //do nothing
                }
                return true;
            }
 }// end if can import ..

       }catch(Exception e){
         //do nothing         
     }//end catch 
     //****************
        return false;

    }//end function import data


    //Insert a Document in a another Document
    public static void insertDocument(StyledDocument srcSDoc, int srcPos, JTextPane theTextPane){
        StyledDocument theSDoc = theTextPane.getStyledDocument();
        Element rootElement, paragraphElement, textElement;
        SimpleAttributeSet copyAttrs;
        int startOffset, endOffset;
        int pos = srcPos;
        String copy_string;

        rootElement = srcSDoc.getDefaultRootElement();

        for (int lpParagraph=0; lpParagraph<rootElement.getElementCount(); lpParagraph++){
            paragraphElement = rootElement.getElement(lpParagraph);

            for (int lpText=0; lpText<paragraphElement.getElementCount(); lpText++) {
                textElement = paragraphElement.getElement(lpText);
                copyAttrs = new SimpleAttributeSet(textElement.getAttributes());
                startOffset = textElement.getStartOffset();
                endOffset = textElement.getEndOffset();
                //A Verifier
                try{
                    copy_string = srcSDoc.getText(startOffset, (endOffset-startOffset));
                    theSDoc.insertString(pos, copy_string, copyAttrs);
                }catch (BadLocationException e){
              // do nothing
                }
                pos += endOffset-startOffset;
            }
            //Modify the Style of the paragraph
            copyAttrs = new SimpleAttributeSet(paragraphElement.getAttributes());
            startOffset = paragraphElement.getStartOffset();
            endOffset = paragraphElement.getEndOffset();

            theSDoc.setParagraphAttributes(startOffset, (endOffset-startOffset), copyAttrs, true);
        }
        try{
            theSDoc.remove(pos-1, 1);
        }catch(BadLocationException e){
        // do nothing
        }
    }


}
    class JTextPaneSelection implements Transferable, ClipboardOwner{
    private String dataString;
    private DefaultStyledDocument dataDoc;
    public static DataFlavor DSDocFlavor = new DataFlavor(DefaultStyledDocument.class, "DSDocFlavor");
    private DataFlavor [] supportedFlavors = {DSDocFlavor, DataFlavor.stringFlavor};

    //Usefull for Dummy StringTransferSelection Object
    public JTextPaneSelection(String dataString){
        this.dataString = dataString;
    }

    public JTextPaneSelection(DefaultStyledDocument dataDoc){
        this.dataDoc = dataDoc;
        try{
            dataString = dataDoc.getText(0, dataDoc.getLength());
        }catch(BadLocationException e){
            //It won't happen
        }
    }

    public DataFlavor[] getTransferDataFlavors(){
        return supportedFlavors;
    }

    public boolean isDataFlavorSupported(DataFlavor flavor){
        if(flavor.equals(DataFlavor.stringFlavor)){
            return true;
        }
        if(flavor.equals(DSDocFlavor)){
            return true;
        }
        return false;
    }

    //Throw a weird exception if the part with DataFlavor.stringFlavor is not there (FIX)
    //When you create the Transferable the method getTransferDataFlavors is called
    //then getTransferData is called for every type in supportedFlavors
    //It must be some inner working of the Clipboard
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException{
        if(flavor.equals(DataFlavor.stringFlavor)){
            return dataString;
        }else if(flavor.equals(DSDocFlavor)){
            return dataDoc;
        }else{
            throw new UnsupportedFlavorException(flavor);
        }
    }

    public void lostOwnership(Clipboard clipboard, Transferable contents){

    }
}

