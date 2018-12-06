package _04_FileDirectory;

public class Check_Plik extends Plik {
    public Check_Plik(String name) {
        super(name);
    }

    @Override
    public void rename(String nName) {
        Validator val = new Validator(this);
        val.rename(nName);
    }
}
