package emt.lab2.demo.web.controller;

import emt.lab2.demo.model.Book;
import emt.lab2.demo.model.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoriesController {

    @GetMapping
    public String getCategoryPage(Model model) {
        List<Category> categories= Arrays.asList(Category.values().clone());
        model.addAttribute("categories", categories);
        model.addAttribute("bodyContent", "categories");
        return "master-template";
    }

}
