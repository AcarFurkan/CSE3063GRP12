package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import core.models.concretes.Student;

public class StudentTest {

    @Test
    public void testStudentCreation() {
        Student student = new Student();
        assertNotNull("Student object should not be null", student);
    }

    @Test
    public void testEmptyConstructor() {
        Student student = new Student();
        assertNotNull("Student object should not be null when created with empty constructor", student);
    }

    @Test
    public void testParameterizedConstructor() {
        Student student = new Student("1", "Furkan", "Acar", "o150121534", "password", null, new ArrayList<>(), null);
        assertNotNull("Student object should not be null when created with parameters", student);
        assertEquals("Furkan", student.getFirstName());
        assertEquals("Acar", student.getLastName());
    }

    // Diğer test metodları buraya eklenebilir
}
