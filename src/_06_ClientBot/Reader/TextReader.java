package _06_ClientBot.Reader;

import java.nio.charset.StandardCharsets;

public class TextReader extends DataReader {

    public TextReader() {
        next = new ImageReader();
    }

    @Override
    protected Object processContentRequest(byte[] type, byte[] data) {
        // if it is text
        if (type[0] == 1) {
            String inputLine = new String(data, StandardCharsets.UTF_8);
            return inputLine;
        }
        else {
            return null;
        }
    }
}
