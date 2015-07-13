/**
 * Author: Mohammad Mofeed AlBanna.
 * Web Developer
 * Website: www.MBanna.info
 * Blog: www.OutOfPalBox.net
 * Facebook: www.FB.com/MBanna.info
 */


package classes;

import javax.swing.text.Style;
import MainPackage.FastNotepadFrame;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.LinkedList;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JViewport;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.StyleConstants;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyledDocument;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;


public class AllFunctions {

public static LinkedList<String> AllCharsetLinkedList=new LinkedList<String>();
public static LinkedList AlignNumber=new LinkedList();// to Store the constant of alignment ..
static LinkedList list=new LinkedList();// to save the Objects into files ..
//******************************************************************************
// This function to get The current ( Selected tab) TextPane
public static JTextPane getCurrentJTextPane(JTabbedPane MyTab){
try{
JPanel Currentpanel=(JPanel)(MyTab.getSelectedComponent());
JScrollPane scrollpane=(JScrollPane)Currentpanel.getComponent(0);
JViewport viewport=(JViewport)scrollpane.getComponent(0);
JTextPane CurrentPane=(JTextPane)viewport.getComponent(0);
return CurrentPane;
    }//end try
catch(Exception e){
// do nothing ...
return null;
}//end catch

}//end function getCurrentJTextPane();
//******************************************************************************
// This function to set hyper Link for JTextPane ..
public static void setHyperLink(final JTextPane pane){
pane.addHyperlinkListener(new HyperlinkListener() {
public void hyperlinkUpdate(HyperlinkEvent e) {
if (e.getEventType() ==HyperlinkEvent.EventType.ACTIVATED) {
{try{
Desktop desktop = Desktop.getDesktop();   
desktop.browse(e.getURL().toURI());
pane.setEditable(true);
    }
 catch(Exception ee){
// do nothing
 }
    }//end if
}
}
});
}// end function
//******************************************************************************
// For get from transferhandler ,
// need to convert from Reader to inputStream then convert inputstream to string .
 public static String convertStreamToString(InputStream is)throws IOException {
if (is != null) {
Writer writer = new StringWriter();

char[] buffer = new char[1024];
try {
Reader reader = new BufferedReader(
new InputStreamReader(is, "UTF-8"));
int n;
while ((n = reader.read(buffer)) != -1) {
writer.write(buffer, 0, n);
}
} finally {
is.close();
}
return writer.toString();
} else {
return "";
}
}// end method
//******************************************************************************
// Download Image form net ...
 public static void AddImage(final URL url,final JTextPane pane) {

       try{
            Image greenball = Toolkit.getDefaultToolkit().getImage(url);
           Icon icon=new MyImageIcon(greenball);
           pane.insertIcon(icon);
           FastNotepadFrame.OperationsLabel.setText("تم تحميل الصورة بنجاح !");
           
             }catch(Exception e){
              JOptionPane.showMessageDialog(null,"خطأ في تحميل الصورة , تأكد من : \n 1) إتصال بالإنترنت . \n 2) الرابط الالكتروني المُدرج . \n الحل : يمكنك نسخ الصورة ولصقها مباشرة ً في المستند .", "رسالة خطأ", JOptionPane.ERROR_MESSAGE);
              FastNotepadFrame.OperationsLabel.setText("فشل تحميل الصورة !");
              
             }
  


    }// end method ..
//******************************************************************************
// This Function To get the First X Button of tab to hide it or View it ...
public static JButton GetButtonOfFirstTab(){
    JPanel panel=(JPanel)FastNotepadFrame.MyTab.getTabComponentAt(0);
    JButton button=(JButton)panel.getComponent(0);
    return button;
 }
//******************************************************************************
//This Method to create Server Socket and listening..
// When get the path it will open it in new tab ....
public static void createSocketServer(){
new Thread(){@Override
public void run(){
 try{
ServerSocket myserver=new ServerSocket(9547);
while(true)
{
Socket socket= myserver.accept();
try{
 DataInputStream input =new DataInputStream(socket.getInputStream());
 String thePath = input.readUTF();
 File selectedFile=new File(thePath);
 if(selectedFile.toString().toLowerCase().endsWith(".fnp"))
 FastNotepadFrame.DefaultFastNotepadFrameObject.OpentFNPFiles(selectedFile);
 else if (selectedFile.toString().toLowerCase().endsWith(".html"))
 FastNotepadFrame.DefaultFastNotepadFrameObject.OpenHTMLFiles(selectedFile);
 else if(selectedFile.toString().toLowerCase().endsWith(".jpg")||
 selectedFile.toString().toLowerCase().endsWith(".gif")||
 selectedFile.toString().toLowerCase().endsWith(".tiff")||
 selectedFile.toString().toLowerCase().endsWith(".jpeg")||
 selectedFile.toString().toLowerCase().endsWith(".tif")||
 selectedFile.toString().toLowerCase().endsWith(".png"))
 FastNotepadFrame.DefaultFastNotepadFrameObject.OpenImageFiles(selectedFile);
 else
 FastNotepadFrame.DefaultFastNotepadFrameObject.OpenOtherFilesFile(selectedFile);
 }//end try block
catch(Exception e)
  {
// do nothing
 }//end catch

}// end while loop

}// end try

 catch(Exception e){
// do nothing
}//end catch
}}.start();


  }// end method
//******************************************************************************
// This method to send path to server if the socket not created ,
// That mean this is the First Program ...then create socket
public static void CheckAndSendPathToServer(final String thePath){

try{
Socket checkChannel=new Socket("127.0.0.1",9547);
// Just For Check the Connection ..
DataOutputStream out =new DataOutputStream(checkChannel.getOutputStream());
out.writeUTF(thePath);
checkChannel.close();
}catch(Exception e)
{
// That mean this is first time for running program
SwingUtilities.invokeLater(new Runnable(){
public void run(){
FastNotepadFrame.DefaultFastNotepadFrameObject=new FastNotepadFrame(new File(thePath));
FastNotepadFrame.DefaultFastNotepadFrameObject.setVisible(true);
createSocketServer();
}});

}//end catch


}//end function ....
//******************************************************************************
public static String replaceAllWords(String original, String find, String replacement) {
     String result = "";
     String delimiters = "\n";
     StringTokenizer st = new StringTokenizer(original, delimiters,true);

    while (st.hasMoreTokens()) {
        String w = st.nextToken();
        if (w.trim().equalsIgnoreCase(find)) {
            result = result + replacement;
        } else {
            result = result + w;
        }
    }
    return result;
}

//******************************************************************************
public static String replaceAllWordsWithCaseSensetive(String original, String find, String replacement) {
    String result = "";
     String delimiters = "\n";
    StringTokenizer st = new StringTokenizer(original, delimiters,true);
 
    while (st.hasMoreTokens()) {
        String w = st.nextToken();
        if (w.trim().equals(find)) {
            result = result + replacement;
        } else {
            result = result + w;
        }
    }
    return result;
}

//******************************************************************************
public static String replaceAllWordsForGlobalText(String original, String find, String replacement) {
    String result = "";
     String delimiters = " ";
     StringTokenizer st = new StringTokenizer(original, delimiters,true);

    while (st.hasMoreTokens()) {
        String w = st.nextToken();
        if (w.trim().equalsIgnoreCase(find)) {
            result = result + replacement;
        } else {
            result = result + w;
        }
    }
    return result;
}

//******************************************************************************
public static String replaceAllWordsWithCaseSensetiveForGlobalText(String original, String find, String replacement) {
    String result = "";
     String delimiters = " ";
    StringTokenizer st = new StringTokenizer(original, delimiters,true);

    while (st.hasMoreTokens()) {
        String w = st.nextToken();
        if (w.trim().equals(find)) {
            result = result + replacement;
        } else {
            result = result + w;
        }
    }
    return result;
}// end function ....
//******************************************************************************
// to Save the Content of JTextPane
public static void SaveContentOfJTextPane(final JTextPane pane,final String thePathOfFile){
SwingUtilities.invokeLater(new Runnable(){
public void run(){
ObjectOutputStream out=null;
pane.requestFocusInWindow();
list.clear();
try{
out=new ObjectOutputStream(new FileOutputStream(thePathOfFile));
    }//end try
catch(Exception e){
JOptionPane.showMessageDialog(null,"خطأ في حفظ الملف .. الرجاء المحاولة لاحقا ًمع تصحيح الخطأ :"+e,"رسالة خطأ",JOptionPane.ERROR_MESSAGE);
// do nothing
}// end catch ....

for (int i=0; i<pane.getStyledDocument().getLength(); i++)
{
Element element =pane.getStyledDocument().getCharacterElement(i);
AttributeSet attributeSet = element.getAttributes();
Icon ico=StyleConstants.getIcon(attributeSet);
try
{
Character characte=element.getDocument().getText(i,1).toCharArray()[0];
ContentOfJTextPane con=new ContentOfJTextPane();
if(characte=='\n'){
con.setCharacter('\n');
Element elemente = pane.getStyledDocument().getCharacterElement(i+1);// to get the Align Number
con.setAlignment(StyleConstants.getAlignment(elemente.getAttributes()));// to save it
}// end if its new line ..
else if(characte==' ')
con.setCharacter(' ');
else
con.setCharacter(characte);

con.setTheFont(StyleConstants.getFontFamily(attributeSet));
con.setTextColor(StyleConstants.getForeground(attributeSet));
con.setTextBGColor(StyleConstants.getBackground(attributeSet));
con.setTheSize(StyleConstants.getFontSize(attributeSet));
con.setIsBold(StyleConstants.isBold(attributeSet));
con.setIsItalic(StyleConstants.isItalic(attributeSet));
con.setIsUnderLing(StyleConstants.isUnderline(attributeSet));
if(i==0)
{con.setAlignment(StyleConstants.getAlignment(attributeSet));}// end if this is First Line .

con.setIcon(ico);
list.add(con);
}// end try catch...

catch (Exception exc){
// do nothing
}//end catch
}// end for loop
  try{
out.writeObject(list);
out.close();
    }// end try if can't write object or close Session ..
catch(Exception e){
JOptionPane.showMessageDialog(null,"خطأ في حفظ الملف .. الرجاء المحاولة لاحقا ًمع تصحيح الخطأ :"+e,"رسالة خطأ",JOptionPane.ERROR_MESSAGE);
// do nothing
}// end catch ...


}//end run
});

}// end function
//******************************************************************************
// to Save the Content of JTextPane
public static void SaveContentOfJTextPane(final JTextPane pane,final File thePathOfFile){

SwingUtilities.invokeLater(new Runnable(){
public void run(){
ObjectOutputStream out=null;
pane.requestFocusInWindow();
list.clear();
try{
out=new ObjectOutputStream(new FileOutputStream(thePathOfFile));
    }//end try
catch(Exception e){
JOptionPane.showMessageDialog(null,"خطأ في حفظ الملف .. الرجاء المحاولة لاحقا ًمع تصحيح الخطأ :"+e,"رسالة خطأ",JOptionPane.ERROR_MESSAGE);
// do nothing
}// end catch box

for (int i=0; i<pane.getStyledDocument().getLength(); i++)
{
Element element =pane.getStyledDocument().getCharacterElement(i);
AttributeSet attributeSet = element.getAttributes();
Icon ico=StyleConstants.getIcon(attributeSet);
try
{
Character characte=element.getDocument().getText(i,1).toCharArray()[0];
ContentOfJTextPane con=new ContentOfJTextPane();
if(characte=='\n'){
con.setCharacter('\n');
Element elemente = pane.getStyledDocument().getCharacterElement(i+1);// to get the Align Number
con.setAlignment(StyleConstants.getAlignment(elemente.getAttributes()));// to save it
}// end if this is new line ..
else if(characte==' ')
con.setCharacter(' ');
else
con.setCharacter(characte);

con.setTheFont(StyleConstants.getFontFamily(attributeSet));
con.setTextColor(StyleConstants.getForeground(attributeSet));
con.setTextBGColor(StyleConstants.getBackground(attributeSet));
con.setTheSize(StyleConstants.getFontSize(attributeSet));
con.setIsBold(StyleConstants.isBold(attributeSet));
con.setIsItalic(StyleConstants.isItalic(attributeSet));
con.setIsUnderLing(StyleConstants.isUnderline(attributeSet));
if(i==0)
{con.setAlignment(StyleConstants.getAlignment(attributeSet));}// end if First Line

con.setIcon(ico);
list.add(con);
}

catch (Exception exc)
{
// do nothing
}

}
  try{
out.writeObject(list);
out.close();
    }// end try
catch(Exception e){
JOptionPane.showMessageDialog(null,"خطأ في حفظ الملف .. الرجاء المحاولة لاحقا ًمع تصحيح الخطأ :"+e,"رسالة خطأ",JOptionPane.ERROR_MESSAGE);
// do nothing
    }// end catch
}
});
}// end function ..
//******************************************************************************
// to read the content of FNP file and put it to JTextPane..
public synchronized static void ReadFromFileToJTextPane(final JTextPane pane,final File thePathOfFile){

SwingWorker worker=new SwingWorker() {
public Void doInBackground(){
// to Prevent Freezing
SwingUtilities.invokeLater(new Runnable(){
public void run(){
Thread readFNPThread=new Thread(){
@Override
public void run(){
 try{
AlignNumber.clear();
pane.requestFocusInWindow();
ObjectInputStream in=new ObjectInputStream(new FileInputStream(thePathOfFile));
LinkedList list=new LinkedList();// to list all ContentOfJTextPane objects
list=(LinkedList)in.readObject();


for(int x=0;x<list.size();x++){
        ContentOfJTextPane ic=(ContentOfJTextPane)list.get(x);
        Style baseStyle = pane.getStyledDocument().addStyle("base",null);
        StyleConstants.setFontFamily(baseStyle,ic.getTheFont());
        Color BG=ic.getTextBGColor();
        if(BG.equals(Color.black))
        StyleConstants.setBackground(baseStyle,Color.white);
        else
        StyleConstants.setBackground(baseStyle,BG);

        StyleConstants.setFontSize(baseStyle, ic.getTheSize());
        StyleConstants.setForeground(baseStyle,ic.getTextColor());
        StyleConstants.setBold(baseStyle, ic.isIsBold());
        StyleConstants.setItalic(baseStyle, ic.isIsItalic());
        StyleConstants.setUnderline(baseStyle, ic.isIsUnderLing());
        String character=ic.getCharacter().toString();
        if(character.equals("\n")||x==0)
        {
        AlignNumber.add(ic.getAlignment());
        }

        Icon icon=ic.getIcon();
        if(icon!=null)
       {   pane.setCaretPosition(pane.getDocument().getLength());
           pane.insertIcon(icon);
       }
        pane.getDocument().insertString(pane.getDocument().getLength(),character,baseStyle);
}// end for loop
setAlign(pane,AlignNumber);
FastNotepadFrame.linesAndColLabel.setText(" أحرف : "+pane.getText().length()+"/ أسطر : "+pane.getText().split("\n").length);
in.close();
}//end try
catch(Exception e){
// do nothing
}//end catch
}
};

readFNPThread.start();
try{
readFNPThread.join();
}catch(Exception e){
// do nothing
}

}});// end invoke later ...

return null;
}// end do in back ground ..

@Override
public void done(){
singleton.getReadingFileObject().setVisible(false);
FastNotepadFrame.UndoAndRedo.setJTextPane(pane);
}
};

worker.execute();

}// end method
//******************************************************************************
// to read the content of Help file && Shapes and Symbols and put it to JTextPane..
public synchronized static void ReadFromFileToJTextPane(final JTextPane pane,final InputStream thePathOfFile)throws Exception{

SwingWorker worker=new SwingWorker(){
public Void doInBackground(){
// to Prevent Freezing
SwingUtilities.invokeLater(new Runnable(){
public void run(){

Thread readHelpAndSymbol=new Thread(){
@Override
public void run(){
 try{

AlignNumber.clear();
pane.requestFocusInWindow();
ObjectInputStream in=new ObjectInputStream(thePathOfFile);
LinkedList list=new LinkedList();// to list all ContentOfJTextPane objects
list=(LinkedList)in.readObject();


for(int x=0;x<list.size();x++){
        ContentOfJTextPane ic=(ContentOfJTextPane)list.get(x);
        Style baseStyle = pane.getStyledDocument().addStyle("base",null);
        StyleConstants.setFontFamily(baseStyle,ic.getTheFont());
        Color BG=ic.getTextBGColor();
        if(BG.equals(Color.black))
        StyleConstants.setBackground(baseStyle,Color.white);
        else
        StyleConstants.setBackground(baseStyle,BG);

        StyleConstants.setFontSize(baseStyle, ic.getTheSize());
        StyleConstants.setForeground(baseStyle,ic.getTextColor());
        StyleConstants.setBold(baseStyle, ic.isIsBold());
        StyleConstants.setItalic(baseStyle, ic.isIsItalic());
        StyleConstants.setUnderline(baseStyle, ic.isIsUnderLing());
        String character=ic.getCharacter().toString();
        if(character.equals("\n")||x==0)
        {
        AlignNumber.add(ic.getAlignment());
        }

        Icon icon=ic.getIcon();
        if(icon!=null)
       {   pane.setCaretPosition(pane.getDocument().getLength());
           pane.insertIcon(icon);
       }
        pane.getDocument().insertString(pane.getDocument().getLength(),character,baseStyle);
}// end for loop
setAlign(pane,AlignNumber);
FastNotepadFrame.linesAndColLabel.setText(" أحرف : "+pane.getText().length()+"/ أسطر : "+pane.getText().split("\n").length);
in.close();
}//end try
catch(Exception e){
// do nothing
}//end catch
}
};

readHelpAndSymbol.start();
try{
readHelpAndSymbol.join();
}catch(Exception e){
// do nothing
}

}});// end invoke later
return null;
}// end do In back ground

@Override
public void done(){
singleton.getReadingFileObject().setVisible(false);
FastNotepadFrame.UndoAndRedo.setJTextPane(pane);
}//end done
};

 worker.execute();

}// end function ..
//******************************************************************************
// This function to set Alignment ..
public static void setAlign(JTextPane pane,LinkedList AlignNumber){
try{
int PositionOfNewLine=0;
for(int x=0;x<pane.getText().split("\n").length;x++){
    Style baseStyle=pane.getStyledDocument().addStyle("base",null);
    StyleConstants.setAlignment(baseStyle,(Integer)AlignNumber.get(x));
    pane.getStyledDocument().setParagraphAttributes(PositionOfNewLine,pane.getText().split("\n")[x].length(), baseStyle, true);
    PositionOfNewLine=PositionOfNewLine+pane.getText().split("\n")[x].length()+1;
}//end for loop
pane.setCaretPosition(0);
  }//end try box

catch(Exception e){
// do nothing
}

}//end Function ..
//******************************************************************************
// This function to read Others files with another encoding ..
public static void ReadOtherFilesWithEncoding(final JTextPane pane,final File thePathFile,final String Encoding){
Thread readOtherFiles=new Thread(){
@Override
public void run(){
try{
        if(thePathFile.toString().equals("null"))
        {
        JOptionPane.showMessageDialog(null,"لا يوجد مسار لملف ليتم تحديد ترميز له!","رسالة خطأ",JOptionPane.ERROR_MESSAGE);
        return;
        }//end if the path is null
        pane.setText("");
        StyledDocument doc=new DefaultStyledDocument();
        pane.setStyledDocument (doc);
        Reader fin = new InputStreamReader(new FileInputStream(thePathFile),Encoding);
        BufferedReader br = new BufferedReader(fin);
        char buffer[] = new char[1000];
        int len;
        while ((len = br.read (buffer, 0, buffer.length)) != -1) {
        // Insert into pane
        doc.insertString(doc.getLength(),new String (buffer, 0, len), null);}// end while
        fin.close();
        br.close();
        FastNotepadFrame.linesAndColLabel.setText(" أحرف : "+pane.getText().length()+"/ أسطر : "+pane.getText().split("\n").length);
}//end try
catch(Exception e){
//do nothing
}//end catch box
}};
readOtherFiles.start();
try{
readOtherFiles.join();
}catch(Exception e){
// do nothing
    }
}//end function
//******************************************************************************
// This function to read HTML files with another encoding ..
public static void ReadHTMLFilesWithEncoding(final JTextPane pane,final File thePathFile,final String Encoding){

Thread readHTML=new Thread(){
@Override
public void run(){
    try{

        if(thePathFile.toString().equals("null"))
        {
        JOptionPane.showMessageDialog(null,"لا يوجد مسار لملف ليتم تحديد ترميز له!","رسالة خطأ",JOptionPane.ERROR_MESSAGE);
        return;
        }//end if the path is null
        pane.setText("");
        Reader fin = new InputStreamReader(new FileInputStream(thePathFile),Encoding);
        BufferedReader br = new BufferedReader (fin);
        String alltext="";
        String line;
        while((line=br.readLine())!=null)
        {  alltext=alltext+line;
        }
        // Insert Text to The Text Pane Content Text/HTML
        pane.setText(alltext);
        fin.close();
        br.close();
        FastNotepadFrame.linesAndColLabel.setText(" أحرف : "+pane.getText().length()+"/ أسطر : "+pane.getText().split("\n").length);

}//end try
catch(Exception e){
// do nothing
}//end catch box
}};
readHTML.start();
try{
readHTML.join();
}catch(Exception e){
//do nothing
}
}//end function
//******************************************************************************

public static void AutoHelp(final String[] help,final JLabel OperationLabel){
new Thread(){@Override
public void run(){
try{
OperationLabel.setText("أهلا ً بكم في برنامج Fast NotePad بإصداره الثالث..سيتم بدأ المساعدة الآلية بعد 20 ثانية..");
Thread.sleep(20000);
int x=0;
while(true){
OperationLabel.setText(help[x]);
Thread.sleep(20000);
x++;
if(x==help.length)
x=0;
    }//end while loop
}
catch(Exception e){
// do nothing
return;
}
}}.start();// end thread

}//end function
public static String[] Help={  "لفتح لسان جديد CTRL + N"
,"لتغيير الخلفية وخصائص اخرى للبرنامج يتم ذلك من خلال : تحرير -> الإعدادات الشكلية ."
,"لفتح ملف جديد اما صورة او ملفات اخرى , من خلال , ملف -> فتح ملف او بالضغط على CTRL + O"
         ,"تم تفعيل خاصية السحب والإفلات, اي يمكن للمستخدم سحب ملف وسيتم قرائته , او سحب صورة وسيتم إضافتها في المستندات العادية"
          ,"تتم عملية قراءة الخطوط من مجلد FONTS الموجود في نظام التشغيل , سيتم قراءة الخطوط الجديدة في المجلد ايضا ً."
         ,"يمكن للمستخدم طباعة محتويات اللسان من خلال الضغط على زر CTRL+P او من قائمة ملف ومن ثم طباعة "
         ,"عملية النسخ في اي مستند سيتم نسخ ايضا ً شكل النص او الصورة , تم تمكين نسخ الصورة ولصقها مباشرة في المستندات العادية."
         ,"لبدء عملية البحث عن النصوص من خلال الضغط على CTRL + F او من خلال قائمة تحرير-> بحث "
        ,"لإدراج صورة من موقع ويب من خلال قائمة إدراج->إدراج صورة من الإنترنت ,او نسخ الصورة ولصقها مباشرة ."
         ,"في مستندات HTML يمكن إضافة رابط الكتروني من خلال إدراج -> إدراج رابط في مستند HTML ومن ثم أدخل الرابط ووصفه ."
         ,"لتفعيل الرابط الالكتروني والانتقال المباشر للرابط من خلال CTRL + زر الماوس الايسر ,لفتح الرابط مباشرة على المتصفح."
          ,"في المستندات الداعمة للــ HTML يمكن فتح محررة HTML بحيث يمكن تحرير النصوص البرمجية مباشرة ."
           ,"يمكن ادراج رموز واشكال خاصة بالضغط على ctrl+Q او من خلال ادراج -> ادراج رموز واشكال ."
,"يمكن تكبير الخط بعد تحديد النص من خلال ctrl+Equals او تصغيره من خلال ctrl + Minus"
,"يمكن التراجع عن التغيرات التي جرت على المستند بالضغط على ctrl+z او التقدم عن هذا التراجع بالضغط على ctrl+y."
,"يمكن نسخ محتويات ملفات Office ولصقها على مستندات تدعم HTML لان محتويات النص المنسوخ عبارة عن HTML ."
,"يمكن متابعة المزيد من خلال المساعدة , بالضغط على حول -> مساعدة ."


};


//******************************************************************************
// This function to check if the file of Fast Note Pad config is Exists or not
// if is exists read it and put the background and foregrounds ..
public static void CheckFastNotePadConfig(){
File theConfigFile=new File(System.getProperty("java.io.tmpdir")+"/FastNotePadConfig.fnp");
if(theConfigFile.exists()){
try{
ObjectInputStream read=new ObjectInputStream(new FileInputStream(System.getProperty("java.io.tmpdir")+"/FastNotePadConfig.fnp"));
ConfigFile PathAndColorObject=(ConfigFile)read.readObject();
String thePathIs=PathAndColorObject.getThePath();
if(thePathIs.trim().equalsIgnoreCase(""))
PaintMainPanel.image = ImageIO.read(ClassLoader.getSystemClassLoader().getClass().getResource("/Images/MainBackGround.png"));
else
PaintMainPanel.image=ImageIO.read(new File(thePathIs));
FastNotepadFrame.MainPanel.repaint();
FastNotepadFrame.contentLabel.setForeground(PathAndColorObject.getStatusBarForegroundColor());
FastNotepadFrame.OperationsLabel.setForeground(PathAndColorObject.getStatusBarForegroundColor());
FastNotepadFrame.linesAndColLabel.setForeground(PathAndColorObject.getStatusBarForegroundColor());

// To set the color for title borders
FastNotepadFrame.FontPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "إعدادات الخط", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13),PathAndColorObject.getTitleBarForegroundColor())); // NOI18N
FastNotepadFrame.PostionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "مواقع النصوص", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13),PathAndColorObject.getTitleBarForegroundColor())); // NOI18N
FastNotepadFrame.UndoAndRedoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "فعل", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13),PathAndColorObject.getTitleBarForegroundColor())); // NOI18N

read.close();
}//end try
catch(Exception e){
try{
PaintMainPanel.image = ImageIO.read(ClassLoader.getSystemClassLoader().getClass().getResource("/Images/MainBackGround.png"));
FastNotepadFrame.MainPanel.repaint();
    }//end try
catch(Exception e2){
JOptionPane.showMessageDialog(null,"خطأ في إيجاد صورة الخلفية الأساسية للبرنامج , قد يساعد إعادة تحميل التطبيق في حل المشكلة : "+e, "رسالة خطأ",JOptionPane.ERROR_MESSAGE);
// do nothing
}
// do nothing
}
}//end if the file is exist 
}//end function


//******************************************************************************
// This Function to remove the black background from image when copy - paste it .
public static Image makeColorTransparent(BufferedImage im, final Color color) {
    ImageFilter filter = new RGBImageFilter() {
      // the color we are looking for... Alpha bits are set to opaque
      public int markerRGB = color.getRGB() | 0xFF000000;

      @Override
      public final int filterRGB(int x, int y, int rgb) {
      if ((rgb | 0xFF000000) == markerRGB) {
          // Mark the alpha bits as zero - transparent
          return 0x00FFFFFF & rgb;

       } else {
           //nothing to do
           return rgb;
          }
      }
    };

    ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
    return Toolkit.getDefaultToolkit().createImage(ip);
  }

}// end class ....