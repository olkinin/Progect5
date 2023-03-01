package Hibernate;

import java.util.List;

public interface StudentDao {
    Student findById(Long id);

    List<Student> findAll();
    void addStudent(Student student);
    void deleteStudent(Long id);
 }
