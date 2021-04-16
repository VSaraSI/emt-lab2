package emt.lab2.demo.service.impl;

import emt.lab2.demo.model.Author;
import emt.lab2.demo.repository.AuthorRepository;
import emt.lab2.demo.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }
}
