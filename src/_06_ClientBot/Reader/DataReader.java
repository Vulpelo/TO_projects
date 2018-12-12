package _06_ClientBot.Reader;

public abstract class DataReader {
    protected DataReader next;

    public DataReader() {
        next = null;
    }

    protected void setNext(DataReader next) {
        this.next = next;
    }

    public Object processContent(byte[] type, byte[] data) {
        Object tmp =  processContentRequest(type, data);
        if (tmp != null) {
            return tmp;
        }
        else if (next != null) {
            return next.processContent(type, data);
        }
        return null;
    }

    protected Object processContentRequest(byte[] type, byte[] data) {
        return null;
    }
}
