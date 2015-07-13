/**
 * Author: Mohammad Mofeed AlBanna.
 * Web Developer
 * Website: www.MBanna.info
 * Blog: www.OutOfPalBox.net
 * Facebook: www.FB.com/MBanna.info
 */


//This CLass to convert Reader to inputStream then convert inputstream to string .
package classes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.Reader;

public class ReaderToInputStream extends InputStream {
     
    private Reader reader;
    private PipedOutputStream pos;
    private PipedInputStream pis;
    private OutputStreamWriter osw;


    public ReaderToInputStream(Reader reader) throws IOException {
        this.reader = reader;
        pos = new PipedOutputStream();
        pis = new PipedInputStream(pos);
        osw = new OutputStreamWriter(pos);
    }


    public ReaderToInputStream(Reader reader, String encoding)
    throws IOException {
        this.reader = reader;
        pos = new PipedOutputStream();
        pis = new PipedInputStream(pos);
        osw = new OutputStreamWriter(pos, encoding);
    }

    public int read() throws IOException {
        if (pis.available() > 0) {
            return pis.read();
        }

        int c = reader.read();

        if (c == -1) {
            return c;
        }

        osw.write(c);
        osw.flush();
        pos.flush();

        return pis.read();
    }

        @Override
    public int read(byte[] b, int off, int len) throws IOException {
        if (len == 0) {
            return 0;
        }

        int c = read();

        if (c == -1) {
            return -1;
        }

        b[off] = (byte) c;

        int i = 1;

        // Don't try to fill up the buffer if the reader is waiting.
        for (; (i < len) && reader.ready(); i++) {
            c = read();

            if (c == -1) {
                return i;
            }

            b[off + i] = (byte) c;
        }

        return i;
    }

        @Override
    public int available() throws IOException {
        int i = pis.available();

        if (i > 0) {
            return i;
        }

        if (reader.ready()) {
            // Char must produce at least one byte.
            return 1;
        } else {
            return 0;
        }
    }

        @Override
    public void close() throws IOException {
        reader.close();
        osw.close();
        pis.close();
    }
}