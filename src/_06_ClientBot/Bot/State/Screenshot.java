package _06_ClientBot.Bot.State;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class Screenshot extends State {

    OutputStream out;

    public Screenshot(OutputStream pW) {
        out = pW;
    }

    @Override
    public State doAction() {
        try {

            // making screenshot
            BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(image, "png", byteArrayOutputStream);

            byte[] size = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();
            out.write(size);
            out.write(byteArrayOutputStream.toByteArray());
//            out.flush();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return new Idle();
    }

//    private void send(byte[] message) {
//        try {
//            byte[] size = ByteBuffer.allocate(4).putInt(message.length).array();
//            out.write(size);
//            out.write(message);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
