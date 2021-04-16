package emt.lab2.demo.service.impl;

import emt.lab2.demo.model.Author;
import emt.lab2.demo.model.Book;
import emt.lab2.demo.model.Category;
import emt.lab2.demo.model.dto.BookDto;
import emt.lab2.demo.model.exceptions.AuthorIsNotInDatabase;
import emt.lab2.demo.model.exceptions.BookNotFoundException;
import emt.lab2.demo.model.exceptions.CopiesCantBeNegative;
import emt.lab2.demo.repository.AuthorRepository;
import emt.lab2.demo.repository.BookRepository;
import emt.lab2.demo.service.BookService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
       return this.bookRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<Book> save(String name, String category, Long authorId, Integer copies) {

        Author author1 = this.authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorIsNotInDatabase());

        if(copies<0){
            throw new CopiesCantBeNegative();
        }

        Category category1=Category.valueOf(category);

        this.bookRepository.deleteByName(name);
        Book book = new Book(name, category1, author1, copies);
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {

        Author author1 = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorIsNotInDatabase());

        if(bookDto.getCopies()<0){
            throw new CopiesCantBeNegative();
        }

        Category category1=Category.valueOf(bookDto.getCategory());

        this.bookRepository.deleteByName(bookDto.getName());
        Book book = new Book(bookDto.getName(), category1, author1,bookDto.getCopies());
       this.bookRepository.save(book);
        return Optional.of(book);
    }


    @Override
    @Transactional
    public Optional<Book> edit(Long id, String name, String category, Long authorId, Integer copies) {

        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        book.setName(name);
        book.setCategory(Category.valueOf(category));

        Author author1 = this.authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorIsNotInDatabase());


        if(copies<0){
            throw new CopiesCantBeNegative();
        }

        book.setAvaliableCopies(copies);
        book.setAuthor(author1);

        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        book.setName(bookDto.getName());

        Category category=Category.valueOf(bookDto.getCategory());

        Author author=this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorIsNotInDatabase());

        book.setCategory(category);
        book.setAuthor(author);

        if(bookDto.getCopies()<0)
            throw new CopiesCantBeNegative();

        book.setAvaliableCopies(bookDto.getCopies());

        this.bookRepository.save(book);
        return Optional.of(book);
    }

    public void changeCopies(Long id){
            Book book=this.bookRepository.findById(id).get();
            Integer oldCopies=book.getAvaliableCopies();
            if(oldCopies==0)
                book.setAvaliableCopies(0);
            else
            book.setAvaliableCopies(oldCopies-1);

            this.bookRepository.save(book);
    }

}