package pe.edu.upc.procv.service;

import pe.edu.upc.procv.model.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> findAll();
    Teacher findById(int idTeacher);
    Teacher create(Teacher teacher);
    Teacher update(Teacher teacher);
    void deleteById(int idTeacher);
}
