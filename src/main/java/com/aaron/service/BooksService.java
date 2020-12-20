package com.aaron.service;

import com.aaron.pojo.Books;

import java.util.List;

/**
 * @Description
 * @Author Aaron
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/5
 */
public interface BooksService {

    int addBooks(Books books);

    int deleteBooks(Integer id);

    int updateBooks(Books books);

    Books queryBooksById(Integer id);

    List<Books> queryBooksList();

    Books queryBooksByName(String bookName);
}
