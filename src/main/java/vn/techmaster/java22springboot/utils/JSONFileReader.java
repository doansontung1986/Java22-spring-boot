package vn.techmaster.java22springboot.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import vn.techmaster.java22springboot.model.Book;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Component
@Primary
public class JSONFileReader implements IFileReader {

    @Override
    public List<Book> readFile(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(filePath), new TypeReference<>() {
            });
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }
}
