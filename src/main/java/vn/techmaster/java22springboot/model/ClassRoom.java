package vn.techmaster.java22springboot.model;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ToString
public class ClassRoom {
    @Autowired
    private Teacher teacher;
    @Autowired
    private Student student;

    public ClassRoom() {
        System.out.println("Class room constructor");
    }
}
