package com.vulpelo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="tabela_kursow")
public class CurrencyCollection {
    private List<Currency> currencies = new ArrayList<Currency>();

    CurrencyCollection() {}

    public void updateCurrencies() throws Exception {
        IFileReader fileReaderXML = new FileReaderXML();
        this.setCurrencies( fileReaderXML.getCurrencies().getListCurrencies() );

        Currency pln = new Currency("PLN","Polskich złotch", "1", "1");
        currencies.add(pln);
    }

    @XmlElements(@XmlElement(name = "pozycja"))
    public List<Currency> getListCurrencies(){
        return currencies;
    }
    public void setCurrencies(List<Currency> curs){
        currencies = curs;
    }


    public Currency getCurrencyByCode(String code)
    {
        for (Currency cur : currencies) {
            if(cur.getCode().equals(code))
                return cur;
        }
        return null;
    }
}
