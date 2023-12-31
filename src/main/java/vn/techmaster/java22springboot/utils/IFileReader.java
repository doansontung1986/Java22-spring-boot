package vn.techmaster.java22springboot.utils;

import vn.techmaster.java22springboot.model.Book;

import java.util.List;

public interface IFileReader {
    List<Book> readFile(String fileName);
}
