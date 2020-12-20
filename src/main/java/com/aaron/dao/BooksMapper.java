package com.aaron.dao;

import com.aaron.pojo.Books;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author Aaron
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/5
 */
@Mapper
public interface BooksMapper {

    int addBooks(Books books);

    int deleteBooks(@Param("bookId") Integer id);

    int updateBooks(Books books);

    Books queryBooksById(@Param("bookId") Integer id);

    List<Books> queryBooksList();

    Books queryBooksByName(@Param("bookName") String bookName);
}
