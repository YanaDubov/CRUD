package crud.model;

import java.io.Serializable;

public class Number implements Serializable{

    private String number;

    public Number(String telephone) {
        this.number = telephone;
    }

    public String getNumber() {
        return number;
    }
}
