package com.vulpelo;

import javax.xml.bind.ValidationException;

public class ConsolControler extends Controler {

    ConsolControler(View nView) {
        view = nView;
    }

    @Override
    public void validate() throws ValidationException {
        boolean valid = false;
        for (Currency curr:
                view.getCurrCalc().getCurrencyCollection().getListCurrencies()) {
            if(fCode.equals(curr.getCode())){
                valid = true;
                break;
            }
        }

        if(!valid) throw new ValidationException("Such currency isn't supported");

        valid = false;
        for (Currency curr:
                view.getCurrCalc().getCurrencyCollection().getListCurrencies()) {
            if(tCode.equals(curr.getCode())){
                valid = true;
                break;
            }
        }

        if(!valid)
            throw new ValidationException("Such currency isn't supported");

        if(this.amount <= 0){
            throw new ValidationException("Money amount should be bigger than 0");
        }
    }

}
