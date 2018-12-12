package _06_ClientBot.Reader;

import com.sun.corba.se.impl.orbutil.ObjectWriter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;

public class ImageReader extends DataReader {

    public ImageReader() {
        next = null;
    }

    @Override
    protected Object processContentRequest(byte[] type, byte[] data) {
        // if it is image
        if (type[0] == 2) {
            try {
                BufferedImage image = ImageIO.read(new ByteArrayInputStream(data));
//                ImageIO.write(image, "jpg", new File("C:\\Users\\Vulpelo\\Desktop\\ss.jpg"));
                return image;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
