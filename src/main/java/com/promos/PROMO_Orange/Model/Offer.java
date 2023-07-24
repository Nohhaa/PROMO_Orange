package com.promos.PROMO_Orange.Model;
import org.springframework.stereotype.Component;
@Component
public class Offer {
    private int Id;

    private int Value;

    private int Validity;

    private String Type;




    public int getValue() {
        return Value;
    }

    public void setValue(int value) {
        Value = value;
    }
    public int getValidity() {
        return Validity;
    }

    public void setValidity(int validity) {
        Validity = validity;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

}
