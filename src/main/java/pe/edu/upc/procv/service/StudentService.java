package pe.edu.upc.procv.service;

import pe.edu.upc.procv.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student findById(int idStudent);
    Student create(Student student);
    Student update(Student student);
    void deleteById(int idStudent);
    List <Student>  findbyName(String name);
}
