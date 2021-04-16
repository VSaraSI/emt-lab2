package emt.lab2.demo.model.dto;

import lombok.Data;

@Data
public class BookDto {

    private String name;

    private String category;

    private Long author;
    
    private Integer copies;

    public BookDto() {
    }

    public BookDto(String name,String category,Long author,Integer copies) {
        this.name=name;
        this.category = category;
        this.author=author;
        this.copies=copies;
    }


}
