package pe.edu.upc.procv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.procv.model.Advisory;

@Repository
public interface AdvisoryRepository extends JpaRepository<Advisory, Integer> {
}
