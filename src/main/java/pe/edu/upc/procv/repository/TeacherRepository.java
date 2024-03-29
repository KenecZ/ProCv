package pe.edu.upc.procv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.procv.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
