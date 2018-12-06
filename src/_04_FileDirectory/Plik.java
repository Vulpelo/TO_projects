public class Plik extends Node {

    private String content = "";

    public Plik(String name) {
        this.setName(name);
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}
