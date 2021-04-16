package emt.lab2.demo.model.exceptions;

import org.springframework.stereotype.Component;

@Component
public class AuthorIsNotInDatabase extends RuntimeException{

    public AuthorIsNotInDatabase() {
        super(String.format("Author is not found"));
    }
}
