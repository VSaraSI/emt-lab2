package emt.lab2.demo.service;

import emt.lab2.demo.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AuthorService {

    List<Author> findAll();

}
