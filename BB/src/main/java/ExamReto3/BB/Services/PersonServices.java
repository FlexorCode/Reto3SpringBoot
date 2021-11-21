package ExamReto3.BB.Services;

import ExamReto3.BB.Entity.Person;
import ExamReto3.BB.Repository.PersonRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServices {
    
    @Autowired
    PersonRepository personRepository;
    
    public List<Person> list(){
        return personRepository.findAll();
    }
    
    public Optional<Person> findByFullname(String fullname){
        return personRepository.findByFullname(fullname);
    }
    
    public Person findById(Person person){
        return personRepository.findById(person.getId()).orElse(null);
    }
    
    public Person getById(int id){
        return personRepository.getById(id);
    }
    
    public void save(Person person){
        personRepository.save(person);
    }
    
    
    public void delete(Person person){
        personRepository.delete(person);
    }
    
    public boolean existsByFullname(String fullname){
        return personRepository.existsByFullname(fullname);
    }
    
    public boolean existsById(int id){
        return personRepository.existsById(id);
    }
    
}
