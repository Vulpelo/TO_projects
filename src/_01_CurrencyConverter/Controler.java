package _01_CurrencyConverter;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

import javax.xml.bind.ValidationException;
import java.util.Scanner;

public abstract class Controler {

    View view;
    String fCode;
    String tCode;
    float amount;

    public Controler(){

    }

    public Controler(View nView)
    {
        view = nView;
    }

    void start(){
        Scanner scanner = new Scanner(System.in);

        while(true) {
            try {
                System.out.println("Code currency, from:");
                fCode = scanner.next();

                System.out.println("Code currency, to:");
                tCode = scanner.next();

                System.out.println("Amount:");
                amount = scanner.nextFloat();

                validate();

                view.calculateValue(fCode, tCode, amount);
            }
            catch (ValidationException e){
                System.out.println(e.toString());
            }
            catch (ValueException e) {
                System.out.println("Wrong data entered.");
            }
            catch (Exception e) {
                System.out.println(e.toString());
            }
            finally {
                System.out.println("Exit? y/n");
                String c = scanner.next();
                if(c.equals("y")){
                    break;
                }
            }
        }

    }


    public void validate() throws ValidationException {};
}
