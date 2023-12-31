package vn.techmaster.java22springboot.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import vn.techmaster.java22springboot.model.Book;
import vn.techmaster.java22springboot.utils.IFileReader;

import java.util.List;


@Configuration
public class InitDB implements CommandLineRunner {
    @Autowired
    private IFileReader fileReader;

    @Override
    public void run(String... args) {
        BookDB.bookList = loadDataFromCSV();

        for (Book book : BookDB.bookList) {
            System.out.println(book);
        }
    }

    public List<Book> loadDataFromJSON() {
        System.out.println("Read data from JSON file");
        return fileReader.readFile("book.json");
    }

    public List<Book> loadDataFromCSV() {
        System.out.println("Read data from CSV file");
        return fileReader.readFile("book.csv");
    }

    public List<Book> loadDataFromExcel() {
        System.out.println("Read data from Excel file");
        return fileReader.readFile("book.xlsx");
    }
}
