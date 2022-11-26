package pe.edu.upc.procv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.procv.model.Teacher;
import pe.edu.upc.procv.repository.TeacherRepository;
import pe.edu.upc.procv.service.TeacherService;
import pe.edu.upc.procv.service.impl.TeacherServiceImpl;

import javax.servlet.http.HttpServletResponse;
import pe.edu.upc.procv.util.teacherexcel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;  



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public ResponseEntity<?> listAll() {
        try {
            List<Teacher> teachers = teacherService.findAll();
            return ResponseEntity.ok(teachers);
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }

    @GetMapping("/{idTeacher}")
    public ResponseEntity<?> listById(@PathVariable int idTeacher) {
        try {
            Teacher teacher = teacherService.findById(idTeacher);
            return ResponseEntity.ok(teacher);
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Teacher teacher) {
        try {
        Teacher teacherSave = teacherService.create(teacher);
        return ResponseEntity.ok(teacherSave);
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }

    @PutMapping("/{idTeacher}")
    public ResponseEntity<?> update(@PathVariable int idTeacher, @RequestBody Teacher teacher) {
        try {
            teacher.setIdTeacher(idTeacher);
            Teacher teacherSave = teacherService.update(teacher);
            return ResponseEntity.ok(teacherSave);
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }

    @DeleteMapping("/{idTeacher}")
    public ResponseEntity<?> deleteById(@PathVariable int idTeacher) {
        try {
        teacherService.deleteById(idTeacher);
        return ResponseEntity.ok(null);
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }
    @GetMapping("/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {

        response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=result_advisory";
        response.setHeader(headerKey, headerValue);

        List<Teacher> teachers = teacherService.findAll();

        teacherexcel excelExporter = new teacherexcel(teachers);

        excelExporter.export(response);


    }
}
