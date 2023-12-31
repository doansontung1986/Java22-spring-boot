package vn.techmaster.java22springboot.dao;

import org.springframework.stereotype.Repository;
import vn.techmaster.java22springboot.database.BookDB;
import vn.techmaster.java22springboot.model.Book;

import java.util.List;

@Repository
public class BookDao {

    public List<Book> findAll() {
        return BookDB.bookList;
    }

    public Book findById(String id) {
        for (Book book : BookDB.bookList) {
            if (book.getId().equals(id)) {
                return book;
            }
        }

        return null;
    }
}
