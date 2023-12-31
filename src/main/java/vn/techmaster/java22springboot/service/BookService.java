package vn.techmaster.java22springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.java22springboot.dao.BookDao;
import vn.techmaster.java22springboot.model.Book;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }

    public Book getBookById(String id) {
        return bookDao.findById(id);
    }
}
