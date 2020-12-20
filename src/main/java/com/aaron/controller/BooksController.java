package com.aaron.controller;

import com.aaron.pojo.Books;
import com.aaron.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author Aaron
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/5
 */
@Controller
public class BooksController {

    @Autowired
    private BooksService booksService;

    @RequestMapping("/books/queryAll")
    public String queryAllBooks(Model model) {
        List<Books> bookList = booksService.queryBooksList();
        model.addAttribute("bookList", bookList);
        return "allBooks";
    }

    @RequestMapping("/books/toAddPages")
    public String toAddPages() {
        return "addBooks";
    }

    @RequestMapping("/books/addBooks")
    public String addBooks(Books books) {
        booksService.addBooks(books);
        return "redirect:/books/queryAll";
    }

    @GetMapping("/books/toUpdatePage/{id}")
    public String toUpdatePage(@PathVariable("id") Integer id, Model model) {
        Books books = booksService.queryBooksById(id);
        model.addAttribute("bInfo", books);
        return "updateBooks";
    }

    @RequestMapping("/books/updateBooks")
    public String updateBooks(Books books) {
        booksService.updateBooks(books);
        return "redirect:/books/queryAll";
    }



    @GetMapping("/books/deleteBooks/{id}")
    public String deleteBooks(@PathVariable("id") Integer id, Model model) {
        booksService.deleteBooks(id);
        return "redirect:/books/queryAll";
    }

    @PostMapping("/books/queryBookByName")
    public String queryBookByName(@RequestParam("bkName") String bookName, Model model) {
        Books books = booksService.queryBooksByName(bookName);
        if(books == null) {
            model.addAttribute("errMsg", "未查询到结果");
            return "allBooks";
        }
        List<Books> booksList = new ArrayList<>();
        booksList.add(books);
        model.addAttribute("bookList", booksList);
        return "allBooks";
    }
}
