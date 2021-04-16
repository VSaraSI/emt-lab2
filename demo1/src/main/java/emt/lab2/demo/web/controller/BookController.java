package emt.lab2.demo.web.controller;

import emt.lab2.demo.model.Author;
import emt.lab2.demo.model.Book;
import emt.lab2.demo.model.Category;
import emt.lab2.demo.service.AuthorService;
import emt.lab2.demo.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value={"/" , "/books"})
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public String getBookPage(Model model) {
        List<Book> books = this.bookService.findAll();
        model.addAttribute("books", books);
        model.addAttribute("bodyContent", "books");
        return "master-template";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        this.bookService.deleteById(id);
        return "redirect:/books";
    }

    @PostMapping("/mark/{id}")
    public String markBookById(@PathVariable Long id) {
        this.bookService.changeCopies(id);

        return "redirect:/books";
    }

    @GetMapping("/edit-form/{id}")
    public String editBookPage(@PathVariable Long id, Model model) {
        if (this.bookService.findById(id).isPresent()) {
            Book book = this.bookService.findById(id).get();
            List<Category> categories= Arrays.asList(Category.values().clone());
            List<Author> authors=this.authorService.findAll();
            model.addAttribute("authors",authors);
            model.addAttribute("categories", categories);
            model.addAttribute("book", book);
            model.addAttribute("bodyContent", "add-book");
            return "master-template";
        }
        return "redirect:/books?error=BookNotFound";
    }


    @GetMapping("/add-form")
    public String addBookPage(Model model) {
        List<Category> categories= Arrays.asList(Category.values().clone());
        List<Author> authors=this.authorService.findAll();
        model.addAttribute("authors",authors);
        model.addAttribute("categories", categories);
        model.addAttribute("bodyContent", "add-book");
        return "master-template";
    }



    @PostMapping("/add")
    public String saveBook(
            @RequestParam(required = false) Long id,
            @RequestParam String name,
            @RequestParam String category,
            @RequestParam Long author,
            @RequestParam Integer copies) {
        if (id != null) {
            this.bookService.edit(id, name, category,author,copies);
        } else {
            this.bookService.save( name, category,author,copies);
        }
        return "redirect:/books";
    }





}
