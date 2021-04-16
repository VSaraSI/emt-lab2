package emt.lab2.demo.web.rest;

import emt.lab2.demo.model.Author;
import emt.lab2.demo.model.Book;
import emt.lab2.demo.service.AuthorService;
import emt.lab2.demo.service.BookService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/authors")
public class AuthorRestController {

    private final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    private List<Author> findAll() {
        return this.authorService.findAll();
    }
}
