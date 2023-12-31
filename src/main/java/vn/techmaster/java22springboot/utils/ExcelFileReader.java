package vn.techmaster.java22springboot.utils;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Component;
import vn.techmaster.java22springboot.model.Book;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ExcelFileReader implements IFileReader {

    @Override
    public List<Book> readFile(String fileName) {
        List<Book> bookList = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(fileName); Workbook workbook = WorkbookFactory.create(fis)) {

            if (isSheetExist(workbook, "data")) {
                Sheet sheet = workbook.getSheet("data");
                Row firstRow = sheet.getRow(0);
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    Row row = sheet.getRow(i);

                    String id = "";
                    String title = "";
                    String author = "";
                    int publishedYear = 0;

                    for (int j = 0; j < row.getLastCellNum(); j++) {
                        if (firstRow.getCell(j).toString().equals("id")) {
                            id = row.getCell(j).toString();
                        }

                        if (firstRow.getCell(j).toString().equals("title")) {
                            title = row.getCell(j).toString();
                        }

                        if (firstRow.getCell(j).toString().equals("author")) {
                            author = row.getCell(j).toString();
                        }

                        if (firstRow.getCell(j).toString().equals("year")) {
                            publishedYear = (int) Double.parseDouble(row.getCell(j).toString());
                        }
                    }

                    Book newBook = new Book(id, title, author, publishedYear);

                    bookList.add(newBook);
                }
            } else {
                System.out.println("Sheet is not found");
                return null;
            }

        } catch (IOException | EncryptedDocumentException e) {
            e.printStackTrace();
        }

        return bookList;
    }

    private static boolean isSheetExist(Workbook workbook, String sheetName) {
        int index = workbook.getSheetIndex(sheetName);
        return index != -1;
    }
}
