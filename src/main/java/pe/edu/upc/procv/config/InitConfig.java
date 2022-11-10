package pe.edu.upc.procv.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pe.edu.upc.procv.model.ServiceType;
import pe.edu.upc.procv.model.Student;
import pe.edu.upc.procv.model.Teacher;
import pe.edu.upc.procv.service.ServiceTypeService;
import pe.edu.upc.procv.service.StudentService;
import pe.edu.upc.procv.service.TeacherService;

@Component
public class InitConfig implements CommandLineRunner {

    @Autowired
    ServiceTypeService serviceTypeService;

    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;

    @Override
    public void run(String...args) throws Exception {
        createServiceTypeServices();
        createStudentServices();
        createTeacherServices();
    }

    private void createServiceTypeServices() {
        serviceTypeService.create(new ServiceType(0, "Mejora de CV"));
        serviceTypeService.create(new ServiceType(0, "Creación de CV"));
    }

    private void createStudentServices() {
        studentService.create(new Student(0, "Juan", "Torres", "75365895", "juantorres@gmail.com", "996523663"));
        studentService.create(new Student(0, "Karina", "Palacios", "75365263", "karinapalacios@gmail.com", "98552200"));
    }

    private void createTeacherServices() {
        teacherService.create(new Teacher(0, "Carlos", "Martínez", "77965211", "carlosmartinez@gmail.com", "925236285"));
        teacherService.create(new Teacher(0, "Laura", "Ramos", "74549602", "lauraramos@gmail.com", "963522599"));
    }
}
