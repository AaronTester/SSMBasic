package com.aaron.service.impl;

import com.aaron.dao.BooksMapper;
import com.aaron.pojo.Books;
import com.aaron.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author Aaron
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/5
 */
@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    private BooksMapper booksMapper;

    @Override
    public int addBooks(Books books) {
        return booksMapper.addBooks(books);
    }

    @Override
    public int deleteBooks(Integer id) {
        return booksMapper.deleteBooks(id);
    }

    @Override
    public int updateBooks(Books books) {
        return booksMapper.updateBooks(books);
    }

    @Override
    public Books queryBooksById(Integer id) {
        return booksMapper.queryBooksById(id);
    }

    @Override
    public List<Books> queryBooksList() {
        return booksMapper.queryBooksList();
    }

    @Override
    public Books queryBooksByName(String bookName) {
        return booksMapper.queryBooksByName(bookName);
    }
}
