package _01_CurrencyConverter;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;


public class FileReaderXML implements IFileReader {

    private String filePath = "./currencyData.xml";
    private String urlPath = "http://www.nbp.pl/kursy/xml/LastA.xml";
    ServerConnection server = new ServerConnection();


    private void getFilesFromServer(){
        File a = new File(filePath);

        if(a.exists())
        {
            try {
                System.out.println("Updating files...");
                server.getCurrencyCollectionData(urlPath, filePath);
                System.out.println("Files updated.");
            } catch (Exception e) {
                System.out.println("Files couldn't be updated.");
                System.out.println(e.toString());
            }
        }
        else{
            try {
                System.out.println("Downloading files...");
                server.getCurrencyCollectionData(urlPath, filePath);
                System.out.println("Files downloaded.");
            } catch (Exception e) {
                System.out.println("Files couldn't be downloaded.");
                System.out.println(e.toString());
                System.exit(1);
            }
        }
    }

    public CurrencyCollection getCurrencies() throws Exception {

        getFilesFromServer();

        JAXBContext jaxbContext = JAXBContext.newInstance(CurrencyCollection.class);
        Unmarshaller jaxbunmarshaller = jaxbContext.createUnmarshaller();

        CurrencyCollection curr = (CurrencyCollection) jaxbunmarshaller.unmarshal(new File(filePath));

        return curr;
    }

}
