/**
 * Author: Mohammad Mofeed AlBanna.
 * Web Developer
 * Website: www.MBanna.info
 * Blog: www.OutOfPalBox.net
 * Facebook: www.FB.com/MBanna.info
 */

package classes;

import javax.swing.text.Document;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

class RmCommentHTMLDocument extends HTMLDocument {

@Override
public HTMLEditorKit.ParserCallback getReader(int pos) {
return new RmCommentReader(pos);
}

private class RmCommentReader extends HTMLDocument.HTMLReader {

public RmCommentReader(int pos) {
super(pos);
}

@Override
public void handleComment(char[] data, int pos) {
// do nothing when comment is found
// default behavior seems to be to create
// a view box
// System.out.println("found comment: " + String.valueOf(data));
}
}
}

  public class MyEditorKit extends HTMLEditorKit {
@Override
public Document createDefaultDocument() {
return new RmCommentHTMLDocument();
}
}