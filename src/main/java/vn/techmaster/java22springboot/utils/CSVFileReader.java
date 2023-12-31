package vn.techmaster.java22springboot.utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Component;
import vn.techmaster.java22springboot.model.Book;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CSVFileReader implements IFileReader {

    @Override
    public List<Book> readFile(String fileName) {
        CSVReader csvReader;
        List<Book> listBook = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(fileName);
            csvReader = new CSVReader(fileReader);

            if (csvReader.readNext() != null) {
                String[] line;

                while ((line = csvReader.readNext()) != null) {
                    String id = line[0];
                    String title = line[1];
                    String author = line[2];
                    int publishedYear = Integer.parseInt(line[3]);

                    Book newBook = new Book(id, title, author, publishedYear);
                    listBook.add(newBook);
                }
            } else {
                throw new RuntimeException("Empty CSV file");
            }

            csvReader.close();
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }

        return listBook;
    }
}
