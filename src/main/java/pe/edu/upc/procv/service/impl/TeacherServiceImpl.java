package pe.edu.upc.procv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.procv.model.Teacher;
import pe.edu.upc.procv.repository.TeacherRepository;
import pe.edu.upc.procv.service.TeacherService;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findById(int idTeacher) {
        return teacherRepository.findById(idTeacher).get();
    }

    @Override
    public Teacher create(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher update(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteById(int idTeacher) {
        teacherRepository.deleteById(idTeacher);
    }
}
