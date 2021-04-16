package emt.lab2.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(value=EnumType.STRING)
    private Category category;

    @ManyToOne
    private Author author;

    private Integer avaliableCopies;

    public Book(){}

    public Book(String name,Category category,Author author,Integer copies){
        this.name=name;
        this.category=category;
        this.author=author;
        this.avaliableCopies=copies;
    }
}
