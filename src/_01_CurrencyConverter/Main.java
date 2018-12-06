package _01_CurrencyConverter;

public class Main {

    public static void main(String[] args) throws Exception {
        View converter = new View();
        Controler controler = new ConsolControler(converter);
        controler.start();

    }
}
