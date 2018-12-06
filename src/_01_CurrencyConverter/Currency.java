package _01_CurrencyConverter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="pozycja")
public class Currency {

    private String code;
    private String name;
    private String conversionRate;
    private String course;

    public Currency(){}

    public Currency(String code, String name, String convesionRate, String course) {
        this.code = code;
        this.name = name;
        this.conversionRate = convesionRate;
        this.course = course;
    }

    @XmlElement(name="kod_waluty")
    public String getCode(){
        return code;
    }
    public void setCode(String ncode){
        code = ncode;
    }

    @XmlElement(name="nazwa_waluty")
    public String getName(){
        return name;
    }
    public void setName(String nname){
        name = nname;
    }

    @XmlElement(name="przelicznik")
    public String getConversionRate() {
        return conversionRate;
    }
    public void setConversionRate(String nConversionRate) {
        conversionRate = nConversionRate.replace(',','.');
    }

    @XmlElement(name="kurs_sredni")
    public String getCourse() {
        return course.replace(',','.');
    }
    public void setCourse(String nCourse) {
        course = nCourse;
    }

}

