package pe.edu.upc.procv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.procv.model.Student;
import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
   @Query("SELECT dni FROM students s WHERE s.name LIKE %?1%")
    List<Product> findByNameLike(String name);
}
