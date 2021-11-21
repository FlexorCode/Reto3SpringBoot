package ExamReto3.BB.Repository;

import ExamReto3.BB.Entity.Person;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer>{
    
    Optional<Person> findByFullname(String fullname);
    
    boolean existsByFullname(String fullname);
}
