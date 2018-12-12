package _06_ClientBot.Reader;

import java.nio.charset.StandardCharsets;

public class DataReaderBegin extends DataReader {
    public DataReaderBegin() {
        next = new TextReader();
    }

    @Override
    protected Object processContentRequest(byte[] type, byte[] data) {
        return null;
    }
}
