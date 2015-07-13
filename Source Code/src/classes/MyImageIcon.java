/**
 * Author: Mohammad Mofeed AlBanna.
 * Web Developer
 * Website: www.MBanna.info
 * Blog: www.OutOfPalBox.net
 * Facebook: www.FB.com/MBanna.info
 */


package classes;

import java.awt.Image;
import java.awt.IllegalComponentStateException;
import java.awt.Component;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.awt.image.ColorModel;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.beans.ConstructorProperties;
import java.beans.Transient;
import java.net.URL;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Locale;
import javax.accessibility.Accessible;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleIcon;
import javax.accessibility.AccessibleRole;
import javax.accessibility.AccessibleStateSet;
import sun.awt.AppContext;
import java.lang.reflect.Field;
import java.security.PrivilegedAction;
import java.security.AccessController;
import javax.swing.Icon;


public class MyImageIcon implements Icon, Serializable, Accessible {
private static final long serialVersionUID = 1L;// set SerialVersion for Image Icon
  
    transient private String filename;
    transient private URL location;

    transient Image image;
    transient int loadStatus = 0;
    ImageObserver imageObserver;
    String description = null;

    protected final static Component component;
    protected final static MediaTracker tracker;

    static {
        component = new Component() {};
        AccessController.doPrivileged(new PrivilegedAction<Object>() {
            public Object run() {
                try {
                    // 6482575 - clear the appContext field so as not to leak it
                    Field appContextField =
                                 Component.class.getDeclaredField("appContext");
                    appContextField.setAccessible(true);
                    appContextField.set(component, null);
                }
                catch (NoSuchFieldException e) {
                   return null;
                }
                catch (IllegalAccessException e) {
                    return null;
                }
                return null;
            }
        });
        tracker = new MediaTracker(component);
    }


    private static int mediaTrackerID;

    private final static Object TRACKER_KEY = new StringBuilder("TRACKER_KEY");

    int width = -1;
    int height = -1;


    public MyImageIcon(String filename, String description) {
        image = Toolkit.getDefaultToolkit().getImage(filename);
        if (image == null) {
            return;
        }
        this.filename = filename;
        this.description = description;
        loadImage(image);
    }


    @ConstructorProperties({"description"})
    public MyImageIcon (String filename) {
        this(filename, filename);
    }

    public MyImageIcon(URL location, String description) {
        image = Toolkit.getDefaultToolkit().getImage(location);
        if (image == null) {
            return;
        }
        this.location = location;
        this.description = description;
        loadImage(image);
    }


    public MyImageIcon (URL location) {
        this(location, location.toExternalForm());
    }


    public MyImageIcon(Image image, String description) {
        this(image);
        this.description = description;
    }


    public MyImageIcon (Image image) {
        this.image = image;
        Object o = image.getProperty("comment", imageObserver);
        if (o instanceof String) {
            description = (String) o;
        }
        loadImage(image);
    }


    public MyImageIcon (byte[] imageData, String description) {
        this.image = Toolkit.getDefaultToolkit().createImage(imageData);
        if (image == null) {
            return;
        }
        this.description = description;
        loadImage(image);
    }


    public MyImageIcon (byte[] imageData) {
        this.image = Toolkit.getDefaultToolkit().createImage(imageData);
        if (image == null) {
            return;
        }
        Object o = image.getProperty("comment", imageObserver);
        if (o instanceof String) {
            description = (String) o;
        }
        loadImage(image);
    }

    /**
     * Creates an uninitialized image icon.
     */
    public MyImageIcon() {
    }

    protected void loadImage(Image image) {
        MediaTracker mTracker = getTracker();
        synchronized(mTracker) {
            int id = getNextID();

            mTracker.addImage(image, id);
            try {
                mTracker.waitForID(id, 0);
            } catch (InterruptedException e) {
                System.out.println("INTERRUPTED while loading Image");
            }
            loadStatus = mTracker.statusID(id, false);
            mTracker.removeImage(image, id);

            width = image.getWidth(imageObserver);
            height = image.getHeight(imageObserver);
        }
    }


    private int getNextID() {
        synchronized(getTracker()) {
            return ++mediaTrackerID;
        }
    }


    private MediaTracker getTracker() {
        Object trackerObj;
        AppContext ac = AppContext.getAppContext();
        // Opt: Only synchronize if trackerObj comes back null?
        // If null, synchronize, re-check for null, and put new tracker
        synchronized(ac) {
            trackerObj = ac.get(TRACKER_KEY);
            if (trackerObj == null) {
                Component comp = new Component() {};
                trackerObj = new MediaTracker(comp);
                ac.put(TRACKER_KEY, trackerObj);
            }
        }
        return (MediaTracker) trackerObj;
    }


    public int getImageLoadStatus() {
        return loadStatus;
    }


    @Transient
    public Image getImage() {
        return image;
    }

    /**
     * Sets the image displayed by this icon.
     * @param image the image
     */
    public void setImage(Image image) {
        this.image = image;
        loadImage(image);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public synchronized void paintIcon(Component c, Graphics g, int x, int y) {
        if(imageObserver == null) {
           g.drawImage(image, x, y, c);
        } else {
           g.drawImage(image, x, y, imageObserver);
        }
    }


    public int getIconWidth() {
        return width;
    }

    public int getIconHeight() {
        return height;
    }


    public void setImageObserver(ImageObserver observer) {
        imageObserver = observer;
    }


    @Transient
    public ImageObserver getImageObserver() {
        return imageObserver;
    }


    public String toString() {
        if (description != null) {
            return description;
        }
        return super.toString();
    }

    private void readObject(ObjectInputStream s)
        throws ClassNotFoundException, IOException
    {
        s.defaultReadObject();

        int w = s.readInt();
        int h = s.readInt();
        int[] pixels = (int[])(s.readObject());

        if (pixels != null) {
            Toolkit tk = Toolkit.getDefaultToolkit();
            ColorModel cm = ColorModel.getRGBdefault();
            image = tk.createImage(new MemoryImageSource(w, h, cm, pixels, 0, w));
            loadImage(image);
        }
    }


    private void writeObject(ObjectOutputStream s)
        throws IOException
    {
        s.defaultWriteObject();

        int w = getIconWidth();
        int h = getIconHeight();
        int[] pixels = image != null? new int[w * h] : null;

        if (image != null) {
            try {
                PixelGrabber pg = new PixelGrabber(image, 0, 0, w, h, pixels, 0, w);
                pg.grabPixels();
                if ((pg.getStatus() & ImageObserver.ABORT) != 0) {
                    throw new IOException("failed to load image contents");
                }
            }
            catch (InterruptedException e) {
                throw new IOException("image load interrupted");
            }
        }

        s.writeInt(w);
        s.writeInt(h);
        s.writeObject(pixels);
    }

    /**
     * --- Accessibility Support ---
     */

    private AccessibleImageIcon accessibleContext = null;


    public AccessibleContext getAccessibleContext() {
        if (accessibleContext == null) {
            accessibleContext = new AccessibleImageIcon();
        }
        return accessibleContext;
    }


    protected class AccessibleImageIcon extends AccessibleContext
        implements AccessibleIcon, Serializable {

        public AccessibleRole getAccessibleRole() {
            return AccessibleRole.ICON;
        }

        public AccessibleStateSet getAccessibleStateSet() {
            return null;
        }

        public Accessible getAccessibleParent() {
            return null;
        }

        public int getAccessibleIndexInParent() {
            return -1;
        }


        public int getAccessibleChildrenCount() {
            return 0;
        }

        public Accessible getAccessibleChild(int i) {
            return null;
        }

        public Locale getLocale() throws IllegalComponentStateException {
            return null;
        }

        public String getAccessibleIconDescription() {
            return MyImageIcon.this.getDescription();
        }


        public void setAccessibleIconDescription(String description) {
            MyImageIcon.this.setDescription(description);
        }

        public int getAccessibleIconHeight() {
            return MyImageIcon.this.height;
        }

        public int getAccessibleIconWidth() {
            return MyImageIcon.this.width;
        }

        private void readObject(ObjectInputStream s)
            throws ClassNotFoundException, IOException
        {
            s.defaultReadObject();
        }

        private void writeObject(ObjectOutputStream s)
            throws IOException
        {
            s.defaultWriteObject();
        }
    }  // AccessibleImageIcon
}
