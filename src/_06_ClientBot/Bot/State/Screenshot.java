package _06_ClientBot.Bot.State;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

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
            ImageIO.write(image, "jpg", byteArrayOutputStream);

            byte[] size = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();
            byte type = 2;
            out.write(size);
            out.write(type);
            out.write(byteArrayOutputStream.toByteArray());
//            TimeUnit.SECONDS.sleep(1);
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
