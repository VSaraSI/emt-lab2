package emt.lab2.demo.repository;

import emt.lab2.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    void deleteByName(String name);

}
