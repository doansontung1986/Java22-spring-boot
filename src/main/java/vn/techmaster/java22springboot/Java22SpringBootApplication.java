package vn.techmaster.java22springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import vn.techmaster.java22springboot.model.ClassRoom;
import vn.techmaster.java22springboot.model.Student;
import vn.techmaster.java22springboot.model.Teacher;

@SpringBootApplication
public class Java22SpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(Java22SpringBootApplication.class, args);
    }

    @Bean
    public Student getStudent() {
        return new Student(1, "Tung");
    }

}
