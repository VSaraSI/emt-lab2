package emt.lab2.demo.model.exceptions;

public class CopiesCantBeNegative extends RuntimeException{

    public CopiesCantBeNegative() {
        super("Copies can't be negative");
    }

}
